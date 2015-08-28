package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class BinaryShiftToken
  extends Token
{
  private final short b;
  private final short c;
  
  BinaryShiftToken(Token paramToken, int paramInt1, int paramInt2)
  {
    super(paramToken);
    this.b = ((short)paramInt1);
    this.c = ((short)paramInt2);
  }
  
  public void a(BitArray paramBitArray, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (i < this.c)
    {
      if ((i == 0) || ((i == 31) && (this.c <= 62)))
      {
        paramBitArray.b(31, 5);
        if (this.c <= 62) {
          break label78;
        }
        paramBitArray.b(-31 + this.c, 16);
      }
      for (;;)
      {
        paramBitArray.b(paramArrayOfByte[(i + this.b)], 8);
        i++;
        break;
        label78:
        if (i == 0) {
          paramBitArray.b(Math.min(this.c, 31), 5);
        } else {
          paramBitArray.b(-31 + this.c, 5);
        }
      }
    }
  }
  
  public String toString()
  {
    return "<" + this.b + "::" + (-1 + (this.b + this.c)) + '>';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.encoder.BinaryShiftToken
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */