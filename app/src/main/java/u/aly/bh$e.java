package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum bh$e
  implements cg
{
  private static final Map<String, e> j;
  private final short k;
  private final String l;
  
  static
  {
    e[] arrayOfe = new e[9];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    arrayOfe[4] = e;
    arrayOfe[5] = f;
    arrayOfe[6] = g;
    arrayOfe[7] = h;
    arrayOfe[8] = i;
    m = arrayOfe;
    j = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      j.put(locale.b(), locale);
    }
  }
  
  private bh$e(short paramShort, String paramString)
  {
    this.k = paramShort;
    this.l = paramString;
  }
  
  public short a()
  {
    return this.k;
  }
  
  public String b()
  {
    return this.l;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bh.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */