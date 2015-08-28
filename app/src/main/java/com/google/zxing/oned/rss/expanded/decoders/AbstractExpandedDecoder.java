package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder
{
  private final BitArray a;
  private final GeneralAppIdDecoder b;
  
  AbstractExpandedDecoder(BitArray paramBitArray)
  {
    this.a = paramBitArray;
    this.b = new GeneralAppIdDecoder(paramBitArray);
  }
  
  public static AbstractExpandedDecoder a(BitArray paramBitArray)
  {
    if (paramBitArray.a(1)) {
      return new AI01AndOtherAIs(paramBitArray);
    }
    if (!paramBitArray.a(2)) {
      return new AnyAIDecoder(paramBitArray);
    }
    switch (GeneralAppIdDecoder.a(paramBitArray, 1, 4))
    {
    default: 
      switch (GeneralAppIdDecoder.a(paramBitArray, 1, 5))
      {
      default: 
        switch (GeneralAppIdDecoder.a(paramBitArray, 1, 7))
        {
        default: 
          throw new IllegalStateException("unknown decoder: " + paramBitArray);
        }
        break;
      }
    case 4: 
      return new AI013103decoder(paramBitArray);
    }
    return new AI01320xDecoder(paramBitArray);
    return new AI01392xDecoder(paramBitArray);
    return new AI01393xDecoder(paramBitArray);
    return new AI013x0x1xDecoder(paramBitArray, "310", "11");
    return new AI013x0x1xDecoder(paramBitArray, "320", "11");
    return new AI013x0x1xDecoder(paramBitArray, "310", "13");
    return new AI013x0x1xDecoder(paramBitArray, "320", "13");
    return new AI013x0x1xDecoder(paramBitArray, "310", "15");
    return new AI013x0x1xDecoder(paramBitArray, "320", "15");
    return new AI013x0x1xDecoder(paramBitArray, "310", "17");
    return new AI013x0x1xDecoder(paramBitArray, "320", "17");
  }
  
  public abstract String a();
  
  protected final BitArray b()
  {
    return this.a;
  }
  
  protected final GeneralAppIdDecoder c()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */