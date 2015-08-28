package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork
  implements Network
{
  protected static final boolean a = VolleyLog.b;
  private static int d = 3000;
  private static int e = 4096;
  protected final HttpStack b;
  protected final ByteArrayPool c;
  
  public BasicNetwork(HttpStack paramHttpStack)
  {
    this(paramHttpStack, new ByteArrayPool(e));
  }
  
  public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool)
  {
    this.b = paramHttpStack;
    this.c = paramByteArrayPool;
  }
  
  protected static Map<String, String> a(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < paramArrayOfHeader.length; i++) {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
    }
    return localTreeMap;
  }
  
  private void a(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    Object[] arrayOfObject;
    if ((a) || (paramLong > d))
    {
      arrayOfObject = new Object[5];
      arrayOfObject[0] = paramRequest;
      arrayOfObject[1] = Long.valueOf(paramLong);
      if (paramArrayOfByte == null) {
        break label91;
      }
    }
    label91:
    for (Object localObject = Integer.valueOf(paramArrayOfByte.length);; localObject = "null")
    {
      arrayOfObject[2] = localObject;
      arrayOfObject[3] = Integer.valueOf(paramStatusLine.getStatusCode());
      arrayOfObject[4] = Integer.valueOf(paramRequest.v().b());
      VolleyLog.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", arrayOfObject);
      return;
    }
  }
  
  private static void a(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
  {
    RetryPolicy localRetryPolicy = paramRequest.v();
    int i = paramRequest.u();
    try
    {
      localRetryPolicy.a(paramVolleyError);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(i);
      paramRequest.a(String.format("%s-retry [timeout=%s]", arrayOfObject2));
      return;
    }
    catch (VolleyError localVolleyError)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(i);
      paramRequest.a(String.format("%s-timeout-giveup [timeout=%s]", arrayOfObject1));
      throw localVolleyError;
    }
  }
  
  private void a(Map<String, String> paramMap, Cache.Entry paramEntry)
  {
    if (paramEntry == null) {}
    do
    {
      return;
      if (paramEntry.b != null) {
        paramMap.put("If-None-Match", paramEntry.b);
      }
    } while (paramEntry.c <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramEntry.c)));
  }
  
  private byte[] a(HttpEntity paramHttpEntity)
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.c, (int)paramHttpEntity.getContentLength());
    byte[] arrayOfByte1 = null;
    InputStream localInputStream;
    try
    {
      localInputStream = paramHttpEntity.getContent();
      arrayOfByte1 = null;
      if (localInputStream == null) {
        throw new ServerError();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.c.a(arrayOfByte1);
      localPoolingByteArrayOutputStream.close();
      throw localObject;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte2;
        VolleyLog.a("Error occured when calling consumingContent", new Object[0]);
      }
    }
    arrayOfByte1 = this.c.a(1024);
    for (;;)
    {
      int i = localInputStream.read(arrayOfByte1);
      if (i == -1) {
        break;
      }
      localPoolingByteArrayOutputStream.write(arrayOfByte1, 0, i);
    }
    arrayOfByte2 = localPoolingByteArrayOutputStream.toByteArray();
    try
    {
      paramHttpEntity.consumeContent();
      this.c.a(arrayOfByte1);
      localPoolingByteArrayOutputStream.close();
      return arrayOfByte2;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        VolleyLog.a("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  /* Error */
  public com.android.volley.NetworkResponse a(Request<?> paramRequest)
  {
    // Byte code:
    //   0: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: invokestatic 218	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 5
    //   12: new 220	java/util/HashMap
    //   15: dup
    //   16: invokespecial 221	java/util/HashMap:<init>	()V
    //   19: astore 6
    //   21: aload_0
    //   22: aload 6
    //   24: aload_1
    //   25: invokevirtual 225	com/android/volley/Request:g	()Lcom/android/volley/Cache$Entry;
    //   28: invokespecial 227	com/android/volley/toolbox/BasicNetwork:a	(Ljava/util/Map;Lcom/android/volley/Cache$Entry;)V
    //   31: aload_0
    //   32: getfield 41	com/android/volley/toolbox/BasicNetwork:b	Lcom/android/volley/toolbox/HttpStack;
    //   35: aload_1
    //   36: aload 6
    //   38: invokeinterface 232 3 0
    //   43: astore 16
    //   45: aload 16
    //   47: invokeinterface 238 1 0
    //   52: astore 17
    //   54: aload 17
    //   56: invokeinterface 88 1 0
    //   61: istore 18
    //   63: aload 16
    //   65: invokeinterface 242 1 0
    //   70: invokestatic 244	com/android/volley/toolbox/BasicNetwork:a	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   73: astore 5
    //   75: iload 18
    //   77: sipush 304
    //   80: if_icmpne +518 -> 598
    //   83: aload_1
    //   84: invokevirtual 225	com/android/volley/Request:g	()Lcom/android/volley/Cache$Entry;
    //   87: astore 19
    //   89: aload 19
    //   91: ifnonnull +23 -> 114
    //   94: new 246	com/android/volley/NetworkResponse
    //   97: dup
    //   98: sipush 304
    //   101: aconst_null
    //   102: aload 5
    //   104: iconst_1
    //   105: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   108: lload_2
    //   109: lsub
    //   110: invokespecial 249	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   113: areturn
    //   114: aload 19
    //   116: getfield 253	com/android/volley/Cache$Entry:f	Ljava/util/Map;
    //   119: aload 5
    //   121: invokeinterface 257 2 0
    //   126: new 246	com/android/volley/NetworkResponse
    //   129: dup
    //   130: sipush 304
    //   133: aload 19
    //   135: getfield 260	com/android/volley/Cache$Entry:a	[B
    //   138: aload 19
    //   140: getfield 253	com/android/volley/Cache$Entry:f	Ljava/util/Map;
    //   143: iconst_1
    //   144: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   147: lload_2
    //   148: lsub
    //   149: invokespecial 249	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   152: areturn
    //   153: aload_1
    //   154: aload 5
    //   156: ldc_w 262
    //   159: invokeinterface 266 2 0
    //   164: checkcast 48	java/lang/String
    //   167: invokevirtual 268	com/android/volley/Request:c	(Ljava/lang/String;)V
    //   170: aload 16
    //   172: invokeinterface 272 1 0
    //   177: ifnull +77 -> 254
    //   180: aload_0
    //   181: aload 16
    //   183: invokeinterface 272 1 0
    //   188: invokespecial 274	com/android/volley/toolbox/BasicNetwork:a	(Lorg/apache/http/HttpEntity;)[B
    //   191: astore 24
    //   193: aload 24
    //   195: astore 20
    //   197: aload_0
    //   198: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   201: lload_2
    //   202: lsub
    //   203: aload_1
    //   204: aload 20
    //   206: aload 17
    //   208: invokespecial 276	com/android/volley/toolbox/BasicNetwork:a	(JLcom/android/volley/Request;[BLorg/apache/http/StatusLine;)V
    //   211: iload 18
    //   213: sipush 200
    //   216: if_icmplt +11 -> 227
    //   219: iload 18
    //   221: sipush 299
    //   224: if_icmple +38 -> 262
    //   227: new 152	java/io/IOException
    //   230: dup
    //   231: invokespecial 277	java/io/IOException:<init>	()V
    //   234: athrow
    //   235: astore 15
    //   237: ldc_w 279
    //   240: aload_1
    //   241: new 281	com/android/volley/TimeoutError
    //   244: dup
    //   245: invokespecial 282	com/android/volley/TimeoutError:<init>	()V
    //   248: invokestatic 284	com/android/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   251: goto -247 -> 4
    //   254: iconst_0
    //   255: newarray byte
    //   257: astore 20
    //   259: goto -62 -> 197
    //   262: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   265: lload_2
    //   266: lsub
    //   267: lstore 21
    //   269: new 246	com/android/volley/NetworkResponse
    //   272: dup
    //   273: iload 18
    //   275: aload 20
    //   277: aload 5
    //   279: iconst_0
    //   280: lload 21
    //   282: invokespecial 249	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   285: astore 23
    //   287: aload 23
    //   289: areturn
    //   290: astore 14
    //   292: ldc_w 286
    //   295: aload_1
    //   296: new 281	com/android/volley/TimeoutError
    //   299: dup
    //   300: invokespecial 282	com/android/volley/TimeoutError:<init>	()V
    //   303: invokestatic 284	com/android/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   306: goto -302 -> 4
    //   309: astore 13
    //   311: new 288	java/lang/RuntimeException
    //   314: dup
    //   315: new 290	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 293
    //   325: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_1
    //   329: invokevirtual 299	com/android/volley/Request:d	()Ljava/lang/String;
    //   332: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: aload 13
    //   340: invokespecial 305	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   343: athrow
    //   344: astore 7
    //   346: aconst_null
    //   347: astore 8
    //   349: aload 4
    //   351: ifnull +124 -> 475
    //   354: aload 4
    //   356: invokeinterface 238 1 0
    //   361: invokeinterface 88 1 0
    //   366: istore 9
    //   368: iload 9
    //   370: sipush 301
    //   373: if_icmpeq +11 -> 384
    //   376: iload 9
    //   378: sipush 302
    //   381: if_icmpne +104 -> 485
    //   384: iconst_2
    //   385: anewarray 4	java/lang/Object
    //   388: astore 10
    //   390: aload 10
    //   392: iconst_0
    //   393: aload_1
    //   394: invokevirtual 307	com/android/volley/Request:e	()Ljava/lang/String;
    //   397: aastore
    //   398: aload 10
    //   400: iconst_1
    //   401: aload_1
    //   402: invokevirtual 299	com/android/volley/Request:d	()Ljava/lang/String;
    //   405: aastore
    //   406: ldc_w 309
    //   409: aload 10
    //   411: invokestatic 311	com/android/volley/VolleyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: aload 8
    //   416: ifnull +148 -> 564
    //   419: new 246	com/android/volley/NetworkResponse
    //   422: dup
    //   423: iload 9
    //   425: aload 8
    //   427: aload 5
    //   429: iconst_0
    //   430: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   433: lload_2
    //   434: lsub
    //   435: invokespecial 249	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   438: astore 11
    //   440: iload 9
    //   442: sipush 401
    //   445: if_icmpeq +11 -> 456
    //   448: iload 9
    //   450: sipush 403
    //   453: if_icmpne +66 -> 519
    //   456: ldc_w 313
    //   459: aload_1
    //   460: new 315	com/android/volley/AuthFailureError
    //   463: dup
    //   464: aload 11
    //   466: invokespecial 318	com/android/volley/AuthFailureError:<init>	(Lcom/android/volley/NetworkResponse;)V
    //   469: invokestatic 284	com/android/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   472: goto -468 -> 4
    //   475: new 320	com/android/volley/NoConnectionError
    //   478: dup
    //   479: aload 7
    //   481: invokespecial 323	com/android/volley/NoConnectionError:<init>	(Ljava/lang/Throwable;)V
    //   484: athrow
    //   485: iconst_2
    //   486: anewarray 4	java/lang/Object
    //   489: astore 12
    //   491: aload 12
    //   493: iconst_0
    //   494: iload 9
    //   496: invokestatic 82	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: aload 12
    //   502: iconst_1
    //   503: aload_1
    //   504: invokevirtual 299	com/android/volley/Request:d	()Ljava/lang/String;
    //   507: aastore
    //   508: ldc_w 325
    //   511: aload 12
    //   513: invokestatic 311	com/android/volley/VolleyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   516: goto -102 -> 414
    //   519: iload 9
    //   521: sipush 301
    //   524: if_icmpeq +11 -> 535
    //   527: iload 9
    //   529: sipush 302
    //   532: if_icmpne +22 -> 554
    //   535: ldc_w 327
    //   538: aload_1
    //   539: new 315	com/android/volley/AuthFailureError
    //   542: dup
    //   543: aload 11
    //   545: invokespecial 318	com/android/volley/AuthFailureError:<init>	(Lcom/android/volley/NetworkResponse;)V
    //   548: invokestatic 284	com/android/volley/toolbox/BasicNetwork:a	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   551: goto -547 -> 4
    //   554: new 169	com/android/volley/ServerError
    //   557: dup
    //   558: aload 11
    //   560: invokespecial 328	com/android/volley/ServerError:<init>	(Lcom/android/volley/NetworkResponse;)V
    //   563: athrow
    //   564: new 330	com/android/volley/NetworkError
    //   567: dup
    //   568: aconst_null
    //   569: invokespecial 331	com/android/volley/NetworkError:<init>	(Lcom/android/volley/NetworkResponse;)V
    //   572: athrow
    //   573: astore 7
    //   575: aload 16
    //   577: astore 4
    //   579: aconst_null
    //   580: astore 8
    //   582: goto -233 -> 349
    //   585: astore 7
    //   587: aload 20
    //   589: astore 8
    //   591: aload 16
    //   593: astore 4
    //   595: goto -246 -> 349
    //   598: iload 18
    //   600: sipush 301
    //   603: if_icmpeq -450 -> 153
    //   606: iload 18
    //   608: sipush 302
    //   611: if_icmpne -441 -> 170
    //   614: goto -461 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	BasicNetwork
    //   0	617	1	paramRequest	Request<?>
    //   3	431	2	l1	long
    //   5	589	4	localObject	Object
    //   10	418	5	localMap	Map
    //   19	18	6	localHashMap	java.util.HashMap
    //   344	136	7	localIOException1	IOException
    //   573	1	7	localIOException2	IOException
    //   585	1	7	localIOException3	IOException
    //   347	243	8	arrayOfByte1	byte[]
    //   366	167	9	i	int
    //   388	22	10	arrayOfObject1	Object[]
    //   438	121	11	localNetworkResponse1	com.android.volley.NetworkResponse
    //   489	23	12	arrayOfObject2	Object[]
    //   309	30	13	localMalformedURLException	java.net.MalformedURLException
    //   290	1	14	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   235	1	15	localSocketTimeoutException	java.net.SocketTimeoutException
    //   43	549	16	localHttpResponse	org.apache.http.HttpResponse
    //   52	155	17	localStatusLine	StatusLine
    //   61	551	18	j	int
    //   87	52	19	localEntry	Cache.Entry
    //   195	393	20	arrayOfByte2	byte[]
    //   267	14	21	l2	long
    //   285	3	23	localNetworkResponse2	com.android.volley.NetworkResponse
    //   191	3	24	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	45	235	java/net/SocketTimeoutException
    //   45	75	235	java/net/SocketTimeoutException
    //   83	89	235	java/net/SocketTimeoutException
    //   94	114	235	java/net/SocketTimeoutException
    //   114	153	235	java/net/SocketTimeoutException
    //   153	170	235	java/net/SocketTimeoutException
    //   170	193	235	java/net/SocketTimeoutException
    //   197	211	235	java/net/SocketTimeoutException
    //   227	235	235	java/net/SocketTimeoutException
    //   254	259	235	java/net/SocketTimeoutException
    //   262	287	235	java/net/SocketTimeoutException
    //   12	45	290	org/apache/http/conn/ConnectTimeoutException
    //   45	75	290	org/apache/http/conn/ConnectTimeoutException
    //   83	89	290	org/apache/http/conn/ConnectTimeoutException
    //   94	114	290	org/apache/http/conn/ConnectTimeoutException
    //   114	153	290	org/apache/http/conn/ConnectTimeoutException
    //   153	170	290	org/apache/http/conn/ConnectTimeoutException
    //   170	193	290	org/apache/http/conn/ConnectTimeoutException
    //   197	211	290	org/apache/http/conn/ConnectTimeoutException
    //   227	235	290	org/apache/http/conn/ConnectTimeoutException
    //   254	259	290	org/apache/http/conn/ConnectTimeoutException
    //   262	287	290	org/apache/http/conn/ConnectTimeoutException
    //   12	45	309	java/net/MalformedURLException
    //   45	75	309	java/net/MalformedURLException
    //   83	89	309	java/net/MalformedURLException
    //   94	114	309	java/net/MalformedURLException
    //   114	153	309	java/net/MalformedURLException
    //   153	170	309	java/net/MalformedURLException
    //   170	193	309	java/net/MalformedURLException
    //   197	211	309	java/net/MalformedURLException
    //   227	235	309	java/net/MalformedURLException
    //   254	259	309	java/net/MalformedURLException
    //   262	287	309	java/net/MalformedURLException
    //   12	45	344	java/io/IOException
    //   45	75	573	java/io/IOException
    //   83	89	573	java/io/IOException
    //   94	114	573	java/io/IOException
    //   114	153	573	java/io/IOException
    //   153	170	573	java/io/IOException
    //   170	193	573	java/io/IOException
    //   254	259	573	java/io/IOException
    //   197	211	585	java/io/IOException
    //   227	235	585	java/io/IOException
    //   262	287	585	java/io/IOException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.BasicNetwork
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */