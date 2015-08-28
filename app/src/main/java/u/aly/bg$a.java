package u.aly;

class bg$a
  extends di<bg>
{
  public void a(cy paramcy, bg parambg)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      parambg.e();
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
      if (localct.b == 8)
      {
        parambg.a = ap.a(paramcy.s());
        parambg.a(true);
      }
      else
      {
        db.a(paramcy, localct.b);
        continue;
        if (localct.b == 8)
        {
          parambg.b = paramcy.s();
          parambg.b(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            parambg.c = paramcy.v();
            parambg.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              parambg.d = paramcy.v();
              parambg.d(true);
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
  
  public void b(cy paramcy, bg parambg)
  {
    parambg.e();
    paramcy.a(bg.f());
    if ((parambg.a != null) && (parambg.a()))
    {
      paramcy.a(bg.g());
      paramcy.a(parambg.a.a());
      paramcy.b();
    }
    if (parambg.b())
    {
      paramcy.a(bg.h());
      paramcy.a(parambg.b);
      paramcy.b();
    }
    if ((parambg.c != null) && (parambg.c()))
    {
      paramcy.a(bg.i());
      paramcy.a(parambg.c);
      paramcy.b();
    }
    if ((parambg.d != null) && (parambg.d()))
    {
      paramcy.a(bg.j());
      paramcy.a(parambg.d);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bg.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */