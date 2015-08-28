package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;

public class aa
{
  private static int e = 300;
  private XMPushService a;
  private int b;
  private long c;
  private int d = 0;
  
  public aa(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
    this.b = 10;
    this.c = 0L;
  }
  
  private int b()
  {
    int i = 40;
    if (this.d > 13) {
      return 300;
    }
    if (this.d > 7) {
      return 60;
    }
    if (this.d >= 1) {
      return 10;
    }
    if (this.c == 0L) {
      return 0;
    }
    long l = System.currentTimeMillis() - this.c;
    if (l < 300000L)
    {
      if (this.b >= e) {
        return this.b;
      }
      int k = this.b;
      this.b = ((int)(1.5D * this.b));
      return k;
    }
    if (l < 900000L)
    {
      if (this.b < i) {
        i = this.b;
      }
      this.b = i;
      return this.b;
    }
    if (l < 1800000L)
    {
      if (this.b < 20) {}
      for (int j = this.b;; j = 20)
      {
        this.b = j;
        return this.b;
      }
    }
    this.b = 10;
    return this.b;
  }
  
  public void a()
  {
    this.c = System.currentTimeMillis();
    this.a.a(1);
    this.d = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.c())
    {
      if (paramBoolean)
      {
        this.a.a(1);
        localXMPushService3 = this.a;
        localXMPushService4 = this.a;
        localXMPushService4.getClass();
        localXMPushService3.a(new XMPushService.c(localXMPushService4));
        this.d = (1 + this.d);
      }
      while (this.a.b(1))
      {
        XMPushService localXMPushService3;
        XMPushService localXMPushService4;
        return;
      }
      int i = b();
      b.a("schedule reconnect in " + i + "s");
      XMPushService localXMPushService1 = this.a;
      XMPushService localXMPushService2 = this.a;
      localXMPushService2.getClass();
      localXMPushService1.a(new XMPushService.c(localXMPushService2), i * 1000);
      this.d = (1 + this.d);
      return;
    }
    b.b("should not reconnect as no client or network.");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.aa
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */