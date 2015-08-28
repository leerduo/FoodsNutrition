package u.aly;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ao$c
  extends dj<ao>
{
  public void a(cy paramcy, ao paramao)
  {
    de localde = (de)paramcy;
    localde.a(paramao.a);
    localde.a(paramao.b.size());
    Iterator localIterator = paramao.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localde.a((String)localEntry.getKey());
      ((az)localEntry.getValue()).b(localde);
    }
    localde.a(paramao.e);
    BitSet localBitSet = new BitSet();
    if (paramao.a()) {
      localBitSet.set(0);
    }
    if (paramao.b()) {
      localBitSet.set(1);
    }
    localde.a(localBitSet, 2);
    if (paramao.a()) {
      localde.a(paramao.c);
    }
    if (paramao.b()) {
      localde.a(paramao.d);
    }
  }
  
  public void b(cy paramcy, ao paramao)
  {
    de localde = (de)paramcy;
    paramao.a = localde.v();
    paramao.a(true);
    cv localcv = new cv((byte)11, (byte)12, localde.s());
    paramao.b = new HashMap(2 * localcv.c);
    for (int i = 0; i < localcv.c; i++)
    {
      String str = localde.v();
      az localaz = new az();
      localaz.a(localde);
      paramao.b.put(str, localaz);
    }
    paramao.b(true);
    paramao.e = localde.t();
    paramao.e(true);
    BitSet localBitSet = localde.b(2);
    if (localBitSet.get(0))
    {
      paramao.c = localde.t();
      paramao.c(true);
    }
    if (localBitSet.get(1))
    {
      paramao.d = localde.s();
      paramao.d(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ao.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */