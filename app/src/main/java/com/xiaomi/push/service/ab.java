package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.w;

public class ab
  extends XMPushService.e
{
  private XMPushService a = null;
  private d b;
  
  public ab(XMPushService paramXMPushService, d paramd)
  {
    super(4);
    this.a = paramXMPushService;
    this.b = paramd;
  }
  
  public void a()
  {
    try
    {
      this.a.a(this.b);
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
    return "send a message.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ab
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */