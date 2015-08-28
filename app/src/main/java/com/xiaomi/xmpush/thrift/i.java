package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.k;

public class i
  implements Serializable, Cloneable, org.apache.thrift.b<i, i.a>
{
  public static final Map<i.a, org.apache.thrift.meta_data.b> i;
  private static final k j = new k("XmPushActionCommand");
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("cmdName", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("cmdArgs", (byte)15, (short)6);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("category", (byte)11, (short)9);
  public String a;
  public g b;
  public String c;
  public String d;
  public String e;
  public List<String> f;
  public String g;
  public String h;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(i.a.class);
    localEnumMap.put(i.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(i.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(i.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(i.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(i.a.e, new org.apache.thrift.meta_data.b("cmdName", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(i.a.f, new org.apache.thrift.meta_data.b("cmdArgs", (byte)2, new org.apache.thrift.meta_data.d((byte)15, new org.apache.thrift.meta_data.c((byte)11))));
    localEnumMap.put(i.a.g, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(i.a.h, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(i.class, i);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      i();
      return;
    }
    switch (localc.c)
    {
    case 8: 
    default: 
      org.apache.thrift.protocol.i.a(paramf, localc.b);
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
        org.apache.thrift.protocol.i.a(paramf, localc.b);
        continue;
        if (localc.b == 12)
        {
          this.b = new g();
          this.b.a(paramf);
        }
        else
        {
          org.apache.thrift.protocol.i.a(paramf, localc.b);
          continue;
          if (localc.b == 11)
          {
            this.c = paramf.w();
          }
          else
          {
            org.apache.thrift.protocol.i.a(paramf, localc.b);
            continue;
            if (localc.b == 11)
            {
              this.d = paramf.w();
            }
            else
            {
              org.apache.thrift.protocol.i.a(paramf, localc.b);
              continue;
              if (localc.b == 11)
              {
                this.e = paramf.w();
              }
              else
              {
                org.apache.thrift.protocol.i.a(paramf, localc.b);
                continue;
                if (localc.b == 15)
                {
                  org.apache.thrift.protocol.d locald = paramf.m();
                  this.f = new ArrayList(locald.b);
                  for (int i1 = 0; i1 < locald.b; i1++)
                  {
                    String str = paramf.w();
                    this.f.add(str);
                  }
                  paramf.n();
                }
                else
                {
                  org.apache.thrift.protocol.i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 11)
                  {
                    this.g = paramf.w();
                  }
                  else
                  {
                    org.apache.thrift.protocol.i.a(paramf, localc.b);
                    continue;
                    if (localc.b == 11) {
                      this.h = paramf.w();
                    } else {
                      org.apache.thrift.protocol.i.a(paramf, localc.b);
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(i parami)
  {
    if (parami == null) {}
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
                    bool2 = parami.a();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(parami.a))));
                  bool3 = b();
                  bool4 = parami.b();
                } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(parami.b))));
                bool5 = c();
                bool6 = parami.c();
              } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(parami.c))));
              bool7 = d();
              bool8 = parami.d();
            } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(parami.d))));
            bool9 = e();
            bool10 = parami.e();
          } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(parami.e))));
          bool11 = f();
          bool12 = parami.f();
        } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(parami.f))));
        bool13 = g();
        bool14 = parami.g();
      } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(parami.g))));
      bool15 = h();
      bool16 = parami.h();
    } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(parami.h))));
    return true;
  }
  
  public int b(i parami)
  {
    int i1;
    if (!getClass().equals(parami.getClass())) {
      i1 = getClass().getName().compareTo(parami.getClass().getName());
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
                                    i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parami.a()));
                                  } while (i1 != 0);
                                  if (!a()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.a, parami.a);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parami.b()));
                              } while (i1 != 0);
                              if (!b()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.b, parami.b);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parami.c()));
                          } while (i1 != 0);
                          if (!c()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.c, parami.c);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parami.d()));
                      } while (i1 != 0);
                      if (!d()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.d, parami.d);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(parami.e()));
                  } while (i1 != 0);
                  if (!e()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.e, parami.e);
                } while (i1 != 0);
                i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(parami.f()));
              } while (i1 != 0);
              if (!f()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.f, parami.f);
            } while (i1 != 0);
            i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(parami.g()));
          } while (i1 != 0);
          if (!g()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.g, parami.g);
        } while (i1 != 0);
        i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(parami.h()));
      } while (i1 != 0);
      if (!h()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.h, parami.h);
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
    if (this.e != null)
    {
      paramf.a(o);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (f()))
    {
      paramf.a(p);
      paramf.a(new org.apache.thrift.protocol.d((byte)11, this.f.size()));
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        paramf.a((String)localIterator.next());
      }
      paramf.e();
      paramf.b();
    }
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
    while (!(paramObject instanceof i)) {
      return false;
    }
    return a((i)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
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
    if (this.e == null) {
      throw new org.apache.thrift.protocol.g("Required field 'cmdName' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionCommand(");
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
        break label411;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label325;
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
          break label351;
        }
        localStringBuilder.append("null");
        label155:
        localStringBuilder.append(", ");
        localStringBuilder.append("cmdName:");
        if (this.e != null) {
          break label363;
        }
        localStringBuilder.append("null");
        label186:
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("cmdArgs:");
          if (this.f != null) {
            break label375;
          }
          localStringBuilder.append("null");
        }
        label224:
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.g != null) {
            break label387;
          }
          localStringBuilder.append("null");
        }
        label262:
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.h != null) {
            break label399;
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
        label325:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label351:
        localStringBuilder.append(this.d);
        break label155;
        label363:
        localStringBuilder.append(this.e);
        break label186;
        label375:
        localStringBuilder.append(this.f);
        break label224;
        label387:
        localStringBuilder.append(this.g);
        break label262;
        label399:
        localStringBuilder.append(this.h);
      }
      label411:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */