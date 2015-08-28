package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class bg
  implements Serializable, Cloneable, bz<bg, bg.e>
{
  public static final Map<bg.e, cl> e;
  private static final dd f = new dd("UserInfo");
  private static final ct g = new ct("gender", (byte)8, (short)1);
  private static final ct h = new ct("age", (byte)8, (short)2);
  private static final ct i = new ct("id", (byte)11, (short)3);
  private static final ct j = new ct("source", (byte)11, (short)4);
  private static final Map<Class<? extends dg>, dh> k = new HashMap();
  public ap a;
  public int b;
  public String c;
  public String d;
  private byte l = 0;
  private bg.e[] m;
  
  static
  {
    k.put(di.class, new bg.b(null));
    k.put(dj.class, new bg.d(null));
    EnumMap localEnumMap = new EnumMap(bg.e.class);
    localEnumMap.put(bg.e.a, new cl("gender", (byte)2, new ck((byte)16, ap.class)));
    localEnumMap.put(bg.e.b, new cl("age", (byte)2, new cm((byte)8)));
    localEnumMap.put(bg.e.c, new cl("id", (byte)2, new cm((byte)11)));
    localEnumMap.put(bg.e.d, new cl("source", (byte)2, new cm((byte)11)));
    e = Collections.unmodifiableMap(localEnumMap);
    cl.a(bg.class, e);
  }
  
  public bg()
  {
    bg.e[] arrayOfe = new bg.e[4];
    arrayOfe[0] = bg.e.a;
    arrayOfe[1] = bg.e.b;
    arrayOfe[2] = bg.e.c;
    arrayOfe[3] = bg.e.d;
    this.m = arrayOfe;
  }
  
  public bg a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }
  
  public bg a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public bg a(ap paramap)
  {
    this.a = paramap;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)k.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public bg b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)k.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = bw.a(this.l, 0, paramBoolean);
  }
  
  public boolean b()
  {
    return bw.a(this.l, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.d = null;
    }
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public void e() {}
  
  public String toString()
  {
    int n = 0;
    StringBuilder localStringBuilder = new StringBuilder("UserInfo(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("gender:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (b())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("age:");
        localStringBuilder.append(this.b);
        i1 = 0;
      }
      if (!c()) {
        break label208;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.c != null) {
        break label182;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      label119:
      if (d())
      {
        if (n == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("source:");
        if (this.d != null) {
          break label196;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label182:
        localStringBuilder.append(this.c);
        n = 0;
        break label119;
        label196:
        localStringBuilder.append(this.d);
      }
      label208:
      n = i1;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bg
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */