package com.qiniu.android.storage;

import com.qiniu.android.http.ResponseInfo;

final class UploadManager$1
  implements Runnable
{
  UploadManager$1(UpCompletionHandler paramUpCompletionHandler, String paramString, ResponseInfo paramResponseInfo) {}
  
  public void run()
  {
    this.val$completionHandler.complete(this.val$key, this.val$info, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.UploadManager.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */