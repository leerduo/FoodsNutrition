package com.qiniu.android.http;

public class Proxy
{
  public final String hostAddress;
  public final String password;
  public final int port;
  public final String user;
  
  public Proxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.hostAddress = paramString1;
    this.port = paramInt;
    this.user = paramString2;
    this.password = paramString3;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.http.Proxy
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */