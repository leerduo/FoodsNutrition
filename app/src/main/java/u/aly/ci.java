package u.aly;

import java.io.ByteArrayOutputStream;

public class ci
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final dk b = new dk(this.a);
  private cy c;
  
  public ci()
  {
    this(new cs.a());
  }
  
  public ci(da paramda)
  {
    this.c = paramda.a(this.b);
  }
  
  public byte[] a(bz parambz)
  {
    this.a.reset();
    parambz.b(this.c);
    return this.a.toByteArray();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ci
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */