package u.aly;

class ah$a
  extends di<ah>
{
  public void a(cy paramcy, ah paramah)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramah.a()) {
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
          paramah.a = paramcy.t();
          paramah.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
        }
      }
    }
    paramah.b();
  }
  
  public void b(cy paramcy, ah paramah)
  {
    paramah.b();
    paramcy.a(ah.c());
    paramcy.a(ah.d());
    paramcy.a(paramah.a);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ah.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */