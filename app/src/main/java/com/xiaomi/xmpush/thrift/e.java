package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.g;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class e
  implements Serializable, Cloneable, org.apache.thrift.b<e, e.a>
{
  public static final Map<e.a, org.apache.thrift.meta_data.b> f;
  private static final k g = new k("StatsEvent");
  private static final org.apache.thrift.protocol.c h = new org.apache.thrift.protocol.c("chid", (byte)3, (short)1);
  private static final org.apache.thrift.protocol.c i = new org.apache.thrift.protocol.c("type", (byte)8, (short)2);
  private static final org.apache.thrift.protocol.c j = new org.apache.thrift.protocol.c("value", (byte)8, (short)3);
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("connpt", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("host", (byte)11, (short)5);
  public byte a;
  public int b;
  public int c;
  public String d;
  public String e;
  private BitSet m = new BitSet(3);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(e.a.class);
    localEnumMap.put(e.a.a, new org.apache.thrift.meta_data.b("chid", (byte)1, new org.apache.thrift.meta_data.c((byte)3)));
    localEnumMap.put(e.a.b, new org.apache.thrift.meta_data.b("type", (byte)1, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(e.a.c, new org.apache.thrift.meta_data.b("value", (byte)1, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(e.a.d, new org.apache.thrift.meta_data.b("connpt", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(e.a.e, new org.apache.thrift.meta_data.b("host", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    f = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(e.class, f);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!a()) {
        throw new g("Required field 'chid' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (localc.c)
      {
      default: 
        i.a(paramf, localc.b);
      }
      for (;;)
      {
        paramf.j();
        break;
        if (localc.b == 3)
        {
          this.a = paramf.r();
          a(true);
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 8)
          {
            this.b = paramf.t();
            b(true);
          }
          else
          {
            i.a(paramf, localc.b);
            continue;
            if (localc.b == 8)
            {
              this.c = paramf.t();
              c(true);
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
    if (!b()) {
      throw new g("Required field 'type' was not found in serialized data! Struct: " + toString());
    }
    if (!c()) {
      throw new g("Required field 'value' was not found in serialized data! Struct: " + toString());
    }
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    this.m.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.m.get(0);
  }
  
  public boolean a(e parame)
  {
    if (parame == null) {}
    boolean bool3;
    boolean bool4;
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        do
        {
          return false;
        } while ((this.a != parame.a) || (this.b != parame.b) || (this.c != parame.c));
        bool1 = d();
        bool2 = parame.d();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(parame.d))));
      bool3 = e();
      bool4 = parame.e();
    } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.e.equals(parame.e))));
    return true;
  }
  
  public int b(e parame)
  {
    int n;
    if (!getClass().equals(parame.getClass())) {
      n = getClass().getName().compareTo(parame.getClass().getName());
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
                        n = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parame.a()));
                      } while (n != 0);
                      if (!a()) {
                        break;
                      }
                      n = org.apache.thrift.c.a(this.a, parame.a);
                    } while (n != 0);
                    n = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parame.b()));
                  } while (n != 0);
                  if (!b()) {
                    break;
                  }
                  n = org.apache.thrift.c.a(this.b, parame.b);
                } while (n != 0);
                n = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parame.c()));
              } while (n != 0);
              if (!c()) {
                break;
              }
              n = org.apache.thrift.c.a(this.c, parame.c);
            } while (n != 0);
            n = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parame.d()));
          } while (n != 0);
          if (!d()) {
            break;
          }
          n = org.apache.thrift.c.a(this.d, parame.d);
        } while (n != 0);
        n = Boolean.valueOf(e()).compareTo(Boolean.valueOf(parame.e()));
      } while (n != 0);
      if (!e()) {
        break;
      }
      n = org.apache.thrift.c.a(this.e, parame.e);
    } while (n != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    f();
    paramf.a(g);
    paramf.a(h);
    paramf.a(this.a);
    paramf.b();
    paramf.a(i);
    paramf.a(this.b);
    paramf.b();
    paramf.a(j);
    paramf.a(this.c);
    paramf.b();
    if (this.d != null)
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
  
  public void b(boolean paramBoolean)
  {
    this.m.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.m.get(1);
  }
  
  public void c(boolean paramBoolean)
  {
    this.m.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.m.get(2);
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
    while (!(paramObject instanceof e)) {
      return false;
    }
    return a((e)paramObject);
  }
  
  public void f()
  {
    if (this.d == null) {
      throw new g("Required field 'connpt' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StatsEvent(");
    localStringBuilder.append("chid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("type:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("value:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("connpt:");
    if (this.d == null)
    {
      localStringBuilder.append("null");
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("host:");
        if (this.e != null) {
          break label172;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.d);
      break;
      label172:
      localStringBuilder.append(this.e);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */