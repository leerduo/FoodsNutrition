package u.aly;

class ba$a
  extends di<ba>
{
  public void a(cy paramcy, ba paramba)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramba.a()) {
        throw new cz("Required field 'height' was not found in serialized data! Struct: " + toString());
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
          paramba.a = paramcy.s();
          paramba.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 8)
          {
            paramba.b = paramcy.s();
            paramba.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
          }
        }
      }
    }
    if (!paramba.b()) {
      throw new cz("Required field 'width' was not found in serialized data! Struct: " + toString());
    }
    paramba.c();
  }
  
  public void b(cy paramcy, ba paramba)
  {
    paramba.c();
    paramcy.a(ba.d());
    paramcy.a(ba.e());
    paramcy.a(paramba.a);
    paramcy.b();
    paramcy.a(ba.f());
    paramcy.a(paramba.b);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ba.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */