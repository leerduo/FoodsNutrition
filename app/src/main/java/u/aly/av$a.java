package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class av$a
  extends di<av>
{
  public void a(cy paramcy, av paramav)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      paramav.e();
      return;
    }
    switch (localct.c)
    {
    default: 
      db.a(paramcy, localct.b);
    }
    for (;;)
    {
      paramcy.i();
      break;
      if (localct.b == 11)
      {
        paramav.a = paramcy.v();
        paramav.a(true);
      }
      else
      {
        db.a(paramcy, localct.b);
        continue;
        if (localct.b == 15)
        {
          cu localcu3 = paramcy.l();
          paramav.b = new ArrayList(localcu3.b);
          for (int k = 0; k < localcu3.b; k++)
          {
            am localam = new am();
            localam.a(paramcy);
            paramav.b.add(localam);
          }
          paramcy.m();
          paramav.b(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 15)
          {
            cu localcu2 = paramcy.l();
            paramav.c = new ArrayList(localcu2.b);
            for (int j = 0; j < localcu2.b; j++)
            {
              ao localao2 = new ao();
              localao2.a(paramcy);
              paramav.c.add(localao2);
            }
            paramcy.m();
            paramav.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 15)
            {
              cu localcu1 = paramcy.l();
              paramav.d = new ArrayList(localcu1.b);
              for (int i = 0; i < localcu1.b; i++)
              {
                ao localao1 = new ao();
                localao1.a(paramcy);
                paramav.d.add(localao1);
              }
              paramcy.m();
              paramav.d(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
  }
  
  public void b(cy paramcy, av paramav)
  {
    paramav.e();
    paramcy.a(av.f());
    if (paramav.a != null)
    {
      paramcy.a(av.g());
      paramcy.a(paramav.a);
      paramcy.b();
    }
    if ((paramav.b != null) && (paramav.b()))
    {
      paramcy.a(av.h());
      paramcy.a(new cu((byte)12, paramav.b.size()));
      Iterator localIterator3 = paramav.b.iterator();
      while (localIterator3.hasNext()) {
        ((am)localIterator3.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    if ((paramav.c != null) && (paramav.c()))
    {
      paramcy.a(av.i());
      paramcy.a(new cu((byte)12, paramav.c.size()));
      Iterator localIterator2 = paramav.c.iterator();
      while (localIterator2.hasNext()) {
        ((ao)localIterator2.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    if ((paramav.d != null) && (paramav.d()))
    {
      paramcy.a(av.j());
      paramcy.a(new cu((byte)12, paramav.d.size()));
      Iterator localIterator1 = paramav.d.iterator();
      while (localIterator1.hasNext()) {
        ((ao)localIterator1.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.av.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */