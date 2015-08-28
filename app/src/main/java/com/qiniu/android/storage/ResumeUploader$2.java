package com.qiniu.android.storage;

import com.qiniu.android.http.ProgressHandler;

class ResumeUploader$2
  implements ProgressHandler
{
  ResumeUploader$2(ResumeUploader paramResumeUploader, int paramInt) {}
  
  public void onProgress(int paramInt1, int paramInt2)
  {
    double d1 = 0.95D;
    double d2 = (paramInt1 + this.val$offset) / ResumeUploader.access$500(this.this$0);
    if (d2 > d1) {}
    for (;;)
    {
      ResumeUploader.access$200(this.this$0).progressHandler.progress(ResumeUploader.access$100(this.this$0), d1);
      return;
      d1 = d2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.ResumeUploader.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */