package u.aly;

import java.util.BitSet;

class bb$c
  extends dj<bb>
{
  public void a(cy paramcy, bb parambb)
  {
    de localde = (de)paramcy;
    localde.a(parambb.a);
    BitSet localBitSet = new BitSet();
    if (parambb.c()) {
      localBitSet.set(0);
    }
    if (parambb.e()) {
      localBitSet.set(1);
    }
    localde.a(localBitSet, 2);
    if (parambb.c()) {
      localde.a(parambb.b);
    }
    if (parambb.e()) {
      parambb.c.b(localde);
    }
  }
  
  public void b(cy paramcy, bb parambb)
  {
    de localde = (de)paramcy;
    parambb.a = localde.s();
    parambb.a(true);
    BitSet localBitSet = localde.b(2);
    if (localBitSet.get(0))
    {
      parambb.b = localde.v();
      parambb.b(true);
    }
    if (localBitSet.get(1))
    {
      parambb.c = new at();
      parambb.c.a(localde);
      parambb.c(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bb.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */