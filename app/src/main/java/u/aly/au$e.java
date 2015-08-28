package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum au$e
  implements cg
{
  private static final Map<String, e> d;
  private final short e;
  private final String f;
  
  static
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    g = arrayOfe;
    d = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      d.put(locale.b(), locale);
    }
  }
  
  private au$e(short paramShort, String paramString)
  {
    this.e = paramShort;
    this.f = paramString;
  }
  
  public short a()
  {
    return this.e;
  }
  
  public String b()
  {
    return this.f;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.au.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */