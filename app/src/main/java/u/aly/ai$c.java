package u.aly;

import java.util.BitSet;

class ai$c
  extends dj<ai>
{
  public void a(cy paramcy, ai paramai)
  {
    de localde = (de)paramcy;
    localde.a(paramai.a);
    localde.a(paramai.e.a());
    localde.a(paramai.f);
    localde.a(paramai.g);
    BitSet localBitSet = new BitSet();
    if (paramai.a()) {
      localBitSet.set(0);
    }
    if (paramai.b()) {
      localBitSet.set(1);
    }
    if (paramai.c()) {
      localBitSet.set(2);
    }
    if (paramai.d()) {
      localBitSet.set(3);
    }
    if (paramai.e()) {
      localBitSet.set(4);
    }
    if (paramai.f()) {
      localBitSet.set(5);
    }
    localde.a(localBitSet, 6);
    if (paramai.a()) {
      localde.a(paramai.b);
    }
    if (paramai.b()) {
      localde.a(paramai.c);
    }
    if (paramai.c()) {
      localde.a(paramai.d);
    }
    if (paramai.d()) {
      localde.a(paramai.h);
    }
    if (paramai.e()) {
      localde.a(paramai.i);
    }
    if (paramai.f()) {
      localde.a(paramai.j);
    }
  }
  
  public void b(cy paramcy, ai paramai)
  {
    de localde = (de)paramcy;
    paramai.a = localde.v();
    paramai.a(true);
    paramai.e = bc.a(localde.s());
    paramai.e(true);
    paramai.f = localde.v();
    paramai.f(true);
    paramai.g = localde.v();
    paramai.g(true);
    BitSet localBitSet = localde.b(6);
    if (localBitSet.get(0))
    {
      paramai.b = localde.v();
      paramai.b(true);
    }
    if (localBitSet.get(1))
    {
      paramai.c = localde.s();
      paramai.c(true);
    }
    if (localBitSet.get(2))
    {
      paramai.d = localde.v();
      paramai.d(true);
    }
    if (localBitSet.get(3))
    {
      paramai.h = localde.v();
      paramai.h(true);
    }
    if (localBitSet.get(4))
    {
      paramai.i = localde.v();
      paramai.i(true);
    }
    if (localBitSet.get(5))
    {
      paramai.j = localde.s();
      paramai.j(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ai.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */