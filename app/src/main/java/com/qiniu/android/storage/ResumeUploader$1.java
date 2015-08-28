package com.qiniu.android.storage;

import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

class ResumeUploader$1
  implements CompletionHandler
{
  ResumeUploader$1(ResumeUploader paramResumeUploader, int paramInt1, int paramInt2, String paramString) {}
  
  public void complete(ResponseInfo paramResponseInfo, JSONObject paramJSONObject)
  {
    if (paramResponseInfo.isOK())
    {
      ResumeUploader.access$000(this.this$0);
      ResumeUploader.access$200(this.this$0).progressHandler.progress(ResumeUploader.access$100(this.this$0), 1.0D);
      ResumeUploader.access$300(this.this$0).complete(ResumeUploader.access$100(this.this$0), paramResponseInfo, paramJSONObject);
      return;
    }
    if ((paramResponseInfo.needRetry()) && (this.val$retried < 5))
    {
      ResumeUploader.access$400(this.this$0, this.val$offset, 1 + this.val$retried, this.val$host);
      return;
    }
    ResumeUploader.access$300(this.this$0).complete(ResumeUploader.access$100(this.this$0), paramResponseInfo, paramJSONObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.ResumeUploader.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */