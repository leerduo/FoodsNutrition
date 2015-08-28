package com.xiaomi.smack;

import com.xiaomi.kenai.jbosh.aa;
import com.xiaomi.kenai.jbosh.ag;
import com.xiaomi.kenai.jbosh.ai;
import com.xiaomi.kenai.jbosh.ai.a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.v.b;
import com.xiaomi.smack.packet.f.b;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class b
  extends j
{
  protected String a = null;
  protected String b = null;
  private com.xiaomi.kenai.jbosh.s o;
  private final a p;
  private boolean q = false;
  private boolean r = false;
  private boolean s = true;
  private boolean t = false;
  private boolean u = false;
  private ExecutorService v;
  private PipedWriter w;
  private Thread x;
  private String y = null;
  private Object z = new Object();
  
  public b(XMPushService paramXMPushService, a parama)
  {
    super(paramXMPushService, parama);
    this.p = parama;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 74	com/xiaomi/smack/b:j	()Z
    //   4: ifeq +9 -> 13
    //   7: ldc 76
    //   9: invokestatic 81	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   12: return
    //   13: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   16: lstore_1
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 41	com/xiaomi/smack/b:u	Z
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 45	com/xiaomi/smack/b:b	Ljava/lang/String;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 43	com/xiaomi/smack/b:a	Ljava/lang/String;
    //   32: aload_0
    //   33: iconst_0
    //   34: iconst_0
    //   35: aconst_null
    //   36: invokevirtual 90	com/xiaomi/smack/b:a	(IILjava/lang/Exception;)V
    //   39: aload_0
    //   40: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   43: invokevirtual 95	com/xiaomi/smack/a:c	()Ljava/net/URI;
    //   46: astore 4
    //   48: new 97	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   55: ldc 100
    //   57: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload 4
    //   62: invokevirtual 110	java/net/URI:toString	()Ljava/lang/String;
    //   65: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 113	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: aload 4
    //   77: aload_0
    //   78: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   81: invokevirtual 116	com/xiaomi/smack/a:e	()Ljava/lang/String;
    //   84: invokestatic 121	com/xiaomi/kenai/jbosh/v$a:a	(Ljava/net/URI;Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/v$a;
    //   87: invokevirtual 124	com/xiaomi/kenai/jbosh/v$a:a	()Lcom/xiaomi/kenai/jbosh/v;
    //   90: aload_0
    //   91: getfield 128	com/xiaomi/smack/b:n	Lcom/xiaomi/push/service/XMPushService;
    //   94: invokevirtual 134	com/xiaomi/push/service/XMPushService:getApplicationContext	()Landroid/content/Context;
    //   97: invokestatic 139	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/v;Landroid/content/Context;)Lcom/xiaomi/kenai/jbosh/s;
    //   100: putfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   103: aload_0
    //   104: new 143	com/xiaomi/smack/c
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 146	com/xiaomi/smack/c:<init>	(Lcom/xiaomi/smack/b;)V
    //   112: invokestatic 152	java/util/concurrent/Executors:newSingleThreadExecutor	(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
    //   115: putfield 154	com/xiaomi/smack/b:v	Ljava/util/concurrent/ExecutorService;
    //   118: aload_0
    //   119: getfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   122: new 156	com/xiaomi/smack/b$a
    //   125: dup
    //   126: aload_0
    //   127: aconst_null
    //   128: invokespecial 159	com/xiaomi/smack/b$a:<init>	(Lcom/xiaomi/smack/b;Lcom/xiaomi/smack/c;)V
    //   131: invokevirtual 162	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/x;)V
    //   134: aload_0
    //   135: getfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   138: new 164	com/xiaomi/smack/i
    //   141: dup
    //   142: aload_0
    //   143: invokespecial 165	com/xiaomi/smack/i:<init>	(Lcom/xiaomi/smack/b;)V
    //   146: invokevirtual 168	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/z;)V
    //   149: aload_0
    //   150: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   153: invokevirtual 171	com/xiaomi/smack/a:i	()Z
    //   156: ifeq +66 -> 222
    //   159: aload_0
    //   160: invokevirtual 173	com/xiaomi/smack/b:b	()V
    //   163: aload_0
    //   164: getfield 37	com/xiaomi/smack/b:s	Z
    //   167: ifeq +55 -> 222
    //   170: aload_0
    //   171: getfield 177	com/xiaomi/smack/b:h	Lcom/xiaomi/smack/debugger/a;
    //   174: invokeinterface 182 1 0
    //   179: ifnull +17 -> 196
    //   182: aload_0
    //   183: aload_0
    //   184: getfield 177	com/xiaomi/smack/b:h	Lcom/xiaomi/smack/debugger/a;
    //   187: invokeinterface 182 1 0
    //   192: aconst_null
    //   193: invokevirtual 185	com/xiaomi/smack/b:a	(Lcom/xiaomi/smack/n;Lcom/xiaomi/smack/filter/a;)V
    //   196: aload_0
    //   197: getfield 177	com/xiaomi/smack/b:h	Lcom/xiaomi/smack/debugger/a;
    //   200: invokeinterface 187 1 0
    //   205: ifnull +17 -> 222
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 177	com/xiaomi/smack/b:h	Lcom/xiaomi/smack/debugger/a;
    //   213: invokeinterface 187 1 0
    //   218: aconst_null
    //   219: invokevirtual 189	com/xiaomi/smack/b:b	(Lcom/xiaomi/smack/n;Lcom/xiaomi/smack/filter/a;)V
    //   222: aload_0
    //   223: getfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   226: invokestatic 194	com/xiaomi/kenai/jbosh/ai:a	()Lcom/xiaomi/kenai/jbosh/ai$a;
    //   229: ldc 196
    //   231: ldc 198
    //   233: invokestatic 203	com/xiaomi/kenai/jbosh/ag:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/ag;
    //   236: ldc 205
    //   238: invokevirtual 210	com/xiaomi/kenai/jbosh/ai$a:a	(Lcom/xiaomi/kenai/jbosh/ag;Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/ai$a;
    //   241: invokevirtual 213	com/xiaomi/kenai/jbosh/ai$a:a	()Lcom/xiaomi/kenai/jbosh/ai;
    //   244: invokevirtual 216	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/ai;)V
    //   247: aload_0
    //   248: getfield 54	com/xiaomi/smack/b:z	Ljava/lang/Object;
    //   251: astore 5
    //   253: aload 5
    //   255: monitorenter
    //   256: aload_0
    //   257: invokevirtual 74	com/xiaomi/smack/b:j	()Z
    //   260: istore 7
    //   262: iload 7
    //   264: ifne +17 -> 281
    //   267: aload_0
    //   268: getfield 54	com/xiaomi/smack/b:z	Ljava/lang/Object;
    //   271: bipush 6
    //   273: invokestatic 221	com/xiaomi/smack/r:b	()I
    //   276: imul
    //   277: i2l
    //   278: invokevirtual 225	java/lang/Object:wait	(J)V
    //   281: aload 5
    //   283: monitorexit
    //   284: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   287: lload_1
    //   288: lsub
    //   289: lstore 8
    //   291: aload_0
    //   292: invokevirtual 74	com/xiaomi/smack/b:j	()Z
    //   295: ifne +156 -> 451
    //   298: aload_0
    //   299: iconst_1
    //   300: putfield 41	com/xiaomi/smack/b:u	Z
    //   303: aload_0
    //   304: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   307: invokevirtual 227	com/xiaomi/smack/a:b	()Ljava/lang/String;
    //   310: invokestatic 231	com/xiaomi/stats/b:a	(Ljava/lang/String;)V
    //   313: new 97	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   320: ldc 233
    //   322: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_0
    //   326: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   329: invokevirtual 227	com/xiaomi/smack/a:b	()Ljava/lang/String;
    //   332: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc 235
    //   337: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: invokevirtual 238	com/xiaomi/smack/b:g	()I
    //   344: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: ldc 243
    //   349: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: astore 10
    //   357: aload_0
    //   358: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   361: invokevirtual 246	com/xiaomi/smack/a:a	()Lcom/xiaomi/network/Fallback;
    //   364: aload_0
    //   365: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   368: invokevirtual 227	com/xiaomi/smack/a:b	()Ljava/lang/String;
    //   371: lload 8
    //   373: lconst_0
    //   374: aconst_null
    //   375: invokevirtual 251	com/xiaomi/network/Fallback:a	(Ljava/lang/String;JJLjava/lang/Exception;)V
    //   378: new 253	com/xiaomi/smack/w
    //   381: dup
    //   382: aload 10
    //   384: new 255	com/xiaomi/smack/packet/h
    //   387: dup
    //   388: getstatic 260	com/xiaomi/smack/packet/h$a:r	Lcom/xiaomi/smack/packet/h$a;
    //   391: aload 10
    //   393: invokespecial 263	com/xiaomi/smack/packet/h:<init>	(Lcom/xiaomi/smack/packet/h$a;Ljava/lang/String;)V
    //   396: invokespecial 266	com/xiaomi/smack/w:<init>	(Ljava/lang/String;Lcom/xiaomi/smack/packet/h;)V
    //   399: athrow
    //   400: astore_3
    //   401: aload_0
    //   402: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   405: invokevirtual 227	com/xiaomi/smack/a:b	()Ljava/lang/String;
    //   408: invokestatic 231	com/xiaomi/stats/b:a	(Ljava/lang/String;)V
    //   411: new 253	com/xiaomi/smack/w
    //   414: dup
    //   415: new 97	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   422: ldc_w 268
    //   425: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_0
    //   429: invokevirtual 270	com/xiaomi/smack/b:d	()Ljava/lang/String;
    //   432: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: aload_3
    //   439: invokespecial 273	com/xiaomi/smack/w:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   442: athrow
    //   443: astore 6
    //   445: aload 5
    //   447: monitorexit
    //   448: aload 6
    //   450: athrow
    //   451: lload 8
    //   453: aload_0
    //   454: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   457: invokevirtual 227	com/xiaomi/smack/a:b	()Ljava/lang/String;
    //   460: invokestatic 276	com/xiaomi/stats/b:a	(JLjava/lang/String;)V
    //   463: aload_0
    //   464: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   467: invokevirtual 246	com/xiaomi/smack/a:a	()Lcom/xiaomi/network/Fallback;
    //   470: aload_0
    //   471: getfield 56	com/xiaomi/smack/b:p	Lcom/xiaomi/smack/a;
    //   474: invokevirtual 227	com/xiaomi/smack/a:b	()Ljava/lang/String;
    //   477: lload 8
    //   479: lconst_0
    //   480: invokevirtual 279	com/xiaomi/network/Fallback:a	(Ljava/lang/String;JJ)V
    //   483: return
    //   484: astore 11
    //   486: goto -205 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	b
    //   16	272	1	l1	long
    //   400	39	3	localException	Exception
    //   46	30	4	localURI	java.net.URI
    //   443	6	6	localObject2	Object
    //   260	3	7	bool	boolean
    //   289	189	8	l2	long
    //   355	37	10	str	String
    //   484	1	11	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   32	196	400	java/lang/Exception
    //   196	222	400	java/lang/Exception
    //   222	247	400	java/lang/Exception
    //   256	262	443	finally
    //   267	281	443	finally
    //   281	284	443	finally
    //   445	448	443	finally
    //   267	281	484	java/lang/InterruptedException
  }
  
  protected void a(ai paramai)
  {
    if (!j()) {
      throw new aa("Not connected to a server!");
    }
    if (paramai == null) {
      throw new NullPointerException("Body mustn't be null!");
    }
    if (this.b != null) {
      paramai = paramai.b().a(ag.a("xm", "sid"), this.b).a();
    }
    this.o.a(paramai);
  }
  
  public void a(v.b paramb)
  {
    try
    {
      new s().a(paramb, this.k, this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(com.xiaomi.smack.packet.d paramd)
  {
    if (!this.u) {
      try
      {
        a(ai.a().a(paramd.c()).a());
        c(paramd);
        return;
      }
      catch (aa localaa)
      {
        throw new w(localaa);
      }
    }
    throw new w("try send packet while the connection is done.");
  }
  
  public void a(com.xiaomi.smack.packet.f paramf, int paramInt, Exception paramException)
  {
    if (o() == 2) {
      return;
    }
    b(paramf, paramInt, paramException);
    this.g.clear();
    this.f.clear();
    this.t = false;
    this.s = true;
  }
  
  protected void a(Exception paramException)
  {
    this.n.a(new h(this, 2, paramException));
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      com.xiaomi.smack.packet.f localf = new com.xiaomi.smack.packet.f(f.b.b);
      localf.l(paramString1);
      localf.n(paramString2);
      a(localf);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(com.xiaomi.smack.packet.d[] paramArrayOfd)
  {
    int i = 0;
    if (!this.u)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfd.length;
      for (int k = 0; k < j; k++)
      {
        com.xiaomi.smack.packet.d locald = paramArrayOfd[k];
        if (locald == null) {
          throw new NullPointerException("Packet is null.");
        }
        localStringBuilder.append(locald.c());
      }
      try
      {
        a(ai.a().a(localStringBuilder.toString()).a());
        int m = paramArrayOfd.length;
        while (i < m)
        {
          c(paramArrayOfd[i]);
          i++;
          continue;
          throw new w("try send packet while connection is done.");
        }
      }
      catch (aa localaa)
      {
        throw new w(localaa);
      }
    }
  }
  
  protected void b()
  {
    this.j = new d(this);
    try
    {
      this.w = new PipedWriter();
      this.i = new PipedReader(this.w);
      label38:
      super.b();
      this.o.a(new e(this));
      this.o.a(new f(this));
      this.x = new g(this);
      this.x.setDaemon(true);
      this.x.start();
      return;
    }
    catch (IOException localIOException)
    {
      break label38;
    }
  }
  
  protected void b(com.xiaomi.smack.packet.d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.v.submit(new b.b(this, paramd));
  }
  
  /* Error */
  protected void b(com.xiaomi.smack.packet.f paramf, int paramInt, Exception paramException)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 43	com/xiaomi/smack/b:a	Ljava/lang/String;
    //   5: aload_0
    //   6: aconst_null
    //   7: putfield 45	com/xiaomi/smack/b:b	Ljava/lang/String;
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 41	com/xiaomi/smack/b:u	Z
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 33	com/xiaomi/smack/b:q	Z
    //   20: aload_0
    //   21: iconst_2
    //   22: iload_2
    //   23: aload_3
    //   24: invokevirtual 90	com/xiaomi/smack/b:a	(IILjava/lang/Exception;)V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 37	com/xiaomi/smack/b:s	Z
    //   32: aload_0
    //   33: ldc_w 425
    //   36: putfield 301	com/xiaomi/smack/b:k	Ljava/lang/String;
    //   39: aload_0
    //   40: getfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   43: invokestatic 194	com/xiaomi/kenai/jbosh/ai:a	()Lcom/xiaomi/kenai/jbosh/ai$a;
    //   46: ldc_w 427
    //   49: ldc 196
    //   51: invokevirtual 430	com/xiaomi/kenai/jbosh/ai$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/kenai/jbosh/ai$a;
    //   54: invokevirtual 213	com/xiaomi/kenai/jbosh/ai$a:a	()Lcom/xiaomi/kenai/jbosh/ai;
    //   57: invokevirtual 432	com/xiaomi/kenai/jbosh/s:b	(Lcom/xiaomi/kenai/jbosh/ai;)V
    //   60: ldc2_w 433
    //   63: invokestatic 437	java/lang/Thread:sleep	(J)V
    //   66: aload_0
    //   67: getfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   70: ifnull +15 -> 85
    //   73: aload_0
    //   74: getfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   77: invokevirtual 439	com/xiaomi/kenai/jbosh/s:a	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 141	com/xiaomi/smack/b:o	Lcom/xiaomi/kenai/jbosh/s;
    //   85: aload_0
    //   86: getfield 59	com/xiaomi/smack/b:w	Ljava/io/PipedWriter;
    //   89: ifnull +15 -> 104
    //   92: aload_0
    //   93: getfield 59	com/xiaomi/smack/b:w	Ljava/io/PipedWriter;
    //   96: invokevirtual 442	java/io/PipedWriter:close	()V
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 388	com/xiaomi/smack/b:i	Ljava/io/Reader;
    //   104: aload_0
    //   105: getfield 388	com/xiaomi/smack/b:i	Ljava/io/Reader;
    //   108: ifnull +15 -> 123
    //   111: aload_0
    //   112: getfield 388	com/xiaomi/smack/b:i	Ljava/io/Reader;
    //   115: invokevirtual 445	java/io/Reader:close	()V
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 388	com/xiaomi/smack/b:i	Ljava/io/Reader;
    //   123: aload_0
    //   124: getfield 377	com/xiaomi/smack/b:j	Ljava/io/Writer;
    //   127: ifnull +15 -> 142
    //   130: aload_0
    //   131: getfield 377	com/xiaomi/smack/b:j	Ljava/io/Writer;
    //   134: invokevirtual 448	java/io/Writer:close	()V
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 377	com/xiaomi/smack/b:j	Ljava/io/Writer;
    //   142: aload_0
    //   143: getfield 154	com/xiaomi/smack/b:v	Ljava/util/concurrent/ExecutorService;
    //   146: ifnull +12 -> 158
    //   149: aload_0
    //   150: getfield 154	com/xiaomi/smack/b:v	Ljava/util/concurrent/ExecutorService;
    //   153: invokeinterface 451 1 0
    //   158: aload_0
    //   159: invokevirtual 454	com/xiaomi/smack/b:h	()Ljava/util/Collection;
    //   162: invokeinterface 460 1 0
    //   167: astore 5
    //   169: aload 5
    //   171: invokeinterface 465 1 0
    //   176: ifeq +40 -> 216
    //   179: aload 5
    //   181: invokeinterface 469 1 0
    //   186: checkcast 471	com/xiaomi/smack/l
    //   189: astore 6
    //   191: aload 6
    //   193: iload_2
    //   194: aload_3
    //   195: invokeinterface 474 3 0
    //   200: goto -31 -> 169
    //   203: astore 7
    //   205: ldc_w 476
    //   208: aload 7
    //   210: invokestatic 478	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: goto -44 -> 169
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 62	com/xiaomi/smack/b:x	Ljava/lang/Thread;
    //   221: return
    //   222: astore 8
    //   224: goto -87 -> 137
    //   227: astore 9
    //   229: goto -111 -> 118
    //   232: astore 10
    //   234: goto -135 -> 99
    //   237: astore 4
    //   239: goto -173 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	b
    //   0	242	1	paramf	com.xiaomi.smack.packet.f
    //   0	242	2	paramInt	int
    //   0	242	3	paramException	Exception
    //   237	1	4	localException1	Exception
    //   167	13	5	localIterator	java.util.Iterator
    //   189	3	6	locall	l
    //   203	6	7	localException2	Exception
    //   222	1	8	localThrowable1	java.lang.Throwable
    //   227	1	9	localThrowable2	java.lang.Throwable
    //   232	1	10	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   191	200	203	java/lang/Exception
    //   130	137	222	java/lang/Throwable
    //   111	118	227	java/lang/Throwable
    //   92	99	232	java/lang/Throwable
    //   39	66	237	java/lang/Exception
  }
  
  public void c()
  {
    if (j())
    {
      com.xiaomi.channel.commonutils.logger.b.b("SMACK-BOSH: scheduling empty request for ping");
      this.o.b();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */