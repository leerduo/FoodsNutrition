package u.aly;

public class cr$a
  implements da
{
  protected boolean a = false;
  protected boolean b = true;
  protected int c;
  
  public cr$a()
  {
    this(false, true);
  }
  
  public cr$a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramBoolean1, paramBoolean2, 0);
  }
  
  public cr$a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramInt;
  }
  
  public cy a(dm paramdm)
  {
    cr localcr = new cr(paramdm, this.a, this.b);
    if (this.c != 0) {
      localcr.c(this.c);
    }
    return localcr;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.cr.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */