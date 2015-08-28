package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class SimpleToken
  extends Token
{
  private final short b;
  private final short c;
  
  SimpleToken(Token paramToken, int paramInt1, int paramInt2)
  {
    super(paramToken);
    this.b = ((short)paramInt1);
    this.c = ((short)paramInt2);
  }
  
  void a(BitArray paramBitArray, byte[] paramArrayOfByte)
  {
    paramBitArray.b(this.b, this.c);
  }
  
  public String toString()
  {
    int i = this.b & -1 + (1 << this.c) | 1 << this.c;
    return '<' + Integer.toBinaryString(i | 1 << this.c).substring(1) + '>';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.encoder.SimpleToken
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */