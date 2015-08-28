package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class p
  implements Serializable, Cloneable, org.apache.thrift.b<p, p.a>
{
  public static final Map<p.a, org.apache.thrift.meta_data.b> i;
  private static final k j = new k("XmPushActionSendFeedbackResult");
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("request", (byte)12, (short)5);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("errorCode", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("reason", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("category", (byte)11, (short)8);
  public String a;
  public g b;
  public String c;
  public String d;
  public o e;
  public long f;
  public String g;
  public String h;
  private BitSet s = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(p.a.class);
    localEnumMap.put(p.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(p.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(p.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(p.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(p.a.e, new org.apache.thrift.meta_data.b("request", (byte)2, new org.apache.thrift.meta_data.g((byte)12, o.class)));
    localEnumMap.put(p.a.f, new org.apache.thrift.meta_data.b("errorCode", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(p.a.g, new org.apache.thrift.meta_data.b("reason", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(p.a.h, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(p.class, i);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!f()) {
        throw new org.apache.thrift.protocol.g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
        if (localc.b == 11)
        {
          this.a = paramf.w();
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 12)
          {
            this.b = new g();
            this.b.a(paramf);
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
                if (localc.b == 12)
                {
                  this.e = new o();
                  this.e.a(paramf);
                }
                else
                {
                  i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 10)
                  {
                    this.f = paramf.u();
                    a(true);
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
    i();
  }
  
  public void a(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(p paramp)
  {
    if (paramp == null) {}
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
                  bool2 = paramp.a();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramp.a))));
                bool3 = b();
                bool4 = paramp.b();
              } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramp.b))));
              bool5 = c();
              bool6 = paramp.c();
            } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramp.c))));
            bool7 = d();
            bool8 = paramp.d();
          } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramp.d))));
          bool9 = e();
          bool10 = paramp.e();
        } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.a(paramp.e)) || (this.f != paramp.f)));
        bool11 = g();
        bool12 = paramp.g();
      } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(paramp.g))));
      bool13 = h();
      bool14 = paramp.h();
    } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.h.equals(paramp.h))));
    return true;
  }
  
  public int b(p paramp)
  {
    int i1;
    if (!getClass().equals(paramp.getClass())) {
      i1 = getClass().getName().compareTo(paramp.getClass().getName());
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
                                    i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramp.a()));
                                  } while (i1 != 0);
                                  if (!a()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.a, paramp.a);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramp.b()));
                              } while (i1 != 0);
                              if (!b()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.b, paramp.b);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramp.c()));
                          } while (i1 != 0);
                          if (!c()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.c, paramp.c);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramp.d()));
                      } while (i1 != 0);
                      if (!d()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.d, paramp.d);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramp.e()));
                  } while (i1 != 0);
                  if (!e()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.e, paramp.e);
                } while (i1 != 0);
                i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramp.f()));
              } while (i1 != 0);
              if (!f()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.f, paramp.f);
            } while (i1 != 0);
            i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramp.g()));
          } while (i1 != 0);
          if (!g()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.g, paramp.g);
        } while (i1 != 0);
        i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramp.h()));
      } while (i1 != 0);
      if (!h()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.h, paramp.h);
    } while (i1 != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    i();
    paramf.a(j);
    if ((this.a != null) && (a()))
    {
      paramf.a(k);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(l);
      this.b.b(paramf);
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
    if ((this.e != null) && (e()))
    {
      paramf.a(o);
      this.e.b(paramf);
      paramf.b();
    }
    paramf.a(p);
    paramf.a(this.f);
    paramf.b();
    if ((this.g != null) && (g()))
    {
      paramf.a(q);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (h()))
    {
      paramf.a(r);
      paramf.a(this.h);
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
    while (!(paramObject instanceof p)) {
      return false;
    }
    return a((p)paramObject);
  }
  
  public boolean f()
  {
    return this.s.get(0);
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public boolean h()
  {
    return this.h != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public void i()
  {
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSendFeedbackResult(");
    int i2 = 1;
    if (a())
    {
      localStringBuilder.append("debug:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      if (!b()) {
        break label393;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label319;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      label89:
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.c == null)
      {
        localStringBuilder.append("null");
        label124:
        localStringBuilder.append(", ");
        localStringBuilder.append("appId:");
        if (this.d != null) {
          break label345;
        }
        localStringBuilder.append("null");
        label155:
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null) {
            break label357;
          }
          localStringBuilder.append("null");
        }
        label193:
        localStringBuilder.append(", ");
        localStringBuilder.append("errorCode:");
        localStringBuilder.append(this.f);
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.g != null) {
            break label369;
          }
          localStringBuilder.append("null");
        }
        label256:
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.h != null) {
            break label381;
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
        label319:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label345:
        localStringBuilder.append(this.d);
        break label155;
        label357:
        localStringBuilder.append(this.e);
        break label193;
        label369:
        localStringBuilder.append(this.g);
        break label256;
        label381:
        localStringBuilder.append(this.h);
      }
      label393:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.p
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */