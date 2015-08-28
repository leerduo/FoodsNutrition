package u.aly;

import java.util.BitSet;

class am$c
  extends dj<am>
{
  public void a(cy paramcy, am paramam)
  {
    de localde = (de)paramcy;
    localde.a(paramam.a);
    localde.a(paramam.b);
    BitSet localBitSet = new BitSet();
    if (paramam.b()) {
      localBitSet.set(0);
    }
    localde.a(localBitSet, 1);
    if (paramam.b()) {
      localde.a(paramam.c.a());
    }
  }
  
  public void b(cy paramcy, am paramam)
  {
    de localde = (de)paramcy;
    paramam.a = localde.t();
    paramam.b(true);
    paramam.b = localde.v();
    paramam.c(true);
    if (localde.b(1).get(0))
    {
      paramam.c = an.a(localde.s());
      paramam.d(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.am.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */