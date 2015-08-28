package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class l
  implements Serializable, Cloneable, org.apache.thrift.b<l, l.a>
{
  public static final Map<l.a, org.apache.thrift.meta_data.b> k;
  private static final k l = new k("XmPushActionNotification");
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("type", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("requireAck", (byte)2, (short)6);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("payload", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("extra", (byte)13, (short)8);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("category", (byte)11, (short)10);
  public String a;
  public g b;
  public String c;
  public String d;
  public String e;
  public boolean f = true;
  public String g;
  public Map<String, String> h;
  public String i;
  public String j;
  private BitSet w = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(l.a.class);
    localEnumMap.put(l.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(l.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(l.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(l.a.d, new org.apache.thrift.meta_data.b("appId", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(l.a.e, new org.apache.thrift.meta_data.b("type", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(l.a.f, new org.apache.thrift.meta_data.b("requireAck", (byte)1, new org.apache.thrift.meta_data.c((byte)2)));
    localEnumMap.put(l.a.g, new org.apache.thrift.meta_data.b("payload", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(l.a.h, new org.apache.thrift.meta_data.b("extra", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new org.apache.thrift.meta_data.c((byte)11), new org.apache.thrift.meta_data.c((byte)11))));
    localEnumMap.put(l.a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(l.a.j, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(l.class, k);
  }
  
  public l a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public l a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    b(true);
    return this;
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!f()) {
        throw new org.apache.thrift.protocol.g("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
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
                if (localc.b == 11)
                {
                  this.e = paramf.w();
                }
                else
                {
                  i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 2)
                  {
                    this.f = paramf.q();
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
                      if (localc.b == 13)
                      {
                        org.apache.thrift.protocol.e locale = paramf.k();
                        this.h = new HashMap(2 * locale.c);
                        for (int i1 = 0; i1 < locale.c; i1++)
                        {
                          String str1 = paramf.w();
                          String str2 = paramf.w();
                          this.h.put(str1, str2);
                        }
                        paramf.l();
                      }
                      else
                      {
                        i.a(paramf, localc.b);
                        continue;
                        if (localc.b == 11)
                        {
                          this.i = paramf.w();
                        }
                        else
                        {
                          i.a(paramf, localc.b);
                          continue;
                          if (localc.b == 11) {
                            this.j = paramf.w();
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
      }
    }
    l();
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(l paraml)
  {
    if (paraml == null) {}
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
                      bool2 = paraml.a();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paraml.a))));
                    bool3 = b();
                    bool4 = paraml.b();
                  } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paraml.b))));
                  bool5 = c();
                  bool6 = paraml.c();
                } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paraml.c))));
                bool7 = d();
                bool8 = paraml.d();
              } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paraml.d))));
              bool9 = e();
              bool10 = paraml.e();
            } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paraml.e)) || (this.f != paraml.f)));
            bool11 = g();
            bool12 = paraml.g();
          } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(paraml.g))));
          bool13 = i();
          bool14 = paraml.i();
        } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.h.equals(paraml.h))));
        bool15 = j();
        bool16 = paraml.j();
      } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.i.equals(paraml.i))));
      bool17 = k();
      bool18 = paraml.k();
    } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.j.equals(paraml.j))));
    return true;
  }
  
  public int b(l paraml)
  {
    int i1;
    if (!getClass().equals(paraml.getClass())) {
      i1 = getClass().getName().compareTo(paraml.getClass().getName());
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
                                            return i1;
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paraml.a()));
                                          } while (i1 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.a, paraml.a);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paraml.b()));
                                      } while (i1 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.b, paraml.b);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paraml.c()));
                                  } while (i1 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.c, paraml.c);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paraml.d()));
                              } while (i1 != 0);
                              if (!d()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.d, paraml.d);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paraml.e()));
                          } while (i1 != 0);
                          if (!e()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.e, paraml.e);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paraml.f()));
                      } while (i1 != 0);
                      if (!f()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.f, paraml.f);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paraml.g()));
                  } while (i1 != 0);
                  if (!g()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.g, paraml.g);
                } while (i1 != 0);
                i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paraml.i()));
              } while (i1 != 0);
              if (!i()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.h, paraml.h);
            } while (i1 != 0);
            i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paraml.j()));
          } while (i1 != 0);
          if (!j()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.i, paraml.i);
        } while (i1 != 0);
        i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paraml.k()));
      } while (i1 != 0);
      if (!k()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.j, paraml.j);
    } while (i1 != 0);
    return 0;
  }
  
  public l b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void b(f paramf)
  {
    l();
    paramf.a(l);
    if ((this.a != null) && (a()))
    {
      paramf.a(m);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(n);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(o);
      paramf.a(this.c);
      paramf.b();
    }
    if ((this.d != null) && (d()))
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(q);
      paramf.a(this.e);
      paramf.b();
    }
    paramf.a(r);
    paramf.a(this.f);
    paramf.b();
    if ((this.g != null) && (g()))
    {
      paramf.a(s);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (i()))
    {
      paramf.a(t);
      paramf.a(new org.apache.thrift.protocol.e((byte)11, (byte)11, this.h.size()));
      Iterator localIterator = this.h.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramf.a((String)localEntry.getKey());
        paramf.a((String)localEntry.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.i != null) && (j()))
    {
      paramf.a(u);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (k()))
    {
      paramf.a(v);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public l c(String paramString)
  {
    this.e = paramString;
    return this;
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
    while (!(paramObject instanceof l)) {
      return false;
    }
    return a((l)paramObject);
  }
  
  public boolean f()
  {
    return this.w.get(0);
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public Map<String, String> h()
  {
    return this.h;
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
  
  public boolean k()
  {
    return this.j != null;
  }
  
  public void l()
  {
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionNotification(");
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
        break label500;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label402;
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
        if (d())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appId:");
          if (this.d != null) {
            break label428;
          }
          localStringBuilder.append("null");
        }
        label162:
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("type:");
          if (this.e != null) {
            break label440;
          }
          localStringBuilder.append("null");
        }
        label200:
        localStringBuilder.append(", ");
        localStringBuilder.append("requireAck:");
        localStringBuilder.append(this.f);
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("payload:");
          if (this.g != null) {
            break label452;
          }
          localStringBuilder.append("null");
        }
        label263:
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("extra:");
          if (this.h != null) {
            break label464;
          }
          localStringBuilder.append("null");
        }
        label301:
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label476;
          }
          localStringBuilder.append("null");
        }
        label339:
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.j != null) {
            break label488;
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
        label402:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label428:
        localStringBuilder.append(this.d);
        break label162;
        label440:
        localStringBuilder.append(this.e);
        break label200;
        label452:
        localStringBuilder.append(this.g);
        break label263;
        label464:
        localStringBuilder.append(this.h);
        break label301;
        label476:
        localStringBuilder.append(this.i);
        break label339;
        label488:
        localStringBuilder.append(this.j);
      }
      label500:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */