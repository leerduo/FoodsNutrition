package com.loopj.android.http;

import org.json.JSONException;
import org.json.JSONObject;

class JsonHttpResponseHandler$1$2
  implements Runnable
{
  JsonHttpResponseHandler$1$2(JsonHttpResponseHandler.1 param1, JSONException paramJSONException) {}
  
  public void run()
  {
    this.this$1.this$0.onFailure(this.this$1.val$statusCode, this.this$1.val$headers, this.val$ex, (JSONObject)null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.JsonHttpResponseHandler.1.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */