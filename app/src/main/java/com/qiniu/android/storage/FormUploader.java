package com.qiniu.android.storage;

import com.qiniu.android.http.HttpManager;
import com.qiniu.android.http.PostArgs;
import com.qiniu.android.utils.Crc32;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class FormUploader
{
  private static void post(byte[] paramArrayOfByte, File paramFile, String paramString1, String paramString2, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions, HttpManager paramHttpManager)
  {
    HashMap localHashMap = new HashMap();
    PostArgs localPostArgs = new PostArgs();
    UploadOptions localUploadOptions;
    label59:
    long l1;
    if (paramString1 != null)
    {
      localHashMap.put("key", paramString1);
      localPostArgs.fileName = paramString1;
      localHashMap.put("token", paramString2);
      if (paramUploadOptions == null) {
        break label207;
      }
      localUploadOptions = paramUploadOptions;
      localHashMap.putAll(localUploadOptions.params);
      if (localUploadOptions.checkCrc)
      {
        l1 = 0L;
        if (paramFile == null) {
          break label225;
        }
      }
    }
    for (;;)
    {
      try
      {
        long l2 = Crc32.file(paramFile);
        l1 = l2;
        localHashMap.put("crc32", "" + l1);
        FormUploader.1 local1 = new FormUploader.1(localUploadOptions, paramString1);
        localPostArgs.data = paramArrayOfByte;
        localPostArgs.file = paramFile;
        localPostArgs.mimeType = localUploadOptions.mimeType;
        localPostArgs.params = localHashMap;
        paramHttpManager.multipartPost("http://upload.qiniu.com", localPostArgs, local1, new FormUploader.2(localUploadOptions, paramString1, paramUpCompletionHandler, paramHttpManager, localPostArgs, local1));
        return;
      }
      catch (IOException localIOException)
      {
        label207:
        localIOException.printStackTrace();
        continue;
      }
      localPostArgs.fileName = "?";
      break;
      localUploadOptions = UploadOptions.defaultOptions();
      break label59;
      label225:
      l1 = Crc32.bytes(paramArrayOfByte);
    }
  }
  
  static void upload(HttpManager paramHttpManager, File paramFile, String paramString1, String paramString2, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions)
  {
    post(null, paramFile, paramString1, paramString2, paramUpCompletionHandler, paramUploadOptions, paramHttpManager);
  }
  
  static void upload(HttpManager paramHttpManager, byte[] paramArrayOfByte, String paramString1, String paramString2, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions)
  {
    post(paramArrayOfByte, null, paramString1, paramString2, paramUpCompletionHandler, paramUploadOptions, paramHttpManager);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.FormUploader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */