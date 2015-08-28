package com.qiniu.android.storage;

import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

public abstract interface UpCompletionHandler
{
  public abstract void complete(String paramString, ResponseInfo paramResponseInfo, JSONObject paramJSONObject);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.UpCompletionHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */