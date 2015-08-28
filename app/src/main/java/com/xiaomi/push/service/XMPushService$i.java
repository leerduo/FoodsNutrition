package com.xiaomi.push.service;

import com.xiaomi.smack.j;
import com.xiaomi.smack.w;

class XMPushService$i
  extends XMPushService.e
{
  public XMPushService$i(XMPushService paramXMPushService)
  {
    super(4);
  }
  
  public void a()
  {
    if (this.a.f()) {}
    try
    {
      com.xiaomi.stats.b.a();
      XMPushService.d(this.a).c();
      return;
    }
    catch (w localw)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localw);
      this.a.b(10, localw);
    }
  }
  
  public String b()
  {
    return "send ping..";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */