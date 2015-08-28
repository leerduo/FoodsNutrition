package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Detector
{
  private static final int[] g = { 3808, 476, 2107, 1799 };
  private final BitMatrix a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public Detector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
  }
  
  private static float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return MathUtils.a(paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint2.a(), paramResultPoint2.b());
  }
  
  private static int a(long paramLong, boolean paramBoolean)
  {
    i = 0;
    int j;
    if (paramBoolean) {
      j = 7;
    }
    int m;
    int[] arrayOfInt;
    for (int k = 2;; k = 4)
    {
      m = j - k;
      arrayOfInt = new int[j];
      for (int n = j - 1; n >= 0; n--)
      {
        arrayOfInt[n] = (0xF & (int)paramLong);
        paramLong >>= 4;
      }
      j = 10;
    }
    try
    {
      new ReedSolomonDecoder(GenericGF.d).a(arrayOfInt, m);
      for (int i1 = 0; i1 < k; i1++) {
        i = (i << 4) + arrayOfInt[i1];
      }
      return i;
    }
    catch (ReedSolomonException localReedSolomonException)
    {
      throw NotFoundException.a();
    }
  }
  
  private int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, int paramInt)
  {
    int i = 0;
    float f1 = a(paramResultPoint1, paramResultPoint2);
    float f2 = f1 / paramInt;
    float f3 = paramResultPoint1.a();
    float f4 = paramResultPoint1.b();
    float f5 = f2 * (paramResultPoint2.a() - paramResultPoint1.a()) / f1;
    float f6 = f2 * (paramResultPoint2.b() - paramResultPoint1.b()) / f1;
    for (int j = 0; j < paramInt; j++) {
      if (this.a.a(MathUtils.a(f3 + f5 * j), MathUtils.a(f4 + f6 * j))) {
        i |= 1 << -1 + (paramInt - j);
      }
    }
    return i;
  }
  
  private int a(Detector.Point paramPoint1, Detector.Point paramPoint2)
  {
    float f1 = b(paramPoint1, paramPoint2);
    float f2 = (paramPoint2.b() - paramPoint1.b()) / f1;
    float f3 = (paramPoint2.c() - paramPoint1.c()) / f1;
    float f4 = paramPoint1.b();
    float f5 = paramPoint1.c();
    boolean bool1 = this.a.a(paramPoint1.b(), paramPoint1.c());
    int i = 0;
    float f6 = f4;
    float f7 = f5;
    for (int j = 0; j < f1; j++)
    {
      f6 += f2;
      f7 += f3;
      if (this.a.a(MathUtils.a(f6), MathUtils.a(f7)) != bool1) {
        i++;
      }
    }
    float f8 = i / f1;
    if ((f8 > 0.1F) && (f8 < 0.9F)) {
      return 0;
    }
    if (f8 <= 0.1F) {}
    for (boolean bool2 = true; bool2 == bool1; bool2 = false) {
      return 1;
    }
    return -1;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    int m = 0;
    while (k < j)
    {
      int i1 = paramArrayOfInt[k];
      m = (i1 >> paramInt - 2 << 1) + (i1 & 0x1) + (m << 3);
      k++;
    }
    int n = ((m & 0x1) << 11) + (m >> 1);
    while (i < 4)
    {
      if (Integer.bitCount(n ^ g[i]) <= 2) {
        return i;
      }
      i++;
    }
    throw NotFoundException.a();
  }
  
  /* Error */
  private Detector.Point a()
  {
    // Byte code:
    //   0: new 93	com/google/zxing/common/detector/WhiteRectangleDetector
    //   3: dup
    //   4: aload_0
    //   5: getfield 25	com/google/zxing/aztec/detector/Detector:a	Lcom/google/zxing/common/BitMatrix;
    //   8: invokespecial 95	com/google/zxing/common/detector/WhiteRectangleDetector:<init>	(Lcom/google/zxing/common/BitMatrix;)V
    //   11: invokevirtual 98	com/google/zxing/common/detector/WhiteRectangleDetector:a	()[Lcom/google/zxing/ResultPoint;
    //   14: astore 16
    //   16: aload 16
    //   18: iconst_0
    //   19: aaload
    //   20: astore 4
    //   22: aload 16
    //   24: iconst_1
    //   25: aaload
    //   26: astore 5
    //   28: aload 16
    //   30: iconst_2
    //   31: aaload
    //   32: astore 6
    //   34: aload 16
    //   36: iconst_3
    //   37: aaload
    //   38: astore 7
    //   40: aload 4
    //   42: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   45: aload 7
    //   47: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   50: fadd
    //   51: aload 5
    //   53: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   56: fadd
    //   57: aload 6
    //   59: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   62: fadd
    //   63: ldc 99
    //   65: fdiv
    //   66: invokestatic 65	com/google/zxing/common/detector/MathUtils:a	(F)I
    //   69: istore 8
    //   71: aload 4
    //   73: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   76: aload 7
    //   78: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   81: fadd
    //   82: aload 5
    //   84: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   87: fadd
    //   88: aload 6
    //   90: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   93: fadd
    //   94: ldc 99
    //   96: fdiv
    //   97: invokestatic 65	com/google/zxing/common/detector/MathUtils:a	(F)I
    //   100: istore 9
    //   102: new 93	com/google/zxing/common/detector/WhiteRectangleDetector
    //   105: dup
    //   106: aload_0
    //   107: getfield 25	com/google/zxing/aztec/detector/Detector:a	Lcom/google/zxing/common/BitMatrix;
    //   110: bipush 15
    //   112: iload 8
    //   114: iload 9
    //   116: invokespecial 102	com/google/zxing/common/detector/WhiteRectangleDetector:<init>	(Lcom/google/zxing/common/BitMatrix;III)V
    //   119: invokevirtual 98	com/google/zxing/common/detector/WhiteRectangleDetector:a	()[Lcom/google/zxing/ResultPoint;
    //   122: astore 15
    //   124: aload 15
    //   126: iconst_0
    //   127: aaload
    //   128: astore 11
    //   130: aload 15
    //   132: iconst_1
    //   133: aaload
    //   134: astore 12
    //   136: aload 15
    //   138: iconst_2
    //   139: aaload
    //   140: astore 13
    //   142: aload 15
    //   144: iconst_3
    //   145: aaload
    //   146: astore 14
    //   148: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   151: dup
    //   152: aload 11
    //   154: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   157: aload 14
    //   159: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   162: fadd
    //   163: aload 12
    //   165: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   168: fadd
    //   169: aload 13
    //   171: invokevirtual 31	com/google/zxing/ResultPoint:a	()F
    //   174: fadd
    //   175: ldc 99
    //   177: fdiv
    //   178: invokestatic 65	com/google/zxing/common/detector/MathUtils:a	(F)I
    //   181: aload 11
    //   183: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   186: aload 14
    //   188: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   191: fadd
    //   192: aload 12
    //   194: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   197: fadd
    //   198: aload 13
    //   200: invokevirtual 33	com/google/zxing/ResultPoint:b	()F
    //   203: fadd
    //   204: ldc 99
    //   206: fdiv
    //   207: invokestatic 65	com/google/zxing/common/detector/MathUtils:a	(F)I
    //   210: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   213: areturn
    //   214: astore_1
    //   215: aload_0
    //   216: getfield 25	com/google/zxing/aztec/detector/Detector:a	Lcom/google/zxing/common/BitMatrix;
    //   219: invokevirtual 107	com/google/zxing/common/BitMatrix:f	()I
    //   222: iconst_2
    //   223: idiv
    //   224: istore_2
    //   225: aload_0
    //   226: getfield 25	com/google/zxing/aztec/detector/Detector:a	Lcom/google/zxing/common/BitMatrix;
    //   229: invokevirtual 109	com/google/zxing/common/BitMatrix:g	()I
    //   232: iconst_2
    //   233: idiv
    //   234: istore_3
    //   235: aload_0
    //   236: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   239: dup
    //   240: iload_2
    //   241: bipush 7
    //   243: iadd
    //   244: iload_3
    //   245: bipush 7
    //   247: isub
    //   248: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   251: iconst_0
    //   252: iconst_1
    //   253: iconst_m1
    //   254: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   257: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   260: astore 4
    //   262: aload_0
    //   263: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   266: dup
    //   267: iload_2
    //   268: bipush 7
    //   270: iadd
    //   271: iload_3
    //   272: bipush 7
    //   274: iadd
    //   275: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   278: iconst_0
    //   279: iconst_1
    //   280: iconst_1
    //   281: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   284: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   287: astore 5
    //   289: aload_0
    //   290: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   293: dup
    //   294: iload_2
    //   295: bipush 7
    //   297: isub
    //   298: iload_3
    //   299: bipush 7
    //   301: iadd
    //   302: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   305: iconst_0
    //   306: iconst_m1
    //   307: iconst_1
    //   308: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   311: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   314: astore 6
    //   316: aload_0
    //   317: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   320: dup
    //   321: iload_2
    //   322: bipush 7
    //   324: isub
    //   325: iload_3
    //   326: bipush 7
    //   328: isub
    //   329: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   332: iconst_0
    //   333: iconst_m1
    //   334: iconst_m1
    //   335: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   338: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   341: astore 7
    //   343: goto -303 -> 40
    //   346: astore 10
    //   348: aload_0
    //   349: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   352: dup
    //   353: iload 8
    //   355: bipush 7
    //   357: iadd
    //   358: iload 9
    //   360: bipush 7
    //   362: isub
    //   363: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   366: iconst_0
    //   367: iconst_1
    //   368: iconst_m1
    //   369: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   372: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   375: astore 11
    //   377: aload_0
    //   378: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   381: dup
    //   382: iload 8
    //   384: bipush 7
    //   386: iadd
    //   387: iload 9
    //   389: bipush 7
    //   391: iadd
    //   392: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   395: iconst_0
    //   396: iconst_1
    //   397: iconst_1
    //   398: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   401: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   404: astore 12
    //   406: aload_0
    //   407: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   410: dup
    //   411: iload 8
    //   413: bipush 7
    //   415: isub
    //   416: iload 9
    //   418: bipush 7
    //   420: iadd
    //   421: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   424: iconst_0
    //   425: iconst_m1
    //   426: iconst_1
    //   427: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   430: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   433: astore 13
    //   435: aload_0
    //   436: new 76	com/google/zxing/aztec/detector/Detector$Point
    //   439: dup
    //   440: iload 8
    //   442: bipush 7
    //   444: isub
    //   445: iload 9
    //   447: bipush 7
    //   449: isub
    //   450: invokespecial 105	com/google/zxing/aztec/detector/Detector$Point:<init>	(II)V
    //   453: iconst_0
    //   454: iconst_m1
    //   455: iconst_m1
    //   456: invokespecial 112	com/google/zxing/aztec/detector/Detector:a	(Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   459: invokevirtual 115	com/google/zxing/aztec/detector/Detector$Point:a	()Lcom/google/zxing/ResultPoint;
    //   462: astore 14
    //   464: goto -316 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	Detector
    //   214	1	1	localNotFoundException1	NotFoundException
    //   224	101	2	i	int
    //   234	95	3	j	int
    //   20	241	4	localResultPoint1	ResultPoint
    //   26	262	5	localResultPoint2	ResultPoint
    //   32	283	6	localResultPoint3	ResultPoint
    //   38	304	7	localResultPoint4	ResultPoint
    //   69	376	8	k	int
    //   100	350	9	m	int
    //   346	1	10	localNotFoundException2	NotFoundException
    //   128	248	11	localResultPoint5	ResultPoint
    //   134	271	12	localResultPoint6	ResultPoint
    //   140	294	13	localResultPoint7	ResultPoint
    //   146	317	14	localResultPoint8	ResultPoint
    //   122	21	15	arrayOfResultPoint1	ResultPoint[]
    //   14	21	16	arrayOfResultPoint2	ResultPoint[]
    // Exception table:
    //   from	to	target	type
    //   0	40	214	com/google/zxing/NotFoundException
    //   102	148	346	com/google/zxing/NotFoundException
  }
  
  private Detector.Point a(Detector.Point paramPoint, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramPoint.b();
    int j = paramInt2 + paramPoint.c();
    while ((a(i, j)) && (this.a.a(i, j) == paramBoolean))
    {
      i += paramInt1;
      j += paramInt2;
    }
    int k = i - paramInt1;
    int m = j - paramInt2;
    int n = k;
    while ((a(n, m)) && (this.a.a(n, m) == paramBoolean)) {
      n += paramInt1;
    }
    int i1 = n - paramInt1;
    int i2 = m;
    while ((a(i1, i2)) && (this.a.a(i1, i2) == paramBoolean)) {
      i2 += paramInt2;
    }
    return new Detector.Point(i1, i2 - paramInt2);
  }
  
  private BitMatrix a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    GridSampler localGridSampler = GridSampler.a();
    int i = b();
    float f1 = i / 2.0F - this.e;
    float f2 = i / 2.0F + this.e;
    return localGridSampler.a(paramBitMatrix, i, i, f1, f1, f2, f1, f2, f2, f1, f2, paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint2.a(), paramResultPoint2.b(), paramResultPoint3.a(), paramResultPoint3.b(), paramResultPoint4.a(), paramResultPoint4.b());
  }
  
  private void a(ResultPoint[] paramArrayOfResultPoint)
  {
    if ((!a(paramArrayOfResultPoint[0])) || (!a(paramArrayOfResultPoint[1])) || (!a(paramArrayOfResultPoint[2])) || (!a(paramArrayOfResultPoint[3]))) {
      throw NotFoundException.a();
    }
    int i = 2 * this.e;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1], i);
    arrayOfInt[1] = a(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2], i);
    arrayOfInt[2] = a(paramArrayOfResultPoint[2], paramArrayOfResultPoint[3], i);
    arrayOfInt[3] = a(paramArrayOfResultPoint[3], paramArrayOfResultPoint[0], i);
    this.f = a(arrayOfInt, i);
    long l = 0L;
    int j = 0;
    if (j < 4)
    {
      int m = arrayOfInt[((j + this.f) % 4)];
      if (this.b) {}
      for (l = (l << 7) + (0x7F & m >> 1);; l = (l << 10) + ((0x3E0 & m >> 2) + (0x1F & m >> 1)))
      {
        j++;
        break;
      }
    }
    int k = a(l, this.b);
    if (this.b)
    {
      this.c = (1 + (k >> 6));
      this.d = (1 + (k & 0x3F));
      return;
    }
    this.c = (1 + (k >> 11));
    this.d = (1 + (k & 0x7FF));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 < this.a.f()) && (paramInt2 > 0) && (paramInt2 < this.a.g());
  }
  
  private boolean a(ResultPoint paramResultPoint)
  {
    return a(MathUtils.a(paramResultPoint.a()), MathUtils.a(paramResultPoint.b()));
  }
  
  private boolean a(Detector.Point paramPoint1, Detector.Point paramPoint2, Detector.Point paramPoint3, Detector.Point paramPoint4)
  {
    Detector.Point localPoint1 = new Detector.Point(paramPoint1.b() - 3, 3 + paramPoint1.c());
    Detector.Point localPoint2 = new Detector.Point(paramPoint2.b() - 3, paramPoint2.c() - 3);
    Detector.Point localPoint3 = new Detector.Point(3 + paramPoint3.b(), paramPoint3.c() - 3);
    Detector.Point localPoint4 = new Detector.Point(3 + paramPoint4.b(), 3 + paramPoint4.c());
    int i = a(localPoint4, localPoint1);
    if (i == 0) {}
    while ((a(localPoint1, localPoint2) != i) || (a(localPoint2, localPoint3) != i) || (a(localPoint3, localPoint4) != i)) {
      return false;
    }
    return true;
  }
  
  private ResultPoint[] a(Detector.Point paramPoint)
  {
    boolean bool1 = true;
    this.e = 1;
    Object localObject1 = paramPoint;
    Object localObject2 = paramPoint;
    Object localObject3 = paramPoint;
    Detector.Point localPoint1;
    Detector.Point localPoint2;
    Detector.Point localPoint3;
    Detector.Point localPoint4;
    if (this.e < 9)
    {
      localPoint1 = a((Detector.Point)localObject3, bool1, 1, -1);
      localPoint2 = a((Detector.Point)localObject2, bool1, 1, 1);
      localPoint3 = a((Detector.Point)localObject1, bool1, -1, 1);
      localPoint4 = a(paramPoint, bool1, -1, -1);
      if (this.e > 2)
      {
        float f1 = b(localPoint4, localPoint1) * this.e / (b(paramPoint, (Detector.Point)localObject3) * (2 + this.e));
        if ((f1 >= 0.75D) && (f1 <= 1.25D) && (a(localPoint1, localPoint2, localPoint3, localPoint4))) {}
      }
    }
    else
    {
      if ((this.e == 5) || (this.e == 7)) {
        break label198;
      }
      throw NotFoundException.a();
    }
    if (!bool1) {}
    for (bool1 = true;; bool1 = false)
    {
      this.e = (1 + this.e);
      paramPoint = localPoint4;
      localObject1 = localPoint3;
      localObject2 = localPoint2;
      localObject3 = localPoint1;
      break;
    }
    label198:
    if (this.e == 5) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      this.b = bool2;
      return a(new ResultPoint[] { new ResultPoint(0.5F + ((Detector.Point)localObject3).b(), ((Detector.Point)localObject3).c() - 0.5F), new ResultPoint(0.5F + ((Detector.Point)localObject2).b(), 0.5F + ((Detector.Point)localObject2).c()), new ResultPoint(((Detector.Point)localObject1).b() - 0.5F, 0.5F + ((Detector.Point)localObject1).c()), new ResultPoint(paramPoint.b() - 0.5F, paramPoint.c() - 0.5F) }, -3 + 2 * this.e, 2 * this.e);
    }
  }
  
  private static ResultPoint[] a(ResultPoint[] paramArrayOfResultPoint, float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat2 / (2.0F * paramFloat1);
    float f2 = paramArrayOfResultPoint[0].a() - paramArrayOfResultPoint[2].a();
    float f3 = paramArrayOfResultPoint[0].b() - paramArrayOfResultPoint[2].b();
    float f4 = (paramArrayOfResultPoint[0].a() + paramArrayOfResultPoint[2].a()) / 2.0F;
    float f5 = (paramArrayOfResultPoint[0].b() + paramArrayOfResultPoint[2].b()) / 2.0F;
    ResultPoint localResultPoint1 = new ResultPoint(f4 + f1 * f2, f5 + f1 * f3);
    ResultPoint localResultPoint2 = new ResultPoint(f4 - f2 * f1, f5 - f3 * f1);
    float f6 = paramArrayOfResultPoint[1].a() - paramArrayOfResultPoint[3].a();
    float f7 = paramArrayOfResultPoint[1].b() - paramArrayOfResultPoint[3].b();
    float f8 = (paramArrayOfResultPoint[1].a() + paramArrayOfResultPoint[3].a()) / 2.0F;
    float f9 = (paramArrayOfResultPoint[1].b() + paramArrayOfResultPoint[3].b()) / 2.0F;
    return new ResultPoint[] { localResultPoint1, new ResultPoint(f8 + f1 * f6, f9 + f1 * f7), localResultPoint2, new ResultPoint(f8 - f6 * f1, f9 - f1 * f7) };
  }
  
  private static float b(Detector.Point paramPoint1, Detector.Point paramPoint2)
  {
    return MathUtils.a(paramPoint1.b(), paramPoint1.c(), paramPoint2.b(), paramPoint2.c());
  }
  
  private int b()
  {
    if (this.b) {
      return 11 + 4 * this.c;
    }
    if (this.c <= 4) {
      return 15 + 4 * this.c;
    }
    return 15 + (4 * this.c + 2 * (1 + (-4 + this.c) / 8));
  }
  
  private ResultPoint[] b(ResultPoint[] paramArrayOfResultPoint)
  {
    return a(paramArrayOfResultPoint, 2 * this.e, b());
  }
  
  public AztecDetectorResult a(boolean paramBoolean)
  {
    ResultPoint[] arrayOfResultPoint = a(a());
    if (paramBoolean)
    {
      ResultPoint localResultPoint = arrayOfResultPoint[0];
      arrayOfResultPoint[0] = arrayOfResultPoint[2];
      arrayOfResultPoint[2] = localResultPoint;
    }
    a(arrayOfResultPoint);
    return new AztecDetectorResult(a(this.a, arrayOfResultPoint[(this.f % 4)], arrayOfResultPoint[((1 + this.f) % 4)], arrayOfResultPoint[((2 + this.f) % 4)], arrayOfResultPoint[((3 + this.f) % 4)]), b(arrayOfResultPoint), this.b, this.d, this.c);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.detector.Detector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */