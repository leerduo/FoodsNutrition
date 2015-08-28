package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ai$e
  implements cg
{
  private static final Map<String, e> k;
  private final short l;
  private final String m;
  
  static
  {
    e[] arrayOfe = new e[10];
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
    n = arrayOfe;
    k = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      k.put(locale.b(), locale);
    }
  }
  
  private ai$e(short paramShort, String paramString)
  {
    this.l = paramShort;
    this.m = paramString;
  }
  
  public short a()
  {
    return this.l;
  }
  
  public String b()
  {
    return this.m;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ai.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */