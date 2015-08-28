package u.aly;

public class db
{
  private static int a = 2147483647;
  
  public static void a(cy paramcy, byte paramByte)
  {
    a(paramcy, paramByte, a);
  }
  
  public static void a(cy paramcy, byte paramByte, int paramInt)
  {
    int i = 0;
    if (paramInt <= 0) {
      throw new cf("Maximum skip depth exceeded");
    }
    switch (paramByte)
    {
    case 5: 
    case 7: 
    case 9: 
    default: 
      return;
    case 2: 
      paramcy.p();
      return;
    case 3: 
      paramcy.q();
      return;
    case 6: 
      paramcy.r();
      return;
    case 8: 
      paramcy.s();
      return;
    case 10: 
      paramcy.t();
      return;
    case 4: 
      paramcy.u();
      return;
    case 11: 
      paramcy.w();
      return;
    case 12: 
      paramcy.f();
      for (;;)
      {
        ct localct = paramcy.h();
        if (localct.b == 0)
        {
          paramcy.g();
          return;
        }
        a(paramcy, localct.b, paramInt - 1);
        paramcy.i();
      }
    case 13: 
      cv localcv = paramcy.j();
      while (i < localcv.c)
      {
        a(paramcy, localcv.a, paramInt - 1);
        a(paramcy, localcv.b, paramInt - 1);
        i++;
      }
      paramcy.k();
      return;
    case 14: 
      dc localdc = paramcy.n();
      while (i < localdc.b)
      {
        a(paramcy, localdc.a, paramInt - 1);
        i++;
      }
      paramcy.o();
      return;
    }
    cu localcu = paramcy.l();
    while (i < localcu.b)
    {
      a(paramcy, localcu.a, paramInt - 1);
      i++;
    }
    paramcy.m();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.db
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */