package u.aly;

import java.io.Serializable;

public class cm
  implements Serializable
{
  private final boolean a;
  public final byte b;
  private final String c;
  private final boolean d;
  
  public cm(byte paramByte)
  {
    this(paramByte, false);
  }
  
  public cm(byte paramByte, boolean paramBoolean)
  {
    this.b = paramByte;
    this.a = false;
    this.c = null;
    this.d = paramBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.cm
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */