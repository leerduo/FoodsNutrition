package com.google.zxing.aztec;

import com.google.zxing.Reader;

public final class AztecReader
  implements Reader
{
  /* Error */
  public com.google.zxing.Result a(com.google.zxing.BinaryBitmap paramBinaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 18	com/google/zxing/aztec/detector/Detector
    //   5: dup
    //   6: aload_1
    //   7: invokevirtual 24	com/google/zxing/BinaryBitmap:c	()Lcom/google/zxing/common/BitMatrix;
    //   10: invokespecial 27	com/google/zxing/aztec/detector/Detector:<init>	(Lcom/google/zxing/common/BitMatrix;)V
    //   13: astore 4
    //   15: aload 4
    //   17: iconst_0
    //   18: invokevirtual 30	com/google/zxing/aztec/detector/Detector:a	(Z)Lcom/google/zxing/aztec/AztecDetectorResult;
    //   21: astore 22
    //   23: aload 22
    //   25: invokevirtual 36	com/google/zxing/aztec/AztecDetectorResult:e	()[Lcom/google/zxing/ResultPoint;
    //   28: astore 23
    //   30: aload 23
    //   32: astore 6
    //   34: new 38	com/google/zxing/aztec/decoder/Decoder
    //   37: dup
    //   38: invokespecial 39	com/google/zxing/aztec/decoder/Decoder:<init>	()V
    //   41: aload 22
    //   43: invokevirtual 42	com/google/zxing/aztec/decoder/Decoder:a	(Lcom/google/zxing/aztec/AztecDetectorResult;)Lcom/google/zxing/common/DecoderResult;
    //   46: astore 24
    //   48: aload 24
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aload 7
    //   57: ifnonnull +235 -> 292
    //   60: aload 4
    //   62: iconst_1
    //   63: invokevirtual 30	com/google/zxing/aztec/detector/Detector:a	(Z)Lcom/google/zxing/aztec/AztecDetectorResult;
    //   66: astore 18
    //   68: aload 18
    //   70: invokevirtual 36	com/google/zxing/aztec/AztecDetectorResult:e	()[Lcom/google/zxing/ResultPoint;
    //   73: astore 19
    //   75: new 38	com/google/zxing/aztec/decoder/Decoder
    //   78: dup
    //   79: invokespecial 39	com/google/zxing/aztec/decoder/Decoder:<init>	()V
    //   82: aload 18
    //   84: invokevirtual 42	com/google/zxing/aztec/decoder/Decoder:a	(Lcom/google/zxing/aztec/AztecDetectorResult;)Lcom/google/zxing/common/DecoderResult;
    //   87: astore 20
    //   89: aload 20
    //   91: astore 9
    //   93: aload 19
    //   95: astore 10
    //   97: aload_2
    //   98: ifnull +108 -> 206
    //   101: aload_2
    //   102: getstatic 48	com/google/zxing/DecodeHintType:j	Lcom/google/zxing/DecodeHintType;
    //   105: invokeinterface 54 2 0
    //   110: checkcast 56	com/google/zxing/ResultPointCallback
    //   113: astore 14
    //   115: aload 14
    //   117: ifnull +89 -> 206
    //   120: aload 10
    //   122: arraylength
    //   123: istore 15
    //   125: iconst_0
    //   126: istore 16
    //   128: iload 16
    //   130: iload 15
    //   132: if_icmpge +74 -> 206
    //   135: aload 14
    //   137: aload 10
    //   139: iload 16
    //   141: aaload
    //   142: invokeinterface 59 2 0
    //   147: iinc 16 1
    //   150: goto -22 -> 128
    //   153: astore 21
    //   155: aconst_null
    //   156: astore 6
    //   158: aload 21
    //   160: astore 8
    //   162: aconst_null
    //   163: astore 7
    //   165: aconst_null
    //   166: astore_3
    //   167: goto -112 -> 55
    //   170: astore 5
    //   172: aconst_null
    //   173: astore 6
    //   175: aload 5
    //   177: astore_3
    //   178: aconst_null
    //   179: astore 7
    //   181: aconst_null
    //   182: astore 8
    //   184: goto -129 -> 55
    //   187: astore 17
    //   189: aload 8
    //   191: ifnull +6 -> 197
    //   194: aload 8
    //   196: athrow
    //   197: aload_3
    //   198: ifnull +5 -> 203
    //   201: aload_3
    //   202: athrow
    //   203: aload 17
    //   205: athrow
    //   206: new 61	com/google/zxing/Result
    //   209: dup
    //   210: aload 9
    //   212: invokevirtual 67	com/google/zxing/common/DecoderResult:b	()Ljava/lang/String;
    //   215: aload 9
    //   217: invokevirtual 70	com/google/zxing/common/DecoderResult:a	()[B
    //   220: aload 10
    //   222: getstatic 75	com/google/zxing/BarcodeFormat:a	Lcom/google/zxing/BarcodeFormat;
    //   225: invokespecial 78	com/google/zxing/Result:<init>	(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V
    //   228: astore 11
    //   230: aload 9
    //   232: invokevirtual 81	com/google/zxing/common/DecoderResult:c	()Ljava/util/List;
    //   235: astore 12
    //   237: aload 12
    //   239: ifnull +13 -> 252
    //   242: aload 11
    //   244: getstatic 86	com/google/zxing/ResultMetadataType:c	Lcom/google/zxing/ResultMetadataType;
    //   247: aload 12
    //   249: invokevirtual 89	com/google/zxing/Result:a	(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
    //   252: aload 9
    //   254: invokevirtual 92	com/google/zxing/common/DecoderResult:d	()Ljava/lang/String;
    //   257: astore 13
    //   259: aload 13
    //   261: ifnull +13 -> 274
    //   264: aload 11
    //   266: getstatic 94	com/google/zxing/ResultMetadataType:d	Lcom/google/zxing/ResultMetadataType;
    //   269: aload 13
    //   271: invokevirtual 89	com/google/zxing/Result:a	(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V
    //   274: aload 11
    //   276: areturn
    //   277: astore 17
    //   279: goto -90 -> 189
    //   282: astore 5
    //   284: goto -109 -> 175
    //   287: astore 21
    //   289: goto -131 -> 158
    //   292: aload 7
    //   294: astore 9
    //   296: aload 6
    //   298: astore 10
    //   300: goto -203 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	AztecReader
    //   0	303	1	paramBinaryBitmap	com.google.zxing.BinaryBitmap
    //   0	303	2	paramMap	java.util.Map<com.google.zxing.DecodeHintType, ?>
    //   1	201	3	localObject1	Object
    //   13	48	4	localDetector	com.google.zxing.aztec.detector.Detector
    //   170	6	5	localFormatException1	com.google.zxing.FormatException
    //   282	1	5	localFormatException2	com.google.zxing.FormatException
    //   32	265	6	arrayOfResultPoint1	com.google.zxing.ResultPoint[]
    //   50	243	7	localDecoderResult1	com.google.zxing.common.DecoderResult
    //   53	142	8	localObject2	Object
    //   91	204	9	localDecoderResult2	com.google.zxing.common.DecoderResult
    //   95	204	10	arrayOfResultPoint2	com.google.zxing.ResultPoint[]
    //   228	47	11	localResult	com.google.zxing.Result
    //   235	13	12	localList	java.util.List
    //   257	13	13	str	java.lang.String
    //   113	23	14	localResultPointCallback	com.google.zxing.ResultPointCallback
    //   123	10	15	i	int
    //   126	22	16	j	int
    //   187	17	17	localNotFoundException1	com.google.zxing.NotFoundException
    //   277	1	17	localFormatException3	com.google.zxing.FormatException
    //   66	17	18	localAztecDetectorResult1	AztecDetectorResult
    //   73	21	19	arrayOfResultPoint3	com.google.zxing.ResultPoint[]
    //   87	3	20	localDecoderResult3	com.google.zxing.common.DecoderResult
    //   153	6	21	localNotFoundException2	com.google.zxing.NotFoundException
    //   287	1	21	localNotFoundException3	com.google.zxing.NotFoundException
    //   21	21	22	localAztecDetectorResult2	AztecDetectorResult
    //   28	3	23	arrayOfResultPoint4	com.google.zxing.ResultPoint[]
    //   46	3	24	localDecoderResult4	com.google.zxing.common.DecoderResult
    // Exception table:
    //   from	to	target	type
    //   15	30	153	com/google/zxing/NotFoundException
    //   15	30	170	com/google/zxing/FormatException
    //   60	89	187	com/google/zxing/NotFoundException
    //   60	89	277	com/google/zxing/FormatException
    //   34	48	282	com/google/zxing/FormatException
    //   34	48	287	com/google/zxing/NotFoundException
  }
  
  public void a() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.AztecReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */