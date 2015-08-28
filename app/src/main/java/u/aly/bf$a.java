package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bf$a
  extends di<bf>
{
  public void a(cy paramcy, bf parambf)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      parambf.i();
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
      if (localct.b == 12)
      {
        parambf.a = new aj();
        parambf.a.a(paramcy);
        parambf.a(true);
      }
      else
      {
        db.a(paramcy, localct.b);
        continue;
        if (localct.b == 12)
        {
          parambf.b = new ai();
          parambf.b.a(paramcy);
          parambf.b(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 12)
          {
            parambf.c = new ak();
            parambf.c.a(paramcy);
            parambf.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 12)
            {
              parambf.d = new ax();
              parambf.d.a(paramcy);
              parambf.d(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 12)
              {
                parambf.e = new ah();
                parambf.e.a(paramcy);
                parambf.e(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 15)
                {
                  cu localcu2 = paramcy.l();
                  parambf.f = new ArrayList(localcu2.b);
                  for (int j = 0; j < localcu2.b; j++)
                  {
                    av localav = new av();
                    localav.a(paramcy);
                    parambf.f.add(localav);
                  }
                  paramcy.m();
                  parambf.f(true);
                }
                else
                {
                  db.a(paramcy, localct.b);
                  continue;
                  if (localct.b == 15)
                  {
                    cu localcu1 = paramcy.l();
                    parambf.g = new ArrayList(localcu1.b);
                    for (int i = 0; i < localcu1.b; i++)
                    {
                      bd localbd = new bd();
                      localbd.a(paramcy);
                      parambf.g.add(localbd);
                    }
                    paramcy.m();
                    parambf.g(true);
                  }
                  else
                  {
                    db.a(paramcy, localct.b);
                    continue;
                    if (localct.b == 12)
                    {
                      parambf.h = new at();
                      parambf.h.a(paramcy);
                      parambf.h(true);
                    }
                    else
                    {
                      db.a(paramcy, localct.b);
                      continue;
                      if (localct.b == 12)
                      {
                        parambf.i = new as();
                        parambf.i.a(paramcy);
                        parambf.i(true);
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
          }
        }
      }
    }
  }
  
  public void b(cy paramcy, bf parambf)
  {
    parambf.i();
    paramcy.a(bf.j());
    if (parambf.a != null)
    {
      paramcy.a(bf.k());
      parambf.a.b(paramcy);
      paramcy.b();
    }
    if (parambf.b != null)
    {
      paramcy.a(bf.l());
      parambf.b.b(paramcy);
      paramcy.b();
    }
    if (parambf.c != null)
    {
      paramcy.a(bf.m());
      parambf.c.b(paramcy);
      paramcy.b();
    }
    if (parambf.d != null)
    {
      paramcy.a(bf.n());
      parambf.d.b(paramcy);
      paramcy.b();
    }
    if ((parambf.e != null) && (parambf.a()))
    {
      paramcy.a(bf.o());
      parambf.e.b(paramcy);
      paramcy.b();
    }
    if ((parambf.f != null) && (parambf.d()))
    {
      paramcy.a(bf.p());
      paramcy.a(new cu((byte)12, parambf.f.size()));
      Iterator localIterator2 = parambf.f.iterator();
      while (localIterator2.hasNext()) {
        ((av)localIterator2.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    if ((parambf.g != null) && (parambf.f()))
    {
      paramcy.a(bf.q());
      paramcy.a(new cu((byte)12, parambf.g.size()));
      Iterator localIterator1 = parambf.g.iterator();
      while (localIterator1.hasNext()) {
        ((bd)localIterator1.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    if ((parambf.h != null) && (parambf.g()))
    {
      paramcy.a(bf.r());
      parambf.h.b(paramcy);
      paramcy.b();
    }
    if ((parambf.i != null) && (parambf.h()))
    {
      paramcy.a(bf.s());
      parambf.i.b(paramcy);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bf.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */