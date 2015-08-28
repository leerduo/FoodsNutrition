package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

class bd$c
  extends dj<bd>
{
  public void a(cy paramcy, bd parambd)
  {
    de localde = (de)paramcy;
    localde.a(parambd.a);
    localde.a(parambd.b);
    localde.a(parambd.c);
    localde.a(parambd.d);
    BitSet localBitSet = new BitSet();
    if (parambd.e()) {
      localBitSet.set(0);
    }
    if (parambd.f()) {
      localBitSet.set(1);
    }
    if (parambd.g()) {
      localBitSet.set(2);
    }
    localde.a(localBitSet, 3);
    if (parambd.e())
    {
      localde.a(parambd.e.size());
      Iterator localIterator2 = parambd.e.iterator();
      while (localIterator2.hasNext()) {
        ((ay)localIterator2.next()).b(localde);
      }
    }
    if (parambd.f())
    {
      localde.a(parambd.f.size());
      Iterator localIterator1 = parambd.f.iterator();
      while (localIterator1.hasNext()) {
        ((aw)localIterator1.next()).b(localde);
      }
    }
    if (parambd.g()) {
      parambd.g.b(localde);
    }
  }
  
  public void b(cy paramcy, bd parambd)
  {
    int i = 0;
    de localde = (de)paramcy;
    parambd.a = localde.v();
    parambd.a(true);
    parambd.b = localde.t();
    parambd.b(true);
    parambd.c = localde.t();
    parambd.c(true);
    parambd.d = localde.t();
    parambd.d(true);
    BitSet localBitSet = localde.b(3);
    if (localBitSet.get(0))
    {
      cu localcu1 = new cu((byte)12, localde.s());
      parambd.e = new ArrayList(localcu1.b);
      for (int j = 0; j < localcu1.b; j++)
      {
        ay localay = new ay();
        localay.a(localde);
        parambd.e.add(localay);
      }
      parambd.e(true);
    }
    if (localBitSet.get(1))
    {
      cu localcu2 = new cu((byte)12, localde.s());
      parambd.f = new ArrayList(localcu2.b);
      while (i < localcu2.b)
      {
        aw localaw = new aw();
        localaw.a(localde);
        parambd.f.add(localaw);
        i++;
      }
      parambd.f(true);
    }
    if (localBitSet.get(2))
    {
      parambd.g = new be();
      parambd.g.a(localde);
      parambd.g(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bd.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */