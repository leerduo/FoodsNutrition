package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.w;
import com.xiaomi.xmpush.thrift.d;

final class o
  extends XMPushService.e
{
  o(int paramInt, XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      com.xiaomi.xmpush.thrift.k localk = k.a(this.a, this.b);
      localk.m().a("miui_message_unrecognized", "1");
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
    return "send ack message for unrecognized new miui message.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.o
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */