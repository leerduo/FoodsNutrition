package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ai
  implements Serializable, Cloneable, bz<ai, ai.e>
{
  public static final Map<ai.e, cl> k;
  private static final dd l = new dd("AppInfo");
  private static final ct m = new ct("key", (byte)11, (short)1);
  private static final ct n = new ct("version", (byte)11, (short)2);
  private static final ct o = new ct("version_index", (byte)8, (short)3);
  private static final ct p = new ct("package_name", (byte)11, (short)4);
  private static final ct q = new ct("sdk_type", (byte)8, (short)5);
  private static final ct r = new ct("sdk_version", (byte)11, (short)6);
  private static final ct s = new ct("channel", (byte)11, (short)7);
  private static final ct t = new ct("wrapper_type", (byte)11, (short)8);
  private static final ct u = new ct("wrapper_version", (byte)11, (short)9);
  private static final ct v = new ct("vertical_type", (byte)8, (short)10);
  private static final Map<Class<? extends dg>, dh> w = new HashMap();
  public String a;
  public String b;
  public int c;
  public String d;
  public bc e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  private byte x = 0;
  private ai.e[] y;
  
  static
  {
    w.put(di.class, new ai.b(null));
    w.put(dj.class, new ai.d(null));
    EnumMap localEnumMap = new EnumMap(ai.e.class);
    localEnumMap.put(ai.e.a, new cl("key", (byte)1, new cm((byte)11)));
    localEnumMap.put(ai.e.b, new cl("version", (byte)2, new cm((byte)11)));
    localEnumMap.put(ai.e.c, new cl("version_index", (byte)2, new cm((byte)8)));
    localEnumMap.put(ai.e.d, new cl("package_name", (byte)2, new cm((byte)11)));
    localEnumMap.put(ai.e.e, new cl("sdk_type", (byte)1, new ck((byte)16, bc.class)));
    localEnumMap.put(ai.e.f, new cl("sdk_version", (byte)1, new cm((byte)11)));
    localEnumMap.put(ai.e.g, new cl("channel", (byte)1, new cm((byte)11)));
    localEnumMap.put(ai.e.h, new cl("wrapper_type", (byte)2, new cm((byte)11)));
    localEnumMap.put(ai.e.i, new cl("wrapper_version", (byte)2, new cm((byte)11)));
    localEnumMap.put(ai.e.j, new cl("vertical_type", (byte)2, new cm((byte)8)));
    k = Collections.unmodifiableMap(localEnumMap);
    cl.a(ai.class, k);
  }
  
  public ai()
  {
    ai.e[] arrayOfe = new ai.e[6];
    arrayOfe[0] = ai.e.b;
    arrayOfe[1] = ai.e.c;
    arrayOfe[2] = ai.e.d;
    arrayOfe[3] = ai.e.h;
    arrayOfe[4] = ai.e.i;
    arrayOfe[5] = ai.e.j;
    this.y = arrayOfe;
  }
  
  public ai a(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }
  
  public ai a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ai a(bc parambc)
  {
    this.e = parambc;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)w.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return this.b != null;
  }
  
  public ai b(int paramInt)
  {
    this.j = paramInt;
    j(true);
    return this;
  }
  
  public ai b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)w.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public boolean b()
  {
    return bw.a(this.x, 0);
  }
  
  public ai c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.x = bw.a(this.x, 0, paramBoolean);
  }
  
  public boolean c()
  {
    return this.d != null;
  }
  
  public ai d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.d = null;
    }
  }
  
  public boolean d()
  {
    return this.h != null;
  }
  
  public ai e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e = null;
    }
  }
  
  public boolean e()
  {
    return this.i != null;
  }
  
  public ai f(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.f = null;
    }
  }
  
  public boolean f()
  {
    return bw.a(this.x, 1);
  }
  
  public ai g(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public void g()
  {
    if (this.a == null) {
      throw new cz("Required field 'key' was not present! Struct: " + toString());
    }
    if (this.e == null) {
      throw new cz("Required field 'sdk_type' was not present! Struct: " + toString());
    }
    if (this.f == null) {
      throw new cz("Required field 'sdk_version' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new cz("Required field 'channel' was not present! Struct: " + toString());
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.g = null;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h = null;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  public void j(boolean paramBoolean)
  {
    this.x = bw.a(this.x, 1, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AppInfo(");
    localStringBuilder.append("key:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (a())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("version:");
        if (this.b != null) {
          break label368;
        }
        localStringBuilder.append("null");
      }
      label72:
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("version_index:");
        localStringBuilder.append(this.c);
      }
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("package_name:");
        if (this.d != null) {
          break label380;
        }
        localStringBuilder.append("null");
      }
      label142:
      localStringBuilder.append(", ");
      localStringBuilder.append("sdk_type:");
      if (this.e != null) {
        break label392;
      }
      localStringBuilder.append("null");
      label173:
      localStringBuilder.append(", ");
      localStringBuilder.append("sdk_version:");
      if (this.f != null) {
        break label404;
      }
      localStringBuilder.append("null");
      label204:
      localStringBuilder.append(", ");
      localStringBuilder.append("channel:");
      if (this.g != null) {
        break label416;
      }
      localStringBuilder.append("null");
      label235:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("wrapper_type:");
        if (this.h != null) {
          break label428;
        }
        localStringBuilder.append("null");
      }
      label273:
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("wrapper_version:");
        if (this.i != null) {
          break label440;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("vertical_type:");
        localStringBuilder.append(this.j);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label368:
      localStringBuilder.append(this.b);
      break label72;
      label380:
      localStringBuilder.append(this.d);
      break label142;
      label392:
      localStringBuilder.append(this.e);
      break label173;
      label404:
      localStringBuilder.append(this.f);
      break label204;
      label416:
      localStringBuilder.append(this.g);
      break label235;
      label428:
      localStringBuilder.append(this.h);
      break label273;
      label440:
      localStringBuilder.append(this.i);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ai
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */