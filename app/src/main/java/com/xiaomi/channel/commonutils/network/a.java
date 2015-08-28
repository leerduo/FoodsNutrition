package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;

public class a
{
  public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
  public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  
  public static int a(Context paramContext)
  {
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null) {
        return -1;
      }
    }
    catch (Exception localException1)
    {
      return -1;
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return -1;
      }
    }
    catch (Exception localException2)
    {
      return -1;
    }
    return localNetworkInfo.getType();
  }
  
  public static String a(Context paramContext, String paramString, List<NameValuePair> paramList)
  {
    return a(paramContext, paramString, paramList, null, null, null);
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, List<NameValuePair> paramList, a.b paramb, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +13 -> 20
    //   10: new 70	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc 72
    //   16: invokespecial 76	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: aload_0
    //   21: aload_1
    //   22: invokestatic 79	com/xiaomi/channel/commonutils/network/a:a	(Ljava/lang/String;)Ljava/net/URL;
    //   25: invokestatic 82	com/xiaomi/channel/commonutils/network/a:a	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   28: astore 13
    //   30: aload 13
    //   32: sipush 10000
    //   35: invokevirtual 88	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   38: aload 13
    //   40: sipush 15000
    //   43: invokevirtual 91	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   46: aload 13
    //   48: ldc 93
    //   50: invokevirtual 96	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   53: aload 4
    //   55: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +12 -> 70
    //   61: aload 13
    //   63: ldc 98
    //   65: aload 4
    //   67: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload 5
    //   72: ifnull +12 -> 84
    //   75: aload 13
    //   77: ldc 104
    //   79: aload 5
    //   81: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: invokestatic 107	com/xiaomi/channel/commonutils/network/a:a	(Ljava/util/List;)Ljava/lang/String;
    //   88: astore 14
    //   90: aload 14
    //   92: ifnonnull +46 -> 138
    //   95: new 70	java/lang/IllegalArgumentException
    //   98: dup
    //   99: ldc 109
    //   101: invokespecial 76	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: astore 12
    //   107: aconst_null
    //   108: astore 8
    //   110: aload 12
    //   112: athrow
    //   113: astore 7
    //   115: aload 8
    //   117: ifnull +8 -> 125
    //   120: aload 8
    //   122: invokevirtual 114	java/io/OutputStream:close	()V
    //   125: aload 6
    //   127: ifnull +8 -> 135
    //   130: aload 6
    //   132: invokevirtual 117	java/io/BufferedReader:close	()V
    //   135: aload 7
    //   137: athrow
    //   138: aload 13
    //   140: iconst_1
    //   141: invokevirtual 121	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   144: aload 14
    //   146: invokevirtual 127	java/lang/String:getBytes	()[B
    //   149: astore 15
    //   151: aload 13
    //   153: invokevirtual 131	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   156: astore 16
    //   158: aload 16
    //   160: astore 8
    //   162: aload 8
    //   164: aload 15
    //   166: iconst_0
    //   167: aload 15
    //   169: arraylength
    //   170: invokevirtual 135	java/io/OutputStream:write	([BII)V
    //   173: aload 8
    //   175: invokevirtual 138	java/io/OutputStream:flush	()V
    //   178: aload 8
    //   180: invokevirtual 114	java/io/OutputStream:close	()V
    //   183: aload 13
    //   185: invokevirtual 141	java/net/HttpURLConnection:getResponseCode	()I
    //   188: istore 17
    //   190: ldc 143
    //   192: new 145	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   199: ldc 149
    //   201: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 17
    //   206: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 166	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   215: pop
    //   216: aload_3
    //   217: ifnull +62 -> 279
    //   220: aload_3
    //   221: iload 17
    //   223: putfield 171	com/xiaomi/channel/commonutils/network/a$b:a	I
    //   226: aload_3
    //   227: getfield 174	com/xiaomi/channel/commonutils/network/a$b:b	Ljava/util/Map;
    //   230: astore 19
    //   232: iconst_0
    //   233: istore 20
    //   235: aload 19
    //   237: ifnonnull +14 -> 251
    //   240: aload_3
    //   241: new 176	java/util/HashMap
    //   244: dup
    //   245: invokespecial 177	java/util/HashMap:<init>	()V
    //   248: putfield 174	com/xiaomi/channel/commonutils/network/a$b:b	Ljava/util/Map;
    //   251: aload 13
    //   253: iload 20
    //   255: invokevirtual 181	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   258: astore 21
    //   260: aload 13
    //   262: iload 20
    //   264: invokevirtual 184	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   267: astore 22
    //   269: aload 21
    //   271: ifnonnull +94 -> 365
    //   274: aload 22
    //   276: ifnonnull +89 -> 365
    //   279: new 116	java/io/BufferedReader
    //   282: dup
    //   283: new 186	java/io/InputStreamReader
    //   286: dup
    //   287: new 188	com/xiaomi/channel/commonutils/network/a$a
    //   290: dup
    //   291: aload 13
    //   293: invokevirtual 192	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   296: invokespecial 195	com/xiaomi/channel/commonutils/network/a$a:<init>	(Ljava/io/InputStream;)V
    //   299: invokespecial 196	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   302: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   305: astore 24
    //   307: aload 24
    //   309: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   312: astore 25
    //   314: new 204	java/lang/StringBuffer
    //   317: dup
    //   318: invokespecial 205	java/lang/StringBuffer:<init>	()V
    //   321: astore 26
    //   323: ldc 207
    //   325: invokestatic 213	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore 27
    //   330: aload 25
    //   332: ifnull +58 -> 390
    //   335: aload 26
    //   337: aload 25
    //   339: invokevirtual 216	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   342: pop
    //   343: aload 26
    //   345: aload 27
    //   347: invokevirtual 216	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   350: pop
    //   351: aload 24
    //   353: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   356: astore 30
    //   358: aload 30
    //   360: astore 25
    //   362: goto -32 -> 330
    //   365: aload_3
    //   366: getfield 174	com/xiaomi/channel/commonutils/network/a$b:b	Ljava/util/Map;
    //   369: aload 21
    //   371: aload 22
    //   373: invokeinterface 222 3 0
    //   378: pop
    //   379: iconst_1
    //   380: iload 20
    //   382: iconst_1
    //   383: iadd
    //   384: iadd
    //   385: istore 20
    //   387: goto -136 -> 251
    //   390: aload 26
    //   392: invokevirtual 223	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   395: astore 31
    //   397: aload 24
    //   399: invokevirtual 117	java/io/BufferedReader:close	()V
    //   402: iconst_0
    //   403: ifeq +7 -> 410
    //   406: aconst_null
    //   407: invokevirtual 114	java/io/OutputStream:close	()V
    //   410: iconst_0
    //   411: ifeq +7 -> 418
    //   414: aconst_null
    //   415: invokevirtual 117	java/io/BufferedReader:close	()V
    //   418: aload 31
    //   420: areturn
    //   421: astore 32
    //   423: ldc 143
    //   425: ldc 225
    //   427: aload 32
    //   429: invokestatic 229	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   432: pop
    //   433: aload 31
    //   435: areturn
    //   436: astore 11
    //   438: aconst_null
    //   439: astore 8
    //   441: new 60	java/io/IOException
    //   444: dup
    //   445: aload 11
    //   447: invokespecial 232	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   450: athrow
    //   451: astore 9
    //   453: ldc 143
    //   455: ldc 225
    //   457: aload 9
    //   459: invokestatic 229	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   462: pop
    //   463: goto -328 -> 135
    //   466: astore 7
    //   468: aconst_null
    //   469: astore 6
    //   471: aconst_null
    //   472: astore 8
    //   474: goto -359 -> 115
    //   477: astore 7
    //   479: aload 24
    //   481: astore 6
    //   483: aconst_null
    //   484: astore 8
    //   486: goto -371 -> 115
    //   489: astore 11
    //   491: aconst_null
    //   492: astore 6
    //   494: goto -53 -> 441
    //   497: astore 11
    //   499: aload 24
    //   501: astore 6
    //   503: aconst_null
    //   504: astore 8
    //   506: goto -65 -> 441
    //   509: astore 12
    //   511: aconst_null
    //   512: astore 6
    //   514: goto -404 -> 110
    //   517: astore 12
    //   519: aload 24
    //   521: astore 6
    //   523: aconst_null
    //   524: astore 8
    //   526: goto -416 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	paramContext	Context
    //   0	529	1	paramString1	String
    //   0	529	2	paramList	List<NameValuePair>
    //   0	529	3	paramb	a.b
    //   0	529	4	paramString2	String
    //   0	529	5	paramString3	String
    //   1	521	6	localObject1	Object
    //   113	23	7	localObject2	Object
    //   466	1	7	localObject3	Object
    //   477	1	7	localObject4	Object
    //   108	417	8	localObject5	Object
    //   451	7	9	localIOException1	java.io.IOException
    //   436	10	11	localThrowable1	java.lang.Throwable
    //   489	1	11	localThrowable2	java.lang.Throwable
    //   497	1	11	localThrowable3	java.lang.Throwable
    //   105	6	12	localIOException2	java.io.IOException
    //   509	1	12	localIOException3	java.io.IOException
    //   517	1	12	localIOException4	java.io.IOException
    //   28	264	13	localHttpURLConnection	HttpURLConnection
    //   88	57	14	str1	String
    //   149	19	15	arrayOfByte	byte[]
    //   156	3	16	localOutputStream	java.io.OutputStream
    //   188	34	17	i	int
    //   230	6	19	localMap	java.util.Map
    //   233	153	20	j	int
    //   258	112	21	str2	String
    //   267	105	22	str3	String
    //   305	215	24	localBufferedReader	java.io.BufferedReader
    //   312	49	25	localObject6	Object
    //   321	70	26	localStringBuffer	StringBuffer
    //   328	18	27	str4	String
    //   356	3	30	str5	String
    //   395	39	31	str6	String
    //   421	7	32	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   20	70	105	java/io/IOException
    //   75	84	105	java/io/IOException
    //   84	90	105	java/io/IOException
    //   95	105	105	java/io/IOException
    //   138	158	105	java/io/IOException
    //   183	216	105	java/io/IOException
    //   220	232	105	java/io/IOException
    //   240	251	105	java/io/IOException
    //   251	269	105	java/io/IOException
    //   279	307	105	java/io/IOException
    //   365	379	105	java/io/IOException
    //   110	113	113	finally
    //   162	183	113	finally
    //   441	451	113	finally
    //   406	410	421	java/io/IOException
    //   414	418	421	java/io/IOException
    //   20	70	436	java/lang/Throwable
    //   75	84	436	java/lang/Throwable
    //   84	90	436	java/lang/Throwable
    //   95	105	436	java/lang/Throwable
    //   138	158	436	java/lang/Throwable
    //   183	216	436	java/lang/Throwable
    //   220	232	436	java/lang/Throwable
    //   240	251	436	java/lang/Throwable
    //   251	269	436	java/lang/Throwable
    //   279	307	436	java/lang/Throwable
    //   365	379	436	java/lang/Throwable
    //   120	125	451	java/io/IOException
    //   130	135	451	java/io/IOException
    //   20	70	466	finally
    //   75	84	466	finally
    //   84	90	466	finally
    //   95	105	466	finally
    //   138	158	466	finally
    //   183	216	466	finally
    //   220	232	466	finally
    //   240	251	466	finally
    //   251	269	466	finally
    //   279	307	466	finally
    //   365	379	466	finally
    //   307	330	477	finally
    //   335	358	477	finally
    //   390	402	477	finally
    //   162	183	489	java/lang/Throwable
    //   307	330	497	java/lang/Throwable
    //   335	358	497	java/lang/Throwable
    //   390	402	497	java/lang/Throwable
    //   162	183	509	java/io/IOException
    //   307	330	517	java/io/IOException
    //   335	358	517	java/io/IOException
    //   390	402	517	java/io/IOException
  }
  
  public static String a(URL paramURL)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramURL.getProtocol()).append("://").append("10.0.0.172").append(paramURL.getPath());
    if (!TextUtils.isEmpty(paramURL.getQuery())) {
      localStringBuilder.append("?").append(paramURL.getQuery());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(List<NameValuePair> paramList)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
      try
      {
        if (localNameValuePair.getValue() != null)
        {
          localStringBuffer1.append(URLEncoder.encode(localNameValuePair.getName(), "UTF-8"));
          localStringBuffer1.append("=");
          localStringBuffer1.append(URLEncoder.encode(localNameValuePair.getValue(), "UTF-8"));
          localStringBuffer1.append("&");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.d("com.xiaomi.common.Network", "Failed to convert from param list to string: " + localUnsupportedEncodingException.toString());
        Log.d("com.xiaomi.common.Network", "pair: " + localNameValuePair.toString());
        return null;
      }
    }
    if (localStringBuffer1.length() > 0) {}
    for (StringBuffer localStringBuffer2 = localStringBuffer1.deleteCharAt(-1 + localStringBuffer1.length());; localStringBuffer2 = localStringBuffer1) {
      return localStringBuffer2.toString();
    }
  }
  
  public static HttpURLConnection a(Context paramContext, URL paramURL)
  {
    if (c(paramContext)) {
      return (HttpURLConnection)paramURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
    }
    if (!b(paramContext)) {
      return (HttpURLConnection)paramURL.openConnection();
    }
    String str = paramURL.getHost();
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(a(paramURL)).openConnection();
    localHttpURLConnection.addRequestProperty("X-Online-Host", str);
    return localHttpURLConnection;
  }
  
  private static URL a(String paramString)
  {
    return new URL(paramString);
  }
  
  public static boolean b(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso())) {}
    for (;;)
    {
      return false;
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localConnectivityManager == null) {
          continue;
        }
        try
        {
          NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
          if (localNetworkInfo == null) {
            continue;
          }
          String str = localNetworkInfo.getExtraInfo();
          if ((TextUtils.isEmpty(str)) || (str.length() < 3) || (str.contains("ctwap"))) {
            continue;
          }
          return str.regionMatches(true, -3 + str.length(), "wap", 0, 3);
        }
        catch (Exception localException2)
        {
          return false;
        }
        return false;
      }
      catch (Exception localException1) {}
    }
  }
  
  public static boolean c(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso())) {
      return false;
    }
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null) {
        return false;
      }
    }
    catch (Exception localException1)
    {
      return false;
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
    }
    catch (Exception localException2)
    {
      return false;
    }
    String str = localNetworkInfo.getExtraInfo();
    if ((TextUtils.isEmpty(str)) || (str.length() < 3)) {
      return false;
    }
    return str.contains("ctwap");
  }
  
  public static boolean d(Context paramContext)
  {
    return a(paramContext) >= 0;
  }
  
  /* Error */
  public static boolean e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 36
    //   3: invokevirtual 42	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 44	android/net/ConnectivityManager
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokevirtual 48	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull -10 -> 14
    //   27: iconst_1
    //   28: aload 4
    //   30: invokevirtual 54	android/net/NetworkInfo:getType	()I
    //   33: if_icmpne +9 -> 42
    //   36: iconst_1
    //   37: istore 5
    //   39: iload 5
    //   41: ireturn
    //   42: iconst_0
    //   43: istore 5
    //   45: goto -6 -> 39
    //   48: astore_3
    //   49: iconst_0
    //   50: ireturn
    //   51: astore_1
    //   52: iconst_0
    //   53: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    //   51	1	1	localException1	Exception
    //   9	8	2	localConnectivityManager	ConnectivityManager
    //   48	1	3	localException2	Exception
    //   20	9	4	localNetworkInfo	NetworkInfo
    //   37	7	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   16	22	48	java/lang/Exception
    //   0	10	51	java/lang/Exception
  }
  
  public static String f(Context paramContext)
  {
    if (e(paramContext)) {
      return "wifi";
    }
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null) {
        return "";
      }
    }
    catch (Exception localException1)
    {
      return "";
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "";
      }
    }
    catch (Exception localException2)
    {
      return "";
    }
    return (localNetworkInfo.getTypeName() + "-" + localNetworkInfo.getSubtypeName() + "-" + localNetworkInfo.getExtraInfo()).toLowerCase();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.network.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */