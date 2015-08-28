package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.j;
import com.xiaomi.smack.w;

class XMPushService$l
  extends XMPushService.e
{
  v.b a = null;
  int b;
  String c;
  String e;
  
  public XMPushService$l(XMPushService paramXMPushService, v.b paramb, int paramInt, String paramString1, String paramString2)
  {
    super(9);
    this.a = paramb;
    this.b = paramInt;
    this.c = paramString1;
    this.e = paramString2;
  }
  
  public void a()
  {
    if ((this.a.m != v.c.a) && (XMPushService.d(this.f) != null)) {}
    try
    {
      XMPushService.d(this.f).a(this.a.h, this.a.b);
      this.a.a(v.c.a, this.b, 0, this.e, this.c);
      return;
    }
    catch (w localw)
    {
      for (;;)
      {
        b.a(localw);
        this.f.b(10, localw);
      }
    }
  }
  
  public String b()
  {
    return "unbind the channel. " + this.a.h + ", " + this.a.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */