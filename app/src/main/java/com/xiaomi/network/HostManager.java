package com.xiaomi.network;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.common.logger.thrift.mfs.a;
import com.xiaomi.common.logger.thrift.mfs.d;
import com.xiaomi.common.logger.thrift.mfs.e;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

public class HostManager
{
  private static Map<String, ArrayList<String>> b = new HashMap();
  private static HostManager k;
  private static HostManager.HostManagerFactory l;
  private static String m;
  private static String n;
  private static boolean o = false;
  protected Map<String, Fallbacks> a = new HashMap();
  private Context c;
  private HostFilter d;
  private HostManager.HttpGet e;
  private String f = "0";
  private long g = 0L;
  private final long h = 15L;
  private long i = 0L;
  private String j = "isp_prov_city_country_ip";
  
  protected HostManager(Context paramContext, HostFilter paramHostFilter, HostManager.HttpGet paramHttpGet, String paramString1, String paramString2, String paramString3)
  {
    this.c = paramContext.getApplicationContext();
    if (this.c == null) {
      this.c = paramContext;
    }
    this.e = paramHttpGet;
    if (paramHostFilter == null)
    {
      this.d = new b(this);
      this.f = paramString1;
      if (paramString2 == null) {
        break label120;
      }
      label96:
      m = paramString2;
      if (paramString3 == null) {
        break label129;
      }
    }
    for (;;)
    {
      n = paramString3;
      return;
      this.d = paramHostFilter;
      break;
      label120:
      paramString2 = paramContext.getPackageName();
      break label96;
      label129:
      paramString3 = j();
    }
  }
  
  public static HostManager a()
  {
    try
    {
      if (k == null) {
        throw new IllegalStateException("the host manager is not initialized yet.");
      }
    }
    finally {}
    HostManager localHostManager = k;
    return localHostManager;
  }
  
  private String a(ArrayList<String> paramArrayList, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new BasicNameValuePair("type", paramString));
    localArrayList2.add(new BasicNameValuePair("uuid", this.f));
    localArrayList2.add(new BasicNameValuePair("list", a(paramArrayList, ",")));
    Fallback localFallback = c("resolver.gslb.mi-idc.com");
    String str = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", new Object[] { "resolver.gslb.mi-idc.com" });
    if (localFallback == null) {
      localArrayList1.add(str);
    }
    Uri.Builder localBuilder;
    for (;;)
    {
      Iterator localIterator1 = localArrayList1.iterator();
      if (!localIterator1.hasNext()) {
        break label256;
      }
      localBuilder = Uri.parse((String)localIterator1.next()).buildUpon();
      Iterator localIterator2 = localArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)localIterator2.next();
        localBuilder.appendQueryParameter(localNameValuePair.getName(), localNameValuePair.getValue());
      }
      localArrayList1 = localFallback.a(str);
    }
    if (this.e == null) {
      return Network.a(this.c, new URL(localBuilder.toString()));
    }
    return this.e.a(localBuilder.toString());
    label256:
    return null;
  }
  
  public static <T> String a(Collection<T> paramCollection, String paramString)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArrayOfString[0]);
    for (int i1 = 1; i1 < paramArrayOfString.length; i1++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramArrayOfString[i1]);
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private ArrayList<Fallback> a(ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 227	com/xiaomi/network/HostManager:h	()V
    //   4: aload_0
    //   5: getfield 45	com/xiaomi/network/HostManager:a	Ljava/util/Map;
    //   8: astore_2
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_0
    //   12: invokevirtual 229	com/xiaomi/network/HostManager:d	()Z
    //   15: pop
    //   16: aload_0
    //   17: getfield 45	com/xiaomi/network/HostManager:a	Ljava/util/Map;
    //   20: invokeinterface 235 1 0
    //   25: invokeinterface 238 1 0
    //   30: astore 5
    //   32: aload 5
    //   34: invokeinterface 148 1 0
    //   39: ifeq +39 -> 78
    //   42: aload 5
    //   44: invokeinterface 152 1 0
    //   49: checkcast 133	java/lang/String
    //   52: astore 37
    //   54: aload_1
    //   55: aload 37
    //   57: invokevirtual 241	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   60: ifne -28 -> 32
    //   63: aload_1
    //   64: aload 37
    //   66: invokevirtual 138	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: goto -38 -> 32
    //   73: astore_3
    //   74: aload_2
    //   75: monitorexit
    //   76: aload_3
    //   77: athrow
    //   78: aload_2
    //   79: monitorexit
    //   80: getstatic 39	com/xiaomi/network/HostManager:b	Ljava/util/Map;
    //   83: astore 6
    //   85: aload 6
    //   87: monitorenter
    //   88: getstatic 39	com/xiaomi/network/HostManager:b	Ljava/util/Map;
    //   91: invokeinterface 235 1 0
    //   96: invokeinterface 238 1 0
    //   101: astore 8
    //   103: aload 8
    //   105: invokeinterface 148 1 0
    //   110: ifeq +42 -> 152
    //   113: aload 8
    //   115: invokeinterface 152 1 0
    //   120: checkcast 133	java/lang/String
    //   123: astore 35
    //   125: aload_1
    //   126: aload 35
    //   128: invokevirtual 241	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   131: ifne -28 -> 103
    //   134: aload_1
    //   135: aload 35
    //   137: invokevirtual 138	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   140: pop
    //   141: goto -38 -> 103
    //   144: astore 7
    //   146: aload 6
    //   148: monitorexit
    //   149: aload 7
    //   151: athrow
    //   152: aload 6
    //   154: monitorexit
    //   155: aload_1
    //   156: ldc 126
    //   158: invokevirtual 241	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   161: ifne +10 -> 171
    //   164: aload_1
    //   165: ldc 126
    //   167: invokevirtual 138	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: new 101	java/util/ArrayList
    //   174: dup
    //   175: aload_1
    //   176: invokevirtual 245	java/util/ArrayList:size	()I
    //   179: invokespecial 248	java/util/ArrayList:<init>	(I)V
    //   182: astore 9
    //   184: iconst_0
    //   185: istore 10
    //   187: iload 10
    //   189: aload_1
    //   190: invokevirtual 245	java/util/ArrayList:size	()I
    //   193: if_icmpge +16 -> 209
    //   196: aload 9
    //   198: aconst_null
    //   199: invokevirtual 138	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   202: pop
    //   203: iinc 10 1
    //   206: goto -19 -> 187
    //   209: aload_0
    //   210: invokevirtual 250	com/xiaomi/network/HostManager:c	()Z
    //   213: ifeq +431 -> 644
    //   216: ldc 252
    //   218: astore 16
    //   220: aload_0
    //   221: aload_1
    //   222: aload 16
    //   224: invokespecial 254	com/xiaomi/network/HostManager:a	(Ljava/util/ArrayList;Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 17
    //   229: aload 17
    //   231: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne +337 -> 571
    //   237: new 261	org/json/JSONObject
    //   240: dup
    //   241: aload 17
    //   243: invokespecial 262	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   246: astore 18
    //   248: ldc_w 264
    //   251: aload 18
    //   253: ldc_w 266
    //   256: invokevirtual 269	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 273	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   262: ifeq +309 -> 571
    //   265: aload 18
    //   267: ldc_w 275
    //   270: invokevirtual 279	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   273: astore 19
    //   275: aload 19
    //   277: ldc_w 281
    //   280: invokevirtual 269	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   283: astore 20
    //   285: aload 19
    //   287: ldc_w 283
    //   290: invokevirtual 269	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   293: astore 21
    //   295: aload 19
    //   297: ldc_w 285
    //   300: invokevirtual 269	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: astore 22
    //   305: aload 19
    //   307: ldc_w 287
    //   310: invokevirtual 269	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   313: astore 23
    //   315: aload 19
    //   317: ldc_w 289
    //   320: invokevirtual 269	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   323: astore 24
    //   325: aload 19
    //   327: aload 16
    //   329: invokevirtual 279	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   332: astore 25
    //   334: iconst_0
    //   335: istore 26
    //   337: iload 26
    //   339: aload_1
    //   340: invokevirtual 245	java/util/ArrayList:size	()I
    //   343: if_icmpge +228 -> 571
    //   346: aload_1
    //   347: iload 26
    //   349: invokevirtual 293	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   352: checkcast 133	java/lang/String
    //   355: astore 27
    //   357: aload 25
    //   359: aload 27
    //   361: invokevirtual 297	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   364: astore 28
    //   366: new 179	com/xiaomi/network/Fallback
    //   369: dup
    //   370: aload 27
    //   372: invokespecial 298	com/xiaomi/network/Fallback:<init>	(Ljava/lang/String;)V
    //   375: astore 29
    //   377: iconst_0
    //   378: istore 30
    //   380: iload 30
    //   382: aload 28
    //   384: invokevirtual 303	org/json/JSONArray:length	()I
    //   387: if_icmpge +45 -> 432
    //   390: aload 28
    //   392: iload 30
    //   394: invokevirtual 306	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   397: astore 32
    //   399: aload 32
    //   401: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   404: ifne +234 -> 638
    //   407: aload 29
    //   409: new 308	com/xiaomi/network/WeightedHost
    //   412: dup
    //   413: aload 32
    //   415: aload 28
    //   417: invokevirtual 303	org/json/JSONArray:length	()I
    //   420: iload 30
    //   422: isub
    //   423: invokespecial 311	com/xiaomi/network/WeightedHost:<init>	(Ljava/lang/String;I)V
    //   426: invokevirtual 314	com/xiaomi/network/Fallback:a	(Lcom/xiaomi/network/WeightedHost;)V
    //   429: goto +209 -> 638
    //   432: aload 9
    //   434: iload 26
    //   436: aload 29
    //   438: invokevirtual 318	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   441: pop
    //   442: aload 29
    //   444: aload 24
    //   446: putfield 320	com/xiaomi/network/Fallback:g	Ljava/lang/String;
    //   449: aload 29
    //   451: aload 20
    //   453: putfield 322	com/xiaomi/network/Fallback:c	Ljava/lang/String;
    //   456: aload 29
    //   458: aload 22
    //   460: putfield 324	com/xiaomi/network/Fallback:e	Ljava/lang/String;
    //   463: aload 29
    //   465: aload 23
    //   467: putfield 325	com/xiaomi/network/Fallback:f	Ljava/lang/String;
    //   470: aload 29
    //   472: aload 21
    //   474: putfield 327	com/xiaomi/network/Fallback:d	Ljava/lang/String;
    //   477: aload 19
    //   479: ldc_w 329
    //   482: invokevirtual 332	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   485: ifeq +16 -> 501
    //   488: aload 29
    //   490: aload 19
    //   492: ldc_w 329
    //   495: invokevirtual 336	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   498: invokevirtual 339	com/xiaomi/network/Fallback:a	(D)V
    //   501: aload 19
    //   503: ldc_w 341
    //   506: invokevirtual 332	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   509: ifeq +16 -> 525
    //   512: aload 29
    //   514: aload 19
    //   516: ldc_w 341
    //   519: invokevirtual 269	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   522: invokevirtual 343	com/xiaomi/network/Fallback:c	(Ljava/lang/String;)V
    //   525: aload 19
    //   527: ldc_w 345
    //   530: invokevirtual 332	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   533: ifeq +21 -> 554
    //   536: aload 29
    //   538: ldc2_w 346
    //   541: aload 19
    //   543: ldc_w 345
    //   546: invokevirtual 351	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   549: i2l
    //   550: lmul
    //   551: invokevirtual 354	com/xiaomi/network/Fallback:a	(J)V
    //   554: aload_0
    //   555: aload 29
    //   557: invokevirtual 356	com/xiaomi/network/Fallback:d	()Ljava/lang/String;
    //   560: invokevirtual 358	com/xiaomi/network/HostManager:b	(Ljava/lang/String;)V
    //   563: iinc 26 1
    //   566: goto -229 -> 337
    //   569: astore 15
    //   571: iconst_0
    //   572: istore 12
    //   574: iload 12
    //   576: aload_1
    //   577: invokevirtual 245	java/util/ArrayList:size	()I
    //   580: if_icmpge +41 -> 621
    //   583: aload 9
    //   585: iload 12
    //   587: invokevirtual 293	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   590: checkcast 179	com/xiaomi/network/Fallback
    //   593: astore 13
    //   595: aload 13
    //   597: ifnull +18 -> 615
    //   600: aload_0
    //   601: aload_1
    //   602: iload 12
    //   604: invokevirtual 293	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   607: checkcast 133	java/lang/String
    //   610: aload 13
    //   612: invokevirtual 361	com/xiaomi/network/HostManager:a	(Ljava/lang/String;Lcom/xiaomi/network/Fallback;)V
    //   615: iinc 12 1
    //   618: goto -44 -> 574
    //   621: aload_0
    //   622: invokevirtual 363	com/xiaomi/network/HostManager:e	()V
    //   625: aload 9
    //   627: areturn
    //   628: astore 14
    //   630: goto -59 -> 571
    //   633: astore 11
    //   635: goto -64 -> 571
    //   638: iinc 30 1
    //   641: goto -261 -> 380
    //   644: ldc_w 365
    //   647: astore 16
    //   649: goto -429 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	HostManager
    //   0	652	1	paramArrayList	ArrayList<String>
    //   8	71	2	localMap1	Map
    //   73	4	3	localObject1	Object
    //   30	13	5	localIterator1	Iterator
    //   83	70	6	localMap2	Map
    //   144	6	7	localObject2	Object
    //   101	13	8	localIterator2	Iterator
    //   182	444	9	localArrayList	ArrayList
    //   185	19	10	i1	int
    //   633	1	11	localJSONException	org.json.JSONException
    //   572	44	12	i2	int
    //   593	18	13	localFallback1	Fallback
    //   628	1	14	localIOException	java.io.IOException
    //   569	1	15	localException	Exception
    //   218	430	16	str1	String
    //   227	15	17	str2	String
    //   246	20	18	localJSONObject1	org.json.JSONObject
    //   273	269	19	localJSONObject2	org.json.JSONObject
    //   283	169	20	str3	String
    //   293	180	21	str4	String
    //   303	156	22	str5	String
    //   313	153	23	str6	String
    //   323	122	24	str7	String
    //   332	26	25	localJSONObject3	org.json.JSONObject
    //   335	229	26	i3	int
    //   355	16	27	str8	String
    //   364	52	28	localJSONArray	JSONArray
    //   375	181	29	localFallback2	Fallback
    //   378	261	30	i4	int
    //   397	17	32	str9	String
    //   123	13	35	str10	String
    //   52	13	37	str11	String
    // Exception table:
    //   from	to	target	type
    //   11	32	73	finally
    //   32	70	73	finally
    //   74	76	73	finally
    //   78	80	73	finally
    //   88	103	144	finally
    //   103	141	144	finally
    //   146	149	144	finally
    //   152	155	144	finally
    //   209	216	569	java/lang/Exception
    //   220	334	569	java/lang/Exception
    //   337	377	569	java/lang/Exception
    //   380	429	569	java/lang/Exception
    //   432	501	569	java/lang/Exception
    //   501	525	569	java/lang/Exception
    //   525	554	569	java/lang/Exception
    //   554	563	569	java/lang/Exception
    //   209	216	628	java/io/IOException
    //   220	334	628	java/io/IOException
    //   337	377	628	java/io/IOException
    //   380	429	628	java/io/IOException
    //   432	501	628	java/io/IOException
    //   501	525	628	java/io/IOException
    //   525	554	628	java/io/IOException
    //   554	563	628	java/io/IOException
    //   209	216	633	org/json/JSONException
    //   220	334	633	org/json/JSONException
    //   337	377	633	org/json/JSONException
    //   380	429	633	org/json/JSONException
    //   432	501	633	org/json/JSONException
    //   501	525	633	org/json/JSONException
    //   525	554	633	org/json/JSONException
    //   554	563	633	org/json/JSONException
  }
  
  /* Error */
  public static void a(Context paramContext, HostFilter paramHostFilter, HostManager.HttpGet paramHttpGet, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 91	com/xiaomi/network/HostManager:k	Lcom/xiaomi/network/HostManager;
    //   6: ifnonnull +56 -> 62
    //   9: getstatic 367	com/xiaomi/network/HostManager:l	Lcom/xiaomi/network/HostManager$HostManagerFactory;
    //   12: ifnonnull +54 -> 66
    //   15: new 2	com/xiaomi/network/HostManager
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: aload_2
    //   22: aload_3
    //   23: aload 4
    //   25: aload 5
    //   27: invokespecial 369	com/xiaomi/network/HostManager:<init>	(Landroid/content/Context;Lcom/xiaomi/network/HostFilter;Lcom/xiaomi/network/HostManager$HttpGet;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: putstatic 91	com/xiaomi/network/HostManager:k	Lcom/xiaomi/network/HostManager;
    //   33: getstatic 91	com/xiaomi/network/HostManager:k	Lcom/xiaomi/network/HostManager;
    //   36: ifnull +26 -> 62
    //   39: invokestatic 374	com/xiaomi/network/UploadHostStatHelper:a	()Lcom/xiaomi/network/UploadHostStatHelper;
    //   42: ifnonnull +7 -> 49
    //   45: aload_0
    //   46: invokestatic 377	com/xiaomi/network/UploadHostStatHelper:a	(Landroid/content/Context;)V
    //   49: invokestatic 374	com/xiaomi/network/UploadHostStatHelper:a	()Lcom/xiaomi/network/UploadHostStatHelper;
    //   52: new 379	com/xiaomi/network/a
    //   55: dup
    //   56: invokespecial 380	com/xiaomi/network/a:<init>	()V
    //   59: invokevirtual 383	com/xiaomi/network/UploadHostStatHelper:a	(Lcom/xiaomi/network/UploadHostStatHelper$HttpRecordCallback;)V
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: getstatic 367	com/xiaomi/network/HostManager:l	Lcom/xiaomi/network/HostManager$HostManagerFactory;
    //   69: aload_0
    //   70: aload_1
    //   71: aload_2
    //   72: aload_3
    //   73: invokeinterface 388 5 0
    //   78: putstatic 91	com/xiaomi/network/HostManager:k	Lcom/xiaomi/network/HostManager;
    //   81: goto -48 -> 33
    //   84: astore 6
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload 6
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   0	92	1	paramHostFilter	HostFilter
    //   0	92	2	paramHttpGet	HostManager.HttpGet
    //   0	92	3	paramString1	String
    //   0	92	4	paramString2	String
    //   0	92	5	paramString3	String
    //   84	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	33	84	finally
    //   33	49	84	finally
    //   49	62	84	finally
    //   66	81	84	finally
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = (ArrayList)b.get(paramString1);
    localMap = b;
    if (localArrayList1 == null) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(paramString2);
        b.put(paramString1, localArrayList2);
        return;
      }
      finally {}
      if (!localArrayList1.contains(paramString2)) {
        localArrayList1.add(paramString2);
      }
    }
  }
  
  private Fallback c(String paramString)
  {
    synchronized (this.a)
    {
      d();
      Fallbacks localFallbacks = (Fallbacks)this.a.get(paramString);
      if (localFallbacks != null)
      {
        Fallback localFallback = localFallbacks.a();
        if (localFallback != null) {
          return localFallback;
        }
      }
    }
    return null;
  }
  
  private Fallback d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return (Fallback)a(localArrayList).get(0);
  }
  
  private String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "unknown";
    }
    while (!paramString.startsWith("WIFI")) {
      return paramString;
    }
    return "WIFI";
  }
  
  private void f(String paramString)
  {
    synchronized (this.a)
    {
      this.a.clear();
      JSONArray localJSONArray = new JSONArray(paramString);
      for (int i1 = 0; i1 < localJSONArray.length(); i1++)
      {
        Fallbacks localFallbacks = new Fallbacks().a(localJSONArray.getJSONObject(i1));
        this.a.put(localFallbacks.d(), localFallbacks);
      }
      return;
    }
  }
  
  private String j()
  {
    try
    {
      PackageInfo localPackageInfo = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 16384);
      if (localPackageInfo != null)
      {
        String str = localPackageInfo.versionName;
        return str;
      }
    }
    catch (Exception localException) {}
    return "0";
  }
  
  private JSONArray k()
  {
    JSONArray localJSONArray;
    synchronized (this.a)
    {
      localJSONArray = new JSONArray();
      Iterator localIterator = this.a.values().iterator();
      if (localIterator.hasNext()) {
        localJSONArray.put(((Fallbacks)localIterator.next()).e());
      }
    }
    return localJSONArray;
  }
  
  public Fallback a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the host is empty");
    }
    Fallback localFallback1;
    if (!this.d.a(paramString)) {
      localFallback1 = null;
    }
    do
    {
      return localFallback1;
      localFallback1 = c(paramString);
    } while (localFallback1 != null);
    if (System.currentTimeMillis() - this.i > 1000L * (60L * this.g))
    {
      this.i = System.currentTimeMillis();
      Fallback localFallback3 = d(paramString);
      if (localFallback3 != null)
      {
        this.g = 0L;
        return localFallback3;
      }
      if (this.g < 15L) {
        this.g = (1L + this.g);
      }
    }
    ArrayList localArrayList = (ArrayList)b.get(paramString);
    Map localMap = b;
    if (localArrayList != null)
    {
      Fallback localFallback2;
      try
      {
        localFallback2 = new Fallback(paramString);
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext()) {
          localFallback2.b((String)localIterator.next());
        }
      }
      finally {}
      return localFallback2;
    }
    return null;
  }
  
  public void a(String paramString, Fallback paramFallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFallback == null)) {
      throw new IllegalArgumentException("the argument is invalid " + paramString + ", " + paramFallback);
    }
    if (this.d.a(paramString)) {
      synchronized (this.a)
      {
        d();
        if (this.a.containsKey(paramString))
        {
          ((Fallbacks)this.a.get(paramString)).a(paramFallback);
          return;
        }
        Fallbacks localFallbacks = new Fallbacks(paramString);
        localFallbacks.a(paramFallback);
        this.a.put(paramString, localFallbacks);
      }
    }
  }
  
  public String b()
  {
    if (this.c == null) {
      return "unknown";
    }
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)this.c.getSystemService("connectivity");
      if (localConnectivityManager == null) {
        return "unknown";
      }
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1)
      {
        WifiManager localWifiManager = (WifiManager)this.c.getSystemService("wifi");
        if ((localWifiManager != null) && (localWifiManager.getConnectionInfo() != null)) {
          return "WIFI-" + localWifiManager.getConnectionInfo().getSSID();
        }
      }
      else
      {
        String str = localNetworkInfo.getTypeName() + "-" + localNetworkInfo.getSubtypeName();
        return str;
      }
    }
    catch (Exception localException) {}
    return "unknown";
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public boolean c()
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)this.c.getSystemService("connectivity");
      if (localConnectivityManager == null) {
        return false;
      }
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        if (1 == localNetworkInfo.getType()) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  protected boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/xiaomi/network/HostManager:a	Ljava/util/Map;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: getstatic 41	com/xiaomi/network/HostManager:o	Z
    //   10: ifne +237 -> 247
    //   13: iconst_1
    //   14: putstatic 41	com/xiaomi/network/HostManager:o	Z
    //   17: aload_0
    //   18: getfield 45	com/xiaomi/network/HostManager:a	Ljava/util/Map;
    //   21: invokeinterface 412 1 0
    //   26: aconst_null
    //   27: astore_3
    //   28: new 521	java/io/File
    //   31: dup
    //   32: aload_0
    //   33: getfield 69	com/xiaomi/network/HostManager:c	Landroid/content/Context;
    //   36: invokevirtual 525	android/content/Context:getFilesDir	()Ljava/io/File;
    //   39: aload_0
    //   40: invokevirtual 527	com/xiaomi/network/HostManager:f	()Ljava/lang/String;
    //   43: invokespecial 530	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 533	java/io/File:isFile	()Z
    //   53: istore 12
    //   55: aconst_null
    //   56: astore_3
    //   57: iload 12
    //   59: ifeq +131 -> 190
    //   62: new 535	java/io/BufferedReader
    //   65: dup
    //   66: new 537	java/io/InputStreamReader
    //   69: dup
    //   70: new 539	java/io/FileInputStream
    //   73: dup
    //   74: aload 4
    //   76: invokespecial 542	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   79: invokespecial 545	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   82: invokespecial 548	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 6
    //   87: new 207	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   94: astore 13
    //   96: aload 6
    //   98: invokevirtual 551	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore 14
    //   103: aload 14
    //   105: ifnull +35 -> 140
    //   108: aload 13
    //   110: aload 14
    //   112: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: goto -20 -> 96
    //   119: astore 5
    //   121: aload 5
    //   123: invokevirtual 554	java/io/IOException:printStackTrace	()V
    //   126: aload 6
    //   128: ifnull +8 -> 136
    //   131: aload 6
    //   133: invokevirtual 557	java/io/BufferedReader:close	()V
    //   136: aload_1
    //   137: monitorexit
    //   138: iconst_0
    //   139: ireturn
    //   140: aload 13
    //   142: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 16
    //   147: aload 16
    //   149: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +41 -> 193
    //   155: aload_0
    //   156: aload 16
    //   158: invokespecial 559	com/xiaomi/network/HostManager:f	(Ljava/lang/String;)V
    //   161: ldc_w 561
    //   164: ldc_w 563
    //   167: invokestatic 569	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   170: pop
    //   171: aload 6
    //   173: ifnull +8 -> 181
    //   176: aload 6
    //   178: invokevirtual 557	java/io/BufferedReader:close	()V
    //   181: aload_1
    //   182: monitorexit
    //   183: iconst_1
    //   184: ireturn
    //   185: astore_2
    //   186: aload_1
    //   187: monitorexit
    //   188: aload_2
    //   189: athrow
    //   190: aconst_null
    //   191: astore 6
    //   193: aload 6
    //   195: ifnull -59 -> 136
    //   198: aload 6
    //   200: invokevirtual 557	java/io/BufferedReader:close	()V
    //   203: goto -67 -> 136
    //   206: astore 17
    //   208: goto -72 -> 136
    //   211: astore 10
    //   213: aload 10
    //   215: invokevirtual 570	java/lang/Throwable:printStackTrace	()V
    //   218: aload_3
    //   219: ifnull -83 -> 136
    //   222: aload_3
    //   223: invokevirtual 557	java/io/BufferedReader:close	()V
    //   226: goto -90 -> 136
    //   229: astore 11
    //   231: goto -95 -> 136
    //   234: astore 7
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 557	java/io/BufferedReader:close	()V
    //   244: aload 7
    //   246: athrow
    //   247: aload_1
    //   248: monitorexit
    //   249: iconst_1
    //   250: ireturn
    //   251: astore 19
    //   253: goto -72 -> 181
    //   256: astore 9
    //   258: goto -122 -> 136
    //   261: astore 8
    //   263: goto -19 -> 244
    //   266: astore 7
    //   268: aload 6
    //   270: astore_3
    //   271: goto -35 -> 236
    //   274: astore 10
    //   276: aload 6
    //   278: astore_3
    //   279: goto -66 -> 213
    //   282: astore 5
    //   284: aconst_null
    //   285: astore 6
    //   287: goto -166 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	HostManager
    //   4	244	1	localMap	Map
    //   185	4	2	localObject1	Object
    //   27	252	3	localObject2	Object
    //   46	29	4	localFile	java.io.File
    //   119	3	5	localIOException1	java.io.IOException
    //   282	1	5	localIOException2	java.io.IOException
    //   85	201	6	localBufferedReader	java.io.BufferedReader
    //   234	11	7	localObject3	Object
    //   266	1	7	localObject4	Object
    //   261	1	8	localIOException3	java.io.IOException
    //   256	1	9	localIOException4	java.io.IOException
    //   211	3	10	localThrowable1	java.lang.Throwable
    //   274	1	10	localThrowable2	java.lang.Throwable
    //   229	1	11	localIOException5	java.io.IOException
    //   53	5	12	bool	boolean
    //   94	47	13	localStringBuilder	StringBuilder
    //   101	10	14	str1	String
    //   145	12	16	str2	String
    //   206	1	17	localIOException6	java.io.IOException
    //   251	1	19	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   87	96	119	java/io/IOException
    //   96	103	119	java/io/IOException
    //   108	116	119	java/io/IOException
    //   140	171	119	java/io/IOException
    //   7	26	185	finally
    //   131	136	185	finally
    //   136	138	185	finally
    //   176	181	185	finally
    //   181	183	185	finally
    //   186	188	185	finally
    //   198	203	185	finally
    //   222	226	185	finally
    //   240	244	185	finally
    //   244	247	185	finally
    //   247	249	185	finally
    //   198	203	206	java/io/IOException
    //   28	55	211	java/lang/Throwable
    //   62	87	211	java/lang/Throwable
    //   222	226	229	java/io/IOException
    //   28	55	234	finally
    //   62	87	234	finally
    //   213	218	234	finally
    //   176	181	251	java/io/IOException
    //   131	136	256	java/io/IOException
    //   240	244	261	java/io/IOException
    //   87	96	266	finally
    //   96	103	266	finally
    //   108	116	266	finally
    //   121	126	266	finally
    //   140	171	266	finally
    //   87	96	274	java/lang/Throwable
    //   96	103	274	java/lang/Throwable
    //   108	116	274	java/lang/Throwable
    //   140	171	274	java/lang/Throwable
    //   28	55	282	java/io/IOException
    //   62	87	282	java/io/IOException
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 227	com/xiaomi/network/HostManager:h	()V
    //   4: aload_0
    //   5: getfield 45	com/xiaomi/network/HostManager:a	Ljava/util/Map;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: new 572	java/io/BufferedWriter
    //   14: dup
    //   15: new 574	java/io/OutputStreamWriter
    //   18: dup
    //   19: aload_0
    //   20: getfield 69	com/xiaomi/network/HostManager:c	Landroid/content/Context;
    //   23: aload_0
    //   24: invokevirtual 527	com/xiaomi/network/HostManager:f	()Ljava/lang/String;
    //   27: iconst_0
    //   28: invokevirtual 578	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   31: invokespecial 581	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   34: invokespecial 584	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   37: astore_2
    //   38: aload_0
    //   39: invokespecial 586	com/xiaomi/network/HostManager:k	()Lorg/json/JSONArray;
    //   42: invokevirtual 587	org/json/JSONArray:toString	()Ljava/lang/String;
    //   45: astore 7
    //   47: aload 7
    //   49: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +9 -> 61
    //   55: aload_2
    //   56: aload 7
    //   58: invokevirtual 590	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: invokevirtual 591	java/io/BufferedWriter:close	()V
    //   65: aload_1
    //   66: monitorexit
    //   67: return
    //   68: astore 6
    //   70: aload 6
    //   72: invokevirtual 554	java/io/IOException:printStackTrace	()V
    //   75: goto -10 -> 65
    //   78: astore 4
    //   80: aload_1
    //   81: monitorexit
    //   82: aload 4
    //   84: athrow
    //   85: astore 5
    //   87: aload 5
    //   89: invokevirtual 592	org/json/JSONException:printStackTrace	()V
    //   92: goto -27 -> 65
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 593	java/lang/Exception:printStackTrace	()V
    //   100: goto -35 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	HostManager
    //   37	25	2	localBufferedWriter	java.io.BufferedWriter
    //   95	2	3	localException	Exception
    //   78	5	4	localObject	Object
    //   85	3	5	localJSONException	org.json.JSONException
    //   68	3	6	localIOException	java.io.IOException
    //   45	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   11	61	68	java/io/IOException
    //   61	65	68	java/io/IOException
    //   11	61	78	finally
    //   61	65	78	finally
    //   65	67	78	finally
    //   70	75	78	finally
    //   80	82	78	finally
    //   87	92	78	finally
    //   96	100	78	finally
    //   11	61	85	org/json/JSONException
    //   61	65	85	org/json/JSONException
    //   11	61	95	java/lang/Exception
    //   61	65	95	java/lang/Exception
  }
  
  protected String f()
  {
    List localList = ((ActivityManager)this.c.getSystemService("activity")).getRunningAppProcesses();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == Process.myPid()) {
          return localRunningAppProcessInfo.processName;
        }
      }
    }
    return "com.xiaomi";
  }
  
  public ArrayList<com.xiaomi.common.logger.thrift.mfs.b> g()
  {
    for (;;)
    {
      HashMap localHashMap1;
      com.xiaomi.common.logger.thrift.mfs.b localb2;
      com.xiaomi.common.logger.thrift.mfs.b localb4;
      a locala;
      ArrayList localArrayList2;
      int i1;
      int i2;
      int i3;
      int i5;
      int i6;
      int i7;
      int i9;
      synchronized (this.a)
      {
        localHashMap1 = new HashMap();
        Iterator localIterator1 = this.a.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break label644;
        }
        String str1 = (String)localIterator1.next();
        Fallbacks localFallbacks = (Fallbacks)this.a.get(str1);
        if (localFallbacks == null) {
          continue;
        }
        Iterator localIterator3 = localFallbacks.b().iterator();
        if (!localIterator3.hasNext()) {
          continue;
        }
        Fallback localFallback = (Fallback)localIterator3.next();
        localb2 = (com.xiaomi.common.logger.thrift.mfs.b)localHashMap1.get(localFallback.d());
        if (localb2 != null) {
          break label712;
        }
        com.xiaomi.common.logger.thrift.mfs.b localb3 = new com.xiaomi.common.logger.thrift.mfs.b();
        localb3.a("httpapi");
        localb3.e(localFallback.f);
        localb3.d(e(localFallback.a));
        localb3.b(this.f);
        localb3.c(n);
        localb3.f(m);
        localb3.g(this.c.getPackageName());
        localb3.h(j());
        e locale = new e();
        locale.c(localFallback.d);
        locale.a(localFallback.g);
        locale.b(localFallback.c);
        locale.d(localFallback.e);
        localb3.a(locale);
        localHashMap1.put(localFallback.d(), localb3);
        localb4 = localb3;
        locala = new a();
        locala.a(localFallback.b);
        localArrayList2 = new ArrayList();
        Iterator localIterator4 = localFallback.e().iterator();
        if (localIterator4.hasNext())
        {
          WeightedHost localWeightedHost = (WeightedHost)localIterator4.next();
          ArrayList localArrayList3 = localWeightedHost.a();
          if (localArrayList3.isEmpty()) {
            continue;
          }
          d locald = new d();
          locald.a(localWeightedHost.a);
          i1 = 0;
          i2 = 0;
          long l1 = 0L;
          i3 = 0;
          HashMap localHashMap2 = new HashMap();
          Iterator localIterator5 = localArrayList3.iterator();
          if (localIterator5.hasNext())
          {
            AccessHistory localAccessHistory = (AccessHistory)localIterator5.next();
            if (localAccessHistory.a() >= 0)
            {
              int i4 = i1 + 1;
              l1 += localAccessHistory.b();
              i5 = (int)(i3 + localAccessHistory.d());
              i6 = i2;
              i7 = i4;
              break label719;
            }
            String str2 = localAccessHistory.e();
            if (TextUtils.isEmpty(str2)) {
              break label734;
            }
            if (!localHashMap2.containsKey(str2)) {
              break label755;
            }
            i9 = 1 + ((Integer)localHashMap2.get(str2)).intValue();
            localHashMap2.put(str2, Integer.valueOf(i9));
            break label734;
          }
          locald.a(localHashMap2);
          locald.b(i1);
          locald.a(i2);
          locald.a(l1);
          locald.c(i3);
          localArrayList2.add(locald);
        }
      }
      if (!localArrayList2.isEmpty())
      {
        locala.a(localArrayList2);
        localb4.a(locala);
        continue;
        label644:
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator2 = localHashMap1.values().iterator();
        while (localIterator2.hasNext())
        {
          com.xiaomi.common.logger.thrift.mfs.b localb1 = (com.xiaomi.common.logger.thrift.mfs.b)localIterator2.next();
          if (localb1.g() > 0) {
            localArrayList1.add(localb1);
          }
        }
        return localArrayList1;
        label712:
        localb4 = localb2;
        continue;
        for (;;)
        {
          label719:
          i1 = i7;
          i2 = i6;
          i3 = i5;
          break;
          label734:
          int i8 = i2 + 1;
          i7 = i1;
          i5 = i3;
          i6 = i8;
        }
        label755:
        i9 = 1;
      }
    }
  }
  
  public void h()
  {
    synchronized (this.a)
    {
      Iterator localIterator1 = this.a.values().iterator();
      if (localIterator1.hasNext()) {
        ((Fallbacks)localIterator1.next()).c();
      }
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 == 0)
      {
        Iterator localIterator2 = this.a.keySet().iterator();
        String str;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          str = (String)localIterator2.next();
        } while (!((Fallbacks)this.a.get(str)).b().isEmpty());
        this.a.remove(str);
        i1 = 0;
      }
      else
      {
        return;
        i1 = 1;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.HostManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */