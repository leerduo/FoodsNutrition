package com.xiaomi.push.service;

public class XMPushService$d
  extends XMPushService.e
{
  public int a;
  public Exception b;
  
  XMPushService$d(XMPushService paramXMPushService, int paramInt, Exception paramException)
  {
    super(2);
    this.a = paramInt;
    this.b = paramException;
  }
  
  public void a()
  {
    this.c.b(this.a, this.b);
  }
  
  public String b()
  {
    return "disconnect the connection.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */