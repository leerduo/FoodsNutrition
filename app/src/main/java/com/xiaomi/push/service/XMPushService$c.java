package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;

public class XMPushService$c
  extends XMPushService.e
{
  XMPushService$c(XMPushService paramXMPushService)
  {
    super(1);
  }
  
  public void a()
  {
    if (this.a.c())
    {
      XMPushService.g(this.a);
      return;
    }
    b.a("should not connect. quit the job.");
  }
  
  public String b()
  {
    return "do reconnect..";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */