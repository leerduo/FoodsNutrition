package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.w;
import com.xiaomi.xmpush.thrift.k;

final class l
  extends XMPushService.e
{
  l(int paramInt, XMPushService paramXMPushService, k paramk)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      this.a.b(this.a.a(this.b.j(), this.b.h()));
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
    return "send app absent message.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */