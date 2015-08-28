package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class BitmapHunter
  implements Runnable
{
  private static final Object s = new Object();
  private static final ThreadLocal<StringBuilder> t = new BitmapHunter.1();
  private static final AtomicInteger u = new AtomicInteger();
  private static final RequestHandler v = new BitmapHunter.2();
  final int a = u.incrementAndGet();
  final Picasso b;
  final Dispatcher c;
  final Cache d;
  final Stats e;
  final String f;
  final Request g;
  final boolean h;
  final RequestHandler i;
  Action j;
  List<Action> k;
  Bitmap l;
  Future<?> m;
  Picasso.LoadedFrom n;
  Exception o;
  int p;
  int q;
  Picasso.Priority r;
  
  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, RequestHandler paramRequestHandler)
  {
    this.b = paramPicasso;
    this.c = paramDispatcher;
    this.d = paramCache;
    this.e = paramStats;
    this.j = paramAction;
    this.f = paramAction.e();
    this.g = paramAction.c();
    this.r = paramAction.i();
    this.h = paramAction.d;
    this.i = paramRequestHandler;
    this.q = paramRequestHandler.a();
  }
  
  static Bitmap a(Request paramRequest, Bitmap paramBitmap, int paramInt)
  {
    int i1 = 0;
    int i2 = paramBitmap.getWidth();
    int i3 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    int i7;
    int i8;
    int i5;
    int i4;
    int i6;
    label234:
    float f2;
    if (paramRequest.f())
    {
      i7 = paramRequest.h;
      i8 = paramRequest.i;
      float f1 = paramRequest.l;
      float f6;
      float f7;
      int i11;
      int i13;
      int i12;
      if (f1 != 0.0F)
      {
        if (paramRequest.o) {
          localMatrix.setRotate(f1, paramRequest.m, paramRequest.n);
        }
      }
      else
      {
        if (!paramRequest.j) {
          break label280;
        }
        f6 = i7 / i2;
        f7 = i8 / i3;
        if (f6 <= f7) {
          break label234;
        }
        i11 = (int)Math.ceil(i3 * (f7 / f6));
        int i16 = (i3 - i11) / 2;
        int i17 = i2;
        i13 = i16;
        i12 = i17;
      }
      for (;;)
      {
        localMatrix.preScale(f6, f6);
        int i14 = i11;
        i5 = i1;
        i4 = i14;
        int i15 = i13;
        i2 = i12;
        i6 = i15;
        if (paramInt != 0) {
          localMatrix.preRotate(paramInt);
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, i5, i6, i2, i4, localMatrix, true);
        if (localBitmap != paramBitmap)
        {
          paramBitmap.recycle();
          paramBitmap = localBitmap;
        }
        return paramBitmap;
        localMatrix.setRotate(f1);
        break;
        int i9 = (int)Math.ceil(i2 * (f6 / f7));
        int i10 = (i2 - i9) / 2;
        i11 = i3;
        i12 = i9;
        f6 = f7;
        i1 = i10;
        i13 = 0;
      }
      label280:
      if (paramRequest.k)
      {
        float f4 = i7 / i2;
        float f5 = i8 / i3;
        if (f4 < f5) {}
        for (;;)
        {
          localMatrix.preScale(f4, f4);
          i4 = i3;
          i5 = 0;
          i6 = 0;
          break;
          f4 = f5;
        }
      }
      if (((i7 != 0) || (i8 != 0)) && ((i7 != i2) || (i8 != i3)))
      {
        if (i7 == 0) {
          break label418;
        }
        f2 = i7 / i2;
        label381:
        if (i8 == 0) {
          break label430;
        }
      }
    }
    label418:
    label430:
    for (float f3 = i8 / i3;; f3 = i7 / i2)
    {
      localMatrix.preScale(f2, f3);
      i4 = i3;
      i5 = 0;
      i6 = 0;
      break;
      f2 = i8 / i3;
      break label381;
    }
  }
  
  static Bitmap a(List<Transformation> paramList, Bitmap paramBitmap)
  {
    int i1 = paramList.size();
    int i2 = 0;
    Bitmap localBitmap;
    for (Object localObject = paramBitmap; i2 < i1; localObject = localBitmap)
    {
      Transformation localTransformation = (Transformation)paramList.get(i2);
      try
      {
        localBitmap = localTransformation.a((Bitmap)localObject);
        if (localBitmap != null) {
          break label170;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("Transformation ").append(localTransformation.a()).append(" returned null after ").append(i2).append(" previous transformation(s).\n\nTransformation list:\n");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((Transformation)localIterator.next()).a()).append('\n');
        }
        Picasso.a.post(new BitmapHunter.4(localStringBuilder));
      }
      catch (RuntimeException localRuntimeException)
      {
        Picasso.a.post(new BitmapHunter.3(localTransformation, localRuntimeException));
        return null;
      }
      return null;
      label170:
      if ((localBitmap == localObject) && (((Bitmap)localObject).isRecycled()))
      {
        Picasso.a.post(new BitmapHunter.5(localTransformation));
        return null;
      }
      if ((localBitmap != localObject) && (!((Bitmap)localObject).isRecycled()))
      {
        Picasso.a.post(new BitmapHunter.6(localTransformation));
        return null;
      }
      i2++;
    }
    return localObject;
  }
  
  static BitmapHunter a(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    Request localRequest = paramAction.c();
    List localList = paramPicasso.a();
    int i1 = 0;
    int i2 = localList.size();
    while (i1 < i2)
    {
      RequestHandler localRequestHandler = (RequestHandler)localList.get(i1);
      if (localRequestHandler.a(localRequest)) {
        return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, localRequestHandler);
      }
      i1++;
    }
    return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, v);
  }
  
  static void a(Request paramRequest)
  {
    String str = paramRequest.c();
    StringBuilder localStringBuilder = (StringBuilder)t.get();
    localStringBuilder.ensureCapacity("Picasso-".length() + str.length());
    localStringBuilder.replace("Picasso-".length(), localStringBuilder.length(), str);
    Thread.currentThread().setName(localStringBuilder.toString());
  }
  
  private Picasso.Priority o()
  {
    int i1 = 1;
    int i2 = 0;
    Picasso.Priority localPriority = Picasso.Priority.a;
    int i3;
    label42:
    Object localObject1;
    if ((this.k != null) && (!this.k.isEmpty()))
    {
      i3 = i1;
      if ((this.j == null) && (i3 == 0)) {
        break label58;
      }
      if (i1 != 0) {
        break label63;
      }
      localObject1 = localPriority;
    }
    label142:
    label153:
    for (;;)
    {
      return localObject1;
      i3 = 0;
      break;
      label58:
      i1 = 0;
      break label42;
      label63:
      if (this.j != null) {}
      for (localObject1 = this.j.i();; localObject1 = localPriority)
      {
        if (i3 == 0) {
          break label153;
        }
        int i4 = this.k.size();
        label95:
        Object localObject2;
        if (i2 < i4)
        {
          localObject2 = ((Action)this.k.get(i2)).i();
          if (((Picasso.Priority)localObject2).ordinal() <= ((Picasso.Priority)localObject1).ordinal()) {
            break label142;
          }
        }
        for (;;)
        {
          i2++;
          localObject1 = localObject2;
          break label95;
          break;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  Bitmap a()
  {
    boolean bool1 = this.h;
    Bitmap localBitmap = null;
    if (!bool1)
    {
      localBitmap = this.d.a(this.f);
      if (localBitmap != null)
      {
        this.e.a();
        this.n = Picasso.LoadedFrom.a;
        if (this.b.k) {
          Utils.a("Hunter", "decoded", this.g.a(), "from cache");
        }
      }
    }
    for (;;)
    {
      return localBitmap;
      Request localRequest = this.g;
      boolean bool2;
      if (this.q == 0)
      {
        bool2 = true;
        localRequest.c = bool2;
        RequestHandler.Result localResult = this.i.b(this.g);
        if (localResult != null)
        {
          localBitmap = localResult.a();
          this.n = localResult.b();
          this.p = localResult.c();
        }
        if (localBitmap == null) {
          continue;
        }
        if (this.b.k) {
          Utils.a("Hunter", "decoded", this.g.a());
        }
        this.e.a(localBitmap);
        if ((!this.g.e()) && (this.p == 0)) {
          continue;
        }
      }
      synchronized (s)
      {
        if ((this.g.f()) || (this.p != 0))
        {
          localBitmap = a(this.g, localBitmap, this.p);
          if (this.b.k) {
            Utils.a("Hunter", "transformed", this.g.a());
          }
        }
        if (this.g.g())
        {
          localBitmap = a(this.g.g, localBitmap);
          if (this.b.k) {
            Utils.a("Hunter", "transformed", this.g.a(), "from custom transformations");
          }
        }
        if (localBitmap == null) {
          continue;
        }
        this.e.b(localBitmap);
        return localBitmap;
        bool2 = false;
      }
    }
  }
  
  void a(Action paramAction)
  {
    boolean bool = this.b.k;
    Request localRequest = paramAction.b;
    if (this.j == null)
    {
      this.j = paramAction;
      if (bool)
      {
        if ((this.k != null) && (!this.k.isEmpty())) {
          break label65;
        }
        Utils.a("Hunter", "joined", localRequest.a(), "to empty hunter");
      }
    }
    label65:
    Picasso.Priority localPriority;
    do
    {
      return;
      Utils.a("Hunter", "joined", localRequest.a(), Utils.a(this, "to "));
      return;
      if (this.k == null) {
        this.k = new ArrayList(3);
      }
      this.k.add(paramAction);
      if (bool) {
        Utils.a("Hunter", "joined", localRequest.a(), Utils.a(this, "to "));
      }
      localPriority = paramAction.i();
    } while (localPriority.ordinal() <= this.r.ordinal());
    this.r = localPriority;
  }
  
  boolean a(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    if (this.q > 0) {}
    for (int i1 = 1; i1 == 0; i1 = 0) {
      return false;
    }
    this.q = (-1 + this.q);
    return this.i.a(paramBoolean, paramNetworkInfo);
  }
  
  void b(Action paramAction)
  {
    boolean bool;
    if (this.j == paramAction)
    {
      this.j = null;
      bool = true;
    }
    for (;;)
    {
      if ((bool) && (paramAction.i() == this.r)) {
        this.r = o();
      }
      if (this.b.k) {
        Utils.a("Hunter", "removed", paramAction.b.a(), Utils.a(this, "from "));
      }
      return;
      List localList = this.k;
      bool = false;
      if (localList != null) {
        bool = this.k.remove(paramAction);
      }
    }
  }
  
  boolean b()
  {
    Action localAction = this.j;
    boolean bool1 = false;
    if (localAction == null) {
      if (this.k != null)
      {
        boolean bool3 = this.k.isEmpty();
        bool1 = false;
        if (!bool3) {}
      }
      else
      {
        Future localFuture = this.m;
        bool1 = false;
        if (localFuture != null)
        {
          boolean bool2 = this.m.cancel(false);
          bool1 = false;
          if (bool2) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  boolean c()
  {
    return (this.m != null) && (this.m.isCancelled());
  }
  
  boolean d()
  {
    return this.h;
  }
  
  boolean e()
  {
    return this.i.b();
  }
  
  Bitmap f()
  {
    return this.l;
  }
  
  String g()
  {
    return this.f;
  }
  
  Request h()
  {
    return this.g;
  }
  
  Action i()
  {
    return this.j;
  }
  
  Picasso j()
  {
    return this.b;
  }
  
  List<Action> k()
  {
    return this.k;
  }
  
  Exception l()
  {
    return this.o;
  }
  
  Picasso.LoadedFrom m()
  {
    return this.n;
  }
  
  Picasso.Priority n()
  {
    return this.r;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	com/squareup/picasso/BitmapHunter:g	Lcom/squareup/picasso/Request;
    //   4: invokestatic 450	com/squareup/picasso/BitmapHunter:a	(Lcom/squareup/picasso/Request;)V
    //   7: aload_0
    //   8: getfield 81	com/squareup/picasso/BitmapHunter:b	Lcom/squareup/picasso/Picasso;
    //   11: getfield 337	com/squareup/picasso/Picasso:k	Z
    //   14: ifeq +16 -> 30
    //   17: ldc_w 339
    //   20: ldc_w 452
    //   23: aload_0
    //   24: invokestatic 455	com/squareup/picasso/Utils:a	(Lcom/squareup/picasso/BitmapHunter;)Ljava/lang/String;
    //   27: invokestatic 368	com/squareup/picasso/Utils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual 456	com/squareup/picasso/BitmapHunter:a	()Landroid/graphics/Bitmap;
    //   35: putfield 434	com/squareup/picasso/BitmapHunter:l	Landroid/graphics/Bitmap;
    //   38: aload_0
    //   39: getfield 434	com/squareup/picasso/BitmapHunter:l	Landroid/graphics/Bitmap;
    //   42: ifnonnull +21 -> 63
    //   45: aload_0
    //   46: getfield 83	com/squareup/picasso/BitmapHunter:c	Lcom/squareup/picasso/Dispatcher;
    //   49: aload_0
    //   50: invokevirtual 461	com/squareup/picasso/Dispatcher:c	(Lcom/squareup/picasso/BitmapHunter;)V
    //   53: invokestatic 301	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: ldc_w 463
    //   59: invokevirtual 308	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   62: return
    //   63: aload_0
    //   64: getfield 83	com/squareup/picasso/BitmapHunter:c	Lcom/squareup/picasso/Dispatcher;
    //   67: aload_0
    //   68: invokevirtual 465	com/squareup/picasso/Dispatcher:a	(Lcom/squareup/picasso/BitmapHunter;)V
    //   71: goto -18 -> 53
    //   74: astore 6
    //   76: aload_0
    //   77: aload 6
    //   79: putfield 439	com/squareup/picasso/BitmapHunter:o	Ljava/lang/Exception;
    //   82: aload_0
    //   83: getfield 83	com/squareup/picasso/BitmapHunter:c	Lcom/squareup/picasso/Dispatcher;
    //   86: aload_0
    //   87: invokevirtual 461	com/squareup/picasso/Dispatcher:c	(Lcom/squareup/picasso/BitmapHunter;)V
    //   90: invokestatic 301	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   93: ldc_w 463
    //   96: invokevirtual 308	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   99: return
    //   100: astore 5
    //   102: aload_0
    //   103: aload 5
    //   105: putfield 439	com/squareup/picasso/BitmapHunter:o	Ljava/lang/Exception;
    //   108: aload_0
    //   109: getfield 83	com/squareup/picasso/BitmapHunter:c	Lcom/squareup/picasso/Dispatcher;
    //   112: aload_0
    //   113: invokevirtual 467	com/squareup/picasso/Dispatcher:b	(Lcom/squareup/picasso/BitmapHunter;)V
    //   116: invokestatic 301	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   119: ldc_w 463
    //   122: invokevirtual 308	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   125: return
    //   126: astore_3
    //   127: new 469	java/io/StringWriter
    //   130: dup
    //   131: invokespecial 470	java/io/StringWriter:<init>	()V
    //   134: astore 4
    //   136: aload_0
    //   137: getfield 87	com/squareup/picasso/BitmapHunter:e	Lcom/squareup/picasso/Stats;
    //   140: invokevirtual 473	com/squareup/picasso/Stats:e	()Lcom/squareup/picasso/StatsSnapshot;
    //   143: new 475	java/io/PrintWriter
    //   146: dup
    //   147: aload 4
    //   149: invokespecial 478	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   152: invokevirtual 483	com/squareup/picasso/StatsSnapshot:a	(Ljava/io/PrintWriter;)V
    //   155: aload_0
    //   156: new 183	java/lang/RuntimeException
    //   159: dup
    //   160: aload 4
    //   162: invokevirtual 484	java/io/StringWriter:toString	()Ljava/lang/String;
    //   165: aload_3
    //   166: invokespecial 487	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: putfield 439	com/squareup/picasso/BitmapHunter:o	Ljava/lang/Exception;
    //   172: aload_0
    //   173: getfield 83	com/squareup/picasso/BitmapHunter:c	Lcom/squareup/picasso/Dispatcher;
    //   176: aload_0
    //   177: invokevirtual 461	com/squareup/picasso/Dispatcher:c	(Lcom/squareup/picasso/BitmapHunter;)V
    //   180: invokestatic 301	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   183: ldc_w 463
    //   186: invokevirtual 308	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   189: return
    //   190: astore_2
    //   191: aload_0
    //   192: aload_2
    //   193: putfield 439	com/squareup/picasso/BitmapHunter:o	Ljava/lang/Exception;
    //   196: aload_0
    //   197: getfield 83	com/squareup/picasso/BitmapHunter:c	Lcom/squareup/picasso/Dispatcher;
    //   200: aload_0
    //   201: invokevirtual 461	com/squareup/picasso/Dispatcher:c	(Lcom/squareup/picasso/BitmapHunter;)V
    //   204: invokestatic 301	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   207: ldc_w 463
    //   210: invokevirtual 308	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   213: return
    //   214: astore_1
    //   215: invokestatic 301	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   218: ldc_w 463
    //   221: invokevirtual 308	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   224: aload_1
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	BitmapHunter
    //   214	11	1	localObject	Object
    //   190	3	2	localException	Exception
    //   126	40	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   134	27	4	localStringWriter	java.io.StringWriter
    //   100	4	5	localIOException	java.io.IOException
    //   74	4	6	localResponseException	Downloader.ResponseException
    // Exception table:
    //   from	to	target	type
    //   0	30	74	com/squareup/picasso/Downloader$ResponseException
    //   30	53	74	com/squareup/picasso/Downloader$ResponseException
    //   63	71	74	com/squareup/picasso/Downloader$ResponseException
    //   0	30	100	java/io/IOException
    //   30	53	100	java/io/IOException
    //   63	71	100	java/io/IOException
    //   0	30	126	java/lang/OutOfMemoryError
    //   30	53	126	java/lang/OutOfMemoryError
    //   63	71	126	java/lang/OutOfMemoryError
    //   0	30	190	java/lang/Exception
    //   30	53	190	java/lang/Exception
    //   63	71	190	java/lang/Exception
    //   0	30	214	finally
    //   30	53	214	finally
    //   63	71	214	finally
    //   76	90	214	finally
    //   102	116	214	finally
    //   127	180	214	finally
    //   191	204	214	finally
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.BitmapHunter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */