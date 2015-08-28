package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class AsyncHttpResponseHandler$ResponderHandler
  extends Handler
{
  private final AsyncHttpResponseHandler mResponder;
  
  AsyncHttpResponseHandler$ResponderHandler(AsyncHttpResponseHandler paramAsyncHttpResponseHandler, Looper paramLooper)
  {
    super(paramLooper);
    this.mResponder = paramAsyncHttpResponseHandler;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.mResponder.handleMessage(paramMessage);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.AsyncHttpResponseHandler.ResponderHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */