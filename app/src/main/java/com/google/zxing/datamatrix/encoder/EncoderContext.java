package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.nio.charset.Charset;

final class EncoderContext
{
  int a;
  private final String b;
  private SymbolShapeHint c;
  private Dimension d;
  private Dimension e;
  private final StringBuilder f;
  private int g;
  private SymbolInfo h;
  private int i;
  
  EncoderContext(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes(Charset.forName("ISO-8859-1"));
    StringBuilder localStringBuilder = new StringBuilder(arrayOfByte.length);
    int j = 0;
    int k = arrayOfByte.length;
    while (j < k)
    {
      char c1 = (char)(0xFF & arrayOfByte[j]);
      if ((c1 == '?') && (paramString.charAt(j) != '?')) {
        throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
      }
      localStringBuilder.append(c1);
      j++;
    }
    this.b = localStringBuilder.toString();
    this.c = SymbolShapeHint.a;
    this.f = new StringBuilder(paramString.length());
    this.g = -1;
  }
  
  private int l()
  {
    return this.b.length() - this.i;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(char paramChar)
  {
    this.f.append(paramChar);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(Dimension paramDimension1, Dimension paramDimension2)
  {
    this.d = paramDimension1;
    this.e = paramDimension2;
  }
  
  public void a(SymbolShapeHint paramSymbolShapeHint)
  {
    this.c = paramSymbolShapeHint;
  }
  
  public void a(String paramString)
  {
    this.f.append(paramString);
  }
  
  public char b()
  {
    return this.b.charAt(this.a);
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public StringBuilder c()
  {
    return this.f;
  }
  
  public void c(int paramInt)
  {
    if ((this.h == null) || (paramInt > this.h.h())) {
      this.h = SymbolInfo.a(paramInt, this.c, this.d, this.e, true);
    }
  }
  
  public int d()
  {
    return this.f.length();
  }
  
  public int e()
  {
    return this.g;
  }
  
  public void f()
  {
    this.g = -1;
  }
  
  public boolean g()
  {
    return this.a < l();
  }
  
  public int h()
  {
    return l() - this.a;
  }
  
  public SymbolInfo i()
  {
    return this.h;
  }
  
  public void j()
  {
    c(d());
  }
  
  public void k()
  {
    this.h = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.EncoderContext
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */