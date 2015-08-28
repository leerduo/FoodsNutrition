package com.qiniu.android.storage;

class UploadManager$2
  implements Runnable
{
  UploadManager$2(UploadManager paramUploadManager, byte[] paramArrayOfByte, String paramString1, String paramString2, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions) {}
  
  public void run()
  {
    FormUploader.upload(UploadManager.access$000(this.this$0), this.val$data, this.val$key, this.val$token, this.val$completionHandler, this.val$options);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.UploadManager.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */