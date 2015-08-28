package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatUPCEANReader
  extends OneDReader
{
  private final UPCEANReader[] a;
  
  public MultiFormatUPCEANReader(Map<DecodeHintType, ?> paramMap)
  {
    Collection localCollection;
    ArrayList localArrayList;
    if (paramMap == null)
    {
      localCollection = null;
      localArrayList = new ArrayList();
      if (localCollection != null)
      {
        if (!localCollection.contains(BarcodeFormat.h)) {
          break label190;
        }
        localArrayList.add(new EAN13Reader());
      }
    }
    for (;;)
    {
      if (localCollection.contains(BarcodeFormat.g)) {
        localArrayList.add(new EAN8Reader());
      }
      if (localCollection.contains(BarcodeFormat.p)) {
        localArrayList.add(new UPCEReader());
      }
      if (localArrayList.isEmpty())
      {
        localArrayList.add(new EAN13Reader());
        localArrayList.add(new EAN8Reader());
        localArrayList.add(new UPCEReader());
      }
      this.a = ((UPCEANReader[])localArrayList.toArray(new UPCEANReader[localArrayList.size()]));
      return;
      localCollection = (Collection)paramMap.get(DecodeHintType.c);
      break;
      label190:
      if (localCollection.contains(BarcodeFormat.o)) {
        localArrayList.add(new UPCAReader());
      }
    }
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt = UPCEANReader.a(paramBitArray);
    UPCEANReader[] arrayOfUPCEANReader = this.a;
    int i = arrayOfUPCEANReader.length;
    int j = 0;
    while (j < i)
    {
      UPCEANReader localUPCEANReader = arrayOfUPCEANReader[j];
      try
      {
        Result localResult1 = localUPCEANReader.a(paramInt, paramBitArray, arrayOfInt, paramMap);
        int k;
        Collection localCollection;
        if ((localResult1.d() == BarcodeFormat.h) && (localResult1.a().charAt(0) == '0'))
        {
          k = 1;
          if (paramMap != null) {
            break label162;
          }
          localCollection = null;
          label81:
          if ((localCollection != null) && (!localCollection.contains(BarcodeFormat.o))) {
            break label179;
          }
        }
        label162:
        label179:
        for (int m = 1;; m = 0)
        {
          if ((k == 0) || (m == 0)) {
            break label185;
          }
          Result localResult2 = new Result(localResult1.a().substring(1), localResult1.b(), localResult1.c(), BarcodeFormat.o);
          localResult2.a(localResult1.e());
          return localResult2;
          k = 0;
          break;
          localCollection = (Collection)paramMap.get(DecodeHintType.c);
          break label81;
        }
        label185:
        return localResult1;
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
    UPCEANReader[] arrayOfUPCEANReader = this.a;
    int i = arrayOfUPCEANReader.length;
    for (int j = 0; j < i; j++) {
      arrayOfUPCEANReader[j].a();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.MultiFormatUPCEANReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */