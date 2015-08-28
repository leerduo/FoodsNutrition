package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum av$e
  implements cg
{
  private static final Map<String, e> e;
  private final short f;
  private final String g;
  
  static
  {
    e[] arrayOfe = new e[4];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    h = arrayOfe;
    e = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      e.put(locale.b(), locale);
    }
  }
  
  private av$e(short paramShort, String paramString)
  {
    this.f = paramShort;
    this.g = paramString;
  }
  
  public short a()
  {
    return this.f;
  }
  
  public String b()
  {
    return this.g;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.av.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */