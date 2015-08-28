package u.aly;

class aw$a
  extends di<aw>
{
  public void a(cy paramcy, aw paramaw)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramaw.a()) {
        throw new cz("Required field 'lat' was not found in serialized data! Struct: " + toString());
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
        if (localct.b == 4)
        {
          paramaw.a = paramcy.u();
          paramaw.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 4)
          {
            paramaw.b = paramcy.u();
            paramaw.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 10)
            {
              paramaw.c = paramcy.t();
              paramaw.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    if (!paramaw.b()) {
      throw new cz("Required field 'lng' was not found in serialized data! Struct: " + toString());
    }
    if (!paramaw.c()) {
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    }
    paramaw.d();
  }
  
  public void b(cy paramcy, aw paramaw)
  {
    paramaw.d();
    paramcy.a(aw.e());
    paramcy.a(aw.f());
    paramcy.a(paramaw.a);
    paramcy.b();
    paramcy.a(aw.g());
    paramcy.a(paramaw.b);
    paramcy.b();
    paramcy.a(aw.h());
    paramcy.a(paramaw.c);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aw.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */