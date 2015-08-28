package u.aly;

import java.util.BitSet;

class aj$c
  extends dj<aj>
{
  public void a(cy paramcy, aj paramaj)
  {
    de localde = (de)paramcy;
    localde.a(paramaj.a);
    localde.a(paramaj.b);
    BitSet localBitSet = new BitSet();
    if (paramaj.c()) {
      localBitSet.set(0);
    }
    localde.a(localBitSet, 1);
    if (paramaj.c()) {
      localde.a(paramaj.c);
    }
  }
  
  public void b(cy paramcy, aj paramaj)
  {
    de localde = (de)paramcy;
    paramaj.a = localde.s();
    paramaj.a(true);
    paramaj.b = localde.s();
    paramaj.b(true);
    if (localde.b(1).get(0))
    {
      paramaj.c = localde.s();
      paramaj.c(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aj.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */