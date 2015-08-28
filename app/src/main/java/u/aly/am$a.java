package u.aly;

class am$a
  extends di<am>
{
  public void a(cy paramcy, am paramam)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramam.a()) {
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
        if (localct.b == 10)
        {
          paramam.a = paramcy.t();
          paramam.b(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            paramam.b = paramcy.v();
            paramam.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 8)
            {
              paramam.c = an.a(paramcy.s());
              paramam.d(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    paramam.c();
  }
  
  public void b(cy paramcy, am paramam)
  {
    paramam.c();
    paramcy.a(am.d());
    paramcy.a(am.e());
    paramcy.a(paramam.a);
    paramcy.b();
    if (paramam.b != null)
    {
      paramcy.a(am.f());
      paramcy.a(paramam.b);
      paramcy.b();
    }
    if ((paramam.c != null) && (paramam.b()))
    {
      paramcy.a(am.g());
      paramcy.a(paramam.c.a());
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.am.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */