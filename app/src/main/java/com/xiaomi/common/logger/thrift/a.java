package com.xiaomi.common.logger.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class a
  implements Serializable, Cloneable, org.apache.thrift.b<a, a.a>
{
  public static final Map<a.a, org.apache.thrift.meta_data.b> f;
  private static final k g = new k("Common");
  private static final org.apache.thrift.protocol.c h = new org.apache.thrift.protocol.c("uuid", (byte)10, (short)1);
  private static final org.apache.thrift.protocol.c i = new org.apache.thrift.protocol.c("time", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.c j = new org.apache.thrift.protocol.c("clientIp", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("serverIp", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("serverHost", (byte)11, (short)5);
  public long a = 0L;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  private BitSet m = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.a.class);
    localEnumMap.put(a.a.a, new org.apache.thrift.meta_data.b("uuid", (byte)2, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(a.a.b, new org.apache.thrift.meta_data.b("time", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.a.c, new org.apache.thrift.meta_data.b("clientIp", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.a.d, new org.apache.thrift.meta_data.b("serverIp", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.a.e, new org.apache.thrift.meta_data.b("serverHost", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    f = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(a.class, f);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      f();
      return;
    }
    switch (localc.c)
    {
    default: 
      i.a(paramf, localc.b);
    }
    for (;;)
    {
      paramf.j();
      break;
      if (localc.b == 10)
      {
        this.a = paramf.u();
        a(true);
      }
      else
      {
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.b = paramf.w();
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 11)
          {
            this.c = paramf.w();
          }
          else
          {
            i.a(paramf, localc.b);
            continue;
            if (localc.b == 11)
            {
              this.d = paramf.w();
            }
            else
            {
              i.a(paramf, localc.b);
              continue;
              if (localc.b == 11) {
                this.e = paramf.w();
              } else {
                i.a(paramf, localc.b);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.m.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.m.get(0);
  }
  
  public boolean a(a parama)
  {
    if (parama == null) {}
    boolean bool9;
    boolean bool10;
    do
    {
      boolean bool7;
      boolean bool8;
      do
      {
        boolean bool5;
        boolean bool6;
        do
        {
          boolean bool3;
          boolean bool4;
          do
          {
            boolean bool1;
            boolean bool2;
            do
            {
              return false;
              bool1 = a();
              bool2 = parama.a();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.a != parama.a)));
            bool3 = b();
            bool4 = parama.b();
          } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.equals(parama.b))));
          bool5 = c();
          bool6 = parama.c();
        } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(parama.c))));
        bool7 = d();
        bool8 = parama.d();
      } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(parama.d))));
      bool9 = e();
      bool10 = parama.e();
    } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(parama.e))));
    return true;
  }
  
  public int b(a parama)
  {
    int n;
    if (!getClass().equals(parama.getClass())) {
      n = getClass().getName().compareTo(parama.getClass().getName());
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return n;
                        n = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parama.a()));
                      } while (n != 0);
                      if (!a()) {
                        break;
                      }
                      n = org.apache.thrift.c.a(this.a, parama.a);
                    } while (n != 0);
                    n = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parama.b()));
                  } while (n != 0);
                  if (!b()) {
                    break;
                  }
                  n = org.apache.thrift.c.a(this.b, parama.b);
                } while (n != 0);
                n = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parama.c()));
              } while (n != 0);
              if (!c()) {
                break;
              }
              n = org.apache.thrift.c.a(this.c, parama.c);
            } while (n != 0);
            n = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parama.d()));
          } while (n != 0);
          if (!d()) {
            break;
          }
          n = org.apache.thrift.c.a(this.d, parama.d);
        } while (n != 0);
        n = Boolean.valueOf(e()).compareTo(Boolean.valueOf(parama.e()));
      } while (n != 0);
      if (!e()) {
        break;
      }
      n = org.apache.thrift.c.a(this.e, parama.e);
    } while (n != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    f();
    paramf.a(g);
    if (a())
    {
      paramf.a(h);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(i);
      paramf.a(this.b);
      paramf.b();
    }
    if ((this.c != null) && (c()))
    {
      paramf.a(j);
      paramf.a(this.c);
      paramf.b();
    }
    if ((this.d != null) && (d()))
    {
      paramf.a(k);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(l);
      paramf.a(this.e);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof a)) {
      return false;
    }
    return a((a)paramObject);
  }
  
  public void f() {}
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int n = 0;
    StringBuilder localStringBuilder = new StringBuilder("Common(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("uuid:");
      localStringBuilder.append(this.a);
      i1 = 0;
    }
    if (b())
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("time:");
      if (this.b == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (c())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("clientIp:");
        if (this.c != null) {
          break label238;
        }
        localStringBuilder.append("null");
        label127:
        i1 = 0;
      }
      if (!d()) {
        break label276;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("serverIp:");
      if (this.d != null) {
        break label250;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      label171:
      if (e())
      {
        if (n == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("serverHost:");
        if (this.e != null) {
          break label264;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.b);
        break;
        label238:
        localStringBuilder.append(this.c);
        break label127;
        label250:
        localStringBuilder.append(this.d);
        n = 0;
        break label171;
        label264:
        localStringBuilder.append(this.e);
      }
      label276:
      n = i1;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */