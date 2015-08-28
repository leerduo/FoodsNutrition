package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.e;

class u
  extends XMPushService.e
{
  u(t paramt, int paramInt, long paramLong)
  {
    super(paramInt);
  }
  
  public void a()
  {
    if ((this.b.j()) && (!this.b.a(this.a))) {
      t.a(this.b).b(22, null);
    }
  }
  
  public String b()
  {
    return "check the ping-pong.";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.u
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */