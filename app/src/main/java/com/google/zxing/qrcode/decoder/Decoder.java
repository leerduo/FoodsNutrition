package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder
{
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.e);
  
  private DecoderResult a(BitMatrixParser paramBitMatrixParser, Map<DecodeHintType, ?> paramMap)
  {
    Version localVersion = paramBitMatrixParser.b();
    ErrorCorrectionLevel localErrorCorrectionLevel = paramBitMatrixParser.a().a();
    DataBlock[] arrayOfDataBlock = DataBlock.a(paramBitMatrixParser.c(), localVersion, localErrorCorrectionLevel);
    int i = arrayOfDataBlock.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfDataBlock[j].a();
      j++;
    }
    byte[] arrayOfByte1 = new byte[k];
    int m = arrayOfDataBlock.length;
    int n = 0;
    int i3;
    for (int i1 = 0; n < m; i1 = i3)
    {
      DataBlock localDataBlock = arrayOfDataBlock[n];
      byte[] arrayOfByte2 = localDataBlock.b();
      int i2 = localDataBlock.a();
      a(arrayOfByte2, i2);
      i3 = i1;
      int i4 = 0;
      while (i4 < i2)
      {
        int i5 = i3 + 1;
        arrayOfByte1[i3] = arrayOfByte2[i4];
        i4++;
        i3 = i5;
      }
      n++;
    }
    return DecodedBitStreamParser.a(arrayOfByte1, localVersion, localErrorCorrectionLevel, paramMap);
  }
  
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
  
  /* Error */
  public DecoderResult a(com.google.zxing.common.BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap)
  {
    // Byte code:
    //   0: new 26	com/google/zxing/qrcode/decoder/BitMatrixParser
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 76	com/google/zxing/qrcode/decoder/BitMatrixParser:<init>	(Lcom/google/zxing/common/BitMatrix;)V
    //   8: astore_3
    //   9: aload_0
    //   10: aload_3
    //   11: aload_2
    //   12: invokespecial 78	com/google/zxing/qrcode/decoder/Decoder:a	(Lcom/google/zxing/qrcode/decoder/BitMatrixParser;Ljava/util/Map;)Lcom/google/zxing/common/DecoderResult;
    //   15: astore 11
    //   17: aload 11
    //   19: areturn
    //   20: astore 10
    //   22: aload 10
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 4
    //   29: aload_3
    //   30: invokevirtual 81	com/google/zxing/qrcode/decoder/BitMatrixParser:d	()V
    //   33: aload_3
    //   34: iconst_1
    //   35: invokevirtual 84	com/google/zxing/qrcode/decoder/BitMatrixParser:a	(Z)V
    //   38: aload_3
    //   39: invokevirtual 30	com/google/zxing/qrcode/decoder/BitMatrixParser:b	()Lcom/google/zxing/qrcode/decoder/Version;
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 33	com/google/zxing/qrcode/decoder/BitMatrixParser:a	()Lcom/google/zxing/qrcode/decoder/FormatInformation;
    //   47: pop
    //   48: aload_3
    //   49: invokevirtual 86	com/google/zxing/qrcode/decoder/BitMatrixParser:e	()V
    //   52: aload_0
    //   53: aload_3
    //   54: aload_2
    //   55: invokespecial 78	com/google/zxing/qrcode/decoder/Decoder:a	(Lcom/google/zxing/qrcode/decoder/BitMatrixParser;Ljava/util/Map;)Lcom/google/zxing/common/DecoderResult;
    //   58: astore 9
    //   60: aload 9
    //   62: new 88	com/google/zxing/qrcode/decoder/QRCodeDecoderMetaData
    //   65: dup
    //   66: iconst_1
    //   67: invokespecial 90	com/google/zxing/qrcode/decoder/QRCodeDecoderMetaData:<init>	(Z)V
    //   70: invokevirtual 95	com/google/zxing/common/DecoderResult:a	(Ljava/lang/Object;)V
    //   73: aload 9
    //   75: areturn
    //   76: astore 6
    //   78: aload 5
    //   80: ifnull +14 -> 94
    //   83: aload 5
    //   85: athrow
    //   86: astore 4
    //   88: aconst_null
    //   89: astore 5
    //   91: goto -62 -> 29
    //   94: aload 4
    //   96: ifnull +6 -> 102
    //   99: aload 4
    //   101: athrow
    //   102: aload 6
    //   104: athrow
    //   105: astore 6
    //   107: goto -29 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	Decoder
    //   0	110	1	paramBitMatrix	com.google.zxing.common.BitMatrix
    //   0	110	2	paramMap	Map<DecodeHintType, ?>
    //   8	46	3	localBitMatrixParser	BitMatrixParser
    //   27	1	4	localObject	Object
    //   86	14	4	localChecksumException1	ChecksumException
    //   24	66	5	localFormatException1	com.google.zxing.FormatException
    //   76	27	6	localFormatException2	com.google.zxing.FormatException
    //   105	1	6	localChecksumException2	ChecksumException
    //   58	16	9	localDecoderResult1	DecoderResult
    //   20	3	10	localFormatException3	com.google.zxing.FormatException
    //   15	3	11	localDecoderResult2	DecoderResult
    // Exception table:
    //   from	to	target	type
    //   9	17	20	com/google/zxing/FormatException
    //   29	73	76	com/google/zxing/FormatException
    //   9	17	86	com/google/zxing/ChecksumException
    //   29	73	105	com/google/zxing/ChecksumException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Decoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */