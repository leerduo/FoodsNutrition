package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;

public abstract class XMPushService$e
{
  protected int d;
  
  public XMPushService$e(int paramInt)
  {
    this.d = paramInt;
  }
  
  public abstract void a();
  
  public abstract String b();
  
  public void c()
  {
    if ((this.d != 4) && (this.d != 8)) {
      b.a("JOB: " + b());
    }
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */