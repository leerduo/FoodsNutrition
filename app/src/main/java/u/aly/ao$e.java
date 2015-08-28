package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ao$e
  implements cg
{
  private static final Map<String, e> f;
  private final short g;
  private final String h;
  
  static
  {
    e[] arrayOfe = new e[5];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    arrayOfe[4] = e;
    i = arrayOfe;
    f = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      f.put(locale.b(), locale);
    }
  }
  
  private ao$e(short paramShort, String paramString)
  {
    this.g = paramShort;
    this.h = paramString;
  }
  
  public short a()
  {
    return this.g;
  }
  
  public String b()
  {
    return this.h;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ao.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */