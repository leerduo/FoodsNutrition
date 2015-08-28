package com.xiaomi.smack;

import android.os.SystemClock;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.v.b;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.packet.f.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class t
  extends j
{
  public Exception a = null;
  protected Socket b;
  String o = null;
  q p;
  o q;
  private String r = null;
  private String s = "";
  private String t;
  private XMPushService u;
  private volatile long v = 0L;
  private volatile long w = 0L;
  private final String x = "<pf><p>t:%1$d</p></pf>";
  private volatile long y = 0L;
  private int z;
  
  public t(XMPushService paramXMPushService, k paramk)
  {
    super(paramXMPushService, paramk);
    this.u = paramXMPushService;
  }
  
  private void a(k paramk)
  {
    a(paramk.h(), paramk.g());
  }
  
  private void a(Exception paramException)
  {
    if (SystemClock.elapsedRealtime() - this.y < 300000L)
    {
      if (com.xiaomi.channel.commonutils.network.a.d(this.u))
      {
        this.z = (1 + this.z);
        if (this.z >= 2)
        {
          String str = e();
          com.xiaomi.channel.commonutils.logger.b.a("max short conn time reached, sink down current host:" + str);
          a(str, 0L, paramException);
          this.z = 0;
        }
      }
      return;
    }
    this.z = 0;
  }
  
  /* Error */
  private void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield 32	com/xiaomi/smack/t:a	Ljava/lang/Exception;
    //   7: new 117	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 118	java/util/ArrayList:<init>	()V
    //   14: astore 4
    //   16: new 89	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   23: ldc 120
    //   25: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 123	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)Ljava/lang/Integer;
    //   38: invokevirtual 128	java/lang/Integer:intValue	()I
    //   41: istore 5
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 132	com/xiaomi/smack/t:c	(Ljava/lang/String;)Lcom/xiaomi/network/Fallback;
    //   48: astore 6
    //   50: iload 5
    //   52: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokestatic 139	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Integer;)V
    //   58: aload 6
    //   60: ifnull +10 -> 70
    //   63: aload 6
    //   65: invokevirtual 144	com/xiaomi/network/Fallback:c	()Ljava/util/ArrayList;
    //   68: astore 4
    //   70: aload 4
    //   72: invokevirtual 148	java/util/ArrayList:isEmpty	()Z
    //   75: ifeq +10 -> 85
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: lconst_0
    //   87: putfield 50	com/xiaomi/smack/t:y	J
    //   90: new 89	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   97: astore 7
    //   99: aload 4
    //   101: invokevirtual 156	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   104: astore 8
    //   106: aload 8
    //   108: invokeinterface 161 1 0
    //   113: ifeq +191 -> 304
    //   116: aload 8
    //   118: invokeinterface 165 1 0
    //   123: checkcast 167	java/lang/String
    //   126: astore 9
    //   128: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   131: lstore 10
    //   133: aload_0
    //   134: iconst_1
    //   135: aload_0
    //   136: getfield 174	com/xiaomi/smack/t:d	I
    //   139: iadd
    //   140: putfield 174	com/xiaomi/smack/t:d	I
    //   143: new 89	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   150: ldc 176
    //   152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 9
    //   157: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   166: aload_0
    //   167: aload_0
    //   168: invokevirtual 179	com/xiaomi/smack/t:v	()Ljava/net/Socket;
    //   171: putfield 181	com/xiaomi/smack/t:b	Ljava/net/Socket;
    //   174: aload_0
    //   175: getfield 181	com/xiaomi/smack/t:b	Ljava/net/Socket;
    //   178: aconst_null
    //   179: invokevirtual 187	java/net/Socket:bind	(Ljava/net/SocketAddress;)V
    //   182: new 189	java/net/InetSocketAddress
    //   185: dup
    //   186: aload 9
    //   188: iload_2
    //   189: invokespecial 191	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   192: astore 20
    //   194: aload_0
    //   195: getfield 181	com/xiaomi/smack/t:b	Ljava/net/Socket;
    //   198: aload 20
    //   200: sipush 10000
    //   203: invokevirtual 195	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   206: aload_0
    //   207: getfield 181	com/xiaomi/smack/t:b	Ljava/net/Socket;
    //   210: iconst_1
    //   211: invokevirtual 199	java/net/Socket:setTcpNoDelay	(Z)V
    //   214: aload_0
    //   215: aload 9
    //   217: putfield 201	com/xiaomi/smack/t:t	Ljava/lang/String;
    //   220: aload_0
    //   221: invokespecial 203	com/xiaomi/smack/t:y	()V
    //   224: aload_0
    //   225: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   228: lload 10
    //   230: lsub
    //   231: putfield 205	com/xiaomi/smack/t:e	J
    //   234: aload 6
    //   236: ifnull +15 -> 251
    //   239: aload 6
    //   241: aload 9
    //   243: aload_0
    //   244: getfield 205	com/xiaomi/smack/t:e	J
    //   247: lconst_0
    //   248: invokevirtual 208	com/xiaomi/network/Fallback:a	(Ljava/lang/String;JJ)V
    //   251: aload_0
    //   252: invokestatic 74	android/os/SystemClock:elapsedRealtime	()J
    //   255: putfield 50	com/xiaomi/smack/t:y	J
    //   258: new 89	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   265: ldc 210
    //   267: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 9
    //   272: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 212
    //   277: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 205	com/xiaomi/smack/t:e	J
    //   284: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   293: aload_0
    //   294: getfield 205	com/xiaomi/smack/t:e	J
    //   297: aload 9
    //   299: invokestatic 220	com/xiaomi/stats/b:a	(JLjava/lang/String;)V
    //   302: iconst_1
    //   303: istore_3
    //   304: invokestatic 225	com/xiaomi/network/HostManager:a	()Lcom/xiaomi/network/HostManager;
    //   307: invokevirtual 227	com/xiaomi/network/HostManager:e	()V
    //   310: iload_3
    //   311: ifne +283 -> 594
    //   314: new 113	com/xiaomi/smack/w
    //   317: dup
    //   318: aload 7
    //   320: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokespecial 229	com/xiaomi/smack/w:<init>	(Ljava/lang/String;)V
    //   326: athrow
    //   327: astore 18
    //   329: iload_3
    //   330: istore 13
    //   332: aload 6
    //   334: ifnull +19 -> 353
    //   337: aload 6
    //   339: aload 9
    //   341: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   344: lload 10
    //   346: lsub
    //   347: lconst_0
    //   348: aload 18
    //   350: invokevirtual 232	com/xiaomi/network/Fallback:a	(Ljava/lang/String;JJLjava/lang/Exception;)V
    //   353: aload_0
    //   354: aload 18
    //   356: putfield 32	com/xiaomi/smack/t:a	Ljava/lang/Exception;
    //   359: new 89	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   366: ldc 234
    //   368: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 9
    //   373: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 236	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   382: aload 7
    //   384: ldc 238
    //   386: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 9
    //   391: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc 240
    //   396: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: iload_2
    //   400: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: ldc 245
    //   405: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 18
    //   410: invokevirtual 248	java/io/IOException:getMessage	()Ljava/lang/String;
    //   413: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc 250
    //   418: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: iload 13
    //   424: ifne +225 -> 649
    //   427: aload 9
    //   429: invokestatic 251	com/xiaomi/stats/b:a	(Ljava/lang/String;)V
    //   432: iload 13
    //   434: istore 15
    //   436: iload 15
    //   438: istore_3
    //   439: goto -333 -> 106
    //   442: astore 16
    //   444: iload_3
    //   445: istore 13
    //   447: aload 6
    //   449: ifnull +19 -> 468
    //   452: aload 6
    //   454: aload 9
    //   456: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   459: lload 10
    //   461: lsub
    //   462: lconst_0
    //   463: aload 16
    //   465: invokevirtual 232	com/xiaomi/network/Fallback:a	(Ljava/lang/String;JJLjava/lang/Exception;)V
    //   468: aload_0
    //   469: aload 16
    //   471: putfield 32	com/xiaomi/smack/t:a	Ljava/lang/Exception;
    //   474: new 89	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   481: ldc 234
    //   483: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 9
    //   488: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 236	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   497: aload 7
    //   499: ldc 238
    //   501: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 9
    //   506: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 240
    //   511: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: iload_2
    //   515: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: ldc 245
    //   520: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload 16
    //   525: invokevirtual 252	com/xiaomi/smack/w:getMessage	()Ljava/lang/String;
    //   528: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: ldc 250
    //   533: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: iload 13
    //   539: ifne +110 -> 649
    //   542: aload 9
    //   544: invokestatic 251	com/xiaomi/stats/b:a	(Ljava/lang/String;)V
    //   547: iload 13
    //   549: istore 15
    //   551: goto -115 -> 436
    //   554: astore 14
    //   556: aload 14
    //   558: invokestatic 255	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   561: iload_3
    //   562: ifne +81 -> 643
    //   565: aload 9
    //   567: invokestatic 251	com/xiaomi/stats/b:a	(Ljava/lang/String;)V
    //   570: iload_3
    //   571: istore 15
    //   573: goto -137 -> 436
    //   576: astore 12
    //   578: iload_3
    //   579: istore 13
    //   581: iload 13
    //   583: ifne +8 -> 591
    //   586: aload 9
    //   588: invokestatic 251	com/xiaomi/stats/b:a	(Ljava/lang/String;)V
    //   591: aload 12
    //   593: athrow
    //   594: return
    //   595: astore 12
    //   597: iconst_1
    //   598: istore 13
    //   600: goto -19 -> 581
    //   603: astore 12
    //   605: goto -24 -> 581
    //   608: astore 23
    //   610: aload 23
    //   612: astore 14
    //   614: iconst_1
    //   615: istore_3
    //   616: goto -60 -> 556
    //   619: astore 22
    //   621: iconst_1
    //   622: istore 13
    //   624: aload 22
    //   626: astore 16
    //   628: goto -181 -> 447
    //   631: astore 21
    //   633: iconst_1
    //   634: istore 13
    //   636: aload 21
    //   638: astore 18
    //   640: goto -308 -> 332
    //   643: iload_3
    //   644: istore 15
    //   646: goto -210 -> 436
    //   649: iload 13
    //   651: istore 15
    //   653: goto -217 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	this	t
    //   0	656	1	paramString	String
    //   0	656	2	paramInt	int
    //   1	643	3	i	int
    //   14	86	4	localArrayList	java.util.ArrayList
    //   41	10	5	j	int
    //   48	405	6	localFallback	Fallback
    //   97	401	7	localStringBuilder	java.lang.StringBuilder
    //   104	13	8	localIterator	java.util.Iterator
    //   126	461	9	str	String
    //   131	329	10	l	long
    //   576	16	12	localObject1	Object
    //   595	1	12	localObject2	Object
    //   603	1	12	localObject3	Object
    //   330	320	13	k	int
    //   554	3	14	localThrowable1	java.lang.Throwable
    //   612	1	14	localObject4	Object
    //   434	218	15	m	int
    //   442	82	16	localw1	w
    //   626	1	16	localObject5	Object
    //   327	82	18	localIOException1	java.io.IOException
    //   638	1	18	localObject6	Object
    //   192	7	20	localInetSocketAddress	java.net.InetSocketAddress
    //   631	6	21	localIOException2	java.io.IOException
    //   619	6	22	localw2	w
    //   608	3	23	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   143	224	327	java/io/IOException
    //   143	224	442	com/xiaomi/smack/w
    //   143	224	554	java/lang/Throwable
    //   143	224	576	finally
    //   556	561	576	finally
    //   224	234	595	finally
    //   239	251	595	finally
    //   251	302	595	finally
    //   337	353	603	finally
    //   353	422	603	finally
    //   452	468	603	finally
    //   468	537	603	finally
    //   224	234	608	java/lang/Throwable
    //   239	251	608	java/lang/Throwable
    //   251	302	608	java/lang/Throwable
    //   224	234	619	com/xiaomi/smack/w
    //   239	251	619	com/xiaomi/smack/w
    //   251	302	619	com/xiaomi/smack/w
    //   224	234	631	java/io/IOException
    //   239	251	631	java/io/IOException
    //   251	302	631	java/io/IOException
  }
  
  private void a(String paramString, long paramLong, Exception paramException)
  {
    String str = k.d();
    Fallback localFallback = HostManager.a().a(str);
    if (localFallback != null)
    {
      localFallback.a(paramString, paramLong, 0L, paramException);
      HostManager.a().e();
    }
  }
  
  private void y()
  {
    try
    {
      z();
      this.p = new q(this);
      this.q = new o(this);
      if (this.m.i())
      {
        a(this.h.c(), null);
        if (this.h.d() != null) {
          b(this.h.d(), null);
        }
      }
      this.p.c();
      this.q.b();
      return;
    }
    finally {}
  }
  
  private void z()
  {
    try
    {
      this.i = new BufferedReader(new InputStreamReader(this.b.getInputStream(), "UTF-8"), 4096);
      this.j = new BufferedWriter(new OutputStreamWriter(this.b.getOutputStream(), "UTF-8"));
      if ((this.i != null) && (this.j != null)) {
        b();
      }
      return;
    }
    catch (Exception localException)
    {
      throw new w("Error to init reader and writer", localException);
    }
  }
  
  public String a()
  {
    return this.k;
  }
  
  public void a(int paramInt, Exception paramException)
  {
    this.u.a(new v(this, 2, paramInt, paramException));
  }
  
  public void a(v.b paramb)
  {
    try
    {
      new s().a(paramb, a(), this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(d paramd)
  {
    if (this.p != null)
    {
      this.p.a(paramd);
      return;
    }
    throw new w("the writer is null.");
  }
  
  public void a(f paramf, int paramInt, Exception paramException)
  {
    b(paramf, paramInt, paramException);
    if ((paramException != null) && (this.y != 0L)) {
      a(paramException);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      f localf = new f(f.b.b);
      localf.l(paramString1);
      localf.n(paramString2);
      if (this.p != null) {
        this.p.a(localf);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(d[] paramArrayOfd)
  {
    int i = paramArrayOfd.length;
    for (int j = 0; j < i; j++) {
      a(paramArrayOfd[j]);
    }
  }
  
  /* Error */
  protected void b(f paramf, int paramInt, Exception paramException)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 398	com/xiaomi/smack/t:o	()I
    //   6: istore 5
    //   8: iload 5
    //   10: iconst_2
    //   11: if_icmpne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_2
    //   19: iload_2
    //   20: aload_3
    //   21: invokevirtual 401	com/xiaomi/smack/t:a	(IILjava/lang/Exception;)V
    //   24: aload_0
    //   25: ldc 38
    //   27: putfield 347	com/xiaomi/smack/t:k	Ljava/lang/String;
    //   30: aload_0
    //   31: getfield 273	com/xiaomi/smack/t:q	Lcom/xiaomi/smack/o;
    //   34: ifnull +22 -> 56
    //   37: aload_0
    //   38: getfield 273	com/xiaomi/smack/t:q	Lcom/xiaomi/smack/o;
    //   41: invokevirtual 402	com/xiaomi/smack/o:c	()V
    //   44: aload_0
    //   45: getfield 273	com/xiaomi/smack/t:q	Lcom/xiaomi/smack/o;
    //   48: invokevirtual 404	com/xiaomi/smack/o:d	()V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 273	com/xiaomi/smack/t:q	Lcom/xiaomi/smack/o;
    //   56: aload_0
    //   57: getfield 268	com/xiaomi/smack/t:p	Lcom/xiaomi/smack/q;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +22 -> 86
    //   67: aload_0
    //   68: getfield 268	com/xiaomi/smack/t:p	Lcom/xiaomi/smack/q;
    //   71: invokevirtual 405	com/xiaomi/smack/q:b	()V
    //   74: aload_0
    //   75: getfield 268	com/xiaomi/smack/t:p	Lcom/xiaomi/smack/q;
    //   78: invokevirtual 407	com/xiaomi/smack/q:a	()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 268	com/xiaomi/smack/t:p	Lcom/xiaomi/smack/q;
    //   86: aload_0
    //   87: getfield 181	com/xiaomi/smack/t:b	Ljava/net/Socket;
    //   90: invokevirtual 410	java/net/Socket:close	()V
    //   93: aload_0
    //   94: getfield 320	com/xiaomi/smack/t:i	Ljava/io/Reader;
    //   97: astore 8
    //   99: aload 8
    //   101: ifnull +15 -> 116
    //   104: aload_0
    //   105: getfield 320	com/xiaomi/smack/t:i	Ljava/io/Reader;
    //   108: invokevirtual 413	java/io/Reader:close	()V
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 320	com/xiaomi/smack/t:i	Ljava/io/Reader;
    //   116: aload_0
    //   117: getfield 338	com/xiaomi/smack/t:j	Ljava/io/Writer;
    //   120: astore 9
    //   122: aload 9
    //   124: ifnull +15 -> 139
    //   127: aload_0
    //   128: getfield 338	com/xiaomi/smack/t:j	Ljava/io/Writer;
    //   131: invokevirtual 416	java/io/Writer:close	()V
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 338	com/xiaomi/smack/t:j	Ljava/io/Writer;
    //   139: aload_0
    //   140: lconst_0
    //   141: putfield 42	com/xiaomi/smack/t:v	J
    //   144: aload_0
    //   145: lconst_0
    //   146: putfield 44	com/xiaomi/smack/t:w	J
    //   149: goto -135 -> 14
    //   152: astore 4
    //   154: aload_0
    //   155: monitorexit
    //   156: aload 4
    //   158: athrow
    //   159: astore 12
    //   161: aload 12
    //   163: invokestatic 255	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   166: goto -92 -> 74
    //   169: astore 10
    //   171: goto -37 -> 134
    //   174: astore 11
    //   176: goto -65 -> 111
    //   179: astore 7
    //   181: goto -88 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	t
    //   0	184	1	paramf	f
    //   0	184	2	paramInt	int
    //   0	184	3	paramException	Exception
    //   152	5	4	localObject	Object
    //   6	6	5	i	int
    //   60	3	6	localq	q
    //   179	1	7	localThrowable1	java.lang.Throwable
    //   97	3	8	localReader	java.io.Reader
    //   120	3	9	localWriter	java.io.Writer
    //   169	1	10	localThrowable2	java.lang.Throwable
    //   174	1	11	localThrowable3	java.lang.Throwable
    //   159	3	12	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	8	152	finally
    //   17	56	152	finally
    //   56	62	152	finally
    //   67	74	152	finally
    //   74	86	152	finally
    //   86	93	152	finally
    //   93	99	152	finally
    //   104	111	152	finally
    //   111	116	152	finally
    //   116	122	152	finally
    //   127	134	152	finally
    //   134	139	152	finally
    //   139	149	152	finally
    //   161	166	152	finally
    //   67	74	159	java/io/IOException
    //   127	134	169	java/lang/Throwable
    //   104	111	174	java/lang/Throwable
    //   86	93	179	java/lang/Throwable
  }
  
  public void b(String paramString)
  {
    this.s = paramString;
  }
  
  public Fallback c(String paramString)
  {
    return HostManager.a().a(paramString);
  }
  
  public void c()
  {
    if (this.p != null)
    {
      this.p.d();
      long l = System.currentTimeMillis();
      this.u.a(new u(this, 13, l), 15000L);
      return;
    }
    throw new w("the packetwriter is null.");
  }
  
  public String e()
  {
    return this.t;
  }
  
  /* Error */
  public void t()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 431	com/xiaomi/smack/t:j	()Z
    //   6: ifne +10 -> 16
    //   9: aload_0
    //   10: invokevirtual 432	com/xiaomi/smack/t:i	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc_w 434
    //   19: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: iconst_0
    //   27: iconst_0
    //   28: aconst_null
    //   29: invokevirtual 401	com/xiaomi/smack/t:a	(IILjava/lang/Exception;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 277	com/xiaomi/smack/t:m	Lcom/xiaomi/smack/k;
    //   37: invokespecial 436	com/xiaomi/smack/t:a	(Lcom/xiaomi/smack/k;)V
    //   40: goto -18 -> 22
    //   43: astore_2
    //   44: new 113	com/xiaomi/smack/w
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 438	com/xiaomi/smack/w:<init>	(Ljava/lang/Throwable;)V
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	t
    //   53	4	1	localObject	Object
    //   43	6	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	16	43	java/io/IOException
    //   16	22	43	java/io/IOException
    //   25	40	43	java/io/IOException
    //   2	16	53	finally
    //   16	22	53	finally
    //   25	40	53	finally
    //   44	53	53	finally
  }
  
  public String u()
  {
    String str1;
    String str2;
    if ((this.w == 0L) || (this.v == 0L))
    {
      str1 = "";
      str2 = com.xiaomi.stats.b.c();
      if (str2 == null) {
        break label109;
      }
    }
    label109:
    for (String str3 = "<q>" + str2 + "</q>";; str3 = "")
    {
      return String.format(this.s, new Object[] { str1, str3 });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(this.w - this.v);
      str1 = String.format("<pf><p>t:%1$d</p></pf>", arrayOfObject);
      break;
    }
  }
  
  public Socket v()
  {
    return new Socket();
  }
  
  public void w()
  {
    this.v = SystemClock.uptimeMillis();
  }
  
  public void x()
  {
    this.w = SystemClock.uptimeMillis();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.t
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */