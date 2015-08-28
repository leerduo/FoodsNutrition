package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ao$a
  extends di<ao>
{
  public void a(cy paramcy, ao paramao)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramao.c()) {
        throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
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
          paramao.a = paramcy.v();
          paramao.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 13)
          {
            cv localcv = paramcy.j();
            paramao.b = new HashMap(2 * localcv.c);
            for (int i = 0; i < localcv.c; i++)
            {
              String str = paramcy.v();
              az localaz = new az();
              localaz.a(paramcy);
              paramao.b.put(str, localaz);
            }
            paramcy.k();
            paramao.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 10)
            {
              paramao.c = paramcy.t();
              paramao.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 8)
              {
                paramao.d = paramcy.s();
                paramao.d(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 10)
                {
                  paramao.e = paramcy.t();
                  paramao.e(true);
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
    paramao.d();
  }
  
  public void b(cy paramcy, ao paramao)
  {
    paramao.d();
    paramcy.a(ao.e());
    if (paramao.a != null)
    {
      paramcy.a(ao.f());
      paramcy.a(paramao.a);
      paramcy.b();
    }
    if (paramao.b != null)
    {
      paramcy.a(ao.g());
      paramcy.a(new cv((byte)11, (byte)12, paramao.b.size()));
      Iterator localIterator = paramao.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramcy.a((String)localEntry.getKey());
        ((az)localEntry.getValue()).b(paramcy);
      }
      paramcy.d();
      paramcy.b();
    }
    if (paramao.a())
    {
      paramcy.a(ao.h());
      paramcy.a(paramao.c);
      paramcy.b();
    }
    if (paramao.b())
    {
      paramcy.a(ao.i());
      paramcy.a(paramao.d);
      paramcy.b();
    }
    paramcy.a(ao.j());
    paramcy.a(paramao.e);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ao.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */