package com.xiaomi.push.service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class t
{
  private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
  private static ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  public static void a()
  {
    if (b.getActiveCount() > 0) {
      return;
    }
    b.execute(new u());
  }
  
  /* Error */
  private static void b(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 64	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   9: ldc 67
    //   11: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 78	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   24: ldc 80
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: aastore
    //   34: invokestatic 86	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   37: astore 9
    //   39: invokestatic 92	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   42: aload 9
    //   44: invokevirtual 96	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   47: astore 10
    //   49: aload 10
    //   51: astore_3
    //   52: new 98	java/io/BufferedReader
    //   55: dup
    //   56: new 100	java/io/InputStreamReader
    //   59: dup
    //   60: aload_3
    //   61: invokevirtual 106	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   64: invokespecial 109	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   67: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   70: astore 11
    //   72: aload 11
    //   74: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: astore 12
    //   79: aload 12
    //   81: ifnull +36 -> 117
    //   84: new 64	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   91: ldc 117
    //   93: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 12
    //   98: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 78	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   107: aload 11
    //   109: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   112: astore 12
    //   114: goto -35 -> 79
    //   117: aload_3
    //   118: invokevirtual 120	java/lang/Process:waitFor	()I
    //   121: pop
    //   122: aload 11
    //   124: invokevirtual 123	java/io/BufferedReader:close	()V
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 126	java/lang/Process:destroy	()V
    //   135: return
    //   136: astore 7
    //   138: aconst_null
    //   139: astore_3
    //   140: aload 7
    //   142: invokestatic 129	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   145: aload_1
    //   146: invokevirtual 123	java/io/BufferedReader:close	()V
    //   149: aload_3
    //   150: ifnull -15 -> 135
    //   153: goto -22 -> 131
    //   156: astore 5
    //   158: aconst_null
    //   159: astore_3
    //   160: aload 5
    //   162: invokestatic 129	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   165: aload_1
    //   166: invokevirtual 123	java/io/BufferedReader:close	()V
    //   169: aload_3
    //   170: ifnull -35 -> 135
    //   173: goto -42 -> 131
    //   176: astore_2
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_1
    //   180: invokevirtual 123	java/io/BufferedReader:close	()V
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 126	java/lang/Process:destroy	()V
    //   191: aload_2
    //   192: athrow
    //   193: astore 4
    //   195: goto -12 -> 183
    //   198: astore 8
    //   200: goto -51 -> 149
    //   203: astore 6
    //   205: goto -36 -> 169
    //   208: astore 14
    //   210: goto -83 -> 127
    //   213: astore_2
    //   214: goto -35 -> 179
    //   217: astore_2
    //   218: aload 11
    //   220: astore_1
    //   221: goto -42 -> 179
    //   224: astore 5
    //   226: aconst_null
    //   227: astore_1
    //   228: goto -68 -> 160
    //   231: astore 5
    //   233: aload 11
    //   235: astore_1
    //   236: goto -76 -> 160
    //   239: astore 7
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -103 -> 140
    //   246: astore 7
    //   248: aload 11
    //   250: astore_1
    //   251: goto -111 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramString	java.lang.String
    //   1	250	1	localObject1	Object
    //   176	16	2	localObject2	Object
    //   213	1	2	localObject3	Object
    //   217	1	2	localObject4	Object
    //   51	137	3	localProcess1	java.lang.Process
    //   193	1	4	localIOException1	java.io.IOException
    //   156	5	5	localException1	java.lang.Exception
    //   224	1	5	localException2	java.lang.Exception
    //   231	1	5	localException3	java.lang.Exception
    //   203	1	6	localIOException2	java.io.IOException
    //   136	5	7	localIOException3	java.io.IOException
    //   239	1	7	localIOException4	java.io.IOException
    //   246	1	7	localIOException5	java.io.IOException
    //   198	1	8	localIOException6	java.io.IOException
    //   37	6	9	str1	java.lang.String
    //   47	3	10	localProcess2	java.lang.Process
    //   70	179	11	localBufferedReader	java.io.BufferedReader
    //   77	36	12	str2	java.lang.String
    //   208	1	14	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   24	49	136	java/io/IOException
    //   24	49	156	java/lang/Exception
    //   24	49	176	finally
    //   179	183	193	java/io/IOException
    //   145	149	198	java/io/IOException
    //   165	169	203	java/io/IOException
    //   122	127	208	java/io/IOException
    //   52	72	213	finally
    //   140	145	213	finally
    //   160	165	213	finally
    //   72	79	217	finally
    //   84	114	217	finally
    //   117	122	217	finally
    //   52	72	224	java/lang/Exception
    //   72	79	231	java/lang/Exception
    //   84	114	231	java/lang/Exception
    //   117	122	231	java/lang/Exception
    //   52	72	239	java/io/IOException
    //   72	79	246	java/io/IOException
    //   84	114	246	java/io/IOException
    //   117	122	246	java/io/IOException
  }
  
  /* Error */
  private static java.lang.String c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: invokestatic 92	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: ldc 131
    //   7: invokevirtual 96	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   10: astore 12
    //   12: aload 12
    //   14: astore_2
    //   15: new 98	java/io/BufferedReader
    //   18: dup
    //   19: new 100	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: invokevirtual 106	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   27: invokespecial 109	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   30: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 15
    //   40: aload 15
    //   42: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +289 -> 334
    //   48: aload 15
    //   50: ldc 139
    //   52: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   55: ifeq +279 -> 334
    //   58: aload 15
    //   60: ldc 145
    //   62: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: astore 17
    //   67: aload 17
    //   69: arraylength
    //   70: istore 18
    //   72: iconst_0
    //   73: istore 19
    //   75: iload 19
    //   77: iload 18
    //   79: if_icmpge +27 -> 106
    //   82: aload 17
    //   84: iload 19
    //   86: aaload
    //   87: astore 23
    //   89: getstatic 20	com/xiaomi/push/service/t:a	Ljava/util/regex/Pattern;
    //   92: aload 23
    //   94: invokevirtual 153	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   97: invokevirtual 159	java/util/regex/Matcher:matches	()Z
    //   100: ifeq +228 -> 328
    //   103: goto +237 -> 340
    //   106: aload_2
    //   107: invokevirtual 120	java/lang/Process:waitFor	()I
    //   110: pop
    //   111: aload_0
    //   112: astore 6
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 123	java/io/BufferedReader:close	()V
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 126	java/lang/Process:destroy	()V
    //   130: aload 6
    //   132: areturn
    //   133: astore 9
    //   135: aconst_null
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_3
    //   139: aconst_null
    //   140: astore 6
    //   142: aload 9
    //   144: astore 10
    //   146: aload 10
    //   148: invokestatic 129	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   151: aload_3
    //   152: ifnull +7 -> 159
    //   155: aload_3
    //   156: invokevirtual 123	java/io/BufferedReader:close	()V
    //   159: aload_2
    //   160: ifnull -30 -> 130
    //   163: goto -37 -> 126
    //   166: astore 5
    //   168: aconst_null
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_3
    //   172: aconst_null
    //   173: astore 6
    //   175: aload 5
    //   177: astore 7
    //   179: aload 7
    //   181: invokestatic 129	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   184: aload_3
    //   185: ifnull +7 -> 192
    //   188: aload_3
    //   189: invokevirtual 123	java/io/BufferedReader:close	()V
    //   192: aload_2
    //   193: ifnull -63 -> 130
    //   196: goto -70 -> 126
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_2
    //   202: aconst_null
    //   203: astore_3
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 123	java/io/BufferedReader:close	()V
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 126	java/lang/Process:destroy	()V
    //   220: aload_1
    //   221: athrow
    //   222: astore 4
    //   224: goto -12 -> 212
    //   227: astore 11
    //   229: goto -70 -> 159
    //   232: astore 8
    //   234: goto -42 -> 192
    //   237: astore 16
    //   239: goto -117 -> 122
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_3
    //   245: goto -41 -> 204
    //   248: astore_1
    //   249: goto -45 -> 204
    //   252: astore 25
    //   254: aload 25
    //   256: astore 7
    //   258: aconst_null
    //   259: astore 6
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -84 -> 179
    //   266: astore 14
    //   268: aload 14
    //   270: astore 7
    //   272: aconst_null
    //   273: astore 6
    //   275: goto -96 -> 179
    //   278: astore 21
    //   280: aload_0
    //   281: astore 6
    //   283: aload 21
    //   285: astore 7
    //   287: goto -108 -> 179
    //   290: astore 24
    //   292: aload 24
    //   294: astore 10
    //   296: aconst_null
    //   297: astore 6
    //   299: aconst_null
    //   300: astore_3
    //   301: goto -155 -> 146
    //   304: astore 13
    //   306: aload 13
    //   308: astore 10
    //   310: aconst_null
    //   311: astore 6
    //   313: goto -167 -> 146
    //   316: astore 20
    //   318: aload_0
    //   319: astore 6
    //   321: aload 20
    //   323: astore 10
    //   325: goto -179 -> 146
    //   328: aload_0
    //   329: astore 23
    //   331: goto +9 -> 340
    //   334: aconst_null
    //   335: astore 6
    //   337: goto -223 -> 114
    //   340: iinc 19 1
    //   343: aload 23
    //   345: astore_0
    //   346: goto -271 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	345	0	localObject1	Object
    //   199	22	1	localObject2	Object
    //   242	1	1	localObject3	Object
    //   248	1	1	localObject4	Object
    //   14	203	2	localProcess1	java.lang.Process
    //   33	268	3	localBufferedReader	java.io.BufferedReader
    //   222	1	4	localIOException1	java.io.IOException
    //   166	10	5	localException1	java.lang.Exception
    //   112	224	6	localObject5	Object
    //   177	109	7	localObject6	Object
    //   232	1	8	localIOException2	java.io.IOException
    //   133	10	9	localIOException3	java.io.IOException
    //   144	180	10	localObject7	Object
    //   227	1	11	localIOException4	java.io.IOException
    //   10	3	12	localProcess2	java.lang.Process
    //   304	3	13	localIOException5	java.io.IOException
    //   266	3	14	localException2	java.lang.Exception
    //   38	21	15	str	java.lang.String
    //   237	1	16	localIOException6	java.io.IOException
    //   65	18	17	arrayOfString	java.lang.String[]
    //   70	10	18	i	int
    //   73	268	19	j	int
    //   316	6	20	localIOException7	java.io.IOException
    //   278	6	21	localException3	java.lang.Exception
    //   87	257	23	localObject8	Object
    //   290	3	24	localIOException8	java.io.IOException
    //   252	3	25	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	12	133	java/io/IOException
    //   2	12	166	java/lang/Exception
    //   2	12	199	finally
    //   208	212	222	java/io/IOException
    //   155	159	227	java/io/IOException
    //   188	192	232	java/io/IOException
    //   118	122	237	java/io/IOException
    //   15	34	242	finally
    //   34	72	248	finally
    //   82	103	248	finally
    //   106	111	248	finally
    //   146	151	248	finally
    //   179	184	248	finally
    //   15	34	252	java/lang/Exception
    //   34	72	266	java/lang/Exception
    //   82	103	278	java/lang/Exception
    //   106	111	278	java/lang/Exception
    //   15	34	290	java/io/IOException
    //   34	72	304	java/io/IOException
    //   82	103	316	java/io/IOException
    //   106	111	316	java/io/IOException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.t
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */