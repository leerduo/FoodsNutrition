package com.android.volley;

public abstract interface ResponseDelivery
{
  public abstract void a(Request<?> paramRequest, Response<?> paramResponse);
  
  public abstract void a(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable);
  
  public abstract void a(Request<?> paramRequest, VolleyError paramVolleyError);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.ResponseDelivery
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */