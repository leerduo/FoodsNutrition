package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.k;

public class j
  implements Serializable, Cloneable, org.apache.thrift.b<j, j.a>
{
  public static final Map<j.a, org.apache.thrift.meta_data.b> l;
  private static final k m = new k("XmPushActionCommandResult");
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("cmdName", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("request", (byte)12, (short)6);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("errorCode", (byte)10, (short)7);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("reason", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.c w = new org.apache.thrift.protocol.c("cmdArgs", (byte)15, (short)10);
  private static final org.apache.thrift.protocol.c x = new org.apache.thrift.protocol.c("category", (byte)11, (short)12);
  public String a;
  public g b;
  public String c;
  public String d;
  public String e;
  public i f;
  public long g;
  public String h;
  public String i;
  public List<String> j;
  public String k;
  private BitSet y = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(j.a.class);
    localEnumMap.put(j.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(j.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(j.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(j.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(j.a.e, new org.apache.thrift.meta_data.b("cmdName", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(j.a.f, new org.apache.thrift.meta_data.b("request", (byte)2, new org.apache.thrift.meta_data.g((byte)12, i.class)));
    localEnumMap.put(j.a.g, new org.apache.thrift.meta_data.b("errorCode", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(j.a.h, new org.apache.thrift.meta_data.b("reason", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(j.a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(j.a.j, new org.apache.thrift.meta_data.b("cmdArgs", (byte)2, new org.apache.thrift.meta_data.d((byte)15, new org.apache.thrift.meta_data.c((byte)11))));
    localEnumMap.put(j.a.k, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    l = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(j.class, l);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!h()) {
        throw new org.apache.thrift.protocol.g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (localc.c)
      {
      case 11: 
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
                  if (localc.b == 12)
                  {
                    this.f = new i();
                    this.f.a(paramf);
                  }
                  else
                  {
                    org.apache.thrift.protocol.i.a(paramf, localc.b);
                    continue;
                    if (localc.b == 10)
                    {
                      this.g = paramf.u();
                      a(true);
                    }
                    else
                    {
                      org.apache.thrift.protocol.i.a(paramf, localc.b);
                      continue;
                      if (localc.b == 11)
                      {
                        this.h = paramf.w();
                      }
                      else
                      {
                        org.apache.thrift.protocol.i.a(paramf, localc.b);
                        continue;
                        if (localc.b == 11)
                        {
                          this.i = paramf.w();
                        }
                        else
                        {
                          org.apache.thrift.protocol.i.a(paramf, localc.b);
                          continue;
                          if (localc.b == 15)
                          {
                            org.apache.thrift.protocol.d locald = paramf.m();
                            this.j = new ArrayList(locald.b);
                            for (int i1 = 0; i1 < locald.b; i1++)
                            {
                              String str = paramf.w();
                              this.j.add(str);
                            }
                            paramf.n();
                          }
                          else
                          {
                            org.apache.thrift.protocol.i.a(paramf, localc.b);
                            continue;
                            if (localc.b == 11) {
                              this.k = paramf.w();
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
        }
      }
    }
    o();
  }
  
  public void a(boolean paramBoolean)
  {
    this.y.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(j paramj)
  {
    if (paramj == null) {}
    boolean bool19;
    boolean bool20;
    do
    {
      boolean bool17;
      boolean bool18;
      do
      {
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
                        bool2 = paramj.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramj.a))));
                      bool3 = b();
                      bool4 = paramj.b();
                    } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramj.b))));
                    bool5 = c();
                    bool6 = paramj.c();
                  } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramj.c))));
                  bool7 = d();
                  bool8 = paramj.d();
                } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramj.d))));
                bool9 = f();
                bool10 = paramj.f();
              } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramj.e))));
              bool11 = g();
              bool12 = paramj.g();
            } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.a(paramj.f)) || (this.g != paramj.g)));
            bool13 = i();
            bool14 = paramj.i();
          } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.h.equals(paramj.h))));
          bool15 = j();
          bool16 = paramj.j();
        } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.i.equals(paramj.i))));
        bool17 = l();
        bool18 = paramj.l();
      } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.j.equals(paramj.j))));
      bool19 = n();
      bool20 = paramj.n();
    } while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.k.equals(paramj.k))));
    return true;
  }
  
  public int b(j paramj)
  {
    int i1;
    if (!getClass().equals(paramj.getClass())) {
      i1 = getClass().getName().compareTo(paramj.getClass().getName());
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
                                                i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramj.a()));
                                              } while (i1 != 0);
                                              if (!a()) {
                                                break;
                                              }
                                              i1 = org.apache.thrift.c.a(this.a, paramj.a);
                                            } while (i1 != 0);
                                            i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramj.b()));
                                          } while (i1 != 0);
                                          if (!b()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.b, paramj.b);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramj.c()));
                                      } while (i1 != 0);
                                      if (!c()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.c, paramj.c);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramj.d()));
                                  } while (i1 != 0);
                                  if (!d()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.d, paramj.d);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramj.f()));
                              } while (i1 != 0);
                              if (!f()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.e, paramj.e);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramj.g()));
                          } while (i1 != 0);
                          if (!g()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.f, paramj.f);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramj.h()));
                      } while (i1 != 0);
                      if (!h()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.g, paramj.g);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramj.i()));
                  } while (i1 != 0);
                  if (!i()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.h, paramj.h);
                } while (i1 != 0);
                i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramj.j()));
              } while (i1 != 0);
              if (!j()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.i, paramj.i);
            } while (i1 != 0);
            i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramj.l()));
          } while (i1 != 0);
          if (!l()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.j, paramj.j);
        } while (i1 != 0);
        i1 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramj.n()));
      } while (i1 != 0);
      if (!n()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.k, paramj.k);
    } while (i1 != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    o();
    paramf.a(m);
    if ((this.a != null) && (a()))
    {
      paramf.a(n);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(o);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(p);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(q);
      paramf.a(this.d);
      paramf.b();
    }
    if (this.e != null)
    {
      paramf.a(r);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (g()))
    {
      paramf.a(s);
      this.f.b(paramf);
      paramf.b();
    }
    paramf.a(t);
    paramf.a(this.g);
    paramf.b();
    if ((this.h != null) && (i()))
    {
      paramf.a(u);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (j()))
    {
      paramf.a(v);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (l()))
    {
      paramf.a(w);
      paramf.a(new org.apache.thrift.protocol.d((byte)11, this.j.size()));
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        paramf.a((String)localIterator.next());
      }
      paramf.e();
      paramf.b();
    }
    if ((this.k != null) && (n()))
    {
      paramf.a(x);
      paramf.a(this.k);
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
  
  public String e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof j)) {
      return false;
    }
    return a((j)paramObject);
  }
  
  public boolean f()
  {
    return this.e != null;
  }
  
  public boolean g()
  {
    return this.f != null;
  }
  
  public boolean h()
  {
    return this.y.get(0);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.h != null;
  }
  
  public boolean j()
  {
    return this.i != null;
  }
  
  public List<String> k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return this.j != null;
  }
  
  public String m()
  {
    return this.k;
  }
  
  public boolean n()
  {
    return this.k != null;
  }
  
  public void o()
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionCommandResult(");
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
        break label536;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label426;
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
          break label452;
        }
        localStringBuilder.append("null");
        label155:
        localStringBuilder.append(", ");
        localStringBuilder.append("cmdName:");
        if (this.e != null) {
          break label464;
        }
        localStringBuilder.append("null");
        label186:
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.f != null) {
            break label476;
          }
          localStringBuilder.append("null");
        }
        label224:
        localStringBuilder.append(", ");
        localStringBuilder.append("errorCode:");
        localStringBuilder.append(this.g);
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.h != null) {
            break label488;
          }
          localStringBuilder.append("null");
        }
        label287:
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label500;
          }
          localStringBuilder.append("null");
        }
        label325:
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("cmdArgs:");
          if (this.j != null) {
            break label512;
          }
          localStringBuilder.append("null");
        }
        label363:
        if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.k != null) {
            break label524;
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
        label426:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label452:
        localStringBuilder.append(this.d);
        break label155;
        label464:
        localStringBuilder.append(this.e);
        break label186;
        label476:
        localStringBuilder.append(this.f);
        break label224;
        label488:
        localStringBuilder.append(this.h);
        break label287;
        label500:
        localStringBuilder.append(this.i);
        break label325;
        label512:
        localStringBuilder.append(this.j);
        break label363;
        label524:
        localStringBuilder.append(this.k);
      }
      label536:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */