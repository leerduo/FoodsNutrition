package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

class JsonHttpResponseHandler$1
  implements Runnable
{
  JsonHttpResponseHandler$1(JsonHttpResponseHandler paramJsonHttpResponseHandler, byte[] paramArrayOfByte, int paramInt, Header[] paramArrayOfHeader) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.parseResponse(this.val$responseBytes);
      this.this$0.postRunnable(new JsonHttpResponseHandler.1.1(this, localObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      this.this$0.postRunnable(new JsonHttpResponseHandler.1.2(this, localJSONException));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.JsonHttpResponseHandler.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */