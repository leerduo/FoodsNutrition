package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder
{
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.h);
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    int j = paramInt2 + paramInt3;
    if (paramInt4 == 0) {}
    int[] arrayOfInt;
    for (int k = 1;; k = 2)
    {
      arrayOfInt = new int[j / k];
      for (int m = 0; m < j; m++) {
        if ((paramInt4 == 0) || (m % 2 == paramInt4 - 1)) {
          arrayOfInt[(m / k)] = (0xFF & paramArrayOfByte[(m + paramInt1)]);
        }
      }
    }
    try
    {
      this.a.a(arrayOfInt, paramInt3 / k);
      while (i < paramInt2)
      {
        if ((paramInt4 == 0) || (i % 2 == paramInt4 - 1)) {
          paramArrayOfByte[(i + paramInt1)] = ((byte)arrayOfInt[(i / k)]);
        }
        i++;
      }
      return;
    }
    catch (ReedSolomonException localReedSolomonException)
    {
      throw ChecksumException.a();
    }
  }
  
  public DecoderResult a(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap)
  {
    byte[] arrayOfByte1 = new BitMatrixParser(paramBitMatrix).a();
    a(arrayOfByte1, 0, 10, 10, 0);
    int i = 0xF & arrayOfByte1[0];
    switch (i)
    {
    default: 
      throw FormatException.a();
    case 2: 
    case 3: 
    case 4: 
      a(arrayOfByte1, 20, 84, 40, 1);
      a(arrayOfByte1, 20, 84, 40, 2);
    }
    for (byte[] arrayOfByte2 = new byte[94];; arrayOfByte2 = new byte[78])
    {
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 10);
      System.arraycopy(arrayOfByte1, 20, arrayOfByte2, 10, -10 + arrayOfByte2.length);
      return DecodedBitStreamParser.a(arrayOfByte2, i);
      a(arrayOfByte1, 20, 68, 56, 1);
      a(arrayOfByte1, 20, 68, 56, 2);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.maxicode.decoder.Decoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */