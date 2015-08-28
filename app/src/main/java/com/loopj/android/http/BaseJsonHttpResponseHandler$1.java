package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

class BaseJsonHttpResponseHandler$1
  implements Runnable
{
  BaseJsonHttpResponseHandler$1(BaseJsonHttpResponseHandler paramBaseJsonHttpResponseHandler, String paramString, int paramInt, Header[] paramArrayOfHeader) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.parseResponse(this.val$responseString, false);
      this.this$0.postRunnable(new BaseJsonHttpResponseHandler.1.1(this, localObject));
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", localThrowable);
      this.this$0.postRunnable(new BaseJsonHttpResponseHandler.1.2(this, localThrowable));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.BaseJsonHttpResponseHandler.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */