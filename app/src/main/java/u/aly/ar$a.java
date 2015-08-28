package u.aly;

class ar$a
  extends di<ar>
{
  public void a(cy paramcy, ar paramar)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramar.c()) {
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
          paramar.a = paramcy.v();
          paramar.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            paramar.b = paramcy.t();
            paramar.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 8)
            {
              paramar.c = paramcy.s();
              paramar.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    if (!paramar.e()) {
      throw new cz("Required field 'version' was not found in serialized data! Struct: " + toString());
    }
    paramar.f();
  }
  
  public void b(cy paramcy, ar paramar)
  {
    paramar.f();
    paramcy.a(ar.g());
    if (paramar.a != null)
    {
      paramcy.a(ar.h());
      paramcy.a(paramar.a);
      paramcy.b();
    }
    paramcy.a(ar.i());
    paramcy.a(paramar.b);
    paramcy.b();
    paramcy.a(ar.j());
    paramcy.a(paramar.c);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ar.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */