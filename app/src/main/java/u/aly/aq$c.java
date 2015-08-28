package u.aly;

import java.util.BitSet;

class aq$c
  extends dj<aq>
{
  public void a(cy paramcy, aq paramaq)
  {
    de localde = (de)paramcy;
    localde.a(paramaq.a);
    localde.a(paramaq.c);
    localde.a(paramaq.d);
    BitSet localBitSet = new BitSet();
    if (paramaq.a()) {
      localBitSet.set(0);
    }
    localde.a(localBitSet, 1);
    if (paramaq.a()) {
      localde.a(paramaq.b);
    }
  }
  
  public void b(cy paramcy, aq paramaq)
  {
    de localde = (de)paramcy;
    paramaq.a = localde.v();
    paramaq.a(true);
    paramaq.c = localde.v();
    paramaq.c(true);
    paramaq.d = localde.t();
    paramaq.d(true);
    if (localde.b(1).get(0))
    {
      paramaq.b = localde.v();
      paramaq.b(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aq.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */