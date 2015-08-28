package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

class av$c
  extends dj<av>
{
  public void a(cy paramcy, av paramav)
  {
    de localde = (de)paramcy;
    localde.a(paramav.a);
    BitSet localBitSet = new BitSet();
    if (paramav.b()) {
      localBitSet.set(0);
    }
    if (paramav.c()) {
      localBitSet.set(1);
    }
    if (paramav.d()) {
      localBitSet.set(2);
    }
    localde.a(localBitSet, 3);
    if (paramav.b())
    {
      localde.a(paramav.b.size());
      Iterator localIterator3 = paramav.b.iterator();
      while (localIterator3.hasNext()) {
        ((am)localIterator3.next()).b(localde);
      }
    }
    if (paramav.c())
    {
      localde.a(paramav.c.size());
      Iterator localIterator2 = paramav.c.iterator();
      while (localIterator2.hasNext()) {
        ((ao)localIterator2.next()).b(localde);
      }
    }
    if (paramav.d())
    {
      localde.a(paramav.d.size());
      Iterator localIterator1 = paramav.d.iterator();
      while (localIterator1.hasNext()) {
        ((ao)localIterator1.next()).b(localde);
      }
    }
  }
  
  public void b(cy paramcy, av paramav)
  {
    int i = 0;
    de localde = (de)paramcy;
    paramav.a = localde.v();
    paramav.a(true);
    BitSet localBitSet = localde.b(3);
    if (localBitSet.get(0))
    {
      cu localcu1 = new cu((byte)12, localde.s());
      paramav.b = new ArrayList(localcu1.b);
      for (int j = 0; j < localcu1.b; j++)
      {
        am localam = new am();
        localam.a(localde);
        paramav.b.add(localam);
      }
      paramav.b(true);
    }
    if (localBitSet.get(1))
    {
      cu localcu2 = new cu((byte)12, localde.s());
      paramav.c = new ArrayList(localcu2.b);
      for (int k = 0; k < localcu2.b; k++)
      {
        ao localao1 = new ao();
        localao1.a(localde);
        paramav.c.add(localao1);
      }
      paramav.c(true);
    }
    if (localBitSet.get(2))
    {
      cu localcu3 = new cu((byte)12, localde.s());
      paramav.d = new ArrayList(localcu3.b);
      while (i < localcu3.b)
      {
        ao localao2 = new ao();
        localao2.a(localde);
        paramav.d.add(localao2);
        i++;
      }
      paramav.d(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.av.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */