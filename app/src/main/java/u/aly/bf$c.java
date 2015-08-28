package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

class bf$c
  extends dj<bf>
{
  public void a(cy paramcy, bf parambf)
  {
    de localde = (de)paramcy;
    parambf.a.b(localde);
    parambf.b.b(localde);
    parambf.c.b(localde);
    parambf.d.b(localde);
    BitSet localBitSet = new BitSet();
    if (parambf.a()) {
      localBitSet.set(0);
    }
    if (parambf.d()) {
      localBitSet.set(1);
    }
    if (parambf.f()) {
      localBitSet.set(2);
    }
    if (parambf.g()) {
      localBitSet.set(3);
    }
    if (parambf.h()) {
      localBitSet.set(4);
    }
    localde.a(localBitSet, 5);
    if (parambf.a()) {
      parambf.e.b(localde);
    }
    if (parambf.d())
    {
      localde.a(parambf.f.size());
      Iterator localIterator2 = parambf.f.iterator();
      while (localIterator2.hasNext()) {
        ((av)localIterator2.next()).b(localde);
      }
    }
    if (parambf.f())
    {
      localde.a(parambf.g.size());
      Iterator localIterator1 = parambf.g.iterator();
      while (localIterator1.hasNext()) {
        ((bd)localIterator1.next()).b(localde);
      }
    }
    if (parambf.g()) {
      parambf.h.b(localde);
    }
    if (parambf.h()) {
      parambf.i.b(localde);
    }
  }
  
  public void b(cy paramcy, bf parambf)
  {
    int i = 0;
    de localde = (de)paramcy;
    parambf.a = new aj();
    parambf.a.a(localde);
    parambf.a(true);
    parambf.b = new ai();
    parambf.b.a(localde);
    parambf.b(true);
    parambf.c = new ak();
    parambf.c.a(localde);
    parambf.c(true);
    parambf.d = new ax();
    parambf.d.a(localde);
    parambf.d(true);
    BitSet localBitSet = localde.b(5);
    if (localBitSet.get(0))
    {
      parambf.e = new ah();
      parambf.e.a(localde);
      parambf.e(true);
    }
    if (localBitSet.get(1))
    {
      cu localcu1 = new cu((byte)12, localde.s());
      parambf.f = new ArrayList(localcu1.b);
      for (int j = 0; j < localcu1.b; j++)
      {
        av localav = new av();
        localav.a(localde);
        parambf.f.add(localav);
      }
      parambf.f(true);
    }
    if (localBitSet.get(2))
    {
      cu localcu2 = new cu((byte)12, localde.s());
      parambf.g = new ArrayList(localcu2.b);
      while (i < localcu2.b)
      {
        bd localbd = new bd();
        localbd.a(localde);
        parambf.g.add(localbd);
        i++;
      }
      parambf.g(true);
    }
    if (localBitSet.get(3))
    {
      parambf.h = new at();
      parambf.h.a(localde);
      parambf.h(true);
    }
    if (localBitSet.get(4))
    {
      parambf.i = new as();
      parambf.i.a(localde);
      parambf.i(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bf.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */