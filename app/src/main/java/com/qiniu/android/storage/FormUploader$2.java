package com.qiniu.android.storage;

import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.HttpManager;
import com.qiniu.android.http.PostArgs;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

final class FormUploader$2
  implements CompletionHandler
{
  FormUploader$2(UploadOptions paramUploadOptions, String paramString, UpCompletionHandler paramUpCompletionHandler, HttpManager paramHttpManager, PostArgs paramPostArgs, ProgressHandler paramProgressHandler) {}
  
  public void complete(ResponseInfo paramResponseInfo, JSONObject paramJSONObject)
  {
    if (paramResponseInfo.isOK())
    {
      this.val$options.progressHandler.progress(this.val$key, 1.0D);
      this.val$completionHandler.complete(this.val$key, paramResponseInfo, paramJSONObject);
      return;
    }
    FormUploader.2.1 local1 = new FormUploader.2.1(this);
    String str = "upload.qiniu.com";
    if (paramResponseInfo.needSwitchServer()) {
      str = "up.qiniu.com";
    }
    this.val$httpManager.multipartPost("http://" + str, this.val$args, this.val$progress, local1);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.FormUploader.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */