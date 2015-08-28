package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class g
  implements Serializable, Cloneable, org.apache.thrift.b<g, g.a>
{
  public static final Map<g.a, org.apache.thrift.meta_data.b> f;
  private static final k g = new k("Target");
  private static final org.apache.thrift.protocol.c h = new org.apache.thrift.protocol.c("channelId", (byte)10, (short)1);
  private static final org.apache.thrift.protocol.c i = new org.apache.thrift.protocol.c("userId", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.c j = new org.apache.thrift.protocol.c("server", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("resource", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("isPreview", (byte)2, (short)5);
  public long a = 5L;
  public String b;
  public String c = "xiaomi.com";
  public String d = "";
  public boolean e = false;
  private BitSet m = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(g.a.class);
    localEnumMap.put(g.a.a, new org.apache.thrift.meta_data.b("channelId", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(g.a.b, new org.apache.thrift.meta_data.b("userId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(g.a.c, new org.apache.thrift.meta_data.b("server", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(g.a.d, new org.apache.thrift.meta_data.b("resource", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(g.a.e, new org.apache.thrift.meta_data.b("isPreview", (byte)2, new org.apache.thrift.meta_data.c((byte)2)));
    f = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(g.class, f);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!a()) {
        throw new org.apache.thrift.protocol.g("Required field 'channelId' was not found in serialized data! Struct: " + toString());
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
                if (localc.b == 2)
                {
                  this.e = paramf.q();
                  b(true);
                }
                else
                {
                  i.a(paramf, localc.b);
                }
              }
            }
          }
        }
      }
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
  
  public boolean a(g paramg)
  {
    if (paramg == null) {}
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
            do
            {
              return false;
            } while (this.a != paramg.a);
            bool1 = b();
            bool2 = paramg.b();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramg.b))));
          bool3 = c();
          bool4 = paramg.c();
        } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.c.equals(paramg.c))));
        bool5 = d();
        bool6 = paramg.d();
      } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.d.equals(paramg.d))));
      bool7 = e();
      bool8 = paramg.e();
    } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (this.e != paramg.e)));
    return true;
  }
  
  public int b(g paramg)
  {
    int n;
    if (!getClass().equals(paramg.getClass())) {
      n = getClass().getName().compareTo(paramg.getClass().getName());
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
                        n = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramg.a()));
                      } while (n != 0);
                      if (!a()) {
                        break;
                      }
                      n = org.apache.thrift.c.a(this.a, paramg.a);
                    } while (n != 0);
                    n = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramg.b()));
                  } while (n != 0);
                  if (!b()) {
                    break;
                  }
                  n = org.apache.thrift.c.a(this.b, paramg.b);
                } while (n != 0);
                n = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramg.c()));
              } while (n != 0);
              if (!c()) {
                break;
              }
              n = org.apache.thrift.c.a(this.c, paramg.c);
            } while (n != 0);
            n = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramg.d()));
          } while (n != 0);
          if (!d()) {
            break;
          }
          n = org.apache.thrift.c.a(this.d, paramg.d);
        } while (n != 0);
        n = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramg.e()));
      } while (n != 0);
      if (!e()) {
        break;
      }
      n = org.apache.thrift.c.a(this.e, paramg.e);
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
    if (this.b != null)
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
    if (e())
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
    return this.m.get(1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof g)) {
      return false;
    }
    return a((g)paramObject);
  }
  
  public void f()
  {
    if (this.b == null) {
      throw new org.apache.thrift.protocol.g("Required field 'userId' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Target(");
    localStringBuilder.append("channelId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("userId:");
    if (this.b == null)
    {
      localStringBuilder.append("null");
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("server:");
        if (this.c != null) {
          break label192;
        }
        localStringBuilder.append("null");
      }
      label97:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("resource:");
        if (this.d != null) {
          break label204;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("isPreview:");
        localStringBuilder.append(this.e);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label192:
      localStringBuilder.append(this.c);
      break label97;
      label204:
      localStringBuilder.append(this.d);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */