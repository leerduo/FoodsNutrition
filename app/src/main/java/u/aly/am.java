package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class am
  implements Serializable, Cloneable, bz<am, am.e>
{
  public static final Map<am.e, cl> d;
  private static final dd e = new dd("Error");
  private static final ct f = new ct("ts", (byte)10, (short)1);
  private static final ct g = new ct("context", (byte)11, (short)2);
  private static final ct h = new ct("source", (byte)8, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public long a;
  public String b;
  public an c;
  private byte j = 0;
  private am.e[] k;
  
  static
  {
    i.put(di.class, new am.b(null));
    i.put(dj.class, new am.d(null));
    EnumMap localEnumMap = new EnumMap(am.e.class);
    localEnumMap.put(am.e.a, new cl("ts", (byte)1, new cm((byte)10)));
    localEnumMap.put(am.e.b, new cl("context", (byte)1, new cm((byte)11)));
    localEnumMap.put(am.e.c, new cl("source", (byte)2, new ck((byte)16, an.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(am.class, d);
  }
  
  public am()
  {
    am.e[] arrayOfe = new am.e[1];
    arrayOfe[0] = am.e.c;
    this.k = arrayOfe;
  }
  
  public am a(long paramLong)
  {
    this.a = paramLong;
    b(true);
    return this;
  }
  
  public am a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public am a(an paraman)
  {
    this.c = paraman;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public boolean a()
  {
    return bw.a(this.j, 0);
  }
  
  public void b(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = bw.a(this.j, 0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.c != null;
  }
  
  public void c()
  {
    if (this.b == null) {
      throw new cz("Required field 'context' was not present! Struct: " + toString());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Error(");
    localStringBuilder.append("ts:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("context:");
    if (this.b == null)
    {
      localStringBuilder.append("null");
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("source:");
        if (this.c != null) {
          break label113;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label113:
      localStringBuilder.append(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.am
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */