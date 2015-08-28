package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class UPCAReader
  extends UPCEANReader
{
  private final UPCEANReader a = new EAN13Reader();
  
  private static Result a(Result paramResult)
  {
    String str = paramResult.a();
    if (str.charAt(0) == '0') {
      return new Result(str.substring(1), null, paramResult.c(), BarcodeFormat.o);
    }
    throw FormatException.a();
  }
  
  protected int a(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    return this.a.a(paramBitArray, paramArrayOfInt, paramStringBuilder);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    return a(this.a.a(paramInt, paramBitArray, paramMap));
  }
  
  public Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt, Map<DecodeHintType, ?> paramMap)
  {
    return a(this.a.a(paramInt, paramBitArray, paramArrayOfInt, paramMap));
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    return a(this.a.a(paramBinaryBitmap, paramMap));
  }
  
  BarcodeFormat b()
  {
    return BarcodeFormat.o;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCAReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */