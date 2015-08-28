package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.RSS14Reader;
import com.google.zxing.oned.rss.expanded.RSSExpandedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatOneDReader
  extends OneDReader
{
  private final OneDReader[] a;
  
  public MultiFormatOneDReader(Map<DecodeHintType, ?> paramMap)
  {
    Collection localCollection;
    if (paramMap == null)
    {
      localCollection = null;
      if ((paramMap == null) || (paramMap.get(DecodeHintType.g) == null)) {
        break label467;
      }
    }
    label467:
    for (boolean bool = true;; bool = false)
    {
      ArrayList localArrayList = new ArrayList();
      if (localCollection != null)
      {
        if ((localCollection.contains(BarcodeFormat.h)) || (localCollection.contains(BarcodeFormat.o)) || (localCollection.contains(BarcodeFormat.g)) || (localCollection.contains(BarcodeFormat.p))) {
          localArrayList.add(new MultiFormatUPCEANReader(paramMap));
        }
        if (localCollection.contains(BarcodeFormat.c)) {
          localArrayList.add(new Code39Reader(bool));
        }
        if (localCollection.contains(BarcodeFormat.d)) {
          localArrayList.add(new Code93Reader());
        }
        if (localCollection.contains(BarcodeFormat.e)) {
          localArrayList.add(new Code128Reader());
        }
        if (localCollection.contains(BarcodeFormat.i)) {
          localArrayList.add(new ITFReader());
        }
        if (localCollection.contains(BarcodeFormat.b)) {
          localArrayList.add(new CodaBarReader());
        }
        if (localCollection.contains(BarcodeFormat.m)) {
          localArrayList.add(new RSS14Reader());
        }
        if (localCollection.contains(BarcodeFormat.n)) {
          localArrayList.add(new RSSExpandedReader());
        }
      }
      if (localArrayList.isEmpty())
      {
        localArrayList.add(new MultiFormatUPCEANReader(paramMap));
        localArrayList.add(new Code39Reader());
        localArrayList.add(new CodaBarReader());
        localArrayList.add(new Code93Reader());
        localArrayList.add(new Code128Reader());
        localArrayList.add(new ITFReader());
        localArrayList.add(new RSS14Reader());
        localArrayList.add(new RSSExpandedReader());
      }
      this.a = ((OneDReader[])localArrayList.toArray(new OneDReader[localArrayList.size()]));
      return;
      localCollection = (Collection)paramMap.get(DecodeHintType.c);
      break;
    }
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    OneDReader[] arrayOfOneDReader = this.a;
    int i = arrayOfOneDReader.length;
    int j = 0;
    while (j < i)
    {
      OneDReader localOneDReader = arrayOfOneDReader[j];
      try
      {
        Result localResult = localOneDReader.a(paramInt, paramBitArray, paramMap);
        return localResult;
      }
      catch (ReaderException localReaderException)
      {
        j++;
      }
    }
    throw NotFoundException.a();
  }
  
  public void a()
  {
    OneDReader[] arrayOfOneDReader = this.a;
    int i = arrayOfOneDReader.length;
    for (int j = 0; j < i; j++) {
      arrayOfOneDReader[j].a();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.MultiFormatOneDReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */