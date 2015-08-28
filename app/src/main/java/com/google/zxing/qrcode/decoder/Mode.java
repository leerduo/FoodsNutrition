package com.google.zxing.qrcode.decoder;

public enum Mode
{
  private final int[] k;
  private final int l;
  
  static
  {
    Mode[] arrayOfMode = new Mode[10];
    arrayOfMode[0] = a;
    arrayOfMode[1] = b;
    arrayOfMode[2] = c;
    arrayOfMode[3] = d;
    arrayOfMode[4] = e;
    arrayOfMode[5] = f;
    arrayOfMode[6] = g;
    arrayOfMode[7] = h;
    arrayOfMode[8] = i;
    arrayOfMode[9] = j;
  }
  
  private Mode(int[] paramArrayOfInt, int paramInt)
  {
    this.k = paramArrayOfInt;
    this.l = paramInt;
  }
  
  public static Mode a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 0: 
      return a;
    case 1: 
      return b;
    case 2: 
      return c;
    case 3: 
      return d;
    case 4: 
      return e;
    case 5: 
      return h;
    case 7: 
      return f;
    case 8: 
      return g;
    case 9: 
      return i;
    }
    return j;
  }
  
  public int a()
  {
    return this.l;
  }
  
  public int a(Version paramVersion)
  {
    int n = paramVersion.a();
    int i1;
    if (n <= 9) {
      i1 = 0;
    }
    for (;;)
    {
      return this.k[i1];
      if (n <= 26) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Mode
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */