package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class r
  implements Serializable, Cloneable, org.apache.thrift.b<r, r.a>
{
  public static final Map<r.a, org.apache.thrift.meta_data.b> h;
  private static final k i = new k("XmPushActionSubscription");
  private static final org.apache.thrift.protocol.c j = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("topic", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("category", (byte)11, (short)7);
  public String a;
  public g b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(r.a.class);
    localEnumMap.put(r.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(r.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(r.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(r.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(r.a.e, new org.apache.thrift.meta_data.b("topic", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(r.a.f, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(r.a.g, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    h = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(r.class, h);
  }
  
  public r a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      h();
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
              if (localc.b == 11)
              {
                this.e = paramf.w();
              }
              else
              {
                i.a(paramf, localc.b);
                continue;
                if (localc.b == 11)
                {
                  this.f = paramf.w();
                }
                else
                {
                  i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 11) {
                    this.g = paramf.w();
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(r paramr)
  {
    if (paramr == null) {}
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
                  bool2 = paramr.a();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramr.a))));
                bool3 = b();
                bool4 = paramr.b();
              } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramr.b))));
              bool5 = c();
              bool6 = paramr.c();
            } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramr.c))));
            bool7 = d();
            bool8 = paramr.d();
          } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramr.d))));
          bool9 = e();
          bool10 = paramr.e();
        } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramr.e))));
        bool11 = f();
        bool12 = paramr.f();
      } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramr.f))));
      bool13 = g();
      bool14 = paramr.g();
    } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramr.g))));
    return true;
  }
  
  public int b(r paramr)
  {
    int i1;
    if (!getClass().equals(paramr.getClass())) {
      i1 = getClass().getName().compareTo(paramr.getClass().getName());
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
                                return i1;
                                i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramr.a()));
                              } while (i1 != 0);
                              if (!a()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.a, paramr.a);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramr.b()));
                          } while (i1 != 0);
                          if (!b()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.b, paramr.b);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramr.c()));
                      } while (i1 != 0);
                      if (!c()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.c, paramr.c);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramr.d()));
                  } while (i1 != 0);
                  if (!d()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.d, paramr.d);
                } while (i1 != 0);
                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramr.e()));
              } while (i1 != 0);
              if (!e()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.e, paramr.e);
            } while (i1 != 0);
            i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramr.f()));
          } while (i1 != 0);
          if (!f()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.f, paramr.f);
        } while (i1 != 0);
        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramr.g()));
      } while (i1 != 0);
      if (!g()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.g, paramr.g);
    } while (i1 != 0);
    return 0;
  }
  
  public r b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void b(f paramf)
  {
    h();
    paramf.a(i);
    if ((this.a != null) && (a()))
    {
      paramf.a(j);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(k);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(l);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(m);
      paramf.a(this.d);
      paramf.b();
    }
    if (this.e != null)
    {
      paramf.a(n);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (f()))
    {
      paramf.a(o);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (g()))
    {
      paramf.a(p);
      paramf.a(this.g);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public r c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public r d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public r e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof r)) {
      return false;
    }
    return a((r)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public void h()
  {
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
    }
    if (this.e == null) {
      throw new org.apache.thrift.protocol.g("Required field 'topic' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSubscription(");
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
        break label361;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label287;
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
          break label313;
        }
        localStringBuilder.append("null");
        label155:
        localStringBuilder.append(", ");
        localStringBuilder.append("topic:");
        if (this.e != null) {
          break label325;
        }
        localStringBuilder.append("null");
        label186:
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.f != null) {
            break label337;
          }
          localStringBuilder.append("null");
        }
        label224:
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.g != null) {
            break label349;
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
        label287:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label313:
        localStringBuilder.append(this.d);
        break label155;
        label325:
        localStringBuilder.append(this.e);
        break label186;
        label337:
        localStringBuilder.append(this.f);
        break label224;
        label349:
        localStringBuilder.append(this.g);
      }
      label361:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.r
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */