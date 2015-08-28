package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Code128Writer
  extends OneDimensionalCodeWriter
{
  private static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    int j = paramCharSequence.length();
    while ((paramInt1 < i) && (paramInt1 < j))
    {
      int k = paramCharSequence.charAt(paramInt1);
      if ((k < 48) || (k > 57))
      {
        if (k != 241) {
          return false;
        }
        i++;
      }
      paramInt1++;
    }
    if (i <= j) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.e) {
      throw new IllegalArgumentException("Can only encode CODE_128, but got " + paramBarcodeFormat);
    }
    return super.a(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }
  
  public boolean[] a(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    if ((j < 1) || (j > 80)) {
      throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + j);
    }
    for (int k = 0; k < j; k++)
    {
      char c = paramString.charAt(k);
      if ((c < ' ') || (c > '~')) {
        switch (c)
        {
        default: 
          throw new IllegalArgumentException("Bad character in input: " + c);
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    int n = 0;
    int i1 = 1;
    int i2 = 0;
    int i8;
    label179:
    int i9;
    label194:
    int i10;
    label254:
    int i11;
    if (m < j) {
      if (n == 99)
      {
        i8 = 2;
        if (!a(paramString, m, i8)) {
          break label317;
        }
        i9 = 99;
        if (i9 != n) {
          break label373;
        }
        switch (paramString.charAt(m))
        {
        default: 
          if (n == 100)
          {
            i10 = '￠' + paramString.charAt(m);
            m++;
            i9 = n;
            label261:
            localArrayList.add(Code128Reader.a[i10]);
            i11 = i2 + i10 * i1;
            if (m == 0) {
              break label561;
            }
          }
          break;
        }
      }
    }
    label561:
    for (int i12 = i1 + 1;; i12 = i1)
    {
      i1 = i12;
      i2 = i11;
      n = i9;
      break;
      i8 = 4;
      break label179;
      label317:
      i9 = 100;
      break label194;
      i10 = 102;
      break label254;
      i10 = 97;
      break label254;
      i10 = 96;
      break label254;
      i10 = 100;
      break label254;
      i10 = Integer.parseInt(paramString.substring(m, m + 2));
      m++;
      break label254;
      label373:
      if (n == 0)
      {
        if (i9 == 100)
        {
          i10 = 104;
          break label261;
        }
        i10 = 105;
        break label261;
      }
      i10 = i9;
      break label261;
      int i3 = i2 % 103;
      localArrayList.add(Code128Reader.a[i3]);
      localArrayList.add(Code128Reader.a[106]);
      Iterator localIterator1 = localArrayList.iterator();
      int i4 = 0;
      while (localIterator1.hasNext())
      {
        int[] arrayOfInt = (int[])localIterator1.next();
        int i5 = arrayOfInt.length;
        int i6 = 0;
        while (i6 < i5)
        {
          int i7 = i4 + arrayOfInt[i6];
          i6++;
          i4 = i7;
        }
      }
      boolean[] arrayOfBoolean = new boolean[i4];
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext()) {
        i += a(arrayOfBoolean, i, (int[])localIterator2.next(), true);
      }
      return arrayOfBoolean;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code128Writer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */