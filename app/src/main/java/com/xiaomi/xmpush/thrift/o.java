package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
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

public class o
  implements Serializable, Cloneable, org.apache.thrift.b<o, o.a>
{
  public static final Map<o.a, org.apache.thrift.meta_data.b> g;
  private static final k h = new k("XmPushActionSendFeedback");
  private static final org.apache.thrift.protocol.c i = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c j = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("feedbacks", (byte)13, (short)5);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("category", (byte)11, (short)6);
  public String a;
  public g b;
  public String c;
  public String d;
  public Map<String, String> e;
  public String f;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(o.a.class);
    localEnumMap.put(o.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(o.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(o.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(o.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(o.a.e, new org.apache.thrift.meta_data.b("feedbacks", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new org.apache.thrift.meta_data.c((byte)11), new org.apache.thrift.meta_data.c((byte)11))));
    localEnumMap.put(o.a.f, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    g = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(o.class, g);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      g();
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
              if (localc.b == 13)
              {
                org.apache.thrift.protocol.e locale = paramf.k();
                this.e = new HashMap(2 * locale.c);
                for (int i1 = 0; i1 < locale.c; i1++)
                {
                  String str1 = paramf.w();
                  String str2 = paramf.w();
                  this.e.put(str1, str2);
                }
                paramf.l();
              }
              else
              {
                i.a(paramf, localc.b);
                continue;
                if (localc.b == 11) {
                  this.f = paramf.w();
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(o paramo)
  {
    if (paramo == null) {}
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
                bool2 = paramo.a();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramo.a))));
              bool3 = b();
              bool4 = paramo.b();
            } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramo.b))));
            bool5 = c();
            bool6 = paramo.c();
          } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramo.c))));
          bool7 = d();
          bool8 = paramo.d();
        } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramo.d))));
        bool9 = e();
        bool10 = paramo.e();
      } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramo.e))));
      bool11 = f();
      bool12 = paramo.f();
    } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramo.f))));
    return true;
  }
  
  public int b(o paramo)
  {
    int i1;
    if (!getClass().equals(paramo.getClass())) {
      i1 = getClass().getName().compareTo(paramo.getClass().getName());
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
                            return i1;
                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramo.a()));
                          } while (i1 != 0);
                          if (!a()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.a, paramo.a);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramo.b()));
                      } while (i1 != 0);
                      if (!b()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.b, paramo.b);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramo.c()));
                  } while (i1 != 0);
                  if (!c()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.c, paramo.c);
                } while (i1 != 0);
                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramo.d()));
              } while (i1 != 0);
              if (!d()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.d, paramo.d);
            } while (i1 != 0);
            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramo.e()));
          } while (i1 != 0);
          if (!e()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.e, paramo.e);
        } while (i1 != 0);
        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramo.f()));
      } while (i1 != 0);
      if (!f()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.f, paramo.f);
    } while (i1 != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    g();
    paramf.a(h);
    if ((this.a != null) && (a()))
    {
      paramf.a(i);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(j);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(k);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(l);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(m);
      paramf.a(new org.apache.thrift.protocol.e((byte)11, (byte)11, this.e.size()));
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramf.a((String)localEntry.getKey());
        paramf.a((String)localEntry.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.f != null) && (f()))
    {
      paramf.a(n);
      paramf.a(this.f);
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
    while (!(paramObject instanceof o)) {
      return false;
    }
    return a((o)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
  }
  
  public void g()
  {
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSendFeedback(");
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
        break label318;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label256;
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
          break label282;
        }
        localStringBuilder.append("null");
        label155:
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("feedbacks:");
          if (this.e != null) {
            break label294;
          }
          localStringBuilder.append("null");
        }
        label193:
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.f != null) {
            break label306;
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
        label256:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label282:
        localStringBuilder.append(this.d);
        break label155;
        label294:
        localStringBuilder.append(this.e);
        break label193;
        label306:
        localStringBuilder.append(this.f);
      }
      label318:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.o
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */