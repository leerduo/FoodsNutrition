package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class PDF417ScanningDecoder
{
  private static final ErrorCorrection a = new ErrorCorrection();
  
  private static int a(int paramInt)
  {
    return 2 << paramInt;
  }
  
  private static int a(DetectionResult paramDetectionResult, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    Codeword localCodeword1;
    for (int i = 1;; i = -1)
    {
      boolean bool = a(paramDetectionResult, paramInt1 - i);
      localCodeword1 = null;
      if (bool) {
        localCodeword1 = paramDetectionResult.a(paramInt1 - i).c(paramInt2);
      }
      if (localCodeword1 == null) {
        break label66;
      }
      if (!paramBoolean) {
        break;
      }
      return localCodeword1.e();
    }
    return localCodeword1.d();
    label66:
    Codeword localCodeword2 = paramDetectionResult.a(paramInt1).a(paramInt2);
    if (localCodeword2 != null)
    {
      if (paramBoolean) {
        return localCodeword2.d();
      }
      return localCodeword2.e();
    }
    if (a(paramDetectionResult, paramInt1 - i)) {
      localCodeword2 = paramDetectionResult.a(paramInt1 - i).a(paramInt2);
    }
    if (localCodeword2 != null)
    {
      if (paramBoolean) {
        return localCodeword2.e();
      }
      return localCodeword2.d();
    }
    for (int j = 0; a(paramDetectionResult, paramInt1 - i); j++)
    {
      paramInt1 -= i;
      for (Codeword localCodeword3 : paramDetectionResult.a(paramInt1).b()) {
        if (localCodeword3 != null)
        {
          if (paramBoolean) {}
          for (int n = localCodeword3.e();; n = localCodeword3.d()) {
            return n + i * j * (localCodeword3.e() - localCodeword3.d());
          }
        }
      }
    }
    if (paramBoolean) {
      return paramDetectionResult.e().a();
    }
    return paramDetectionResult.e().b();
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i = -1;
    int j = paramArrayOfInt.length;
    for (int k = 0; k < j; k++) {
      i = Math.max(i, paramArrayOfInt[k]);
    }
    return i;
  }
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    if (((paramArrayOfInt2 != null) && (paramArrayOfInt2.length > 3 + paramInt / 2)) || (paramInt < 0) || (paramInt > 512)) {
      throw ChecksumException.a();
    }
    return a.a(paramArrayOfInt1, paramInt, paramArrayOfInt2);
  }
  
  private static DecoderResult a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[][] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt3.length];
    int i = 100;
    int j = i - 1;
    if (i > 0)
    {
      for (int k = 0; k < arrayOfInt.length; k++) {
        paramArrayOfInt1[paramArrayOfInt3[k]] = paramArrayOfInt[k][arrayOfInt[k]];
      }
      int m;
      try
      {
        DecoderResult localDecoderResult = a(paramArrayOfInt1, paramInt, paramArrayOfInt2);
        return localDecoderResult;
      }
      catch (ChecksumException localChecksumException)
      {
        if (arrayOfInt.length == 0) {
          throw ChecksumException.a();
        }
        m = 0;
      }
      for (;;)
      {
        if (m < arrayOfInt.length)
        {
          if (arrayOfInt[m] < -1 + paramArrayOfInt[m].length) {
            arrayOfInt[m] = (1 + arrayOfInt[m]);
          }
        }
        else
        {
          i = j;
          break;
        }
        arrayOfInt[m] = 0;
        if (m == -1 + arrayOfInt.length) {
          throw ChecksumException.a();
        }
        m++;
      }
    }
    throw ChecksumException.a();
  }
  
  public static DecoderResult a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
  {
    BoundingBox localBoundingBox1 = new BoundingBox(paramBitMatrix, paramResultPoint1, paramResultPoint2, paramResultPoint3, paramResultPoint4);
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = localBoundingBox1;
    Object localObject3 = null;
    Object localObject4 = null;
    if (i < 2) {
      if (paramResultPoint1 == null) {
        break label502;
      }
    }
    label229:
    label502:
    for (Object localObject6 = a(paramBitMatrix, (BoundingBox)localObject2, paramResultPoint1, true, paramInt1, paramInt2);; localObject6 = localObject4)
    {
      if (paramResultPoint3 != null) {}
      for (Object localObject7 = a(paramBitMatrix, (BoundingBox)localObject2, paramResultPoint3, false, paramInt1, paramInt2);; localObject7 = localObject1)
      {
        DetectionResult localDetectionResult = a((DetectionResultRowIndicatorColumn)localObject6, (DetectionResultRowIndicatorColumn)localObject7);
        if (localDetectionResult == null) {
          throw NotFoundException.a();
        }
        if ((i == 0) && (localDetectionResult.e() != null) && ((localDetectionResult.e().c() < ((BoundingBox)localObject2).c()) || (localDetectionResult.e().d() > ((BoundingBox)localObject2).d())))
        {
          BoundingBox localBoundingBox2 = localDetectionResult.e();
          i++;
          localObject1 = localObject7;
          localObject3 = localDetectionResult;
          localObject2 = localBoundingBox2;
          localObject4 = localObject6;
          break;
        }
        localDetectionResult.a((BoundingBox)localObject2);
        localObject1 = localObject7;
        localObject3 = localDetectionResult;
        localObject4 = localObject6;
        int j = 1 + localObject3.b();
        localObject3.a(0, localObject4);
        localObject3.a(j, localObject1);
        boolean bool1;
        int k;
        int m;
        int n;
        if (localObject4 != null)
        {
          bool1 = true;
          k = 1;
          m = paramInt2;
          n = paramInt1;
          if (k > j) {
            break label482;
          }
          if (!bool1) {
            break label267;
          }
        }
        for (int i1 = k;; i1 = j - k)
        {
          if (localObject3.a(i1) == null) {
            break label277;
          }
          k++;
          break label229;
          bool1 = false;
          break;
        }
        boolean bool2;
        Object localObject5;
        int i2;
        int i3;
        int i4;
        int i5;
        if ((i1 == 0) || (i1 == j)) {
          if (i1 == 0)
          {
            bool2 = true;
            localObject5 = new DetectionResultRowIndicatorColumn((BoundingBox)localObject2, bool2);
            localObject3.a(i1, (DetectionResultColumn)localObject5);
            i2 = ((BoundingBox)localObject2).c();
            i3 = -1;
            if (i2 <= ((BoundingBox)localObject2).d())
            {
              i4 = a(localObject3, i1, i2, bool1);
              if ((i4 >= 0) && (i4 <= ((BoundingBox)localObject2).b())) {
                break label411;
              }
              if (i3 != -1) {
                break label407;
              }
              i5 = i3;
            }
          }
        }
        for (;;)
        {
          i2++;
          i3 = i5;
          break label329;
          break;
          bool2 = false;
          break label297;
          localObject5 = new DetectionResultColumn((BoundingBox)localObject2);
          break label310;
          i4 = i3;
          Codeword localCodeword = a(paramBitMatrix, ((BoundingBox)localObject2).a(), ((BoundingBox)localObject2).b(), bool1, i4, i2, n, m);
          if (localCodeword != null)
          {
            ((DetectionResultColumn)localObject5).a(i2, localCodeword);
            n = Math.min(n, localCodeword.c());
            m = Math.max(m, localCodeword.c());
            i5 = i4;
            continue;
            return a(localObject3);
          }
          else
          {
            i5 = i3;
          }
        }
      }
    }
  }
  
  private static DecoderResult a(DetectionResult paramDetectionResult)
  {
    int i = 0;
    BarcodeValue[][] arrayOfBarcodeValue = b(paramDetectionResult);
    a(paramDetectionResult, arrayOfBarcodeValue);
    ArrayList localArrayList1 = new ArrayList();
    int[] arrayOfInt1 = new int[paramDetectionResult.c() * paramDetectionResult.b()];
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    for (int j = 0; j < paramDetectionResult.c(); j++)
    {
      int k = 0;
      if (k < paramDetectionResult.b())
      {
        int[] arrayOfInt2 = arrayOfBarcodeValue[j][(k + 1)].a();
        int m = k + j * paramDetectionResult.b();
        if (arrayOfInt2.length == 0) {
          localArrayList1.add(Integer.valueOf(m));
        }
        for (;;)
        {
          k++;
          break;
          if (arrayOfInt2.length == 1)
          {
            arrayOfInt1[m] = arrayOfInt2[0];
          }
          else
          {
            localArrayList3.add(Integer.valueOf(m));
            localArrayList2.add(arrayOfInt2);
          }
        }
      }
    }
    int[][] arrayOfInt = new int[localArrayList2.size()][];
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = ((int[])localArrayList2.get(i));
      i++;
    }
    return a(paramDetectionResult.d(), arrayOfInt1, PDF417Common.a(localArrayList1), PDF417Common.a(localArrayList3), arrayOfInt);
  }
  
  private static DecoderResult a(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length == 0) {
      throw FormatException.a();
    }
    int i = 1 << paramInt + 1;
    int j = a(paramArrayOfInt1, paramArrayOfInt2, i);
    a(paramArrayOfInt1, i);
    DecoderResult localDecoderResult = DecodedBitStreamParser.a(paramArrayOfInt1, String.valueOf(paramInt));
    localDecoderResult.a(Integer.valueOf(j));
    localDecoderResult.b(Integer.valueOf(paramArrayOfInt2.length));
    return localDecoderResult;
  }
  
  private static BoundingBox a(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn)
  {
    if (paramDetectionResultRowIndicatorColumn == null) {}
    int[] arrayOfInt;
    do
    {
      return null;
      arrayOfInt = paramDetectionResultRowIndicatorColumn.d();
    } while (arrayOfInt == null);
    int i = a(arrayOfInt);
    int j = arrayOfInt.length;
    int k = 0;
    int m = 0;
    Codeword[] arrayOfCodeword;
    int n;
    for (;;)
    {
      if (k < j)
      {
        int i8 = arrayOfInt[k];
        m += i - i8;
        if (i8 <= 0) {}
      }
      else
      {
        arrayOfCodeword = paramDetectionResultRowIndicatorColumn.b();
        n = m;
        for (int i1 = 0; (n > 0) && (arrayOfCodeword[i1] == null); i1++) {
          n--;
        }
      }
      k++;
    }
    int i2 = -1 + arrayOfInt.length;
    int i3 = 0;
    int i6;
    for (int i4 = i2;; i4--) {
      if (i4 >= 0)
      {
        i3 += i - arrayOfInt[i4];
        if (arrayOfInt[i4] <= 0) {}
      }
      else
      {
        int i5 = -1 + arrayOfCodeword.length;
        i6 = i3;
        for (int i7 = i5; (i6 > 0) && (arrayOfCodeword[i7] == null); i7--) {
          i6--;
        }
      }
    }
    return paramDetectionResultRowIndicatorColumn.a().a(n, i6, paramDetectionResultRowIndicatorColumn.f());
  }
  
  private static Codeword a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = b(paramBitMatrix, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    int[] arrayOfInt = a(paramBitMatrix, paramInt1, paramInt2, paramBoolean, i, paramInt4);
    if (arrayOfInt == null) {
      return null;
    }
    int j = PDF417Common.a(arrayOfInt);
    int m;
    if (paramBoolean)
    {
      int i3 = i + j;
      m = i;
      i = i3;
    }
    while (!a(j, paramInt5, paramInt6))
    {
      return null;
      for (int k = 0; k < arrayOfInt.length >> 1; k++)
      {
        int i2 = arrayOfInt[k];
        arrayOfInt[k] = arrayOfInt[(-1 + arrayOfInt.length - k)];
        arrayOfInt[(-1 + arrayOfInt.length - k)] = i2;
      }
      m = i - j;
    }
    int n = PDF417CodewordDecoder.a(arrayOfInt);
    int i1 = PDF417Common.a(n);
    if (i1 == -1) {
      return null;
    }
    return new Codeword(m, i, c(n), i1);
  }
  
  private static DetectionResult a(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2)
  {
    if ((paramDetectionResultRowIndicatorColumn1 == null) && (paramDetectionResultRowIndicatorColumn2 == null)) {}
    BarcodeMetadata localBarcodeMetadata;
    do
    {
      return null;
      localBarcodeMetadata = b(paramDetectionResultRowIndicatorColumn1, paramDetectionResultRowIndicatorColumn2);
    } while (localBarcodeMetadata == null);
    return new DetectionResult(localBarcodeMetadata, BoundingBox.a(a(paramDetectionResultRowIndicatorColumn1), a(paramDetectionResultRowIndicatorColumn2)));
  }
  
  private static DetectionResultRowIndicatorColumn a(BitMatrix paramBitMatrix, BoundingBox paramBoundingBox, ResultPoint paramResultPoint, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DetectionResultRowIndicatorColumn localDetectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(paramBoundingBox, paramBoolean);
    for (int i = 0; i < 2; i++)
    {
      int j;
      int m;
      label42:
      Codeword localCodeword;
      if (i == 0)
      {
        j = 1;
        k = (int)paramResultPoint.a();
        m = (int)paramResultPoint.b();
        if ((m > paramBoundingBox.d()) || (m < paramBoundingBox.c())) {
          continue;
        }
        localCodeword = a(paramBitMatrix, 0, paramBitMatrix.f(), paramBoolean, k, m, paramInt1, paramInt2);
        if (localCodeword != null)
        {
          localDetectionResultRowIndicatorColumn.a(m, localCodeword);
          if (!paramBoolean) {
            break label121;
          }
        }
      }
      label121:
      for (int k = localCodeword.d();; k = localCodeword.e())
      {
        m += j;
        break label42;
        j = -1;
        break;
      }
    }
    return localDetectionResultRowIndicatorColumn;
  }
  
  private static void a(DetectionResult paramDetectionResult, BarcodeValue[][] paramArrayOfBarcodeValue)
  {
    int[] arrayOfInt = paramArrayOfBarcodeValue[0][1].a();
    int i = paramDetectionResult.b() * paramDetectionResult.c() - a(paramDetectionResult.d());
    if (arrayOfInt.length == 0)
    {
      if ((i < 1) || (i > 928)) {
        throw NotFoundException.a();
      }
      paramArrayOfBarcodeValue[0][1].a(i);
    }
    while (arrayOfInt[0] == i) {
      return;
    }
    paramArrayOfBarcodeValue[0][1].a(i);
  }
  
  private static void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt.length < 4) {
      throw FormatException.a();
    }
    int i = paramArrayOfInt[0];
    if (i > paramArrayOfInt.length) {
      throw FormatException.a();
    }
    if (i == 0)
    {
      if (paramInt < paramArrayOfInt.length) {
        paramArrayOfInt[0] = (paramArrayOfInt.length - paramInt);
      }
    }
    else {
      return;
    }
    throw FormatException.a();
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 - 2 <= paramInt1) && (paramInt1 <= paramInt3 + 2);
  }
  
  private static boolean a(DetectionResult paramDetectionResult, int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 1 + paramDetectionResult.b());
  }
  
  private static int[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = new int[8];
    int i;
    boolean bool;
    int j;
    if (paramBoolean)
    {
      i = 1;
      bool = paramBoolean;
      j = 0;
    }
    for (;;)
    {
      if (((!paramBoolean) || (paramInt3 >= paramInt2)) && ((paramBoolean) || (paramInt3 < paramInt1) || (j >= arrayOfInt.length))) {
        break label108;
      }
      if (paramBitMatrix.a(paramInt3, paramInt4) == bool)
      {
        arrayOfInt[j] = (1 + arrayOfInt[j]);
        paramInt3 += i;
        continue;
        i = -1;
        break;
      }
      j++;
      if (!bool) {
        bool = true;
      } else {
        bool = false;
      }
    }
    label108:
    if ((j == arrayOfInt.length) || (((paramBoolean) && (paramInt3 == paramInt2)) || ((!paramBoolean) && (paramInt3 == paramInt1) && (j == -1 + arrayOfInt.length)))) {
      return arrayOfInt;
    }
    return null;
  }
  
  private static int b(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    if (paramBoolean)
    {
      i = -1;
      j = 0;
      k = i;
      m = paramInt3;
      if (j < 2) {
        n = m;
      }
    }
    else
    {
      for (;;)
      {
        if (((!paramBoolean) || (n < paramInt1)) && ((paramBoolean) || (n >= paramInt2) || (paramBoolean != paramBitMatrix.a(n, paramInt4)))) {
          break label91;
        }
        if (Math.abs(paramInt3 - n) > 2)
        {
          return paramInt3;
          i = 1;
          break;
        }
        n += k;
      }
      label91:
      k = -k;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        j++;
        paramBoolean = bool;
        m = n;
        break;
      }
    }
    return m;
  }
  
  private static int b(int[] paramArrayOfInt)
  {
    return (9 + (paramArrayOfInt[0] - paramArrayOfInt[2] + paramArrayOfInt[4] - paramArrayOfInt[6])) % 9;
  }
  
  private static BarcodeMetadata b(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2)
  {
    BarcodeMetadata localBarcodeMetadata1;
    if (paramDetectionResultRowIndicatorColumn1 != null)
    {
      localBarcodeMetadata1 = paramDetectionResultRowIndicatorColumn1.e();
      if (localBarcodeMetadata1 != null) {}
    }
    else if (paramDetectionResultRowIndicatorColumn2 != null) {}
    BarcodeMetadata localBarcodeMetadata2;
    do
    {
      return null;
      return paramDetectionResultRowIndicatorColumn2.e();
      if (paramDetectionResultRowIndicatorColumn2 != null)
      {
        localBarcodeMetadata2 = paramDetectionResultRowIndicatorColumn2.e();
        if (localBarcodeMetadata2 != null) {}
      }
      else
      {
        return localBarcodeMetadata1;
      }
    } while ((localBarcodeMetadata1.a() != localBarcodeMetadata2.a()) && (localBarcodeMetadata1.b() != localBarcodeMetadata2.b()) && (localBarcodeMetadata1.c() != localBarcodeMetadata2.c()));
    return localBarcodeMetadata1;
  }
  
  private static int[] b(int paramInt)
  {
    int[] arrayOfInt = new int[8];
    int i = 0;
    int j = -1 + arrayOfInt.length;
    for (;;)
    {
      if ((paramInt & 0x1) != i)
      {
        i = paramInt & 0x1;
        j--;
        if (j < 0) {
          return arrayOfInt;
        }
      }
      arrayOfInt[j] = (1 + arrayOfInt[j]);
      paramInt >>= 1;
    }
  }
  
  private static BarcodeValue[][] b(DetectionResult paramDetectionResult)
  {
    BarcodeValue[][] arrayOfBarcodeValue = (BarcodeValue[][])Array.newInstance(BarcodeValue.class, new int[] { paramDetectionResult.c(), 2 + paramDetectionResult.b() });
    for (int i = 0; i < arrayOfBarcodeValue.length; i++) {
      for (int i3 = 0; i3 < arrayOfBarcodeValue[i].length; i3++) {
        arrayOfBarcodeValue[i][i3] = new BarcodeValue();
      }
    }
    DetectionResultColumn[] arrayOfDetectionResultColumn = paramDetectionResult.a();
    int j = arrayOfDetectionResultColumn.length;
    int k = 0;
    int m = -1;
    while (k < j)
    {
      DetectionResultColumn localDetectionResultColumn = arrayOfDetectionResultColumn[k];
      int n = m + 1;
      if (localDetectionResultColumn == null)
      {
        k++;
        m = n;
      }
      else
      {
        Codeword[] arrayOfCodeword = localDetectionResultColumn.b();
        int i1 = arrayOfCodeword.length;
        int i2 = 0;
        label137:
        Codeword localCodeword;
        if (i2 < i1)
        {
          localCodeword = arrayOfCodeword[i2];
          if ((localCodeword != null) && (localCodeword.h() != -1)) {
            break label171;
          }
        }
        for (;;)
        {
          i2++;
          break label137;
          break;
          label171:
          arrayOfBarcodeValue[localCodeword.h()][n].a(localCodeword.g());
        }
      }
    }
    return arrayOfBarcodeValue;
  }
  
  private static int c(int paramInt)
  {
    return b(b(paramInt));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.PDF417ScanningDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */