package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bd$a
  extends di<bd>
{
  public void a(cy paramcy, bd parambd)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!parambd.a()) {
        throw new cz("Required field 'start_time' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
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
          parambd.a = paramcy.v();
          parambd.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            parambd.b = paramcy.t();
            parambd.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 10)
            {
              parambd.c = paramcy.t();
              parambd.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 10)
              {
                parambd.d = paramcy.t();
                parambd.d(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 15)
                {
                  cu localcu2 = paramcy.l();
                  parambd.e = new ArrayList(localcu2.b);
                  for (int j = 0; j < localcu2.b; j++)
                  {
                    ay localay = new ay();
                    localay.a(paramcy);
                    parambd.e.add(localay);
                  }
                  paramcy.m();
                  parambd.e(true);
                }
                else
                {
                  db.a(paramcy, localct.b);
                  continue;
                  if (localct.b == 15)
                  {
                    cu localcu1 = paramcy.l();
                    parambd.f = new ArrayList(localcu1.b);
                    for (int i = 0; i < localcu1.b; i++)
                    {
                      aw localaw = new aw();
                      localaw.a(paramcy);
                      parambd.f.add(localaw);
                    }
                    paramcy.m();
                    parambd.f(true);
                  }
                  else
                  {
                    db.a(paramcy, localct.b);
                    continue;
                    if (localct.b == 12)
                    {
                      parambd.g = new be();
                      parambd.g.a(paramcy);
                      parambd.g(true);
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
    if (!parambd.b()) {
      throw new cz("Required field 'end_time' was not found in serialized data! Struct: " + toString());
    }
    if (!parambd.c()) {
      throw new cz("Required field 'duration' was not found in serialized data! Struct: " + toString());
    }
    parambd.h();
  }
  
  public void b(cy paramcy, bd parambd)
  {
    parambd.h();
    paramcy.a(bd.i());
    if (parambd.a != null)
    {
      paramcy.a(bd.j());
      paramcy.a(parambd.a);
      paramcy.b();
    }
    paramcy.a(bd.k());
    paramcy.a(parambd.b);
    paramcy.b();
    paramcy.a(bd.l());
    paramcy.a(parambd.c);
    paramcy.b();
    paramcy.a(bd.m());
    paramcy.a(parambd.d);
    paramcy.b();
    if ((parambd.e != null) && (parambd.e()))
    {
      paramcy.a(bd.n());
      paramcy.a(new cu((byte)12, parambd.e.size()));
      Iterator localIterator2 = parambd.e.iterator();
      while (localIterator2.hasNext()) {
        ((ay)localIterator2.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    if ((parambd.f != null) && (parambd.f()))
    {
      paramcy.a(bd.o());
      paramcy.a(new cu((byte)12, parambd.f.size()));
      Iterator localIterator1 = parambd.f.iterator();
      while (localIterator1.hasNext()) {
        ((aw)localIterator1.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    if ((parambd.g != null) && (parambd.g()))
    {
      paramcy.a(bd.p());
      parambd.g.b(paramcy);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bd.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */