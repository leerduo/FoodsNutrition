package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.j;
import com.xiaomi.smack.w;

class XMPushService$j
  extends XMPushService.e
{
  v.b a = null;
  
  public XMPushService$j(XMPushService paramXMPushService, v.b paramb)
  {
    super(4);
    this.a = paramb;
  }
  
  public void a()
  {
    try
    {
      this.a.a(v.c.a, 1, 16, null, null);
      XMPushService.d(this.b).a(this.a.h, this.a.b);
      this.a.a(v.c.b, 1, 16, null, null);
      XMPushService.d(this.b).a(this.a);
      return;
    }
    catch (w localw)
    {
      b.a(localw);
      this.b.b(10, localw);
    }
  }
  
  public String b()
  {
    return "bind the client. " + this.a.h + ", " + this.a.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */