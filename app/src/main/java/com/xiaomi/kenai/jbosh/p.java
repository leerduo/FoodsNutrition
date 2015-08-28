package com.xiaomi.kenai.jbosh;

final class p
  extends a<String>
  implements Comparable
{
  private static final p a;
  private final int b;
  private final int c;
  
  static
  {
    try
    {
      a = a("1.8");
      return;
    }
    catch (aa localaa)
    {
      throw new IllegalStateException(localaa);
    }
  }
  
  private p(String paramString)
  {
    super(paramString);
    int i = paramString.indexOf('.');
    if (i <= 0) {
      throw new aa("Illegal ver attribute value (not in major.minor form): " + paramString);
    }
    String str1 = paramString.substring(0, i);
    try
    {
      this.b = Integer.parseInt(str1);
      if (this.b < 0) {
        throw new aa("Major version may not be < 0");
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      throw new aa("Could not parse ver attribute value (major ver): " + str1, localNumberFormatException1);
    }
    String str2 = paramString.substring(i + 1);
    try
    {
      this.c = Integer.parseInt(str2);
      if (this.c < 0) {
        throw new aa("Minor version may not be < 0");
      }
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      throw new aa("Could not parse ver attribute value (minor ver): " + str2, localNumberFormatException2);
    }
  }
  
  static p a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new p(paramString);
  }
  
  static p b()
  {
    return a;
  }
  
  public int compareTo(Object paramObject)
  {
    if ((paramObject instanceof p))
    {
      p localp = (p)paramObject;
      if (this.b < localp.b) {}
      do
      {
        return -1;
        if (this.b > localp.b) {
          return 1;
        }
      } while (this.c < localp.c);
      if (this.c > localp.c) {
        return 1;
      }
      return 0;
    }
    return 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.p
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */