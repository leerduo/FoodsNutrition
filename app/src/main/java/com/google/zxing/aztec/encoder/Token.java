package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

abstract class Token
{
  static final Token a = new SimpleToken(null, 0, 0);
  private final Token b;
  
  Token(Token paramToken)
  {
    this.b = paramToken;
  }
  
  final Token a()
  {
    return this.b;
  }
  
  final Token a(int paramInt1, int paramInt2)
  {
    return new SimpleToken(this, paramInt1, paramInt2);
  }
  
  abstract void a(BitArray paramBitArray, byte[] paramArrayOfByte);
  
  final Token b(int paramInt1, int paramInt2)
  {
    return new BinaryShiftToken(this, paramInt1, paramInt2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.encoder.Token
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */