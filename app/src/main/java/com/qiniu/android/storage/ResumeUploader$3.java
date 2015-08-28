package com.qiniu.android.storage;

import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import org.json.JSONException;
import org.json.JSONObject;

class ResumeUploader$3
  implements CompletionHandler
{
  ResumeUploader$3(ResumeUploader paramResumeUploader, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void complete(ResponseInfo paramResponseInfo, JSONObject paramJSONObject)
  {
    String str1 = null;
    if (!paramResponseInfo.isOK())
    {
      if (paramResponseInfo.statusCode == 701)
      {
        ResumeUploader.access$400(this.this$0, 4194304 * (this.val$offset / 4194304), this.val$retried, this.val$host);
        return;
      }
      if ((this.val$retried >= 5) || (!paramResponseInfo.needRetry()))
      {
        ResumeUploader.access$300(this.this$0).complete(ResumeUploader.access$100(this.this$0), paramResponseInfo, null);
        return;
      }
      String str3 = this.val$host;
      if (paramResponseInfo.needSwitchServer()) {
        str3 = "up.qiniu.com";
      }
      ResumeUploader.access$400(this.this$0, this.val$offset, 1 + this.val$retried, str3);
      return;
    }
    if (paramJSONObject == null)
    {
      ResumeUploader.access$400(this.this$0, this.val$offset, 1 + this.val$retried, this.val$host);
      return;
    }
    try
    {
      str1 = paramJSONObject.getString("ctx");
      long l2 = paramJSONObject.getLong("crc32");
      str2 = str1;
      l1 = l2;
      if ((str2 == null) || (l1 != ResumeUploader.access$600(this.this$0)))
      {
        ResumeUploader.access$400(this.this$0, this.val$offset, 1 + this.val$retried, this.val$host);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      String str2;
      for (;;)
      {
        localJSONException.printStackTrace();
        str2 = str1;
        long l1 = 0L;
      }
      ResumeUploader.access$700(this.this$0)[(this.val$offset / 4194304)] = str2;
      ResumeUploader.access$800(this.this$0, this.val$offset + this.val$chunkSize);
      ResumeUploader.access$400(this.this$0, this.val$offset + this.val$chunkSize, this.val$retried, this.val$host);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.ResumeUploader.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */