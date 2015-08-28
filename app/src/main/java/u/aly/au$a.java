package u.aly;

class au$a
  extends di<au>
{
  public void a(cy paramcy, au paramau)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramau.d()) {
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
          paramau.a = paramcy.v();
          paramau.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            paramau.b = paramcy.t();
            paramau.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              paramau.c = paramcy.v();
              paramau.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    paramau.f();
  }
  
  public void b(cy paramcy, au paramau)
  {
    paramau.f();
    paramcy.a(au.g());
    if ((paramau.a != null) && (paramau.b()))
    {
      paramcy.a(au.h());
      paramcy.a(paramau.a);
      paramcy.b();
    }
    paramcy.a(au.i());
    paramcy.a(paramau.b);
    paramcy.b();
    if (paramau.c != null)
    {
      paramcy.a(au.j());
      paramcy.a(paramau.c);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.au.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */