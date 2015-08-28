package u.aly;

class be$a
  extends di<be>
{
  public void a(cy paramcy, be parambe)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!parambe.a()) {
        throw new cz("Required field 'upload_traffic' was not found in serialized data! Struct: " + toString());
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
          parambe.a = paramcy.s();
          parambe.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 8)
          {
            parambe.b = paramcy.s();
            parambe.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
          }
        }
      }
    }
    if (!parambe.b()) {
      throw new cz("Required field 'download_traffic' was not found in serialized data! Struct: " + toString());
    }
    parambe.c();
  }
  
  public void b(cy paramcy, be parambe)
  {
    parambe.c();
    paramcy.a(be.d());
    paramcy.a(be.e());
    paramcy.a(parambe.a);
    paramcy.b();
    paramcy.a(be.f());
    paramcy.a(parambe.b);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.be.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */