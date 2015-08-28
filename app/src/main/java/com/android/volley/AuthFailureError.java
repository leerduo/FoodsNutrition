package com.android.volley;

import android.content.Intent;

public class AuthFailureError
  extends VolleyError
{
  private Intent b;
  
  public AuthFailureError() {}
  
  public AuthFailureError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }
  
  public String getMessage()
  {
    if (this.b != null) {
      return "User needs to (re)enter credentials.";
    }
    return super.getMessage();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.AuthFailureError
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */