package org.apache.thrift.protocol;

public class i
{
  private static int a = 2147483647;
  
  public static void a(f paramf, byte paramByte)
  {
    a(paramf, paramByte, a);
  }
  
  public static void a(f paramf, byte paramByte, int paramInt)
  {
    int i = 0;
    if (paramInt <= 0) {
      throw new org.apache.thrift.e("Maximum skip depth exceeded");
    }
    switch (paramByte)
    {
    case 5: 
    case 7: 
    case 9: 
    default: 
      return;
    case 2: 
      paramf.q();
      return;
    case 3: 
      paramf.r();
      return;
    case 6: 
      paramf.s();
      return;
    case 8: 
      paramf.t();
      return;
    case 10: 
      paramf.u();
      return;
    case 4: 
      paramf.v();
      return;
    case 11: 
      paramf.x();
      return;
    case 12: 
      paramf.g();
      for (;;)
      {
        c localc = paramf.i();
        if (localc.b == 0)
        {
          paramf.h();
          return;
        }
        a(paramf, localc.b, paramInt - 1);
        paramf.j();
      }
    case 13: 
      e locale = paramf.k();
      while (i < locale.c)
      {
        a(paramf, locale.a, paramInt - 1);
        a(paramf, locale.b, paramInt - 1);
        i++;
      }
      paramf.l();
      return;
    case 14: 
      j localj = paramf.o();
      while (i < localj.b)
      {
        a(paramf, localj.a, paramInt - 1);
        i++;
      }
      paramf.p();
      return;
    }
    d locald = paramf.m();
    while (i < locald.b)
    {
      a(paramf, locald.a, paramInt - 1);
      i++;
    }
    paramf.n();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.protocol.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */