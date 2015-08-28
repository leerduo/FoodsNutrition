package com.xiaomi.smack;

import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.v.b;
import com.xiaomi.push.service.x;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.f;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class j
{
  private static final AtomicInteger a = new AtomicInteger(0);
  public static boolean c = false;
  private LinkedList<Pair<Integer, Long>> b = new LinkedList();
  protected int d = 0;
  protected long e = -1L;
  protected final Map<n, j.a> f = new ConcurrentHashMap();
  protected final Map<n, j.a> g = new ConcurrentHashMap();
  protected com.xiaomi.smack.debugger.a h = null;
  protected Reader i;
  protected Writer j;
  protected String k = "";
  protected final int l = a.getAndIncrement();
  protected k m;
  protected XMPushService n;
  private final Collection<l> o = new CopyOnWriteArrayList();
  private int p = 2;
  private long q = 0L;
  
  static
  {
    try
    {
      c = Boolean.getBoolean("smack.debugEnabled");
      label23:
      r.a();
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  protected j(XMPushService paramXMPushService, k paramk)
  {
    this.m = paramk;
    this.n = paramXMPushService;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return "connected";
    }
    if (paramInt == 0) {
      return "connecting";
    }
    if (paramInt == 2) {
      return "disconnected";
    }
    return "unknown";
  }
  
  private void b(int paramInt)
  {
    localLinkedList = this.b;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.b.clear();
        return;
      }
      finally {}
      this.b.add(new Pair(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis())));
      if (this.b.size() > 6) {
        this.b.remove(0);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Exception paramException)
  {
    if (paramInt1 != this.p)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = a(this.p);
      arrayOfObject[1] = a(paramInt1);
      arrayOfObject[2] = x.a(paramInt2);
      b.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", arrayOfObject));
    }
    if (com.xiaomi.channel.commonutils.network.a.d(this.n)) {
      b(paramInt1);
    }
    if (paramInt1 == 1)
    {
      this.n.a(10);
      if (this.p != 0) {
        b.a("try set connected while not connecting.");
      }
      this.p = paramInt1;
      Iterator localIterator4 = this.o.iterator();
      while (localIterator4.hasNext()) {
        ((l)localIterator4.next()).a();
      }
    }
    if (paramInt1 == 0)
    {
      this.n.i();
      if (this.p != 2) {
        b.a("try set connecting while not disconnected.");
      }
      this.p = paramInt1;
      Iterator localIterator3 = this.o.iterator();
      while (localIterator3.hasNext()) {
        ((l)localIterator3.next()).b();
      }
    }
    if (paramInt1 == 2)
    {
      this.n.a(10);
      if (this.p == 0)
      {
        Iterator localIterator2 = this.o.iterator();
        if (localIterator2.hasNext())
        {
          l locall = (l)localIterator2.next();
          if (paramException == null) {}
          for (Object localObject = new CancellationException("disconnect while connecting");; localObject = paramException)
          {
            locall.a((Exception)localObject);
            break;
          }
        }
      }
      else if (this.p == 1)
      {
        Iterator localIterator1 = this.o.iterator();
        while (localIterator1.hasNext()) {
          ((l)localIterator1.next()).a(paramInt2, paramException);
        }
      }
      this.p = paramInt1;
    }
  }
  
  public abstract void a(v.b paramb);
  
  public void a(l paraml)
  {
    if (paraml == null) {}
    while (this.o.contains(paraml)) {
      return;
    }
    this.o.add(paraml);
  }
  
  public void a(n paramn, com.xiaomi.smack.filter.a parama)
  {
    if (paramn == null) {
      throw new NullPointerException("Packet listener is null.");
    }
    j.a locala = new j.a(paramn, parama);
    this.f.put(paramn, locala);
  }
  
  public abstract void a(d paramd);
  
  public abstract void a(f paramf, int paramInt, Exception paramException);
  
  public void a(String paramString)
  {
    this.k = paramString;
    a(1, 0, null);
  }
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(d[] paramArrayOfd);
  
  public boolean a(long paramLong)
  {
    return this.q >= paramLong;
  }
  
  protected void b()
  {
    if ((this.i == null) || (this.j == null)) {}
    while (!this.m.i()) {
      return;
    }
    if (this.h == null) {
      try
      {
        String str2 = System.getProperty("smack.debuggerClass");
        String str1 = str2;
        Object localObject = null;
        if (str1 != null) {}
        Class localClass;
        Constructor localConstructor;
        Object[] arrayOfObject;
        this.i = this.h.a(this.i);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          try
          {
            localClass = Class.forName(str1);
            localObject = localClass;
            if (localObject != null) {
              continue;
            }
            this.h = new com.xiaomi.measite.smack.a(this, this.j, this.i);
            this.i = this.h.a();
            this.j = this.h.b();
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            localObject = null;
            continue;
            try
            {
              localConstructor = localObject.getConstructor(new Class[] { j.class, Writer.class, Reader.class });
              arrayOfObject = new Object[3];
              arrayOfObject[0] = this;
              arrayOfObject[1] = this.j;
              arrayOfObject[2] = this.i;
              this.h = ((com.xiaomi.smack.debugger.a)localConstructor.newInstance(arrayOfObject));
              this.i = this.h.a();
              this.j = this.h.b();
              return;
            }
            catch (Exception localException1)
            {
              throw new IllegalArgumentException("Can't initialize the configured debugger!", localException1);
            }
          }
          localThrowable = localThrowable;
          str1 = null;
        }
      }
    }
    this.j = this.h.a(this.j);
  }
  
  public void b(l paraml)
  {
    this.o.remove(paraml);
  }
  
  public void b(n paramn, com.xiaomi.smack.filter.a parama)
  {
    if (paramn == null) {
      throw new NullPointerException("Packet listener is null.");
    }
    j.a locala = new j.a(paramn, parama);
    this.g.put(paramn, locala);
  }
  
  public abstract void c();
  
  protected void c(d paramd)
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((j.a)localIterator.next()).a(paramd);
    }
  }
  
  public String d()
  {
    return this.m.e();
  }
  
  public String e()
  {
    return this.m.h();
  }
  
  public String f()
  {
    return this.m.f();
  }
  
  public int g()
  {
    return this.m.g();
  }
  
  public Collection<l> h()
  {
    return this.o;
  }
  
  public boolean i()
  {
    return this.p == 0;
  }
  
  public boolean j()
  {
    return this.p == 1;
  }
  
  public int k()
  {
    return this.d;
  }
  
  public void l()
  {
    this.d = 0;
  }
  
  public long m()
  {
    return this.e;
  }
  
  public void n()
  {
    this.e = -1L;
  }
  
  public int o()
  {
    return this.p;
  }
  
  public void p()
  {
    this.q = System.currentTimeMillis();
  }
  
  public boolean q()
  {
    return System.currentTimeMillis() - this.q < r.c();
  }
  
  public boolean r()
  {
    ArrayList localArrayList;
    synchronized (this.b)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (System.currentTimeMillis() - ((Long)localPair.second).longValue() < 1800000L) {
          localArrayList.add(localPair);
        }
      }
    }
    this.b.clear();
    this.b.addAll(localArrayList);
    if (this.b.size() >= 6) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void s()
  {
    synchronized (this.b)
    {
      this.b.clear();
      return;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */