package com.qiniu.android.http;

import org.json.JSONObject;

public abstract interface CompletionHandler
{
  public abstract void complete(ResponseInfo paramResponseInfo, JSONObject paramJSONObject);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.http.CompletionHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */