package com.android.volley;

public class NetworkError
  extends VolleyError
{
  public NetworkError() {}
  
  public NetworkError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }
  
  public NetworkError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.NetworkError
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */