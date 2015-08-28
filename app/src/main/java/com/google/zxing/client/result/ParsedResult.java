package com.google.zxing.client.result;

public abstract class ParsedResult
{
  private final ParsedResultType a;
  
  protected ParsedResult(ParsedResultType paramParsedResultType)
  {
    this.a = paramParsedResultType;
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append('\n');
      }
      paramStringBuilder.append(paramString);
    }
  }
  
  public static void a(String[] paramArrayOfString, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++) {
        a(paramArrayOfString[j], paramStringBuilder);
      }
    }
  }
  
  public abstract String g();
  
  public final String toString()
  {
    return g();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */