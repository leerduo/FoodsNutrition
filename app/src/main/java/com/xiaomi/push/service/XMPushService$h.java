package com.xiaomi.push.service;

import com.xiaomi.smack.packet.d;

class XMPushService$h
  extends XMPushService.e
{
  private d b = null;
  
  public XMPushService$h(XMPushService paramXMPushService, d paramd)
  {
    super(8);
    this.b = paramd;
  }
  
  public void a()
  {
    XMPushService.f(this.a).a(this.b);
  }
  
  public String b()
  {
    return "receive a message.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */