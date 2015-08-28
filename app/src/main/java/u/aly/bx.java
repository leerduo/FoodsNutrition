package u.aly;

public class bx
{
  private short[] a;
  private int b = -1;
  
  public bx(int paramInt)
  {
    this.a = new short[paramInt];
  }
  
  private void c()
  {
    short[] arrayOfShort = new short[2 * this.a.length];
    System.arraycopy(this.a, 0, arrayOfShort, 0, this.a.length);
    this.a = arrayOfShort;
  }
  
  public short a()
  {
    short[] arrayOfShort = this.a;
    int i = this.b;
    this.b = (i - 1);
    return arrayOfShort[i];
  }
  
  public void a(short paramShort)
  {
    if (this.a.length == 1 + this.b) {
      c();
    }
    short[] arrayOfShort = this.a;
    int i = 1 + this.b;
    this.b = i;
    arrayOfShort[i] = paramShort;
  }
  
  public void b()
  {
    this.b = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<ShortStack vector:[");
    for (int i = 0; i < this.a.length; i++)
    {
      if (i != 0) {
        localStringBuilder.append(" ");
      }
      if (i == this.b) {
        localStringBuilder.append(">>");
      }
      localStringBuilder.append(this.a[i]);
      if (i == this.b) {
        localStringBuilder.append("<<");
      }
    }
    localStringBuilder.append("]>");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bx
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */