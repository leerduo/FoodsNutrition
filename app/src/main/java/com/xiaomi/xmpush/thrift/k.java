package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;

public class k
  implements Serializable, Cloneable, org.apache.thrift.b<k, k.a>
{
  public static final Map<k.a, org.apache.thrift.meta_data.b> i;
  private static final org.apache.thrift.protocol.k j = new org.apache.thrift.protocol.k("XmPushActionContainer");
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("action", (byte)8, (short)1);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("encryptAction", (byte)2, (short)2);
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("isRequest", (byte)2, (short)3);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("pushAction", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("appid", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("target", (byte)12, (short)7);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("metaInfo", (byte)12, (short)8);
  public a a;
  public boolean b = true;
  public boolean c = true;
  public ByteBuffer d;
  public String e;
  public String f;
  public g g;
  public d h;
  private BitSet s = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(k.a.class);
    localEnumMap.put(k.a.a, new org.apache.thrift.meta_data.b("action", (byte)1, new org.apache.thrift.meta_data.a((byte)16, a.class)));
    localEnumMap.put(k.a.b, new org.apache.thrift.meta_data.b("encryptAction", (byte)1, new org.apache.thrift.meta_data.c((byte)2)));
    localEnumMap.put(k.a.c, new org.apache.thrift.meta_data.b("isRequest", (byte)1, new org.apache.thrift.meta_data.c((byte)2)));
    localEnumMap.put(k.a.d, new org.apache.thrift.meta_data.b("pushAction", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(k.a.e, new org.apache.thrift.meta_data.b("appid", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(k.a.f, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(k.a.g, new org.apache.thrift.meta_data.b("target", (byte)1, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(k.a.h, new org.apache.thrift.meta_data.b("metaInfo", (byte)2, new org.apache.thrift.meta_data.g((byte)12, d.class)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(k.class, i);
  }
  
  public a a()
  {
    return this.a;
  }
  
  public k a(a parama)
  {
    this.a = parama;
    return this;
  }
  
  public k a(d paramd)
  {
    this.h = paramd;
    return this;
  }
  
  public k a(g paramg)
  {
    this.g = paramg;
    return this;
  }
  
  public k a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public k a(ByteBuffer paramByteBuffer)
  {
    this.d = paramByteBuffer;
    return this;
  }
  
  public k a(boolean paramBoolean)
  {
    this.b = paramBoolean;
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
      if (!d()) {
        throw new org.apache.thrift.protocol.g("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
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
        if (localc.b == 8)
        {
          this.a = a.a(paramf.t());
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 2)
          {
            this.b = paramf.q();
            b(true);
          }
          else
          {
            i.a(paramf, localc.b);
            continue;
            if (localc.b == 2)
            {
              this.c = paramf.q();
              d(true);
            }
            else
            {
              i.a(paramf, localc.b);
              continue;
              if (localc.b == 11)
              {
                this.d = paramf.x();
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
                    if (localc.b == 12)
                    {
                      this.g = new g();
                      this.g.a(paramf);
                    }
                    else
                    {
                      i.a(paramf, localc.b);
                      continue;
                      if (localc.b == 12)
                      {
                        this.h = new d();
                        this.h.a(paramf);
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
        }
      }
    }
    if (!e()) {
      throw new org.apache.thrift.protocol.g("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
    }
    o();
  }
  
  public boolean a(k paramk)
  {
    if (paramk == null) {}
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
                bool1 = b();
                bool2 = paramk.b();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramk.a)) || (this.b != paramk.b) || (this.c != paramk.c)));
              bool3 = g();
              bool4 = paramk.g();
            } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.d.equals(paramk.d))));
            bool5 = i();
            bool6 = paramk.i();
          } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.e.equals(paramk.e))));
          bool7 = k();
          bool8 = paramk.k();
        } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.f.equals(paramk.f))));
        bool9 = l();
        bool10 = paramk.l();
      } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.g.a(paramk.g))));
      bool11 = n();
      bool12 = paramk.n();
    } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.h.a(paramk.h))));
    return true;
  }
  
  public int b(k paramk)
  {
    int i1;
    if (!getClass().equals(paramk.getClass())) {
      i1 = getClass().getName().compareTo(paramk.getClass().getName());
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
                                    i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramk.b()));
                                  } while (i1 != 0);
                                  if (!b()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.a, paramk.a);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramk.d()));
                              } while (i1 != 0);
                              if (!d()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.b, paramk.b);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramk.e()));
                          } while (i1 != 0);
                          if (!e()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.c, paramk.c);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramk.g()));
                      } while (i1 != 0);
                      if (!g()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.d, paramk.d);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramk.i()));
                  } while (i1 != 0);
                  if (!i()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.e, paramk.e);
                } while (i1 != 0);
                i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramk.k()));
              } while (i1 != 0);
              if (!k()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.f, paramk.f);
            } while (i1 != 0);
            i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramk.l()));
          } while (i1 != 0);
          if (!l()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.g, paramk.g);
        } while (i1 != 0);
        i1 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramk.n()));
      } while (i1 != 0);
      if (!n()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.h, paramk.h);
    } while (i1 != 0);
    return 0;
  }
  
  public k b(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void b(f paramf)
  {
    o();
    paramf.a(j);
    if (this.a != null)
    {
      paramf.a(k);
      paramf.a(this.a.a());
      paramf.b();
    }
    paramf.a(l);
    paramf.a(this.b);
    paramf.b();
    paramf.a(m);
    paramf.a(this.c);
    paramf.b();
    if (this.d != null)
    {
      paramf.a(n);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (i()))
    {
      paramf.a(o);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (k()))
    {
      paramf.a(p);
      paramf.a(this.f);
      paramf.b();
    }
    if (this.g != null)
    {
      paramf.a(q);
      this.g.b(paramf);
      paramf.b();
    }
    if ((this.h != null) && (n()))
    {
      paramf.a(r);
      this.h.b(paramf);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.a != null;
  }
  
  public k c(boolean paramBoolean)
  {
    this.c = paramBoolean;
    d(true);
    return this;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public void d(boolean paramBoolean)
  {
    this.s.set(1, paramBoolean);
  }
  
  public boolean d()
  {
    return this.s.get(0);
  }
  
  public boolean e()
  {
    return this.s.get(1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof k)) {
      return false;
    }
    return a((k)paramObject);
  }
  
  public byte[] f()
  {
    a(org.apache.thrift.c.c(this.d));
    return this.d.array();
  }
  
  public boolean g()
  {
    return this.d != null;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.e != null;
  }
  
  public String j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.f != null;
  }
  
  public boolean l()
  {
    return this.g != null;
  }
  
  public d m()
  {
    return this.h;
  }
  
  public boolean n()
  {
    return this.h != null;
  }
  
  public void o()
  {
    if (this.a == null) {
      throw new org.apache.thrift.protocol.g("Required field 'action' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new org.apache.thrift.protocol.g("Required field 'pushAction' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new org.apache.thrift.protocol.g("Required field 'target' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionContainer(");
    localStringBuilder.append("action:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("encryptAction:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("isRequest:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", ");
      localStringBuilder.append("pushAction:");
      if (this.d != null) {
        break label285;
      }
      localStringBuilder.append("null");
      label115:
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("appid:");
        if (this.e != null) {
          break label296;
        }
        localStringBuilder.append("null");
      }
      label153:
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("packageName:");
        if (this.f != null) {
          break label308;
        }
        localStringBuilder.append("null");
      }
      label191:
      localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.g != null) {
        break label320;
      }
      localStringBuilder.append("null");
      label222:
      if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("metaInfo:");
        if (this.h != null) {
          break label332;
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
      label285:
      org.apache.thrift.c.a(this.d, localStringBuilder);
      break label115;
      label296:
      localStringBuilder.append(this.e);
      break label153;
      label308:
      localStringBuilder.append(this.f);
      break label191;
      label320:
      localStringBuilder.append(this.g);
      break label222;
      label332:
      localStringBuilder.append(this.h);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.k
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */