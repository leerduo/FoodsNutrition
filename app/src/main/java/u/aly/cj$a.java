package u.aly;

class cj$a
  extends di<cj>
{
  public void a(cy paramcy, cj paramcj)
  {
    paramcj.c = null;
    paramcj.b = null;
    paramcy.f();
    ct localct = paramcy.h();
    paramcj.b = paramcj.a(paramcy, localct);
    if (paramcj.b != null) {
      paramcj.c = paramcj.b(localct.c);
    }
    paramcy.i();
    paramcy.h();
    paramcy.g();
  }
  
  public void b(cy paramcy, cj paramcj)
  {
    if ((paramcj.b() == null) || (paramcj.c() == null)) {
      throw new cz("Cannot write a TUnion with no set value!");
    }
    paramcy.a(paramcj.a());
    paramcy.a(paramcj.a(paramcj.c));
    paramcj.c(paramcy);
    paramcy.b();
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.cj.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */