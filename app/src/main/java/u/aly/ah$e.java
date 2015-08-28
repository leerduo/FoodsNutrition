package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ah$e
  implements cg
{
  private static final Map<String, e> b;
  private final short c;
  private final String d;
  
  static
  {
    e[] arrayOfe = new e[1];
    arrayOfe[0] = a;
    e = arrayOfe;
    b = new HashMap();
    Iterator localIterator = EnumSet.allOf(e.class).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      b.put(locale.b(), locale);
    }
  }
  
  private ah$e(short paramShort, String paramString)
  {
    this.c = paramShort;
    this.d = paramString;
  }
  
  public short a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ah.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */