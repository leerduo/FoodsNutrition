package com.google.zxing.client.result;

public final class GeoParsedResult
  extends ParsedResult
{
  private final double a;
  private final double b;
  private final double c;
  private final String d;
  
  GeoParsedResult(double paramDouble1, double paramDouble2, double paramDouble3, String paramString)
  {
    super(ParsedResultType.f);
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramDouble3;
    this.d = paramString;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    if (this.c > 0.0D)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(this.c);
      localStringBuilder.append('m');
    }
    if (this.d != null)
    {
      localStringBuilder.append(" (");
      localStringBuilder.append(this.d);
      localStringBuilder.append(')');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.GeoParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */