package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ax$e
  implements cg
{
  private static final Map<String, e> l;
  private final short m;
  private final String n;
  
  static
  {
    e[] arrayOfe = new e[11];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    arrayOfe[4] = e;
    arrayOfe[5] = f;
    arrayOfe[6] = g;
    arrayOfe[7] = h;
    arrayOfe[8] = i;
    arrayOfe[9] = j;
    arrayOfe[10] = k;
    o = arrayOfe;
    l = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      l.put(locale.b(), locale);
    }
  }
  
  private ax$e(short paramShort, String paramString)
  {
    this.m = paramShort;
    this.n = paramString;
  }
  
  public short a()
  {
    return this.m;
  }
  
  public String b()
  {
    return this.n;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ax.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */