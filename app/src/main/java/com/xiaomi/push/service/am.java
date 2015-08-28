package com.xiaomi.push.service;

import com.xiaomi.smack.j;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.packet.f.b;

class am
  extends XMPushService.e
{
  am(XMPushService paramXMPushService, int paramInt)
  {
    super(paramInt);
  }
  
  public void a()
  {
    if (XMPushService.d(this.a) != null)
    {
      XMPushService.d(this.a).a(new f(f.b.b), 15, null);
      XMPushService.a(this.a, null);
    }
  }
  
  public String b()
  {
    return "disconnect for service destroy.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.am
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */