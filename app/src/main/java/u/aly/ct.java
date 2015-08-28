package u.aly;

public class ct
{
  public final String a;
  public final byte b;
  public final short c;
  
  public ct()
  {
    this("", (byte)0, (short)0);
  }
  
  public ct(String paramString, byte paramByte, short paramShort)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramShort;
  }
  
  public String toString()
  {
    return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ct
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */