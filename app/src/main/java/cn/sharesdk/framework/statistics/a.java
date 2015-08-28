package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.network.i;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.statistics.b.g;
import cn.sharesdk.framework.utils.BitmapHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static String b = "http://api.share.mob.com:80";
  static String c;
  static boolean d = false;
  private static a e;
  private static cn.sharesdk.framework.statistics.a.c f;
  private static String g = "http://l.mob.com/url/ShareSdkMapping.do";
  private static String h = "http://up.sharesdk.cn/upload/image";
  Context a;
  private boolean i;
  private boolean j = true;
  private i k = new i();
  
  public static a a(Context paramContext)
  {
    if (e == null)
    {
      e = new a();
      e.a = paramContext.getApplicationContext();
      f = cn.sharesdk.framework.statistics.a.c.a(e.a);
    }
    return e;
  }
  
  private String a(Bitmap paramBitmap, a.a parama)
  {
    try
    {
      File localFile = File.createTempFile("bm_tmp", ".png");
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      String str = a(localFile.getAbsolutePath(), parama);
      return str;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.c(localThrowable);
    }
    return null;
  }
  
  private String a(String paramString, a.a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return null;
    }
    Bitmap.CompressFormat localCompressFormat = BitmapHelper.getBmpFormat(paramString);
    float f1 = 200.0F;
    if (parama == a.a.b) {
      f1 = 600.0F;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    int m = localOptions.outWidth;
    int n = localOptions.outHeight;
    if ((m >= n) && (n > f1)) {}
    for (int i1 = (int)Math.ceil(localOptions.outHeight / f1);; i1 = (int)Math.ceil(localOptions.outWidth / f1))
    {
      if (i1 <= 0) {
        i1 = 1;
      }
      localOptions.inSampleSize = i1;
      localOptions.inPurgeable = true;
      localOptions.inInputShareable = true;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
        localBitmap.getHeight();
        localBitmap.getWidth();
        File localFile = File.createTempFile("bm_tmp2", "." + localCompressFormat.name().toLowerCase());
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        localBitmap.compress(localCompressFormat, 80, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        String str = g(localFile.getAbsolutePath());
        return str;
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
      }
      if ((m >= n) || (m <= f1)) {
        break;
      }
    }
    return g(paramString);
    return null;
  }
  
  /* Error */
  private String a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: getfield 42	cn/sharesdk/framework/statistics/a:j	Z
    //   11: ifne +5 -> 16
    //   14: aload_1
    //   15: areturn
    //   16: new 209	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 210	java/util/ArrayList:<init>	()V
    //   23: astore 6
    //   25: aload_3
    //   26: invokestatic 216	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   29: astore 7
    //   31: aload 7
    //   33: aload_1
    //   34: invokevirtual 220	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   37: astore 8
    //   39: aload 8
    //   41: invokevirtual 225	java/util/regex/Matcher:find	()Z
    //   44: ifeq +34 -> 78
    //   47: aload 8
    //   49: invokevirtual 228	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   52: astore 48
    //   54: aload 48
    //   56: ifnull -17 -> 39
    //   59: aload 48
    //   61: invokevirtual 231	java/lang/String:length	()I
    //   64: ifle -25 -> 39
    //   67: aload 6
    //   69: aload 48
    //   71: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   74: pop
    //   75: goto -36 -> 39
    //   78: aload 6
    //   80: invokevirtual 238	java/util/ArrayList:size	()I
    //   83: ifeq -69 -> 14
    //   86: new 209	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 210	java/util/ArrayList:<init>	()V
    //   93: astore 9
    //   95: aload 9
    //   97: new 240	cn/sharesdk/framework/network/f
    //   100: dup
    //   101: ldc 242
    //   103: aload_2
    //   104: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   107: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: iconst_0
    //   112: istore 11
    //   114: iload 11
    //   116: aload 6
    //   118: invokevirtual 238	java/util/ArrayList:size	()I
    //   121: if_icmpge +37 -> 158
    //   124: aload 9
    //   126: new 240	cn/sharesdk/framework/network/f
    //   129: dup
    //   130: ldc 247
    //   132: aload 6
    //   134: iload 11
    //   136: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   139: checkcast 197	java/lang/String
    //   142: invokevirtual 252	java/lang/String:toString	()Ljava/lang/String;
    //   145: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   148: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: iinc 11 1
    //   155: goto -41 -> 114
    //   158: aload 9
    //   160: new 240	cn/sharesdk/framework/network/f
    //   163: dup
    //   164: ldc 254
    //   166: aload_0
    //   167: getfield 59	cn/sharesdk/framework/statistics/a:a	Landroid/content/Context;
    //   170: invokestatic 259	cn/sharesdk/framework/utils/b:a	(Landroid/content/Context;)Lcn/sharesdk/framework/utils/b;
    //   173: invokevirtual 262	cn/sharesdk/framework/utils/b:p	()Ljava/lang/String;
    //   176: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   179: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   182: pop
    //   183: aload 9
    //   185: new 240	cn/sharesdk/framework/network/f
    //   188: dup
    //   189: ldc_w 264
    //   192: iload 4
    //   194: invokestatic 268	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   197: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   200: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   203: pop
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: astore 14
    //   210: aload 14
    //   212: iconst_0
    //   213: aload_0
    //   214: getfield 59	cn/sharesdk/framework/statistics/a:a	Landroid/content/Context;
    //   217: invokestatic 259	cn/sharesdk/framework/utils/b:a	(Landroid/content/Context;)Lcn/sharesdk/framework/utils/b;
    //   220: invokevirtual 262	cn/sharesdk/framework/utils/b:p	()Ljava/lang/String;
    //   223: aastore
    //   224: ldc_w 270
    //   227: aload 14
    //   229: invokestatic 273	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   232: pop
    //   233: aload_0
    //   234: aload_2
    //   235: aload 5
    //   237: invokespecial 276	cn/sharesdk/framework/statistics/a:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 16
    //   242: aload 16
    //   244: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne -233 -> 14
    //   250: aload 9
    //   252: new 240	cn/sharesdk/framework/network/f
    //   255: dup
    //   256: ldc_w 278
    //   259: aload 16
    //   261: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   264: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   267: pop
    //   268: new 209	java/util/ArrayList
    //   271: dup
    //   272: invokespecial 210	java/util/ArrayList:<init>	()V
    //   275: astore 18
    //   277: aload 18
    //   279: new 240	cn/sharesdk/framework/network/f
    //   282: dup
    //   283: ldc_w 280
    //   286: getstatic 282	cn/sharesdk/framework/statistics/a:c	Ljava/lang/String;
    //   289: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   292: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   295: pop
    //   296: new 209	java/util/ArrayList
    //   299: dup
    //   300: invokespecial 210	java/util/ArrayList:<init>	()V
    //   303: astore 20
    //   305: aload 20
    //   307: new 240	cn/sharesdk/framework/network/f
    //   310: dup
    //   311: ldc_w 284
    //   314: sipush 5000
    //   317: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   323: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   326: pop
    //   327: aload 20
    //   329: new 240	cn/sharesdk/framework/network/f
    //   332: dup
    //   333: ldc_w 291
    //   336: sipush 5000
    //   339: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: invokespecial 245	cn/sharesdk/framework/network/f:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   345: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   348: pop
    //   349: aload_0
    //   350: getfield 47	cn/sharesdk/framework/statistics/a:k	Lcn/sharesdk/framework/network/i;
    //   353: getstatic 33	cn/sharesdk/framework/statistics/a:g	Ljava/lang/String;
    //   356: aload 9
    //   358: aconst_null
    //   359: aload 18
    //   361: aload 20
    //   363: invokevirtual 294	cn/sharesdk/framework/network/i:a	(Ljava/lang/String;Ljava/util/ArrayList;Lcn/sharesdk/framework/network/f;Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/String;
    //   366: astore 46
    //   368: aload 46
    //   370: astore 25
    //   372: aload 25
    //   374: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifeq +24 -> 401
    //   380: aload_0
    //   381: iconst_0
    //   382: putfield 42	cn/sharesdk/framework/statistics/a:j	Z
    //   385: aload_1
    //   386: areturn
    //   387: astore 23
    //   389: aload 23
    //   391: invokestatic 114	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   394: pop
    //   395: aconst_null
    //   396: astore 25
    //   398: goto -26 -> 372
    //   401: ldc_w 296
    //   404: iconst_1
    //   405: anewarray 4	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: aload 25
    //   412: aastore
    //   413: invokestatic 273	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   416: pop
    //   417: new 298	cn/sharesdk/framework/utils/d
    //   420: dup
    //   421: invokespecial 299	cn/sharesdk/framework/utils/d:<init>	()V
    //   424: aload 25
    //   426: invokevirtual 302	cn/sharesdk/framework/utils/d:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   429: astore 27
    //   431: aload 27
    //   433: ldc_w 304
    //   436: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   439: checkcast 286	java/lang/Integer
    //   442: invokevirtual 312	java/lang/Integer:intValue	()I
    //   445: istore 45
    //   447: iload 45
    //   449: istore 30
    //   451: iload 30
    //   453: sipush 200
    //   456: if_icmpne -442 -> 14
    //   459: aload 27
    //   461: ldc_w 314
    //   464: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   467: checkcast 209	java/util/ArrayList
    //   470: astore 31
    //   472: new 306	java/util/HashMap
    //   475: dup
    //   476: invokespecial 315	java/util/HashMap:<init>	()V
    //   479: astore 32
    //   481: aload 31
    //   483: invokevirtual 319	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   486: astore 33
    //   488: aload 33
    //   490: invokeinterface 324 1 0
    //   495: ifeq +64 -> 559
    //   498: aload 33
    //   500: invokeinterface 328 1 0
    //   505: checkcast 306	java/util/HashMap
    //   508: astore 42
    //   510: aload 42
    //   512: ldc_w 330
    //   515: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   518: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   521: astore 43
    //   523: aload 32
    //   525: aload 42
    //   527: ldc_w 335
    //   530: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   533: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   536: aload 43
    //   538: invokevirtual 339	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   541: pop
    //   542: goto -54 -> 488
    //   545: astore 28
    //   547: aload 28
    //   549: invokestatic 114	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   552: pop
    //   553: iconst_m1
    //   554: istore 30
    //   556: goto -105 -> 451
    //   559: aload 7
    //   561: aload_1
    //   562: invokevirtual 220	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   565: astore 34
    //   567: new 185	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   574: astore 35
    //   576: iconst_0
    //   577: istore 36
    //   579: aload 34
    //   581: invokevirtual 225	java/util/regex/Matcher:find	()Z
    //   584: ifeq +49 -> 633
    //   587: aload 35
    //   589: aload_1
    //   590: iload 36
    //   592: aload 34
    //   594: invokevirtual 342	java/util/regex/Matcher:start	()I
    //   597: invokevirtual 346	java/lang/String:substring	(II)Ljava/lang/String;
    //   600: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 35
    //   606: aload 32
    //   608: aload 34
    //   610: invokevirtual 228	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   613: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   616: checkcast 197	java/lang/String
    //   619: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 34
    //   625: invokevirtual 349	java/util/regex/Matcher:end	()I
    //   628: istore 36
    //   630: goto -51 -> 579
    //   633: aload 35
    //   635: aload_1
    //   636: iload 36
    //   638: aload_1
    //   639: invokevirtual 231	java/lang/String:length	()I
    //   642: invokevirtual 346	java/lang/String:substring	(II)Ljava/lang/String;
    //   645: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 35
    //   651: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: astore 38
    //   656: ldc_w 351
    //   659: iconst_1
    //   660: anewarray 4	java/lang/Object
    //   663: dup
    //   664: iconst_0
    //   665: aload 38
    //   667: aastore
    //   668: invokestatic 273	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   671: pop
    //   672: aload 38
    //   674: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	a
    //   0	675	1	paramString1	String
    //   0	675	2	paramString2	String
    //   0	675	3	paramString3	String
    //   0	675	4	paramInt	int
    //   0	675	5	paramString4	String
    //   23	110	6	localArrayList1	ArrayList
    //   29	531	7	localPattern	java.util.regex.Pattern
    //   37	11	8	localMatcher1	java.util.regex.Matcher
    //   93	264	9	localArrayList2	ArrayList
    //   112	41	11	m	int
    //   208	20	14	arrayOfObject	Object[]
    //   240	20	16	str1	String
    //   275	85	18	localArrayList3	ArrayList
    //   303	59	20	localArrayList4	ArrayList
    //   387	3	23	localThrowable1	Throwable
    //   370	55	25	str2	String
    //   429	31	27	localHashMap1	HashMap
    //   545	3	28	localThrowable2	Throwable
    //   449	106	30	n	int
    //   470	12	31	localArrayList5	ArrayList
    //   479	128	32	localHashMap2	HashMap
    //   486	13	33	localIterator	java.util.Iterator
    //   565	59	34	localMatcher2	java.util.regex.Matcher
    //   574	76	35	localStringBuilder	StringBuilder
    //   577	60	36	i1	int
    //   654	19	38	str3	String
    //   508	18	42	localHashMap3	HashMap
    //   521	16	43	str4	String
    //   445	3	45	i2	int
    //   366	3	46	str5	String
    //   52	18	48	str6	String
    // Exception table:
    //   from	to	target	type
    //   349	368	387	java/lang/Throwable
    //   431	447	545	java/lang/Throwable
  }
  
  private String a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      String str1 = Base64.encodeToString(cn.sharesdk.framework.utils.a.a(paramArrayOfByte, paramString), 0);
      localObject = str1;
      String str2;
      Throwable localThrowable2;
      cn.sharesdk.framework.utils.e.c(localThrowable2);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (((String)localObject).contains("\n"))
        {
          str2 = ((String)localObject).replace("\n", "");
          localObject = str2;
        }
        return localObject;
      }
      catch (Throwable localThrowable3)
      {
        Object localObject;
        break label53;
      }
      localThrowable1 = localThrowable1;
      localObject = null;
      localThrowable2 = localThrowable1;
    }
    label53:
    return localObject;
  }
  
  private String b()
  {
    return b + "/date";
  }
  
  private String c()
  {
    return b + "/log4";
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      localArrayList1.add(new cn.sharesdk.framework.network.f("m", paramString1));
      localArrayList1.add(new cn.sharesdk.framework.network.f("t", paramString2));
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", c));
      ArrayList localArrayList3 = new ArrayList();
      localArrayList3.add(new cn.sharesdk.framework.network.f("http.socket.timeout", Integer.valueOf(30000)));
      localArrayList3.add(new cn.sharesdk.framework.network.f("http.connection.timeout", Integer.valueOf(30000)));
      String str = this.k.a(c(), localArrayList1, null, localArrayList2, localArrayList3);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = c();
      arrayOfObject[1] = str;
      cn.sharesdk.framework.utils.e.b("> %s  resp: %s", arrayOfObject);
      if (str != null) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.c(localThrowable);
      return false;
    }
    return false;
  }
  
  private String d()
  {
    return b + "/data2";
  }
  
  private String d(String paramString1, String paramString2)
  {
    cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.a);
    boolean bool1 = f.b();
    boolean bool2 = f.c();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.q(), "utf-8")).append("|");
        localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.t(), "utf-8")).append("|");
        localStringBuilder.append(cn.sharesdk.framework.utils.a.c(String.valueOf(30000 + ShareSDK.getSDKVersionCode()), "utf-8")).append("|");
        localStringBuilder.append(cn.sharesdk.framework.utils.a.c(String.valueOf(localb.o()), "utf-8")).append("|");
        localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.n(), "utf-8")).append("|");
        if (bool1)
        {
          localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.i(), "utf-8")).append("|");
          localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.k(), "utf-8")).append("|");
          localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.c(), "utf-8")).append("|");
          localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.b(), "utf-8")).append("|");
          localStringBuilder.append(cn.sharesdk.framework.utils.a.c(localb.l(), "utf-8")).append("|");
          if (bool2)
          {
            localStringBuilder.append(paramString2);
            String str = localStringBuilder.toString();
            cn.sharesdk.framework.utils.e.c("shorLinkMsg ===>>>>", new Object[] { str });
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = (localb.p() + ":" + paramString1);
            cn.sharesdk.framework.utils.e.c("Base64AES key ===>>>>", arrayOfObject1);
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = localb.p();
            arrayOfObject2[1] = paramString1;
            return a(str, cn.sharesdk.framework.utils.a.c(String.format("%s:%s", arrayOfObject2)));
          }
        }
        else
        {
          localStringBuilder.append("|||||");
          continue;
        }
        localStringBuilder.append(paramString2.split("\\|")[0]);
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        return "";
      }
      localStringBuilder.append("|||||");
    }
  }
  
  private String e()
  {
    return b + "/snsconf";
  }
  
  private String f()
  {
    return b + "/conf4";
  }
  
  private String g()
  {
    return b + "/conn";
  }
  
  private String g(String paramString)
  {
    String str1 = h;
    cn.sharesdk.framework.utils.e.b(" upload file , server url = %s, file path = %s", new Object[] { str1, paramString });
    try
    {
      cn.sharesdk.framework.network.f localf = new cn.sharesdk.framework.network.f("file", paramString);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new cn.sharesdk.framework.network.f("User-Agent", c));
      String str2 = this.k.a(str1, null, localf, localArrayList, null);
      cn.sharesdk.framework.utils.e.b("upload file response == %s", new Object[] { str2 });
      Object localObject = null;
      int n;
      String str4;
      if (str2 != null)
      {
        int m = str2.length();
        localObject = null;
        if (m > 0)
        {
          HashMap localHashMap = new cn.sharesdk.framework.utils.d().a(str2);
          if (!localHashMap.containsKey("status")) {
            break label206;
          }
          n = Integer.parseInt(localHashMap.get("status").toString());
          localObject = null;
          if (n == 200)
          {
            if (!localHashMap.containsKey("url")) {
              break label212;
            }
            str4 = localHashMap.get("url").toString();
          }
        }
      }
      label206:
      label212:
      for (String str3 = str4;; str3 = null)
      {
        localObject = str3;
        return localObject;
        n = -1;
        break;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.c(localThrowable);
    }
  }
  
  private long h()
  {
    if (!f.g()) {
      return 0L;
    }
    Object localObject = "{}";
    try
    {
      String str = this.k.a(b(), null, null, null);
      localObject = str;
      HashMap localHashMap = new cn.sharesdk.framework.utils.d().a((String)localObject);
      if (localHashMap.containsKey("timestamp"))
      {
        long l1 = Long.parseLong(localHashMap.get("timestamp").toString());
        long l2 = System.currentTimeMillis() - l1;
        f.a("service_time", Long.valueOf(l2));
        return l2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
      }
    }
    return f.a();
  }
  
  private String h(String paramString)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramString.getBytes());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream;
    try
    {
      localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      byte[] arrayOfByte1 = new byte[1024];
      for (;;)
      {
        int m = localByteArrayInputStream.read(arrayOfByte1, 0, 1024);
        if (m == -1) {
          break;
        }
        localGZIPOutputStream.write(arrayOfByte1, 0, m);
      }
      localGZIPOutputStream.flush();
    }
    catch (IOException localIOException)
    {
      cn.sharesdk.framework.utils.e.c(localIOException);
      return null;
    }
    localGZIPOutputStream.close();
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    localByteArrayInputStream.close();
    String str = Base64.encodeToString(arrayOfByte2, 2);
    return str;
  }
  
  private String i(String paramString)
  {
    JSONObject localJSONObject = i();
    cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.a);
    try
    {
      localJSONObject.put("type", "DEVICE");
      localJSONObject.put("key", localb.p());
      localJSONObject.put("carrier", localb.l());
      localJSONObject.put("appkey", paramString);
      localJSONObject.put("apppkg", localb.q());
      localJSONObject.put("appver", String.valueOf(localb.s()));
      localJSONObject.put("sdkver", 30000 + ShareSDK.getSDKVersionCode());
      localJSONObject.put("networktype", localb.n());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.c(localJSONException);
      }
    }
  }
  
  private JSONObject i()
  {
    JSONObject localJSONObject = new JSONObject();
    cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.a);
    try
    {
      localJSONObject.put("mac", localb.a());
      localJSONObject.put("udid", localb.d());
      localJSONObject.put("model", localb.b());
      localJSONObject.put("factory", localb.c());
      localJSONObject.put("plat", localb.o());
      localJSONObject.put("sysver", localb.i());
      localJSONObject.put("breaked", false);
      localJSONObject.put("screensize", localb.k());
      localJSONObject.put("androidid", localb.y());
      String str = localb.z();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("adsid", str);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      cn.sharesdk.framework.utils.e.c(localJSONException);
    }
    return localJSONObject;
  }
  
  public String a(Bitmap paramBitmap)
  {
    return a(paramBitmap, a.a.b);
  }
  
  public String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    if (!f.g()) {}
    String str1;
    do
    {
      return paramString1;
      cn.sharesdk.framework.utils.e.c("> SERVER_SHORT_LINK_URL content before replace link ===  %s", new Object[] { paramString1 });
      if (paramBoolean)
      {
        String str2 = a(paramString1, paramString2, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", paramInt, paramString3);
        if ((str2 != null) && (!str2.equals(paramString1))) {
          return str2;
        }
      }
      str1 = a(paramString1, paramString2, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", paramInt, paramString3);
    } while ((str1 == null) || (str1.equals(paramString1)));
    return str1;
  }
  
  public void a()
  {
    if (!f.g()) {}
    while ("none".equals(cn.sharesdk.framework.utils.b.a(this.a).n())) {
      return;
    }
    ArrayList localArrayList = cn.sharesdk.framework.statistics.a.e.a(this.a);
    int m = 0;
    label39:
    cn.sharesdk.framework.statistics.a.d locald;
    if (m < localArrayList.size())
    {
      locald = (cn.sharesdk.framework.statistics.a.d)localArrayList.get(m);
      if (locald.b.size() != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool = c(locald.a, "0");; bool = c(h(locald.a), "1"))
    {
      if (bool) {
        cn.sharesdk.framework.statistics.a.e.a(this.a, locald.b);
      }
      m++;
      break label39;
      break;
    }
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    int m = 0;
    if (!f.g()) {
      return;
    }
    cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.a);
    String str1 = localb.n();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramc.toString();
    cn.sharesdk.framework.utils.e.b(" event string == %s", arrayOfObject);
    if (((paramc instanceof g)) && (!str1.endsWith("none")))
    {
      String str5 = localb.q() + "/" + localb.t();
      String str6 = "ShareSDK/" + ShareSDK.getSDKVersionName();
      String str7 = "Android/" + localb.i();
      c = str5 + " " + str6 + " " + str7;
    }
    for (;;)
    {
      if (!f.b()) {
        paramc.m = null;
      }
      long l = f.a();
      if (l == 0L) {
        l = h();
      }
      paramc.e = (System.currentTimeMillis() - l);
      cn.sharesdk.framework.statistics.a.e.a(this.a, paramc.toString(), paramc.e);
      return;
      if ((paramc instanceof cn.sharesdk.framework.statistics.b.b))
      {
        boolean bool2 = f.c();
        String str4 = ((cn.sharesdk.framework.statistics.b.b)paramc).c;
        if ((bool2) && (!TextUtils.isEmpty(str4)))
        {
          ((cn.sharesdk.framework.statistics.b.b)paramc).c = cn.sharesdk.framework.utils.a.b(str4, paramc.f.substring(0, 16));
        }
        else
        {
          ((cn.sharesdk.framework.statistics.b.b)paramc).d = null;
          ((cn.sharesdk.framework.statistics.b.b)paramc).c = null;
        }
      }
      else if ((paramc instanceof cn.sharesdk.framework.statistics.b.f))
      {
        cn.sharesdk.framework.statistics.b.f localf = (cn.sharesdk.framework.statistics.b.f)paramc;
        int n = f.d();
        boolean bool1 = f.c();
        f.a locala = localf.d;
        int i3;
        if ((n == 1) || ((n == 0) && (this.i)))
        {
          if ((locala == null) || (locala.e == null)) {}
          for (int i1 = 0;; i1 = locala.e.size()) {
            for (int i2 = 0; i2 < i1; i2++)
            {
              String str3 = a((String)locala.e.get(i2), a.a.a);
              if (str3 != null) {
                locala.d.add(str3);
              }
            }
          }
          if ((locala == null) || (locala.f == null)) {
            i3 = 0;
          }
        }
        while (m < i3)
        {
          String str2 = a((Bitmap)locala.f.get(m), a.a.a);
          if (str2 != null) {
            locala.d.add(str2);
          }
          m++;
          continue;
          i3 = locala.f.size();
          m = 0;
          continue;
          localf.d = null;
        }
        if (!bool1) {
          localf.n = null;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    f.b(paramString1, paramString2);
  }
  
  public void a(String paramString, ArrayList<HashMap<String, String>> paramArrayList)
  {
    if (!f.g()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramString);
    cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.a);
    localHashMap.put("plat", Integer.valueOf(localb.o()));
    localHashMap.put("device", localb.p());
    localHashMap.put("list", paramArrayList);
    String str = new cn.sharesdk.framework.utils.d().a(localHashMap);
    cn.sharesdk.framework.utils.e.a(" upload apps info == %s", new Object[] { str });
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new cn.sharesdk.framework.network.f("m", cn.sharesdk.framework.utils.a.b(str, "sdk.sharesdk.sdk")));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", c));
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.add(new cn.sharesdk.framework.network.f("http.socket.timeout", Integer.valueOf(30000)));
    localArrayList3.add(new cn.sharesdk.framework.network.f("http.connection.timeout", Integer.valueOf(30000)));
    cn.sharesdk.framework.utils.e.b("> APPS_UNFINISHED  resp: %s", new Object[] { this.k.a(d(), localArrayList1, null, localArrayList2, localArrayList3) });
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(f.h().longValue());
    int m = localCalendar.get(1);
    int n = localCalendar.get(2);
    int i1 = localCalendar.get(5);
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    int i4 = localCalendar.get(5);
    boolean bool;
    if ((m == i2) || (n == i3) || (i1 == i4)) {
      bool = f.g();
    }
    for (;;)
    {
      return bool;
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(new cn.sharesdk.framework.network.f("appkey", paramString));
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", c));
        ArrayList localArrayList3 = new ArrayList();
        localArrayList3.add(new cn.sharesdk.framework.network.f("http.socket.timeout", Integer.valueOf(30000)));
        localArrayList3.add(new cn.sharesdk.framework.network.f("http.connection.timeout", Integer.valueOf(30000)));
        str = this.k.a(g(), localArrayList1, null, localArrayList2, localArrayList3);
        if (TextUtils.isEmpty(str)) {
          str = "{}";
        }
        cn.sharesdk.framework.utils.e.b(" get server connection response == %s", new Object[] { str });
        HashMap localHashMap = new cn.sharesdk.framework.utils.d().a(str);
        if (localHashMap.containsKey("res"))
        {
          bool = Boolean.parseBoolean(localHashMap.get("res").toString());
          f.a(bool);
          if ("{}".equals(str)) {
            continue;
          }
          f.b(System.currentTimeMillis());
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.e.c(localThrowable);
          String str = "{}";
          continue;
          bool = true;
        }
      }
    }
  }
  
  public long b(String paramString)
  {
    if (!f.g()) {}
    HashMap localHashMap1;
    for (;;)
    {
      return 0L;
      cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.a);
      f.a(System.currentTimeMillis());
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(new cn.sharesdk.framework.network.f("appkey", paramString));
        localArrayList1.add(new cn.sharesdk.framework.network.f("device", localb.p()));
        localArrayList1.add(new cn.sharesdk.framework.network.f("plat", String.valueOf(localb.o())));
        localArrayList1.add(new cn.sharesdk.framework.network.f("apppkg", localb.q()));
        localArrayList1.add(new cn.sharesdk.framework.network.f("appver", String.valueOf(localb.s())));
        localArrayList1.add(new cn.sharesdk.framework.network.f("sdkver", String.valueOf(30000 + ShareSDK.getSDKVersionCode())));
        localArrayList1.add(new cn.sharesdk.framework.network.f("networktype", localb.n()));
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", c));
        ArrayList localArrayList3 = new ArrayList();
        localArrayList3.add(new cn.sharesdk.framework.network.f("http.socket.timeout", Integer.valueOf(10000)));
        localArrayList3.add(new cn.sharesdk.framework.network.f("http.connection.timeout", Integer.valueOf(10000)));
        str1 = this.k.a(f(), localArrayList1, null, localArrayList2, localArrayList3);
        if (TextUtils.isEmpty(str1)) {
          str1 = "{}";
        }
        cn.sharesdk.framework.utils.e.b(" get server config response == %s", new Object[] { str1 });
        localHashMap1 = new cn.sharesdk.framework.utils.d().a(str1);
        if ((localHashMap1.containsKey("status")) && (Integer.parseInt(String.valueOf(localHashMap1.get("status"))) == -200))
        {
          if (!ShareSDK.isDebug()) {
            continue;
          }
          System.err.print(String.valueOf(localHashMap1.get("error")));
          return 0L;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.e.c(localThrowable);
          String str1 = "{}";
        }
      }
    }
    long l3;
    if (localHashMap1.containsKey("timestamp"))
    {
      long l2 = Long.parseLong(localHashMap1.get("timestamp").toString());
      l3 = System.currentTimeMillis() - l2;
      f.a("service_time", Long.valueOf(l3));
    }
    for (long l1 = l3;; l1 = 0L)
    {
      if (localHashMap1.containsKey("switchs"))
      {
        new HashMap();
        HashMap localHashMap2 = (HashMap)localHashMap1.get("switchs");
        String str2 = localHashMap2.get("device").toString();
        String str3 = localHashMap2.get("share").toString();
        String str4 = localHashMap2.get("auth").toString();
        f.d(str2);
        f.f(str3);
        f.e(str4);
      }
      if ((localHashMap1.containsKey("requesthost")) && (localHashMap1.containsKey("requestport")))
      {
        String str5 = String.valueOf(localHashMap1.get("requesthost"));
        String str6 = String.valueOf(localHashMap1.get("requestport"));
        if ((!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6))) {
          b = "http://" + str5 + ":" + str6;
        }
      }
      c(paramString);
      return l1;
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = Base64.decode(paramString2, 0);
    String str = cn.sharesdk.framework.utils.b.a(this.a).p();
    return new String(cn.sharesdk.framework.utils.a.a(cn.sharesdk.framework.utils.a.c(paramString1 + ":" + str), arrayOfByte), "UTF-8");
  }
  
  public void c(String paramString)
  {
    if (!f.g()) {}
    for (;;)
    {
      return;
      try
      {
        String str1 = f.e().trim();
        String str2 = i().toString().trim();
        if (!str2.equals(str1))
        {
          f.h(str2);
          cn.sharesdk.framework.utils.e.a(" curBaseDeviceInfo == %s", new Object[] { str2 });
          ArrayList localArrayList1 = new ArrayList();
          localArrayList1.add(new cn.sharesdk.framework.network.f("m", cn.sharesdk.framework.utils.a.b(i(paramString), "sdk.sharesdk.sdk")));
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", c));
          ArrayList localArrayList3 = new ArrayList();
          localArrayList3.add(new cn.sharesdk.framework.network.f("http.socket.timeout", Integer.valueOf(30000)));
          localArrayList3.add(new cn.sharesdk.framework.network.f("http.connection.timeout", Integer.valueOf(30000)));
          cn.sharesdk.framework.utils.e.b("> DEVICE_UNFINISHED  resp: %s", new Object[] { this.k.a(d(), localArrayList1, null, localArrayList2, localArrayList3) });
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
      }
    }
  }
  
  public String d(String paramString)
  {
    return a(paramString, a.a.b);
  }
  
  public HashMap<String, Object> e(String paramString)
  {
    try
    {
      String str = f.g(paramString);
      HashMap localHashMap = new cn.sharesdk.framework.utils.d().a(str);
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b(localThrowable);
    }
    return new HashMap();
  }
  
  public String f(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new cn.sharesdk.framework.network.f("appkey", paramString));
    localArrayList1.add(new cn.sharesdk.framework.network.f("device", cn.sharesdk.framework.utils.b.a(this.a).p()));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", c));
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.add(new cn.sharesdk.framework.network.f("http.socket.timeout", Integer.valueOf(10000)));
    localArrayList3.add(new cn.sharesdk.framework.network.f("http.connection.timeout", Integer.valueOf(10000)));
    return this.k.a(e(), localArrayList1, null, localArrayList2, localArrayList3);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */