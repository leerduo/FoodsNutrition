package com.loopj.android.http;

class BaseJsonHttpResponseHandler$1$2
  implements Runnable
{
  BaseJsonHttpResponseHandler$1$2(BaseJsonHttpResponseHandler.1 param1, Throwable paramThrowable) {}
  
  public void run()
  {
    this.this$1.this$0.onFailure(this.this$1.val$statusCode, this.this$1.val$headers, this.val$t, this.this$1.val$responseString, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.BaseJsonHttpResponseHandler.1.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */