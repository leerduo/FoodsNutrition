package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

class JsonHttpResponseHandler$2
  implements Runnable
{
  JsonHttpResponseHandler$2(JsonHttpResponseHandler paramJsonHttpResponseHandler, byte[] paramArrayOfByte, int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.parseResponse(this.val$responseBytes);
      this.this$0.postRunnable(new JsonHttpResponseHandler.2.1(this, localObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      this.this$0.postRunnable(new JsonHttpResponseHandler.2.2(this, localJSONException));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.JsonHttpResponseHandler.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */