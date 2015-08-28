package u.aly;

import java.util.BitSet;

class au$c
  extends dj<au>
{
  public void a(cy paramcy, au paramau)
  {
    de localde = (de)paramcy;
    localde.a(paramau.b);
    localde.a(paramau.c);
    BitSet localBitSet = new BitSet();
    if (paramau.b()) {
      localBitSet.set(0);
    }
    localde.a(localBitSet, 1);
    if (paramau.b()) {
      localde.a(paramau.a);
    }
  }
  
  public void b(cy paramcy, au paramau)
  {
    de localde = (de)paramcy;
    paramau.b = localde.t();
    paramau.b(true);
    paramau.c = localde.v();
    paramau.c(true);
    if (localde.b(1).get(0))
    {
      paramau.a = localde.v();
      paramau.a(true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.au.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */