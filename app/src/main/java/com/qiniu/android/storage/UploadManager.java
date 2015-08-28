package com.qiniu.android.storage;

import com.qiniu.android.http.HttpManager;
import com.qiniu.android.http.Proxy;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AsyncRun;
import java.io.File;

public final class UploadManager
{
  private final HttpManager httpManager;
  private final KeyGenerator keyGen;
  private final Recorder recorder;
  
  public UploadManager()
  {
    this(null, null, null);
  }
  
  public UploadManager(Recorder paramRecorder)
  {
    this(paramRecorder, null, null);
  }
  
  public UploadManager(Recorder paramRecorder, KeyGenerator paramKeyGenerator)
  {
    this(paramRecorder, paramKeyGenerator, null);
  }
  
  public UploadManager(Recorder paramRecorder, KeyGenerator paramKeyGenerator, Proxy paramProxy)
  {
    this.recorder = paramRecorder;
    this.httpManager = new HttpManager(paramProxy);
    this.keyGen = paramKeyGenerator;
  }
  
  private static boolean areInvalidArg(String paramString1, byte[] paramArrayOfByte, File paramFile, String paramString2, UpCompletionHandler paramUpCompletionHandler)
  {
    if (paramUpCompletionHandler == null) {
      throw new IllegalArgumentException("no UpCompletionHandler");
    }
    String str;
    if ((paramFile == null) && (paramArrayOfByte == null)) {
      str = "no input data";
    }
    while (str != null)
    {
      AsyncRun.run(new UploadManager.1(paramUpCompletionHandler, paramString1, ResponseInfo.invalidArgument(str)));
      return true;
      if (paramString2 != null)
      {
        boolean bool = paramString2.equals("");
        str = null;
        if (!bool) {}
      }
      else
      {
        str = "no token";
      }
    }
    return false;
  }
  
  public void put(File paramFile, String paramString1, String paramString2, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions)
  {
    if (areInvalidArg(paramString1, null, paramFile, paramString2, paramUpCompletionHandler)) {
      return;
    }
    if (paramFile.length() <= 524288L)
    {
      FormUploader.upload(this.httpManager, paramFile, paramString1, paramString2, paramUpCompletionHandler, paramUploadOptions);
      return;
    }
    if (this.keyGen != null) {}
    for (String str = this.keyGen.gen(paramString1, paramFile);; str = paramString1)
    {
      AsyncRun.run(new ResumeUploader(this.httpManager, this.recorder, paramFile, paramString1, paramString2, paramUpCompletionHandler, paramUploadOptions, str));
      return;
    }
  }
  
  public void put(String paramString1, String paramString2, String paramString3, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions)
  {
    put(new File(paramString1), paramString2, paramString3, paramUpCompletionHandler, paramUploadOptions);
  }
  
  public void put(byte[] paramArrayOfByte, String paramString1, String paramString2, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions)
  {
    if (areInvalidArg(paramString1, paramArrayOfByte, null, paramString2, paramUpCompletionHandler)) {
      return;
    }
    AsyncRun.run(new UploadManager.2(this, paramArrayOfByte, paramString1, paramString2, paramUpCompletionHandler, paramUploadOptions));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.UploadManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */