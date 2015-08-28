package u.aly;

class cj$c
  extends dj<cj>
{
  public void a(cy paramcy, cj paramcj)
  {
    paramcj.c = null;
    paramcj.b = null;
    short s = paramcy.r();
    paramcj.b = paramcj.a(paramcy, s);
    if (paramcj.b != null) {
      paramcj.c = paramcj.b(s);
    }
  }
  
  public void b(cy paramcy, cj paramcj)
  {
    if ((paramcj.b() == null) || (paramcj.c() == null)) {
      throw new cz("Cannot write a TUnion with no set value!");
    }
    paramcy.a(paramcj.c.a());
    paramcj.d(paramcy);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.cj.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */