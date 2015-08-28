package com.qiniu.android.storage;

import com.qiniu.android.http.ProgressHandler;

final class FormUploader$1
  implements ProgressHandler
{
  FormUploader$1(UploadOptions paramUploadOptions, String paramString) {}
  
  public void onProgress(int paramInt1, int paramInt2)
  {
    double d1 = 0.95D;
    double d2 = paramInt1 / paramInt2;
    if (d2 > d1) {}
    for (;;)
    {
      this.val$options.progressHandler.progress(this.val$key, d1);
      return;
      d1 = d2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.FormUploader.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */