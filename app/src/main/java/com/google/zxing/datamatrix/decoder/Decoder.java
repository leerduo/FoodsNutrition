package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Decoder
{
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.f);
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j];
    for (int k = 0; k < j; k++) {
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    }
    int m = paramArrayOfByte.length - paramInt;
    try
    {
      this.a.a(arrayOfInt, m);
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)arrayOfInt[i]);
        i++;
      }
      return;
    }
    catch (ReedSolomonException localReedSolomonException)
    {
      throw ChecksumException.a();
    }
  }
  
  public DecoderResult a(BitMatrix paramBitMatrix)
  {
    BitMatrixParser localBitMatrixParser = new BitMatrixParser(paramBitMatrix);
    Version localVersion = localBitMatrixParser.a();
    DataBlock[] arrayOfDataBlock = DataBlock.a(localBitMatrixParser.b(), localVersion);
    int i = arrayOfDataBlock.length;
    int j = arrayOfDataBlock.length;
    int k = 0;
    int m = 0;
    while (k < j)
    {
      m += arrayOfDataBlock[k].a();
      k++;
    }
    byte[] arrayOfByte1 = new byte[m];
    for (int n = 0; n < i; n++)
    {
      DataBlock localDataBlock = arrayOfDataBlock[n];
      byte[] arrayOfByte2 = localDataBlock.b();
      int i1 = localDataBlock.a();
      a(arrayOfByte2, i1);
      for (int i2 = 0; i2 < i1; i2++) {
        arrayOfByte1[(n + i2 * i)] = arrayOfByte2[i2];
      }
    }
    return DecodedBitStreamParser.a(arrayOfByte1);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.Decoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */