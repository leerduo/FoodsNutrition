package u.aly;

class ay$a
  extends di<ay>
{
  public void a(cy paramcy, ay paramay)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramay.a()) {
        throw new cz("Required field 'duration' was not found in serialized data! Struct: " + toString());
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
          paramay.a = paramcy.v();
          paramay.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            paramay.b = paramcy.t();
            paramay.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
          }
        }
      }
    }
    paramay.b();
  }
  
  public void b(cy paramcy, ay paramay)
  {
    paramay.b();
    paramcy.a(ay.c());
    if (paramay.a != null)
    {
      paramcy.a(ay.d());
      paramcy.a(paramay.a);
      paramcy.b();
    }
    paramcy.a(ay.e());
    paramcy.a(paramay.b);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ay.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */