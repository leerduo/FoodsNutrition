package com.google.zxing.integration.android;

public final class IntentResult
{
  private final String a;
  private final String b;
  private final byte[] c;
  private final Integer d;
  private final String e;
  
  IntentResult()
  {
    this(null, null, null, null, null);
  }
  
  IntentResult(String paramString1, String paramString2, byte[] paramArrayOfByte, Integer paramInteger, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfByte;
    this.d = paramInteger;
    this.e = paramString3;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("Format: ").append(this.b).append('\n');
    localStringBuilder.append("Contents: ").append(this.a).append('\n');
    if (this.c == null) {}
    for (int i = 0;; i = this.c.length)
    {
      localStringBuilder.append("Raw bytes: (").append(i).append(" bytes)\n");
      localStringBuilder.append("Orientation: ").append(this.d).append('\n');
      localStringBuilder.append("EC level: ").append(this.e).append('\n');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.integration.android.IntentResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */