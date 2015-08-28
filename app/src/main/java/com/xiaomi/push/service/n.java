package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.w;
import com.xiaomi.xmpush.thrift.d;

final class n
  extends XMPushService.e
{
  n(int paramInt, XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      com.xiaomi.xmpush.thrift.k localk = k.a(this.a, this.b);
      localk.m().a("message_obsleted", "1");
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
    return "send ack message for obsleted message.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.n
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */