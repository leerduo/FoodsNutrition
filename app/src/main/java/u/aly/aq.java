package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class aq
  implements Serializable, Cloneable, bz<aq, aq.e>
{
  public static final Map<aq.e, cl> e;
  private static final dd f = new dd("IdJournal");
  private static final ct g = new ct("domain", (byte)11, (short)1);
  private static final ct h = new ct("old_id", (byte)11, (short)2);
  private static final ct i = new ct("new_id", (byte)11, (short)3);
  private static final ct j = new ct("ts", (byte)10, (short)4);
  private static final Map<Class<? extends dg>, dh> k = new HashMap();
  public String a;
  public String b;
  public String c;
  public long d;
  private byte l = 0;
  private aq.e[] m;
  
  static
  {
    k.put(di.class, new aq.b(null));
    k.put(dj.class, new aq.d(null));
    EnumMap localEnumMap = new EnumMap(aq.e.class);
    localEnumMap.put(aq.e.a, new cl("domain", (byte)1, new cm((byte)11)));
    localEnumMap.put(aq.e.b, new cl("old_id", (byte)2, new cm((byte)11)));
    localEnumMap.put(aq.e.c, new cl("new_id", (byte)1, new cm((byte)11)));
    localEnumMap.put(aq.e.d, new cl("ts", (byte)1, new cm((byte)10)));
    e = Collections.unmodifiableMap(localEnumMap);
    cl.a(aq.class, e);
  }
  
  public aq()
  {
    aq.e[] arrayOfe = new aq.e[1];
    arrayOfe[0] = aq.e.b;
    this.m = arrayOfe;
  }
  
  public aq a(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }
  
  public aq a(String paramString)
  {
    this.a = paramString;
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
    return this.b != null;
  }
  
  public aq b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)k.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public boolean b()
  {
    return bw.a(this.l, 0);
  }
  
  public aq c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void c()
  {
    if (this.a == null) {
      throw new cz("Required field 'domain' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new cz("Required field 'new_id' was not present! Struct: " + toString());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.l = bw.a(this.l, 0, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdJournal(");
    localStringBuilder.append("domain:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (a())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("old_id:");
        if (this.b != null) {
          break label141;
        }
        localStringBuilder.append("null");
      }
      label66:
      localStringBuilder.append(", ");
      localStringBuilder.append("new_id:");
      if (this.c != null) {
        break label153;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label141:
      localStringBuilder.append(this.b);
      break label66;
      label153:
      localStringBuilder.append(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aq
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */