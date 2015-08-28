package com.loopj.android.http;

import java.lang.ref.WeakReference;

public class RequestHandle
{
  private final WeakReference<AsyncHttpRequest> request;
  
  public RequestHandle(AsyncHttpRequest paramAsyncHttpRequest)
  {
    this.request = new WeakReference(paramAsyncHttpRequest);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.request.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.cancel(paramBoolean));
  }
  
  public boolean isCancelled()
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.request.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.isCancelled());
  }
  
  public boolean isFinished()
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.request.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.isDone());
  }
  
  public boolean shouldBeGarbageCollected()
  {
    if ((isCancelled()) || (isFinished())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.request.clear();
      }
      return bool;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.RequestHandle
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */