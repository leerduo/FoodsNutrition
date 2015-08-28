package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn
  extends DetectionResultColumn
{
  private final boolean a;
  
  DetectionResultRowIndicatorColumn(BoundingBox paramBoundingBox, boolean paramBoolean)
  {
    super(paramBoundingBox);
    this.a = paramBoolean;
  }
  
  private void a(Codeword[] paramArrayOfCodeword, BarcodeMetadata paramBarcodeMetadata)
  {
    int i = 0;
    if (i < paramArrayOfCodeword.length)
    {
      Codeword localCodeword = paramArrayOfCodeword[i];
      if (paramArrayOfCodeword[i] == null) {}
      for (;;)
      {
        i++;
        break;
        int j = localCodeword.g() % 30;
        int k = localCodeword.h();
        if (k > paramBarcodeMetadata.c())
        {
          paramArrayOfCodeword[i] = null;
        }
        else
        {
          if (!this.a) {
            k += 2;
          }
          switch (k % 3)
          {
          default: 
            break;
          case 0: 
            if (1 + j * 3 != paramBarcodeMetadata.d()) {
              paramArrayOfCodeword[i] = null;
            }
            break;
          case 1: 
            if ((j / 3 != paramBarcodeMetadata.b()) || (j % 3 != paramBarcodeMetadata.e())) {
              paramArrayOfCodeword[i] = null;
            }
            break;
          case 2: 
            if (j + 1 != paramBarcodeMetadata.a()) {
              paramArrayOfCodeword[i] = null;
            }
            break;
          }
        }
      }
    }
  }
  
  int a(BarcodeMetadata paramBarcodeMetadata)
  {
    Codeword[] arrayOfCodeword = b();
    c();
    a(arrayOfCodeword, paramBarcodeMetadata);
    BoundingBox localBoundingBox = a();
    ResultPoint localResultPoint1;
    ResultPoint localResultPoint2;
    label46:
    float f;
    int k;
    int m;
    int n;
    int i1;
    label97:
    int i3;
    int i4;
    int i5;
    if (this.a)
    {
      localResultPoint1 = localBoundingBox.e();
      if (!this.a) {
        break label150;
      }
      localResultPoint2 = localBoundingBox.g();
      int i = b((int)localResultPoint1.b());
      int j = b((int)localResultPoint2.b());
      f = (j - i) / paramBarcodeMetadata.c();
      k = -1;
      m = i;
      n = 0;
      i1 = 1;
      if (m >= j) {
        break label397;
      }
      if (arrayOfCodeword[m] != null) {
        break label159;
      }
      i3 = n;
      i4 = i1;
      i5 = k;
    }
    for (;;)
    {
      m++;
      k = i5;
      i1 = i4;
      n = i3;
      break label97;
      localResultPoint1 = localBoundingBox.f();
      break;
      label150:
      localResultPoint2 = localBoundingBox.h();
      break label46;
      label159:
      Codeword localCodeword = arrayOfCodeword[m];
      int i2 = localCodeword.h() - k;
      if (i2 == 0)
      {
        i3 = n + 1;
        i4 = i1;
        i5 = k;
      }
      else if (i2 == 1)
      {
        int i10 = Math.max(i1, n);
        i5 = localCodeword.h();
        i4 = i10;
        i3 = 1;
      }
      else if ((i2 < 0) || (localCodeword.h() >= paramBarcodeMetadata.c()) || (i2 > m))
      {
        arrayOfCodeword[m] = null;
        i3 = n;
        i4 = i1;
        i5 = k;
      }
      else
      {
        int i6;
        label298:
        int i8;
        if (i1 > 2)
        {
          i6 = i2 * (i1 - 2);
          if (i6 < m) {
            break label339;
          }
          i7 = 1;
          i8 = 1;
          label301:
          if ((i8 > i6) || (i7 != 0)) {
            break label351;
          }
          if (arrayOfCodeword[(m - i8)] == null) {
            break label345;
          }
        }
        label339:
        label345:
        for (int i7 = 1;; i7 = 0)
        {
          i8++;
          break label301;
          i6 = i2;
          break;
          i7 = 0;
          break label298;
        }
        label351:
        if (i7 != 0)
        {
          arrayOfCodeword[m] = null;
          i3 = n;
          i4 = i1;
          i5 = k;
        }
        else
        {
          int i9 = localCodeword.h();
          i4 = i1;
          i5 = i9;
          i3 = 1;
        }
      }
    }
    label397:
    return (int)(0.5D + f);
  }
  
  int b(BarcodeMetadata paramBarcodeMetadata)
  {
    BoundingBox localBoundingBox = a();
    ResultPoint localResultPoint1;
    ResultPoint localResultPoint2;
    label30:
    float f;
    Codeword[] arrayOfCodeword;
    int k;
    int m;
    int n;
    int i1;
    if (this.a)
    {
      localResultPoint1 = localBoundingBox.e();
      if (!this.a) {
        break label115;
      }
      localResultPoint2 = localBoundingBox.g();
      int i = b((int)localResultPoint1.b());
      int j = b((int)localResultPoint2.b());
      f = (j - i) / paramBarcodeMetadata.c();
      arrayOfCodeword = b();
      k = -1;
      m = i;
      n = 0;
      i1 = 1;
      label86:
      if (m >= j) {
        break label223;
      }
      if (arrayOfCodeword[m] != null) {
        break label124;
      }
    }
    for (;;)
    {
      m++;
      break label86;
      localResultPoint1 = localBoundingBox.f();
      break;
      label115:
      localResultPoint2 = localBoundingBox.h();
      break label30;
      label124:
      Codeword localCodeword = arrayOfCodeword[m];
      localCodeword.b();
      int i2 = localCodeword.h() - k;
      if (i2 == 0)
      {
        n++;
      }
      else if (i2 == 1)
      {
        int i3 = Math.max(i1, n);
        k = localCodeword.h();
        i1 = i3;
        n = 1;
      }
      else if (localCodeword.h() >= paramBarcodeMetadata.c())
      {
        arrayOfCodeword[m] = null;
      }
      else
      {
        k = localCodeword.h();
        n = 1;
      }
    }
    label223:
    return (int)(0.5D + f);
  }
  
  void c()
  {
    for (Codeword localCodeword : b()) {
      if (localCodeword != null) {
        localCodeword.b();
      }
    }
  }
  
  int[] d()
  {
    BarcodeMetadata localBarcodeMetadata = e();
    int[] arrayOfInt;
    if (localBarcodeMetadata == null) {
      arrayOfInt = null;
    }
    for (;;)
    {
      return arrayOfInt;
      b(localBarcodeMetadata);
      arrayOfInt = new int[localBarcodeMetadata.c()];
      for (Codeword localCodeword : b()) {
        if (localCodeword != null)
        {
          int k = localCodeword.h();
          if (k >= arrayOfInt.length) {
            throw FormatException.a();
          }
          arrayOfInt[k] = (1 + arrayOfInt[k]);
        }
      }
    }
  }
  
  BarcodeMetadata e()
  {
    Codeword[] arrayOfCodeword = b();
    BarcodeValue localBarcodeValue1 = new BarcodeValue();
    BarcodeValue localBarcodeValue2 = new BarcodeValue();
    BarcodeValue localBarcodeValue3 = new BarcodeValue();
    BarcodeValue localBarcodeValue4 = new BarcodeValue();
    int i = arrayOfCodeword.length;
    int j = 0;
    if (j < i)
    {
      Codeword localCodeword = arrayOfCodeword[j];
      if (localCodeword == null) {}
      for (;;)
      {
        j++;
        break;
        localCodeword.b();
        int k = localCodeword.g() % 30;
        int m = localCodeword.h();
        if (!this.a) {
          m += 2;
        }
        switch (m % 3)
        {
        default: 
          break;
        case 0: 
          localBarcodeValue2.a(1 + k * 3);
          break;
        case 1: 
          localBarcodeValue4.a(k / 3);
          localBarcodeValue3.a(k % 3);
          break;
        case 2: 
          localBarcodeValue1.a(k + 1);
        }
      }
    }
    if ((localBarcodeValue1.a().length == 0) || (localBarcodeValue2.a().length == 0) || (localBarcodeValue3.a().length == 0) || (localBarcodeValue4.a().length == 0) || (localBarcodeValue1.a()[0] < 1) || (localBarcodeValue2.a()[0] + localBarcodeValue3.a()[0] < 3) || (localBarcodeValue2.a()[0] + localBarcodeValue3.a()[0] > 90)) {
      return null;
    }
    BarcodeMetadata localBarcodeMetadata = new BarcodeMetadata(localBarcodeValue1.a()[0], localBarcodeValue2.a()[0], localBarcodeValue3.a()[0], localBarcodeValue4.a()[0]);
    a(arrayOfCodeword, localBarcodeMetadata);
    return localBarcodeMetadata;
  }
  
  boolean f()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "IsLeft: " + this.a + '\n' + super.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */