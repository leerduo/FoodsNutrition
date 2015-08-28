package u.aly;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class az
  extends cj<az, az.a>
{
  public static final Map<az.a, cl> a;
  private static final dd d = new dd("PropertyValue");
  private static final ct e = new ct("string_value", (byte)11, (short)1);
  private static final ct f = new ct("long_value", (byte)10, (short)2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(az.a.class);
    localEnumMap.put(az.a.a, new cl("string_value", (byte)3, new cm((byte)11)));
    localEnumMap.put(az.a.b, new cl("long_value", (byte)3, new cm((byte)10)));
    a = Collections.unmodifiableMap(localEnumMap);
    cl.a(az.class, a);
  }
  
  protected Object a(cy paramcy, ct paramct)
  {
    az.a locala = az.a.a(paramct.c);
    String str = null;
    if (locala != null) {}
    switch (az.1.a[locala.ordinal()])
    {
    default: 
      throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
    case 1: 
      if (paramct.b == e.b)
      {
        str = paramcy.v();
        return str;
      }
      db.a(paramcy, paramct.b);
      return null;
    }
    if (paramct.b == f.b) {
      return Long.valueOf(paramcy.t());
    }
    db.a(paramcy, paramct.b);
    return null;
  }
  
  protected Object a(cy paramcy, short paramShort)
  {
    az.a locala = az.a.a(paramShort);
    if (locala != null)
    {
      switch (az.1.a[locala.ordinal()])
      {
      default: 
        throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      case 1: 
        return paramcy.v();
      }
      return Long.valueOf(paramcy.t());
    }
    throw new cz("Couldn't find a field with field id " + paramShort);
  }
  
  protected az.a a(short paramShort)
  {
    return az.a.b(paramShort);
  }
  
  protected ct a(az.a parama)
  {
    switch (az.1.a[parama.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unknown field id " + parama);
    case 1: 
      return e;
    }
    return f;
  }
  
  protected dd a()
  {
    return d;
  }
  
  public void a(long paramLong)
  {
    this.c = az.a.b;
    this.b = Long.valueOf(paramLong);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.c = az.a.a;
    this.b = paramString;
  }
  
  public boolean a(az paramaz)
  {
    return (paramaz != null) && (b() == paramaz.b()) && (c().equals(paramaz.c()));
  }
  
  protected void c(cy paramcy)
  {
    switch (az.1.a[((az.a)this.c).ordinal()])
    {
    default: 
      throw new IllegalStateException("Cannot write union with unknown field " + this.c);
    case 1: 
      paramcy.a((String)this.b);
      return;
    }
    paramcy.a(((Long)this.b).longValue());
  }
  
  protected void d(cy paramcy)
  {
    switch (az.1.a[((az.a)this.c).ordinal()])
    {
    default: 
      throw new IllegalStateException("Cannot write union with unknown field " + this.c);
    case 1: 
      paramcy.a((String)this.b);
      return;
    }
    paramcy.a(((Long)this.b).longValue());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof az)) {
      return a((az)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.az
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */