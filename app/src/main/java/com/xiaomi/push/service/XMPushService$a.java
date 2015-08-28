package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.j;
import com.xiaomi.smack.w;

class XMPushService$a
  extends XMPushService.e
{
  v.b a = null;
  
  public XMPushService$a(XMPushService paramXMPushService, v.b paramb)
  {
    super(9);
    this.a = paramb;
  }
  
  public void a()
  {
    try
    {
      if (!this.b.f())
      {
        b.c("trying bind while the connection is not created, quit!");
        return;
      }
      if (this.a.m == v.c.a)
      {
        this.a.a(v.c.b, 0, 0, null, null);
        XMPushService.d(this.b).a(this.a);
        return;
      }
    }
    catch (w localw)
    {
      b.a(localw);
      this.b.b(10, localw);
      return;
    }
    b.a("trying duplicate bind, ingore! " + this.a.m);
  }
  
  public String b()
  {
    return "bind the client. " + this.a.h + ", " + this.a.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */