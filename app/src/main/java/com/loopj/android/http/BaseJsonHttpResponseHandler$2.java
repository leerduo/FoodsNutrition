package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

class BaseJsonHttpResponseHandler$2
  implements Runnable
{
  BaseJsonHttpResponseHandler$2(BaseJsonHttpResponseHandler paramBaseJsonHttpResponseHandler, String paramString, int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.parseResponse(this.val$responseString, true);
      this.this$0.postRunnable(new BaseJsonHttpResponseHandler.2.1(this, localObject));
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", localThrowable);
      this.this$0.postRunnable(new BaseJsonHttpResponseHandler.2.2(this));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.BaseJsonHttpResponseHandler.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */