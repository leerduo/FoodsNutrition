package com.google.zxing;

import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatReader
  implements Reader
{
  private Map<DecodeHintType, ?> a;
  private Reader[] b;
  
  private Result b(BinaryBitmap paramBinaryBitmap)
  {
    if (this.b != null)
    {
      Reader[] arrayOfReader = this.b;
      int i = arrayOfReader.length;
      int j = 0;
      while (j < i)
      {
        Reader localReader = arrayOfReader[j];
        try
        {
          Result localResult = localReader.a(paramBinaryBitmap, this.a);
          return localResult;
        }
        catch (ReaderException localReaderException)
        {
          j++;
        }
      }
    }
    throw NotFoundException.a();
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap)
  {
    if (this.b == null) {
      a(null);
    }
    return b(paramBinaryBitmap);
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    a(paramMap);
    return b(paramBinaryBitmap);
  }
  
  public void a()
  {
    if (this.b != null)
    {
      Reader[] arrayOfReader = this.b;
      int i = arrayOfReader.length;
      for (int j = 0; j < i; j++) {
        arrayOfReader[j].a();
      }
    }
  }
  
  public void a(Map<DecodeHintType, ?> paramMap)
  {
    this.a = paramMap;
    int i;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.d)))
    {
      i = 1;
      if (paramMap != null) {
        break label524;
      }
    }
    label524:
    for (Collection localCollection = null;; localCollection = (Collection)paramMap.get(DecodeHintType.c))
    {
      ArrayList localArrayList = new ArrayList();
      if (localCollection != null)
      {
        int j;
        if ((!localCollection.contains(BarcodeFormat.o)) && (!localCollection.contains(BarcodeFormat.p)) && (!localCollection.contains(BarcodeFormat.h)) && (!localCollection.contains(BarcodeFormat.g)) && (!localCollection.contains(BarcodeFormat.b)) && (!localCollection.contains(BarcodeFormat.c)) && (!localCollection.contains(BarcodeFormat.d)) && (!localCollection.contains(BarcodeFormat.e)) && (!localCollection.contains(BarcodeFormat.i)) && (!localCollection.contains(BarcodeFormat.m)))
        {
          boolean bool = localCollection.contains(BarcodeFormat.n);
          j = 0;
          if (!bool) {}
        }
        else
        {
          j = 1;
        }
        if ((j != 0) && (i == 0)) {
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        }
        if (localCollection.contains(BarcodeFormat.l)) {
          localArrayList.add(new QRCodeReader());
        }
        if (localCollection.contains(BarcodeFormat.f)) {
          localArrayList.add(new DataMatrixReader());
        }
        if (localCollection.contains(BarcodeFormat.a)) {
          localArrayList.add(new AztecReader());
        }
        if (localCollection.contains(BarcodeFormat.k)) {
          localArrayList.add(new PDF417Reader());
        }
        if (localCollection.contains(BarcodeFormat.j)) {
          localArrayList.add(new MaxiCodeReader());
        }
        if ((j != 0) && (i != 0)) {
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        }
      }
      if (localArrayList.isEmpty())
      {
        if (i == 0) {
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        }
        localArrayList.add(new QRCodeReader());
        localArrayList.add(new DataMatrixReader());
        localArrayList.add(new AztecReader());
        localArrayList.add(new PDF417Reader());
        localArrayList.add(new MaxiCodeReader());
        if (i != 0) {
          localArrayList.add(new MultiFormatOneDReader(paramMap));
        }
      }
      this.b = ((Reader[])localArrayList.toArray(new Reader[localArrayList.size()]));
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.MultiFormatReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */