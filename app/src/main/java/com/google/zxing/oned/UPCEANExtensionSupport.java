package com.google.zxing.oned;

import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;

final class UPCEANExtensionSupport
{
  private static final int[] a = { 1, 1, 2 };
  private final UPCEANExtension2Support b = new UPCEANExtension2Support();
  private final UPCEANExtension5Support c = new UPCEANExtension5Support();
  
  Result a(int paramInt1, BitArray paramBitArray, int paramInt2)
  {
    int[] arrayOfInt = UPCEANReader.a(paramBitArray, paramInt2, false, a);
    try
    {
      Result localResult = this.c.a(paramInt1, paramBitArray, arrayOfInt);
      return localResult;
    }
    catch (ReaderException localReaderException) {}
    return this.b.a(paramInt1, paramBitArray, arrayOfInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCEANExtensionSupport
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */