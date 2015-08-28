package com.loopj.android.http;

class BaseJsonHttpResponseHandler$1$1
  implements Runnable
{
  BaseJsonHttpResponseHandler$1$1(BaseJsonHttpResponseHandler.1 param1, Object paramObject) {}
  
  public void run()
  {
    this.this$1.this$0.onSuccess(this.this$1.val$statusCode, this.this$1.val$headers, this.this$1.val$responseString, this.val$jsonResponse);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.BaseJsonHttpResponseHandler.1.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */