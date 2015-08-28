package u.aly;

class aq$a
  extends di<aq>
{
  public void a(cy paramcy, aq paramaq)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramaq.b()) {
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
          paramaq.a = paramcy.v();
          paramaq.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            paramaq.b = paramcy.v();
            paramaq.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              paramaq.c = paramcy.v();
              paramaq.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 10)
              {
                paramaq.d = paramcy.t();
                paramaq.d(true);
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
    paramaq.c();
  }
  
  public void b(cy paramcy, aq paramaq)
  {
    paramaq.c();
    paramcy.a(aq.d());
    if (paramaq.a != null)
    {
      paramcy.a(aq.e());
      paramcy.a(paramaq.a);
      paramcy.b();
    }
    if ((paramaq.b != null) && (paramaq.a()))
    {
      paramcy.a(aq.f());
      paramcy.a(paramaq.b);
      paramcy.b();
    }
    if (paramaq.c != null)
    {
      paramcy.a(aq.g());
      paramcy.a(paramaq.c);
      paramcy.b();
    }
    paramcy.a(aq.h());
    paramcy.a(paramaq.d);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aq.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */