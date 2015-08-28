package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class as$c
  extends dj<as>
{
  public void a(cy paramcy, as paramas)
  {
    de localde = (de)paramcy;
    localde.a(paramas.a.size());
    Iterator localIterator1 = paramas.a.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      localde.a((String)localEntry.getKey());
      ((ar)localEntry.getValue()).b(localde);
    }
    BitSet localBitSet = new BitSet();
    if (paramas.c()) {
      localBitSet.set(0);
    }
    if (paramas.d()) {
      localBitSet.set(1);
    }
    localde.a(localBitSet, 2);
    if (paramas.c())
    {
      localde.a(paramas.b.size());
      Iterator localIterator2 = paramas.b.iterator();
      while (localIterator2.hasNext()) {
        ((aq)localIterator2.next()).b(localde);
      }
    }
    if (paramas.d()) {
      localde.a(paramas.c);
    }
  }
  
  public void b(cy paramcy, as paramas)
  {
    int i = 0;
    de localde = (de)paramcy;
    cv localcv = new cv((byte)11, (byte)12, localde.s());
    paramas.a = new HashMap(2 * localcv.c);
    for (int j = 0; j < localcv.c; j++)
    {
      String str = localde.v();
      ar localar = new ar();
      localar.a(localde);
      paramas.a.put(str, localar);
    }
    paramas.a(true);
    BitSet localBitSet = localde.b(2);
    if (localBitSet.get(0))
    {
      cu localcu = new cu((byte)12, localde.s());
      paramas.b = new ArrayList(localcu.b);
      while (i < localcu.b)
      {
        aq localaq = new aq();
        localaq.a(localde);
        paramas.b.add(localaq);
        i++;
      }
      paramas.b(true);
    }
    if (localBitSet.get(1))
    {
      paramas.c = localde.v();
      paramas.c(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.as.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */