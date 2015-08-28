package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class at$c
  extends dj<at>
{
  public void a(cy paramcy, at paramat)
  {
    de localde = (de)paramcy;
    localde.a(paramat.a.size());
    Iterator localIterator = paramat.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localde.a((String)localEntry.getKey());
      ((au)localEntry.getValue()).b(localde);
    }
    localde.a(paramat.b);
    localde.a(paramat.c);
  }
  
  public void b(cy paramcy, at paramat)
  {
    de localde = (de)paramcy;
    cv localcv = new cv((byte)11, (byte)12, localde.s());
    paramat.a = new HashMap(2 * localcv.c);
    for (int i = 0; i < localcv.c; i++)
    {
      String str = localde.v();
      au localau = new au();
      localau.a(localde);
      paramat.a.put(str, localau);
    }
    paramat.a(true);
    paramat.b = localde.s();
    paramat.b(true);
    paramat.c = localde.v();
    paramat.c(true);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.at.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */