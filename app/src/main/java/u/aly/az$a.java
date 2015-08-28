package u.aly;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum az$a
  implements cg
{
  private static final Map<String, a> c;
  private final short d;
  private final String e;
  
  static
  {
    a[] arrayOfa = new a[2];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    f = arrayOfa;
    c = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      c.put(locala.b(), locala);
    }
  }
  
  private az$a(short paramShort, String paramString)
  {
    this.d = paramShort;
    this.e = paramString;
  }
  
  public static a a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a;
    }
    return b;
  }
  
  public static a b(int paramInt)
  {
    a locala = a(paramInt);
    if (locala == null) {
      throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
    }
    return locala;
  }
  
  public short a()
  {
    return this.d;
  }
  
  public String b()
  {
    return this.e;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.az.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */