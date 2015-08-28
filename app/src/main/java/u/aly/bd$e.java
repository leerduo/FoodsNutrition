package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum bd$e
  implements cg
{
  private static final Map<String, e> h;
  private final short i;
  private final String j;
  
  static
  {
    e[] arrayOfe = new e[7];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    arrayOfe[4] = e;
    arrayOfe[5] = f;
    arrayOfe[6] = g;
    k = arrayOfe;
    h = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      h.put(locale.b(), locale);
    }
  }
  
  private bd$e(short paramShort, String paramString)
  {
    this.i = paramShort;
    this.j = paramString;
  }
  
  public short a()
  {
    return this.i;
  }
  
  public String b()
  {
    return this.j;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bd.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */