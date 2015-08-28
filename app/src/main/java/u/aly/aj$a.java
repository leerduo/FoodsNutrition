package u.aly;

class aj$a
  extends di<aj>
{
  public void a(cy paramcy, aj paramaj)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramaj.a()) {
        throw new cz("Required field 'successful_requests' was not found in serialized data! Struct: " + toString());
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
        if (localct.b == 8)
        {
          paramaj.a = paramcy.s();
          paramaj.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 8)
          {
            paramaj.b = paramcy.s();
            paramaj.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 8)
            {
              paramaj.c = paramcy.s();
              paramaj.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    if (!paramaj.b()) {
      throw new cz("Required field 'failed_requests' was not found in serialized data! Struct: " + toString());
    }
    paramaj.d();
  }
  
  public void b(cy paramcy, aj paramaj)
  {
    paramaj.d();
    paramcy.a(aj.e());
    paramcy.a(aj.f());
    paramcy.a(paramaj.a);
    paramcy.b();
    paramcy.a(aj.g());
    paramcy.a(paramaj.b);
    paramcy.b();
    if (paramaj.c())
    {
      paramcy.a(aj.h());
      paramcy.a(paramaj.c);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aj.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */