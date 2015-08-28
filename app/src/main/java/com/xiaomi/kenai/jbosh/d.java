package com.xiaomi.kenai.jbosh;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.xiaomi.channel.commonutils.network.a;
import java.net.URI;
import java.net.URLEncoder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

final class d
  implements al
{
  private final Lock a = new ReentrantLock();
  private final HttpContext b;
  private final HttpClient c;
  private HttpPost d;
  private long e;
  private boolean f;
  private aa g;
  private b h;
  private int i;
  
  d(HttpClient paramHttpClient, v paramv, ah paramah, b paramb, Context paramContext)
  {
    this.c = paramHttpClient;
    this.b = new BasicHttpContext();
    this.f = false;
    try
    {
      String str1 = paramb.d();
      this.e = Long.parseLong(paramb.a(r.q));
      String str2 = String.valueOf((int)(1000.0D * Math.random()));
      String str3 = URLEncoder.encode(com.xiaomi.channel.commonutils.string.b.a("xm-http-bind&" + str1));
      if (a.b(paramContext))
      {
        String str4 = paramv.a().getHost();
        Uri.Builder localBuilder2 = Uri.parse(a.a(paramv.a().toURL())).buildUpon();
        localBuilder2.appendQueryParameter("t", str2);
        this.d = new HttpPost(localBuilder2.build().toString());
        this.d.addHeader("X-Online-Host", str4);
      }
      for (;;)
      {
        this.d.addHeader("X-Content-Sig", str3);
        this.d.addHeader("Connection", "Keep-Alive");
        ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(aj.a(str1.getBytes("UTF-8")));
        localByteArrayEntity.setContentType("application/octet-stream");
        this.d.setEntity(localByteArrayEntity);
        return;
        Uri.Builder localBuilder1 = Uri.parse(paramv.a().toString()).buildUpon();
        localBuilder1.appendQueryParameter("t", str2);
        this.d = new HttpPost(localBuilder1.build().toString());
      }
      return;
    }
    catch (Exception localException)
    {
      this.g = new aa("Could not generate request", localException);
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 83	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   9: ldc 204
    //   11: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 67	com/xiaomi/kenai/jbosh/d:e	J
    //   18: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: ldc 209
    //   23: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 155	com/xiaomi/kenai/jbosh/d:d	Lorg/apache/http/client/methods/HttpPost;
    //   30: invokevirtual 212	org/apache/http/client/methods/HttpPost:getURI	()Ljava/net/URI;
    //   33: invokevirtual 193	java/net/URI:toString	()Ljava/lang/String;
    //   36: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 216	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   45: iconst_0
    //   46: istore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: iload_2
    //   50: iconst_3
    //   51: if_icmpge +229 -> 280
    //   54: aload_0
    //   55: getfield 38	com/xiaomi/kenai/jbosh/d:c	Lorg/apache/http/client/HttpClient;
    //   58: aload_0
    //   59: getfield 155	com/xiaomi/kenai/jbosh/d:d	Lorg/apache/http/client/methods/HttpPost;
    //   62: aload_0
    //   63: getfield 43	com/xiaomi/kenai/jbosh/d:b	Lorg/apache/http/protocol/HttpContext;
    //   66: invokeinterface 222 3 0
    //   71: astore 6
    //   73: aload 6
    //   75: invokeinterface 228 1 0
    //   80: invokestatic 234	org/apache/http/util/EntityUtils:toByteArray	(Lorg/apache/http/HttpEntity;)[B
    //   83: astore 7
    //   85: aload 6
    //   87: invokeinterface 238 1 0
    //   92: invokeinterface 244 1 0
    //   97: istore 8
    //   99: new 83	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   106: ldc 246
    //   108: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 8
    //   113: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 216	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   122: iload 8
    //   124: sipush 200
    //   127: if_icmpne +225 -> 352
    //   130: aload 7
    //   132: ifnull +220 -> 352
    //   135: aload 6
    //   137: ldc 163
    //   139: invokeinterface 253 2 0
    //   144: ifeq +208 -> 352
    //   147: aload 7
    //   149: invokestatic 255	com/xiaomi/kenai/jbosh/aj:b	([B)[B
    //   152: astore 9
    //   154: aload 6
    //   156: ldc 163
    //   158: invokeinterface 259 2 0
    //   163: invokeinterface 264 1 0
    //   168: invokestatic 269	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 10
    //   173: new 77	java/lang/String
    //   176: dup
    //   177: aload 9
    //   179: ldc 171
    //   181: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   184: invokestatic 277	com/xiaomi/kenai/jbosh/ap:a	(Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/ap;
    //   187: astore 11
    //   189: new 83	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   196: ldc 86
    //   198: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 11
    //   203: invokevirtual 50	com/xiaomi/kenai/jbosh/b:d	()Ljava/lang/String;
    //   206: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 98	com/xiaomi/channel/commonutils/string/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 12
    //   217: aload 12
    //   219: aload 10
    //   221: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifne +80 -> 304
    //   227: new 83	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 283
    //   237: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 10
    //   242: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 285
    //   248: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 12
    //   253: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 287	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   262: aload_0
    //   263: new 195	com/xiaomi/kenai/jbosh/aa
    //   266: dup
    //   267: ldc_w 289
    //   270: invokespecial 290	com/xiaomi/kenai/jbosh/aa:<init>	(Ljava/lang/String;)V
    //   273: putfield 202	com/xiaomi/kenai/jbosh/d:g	Lcom/xiaomi/kenai/jbosh/aa;
    //   276: aload_0
    //   277: invokevirtual 292	com/xiaomi/kenai/jbosh/d:d	()V
    //   280: iload_2
    //   281: iconst_3
    //   282: if_icmpne +160 -> 442
    //   285: aload_0
    //   286: invokevirtual 292	com/xiaomi/kenai/jbosh/d:d	()V
    //   289: aload_0
    //   290: aload_3
    //   291: putfield 202	com/xiaomi/kenai/jbosh/d:g	Lcom/xiaomi/kenai/jbosh/aa;
    //   294: aload_0
    //   295: getfield 202	com/xiaomi/kenai/jbosh/d:g	Lcom/xiaomi/kenai/jbosh/aa;
    //   298: athrow
    //   299: astore_1
    //   300: aload_0
    //   301: monitorexit
    //   302: aload_1
    //   303: athrow
    //   304: aload_0
    //   305: aload 11
    //   307: putfield 294	com/xiaomi/kenai/jbosh/d:h	Lcom/xiaomi/kenai/jbosh/b;
    //   310: new 83	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 296
    //   320: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_0
    //   324: getfield 67	com/xiaomi/kenai/jbosh/d:e	J
    //   327: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   330: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 216	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   336: aload_0
    //   337: iload 8
    //   339: putfield 298	com/xiaomi/kenai/jbosh/d:i	I
    //   342: aload_0
    //   343: iconst_1
    //   344: putfield 45	com/xiaomi/kenai/jbosh/d:f	Z
    //   347: aconst_null
    //   348: astore_3
    //   349: goto -69 -> 280
    //   352: aload_0
    //   353: invokevirtual 292	com/xiaomi/kenai/jbosh/d:d	()V
    //   356: goto -76 -> 280
    //   359: astore 4
    //   361: aload 4
    //   363: instanceof 300
    //   366: ifeq +51 -> 417
    //   369: new 195	com/xiaomi/kenai/jbosh/aa
    //   372: dup
    //   373: ldc_w 302
    //   376: aload 4
    //   378: invokespecial 200	com/xiaomi/kenai/jbosh/aa:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: astore 5
    //   383: new 83	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 304
    //   393: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: iload_2
    //   397: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: aload 4
    //   405: invokestatic 306	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   408: iinc 2 1
    //   411: aload 5
    //   413: astore_3
    //   414: goto -365 -> 49
    //   417: aload_0
    //   418: invokevirtual 292	com/xiaomi/kenai/jbosh/d:d	()V
    //   421: aload_0
    //   422: new 195	com/xiaomi/kenai/jbosh/aa
    //   425: dup
    //   426: ldc_w 302
    //   429: aload 4
    //   431: invokespecial 200	com/xiaomi/kenai/jbosh/aa:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   434: putfield 202	com/xiaomi/kenai/jbosh/d:g	Lcom/xiaomi/kenai/jbosh/aa;
    //   437: aload_0
    //   438: getfield 202	com/xiaomi/kenai/jbosh/d:g	Lcom/xiaomi/kenai/jbosh/aa;
    //   441: athrow
    //   442: aload_0
    //   443: monitorexit
    //   444: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	d
    //   299	4	1	localObject1	Object
    //   46	363	2	j	int
    //   48	366	3	localObject2	Object
    //   359	71	4	localException	Exception
    //   381	31	5	localaa	aa
    //   71	84	6	localHttpResponse	org.apache.http.HttpResponse
    //   83	65	7	arrayOfByte1	byte[]
    //   97	241	8	k	int
    //   152	26	9	arrayOfByte2	byte[]
    //   171	70	10	str1	String
    //   187	119	11	localap	ap
    //   215	37	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	45	299	finally
    //   54	122	299	finally
    //   135	280	299	finally
    //   285	299	299	finally
    //   304	347	299	finally
    //   352	356	299	finally
    //   361	408	299	finally
    //   417	442	299	finally
    //   54	122	359	java/lang/Exception
    //   135	280	359	java/lang/Exception
    //   304	347	359	java/lang/Exception
    //   352	356	359	java/lang/Exception
  }
  
  public int a()
  {
    if (this.g != null) {
      throw this.g;
    }
    this.a.lock();
    try
    {
      if (!this.f) {
        e();
      }
      return this.i;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public b b()
  {
    if (this.g != null) {
      throw this.g;
    }
    this.a.lock();
    try
    {
      if (!this.f) {
        e();
      }
      return this.h;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public long c()
  {
    return this.e;
  }
  
  public void d()
  {
    if (this.d != null)
    {
      this.d.abort();
      this.g = new aa("HTTP request aborted");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */