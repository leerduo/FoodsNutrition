package com.xiaomi.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;

public class Network
{
  public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
  public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  
  public static InputStream a(Context paramContext, URL paramURL, String paramString1, String paramString2)
  {
    return a(paramContext, paramURL, paramString1, paramString2, null, null);
  }
  
  public static InputStream a(Context paramContext, URL paramURL, String paramString1, String paramString2, Map<String, String> paramMap, Network.HttpHeaderInfo paramHttpHeaderInfo)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context");
    }
    if (paramURL == null) {
      throw new IllegalArgumentException("url");
    }
    for (;;)
    {
      int i;
      try
      {
        HttpURLConnection.setFollowRedirects(true);
        HttpURLConnection localHttpURLConnection = b(paramContext, paramURL);
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setReadTimeout(15000);
        if (!TextUtils.isEmpty(paramString1)) {
          localHttpURLConnection.setRequestProperty("User-Agent", paramString1);
        }
        if (paramString2 != null) {
          localHttpURLConnection.setRequestProperty("Cookie", paramString2);
        }
        if (paramMap != null)
        {
          Iterator localIterator = paramMap.keySet().iterator();
          if (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            localHttpURLConnection.setRequestProperty(str3, (String)paramMap.get(str3));
            continue;
          }
        }
        String str1;
        String str2;
        i = 0;
      }
      catch (IOException localIOException)
      {
        throw localIOException;
        if ((paramHttpHeaderInfo != null) && ((paramURL.getProtocol().equals("http")) || (paramURL.getProtocol().equals("https"))))
        {
          paramHttpHeaderInfo.a = localHttpURLConnection.getResponseCode();
          if (paramHttpHeaderInfo.b != null) {
            break label305;
          }
          paramHttpHeaderInfo.b = new HashMap();
          break label305;
          str1 = localHttpURLConnection.getHeaderFieldKey(i);
          str2 = localHttpURLConnection.getHeaderField(i);
          if ((str1 != null) || (str2 != null)) {}
        }
        else
        {
          return new Network.DoneHandlerInputStream(localHttpURLConnection.getInputStream());
        }
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
          break label311;
        }
        paramHttpHeaderInfo.b.put(str1.toLowerCase(), str2);
      }
      catch (Throwable localThrowable)
      {
        throw new IOException(localThrowable);
      }
      label305:
      continue;
      label311:
      i++;
    }
  }
  
  public static String a(Context paramContext, String paramString, List<NameValuePair> paramList)
  {
    return a(paramContext, paramString, paramList, null, null, null);
  }
  
  public static String a(Context paramContext, String paramString1, List<NameValuePair> paramList, Map<String, String> paramMap, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("url");
    }
    String str4;
    try
    {
      localHttpURLConnection = b(paramContext, new URL(paramString1));
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(15000);
      localHttpURLConnection.setRequestMethod("POST");
      if (!TextUtils.isEmpty(paramString2)) {
        localHttpURLConnection.setRequestProperty("User-Agent", paramString2);
      }
      if (paramString3 != null) {
        localHttpURLConnection.setRequestProperty("Cookie", paramString3);
      }
      str1 = a(paramList);
      if (str1 == null) {
        throw new IllegalArgumentException("nameValuePairs");
      }
    }
    catch (IOException localIOException)
    {
      HttpURLConnection localHttpURLConnection;
      String str1;
      throw localIOException;
      localHttpURLConnection.setDoOutput(true);
      byte[] arrayOfByte = str1.getBytes();
      localHttpURLConnection.getOutputStream().write(arrayOfByte, 0, arrayOfByte.length);
      localHttpURLConnection.getOutputStream().flush();
      localHttpURLConnection.getOutputStream().close();
      int i = localHttpURLConnection.getResponseCode();
      Log.d("com.xiaomi.common.Network", "Http POST Response Code: " + i);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new Network.DoneHandlerInputStream(localHttpURLConnection.getInputStream())));
      String str2 = localBufferedReader.readLine();
      StringBuffer localStringBuffer = new StringBuffer();
      String str3 = System.getProperty("line.separator");
      while (str2 != null)
      {
        localStringBuffer.append(str2);
        localStringBuffer.append(str3);
        str2 = localBufferedReader.readLine();
      }
      str4 = localStringBuffer.toString();
      localBufferedReader.close();
      int j = 0;
      if (paramMap != null) {
        for (;;)
        {
          String str5 = localHttpURLConnection.getHeaderFieldKey(j);
          String str6 = localHttpURLConnection.getHeaderField(j);
          if ((str5 == null) && (str6 == null)) {
            return str4;
          }
          paramMap.put(str5, str6);
          j = 1 + (j + 1);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      throw new IOException(localThrowable);
    }
    return str4;
  }
  
  public static String a(Context paramContext, URL paramURL)
  {
    return a(paramContext, paramURL, null, "UTF-8", (String)null);
  }
  
  /* Error */
  public static String a(Context paramContext, URL paramURL, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 205	java/lang/StringBuilder
    //   6: dup
    //   7: sipush 1024
    //   10: invokespecial 259	java/lang/StringBuilder:<init>	(I)V
    //   13: astore 6
    //   15: aload_0
    //   16: aload_1
    //   17: aload_2
    //   18: aload 4
    //   20: invokestatic 261	com/xiaomi/network/Network:a	(Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore 5
    //   25: new 226	java/io/BufferedReader
    //   28: dup
    //   29: new 228	java/io/InputStreamReader
    //   32: dup
    //   33: aload 5
    //   35: aload_3
    //   36: invokespecial 264	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   39: sipush 1024
    //   42: invokespecial 267	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   45: astore 12
    //   47: aload 12
    //   49: invokevirtual 235	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 13
    //   54: aload 13
    //   56: ifnull +43 -> 99
    //   59: aload 6
    //   61: aload 13
    //   63: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 6
    //   69: ldc_w 269
    //   72: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -29 -> 47
    //   79: astore 11
    //   81: aload 11
    //   83: athrow
    //   84: astore 8
    //   86: aload 5
    //   88: ifnull +8 -> 96
    //   91: aload 5
    //   93: invokevirtual 272	java/io/InputStream:close	()V
    //   96: aload 8
    //   98: athrow
    //   99: aload 5
    //   101: ifnull +8 -> 109
    //   104: aload 5
    //   106: invokevirtual 272	java/io/InputStream:close	()V
    //   109: aload 6
    //   111: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: areturn
    //   115: astore 16
    //   117: ldc 203
    //   119: new 205	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 274
    //   129: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 16
    //   134: invokevirtual 275	java/io/IOException:toString	()Ljava/lang/String;
    //   137: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 278	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   146: pop
    //   147: goto -38 -> 109
    //   150: astore 7
    //   152: new 37	java/io/IOException
    //   155: dup
    //   156: aload 7
    //   158: invokespecial 163	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   161: athrow
    //   162: astore 9
    //   164: ldc 203
    //   166: new 205	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 274
    //   176: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 9
    //   181: invokevirtual 275	java/io/IOException:toString	()Ljava/lang/String;
    //   184: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 278	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   193: pop
    //   194: goto -98 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramURL	URL
    //   0	197	2	paramString1	String
    //   0	197	3	paramString2	String
    //   0	197	4	paramString3	String
    //   1	104	5	localInputStream	InputStream
    //   13	97	6	localStringBuilder	StringBuilder
    //   150	7	7	localThrowable	Throwable
    //   84	13	8	localObject	Object
    //   162	18	9	localIOException1	IOException
    //   79	3	11	localIOException2	IOException
    //   45	3	12	localBufferedReader	BufferedReader
    //   52	10	13	str	String
    //   115	18	16	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   3	47	79	java/io/IOException
    //   47	54	79	java/io/IOException
    //   59	76	79	java/io/IOException
    //   3	47	84	finally
    //   47	54	84	finally
    //   59	76	84	finally
    //   81	84	84	finally
    //   152	162	84	finally
    //   104	109	115	java/io/IOException
    //   3	47	150	java/lang/Throwable
    //   47	54	150	java/lang/Throwable
    //   59	76	150	java/lang/Throwable
    //   91	96	162	java/io/IOException
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
  
  public static boolean a(Context paramContext)
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
  
  public static HttpURLConnection b(Context paramContext, URL paramURL)
  {
    if (b(paramContext)) {
      return (HttpURLConnection)paramURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
    }
    if (!a(paramContext)) {
      return (HttpURLConnection)paramURL.openConnection();
    }
    String str = paramURL.getHost();
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(a(paramURL)).openConnection();
    localHttpURLConnection.addRequestProperty("X-Online-Host", str);
    return localHttpURLConnection;
  }
  
  public static boolean b(Context paramContext)
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
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.Network
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */