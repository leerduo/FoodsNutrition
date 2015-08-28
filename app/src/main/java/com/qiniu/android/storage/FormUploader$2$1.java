package com.qiniu.android.storage;

import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

class FormUploader$2$1
  implements CompletionHandler
{
  FormUploader$2$1(FormUploader.2 param2) {}
  
  public void complete(ResponseInfo paramResponseInfo, JSONObject paramJSONObject)
  {
    if (paramResponseInfo.isOK()) {
      this.this$0.val$options.progressHandler.progress(this.this$0.val$key, 1.0D);
    }
    this.this$0.val$completionHandler.complete(this.this$0.val$key, paramResponseInfo, paramJSONObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.FormUploader.2.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */