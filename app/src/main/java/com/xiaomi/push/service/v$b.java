package com.xiaomi.push.service;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v$b
{
  public String a;
  public String b;
  public String c;
  public String d;
  public boolean e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public b k;
  public Context l;
  v.c m = v.c.a;
  private int n = 0;
  private List<v.b.a> o = new ArrayList();
  private XMPushService p;
  private XMPushService.b q = new XMPushService.b(this);
  
  public v$b(XMPushService paramXMPushService)
  {
    this.p = paramXMPushService;
    a(new w(this));
  }
  
  public long a()
  {
    return 1000L * ((20.0D * Math.random() - 10.0D) + 15 * (1 + this.n));
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 1: 
      return "OPEN";
    case 2: 
      return "CLOSE";
    }
    return "KICK";
  }
  
  public void a(v.b.a parama)
  {
    this.o.add(parama);
  }
  
  public void a(v.c paramc, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    int i1 = 1;
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext()) {
      ((v.b.a)localIterator.next()).a(this.m, paramc, paramInt2);
    }
    if (this.m != paramc)
    {
      Object[] arrayOfObject = new Object[7];
      arrayOfObject[0] = this.m;
      arrayOfObject[i1] = paramc;
      arrayOfObject[2] = a(paramInt1);
      arrayOfObject[3] = x.a(paramInt2);
      arrayOfObject[4] = paramString1;
      arrayOfObject[5] = paramString2;
      arrayOfObject[6] = this.h;
      com.xiaomi.channel.commonutils.logger.b.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", arrayOfObject));
      this.m = paramc;
    }
    if (this.k == null) {
      com.xiaomi.channel.commonutils.logger.b.c("status changed while the client dispatcher is missing");
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        this.k.a(this.l, this, paramInt2);
        return;
      }
      if (paramInt1 == 3)
      {
        this.k.a(this.l, this, paramString2, paramString1);
        return;
      }
    } while (paramInt1 != i1);
    if (paramc == v.c.c)
    {
      if ((i1 != 0) || (!"wait".equals(paramString2))) {
        break label246;
      }
      this.n = (1 + this.n);
    }
    for (;;)
    {
      this.k.a(this.l, this, i1, paramInt2, paramString1);
      return;
      i1 = 0;
      break;
      label246:
      if (i1 != 0) {
        this.n = 0;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.v.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */