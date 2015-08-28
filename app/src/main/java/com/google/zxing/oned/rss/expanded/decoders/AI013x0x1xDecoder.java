package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI013x0x1xDecoder
  extends AI01weightDecoder
{
  private final String a;
  private final String b;
  
  AI013x0x1xDecoder(BitArray paramBitArray, String paramString1, String paramString2)
  {
    super(paramBitArray);
    this.a = paramString2;
    this.b = paramString1;
  }
  
  private void c(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = c().a(paramInt, 16);
    if (i == 38400) {
      return;
    }
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.a);
    paramStringBuilder.append(')');
    int j = i % 32;
    int k = i / 32;
    int m = 1 + k % 12;
    int n = k / 12;
    if (n / 10 == 0) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(n);
    if (m / 10 == 0) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(m);
    if (j / 10 == 0) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(j);
  }
  
  protected int a(int paramInt)
  {
    return paramInt % 100000;
  }
  
  public String a()
  {
    if (b().a() != 84) {
      throw NotFoundException.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 8);
    b(localStringBuilder, 48, 20);
    c(localStringBuilder, 68);
    return localStringBuilder.toString();
  }
  
  protected void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = paramInt / 100000;
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.b);
    paramStringBuilder.append(i);
    paramStringBuilder.append(')');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI013x0x1xDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */