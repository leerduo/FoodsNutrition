package u.aly;

import java.util.BitSet;

class ax$c
  extends dj<ax>
{
  public void a(cy paramcy, ax paramax)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = new BitSet();
    if (paramax.a()) {
      localBitSet.set(0);
    }
    if (paramax.b()) {
      localBitSet.set(1);
    }
    if (paramax.c()) {
      localBitSet.set(2);
    }
    if (paramax.d()) {
      localBitSet.set(3);
    }
    if (paramax.e()) {
      localBitSet.set(4);
    }
    if (paramax.f()) {
      localBitSet.set(5);
    }
    if (paramax.g()) {
      localBitSet.set(6);
    }
    if (paramax.h()) {
      localBitSet.set(7);
    }
    if (paramax.i()) {
      localBitSet.set(8);
    }
    if (paramax.j()) {
      localBitSet.set(9);
    }
    if (paramax.k()) {
      localBitSet.set(10);
    }
    localde.a(localBitSet, 11);
    if (paramax.a()) {
      localde.a(paramax.a);
    }
    if (paramax.b()) {
      localde.a(paramax.b);
    }
    if (paramax.c()) {
      localde.a(paramax.c);
    }
    if (paramax.d()) {
      localde.a(paramax.d);
    }
    if (paramax.e()) {
      localde.a(paramax.e);
    }
    if (paramax.f()) {
      localde.a(paramax.f);
    }
    if (paramax.g()) {
      localde.a(paramax.g);
    }
    if (paramax.h()) {
      localde.a(paramax.h);
    }
    if (paramax.i()) {
      localde.a(paramax.i.a());
    }
    if (paramax.j()) {
      localde.a(paramax.j);
    }
    if (paramax.k()) {
      paramax.k.b(localde);
    }
  }
  
  public void b(cy paramcy, ax paramax)
  {
    de localde = (de)paramcy;
    BitSet localBitSet = localde.b(11);
    if (localBitSet.get(0))
    {
      paramax.a = localde.s();
      paramax.a(true);
    }
    if (localBitSet.get(1))
    {
      paramax.b = localde.v();
      paramax.b(true);
    }
    if (localBitSet.get(2))
    {
      paramax.c = localde.v();
      paramax.c(true);
    }
    if (localBitSet.get(3))
    {
      paramax.d = localde.u();
      paramax.d(true);
    }
    if (localBitSet.get(4))
    {
      paramax.e = localde.u();
      paramax.e(true);
    }
    if (localBitSet.get(5))
    {
      paramax.f = localde.v();
      paramax.f(true);
    }
    if (localBitSet.get(6))
    {
      paramax.g = localde.s();
      paramax.g(true);
    }
    if (localBitSet.get(7))
    {
      paramax.h = localde.v();
      paramax.h(true);
    }
    if (localBitSet.get(8))
    {
      paramax.i = ag.a(localde.s());
      paramax.i(true);
    }
    if (localBitSet.get(9))
    {
      paramax.j = localde.v();
      paramax.j(true);
    }
    if (localBitSet.get(10))
    {
      paramax.k = new bg();
      paramax.k.a(localde);
      paramax.k(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ax.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */