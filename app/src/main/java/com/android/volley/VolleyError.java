package com.android.volley;

public class VolleyError
  extends Exception
{
  public final NetworkResponse a;
  private long b;
  
  public VolleyError()
  {
    this.a = null;
  }
  
  public VolleyError(NetworkResponse paramNetworkResponse)
  {
    this.a = paramNetworkResponse;
  }
  
  public VolleyError(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = null;
  }
  
  void a(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.VolleyError
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */