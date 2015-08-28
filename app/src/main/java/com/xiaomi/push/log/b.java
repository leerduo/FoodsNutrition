package com.xiaomi.push.log;

import android.content.Context;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class b
  implements LoggerInterface
{
  private static final SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss aaa");
  private static com.xiaomi.channel.commonutils.misc.b b = new com.xiaomi.channel.commonutils.misc.b(true);
  private static String c = "/MiPushLog";
  private static List<Pair<String, Throwable>> f = Collections.synchronizedList(new ArrayList());
  private String d;
  private Context e;
  
  public b(Context paramContext)
  {
    this.e = paramContext;
    if (paramContext.getApplicationContext() != null) {
      this.e = paramContext.getApplicationContext();
    }
    this.d = this.e.getPackageName();
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 77	java/io/File
    //   5: dup
    //   6: new 79	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: getfield 57	com/xiaomi/push/log/b:e	Landroid/content/Context;
    //   17: aconst_null
    //   18: invokevirtual 84	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   21: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: getstatic 41	com/xiaomi/push/log/b:c	Ljava/lang/String;
    //   27: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 99	java/io/File:exists	()Z
    //   41: ifeq +10 -> 51
    //   44: aload_2
    //   45: invokevirtual 102	java/io/File:isDirectory	()Z
    //   48: ifne +52 -> 100
    //   51: aload_2
    //   52: invokevirtual 105	java/io/File:mkdirs	()Z
    //   55: ifne +45 -> 100
    //   58: aload_0
    //   59: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   62: ldc 107
    //   64: invokestatic 113	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: iconst_0
    //   69: ifeq +7 -> 76
    //   72: aconst_null
    //   73: invokevirtual 118	java/io/BufferedWriter:close	()V
    //   76: iconst_0
    //   77: ifeq +14 -> 91
    //   80: aconst_null
    //   81: invokevirtual 123	java/nio/channels/FileLock:isValid	()Z
    //   84: ifeq +7 -> 91
    //   87: aconst_null
    //   88: invokevirtual 126	java/nio/channels/FileLock:release	()V
    //   91: iconst_0
    //   92: ifeq +7 -> 99
    //   95: aconst_null
    //   96: invokevirtual 129	java/io/RandomAccessFile:close	()V
    //   99: return
    //   100: new 77	java/io/File
    //   103: dup
    //   104: aload_2
    //   105: ldc 131
    //   107: invokespecial 134	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   110: astore 25
    //   112: aload 25
    //   114: invokevirtual 99	java/io/File:exists	()Z
    //   117: ifeq +11 -> 128
    //   120: aload 25
    //   122: invokevirtual 102	java/io/File:isDirectory	()Z
    //   125: ifeq +9 -> 134
    //   128: aload 25
    //   130: invokevirtual 137	java/io/File:createNewFile	()Z
    //   133: pop
    //   134: new 128	java/io/RandomAccessFile
    //   137: dup
    //   138: aload 25
    //   140: ldc 139
    //   142: invokespecial 140	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   145: astore 9
    //   147: aload 9
    //   149: invokevirtual 144	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   152: invokevirtual 150	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   155: astore 27
    //   157: aload 27
    //   159: astore 8
    //   161: new 115	java/io/BufferedWriter
    //   164: dup
    //   165: new 152	java/io/OutputStreamWriter
    //   168: dup
    //   169: new 154	java/io/FileOutputStream
    //   172: dup
    //   173: new 77	java/io/File
    //   176: dup
    //   177: aload_2
    //   178: ldc 156
    //   180: invokespecial 134	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   183: iconst_1
    //   184: invokespecial 159	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   187: invokespecial 162	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   190: invokespecial 165	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   193: astore 28
    //   195: getstatic 53	com/xiaomi/push/log/b:f	Ljava/util/List;
    //   198: invokeinterface 170 1 0
    //   203: ifne +202 -> 405
    //   206: getstatic 53	com/xiaomi/push/log/b:f	Ljava/util/List;
    //   209: iconst_0
    //   210: invokeinterface 174 2 0
    //   215: checkcast 176	android/util/Pair
    //   218: astore 37
    //   220: aload 37
    //   222: getfield 180	android/util/Pair:first	Ljava/lang/Object;
    //   225: checkcast 182	java/lang/String
    //   228: astore 38
    //   230: aload 37
    //   232: getfield 185	android/util/Pair:second	Ljava/lang/Object;
    //   235: ifnull +56 -> 291
    //   238: new 79	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   245: aload 38
    //   247: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 187
    //   252: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore 39
    //   260: new 79	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   267: aload 39
    //   269: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 37
    //   274: getfield 185	android/util/Pair:second	Ljava/lang/Object;
    //   277: checkcast 189	java/lang/Throwable
    //   280: invokestatic 193	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   283: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: astore 38
    //   291: aload 28
    //   293: new 79	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   300: aload 38
    //   302: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 187
    //   307: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokevirtual 196	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   316: goto -121 -> 195
    //   319: astore_3
    //   320: aload 28
    //   322: astore 4
    //   324: aload 8
    //   326: astore 5
    //   328: aload 9
    //   330: astore 6
    //   332: aload_0
    //   333: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   336: ldc 198
    //   338: aload_3
    //   339: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   342: pop
    //   343: aload 4
    //   345: ifnull +8 -> 353
    //   348: aload 4
    //   350: invokevirtual 118	java/io/BufferedWriter:close	()V
    //   353: aload 5
    //   355: ifnull +16 -> 371
    //   358: aload 5
    //   360: invokevirtual 123	java/nio/channels/FileLock:isValid	()Z
    //   363: ifeq +8 -> 371
    //   366: aload 5
    //   368: invokevirtual 126	java/nio/channels/FileLock:release	()V
    //   371: aload 6
    //   373: ifnull -274 -> 99
    //   376: aload 6
    //   378: invokevirtual 129	java/io/RandomAccessFile:close	()V
    //   381: return
    //   382: astore 17
    //   384: aload_0
    //   385: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   388: astore 18
    //   390: ldc 198
    //   392: astore 19
    //   394: aload 18
    //   396: aload 19
    //   398: aload 17
    //   400: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   403: pop
    //   404: return
    //   405: aload 28
    //   407: invokevirtual 204	java/io/BufferedWriter:flush	()V
    //   410: aload 28
    //   412: ifnull +449 -> 861
    //   415: aload 28
    //   417: invokevirtual 118	java/io/BufferedWriter:close	()V
    //   420: aconst_null
    //   421: astore 4
    //   423: new 77	java/io/File
    //   426: dup
    //   427: aload_2
    //   428: ldc 156
    //   430: invokespecial 134	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   433: astore 29
    //   435: aload 29
    //   437: invokevirtual 208	java/io/File:length	()J
    //   440: ldc2_w 209
    //   443: lcmp
    //   444: iflt +45 -> 489
    //   447: new 77	java/io/File
    //   450: dup
    //   451: aload_2
    //   452: ldc 212
    //   454: invokespecial 134	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   457: astore 30
    //   459: aload 30
    //   461: invokevirtual 99	java/io/File:exists	()Z
    //   464: ifeq +17 -> 481
    //   467: aload 30
    //   469: invokevirtual 215	java/io/File:isFile	()Z
    //   472: ifeq +9 -> 481
    //   475: aload 30
    //   477: invokevirtual 218	java/io/File:delete	()Z
    //   480: pop
    //   481: aload 29
    //   483: aload 30
    //   485: invokevirtual 222	java/io/File:renameTo	(Ljava/io/File;)Z
    //   488: pop
    //   489: aload 4
    //   491: ifnull +8 -> 499
    //   494: aload 4
    //   496: invokevirtual 118	java/io/BufferedWriter:close	()V
    //   499: aload 8
    //   501: ifnull +16 -> 517
    //   504: aload 8
    //   506: invokevirtual 123	java/nio/channels/FileLock:isValid	()Z
    //   509: ifeq +8 -> 517
    //   512: aload 8
    //   514: invokevirtual 126	java/nio/channels/FileLock:release	()V
    //   517: aload 9
    //   519: ifnull -420 -> 99
    //   522: aload 9
    //   524: invokevirtual 129	java/io/RandomAccessFile:close	()V
    //   527: return
    //   528: astore 17
    //   530: aload_0
    //   531: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   534: astore 18
    //   536: ldc 198
    //   538: astore 19
    //   540: goto -146 -> 394
    //   543: astore 7
    //   545: aconst_null
    //   546: astore 8
    //   548: aconst_null
    //   549: astore 9
    //   551: aload_1
    //   552: ifnull +7 -> 559
    //   555: aload_1
    //   556: invokevirtual 118	java/io/BufferedWriter:close	()V
    //   559: aload 8
    //   561: ifnull +16 -> 577
    //   564: aload 8
    //   566: invokevirtual 123	java/nio/channels/FileLock:isValid	()Z
    //   569: ifeq +8 -> 577
    //   572: aload 8
    //   574: invokevirtual 126	java/nio/channels/FileLock:release	()V
    //   577: aload 9
    //   579: ifnull +8 -> 587
    //   582: aload 9
    //   584: invokevirtual 129	java/io/RandomAccessFile:close	()V
    //   587: aload 7
    //   589: athrow
    //   590: astore 14
    //   592: aload_0
    //   593: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   596: ldc 198
    //   598: aload 14
    //   600: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   603: pop
    //   604: goto -45 -> 559
    //   607: astore 10
    //   609: aload_0
    //   610: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   613: ldc 198
    //   615: aload 10
    //   617: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   620: pop
    //   621: goto -34 -> 587
    //   624: astore 12
    //   626: aload_0
    //   627: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   630: ldc 198
    //   632: aload 12
    //   634: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   637: pop
    //   638: goto -61 -> 577
    //   641: astore 23
    //   643: aload_0
    //   644: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   647: ldc 198
    //   649: aload 23
    //   651: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   654: pop
    //   655: goto -302 -> 353
    //   658: astore 21
    //   660: aload_0
    //   661: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   664: ldc 198
    //   666: aload 21
    //   668: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   671: pop
    //   672: goto -301 -> 371
    //   675: astore 43
    //   677: aload_0
    //   678: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   681: ldc 198
    //   683: aload 43
    //   685: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   688: pop
    //   689: goto -613 -> 76
    //   692: astore 17
    //   694: aload_0
    //   695: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   698: astore 18
    //   700: ldc 198
    //   702: astore 19
    //   704: goto -310 -> 394
    //   707: astore 41
    //   709: aload_0
    //   710: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   713: ldc 198
    //   715: aload 41
    //   717: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   720: pop
    //   721: goto -630 -> 91
    //   724: astore 34
    //   726: aload_0
    //   727: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   730: ldc 198
    //   732: aload 34
    //   734: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   737: pop
    //   738: goto -239 -> 499
    //   741: astore 32
    //   743: aload_0
    //   744: getfield 69	com/xiaomi/push/log/b:d	Ljava/lang/String;
    //   747: ldc 198
    //   749: aload 32
    //   751: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   754: pop
    //   755: goto -238 -> 517
    //   758: astore 7
    //   760: aconst_null
    //   761: astore_1
    //   762: aconst_null
    //   763: astore 8
    //   765: goto -214 -> 551
    //   768: astore 7
    //   770: aconst_null
    //   771: astore_1
    //   772: goto -221 -> 551
    //   775: astore 7
    //   777: aload 28
    //   779: astore_1
    //   780: goto -229 -> 551
    //   783: astore 7
    //   785: aload 4
    //   787: astore_1
    //   788: goto -237 -> 551
    //   791: astore 7
    //   793: aload 5
    //   795: astore 8
    //   797: aload 6
    //   799: astore 9
    //   801: aload 4
    //   803: astore_1
    //   804: goto -253 -> 551
    //   807: astore_3
    //   808: aconst_null
    //   809: astore 4
    //   811: aconst_null
    //   812: astore 5
    //   814: aconst_null
    //   815: astore 6
    //   817: goto -485 -> 332
    //   820: astore_3
    //   821: aload 9
    //   823: astore 6
    //   825: aconst_null
    //   826: astore 4
    //   828: aconst_null
    //   829: astore 5
    //   831: goto -499 -> 332
    //   834: astore_3
    //   835: aload 9
    //   837: astore 6
    //   839: aload 8
    //   841: astore 5
    //   843: aconst_null
    //   844: astore 4
    //   846: goto -514 -> 332
    //   849: astore_3
    //   850: aload 8
    //   852: astore 5
    //   854: aload 9
    //   856: astore 6
    //   858: goto -526 -> 332
    //   861: aload 28
    //   863: astore 4
    //   865: goto -442 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	868	0	this	b
    //   1	803	1	localObject1	Object
    //   36	416	2	localFile1	java.io.File
    //   319	20	3	localException1	java.lang.Exception
    //   807	1	3	localException2	java.lang.Exception
    //   820	1	3	localException3	java.lang.Exception
    //   834	1	3	localException4	java.lang.Exception
    //   849	1	3	localException5	java.lang.Exception
    //   322	542	4	localBufferedWriter1	java.io.BufferedWriter
    //   326	527	5	localObject2	Object
    //   330	527	6	localObject3	Object
    //   543	45	7	localObject4	Object
    //   758	1	7	localObject5	Object
    //   768	1	7	localObject6	Object
    //   775	1	7	localObject7	Object
    //   783	1	7	localObject8	Object
    //   791	1	7	localObject9	Object
    //   159	692	8	localObject10	Object
    //   145	710	9	localObject11	Object
    //   607	9	10	localIOException1	java.io.IOException
    //   624	9	12	localIOException2	java.io.IOException
    //   590	9	14	localIOException3	java.io.IOException
    //   382	17	17	localIOException4	java.io.IOException
    //   528	1	17	localIOException5	java.io.IOException
    //   692	1	17	localIOException6	java.io.IOException
    //   388	311	18	str1	String
    //   392	311	19	str2	String
    //   658	9	21	localIOException7	java.io.IOException
    //   641	9	23	localIOException8	java.io.IOException
    //   110	29	25	localFile2	java.io.File
    //   155	3	27	localFileLock	java.nio.channels.FileLock
    //   193	669	28	localBufferedWriter2	java.io.BufferedWriter
    //   433	49	29	localFile3	java.io.File
    //   457	27	30	localFile4	java.io.File
    //   741	9	32	localIOException9	java.io.IOException
    //   724	9	34	localIOException10	java.io.IOException
    //   218	55	37	localPair	Pair
    //   228	73	38	str3	String
    //   258	10	39	str4	String
    //   707	9	41	localIOException11	java.io.IOException
    //   675	9	43	localIOException12	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   195	291	319	java/lang/Exception
    //   291	316	319	java/lang/Exception
    //   405	410	319	java/lang/Exception
    //   415	420	319	java/lang/Exception
    //   376	381	382	java/io/IOException
    //   522	527	528	java/io/IOException
    //   2	51	543	finally
    //   51	68	543	finally
    //   100	128	543	finally
    //   128	134	543	finally
    //   134	147	543	finally
    //   555	559	590	java/io/IOException
    //   582	587	607	java/io/IOException
    //   572	577	624	java/io/IOException
    //   348	353	641	java/io/IOException
    //   366	371	658	java/io/IOException
    //   72	76	675	java/io/IOException
    //   95	99	692	java/io/IOException
    //   87	91	707	java/io/IOException
    //   494	499	724	java/io/IOException
    //   512	517	741	java/io/IOException
    //   147	157	758	finally
    //   161	195	768	finally
    //   195	291	775	finally
    //   291	316	775	finally
    //   405	410	775	finally
    //   415	420	775	finally
    //   423	481	783	finally
    //   481	489	783	finally
    //   332	343	791	finally
    //   2	51	807	java/lang/Exception
    //   51	68	807	java/lang/Exception
    //   100	128	807	java/lang/Exception
    //   128	134	807	java/lang/Exception
    //   134	147	807	java/lang/Exception
    //   147	157	820	java/lang/Exception
    //   161	195	834	java/lang/Exception
    //   423	481	849	java/lang/Exception
    //   481	489	849	java/lang/Exception
  }
  
  public final void a(String paramString)
  {
    a(paramString, null);
  }
  
  public final void a(String paramString, Throwable paramThrowable)
  {
    List localList = f;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = a.format(new Date());
    arrayOfObject[1] = this.d;
    arrayOfObject[2] = paramString;
    localList.add(new Pair(String.format("%1$s %2$s %3$s ", arrayOfObject), paramThrowable));
    b.a(new c(this));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.log.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */