package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class c
  implements Serializable, Cloneable, org.apache.thrift.b<c, c.a>
{
  public static final Map<c.a, org.apache.thrift.meta_data.b> i;
  private static final k j = new k("PushMessage");
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("to", (byte)12, (short)1);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("id", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("appId", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("payload", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("createAt", (byte)10, (short)5);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("ttl", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("collapseKey", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)8);
  public g a;
  public String b;
  public String c;
  public String d;
  public long e;
  public long f;
  public String g;
  public String h;
  private BitSet s = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(c.a.class);
    localEnumMap.put(c.a.a, new org.apache.thrift.meta_data.b("to", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(c.a.b, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(c.a.c, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(c.a.d, new org.apache.thrift.meta_data.b("payload", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(c.a.e, new org.apache.thrift.meta_data.b("createAt", (byte)2, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(c.a.f, new org.apache.thrift.meta_data.b("ttl", (byte)2, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(c.a.g, new org.apache.thrift.meta_data.b("collapseKey", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(c.a.h, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(c.class, i);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      l();
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
      if (localc.b == 12)
      {
        this.a = new g();
        this.a.a(paramf);
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
              if (localc.b == 10)
              {
                this.e = paramf.u();
                a(true);
              }
              else
              {
                i.a(paramf, localc.b);
                continue;
                if (localc.b == 10)
                {
                  this.f = paramf.u();
                  b(true);
                }
                else
                {
                  i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 11)
                  {
                    this.g = paramf.w();
                  }
                  else
                  {
                    i.a(paramf, localc.b);
                    continue;
                    if (localc.b == 11) {
                      this.h = paramf.w();
                    } else {
                      i.a(paramf, localc.b);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(c paramc)
  {
    if (paramc == null) {}
    boolean bool15;
    boolean bool16;
    do
    {
      boolean bool13;
      boolean bool14;
      do
      {
        boolean bool11;
        boolean bool12;
        do
        {
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
                    bool2 = paramc.a();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.a(paramc.a))));
                  bool3 = c();
                  bool4 = paramc.c();
                } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.equals(paramc.b))));
                bool5 = d();
                bool6 = paramc.d();
              } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramc.c))));
              bool7 = f();
              bool8 = paramc.f();
            } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramc.d))));
            bool9 = h();
            bool10 = paramc.h();
          } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (this.e != paramc.e)));
          bool11 = i();
          bool12 = paramc.i();
        } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (this.f != paramc.f)));
        bool13 = j();
        bool14 = paramc.j();
      } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramc.g))));
      bool15 = k();
      bool16 = paramc.k();
    } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramc.h))));
    return true;
  }
  
  public int b(c paramc)
  {
    int i1;
    if (!getClass().equals(paramc.getClass())) {
      i1 = getClass().getName().compareTo(paramc.getClass().getName());
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
                                    return i1;
                                    i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramc.a()));
                                  } while (i1 != 0);
                                  if (!a()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.a, paramc.a);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramc.c()));
                              } while (i1 != 0);
                              if (!c()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.b, paramc.b);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramc.d()));
                          } while (i1 != 0);
                          if (!d()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.c, paramc.c);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramc.f()));
                      } while (i1 != 0);
                      if (!f()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.d, paramc.d);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramc.h()));
                  } while (i1 != 0);
                  if (!h()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.e, paramc.e);
                } while (i1 != 0);
                i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramc.i()));
              } while (i1 != 0);
              if (!i()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.f, paramc.f);
            } while (i1 != 0);
            i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramc.j()));
          } while (i1 != 0);
          if (!j()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.g, paramc.g);
        } while (i1 != 0);
        i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramc.k()));
      } while (i1 != 0);
      if (!k()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.h, paramc.h);
    } while (i1 != 0);
    return 0;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(f paramf)
  {
    l();
    paramf.a(j);
    if ((this.a != null) && (a()))
    {
      paramf.a(k);
      this.a.b(paramf);
      paramf.b();
    }
    if (this.b != null)
    {
      paramf.a(l);
      paramf.a(this.b);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(m);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(n);
      paramf.a(this.d);
      paramf.b();
    }
    if (h())
    {
      paramf.a(o);
      paramf.a(this.e);
      paramf.b();
    }
    if (i())
    {
      paramf.a(p);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (j()))
    {
      paramf.a(q);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (k()))
    {
      paramf.a(r);
      paramf.a(this.h);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.s.set(1, paramBoolean);
  }
  
  public boolean c()
  {
    return this.b != null;
  }
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof c)) {
      return false;
    }
    return a((c)paramObject);
  }
  
  public boolean f()
  {
    return this.d != null;
  }
  
  public long g()
  {
    return this.e;
  }
  
  public boolean h()
  {
    return this.s.get(0);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.s.get(1);
  }
  
  public boolean j()
  {
    return this.g != null;
  }
  
  public boolean k()
  {
    return this.h != null;
  }
  
  public void l()
  {
    if (this.b == null) {
      throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new org.apache.thrift.protocol.g("Required field 'payload' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PushMessage(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("to:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.b != null) {
        break label307;
      }
      localStringBuilder.append("null");
      label80:
      localStringBuilder.append(", ");
      localStringBuilder.append("appId:");
      if (this.c != null) {
        break label319;
      }
      localStringBuilder.append("null");
      label111:
      localStringBuilder.append(", ");
      localStringBuilder.append("payload:");
      if (this.d != null) {
        break label331;
      }
      localStringBuilder.append("null");
      label142:
      if (h())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("createAt:");
        localStringBuilder.append(this.e);
      }
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("ttl:");
        localStringBuilder.append(this.f);
      }
      if (j())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("collapseKey:");
        if (this.g != null) {
          break label343;
        }
        localStringBuilder.append("null");
      }
      label244:
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("packageName:");
        if (this.h != null) {
          break label355;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label307:
      localStringBuilder.append(this.b);
      break label80;
      label319:
      localStringBuilder.append(this.c);
      break label111;
      label331:
      localStringBuilder.append(this.d);
      break label142;
      label343:
      localStringBuilder.append(this.g);
      break label244;
      label355:
      localStringBuilder.append(this.h);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */