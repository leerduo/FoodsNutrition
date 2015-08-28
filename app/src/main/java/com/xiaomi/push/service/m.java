package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.w;

final class m
  extends XMPushService.e
{
  m(int paramInt, XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      com.xiaomi.xmpush.thrift.k localk = k.a(this.a, this.b);
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
    return "send ack message for message.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.m
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */