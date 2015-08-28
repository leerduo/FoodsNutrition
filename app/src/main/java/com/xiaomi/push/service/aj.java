package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.w;

class aj
  extends XMPushService.e
{
  aj(XMPushService paramXMPushService, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      this.c.a(this.a, this.b);
      return;
    }
    catch (w localw)
    {
      b.a(localw);
      this.c.b(10, localw);
    }
  }
  
  public String b()
  {
    return "send mi push message";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.aj
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */