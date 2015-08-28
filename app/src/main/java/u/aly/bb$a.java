package u.aly;

class bb$a
  extends di<bb>
{
  public void a(cy paramcy, bb parambb)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!parambb.a()) {
        throw new cz("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
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
          parambb.a = paramcy.s();
          parambb.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            parambb.b = paramcy.v();
            parambb.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 12)
            {
              parambb.c = new at();
              parambb.c.a(paramcy);
              parambb.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    parambb.f();
  }
  
  public void b(cy paramcy, bb parambb)
  {
    parambb.f();
    paramcy.a(bb.g());
    paramcy.a(bb.h());
    paramcy.a(parambb.a);
    paramcy.b();
    if ((parambb.b != null) && (parambb.c()))
    {
      paramcy.a(bb.i());
      paramcy.a(parambb.b);
      paramcy.b();
    }
    if ((parambb.c != null) && (parambb.e()))
    {
      paramcy.a(bb.j());
      parambb.c.b(paramcy);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bb.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */