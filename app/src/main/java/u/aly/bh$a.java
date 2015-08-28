package u.aly;

class bh$a
  extends di<bh>
{
  public void a(cy paramcy, bh parambh)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!parambh.a()) {
        throw new cz("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
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
          parambh.a = paramcy.v();
          parambh.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            parambh.b = paramcy.v();
            parambh.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              parambh.c = paramcy.v();
              parambh.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 8)
              {
                parambh.d = paramcy.s();
                parambh.d(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 8)
                {
                  parambh.e = paramcy.s();
                  parambh.e(true);
                }
                else
                {
                  db.a(paramcy, localct.b);
                  continue;
                  if (localct.b == 8)
                  {
                    parambh.f = paramcy.s();
                    parambh.f(true);
                  }
                  else
                  {
                    db.a(paramcy, localct.b);
                    continue;
                    if (localct.b == 11)
                    {
                      parambh.g = paramcy.w();
                      parambh.g(true);
                    }
                    else
                    {
                      db.a(paramcy, localct.b);
                      continue;
                      if (localct.b == 11)
                      {
                        parambh.h = paramcy.v();
                        parambh.h(true);
                      }
                      else
                      {
                        db.a(paramcy, localct.b);
                        continue;
                        if (localct.b == 11)
                        {
                          parambh.i = paramcy.v();
                          parambh.i(true);
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
    if (!parambh.b()) {
      throw new cz("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
    }
    if (!parambh.c()) {
      throw new cz("Required field 'length' was not found in serialized data! Struct: " + toString());
    }
    parambh.d();
  }
  
  public void b(cy paramcy, bh parambh)
  {
    parambh.d();
    paramcy.a(bh.e());
    if (parambh.a != null)
    {
      paramcy.a(bh.f());
      paramcy.a(parambh.a);
      paramcy.b();
    }
    if (parambh.b != null)
    {
      paramcy.a(bh.g());
      paramcy.a(parambh.b);
      paramcy.b();
    }
    if (parambh.c != null)
    {
      paramcy.a(bh.h());
      paramcy.a(parambh.c);
      paramcy.b();
    }
    paramcy.a(bh.i());
    paramcy.a(parambh.d);
    paramcy.b();
    paramcy.a(bh.j());
    paramcy.a(parambh.e);
    paramcy.b();
    paramcy.a(bh.k());
    paramcy.a(parambh.f);
    paramcy.b();
    if (parambh.g != null)
    {
      paramcy.a(bh.l());
      paramcy.a(parambh.g);
      paramcy.b();
    }
    if (parambh.h != null)
    {
      paramcy.a(bh.m());
      paramcy.a(parambh.h);
      paramcy.b();
    }
    if (parambh.i != null)
    {
      paramcy.a(bh.n());
      paramcy.a(parambh.i);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bh.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */