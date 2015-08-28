package com.xiaomi.kenai.jbosh;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class s
{
  private static final int b;
  private static final int c;
  private static final boolean d;
  private Context A;
  private final Set<x> e = new CopyOnWriteArraySet();
  private final Set<y> f = new CopyOnWriteArraySet();
  private final Set<z> g = new CopyOnWriteArraySet();
  private final ReentrantLock h = new ReentrantLock();
  private final Condition i = this.h.newCondition();
  private final Condition j = this.h.newCondition();
  private final Condition k = this.h.newCondition();
  private long l = 0L;
  private final v m;
  private final Runnable n = new t(this);
  private final am o = new e();
  private final ao p = new ao();
  private final ScheduledExecutorService q = Executors.newSingleThreadScheduledExecutor();
  private ThreadPoolExecutor r;
  private ScheduledFuture<?> s;
  private ah t;
  private Queue<ak> u = new LinkedList();
  private SortedSet<Long> v = new TreeSet();
  private Long w = Long.valueOf(-1L);
  private List<ai> x = new ArrayList();
  private volatile long y = 0L;
  private volatile long z = 0L;
  
  static
  {
    boolean bool1 = true;
    boolean bool2;
    String str;
    if (!s.class.desiredAssertionStatus())
    {
      bool2 = bool1;
      a = bool2;
      b = Integer.getInteger(s.class.getName() + ".emptyRequestDelay", 100).intValue();
      c = Integer.getInteger(s.class.getName() + ".pauseMargin", 500).intValue();
      str = s.class.getSimpleName() + ".assertionsEnabled";
      if (System.getProperty(str) != null) {
        break label132;
      }
      if (a) {
        break label140;
      }
    }
    for (;;)
    {
      d = bool1;
      return;
      bool2 = false;
      break;
      label132:
      bool1 = Boolean.getBoolean(str);
      continue;
      label140:
      bool1 = false;
    }
  }
  
  private s(v paramv, Context paramContext)
  {
    this.m = paramv;
    this.A = paramContext.getApplicationContext();
    c();
  }
  
  private ai a(long paramLong, ai paramai)
  {
    k();
    ai.a locala = paramai.b();
    locala.a(r.w, this.m.b());
    locala.a(r.A, this.m.d());
    locala.a(r.y, p.b().toString());
    locala.a(r.z, "300");
    locala.a(r.h, "1");
    locala.a(r.q, Long.toString(paramLong));
    a(locala);
    b(locala);
    locala.a(r.c, "1");
    locala.a(r.t, null);
    return locala.a();
  }
  
  private aq a(int paramInt, b paramb)
  {
    k();
    if (a(paramb)) {
      return aq.a(paramb.a(r.e));
    }
    if ((this.t != null) && (this.t.c() == null)) {
      return aq.a(paramInt);
    }
    return null;
  }
  
  public static s a(v paramv, Context paramContext)
  {
    if (paramv == null) {
      throw new IllegalArgumentException("Client configuration may not be null");
    }
    return new s(paramv, paramContext);
  }
  
  private void a(long paramLong)
  {
    k();
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Empty request delay must be >= 0 (was: " + paramLong + ")");
    }
    h();
    if (!d()) {
      return;
    }
    com.xiaomi.channel.commonutils.logger.b.b("SMACK-BOSH: Scheduling empty request in " + paramLong + "ms");
    try
    {
      this.s = this.q.schedule(this.n, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      com.xiaomi.channel.commonutils.logger.b.a("SMACK-BOSH: Could not schedule empty request", localRejectedExecutionException);
    }
  }
  
  private void a(ai.a parama)
  {
    k();
    String str = this.m.e();
    if (str != null) {
      parama.a(r.r, str);
    }
  }
  
  private void a(ak paramak)
  {
    this.u.add(paramak);
    this.r.execute(new u(this));
  }
  
  private void a(b paramb, int paramInt)
  {
    aq localaq = a(paramInt, paramb);
    if (localaq != null) {
      throw new aa("Terminal binding condition encountered: " + localaq.a() + "  (" + localaq.b() + ")");
    }
  }
  
  private void a(b paramb1, b paramb2)
  {
    k();
    if (!this.t.f()) {}
    while (paramb2.a(r.o) != null) {
      return;
    }
    String str = paramb2.a(r.c);
    if (str == null) {}
    for (Long localLong = Long.valueOf(Long.parseLong(paramb1.a(r.q)));; localLong = Long.valueOf(Long.parseLong(str)))
    {
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext()) {
        if (Long.valueOf(Long.parseLong(((b)localIterator.next()).a(r.q))).compareTo(localLong) <= 0) {
          localIterator.remove();
        }
      }
      break;
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    l();
    this.h.lock();
    for (;;)
    {
      try
      {
        ThreadPoolExecutor localThreadPoolExecutor = this.r;
        if (localThreadPoolExecutor == null)
        {
          this.h.unlock();
          return;
        }
        this.r.shutdownNow();
        this.r = null;
        this.h.unlock();
        if (paramThrowable == null)
        {
          n();
          this.h.lock();
        }
        b(paramThrowable);
      }
      finally
      {
        try
        {
          h();
          this.u = null;
          this.t = null;
          this.v = null;
          this.x = null;
          this.i.signalAll();
          this.j.signalAll();
          this.k.signalAll();
          this.h.unlock();
          return;
        }
        finally
        {
          this.h.unlock();
        }
        localObject1 = finally;
        this.h.unlock();
      }
    }
  }
  
  private static boolean a(b paramb)
  {
    return "terminate".equals(paramb.a(r.x));
  }
  
  private ai b(long paramLong, ai paramai)
  {
    k();
    ai.a locala = paramai.b();
    locala.a(r.t, this.t.a().toString());
    locala.a(r.q, Long.toString(paramLong));
    return locala.a();
  }
  
  private void b(ai.a parama)
  {
    k();
    String str = this.m.c();
    if (str != null) {
      parama.a(r.g, str);
    }
  }
  
  /* Error */
  private void b(ak paramak)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 421	com/xiaomi/kenai/jbosh/s:l	()V
    //   4: aload_1
    //   5: invokevirtual 471	com/xiaomi/kenai/jbosh/ak:b	()Lcom/xiaomi/kenai/jbosh/al;
    //   8: astore 4
    //   10: aload 4
    //   12: invokeinterface 476 1 0
    //   17: astore 5
    //   19: aload 4
    //   21: invokeinterface 478 1 0
    //   26: istore 6
    //   28: aload_0
    //   29: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   35: aload 4
    //   37: invokeinterface 481 1 0
    //   42: lstore 9
    //   44: aload_0
    //   45: getfield 200	com/xiaomi/kenai/jbosh/s:y	J
    //   48: lload 9
    //   50: lcmp
    //   51: ifne +8 -> 59
    //   54: aload_0
    //   55: lconst_0
    //   56: putfield 200	com/xiaomi/kenai/jbosh/s:y	J
    //   59: lload 9
    //   61: aload_0
    //   62: getfield 148	com/xiaomi/kenai/jbosh/s:l	J
    //   65: lcmp
    //   66: ifgt +164 -> 230
    //   69: aload_0
    //   70: getfield 146	com/xiaomi/kenai/jbosh/s:k	Ljava/util/concurrent/locks/Condition;
    //   73: invokeinterface 438 1 0
    //   78: aload_0
    //   79: lconst_1
    //   80: aload_0
    //   81: getfield 148	com/xiaomi/kenai/jbosh/s:l	J
    //   84: ladd
    //   85: putfield 148	com/xiaomi/kenai/jbosh/s:l	J
    //   88: aload_0
    //   89: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   92: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   95: aload_0
    //   96: aload 5
    //   98: invokespecial 484	com/xiaomi/kenai/jbosh/s:g	(Lcom/xiaomi/kenai/jbosh/b;)V
    //   101: aload_1
    //   102: invokevirtual 486	com/xiaomi/kenai/jbosh/ak:a	()Lcom/xiaomi/kenai/jbosh/b;
    //   105: astore 11
    //   107: aload_0
    //   108: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   111: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   114: aload_0
    //   115: invokespecial 323	com/xiaomi/kenai/jbosh/s:d	()Z
    //   118: ifne +294 -> 412
    //   121: aload_0
    //   122: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   128: aload_0
    //   129: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   132: invokevirtual 489	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   135: ifeq +270 -> 405
    //   138: aload_0
    //   139: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   142: ifnull +43 -> 185
    //   145: aload_0
    //   146: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   149: invokeinterface 492 1 0
    //   154: ifeq +31 -> 185
    //   157: aload_0
    //   158: invokespecial 494	com/xiaomi/kenai/jbosh/s:g	()Z
    //   161: ifne +24 -> 185
    //   164: aload_0
    //   165: aload 11
    //   167: invokespecial 497	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/b;)J
    //   170: lstore 41
    //   172: lload 41
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +9 -> 185
    //   179: aload_0
    //   180: lload 41
    //   182: invokespecial 499	com/xiaomi/kenai/jbosh/s:a	(J)V
    //   185: aload_0
    //   186: getfield 144	com/xiaomi/kenai/jbosh/s:j	Ljava/util/concurrent/locks/Condition;
    //   189: invokeinterface 438 1 0
    //   194: aload_0
    //   195: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   198: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   201: return
    //   202: astore_3
    //   203: ldc_w 501
    //   206: aload_3
    //   207: invokestatic 350	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_0
    //   211: aload_3
    //   212: invokespecial 503	com/xiaomi/kenai/jbosh/s:a	(Ljava/lang/Throwable;)V
    //   215: return
    //   216: astore_2
    //   217: ldc_w 505
    //   220: aload_2
    //   221: invokestatic 350	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_0
    //   225: aload_2
    //   226: invokespecial 503	com/xiaomi/kenai/jbosh/s:a	(Ljava/lang/Throwable;)V
    //   229: return
    //   230: new 69	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 507
    //   240: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: lload 9
    //   245: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: ldc_w 509
    //   251: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 148	com/xiaomi/kenai/jbosh/s:l	J
    //   258: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: ldc_w 511
    //   264: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 331	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   273: aload_0
    //   274: getfield 146	com/xiaomi/kenai/jbosh/s:k	Ljava/util/concurrent/locks/Condition;
    //   277: ldc2_w 512
    //   280: getstatic 516	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   283: invokeinterface 520 4 0
    //   288: ifne -210 -> 78
    //   291: new 69	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 522
    //   301: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_0
    //   305: getfield 148	com/xiaomi/kenai/jbosh/s:l	J
    //   308: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   311: ldc_w 524
    //   314: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 526	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   323: aload_0
    //   324: new 377	com/xiaomi/kenai/jbosh/aa
    //   327: dup
    //   328: new 69	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 528
    //   338: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 148	com/xiaomi/kenai/jbosh/s:l	J
    //   345: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokespecial 385	com/xiaomi/kenai/jbosh/aa:<init>	(Ljava/lang/String;)V
    //   354: invokespecial 503	com/xiaomi/kenai/jbosh/s:a	(Ljava/lang/Throwable;)V
    //   357: aload_0
    //   358: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   361: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   364: return
    //   365: astore 8
    //   367: aload_0
    //   368: aload 8
    //   370: invokespecial 503	com/xiaomi/kenai/jbosh/s:a	(Ljava/lang/Throwable;)V
    //   373: aload_0
    //   374: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   377: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   380: return
    //   381: astore 7
    //   383: aload_0
    //   384: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   387: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   390: aload 7
    //   392: athrow
    //   393: astore 40
    //   395: aload_0
    //   396: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   399: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   402: aload 40
    //   404: athrow
    //   405: ldc_w 530
    //   408: invokestatic 331	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   411: return
    //   412: aload_0
    //   413: getfield 292	com/xiaomi/kenai/jbosh/s:t	Lcom/xiaomi/kenai/jbosh/ah;
    //   416: ifnonnull +18 -> 434
    //   419: aload_0
    //   420: aload 11
    //   422: aload 5
    //   424: invokestatic 533	com/xiaomi/kenai/jbosh/ah:a	(Lcom/xiaomi/kenai/jbosh/b;Lcom/xiaomi/kenai/jbosh/b;)Lcom/xiaomi/kenai/jbosh/ah;
    //   427: putfield 292	com/xiaomi/kenai/jbosh/s:t	Lcom/xiaomi/kenai/jbosh/ah;
    //   430: aload_0
    //   431: invokespecial 535	com/xiaomi/kenai/jbosh/s:m	()V
    //   434: aload_0
    //   435: getfield 292	com/xiaomi/kenai/jbosh/s:t	Lcom/xiaomi/kenai/jbosh/ah;
    //   438: astore 24
    //   440: aload_0
    //   441: aload 5
    //   443: iload 6
    //   445: invokespecial 537	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/b;I)V
    //   448: aload 5
    //   450: invokestatic 278	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/b;)Z
    //   453: ifeq +108 -> 561
    //   456: aload_0
    //   457: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   460: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   463: aload_0
    //   464: aconst_null
    //   465: invokespecial 503	com/xiaomi/kenai/jbosh/s:a	(Ljava/lang/Throwable;)V
    //   468: aload_0
    //   469: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   472: invokevirtual 489	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   475: ifeq +79 -> 554
    //   478: aload_0
    //   479: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   482: ifnull +43 -> 525
    //   485: aload_0
    //   486: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   489: invokeinterface 492 1 0
    //   494: ifeq +31 -> 525
    //   497: aload_0
    //   498: invokespecial 494	com/xiaomi/kenai/jbosh/s:g	()Z
    //   501: ifne +24 -> 525
    //   504: aload_0
    //   505: aload 11
    //   507: invokespecial 497	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/b;)J
    //   510: lstore 38
    //   512: lload 38
    //   514: lconst_0
    //   515: lcmp
    //   516: ifle +9 -> 525
    //   519: aload_0
    //   520: lload 38
    //   522: invokespecial 499	com/xiaomi/kenai/jbosh/s:a	(J)V
    //   525: aload_0
    //   526: getfield 144	com/xiaomi/kenai/jbosh/s:j	Ljava/util/concurrent/locks/Condition;
    //   529: invokeinterface 438 1 0
    //   534: aload_0
    //   535: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   538: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   541: return
    //   542: astore 37
    //   544: aload_0
    //   545: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   548: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   551: aload 37
    //   553: athrow
    //   554: ldc_w 530
    //   557: invokestatic 331	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   560: return
    //   561: aload 5
    //   563: invokestatic 539	com/xiaomi/kenai/jbosh/s:b	(Lcom/xiaomi/kenai/jbosh/b;)Z
    //   566: ifeq +457 -> 1023
    //   569: iconst_0
    //   570: ifne +677 -> 1247
    //   573: new 195	java/util/ArrayList
    //   576: dup
    //   577: aload_0
    //   578: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   581: invokeinterface 542 1 0
    //   586: invokespecial 545	java/util/ArrayList:<init>	(I)V
    //   589: astore 25
    //   591: aload_0
    //   592: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   595: invokeinterface 546 1 0
    //   600: astore 26
    //   602: aload 26
    //   604: invokeinterface 405 1 0
    //   609: ifeq +131 -> 740
    //   612: aload 25
    //   614: new 468	com/xiaomi/kenai/jbosh/ak
    //   617: dup
    //   618: aload 26
    //   620: invokeinterface 409 1 0
    //   625: checkcast 468	com/xiaomi/kenai/jbosh/ak
    //   628: invokevirtual 486	com/xiaomi/kenai/jbosh/ak:a	()Lcom/xiaomi/kenai/jbosh/b;
    //   631: invokespecial 548	com/xiaomi/kenai/jbosh/ak:<init>	(Lcom/xiaomi/kenai/jbosh/b;)V
    //   634: invokeinterface 549 2 0
    //   639: pop
    //   640: goto -38 -> 602
    //   643: astore 20
    //   645: ldc_w 551
    //   648: aload 20
    //   650: invokestatic 350	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   653: aload_0
    //   654: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   657: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   660: aload_0
    //   661: aload 20
    //   663: invokespecial 503	com/xiaomi/kenai/jbosh/s:a	(Ljava/lang/Throwable;)V
    //   666: aload_0
    //   667: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   670: invokevirtual 489	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   673: ifeq +527 -> 1200
    //   676: aload_0
    //   677: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   680: ifnull +43 -> 723
    //   683: aload_0
    //   684: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   687: invokeinterface 492 1 0
    //   692: ifeq +31 -> 723
    //   695: aload_0
    //   696: invokespecial 494	com/xiaomi/kenai/jbosh/s:g	()Z
    //   699: ifne +24 -> 723
    //   702: aload_0
    //   703: aload 11
    //   705: invokespecial 497	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/b;)J
    //   708: lstore 22
    //   710: lload 22
    //   712: lconst_0
    //   713: lcmp
    //   714: ifle +9 -> 723
    //   717: aload_0
    //   718: lload 22
    //   720: invokespecial 499	com/xiaomi/kenai/jbosh/s:a	(J)V
    //   723: aload_0
    //   724: getfield 144	com/xiaomi/kenai/jbosh/s:j	Ljava/util/concurrent/locks/Condition;
    //   727: invokeinterface 438 1 0
    //   732: aload_0
    //   733: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   736: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   739: return
    //   740: aload 25
    //   742: invokeinterface 400 1 0
    //   747: astore 27
    //   749: aload 27
    //   751: invokeinterface 405 1 0
    //   756: ifeq +117 -> 873
    //   759: aload_0
    //   760: aload 27
    //   762: invokeinterface 409 1 0
    //   767: checkcast 468	com/xiaomi/kenai/jbosh/ak
    //   770: invokespecial 553	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/ak;)V
    //   773: goto -24 -> 749
    //   776: astore 16
    //   778: ldc_w 551
    //   781: aload 16
    //   783: invokestatic 350	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   786: aload_0
    //   787: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   790: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   793: aload_0
    //   794: aload 16
    //   796: invokespecial 503	com/xiaomi/kenai/jbosh/s:a	(Ljava/lang/Throwable;)V
    //   799: aload_0
    //   800: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   803: invokevirtual 489	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   806: ifeq +413 -> 1219
    //   809: aload_0
    //   810: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   813: ifnull +43 -> 856
    //   816: aload_0
    //   817: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   820: invokeinterface 492 1 0
    //   825: ifeq +31 -> 856
    //   828: aload_0
    //   829: invokespecial 494	com/xiaomi/kenai/jbosh/s:g	()Z
    //   832: ifne +24 -> 856
    //   835: aload_0
    //   836: aload 11
    //   838: invokespecial 497	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/b;)J
    //   841: lstore 18
    //   843: lload 18
    //   845: lconst_0
    //   846: lcmp
    //   847: ifle +9 -> 856
    //   850: aload_0
    //   851: lload 18
    //   853: invokespecial 499	com/xiaomi/kenai/jbosh/s:a	(J)V
    //   856: aload_0
    //   857: getfield 144	com/xiaomi/kenai/jbosh/s:j	Ljava/util/concurrent/locks/Condition;
    //   860: invokeinterface 438 1 0
    //   865: aload_0
    //   866: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   869: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   872: return
    //   873: aload 25
    //   875: astore 28
    //   877: aload_0
    //   878: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   881: invokevirtual 489	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   884: ifeq +295 -> 1179
    //   887: aload_0
    //   888: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   891: ifnull +43 -> 934
    //   894: aload_0
    //   895: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   898: invokeinterface 492 1 0
    //   903: ifeq +31 -> 934
    //   906: aload_0
    //   907: invokespecial 494	com/xiaomi/kenai/jbosh/s:g	()Z
    //   910: ifne +24 -> 934
    //   913: aload_0
    //   914: aload 11
    //   916: invokespecial 497	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/b;)J
    //   919: lstore 32
    //   921: lload 32
    //   923: lconst_0
    //   924: lcmp
    //   925: ifle +9 -> 934
    //   928: aload_0
    //   929: lload 32
    //   931: invokespecial 499	com/xiaomi/kenai/jbosh/s:a	(J)V
    //   934: aload_0
    //   935: getfield 144	com/xiaomi/kenai/jbosh/s:j	Ljava/util/concurrent/locks/Condition;
    //   938: invokeinterface 438 1 0
    //   943: aload_0
    //   944: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   947: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   950: aload 28
    //   952: ifnull -751 -> 201
    //   955: aload 28
    //   957: invokeinterface 400 1 0
    //   962: astore 29
    //   964: aload 29
    //   966: invokeinterface 405 1 0
    //   971: ifeq -770 -> 201
    //   974: aload 29
    //   976: invokeinterface 409 1 0
    //   981: checkcast 468	com/xiaomi/kenai/jbosh/ak
    //   984: astore 30
    //   986: aload 30
    //   988: aload_0
    //   989: getfield 160	com/xiaomi/kenai/jbosh/s:o	Lcom/xiaomi/kenai/jbosh/am;
    //   992: aload 24
    //   994: aload 30
    //   996: invokevirtual 486	com/xiaomi/kenai/jbosh/ak:a	()Lcom/xiaomi/kenai/jbosh/b;
    //   999: aload_0
    //   1000: getfield 212	com/xiaomi/kenai/jbosh/s:A	Landroid/content/Context;
    //   1003: invokeinterface 556 4 0
    //   1008: invokevirtual 559	com/xiaomi/kenai/jbosh/ak:a	(Lcom/xiaomi/kenai/jbosh/al;)V
    //   1011: aload_0
    //   1012: aload 30
    //   1014: invokevirtual 486	com/xiaomi/kenai/jbosh/ak:a	()Lcom/xiaomi/kenai/jbosh/b;
    //   1017: invokespecial 561	com/xiaomi/kenai/jbosh/s:f	(Lcom/xiaomi/kenai/jbosh/b;)V
    //   1020: goto -56 -> 964
    //   1023: aload_0
    //   1024: aload 11
    //   1026: aload 5
    //   1028: invokespecial 563	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/b;Lcom/xiaomi/kenai/jbosh/b;)V
    //   1031: aload_0
    //   1032: aload 11
    //   1034: invokespecial 565	com/xiaomi/kenai/jbosh/s:d	(Lcom/xiaomi/kenai/jbosh/b;)V
    //   1037: aload_0
    //   1038: aload 5
    //   1040: invokespecial 568	com/xiaomi/kenai/jbosh/s:e	(Lcom/xiaomi/kenai/jbosh/b;)Lcom/xiaomi/kenai/jbosh/ak;
    //   1043: astore 35
    //   1045: aconst_null
    //   1046: astore 28
    //   1048: aload 35
    //   1050: ifnull -173 -> 877
    //   1053: aconst_null
    //   1054: astore 28
    //   1056: iconst_0
    //   1057: ifne -180 -> 877
    //   1060: new 195	java/util/ArrayList
    //   1063: dup
    //   1064: iconst_1
    //   1065: invokespecial 545	java/util/ArrayList:<init>	(I)V
    //   1068: astore 28
    //   1070: aload 28
    //   1072: aload 35
    //   1074: invokeinterface 549 2 0
    //   1079: pop
    //   1080: aload_0
    //   1081: aload 35
    //   1083: invokespecial 553	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/ak;)V
    //   1086: goto -209 -> 877
    //   1089: astore 12
    //   1091: aload_0
    //   1092: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   1095: invokevirtual 489	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   1098: ifeq +140 -> 1238
    //   1101: aload_0
    //   1102: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   1105: ifnull +43 -> 1148
    //   1108: aload_0
    //   1109: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   1112: invokeinterface 492 1 0
    //   1117: ifeq +31 -> 1148
    //   1120: aload_0
    //   1121: invokespecial 494	com/xiaomi/kenai/jbosh/s:g	()Z
    //   1124: ifne +24 -> 1148
    //   1127: aload_0
    //   1128: aload 11
    //   1130: invokespecial 497	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/b;)J
    //   1133: lstore 14
    //   1135: lload 14
    //   1137: lconst_0
    //   1138: lcmp
    //   1139: ifle +9 -> 1148
    //   1142: aload_0
    //   1143: lload 14
    //   1145: invokespecial 499	com/xiaomi/kenai/jbosh/s:a	(J)V
    //   1148: aload_0
    //   1149: getfield 144	com/xiaomi/kenai/jbosh/s:j	Ljava/util/concurrent/locks/Condition;
    //   1152: invokeinterface 438 1 0
    //   1157: aload_0
    //   1158: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   1161: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1164: aload 12
    //   1166: athrow
    //   1167: astore 31
    //   1169: aload_0
    //   1170: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   1173: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1176: aload 31
    //   1178: athrow
    //   1179: ldc_w 530
    //   1182: invokestatic 331	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   1185: goto -235 -> 950
    //   1188: astore 21
    //   1190: aload_0
    //   1191: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   1194: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1197: aload 21
    //   1199: athrow
    //   1200: ldc_w 530
    //   1203: invokestatic 331	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   1206: return
    //   1207: astore 17
    //   1209: aload_0
    //   1210: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   1213: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1216: aload 17
    //   1218: athrow
    //   1219: ldc_w 530
    //   1222: invokestatic 331	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   1225: return
    //   1226: astore 13
    //   1228: aload_0
    //   1229: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   1232: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1235: aload 13
    //   1237: athrow
    //   1238: ldc_w 530
    //   1241: invokestatic 331	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   1244: goto -80 -> 1164
    //   1247: aconst_null
    //   1248: astore 25
    //   1250: goto -659 -> 591
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1253	0	this	s
    //   0	1253	1	paramak	ak
    //   216	10	2	localInterruptedException1	java.lang.InterruptedException
    //   202	10	3	localaa1	aa
    //   8	28	4	localal	al
    //   17	1022	5	localb1	b
    //   26	418	6	i1	int
    //   381	10	7	localObject1	Object
    //   365	4	8	localInterruptedException2	java.lang.InterruptedException
    //   42	202	9	l1	long
    //   105	1024	11	localb2	b
    //   1089	76	12	localObject2	Object
    //   1226	10	13	localObject3	Object
    //   1133	11	14	l2	long
    //   776	19	16	localInterruptedException3	java.lang.InterruptedException
    //   1207	10	17	localObject4	Object
    //   841	11	18	l3	long
    //   643	19	20	localaa2	aa
    //   1188	10	21	localObject5	Object
    //   708	11	22	l4	long
    //   438	555	24	localah	ah
    //   589	660	25	localArrayList1	ArrayList
    //   600	19	26	localIterator1	Iterator
    //   747	14	27	localIterator2	Iterator
    //   875	196	28	localArrayList2	ArrayList
    //   962	13	29	localIterator3	Iterator
    //   984	29	30	localak1	ak
    //   1167	10	31	localObject6	Object
    //   919	11	32	l5	long
    //   1043	39	35	localak2	ak
    //   542	10	37	localObject7	Object
    //   510	11	38	l6	long
    //   393	10	40	localObject8	Object
    //   170	11	41	l7	long
    // Exception table:
    //   from	to	target	type
    //   4	28	202	com/xiaomi/kenai/jbosh/aa
    //   4	28	216	java/lang/InterruptedException
    //   35	59	365	java/lang/InterruptedException
    //   59	78	365	java/lang/InterruptedException
    //   78	88	365	java/lang/InterruptedException
    //   230	357	365	java/lang/InterruptedException
    //   35	59	381	finally
    //   59	78	381	finally
    //   78	88	381	finally
    //   230	357	381	finally
    //   367	373	381	finally
    //   138	172	393	finally
    //   179	185	393	finally
    //   185	194	393	finally
    //   478	512	542	finally
    //   519	525	542	finally
    //   525	534	542	finally
    //   114	128	643	com/xiaomi/kenai/jbosh/aa
    //   412	434	643	com/xiaomi/kenai/jbosh/aa
    //   434	468	643	com/xiaomi/kenai/jbosh/aa
    //   561	569	643	com/xiaomi/kenai/jbosh/aa
    //   573	591	643	com/xiaomi/kenai/jbosh/aa
    //   591	602	643	com/xiaomi/kenai/jbosh/aa
    //   602	640	643	com/xiaomi/kenai/jbosh/aa
    //   740	749	643	com/xiaomi/kenai/jbosh/aa
    //   749	773	643	com/xiaomi/kenai/jbosh/aa
    //   1023	1045	643	com/xiaomi/kenai/jbosh/aa
    //   1060	1086	643	com/xiaomi/kenai/jbosh/aa
    //   114	128	776	java/lang/InterruptedException
    //   412	434	776	java/lang/InterruptedException
    //   434	468	776	java/lang/InterruptedException
    //   561	569	776	java/lang/InterruptedException
    //   573	591	776	java/lang/InterruptedException
    //   591	602	776	java/lang/InterruptedException
    //   602	640	776	java/lang/InterruptedException
    //   740	749	776	java/lang/InterruptedException
    //   749	773	776	java/lang/InterruptedException
    //   1023	1045	776	java/lang/InterruptedException
    //   1060	1086	776	java/lang/InterruptedException
    //   114	128	1089	finally
    //   412	434	1089	finally
    //   434	468	1089	finally
    //   561	569	1089	finally
    //   573	591	1089	finally
    //   591	602	1089	finally
    //   602	640	1089	finally
    //   645	666	1089	finally
    //   740	749	1089	finally
    //   749	773	1089	finally
    //   778	799	1089	finally
    //   1023	1045	1089	finally
    //   1060	1086	1089	finally
    //   887	921	1167	finally
    //   928	934	1167	finally
    //   934	943	1167	finally
    //   676	710	1188	finally
    //   717	723	1188	finally
    //   723	732	1188	finally
    //   809	843	1207	finally
    //   850	856	1207	finally
    //   856	865	1207	finally
    //   1101	1135	1226	finally
    //   1142	1148	1226	finally
    //   1148	1157	1226	finally
  }
  
  private void b(Throwable paramThrowable)
  {
    l();
    Iterator localIterator = this.e.iterator();
    w localw = null;
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (localw == null) {
        localw = w.a(this, this.x, paramThrowable);
      }
      try
      {
        localx.a(localw);
      }
      catch (Exception localException)
      {
        com.xiaomi.channel.commonutils.logger.b.a("SMACK-BOSH:Unhandled Exception", localException);
      }
    }
  }
  
  private static boolean b(b paramb)
  {
    return "error".equals(paramb.a(r.x));
  }
  
  private long c(b paramb)
  {
    k();
    if ((this.t != null) && (this.t.e() != null)) {
      try
      {
        l locall = l.a(paramb.a(r.m));
        if (locall != null)
        {
          long l1 = locall.c() - c;
          if (l1 < 0L)
          {
            int i1 = b;
            l1 = i1;
          }
          return l1;
        }
      }
      catch (aa localaa)
      {
        com.xiaomi.channel.commonutils.logger.b.a("SMACK-BOSH: Could not extract", localaa);
      }
    }
    return i();
  }
  
  private void c()
  {
    l();
    this.h.lock();
    try
    {
      this.o.a(this.m);
      this.r = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      return;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  private void d(b paramb)
  {
    k();
    Long localLong1 = Long.valueOf(Long.parseLong(paramb.a(r.q)));
    if (this.w.equals(Long.valueOf(-1L))) {
      this.w = localLong1;
    }
    for (;;)
    {
      return;
      this.v.add(localLong1);
      for (Long localLong2 = Long.valueOf(1L + this.w.longValue()); (!this.v.isEmpty()) && (localLong2.equals(this.v.first())); localLong2 = Long.valueOf(1L + localLong2.longValue()))
      {
        this.w = localLong2;
        this.v.remove(localLong2);
      }
    }
  }
  
  private boolean d()
  {
    k();
    return this.r != null;
  }
  
  private ak e(b paramb)
  {
    Object localObject1 = null;
    k();
    String str = paramb.a(r.o);
    if (str == null) {
      return null;
    }
    Long localLong = Long.valueOf(Long.parseLong(str));
    Long.valueOf(Long.parseLong(paramb.a(r.v)));
    Iterator localIterator = this.x.iterator();
    Object localObject2;
    if ((localIterator.hasNext()) && (localObject1 == null))
    {
      localObject2 = (b)localIterator.next();
      if (!localLong.equals(Long.valueOf(Long.parseLong(((b)localObject2).a(r.q))))) {
        break label174;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      break;
      if (localObject1 == null) {
        throw new aa("Report of missing message with RID '" + str + "' but local copy of that request was not found");
      }
      ak localak = new ak(localObject1);
      a(localak);
      this.i.signalAll();
      return localak;
      label174:
      localObject2 = localObject1;
    }
  }
  
  private void e()
  {
    ak localak = f();
    if (localak == null) {
      return;
    }
    this.h.lock();
    try
    {
      long l1 = Long.valueOf(localak.a().a(r.q)).longValue();
      if (this.l == 0L) {
        this.l = l1;
      }
      this.h.unlock();
      b(localak);
      return;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  /* Error */
  private ak f()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 421	com/xiaomi/kenai/jbosh/s:l	()V
    //   4: aload_0
    //   5: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   8: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +12 -> 29
    //   20: aload_0
    //   21: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   24: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   27: aconst_null
    //   28: areturn
    //   29: aload_0
    //   30: getfield 178	com/xiaomi/kenai/jbosh/s:u	Ljava/util/Queue;
    //   33: invokeinterface 647 1 0
    //   38: checkcast 468	com/xiaomi/kenai/jbosh/ak
    //   41: astore_3
    //   42: aload_3
    //   43: ifnonnull +12 -> 55
    //   46: aload_0
    //   47: getfield 142	com/xiaomi/kenai/jbosh/s:i	Ljava/util/concurrent/locks/Condition;
    //   50: invokeinterface 649 1 0
    //   55: aload_3
    //   56: ifnull -45 -> 11
    //   59: aload_0
    //   60: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   66: aload_3
    //   67: areturn
    //   68: astore 4
    //   70: ldc_w 505
    //   73: aload 4
    //   75: invokestatic 350	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -23 -> 55
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 136	com/xiaomi/kenai/jbosh/s:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   86: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	s
    //   81	9	1	localObject	Object
    //   15	2	2	localQueue	Queue
    //   41	26	3	localak	ak
    //   68	6	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   46	55	68	java/lang/InterruptedException
    //   11	16	81	finally
    //   29	42	81	finally
    //   46	55	81	finally
    //   70	78	81	finally
  }
  
  private void f(b paramb)
  {
    l();
    Iterator localIterator = this.f.iterator();
    ab localab = null;
    while (localIterator.hasNext())
    {
      y localy = (y)localIterator.next();
      if (localab == null) {
        localab = ab.a(this, paramb);
      }
      try
      {
        localy.a(localab);
      }
      catch (Exception localException)
      {
        com.xiaomi.channel.commonutils.logger.b.a("SMACK-BOSH:Unhandled Exception", localException);
      }
    }
  }
  
  private void g(b paramb)
  {
    l();
    Iterator localIterator = this.g.iterator();
    ab localab = null;
    while (localIterator.hasNext())
    {
      z localz = (z)localIterator.next();
      if (localab == null) {
        localab = ab.b(this, paramb);
      }
      try
      {
        localz.a(localab);
      }
      catch (Exception localException)
      {
        com.xiaomi.channel.commonutils.logger.b.a("SMACK-BOSH:Unhandled Exception", localException);
      }
    }
  }
  
  private boolean g()
  {
    return ((this.s != null) && (!this.s.isDone())) || (this.y > 0L);
  }
  
  private void h()
  {
    k();
    if (this.s != null)
    {
      this.s.cancel(false);
      this.s = null;
    }
  }
  
  private long i()
  {
    k();
    m localm = this.t.d();
    long l1 = b;
    if (localm != null)
    {
      long l2 = localm.c();
      if (l2 > l1) {
        return l2;
      }
    }
    return l1;
  }
  
  private void j()
  {
    l();
    try
    {
      a(ai.a().a());
      return;
    }
    catch (aa localaa)
    {
      a(localaa);
    }
  }
  
  private void k()
  {
    if ((d) && (!this.h.isHeldByCurrentThread())) {
      throw new AssertionError("Lock is not held by current thread");
    }
  }
  
  private void l()
  {
    if ((d) && (this.h.isHeldByCurrentThread())) {
      throw new AssertionError("Lock is held by current thread");
    }
  }
  
  private void m()
  {
    boolean bool = this.h.isHeldByCurrentThread();
    if (bool) {
      this.h.unlock();
    }
    try
    {
      Iterator localIterator = this.e.iterator();
      Object localObject2 = null;
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if (localObject2 == null)
        {
          w localw = w.a(this);
          localObject2 = localw;
        }
        try
        {
          localx.a(localObject2);
        }
        catch (Exception localException)
        {
          com.xiaomi.channel.commonutils.logger.b.a("SMACK-BOSH:Unhandled Exception", localException);
        }
      }
      if (!bool) {
        return;
      }
    }
    finally
    {
      if (bool) {
        this.h.lock();
      }
    }
    this.h.lock();
  }
  
  private void n()
  {
    l();
    Iterator localIterator = this.e.iterator();
    w localw = null;
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (localw == null) {
        localw = w.b(this);
      }
      try
      {
        localx.a(localw);
      }
      catch (Exception localException)
      {
        com.xiaomi.channel.commonutils.logger.b.a("SMACK-BOSH:Unhandled Exception", localException);
      }
    }
  }
  
  public void a()
  {
    a(new aa("Session explicitly closed by caller"));
  }
  
  public void a(ai paramai)
  {
    l();
    if (paramai == null) {
      throw new IllegalArgumentException("Message body may not be null");
    }
    this.h.lock();
    try
    {
      if ((!d()) && (!a(paramai))) {
        throw new aa("Cannot send message when session is closed");
      }
    }
    finally
    {
      this.h.unlock();
    }
    long l1 = this.p.a();
    if (TextUtils.isEmpty(paramai.e())) {
      this.y = l1;
    }
    ah localah = this.t;
    ai localai;
    if ((localah == null) && (this.u.isEmpty())) {
      localai = a(l1, paramai);
    }
    for (;;)
    {
      ak localak = new ak(localai);
      a(localak);
      this.i.signalAll();
      h();
      this.h.unlock();
      b localb = localak.a();
      localak.a(this.o.a(localah, localb, this.A));
      f(localb);
      return;
      localai = b(l1, paramai);
      if (this.t.f()) {
        this.x.add(localai);
      }
    }
  }
  
  public void a(x paramx)
  {
    if (paramx == null) {
      throw new IllegalArgumentException("Listener may not be null");
    }
    this.e.add(paramx);
  }
  
  public void a(y paramy)
  {
    if (paramy == null) {
      throw new IllegalArgumentException("Listener may not be null");
    }
    this.f.add(paramy);
  }
  
  public void a(z paramz)
  {
    if (paramz == null) {
      throw new IllegalArgumentException("Listener may not be null");
    }
    this.g.add(paramz);
  }
  
  public void b()
  {
    if (this.r == null) {}
    do
    {
      return;
      if ((System.currentTimeMillis() - this.z > 30000L) && (this.r.getActiveCount() > 1))
      {
        a(new aa("SMACK-BOSH: request timeout happened, reset connection"));
        return;
      }
    } while ((this.r.getActiveCount() > 0) && (!g()));
    this.h.lock();
    try
    {
      a(0L);
      return;
    }
    finally
    {
      this.h.unlock();
    }
  }
  
  public void b(ai paramai)
  {
    if (paramai == null) {
      throw new IllegalArgumentException("Message body may not be null");
    }
    ai.a locala = paramai.b();
    locala.a(r.x, "terminate");
    a(locala.a());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.s
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */