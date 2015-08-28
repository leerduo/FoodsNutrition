package com.xiaomi.smack;

import com.xiaomi.kenai.jbosh.z;

public class i
  implements z
{
  private b a;
  
  public i(b paramb)
  {
    this.a = paramb;
  }
  
  /* Error */
  public boolean a(com.xiaomi.kenai.jbosh.ab paramab)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 23	com/xiaomi/kenai/jbosh/ab:a	()Lcom/xiaomi/kenai/jbosh/b;
    //   4: astore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_2
    //   8: ifnull +572 -> 580
    //   11: aload_0
    //   12: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   15: invokevirtual 29	com/xiaomi/smack/b:i	()Z
    //   18: ifeq +550 -> 568
    //   21: aload_2
    //   22: ldc 31
    //   24: ldc 33
    //   26: invokestatic 38	com/xiaomi/kenai/jbosh/ag:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/ag;
    //   29: invokevirtual 43	com/xiaomi/kenai/jbosh/b:a	(Lcom/xiaomi/kenai/jbosh/ag;)Ljava/lang/String;
    //   32: astore 23
    //   34: aload 23
    //   36: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: istore 24
    //   41: iload 24
    //   43: ifne +525 -> 568
    //   46: aload_0
    //   47: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   50: aload 23
    //   52: invokevirtual 52	com/xiaomi/smack/b:a	(Ljava/lang/String;)V
    //   55: iconst_1
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   62: getfield 56	com/xiaomi/smack/b:b	Ljava/lang/String;
    //   65: astore 7
    //   67: aload 7
    //   69: ifnonnull +24 -> 93
    //   72: aload_0
    //   73: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   76: aload_2
    //   77: ldc 31
    //   79: ldc 58
    //   81: invokestatic 38	com/xiaomi/kenai/jbosh/ag:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/ag;
    //   84: invokevirtual 43	com/xiaomi/kenai/jbosh/b:a	(Lcom/xiaomi/kenai/jbosh/ag;)Ljava/lang/String;
    //   87: putfield 56	com/xiaomi/smack/b:b	Ljava/lang/String;
    //   90: iconst_1
    //   91: istore 5
    //   93: aload_0
    //   94: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   97: getfield 60	com/xiaomi/smack/b:a	Ljava/lang/String;
    //   100: astore 8
    //   102: aload 8
    //   104: ifnonnull +24 -> 128
    //   107: aload_0
    //   108: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   111: aload_2
    //   112: ldc 31
    //   114: ldc 62
    //   116: invokestatic 38	com/xiaomi/kenai/jbosh/ag:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/ag;
    //   119: invokevirtual 43	com/xiaomi/kenai/jbosh/b:a	(Lcom/xiaomi/kenai/jbosh/ag;)Ljava/lang/String;
    //   122: putfield 60	com/xiaomi/smack/b:a	Ljava/lang/String;
    //   125: iconst_1
    //   126: istore 5
    //   128: invokestatic 68	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   131: invokevirtual 72	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   134: astore 9
    //   136: aload 9
    //   138: ldc 74
    //   140: iconst_1
    //   141: invokeinterface 80 3 0
    //   146: aload 9
    //   148: new 82	java/io/StringReader
    //   151: dup
    //   152: aload_2
    //   153: invokevirtual 86	com/xiaomi/kenai/jbosh/b:d	()Ljava/lang/String;
    //   156: invokespecial 88	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   159: invokeinterface 92 2 0
    //   164: aload 9
    //   166: invokeinterface 96 1 0
    //   171: pop
    //   172: aload 9
    //   174: invokeinterface 99 1 0
    //   179: istore 11
    //   181: aload_0
    //   182: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   185: invokevirtual 102	com/xiaomi/smack/b:p	()V
    //   188: iload 11
    //   190: iconst_2
    //   191: if_icmpne +371 -> 562
    //   194: aload 9
    //   196: invokeinterface 105 1 0
    //   201: ldc 107
    //   203: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifeq +9 -> 215
    //   209: iload 5
    //   211: istore_3
    //   212: goto +362 -> 574
    //   215: aload 9
    //   217: invokeinterface 105 1 0
    //   222: ldc 115
    //   224: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: istore 12
    //   229: iload 12
    //   231: ifeq +20 -> 251
    //   234: aload_0
    //   235: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   238: aload 9
    //   240: invokestatic 120	com/xiaomi/smack/util/c:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/d;
    //   243: invokevirtual 123	com/xiaomi/smack/b:b	(Lcom/xiaomi/smack/packet/d;)V
    //   246: iconst_1
    //   247: istore_3
    //   248: goto +326 -> 574
    //   251: aload 9
    //   253: invokeinterface 105 1 0
    //   258: ldc 125
    //   260: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: istore 13
    //   265: iload 13
    //   267: ifeq +24 -> 291
    //   270: aload_0
    //   271: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   274: aload 9
    //   276: aload_0
    //   277: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   280: invokestatic 128	com/xiaomi/smack/util/c:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/xiaomi/smack/j;)Lcom/xiaomi/smack/packet/b;
    //   283: invokevirtual 123	com/xiaomi/smack/b:b	(Lcom/xiaomi/smack/packet/d;)V
    //   286: iconst_1
    //   287: istore_3
    //   288: goto +286 -> 574
    //   291: aload 9
    //   293: invokeinterface 105 1 0
    //   298: ldc 130
    //   300: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   303: istore 14
    //   305: iload 14
    //   307: ifeq +20 -> 327
    //   310: aload_0
    //   311: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   314: aload 9
    //   316: invokestatic 133	com/xiaomi/smack/util/c:b	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/f;
    //   319: invokevirtual 123	com/xiaomi/smack/b:b	(Lcom/xiaomi/smack/packet/d;)V
    //   322: iconst_1
    //   323: istore_3
    //   324: goto +250 -> 574
    //   327: aload 9
    //   329: invokeinterface 105 1 0
    //   334: ldc 33
    //   336: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: istore 15
    //   341: iload 15
    //   343: ifeq +26 -> 369
    //   346: aload 9
    //   348: invokeinterface 136 1 0
    //   353: astore 22
    //   355: aload_0
    //   356: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   359: aload 22
    //   361: invokevirtual 52	com/xiaomi/smack/b:a	(Ljava/lang/String;)V
    //   364: iconst_1
    //   365: istore_3
    //   366: goto +208 -> 574
    //   369: aload 9
    //   371: invokeinterface 105 1 0
    //   376: ldc 138
    //   378: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   381: istore 16
    //   383: iload 16
    //   385: ifeq +45 -> 430
    //   388: new 140	com/xiaomi/smack/w
    //   391: dup
    //   392: aload 9
    //   394: invokestatic 143	com/xiaomi/smack/util/c:d	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/g;
    //   397: invokespecial 146	com/xiaomi/smack/w:<init>	(Lcom/xiaomi/smack/packet/g;)V
    //   400: athrow
    //   401: astore 20
    //   403: iconst_1
    //   404: istore_3
    //   405: aload 20
    //   407: astore 4
    //   409: aload_0
    //   410: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   413: invokevirtual 149	com/xiaomi/smack/b:j	()Z
    //   416: ifeq +164 -> 580
    //   419: aload_0
    //   420: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   423: aload 4
    //   425: invokevirtual 152	com/xiaomi/smack/b:a	(Ljava/lang/Exception;)V
    //   428: iload_3
    //   429: ireturn
    //   430: aload 9
    //   432: invokeinterface 105 1 0
    //   437: ldc 154
    //   439: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   442: istore 17
    //   444: iload 17
    //   446: ifeq +51 -> 497
    //   449: aload 9
    //   451: invokeinterface 99 1 0
    //   456: pop
    //   457: aload 9
    //   459: invokeinterface 105 1 0
    //   464: ldc 156
    //   466: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +63 -> 532
    //   472: aload_0
    //   473: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   476: new 158	com/xiaomi/smack/packet/f
    //   479: dup
    //   480: getstatic 163	com/xiaomi/smack/packet/f$b:b	Lcom/xiaomi/smack/packet/f$b;
    //   483: invokespecial 166	com/xiaomi/smack/packet/f:<init>	(Lcom/xiaomi/smack/packet/f$b;)V
    //   486: bipush 6
    //   488: aconst_null
    //   489: invokevirtual 169	com/xiaomi/smack/b:a	(Lcom/xiaomi/smack/packet/f;ILjava/lang/Exception;)V
    //   492: iconst_1
    //   493: istore_3
    //   494: goto +80 -> 574
    //   497: aload 9
    //   499: invokeinterface 105 1 0
    //   504: ldc 171
    //   506: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   509: istore 18
    //   511: iload 18
    //   513: ifeq +49 -> 562
    //   516: aload 9
    //   518: invokestatic 175	com/xiaomi/smack/util/c:c	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/s$b;
    //   521: astore 19
    //   523: aload_0
    //   524: getfield 15	com/xiaomi/smack/i:a	Lcom/xiaomi/smack/b;
    //   527: aload 19
    //   529: invokevirtual 123	com/xiaomi/smack/b:b	(Lcom/xiaomi/smack/packet/d;)V
    //   532: iconst_1
    //   533: istore_3
    //   534: goto +40 -> 574
    //   537: astore 4
    //   539: iconst_0
    //   540: istore_3
    //   541: goto -132 -> 409
    //   544: astore 6
    //   546: aload 6
    //   548: astore 4
    //   550: iload 5
    //   552: istore_3
    //   553: goto -144 -> 409
    //   556: iload_3
    //   557: istore 5
    //   559: goto -387 -> 172
    //   562: iload 5
    //   564: istore_3
    //   565: goto +9 -> 574
    //   568: iconst_0
    //   569: istore 5
    //   571: goto -513 -> 58
    //   574: iload 11
    //   576: iconst_1
    //   577: if_icmpne -21 -> 556
    //   580: iload_3
    //   581: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	i
    //   0	582	1	paramab	com.xiaomi.kenai.jbosh.ab
    //   4	149	2	localb	com.xiaomi.kenai.jbosh.b
    //   6	575	3	bool1	boolean
    //   407	17	4	localException1	java.lang.Exception
    //   537	1	4	localException2	java.lang.Exception
    //   548	1	4	localObject	Object
    //   56	514	5	bool2	boolean
    //   544	3	6	localException3	java.lang.Exception
    //   65	3	7	str1	java.lang.String
    //   100	3	8	str2	java.lang.String
    //   134	383	9	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   179	399	11	i	int
    //   227	3	12	bool3	boolean
    //   263	3	13	bool4	boolean
    //   303	3	14	bool5	boolean
    //   339	3	15	bool6	boolean
    //   381	3	16	bool7	boolean
    //   442	3	17	bool8	boolean
    //   509	3	18	bool9	boolean
    //   521	7	19	localb1	s.b
    //   401	5	20	localException4	java.lang.Exception
    //   353	7	22	str3	java.lang.String
    //   32	19	23	str4	java.lang.String
    //   39	3	24	bool10	boolean
    // Exception table:
    //   from	to	target	type
    //   46	55	401	java/lang/Exception
    //   72	90	401	java/lang/Exception
    //   107	125	401	java/lang/Exception
    //   234	246	401	java/lang/Exception
    //   270	286	401	java/lang/Exception
    //   310	322	401	java/lang/Exception
    //   346	364	401	java/lang/Exception
    //   388	401	401	java/lang/Exception
    //   449	492	401	java/lang/Exception
    //   516	532	401	java/lang/Exception
    //   11	41	537	java/lang/Exception
    //   58	67	544	java/lang/Exception
    //   93	102	544	java/lang/Exception
    //   128	172	544	java/lang/Exception
    //   172	188	544	java/lang/Exception
    //   194	209	544	java/lang/Exception
    //   215	229	544	java/lang/Exception
    //   251	265	544	java/lang/Exception
    //   291	305	544	java/lang/Exception
    //   327	341	544	java/lang/Exception
    //   369	383	544	java/lang/Exception
    //   430	444	544	java/lang/Exception
    //   497	511	544	java/lang/Exception
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */