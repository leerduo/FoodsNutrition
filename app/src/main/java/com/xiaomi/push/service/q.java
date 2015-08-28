package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.w;
import com.xiaomi.xmpush.thrift.d;

final class q
  extends XMPushService.e
{
  q(int paramInt, XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk, String paramString1, String paramString2)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      com.xiaomi.xmpush.thrift.k localk = k.a(this.a, this.b);
      localk.h.a("error", this.c);
      localk.h.a("reason", this.e);
      this.a.b(localk);
      return;
    }
    catch (w localw)
    {
      b.a(localw);
      this.a.b(10, localw);
    }
  }
  
  public String b()
  {
    return "send wrong message ack for message.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.q
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */