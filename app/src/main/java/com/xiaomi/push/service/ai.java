package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.a;
import com.xiaomi.smack.k;

class ai
  extends XMPushService.e
{
  ai(XMPushService paramXMPushService, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString)
  {
    super(paramInt1);
  }
  
  public void a()
  {
    g.f(this.e);
    v.a().a("5");
    a.a(this.a);
    XMPushService.c(this.e).c(k.d());
    this.e.a(this.b, this.c);
  }
  
  public String b()
  {
    return "clear account cache.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ai
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */