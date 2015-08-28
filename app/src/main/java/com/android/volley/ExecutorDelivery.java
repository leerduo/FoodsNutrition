package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery
  implements ResponseDelivery
{
  private final Executor a;
  
  public ExecutorDelivery(Handler paramHandler)
  {
    this.a = new ExecutorDelivery.1(this, paramHandler);
  }
  
  public void a(Request<?> paramRequest, Response<?> paramResponse)
  {
    a(paramRequest, paramResponse, null);
  }
  
  public void a(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable)
  {
    paramRequest.w();
    paramRequest.a("post-response");
    this.a.execute(new ExecutorDelivery.ResponseDeliveryRunnable(this, paramRequest, paramResponse, paramRunnable));
  }
  
  public void a(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramRequest.a("post-error");
    Response localResponse = Response.a(paramVolleyError);
    this.a.execute(new ExecutorDelivery.ResponseDeliveryRunnable(this, paramRequest, localResponse, null));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.ExecutorDelivery
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */