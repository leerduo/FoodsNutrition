package u.aly;

import java.util.BitSet;

class bg$c
  extends dj<bg>
{
  public void a(cy paramcy, bg parambg)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = new BitSet();
    if (parambg.a()) {
      localBitSet.set(0);
    }
    if (parambg.b()) {
      localBitSet.set(1);
    }
    if (parambg.c()) {
      localBitSet.set(2);
    }
    if (parambg.d()) {
      localBitSet.set(3);
    }
    localde.a(localBitSet, 4);
    if (parambg.a()) {
      localde.a(parambg.a.a());
    }
    if (parambg.b()) {
      localde.a(parambg.b);
    }
    if (parambg.c()) {
      localde.a(parambg.c);
    }
    if (parambg.d()) {
      localde.a(parambg.d);
    }
  }
  
  public void b(cy paramcy, bg parambg)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = localde.b(4);
    if (localBitSet.get(0))
    {
      parambg.a = ap.a(localde.s());
      parambg.a(true);
    }
    if (localBitSet.get(1))
    {
      parambg.b = localde.s();
      parambg.b(true);
    }
    if (localBitSet.get(2))
    {
      parambg.c = localde.v();
      parambg.c(true);
    }
    if (localBitSet.get(3))
    {
      parambg.d = localde.v();
      parambg.d(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bg.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */