package com.qiniu.android.storage;

import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.HttpManager;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ResumeUploader
  implements Runnable
{
  private final byte[] chunkBuffer;
  private final UpCompletionHandler completionHandler;
  private final String[] contexts;
  private long crc32;
  private File f;
  private RandomAccessFile file;
  private final Header[] headers;
  private final HttpManager httpManager;
  private final String key;
  private final long modifyTime;
  private final UploadOptions options;
  private final Recorder recorder;
  private final String recorderKey;
  private final int size;
  
  ResumeUploader(HttpManager paramHttpManager, Recorder paramRecorder, File paramFile, String paramString1, String paramString2, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions, String paramString3)
  {
    this.httpManager = paramHttpManager;
    this.recorder = paramRecorder;
    this.f = paramFile;
    this.recorderKey = paramString3;
    this.size = ((int)paramFile.length());
    this.key = paramString1;
    this.headers = new Header[1];
    this.headers[0] = new BasicHeader("Authorization", "UpToken " + paramString2);
    this.completionHandler = paramUpCompletionHandler;
    if (paramUploadOptions != null) {}
    for (;;)
    {
      this.options = paramUploadOptions;
      this.chunkBuffer = new byte[262144];
      this.contexts = new String[(int)((-1 + (4194304 + this.size)) / 4194304)];
      this.modifyTime = this.f.lastModified();
      return;
      paramUploadOptions = UploadOptions.defaultOptions();
    }
  }
  
  private int calcBlockSize(int paramInt)
  {
    int i = this.size - paramInt;
    if (i < 4194304) {
      return i;
    }
    return 4194304;
  }
  
  private int calcPutSize(int paramInt)
  {
    int i = this.size - paramInt;
    if (i < 262144) {
      return i;
    }
    return 262144;
  }
  
  private boolean isCancelled()
  {
    return this.options.cancellationSignal.isCancelled();
  }
  
  private void makeBlock(String paramString, int paramInt1, int paramInt2, int paramInt3, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler)
  {
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    String str = String.format(localLocale, "http://%s/mkblk/%d", arrayOfObject);
    try
    {
      this.file.seek(paramInt1);
      this.file.read(this.chunkBuffer, 0, paramInt3);
      this.crc32 = Crc32.bytes(this.chunkBuffer, 0, paramInt3);
      post(str, this.chunkBuffer, 0, paramInt3, paramProgressHandler, paramCompletionHandler);
      return;
    }
    catch (IOException localIOException)
    {
      this.completionHandler.complete(this.key, ResponseInfo.fileError(localIOException), null);
    }
  }
  
  private void makeFile(String paramString, CompletionHandler paramCompletionHandler)
  {
    Locale localLocale1 = Locale.ENGLISH;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = UrlSafeBase64.encodeToString(this.options.mimeType);
    String str1 = String.format(localLocale1, "/mimeType/%s", arrayOfObject1);
    Object[] arrayOfObject4;
    if (this.key != null)
    {
      arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = UrlSafeBase64.encodeToString(this.key);
    }
    for (String str2 = String.format("/key/%s", arrayOfObject4);; str2 = "")
    {
      String str3 = "";
      if (this.options.params.size() != 0)
      {
        String[] arrayOfString = new String[this.options.params.size()];
        Iterator localIterator = this.options.params.entrySet().iterator();
        int j;
        for (int i = 0; localIterator.hasNext(); i = j)
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          j = i + 1;
          Locale localLocale3 = Locale.ENGLISH;
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = localEntry.getKey();
          arrayOfObject3[1] = UrlSafeBase64.encodeToString((String)localEntry.getValue());
          arrayOfString[i] = String.format(localLocale3, "%s/%s", arrayOfObject3);
        }
        str3 = "/" + StringUtils.join(arrayOfString, "/");
      }
      Locale localLocale2 = Locale.ENGLISH;
      Object[] arrayOfObject2 = new Object[5];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(this.size);
      arrayOfObject2[2] = str1;
      arrayOfObject2[3] = str2;
      arrayOfObject2[4] = str3;
      String str4 = String.format(localLocale2, "http://%s/mkfile/%d%s%s%s", arrayOfObject2);
      byte[] arrayOfByte = StringUtils.join(this.contexts, ",").getBytes();
      post(str4, arrayOfByte, 0, arrayOfByte.length, null, paramCompletionHandler);
      return;
    }
  }
  
  private void nextTask(int paramInt1, int paramInt2, String paramString)
  {
    if (isCancelled())
    {
      this.completionHandler.complete(this.key, ResponseInfo.cancelled(), null);
      return;
    }
    if (paramInt1 == this.size)
    {
      makeFile(paramString, new ResumeUploader.1(this, paramInt2, paramInt1, paramString));
      return;
    }
    int i = calcPutSize(paramInt1);
    ResumeUploader.2 local2 = new ResumeUploader.2(this, paramInt1);
    ResumeUploader.3 local3 = new ResumeUploader.3(this, paramInt1, paramInt2, paramString, i);
    if (paramInt1 % 4194304 == 0)
    {
      makeBlock(paramString, paramInt1, calcBlockSize(paramInt1), i, local2, local3);
      return;
    }
    putChunk(paramString, paramInt1, i, this.contexts[(paramInt1 / 4194304)], local2, local3);
  }
  
  private void post(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler)
  {
    this.httpManager.postData(paramString, paramArrayOfByte, paramInt1, paramInt2, this.headers, paramProgressHandler, paramCompletionHandler);
  }
  
  private void putChunk(String paramString1, int paramInt1, int paramInt2, String paramString2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler)
  {
    int i = paramInt1 % 4194304;
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = Integer.valueOf(i);
    String str = String.format(localLocale, "http://%s/bput/%s/%d", arrayOfObject);
    try
    {
      this.file.seek(paramInt1);
      this.file.read(this.chunkBuffer, 0, paramInt2);
      this.crc32 = Crc32.bytes(this.chunkBuffer, 0, paramInt2);
      post(str, this.chunkBuffer, 0, paramInt2, paramProgressHandler, paramCompletionHandler);
      return;
    }
    catch (IOException localIOException)
    {
      this.completionHandler.complete(this.key, ResponseInfo.fileError(localIOException), null);
    }
  }
  
  private void record(int paramInt)
  {
    if ((this.recorder == null) || (paramInt == 0)) {
      return;
    }
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.size);
    arrayOfObject[1] = Integer.valueOf(paramInt);
    arrayOfObject[2] = Long.valueOf(this.modifyTime);
    arrayOfObject[3] = StringUtils.jsonJoin(this.contexts);
    String str = String.format(localLocale, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", arrayOfObject);
    this.recorder.set(this.recorderKey, str.getBytes());
  }
  
  private int recoveryFromRecord()
  {
    if (this.recorder == null) {}
    for (;;)
    {
      return 0;
      byte[] arrayOfByte = this.recorder.get(this.recorderKey);
      if (arrayOfByte == null) {
        continue;
      }
      String str = new String(arrayOfByte);
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        int i = localJSONObject.optInt("offset", 0);
        long l = localJSONObject.optLong("modify_time", 0L);
        int j = localJSONObject.optInt("size", 0);
        JSONArray localJSONArray = localJSONObject.optJSONArray("contexts");
        if ((i == 0) || (l != this.modifyTime) || (j != this.size) || (localJSONArray == null)) {
          continue;
        }
        int k = localJSONArray.length();
        int m = 0;
        if (k == 0) {
          continue;
        }
        while (m < localJSONArray.length())
        {
          this.contexts[m] = localJSONArray.optString(m);
          m++;
        }
        return i;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return 0;
      }
    }
  }
  
  private void removeRecord()
  {
    if (this.recorder != null) {
      this.recorder.del(this.recorderKey);
    }
  }
  
  public void run()
  {
    int i = recoveryFromRecord();
    try
    {
      this.file = new RandomAccessFile(this.f, "r");
      nextTask(i, 0, "upload.qiniu.com");
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
        this.completionHandler.complete(this.key, ResponseInfo.fileError(localFileNotFoundException), null);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.ResumeUploader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */