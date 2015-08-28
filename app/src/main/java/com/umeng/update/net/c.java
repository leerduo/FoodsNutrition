package com.umeng.update.net;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Messenger;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import u.upd.j;
import u.upd.k;
import u.upd.l;

class c
{
  static final int a = 0;
  static final int b = 1;
  static final int c = 1;
  static final int d = 2;
  private static final String e = c.class.getName();
  private SparseArray<c.b> f;
  private Map<a.a, Messenger> g;
  private e h;
  
  public c(SparseArray<c.b> paramSparseArray, Map<a.a, Messenger> paramMap, e parame)
  {
    this.f = paramSparseArray;
    this.g = paramMap;
    this.h = parame;
  }
  
  int a(a.a parama)
  {
    return Math.abs((int)((parama.b.hashCode() >> 2) + (parama.c.hashCode() >> 3) + System.currentTimeMillis()));
  }
  
  c.a a(Context paramContext, a.a parama, int paramInt1, int paramInt2)
  {
    Context localContext = paramContext.getApplicationContext();
    c.a locala = new c.a(localContext);
    PendingIntent localPendingIntent1 = PendingIntent.getActivity(localContext, 0, new Intent(), 134217728);
    locala.d(localContext.getString(l.j(localContext))).a(17301633).a(localPendingIntent1).a(System.currentTimeMillis());
    RemoteViews localRemoteViews = new RemoteViews(localContext.getPackageName(), k.a(localContext));
    if (Build.VERSION.SDK_INT >= 14)
    {
      int i1 = localContext.getResources().getDimensionPixelSize(17104901);
      int i2 = localContext.getResources().getDimensionPixelSize(17104902);
      localRemoteViews.setInt(j.b(localContext), "setWidth", i1);
      localRemoteViews.setInt(j.b(localContext), "setHeight", i2);
    }
    for (;;)
    {
      try
      {
        Field localField4 = Class.forName("com.android.internal.R$drawable").getDeclaredField("notify_panel_notification_icon_bg_tile");
        localField4.setAccessible(true);
        int i3 = localField4.getInt(null);
        localRemoteViews.setInt(j.b(localContext), "setBackgroundResource", i3);
        locala.a(localRemoteViews);
        locala.b(localContext.getResources().getString(l.g(localContext)) + parama.b).a(paramInt2 + "%").a(100, paramInt2, false);
        if (!parama.g) {
          break;
        }
        locala.b(localRemoteViews);
        locala.e();
        PendingIntent localPendingIntent2 = f.b(localContext, f.a(paramInt1, "continue"));
        PendingIntent localPendingIntent3 = f.b(localContext, f.a(paramInt1, "cancel"));
        a(localContext, locala, paramInt1, 2);
        locala.a(localPendingIntent2, localPendingIntent3).c().a(true).b(false);
        return locala;
      }
      catch (Exception localException3)
      {
        u.upd.b.a(e, "No notification icon background found:", localException3);
        continue;
      }
      try
      {
        Field localField3 = Class.forName("com.android.internal.R$drawable").getDeclaredField("status_bar_notification_icon_bg");
        localField3.setAccessible(true);
        int n = localField3.getInt(null);
        localRemoteViews.setInt(j.b(localContext), "setBackgroundResource", n);
      }
      catch (Exception localException1)
      {
        try
        {
          Class localClass = Class.forName("com.android.internal.R$dimen");
          Field localField1 = localClass.getDeclaredField("status_bar_edge_ignore");
          localField1.setAccessible(true);
          int i = localField1.getInt(null);
          int j = 0 + localContext.getResources().getDimensionPixelSize(i);
          Field localField2 = localClass.getDeclaredField("status_bar_height");
          localField2.setAccessible(true);
          int k = localField2.getInt(null);
          int m = j + localContext.getResources().getDimensionPixelSize(k) + localContext.getResources().getDimensionPixelSize(k);
          localRemoteViews.setInt(j.b(localContext), "setWidth", m);
        }
        catch (Exception localException2)
        {
          u.upd.b.a(e, "No notification size found:", localException2);
        }
      }
    }
    locala.a().a(true).b(false);
    return locala;
  }
  
  void a(Context paramContext, int paramInt)
  {
    Context localContext = paramContext.getApplicationContext();
    NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService("notification");
    c.b localb = (c.b)this.f.get(paramInt);
    localb.b.e();
    a(localContext, localb.b, paramInt, 1);
    localb.b.b(localContext.getResources().getString(l.h(localContext)) + localb.e.b).b().a(false).b(true);
    localNotificationManager.notify(paramInt, localb.b.d());
  }
  
  void a(Context paramContext, c.a parama, int paramInt1, int paramInt2)
  {
    PendingIntent localPendingIntent1;
    PendingIntent localPendingIntent2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localPendingIntent1 = f.b(paramContext, f.a(paramInt1, "continue"));
      localPendingIntent2 = f.b(paramContext, f.a(paramInt1, "cancel"));
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      parama.a(17301560, paramContext.getResources().getString(l.f(paramContext)), localPendingIntent2);
      return;
      parama.a(17301540, paramContext.getResources().getString(l.e(paramContext)), localPendingIntent1);
      continue;
      parama.a(17301539, paramContext.getResources().getString(l.d(paramContext)), localPendingIntent1);
    }
  }
  
  void a(a.a parama, long paramLong1, long paramLong2, long paramLong3)
  {
    if (parama.f != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("dsize", String.valueOf(paramLong1));
      localHashMap.put("dtime", u.upd.n.a().split(" ")[1]);
      boolean bool = paramLong2 < 0L;
      float f1 = 0.0F;
      if (bool) {
        f1 = (float)paramLong1 / (float)paramLong2;
      }
      localHashMap.put("dpcent", String.valueOf((int)(f1 * 100.0F)));
      localHashMap.put("ptimes", String.valueOf(paramLong3));
      a(localHashMap, false, parama.f);
    }
  }
  
  final void a(Map<String, String> paramMap, boolean paramBoolean, String[] paramArrayOfString)
  {
    new Thread(new c.1(this, paramArrayOfString, paramBoolean, paramMap)).start();
  }
  
  boolean a(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList == null) {
      return false;
    }
    String str = paramContext.getPackageName();
    Iterator localIterator = localList.iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.equals(str)));
    return true;
  }
  
  /* Error */
  boolean a(DownloadingService paramDownloadingService, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 408	com/umeng/update/net/DownloadingService:getApplicationContext	()Landroid/content/Context;
    //   4: astore 4
    //   6: aload_2
    //   7: invokevirtual 412	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   10: ldc_w 414
    //   13: invokevirtual 419	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: ldc_w 421
    //   19: invokevirtual 344	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   22: astore 5
    //   24: aload 5
    //   26: iconst_0
    //   27: aaload
    //   28: invokestatic 427	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   31: istore 6
    //   33: aload 5
    //   35: iconst_1
    //   36: aaload
    //   37: invokevirtual 430	java/lang/String:trim	()Ljava/lang/String;
    //   40: astore 7
    //   42: iload 6
    //   44: ifeq +246 -> 290
    //   47: aload 7
    //   49: invokestatic 436	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +238 -> 290
    //   55: aload_0
    //   56: getfield 38	com/umeng/update/net/c:f	Landroid/util/SparseArray;
    //   59: iload 6
    //   61: invokevirtual 439	android/util/SparseArray:indexOfKey	(I)I
    //   64: iflt +226 -> 290
    //   67: aload_0
    //   68: getfield 38	com/umeng/update/net/c:f	Landroid/util/SparseArray;
    //   71: iload 6
    //   73: invokevirtual 283	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   76: checkcast 285	com/umeng/update/net/c$b
    //   79: astore 8
    //   81: aload 8
    //   83: getfield 442	com/umeng/update/net/c$b:a	Lcom/umeng/update/net/DownloadingService$b;
    //   86: astore 9
    //   88: ldc 225
    //   90: aload 7
    //   92: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +308 -> 403
    //   98: aload 9
    //   100: ifnonnull +192 -> 292
    //   103: getstatic 32	com/umeng/update/net/c:e	Ljava/lang/String;
    //   106: ldc_w 444
    //   109: invokestatic 447	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload 4
    //   114: ldc_w 449
    //   117: invokestatic 454	u/upd/a:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   120: ifeq +38 -> 158
    //   123: aload 4
    //   125: invokestatic 456	u/upd/a:e	(Landroid/content/Context;)Z
    //   128: ifne +30 -> 158
    //   131: aload 4
    //   133: aload 4
    //   135: invokevirtual 138	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   138: aload 4
    //   140: invokevirtual 77	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   143: invokestatic 457	u/upd/l:a	(Landroid/content/Context;)I
    //   146: invokevirtual 189	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   149: iconst_1
    //   150: invokestatic 463	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   153: invokevirtual 466	android/widget/Toast:show	()V
    //   156: iconst_0
    //   157: ireturn
    //   158: aload_1
    //   159: invokevirtual 470	java/lang/Object:getClass	()Ljava/lang/Class;
    //   162: pop
    //   163: new 472	com/umeng/update/net/DownloadingService$b
    //   166: dup
    //   167: aload_1
    //   168: aload 4
    //   170: aload 8
    //   172: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   175: iload 6
    //   177: aload 8
    //   179: getfield 474	com/umeng/update/net/c$b:d	I
    //   182: aload_1
    //   183: getfield 478	com/umeng/update/net/DownloadingService:q	Lcom/umeng/update/net/DownloadingService$a;
    //   186: invokespecial 481	com/umeng/update/net/DownloadingService$b:<init>	(Lcom/umeng/update/net/DownloadingService;Landroid/content/Context;Lcom/umeng/update/net/a$a;IILcom/umeng/update/net/DownloadingService$a;)V
    //   189: astore 11
    //   191: aload 8
    //   193: aload 11
    //   195: putfield 442	com/umeng/update/net/c$b:a	Lcom/umeng/update/net/DownloadingService$b;
    //   198: aload 11
    //   200: invokevirtual 482	com/umeng/update/net/DownloadingService$b:start	()V
    //   203: invokestatic 488	android/os/Message:obtain	()Landroid/os/Message;
    //   206: astore 12
    //   208: aload 12
    //   210: iconst_2
    //   211: putfield 491	android/os/Message:what	I
    //   214: aload 12
    //   216: bipush 7
    //   218: putfield 494	android/os/Message:arg1	I
    //   221: aload 12
    //   223: iload 6
    //   225: putfield 497	android/os/Message:arg2	I
    //   228: aload_0
    //   229: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   232: aload 8
    //   234: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   237: invokeinterface 500 2 0
    //   242: ifnull +25 -> 267
    //   245: aload_0
    //   246: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   249: aload 8
    //   251: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   254: invokeinterface 500 2 0
    //   259: checkcast 502	android/os/Messenger
    //   262: aload 12
    //   264: invokevirtual 506	android/os/Messenger:send	(Landroid/os/Message;)V
    //   267: iconst_1
    //   268: ireturn
    //   269: astore 13
    //   271: getstatic 32	com/umeng/update/net/c:e	Ljava/lang/String;
    //   274: ldc_w 508
    //   277: aload 13
    //   279: invokestatic 510	u/upd/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   282: goto -15 -> 267
    //   285: astore_3
    //   286: aload_3
    //   287: invokevirtual 513	java/lang/Exception:printStackTrace	()V
    //   290: iconst_0
    //   291: ireturn
    //   292: getstatic 32	com/umeng/update/net/c:e	Ljava/lang/String;
    //   295: ldc_w 444
    //   298: invokestatic 447	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 9
    //   303: iconst_1
    //   304: invokevirtual 516	com/umeng/update/net/DownloadingService$b:a	(I)V
    //   307: aload 8
    //   309: aconst_null
    //   310: putfield 442	com/umeng/update/net/c$b:a	Lcom/umeng/update/net/DownloadingService$b;
    //   313: aload_0
    //   314: aload 4
    //   316: iload 6
    //   318: invokevirtual 518	com/umeng/update/net/c:a	(Landroid/content/Context;I)V
    //   321: invokestatic 488	android/os/Message:obtain	()Landroid/os/Message;
    //   324: astore 14
    //   326: aload 14
    //   328: iconst_2
    //   329: putfield 491	android/os/Message:what	I
    //   332: aload 14
    //   334: bipush 6
    //   336: putfield 494	android/os/Message:arg1	I
    //   339: aload 14
    //   341: iload 6
    //   343: putfield 497	android/os/Message:arg2	I
    //   346: aload_0
    //   347: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   350: aload 8
    //   352: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   355: invokeinterface 500 2 0
    //   360: ifnull +25 -> 385
    //   363: aload_0
    //   364: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   367: aload 8
    //   369: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   372: invokeinterface 500 2 0
    //   377: checkcast 502	android/os/Messenger
    //   380: aload 14
    //   382: invokevirtual 506	android/os/Messenger:send	(Landroid/os/Message;)V
    //   385: iconst_1
    //   386: ireturn
    //   387: astore 15
    //   389: getstatic 32	com/umeng/update/net/c:e	Ljava/lang/String;
    //   392: ldc_w 508
    //   395: aload 15
    //   397: invokestatic 510	u/upd/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   400: goto -15 -> 385
    //   403: ldc 235
    //   405: aload 7
    //   407: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   410: ifeq -120 -> 290
    //   413: getstatic 32	com/umeng/update/net/c:e	Ljava/lang/String;
    //   416: ldc_w 520
    //   419: invokestatic 447	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload 9
    //   424: ifnull +82 -> 506
    //   427: aload 9
    //   429: iconst_2
    //   430: invokevirtual 516	com/umeng/update/net/DownloadingService$b:a	(I)V
    //   433: invokestatic 488	android/os/Message:obtain	()Landroid/os/Message;
    //   436: astore 28
    //   438: aload 28
    //   440: iconst_5
    //   441: putfield 491	android/os/Message:what	I
    //   444: aload 28
    //   446: iconst_5
    //   447: putfield 494	android/os/Message:arg1	I
    //   450: aload 28
    //   452: iload 6
    //   454: putfield 497	android/os/Message:arg2	I
    //   457: aload_0
    //   458: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   461: aload 8
    //   463: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   466: invokeinterface 500 2 0
    //   471: ifnull +25 -> 496
    //   474: aload_0
    //   475: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   478: aload 8
    //   480: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   483: invokeinterface 500 2 0
    //   488: checkcast 502	android/os/Messenger
    //   491: aload 28
    //   493: invokevirtual 506	android/os/Messenger:send	(Landroid/os/Message;)V
    //   496: aload_0
    //   497: aload 4
    //   499: iload 6
    //   501: invokevirtual 522	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
    //   504: iconst_1
    //   505: ireturn
    //   506: aload 8
    //   508: getfield 525	com/umeng/update/net/c$b:f	[J
    //   511: iconst_0
    //   512: laload
    //   513: lstore 22
    //   515: aload 8
    //   517: getfield 525	com/umeng/update/net/c$b:f	[J
    //   520: iconst_1
    //   521: laload
    //   522: lstore 24
    //   524: aload 8
    //   526: getfield 525	com/umeng/update/net/c$b:f	[J
    //   529: iconst_2
    //   530: laload
    //   531: lstore 26
    //   533: aload_0
    //   534: aload 8
    //   536: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   539: lload 22
    //   541: lload 24
    //   543: lload 26
    //   545: invokevirtual 527	com/umeng/update/net/c:a	(Lcom/umeng/update/net/a$a;JJJ)V
    //   548: goto -115 -> 433
    //   551: astore 19
    //   553: invokestatic 488	android/os/Message:obtain	()Landroid/os/Message;
    //   556: astore 20
    //   558: aload 20
    //   560: iconst_5
    //   561: putfield 491	android/os/Message:what	I
    //   564: aload 20
    //   566: iconst_5
    //   567: putfield 494	android/os/Message:arg1	I
    //   570: aload 20
    //   572: iload 6
    //   574: putfield 497	android/os/Message:arg2	I
    //   577: aload_0
    //   578: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   581: aload 8
    //   583: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   586: invokeinterface 500 2 0
    //   591: ifnull +25 -> 616
    //   594: aload_0
    //   595: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   598: aload 8
    //   600: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   603: invokeinterface 500 2 0
    //   608: checkcast 502	android/os/Messenger
    //   611: aload 20
    //   613: invokevirtual 506	android/os/Messenger:send	(Landroid/os/Message;)V
    //   616: aload_0
    //   617: aload 4
    //   619: iload 6
    //   621: invokevirtual 522	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
    //   624: goto -120 -> 504
    //   627: astore 21
    //   629: aload_0
    //   630: aload 4
    //   632: iload 6
    //   634: invokevirtual 522	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
    //   637: goto -133 -> 504
    //   640: astore 16
    //   642: invokestatic 488	android/os/Message:obtain	()Landroid/os/Message;
    //   645: astore 17
    //   647: aload 17
    //   649: iconst_5
    //   650: putfield 491	android/os/Message:what	I
    //   653: aload 17
    //   655: iconst_5
    //   656: putfield 494	android/os/Message:arg1	I
    //   659: aload 17
    //   661: iload 6
    //   663: putfield 497	android/os/Message:arg2	I
    //   666: aload_0
    //   667: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   670: aload 8
    //   672: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   675: invokeinterface 500 2 0
    //   680: ifnull +25 -> 705
    //   683: aload_0
    //   684: getfield 40	com/umeng/update/net/c:g	Ljava/util/Map;
    //   687: aload 8
    //   689: getfield 293	com/umeng/update/net/c$b:e	Lcom/umeng/update/net/a$a;
    //   692: invokeinterface 500 2 0
    //   697: checkcast 502	android/os/Messenger
    //   700: aload 17
    //   702: invokevirtual 506	android/os/Messenger:send	(Landroid/os/Message;)V
    //   705: aload_0
    //   706: aload 4
    //   708: iload 6
    //   710: invokevirtual 522	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
    //   713: aload 16
    //   715: athrow
    //   716: astore 18
    //   718: aload_0
    //   719: aload 4
    //   721: iload 6
    //   723: invokevirtual 522	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
    //   726: goto -13 -> 713
    //   729: astore 29
    //   731: aload_0
    //   732: aload 4
    //   734: iload 6
    //   736: invokevirtual 522	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
    //   739: goto -235 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	this	c
    //   0	742	1	paramDownloadingService	DownloadingService
    //   0	742	2	paramIntent	Intent
    //   285	2	3	localException1	Exception
    //   4	729	4	localContext	Context
    //   22	12	5	arrayOfString	String[]
    //   31	704	6	i	int
    //   40	366	7	str	String
    //   79	609	8	localb	c.b
    //   86	342	9	localb1	DownloadingService.b
    //   189	10	11	localb2	DownloadingService.b
    //   206	57	12	localMessage1	android.os.Message
    //   269	9	13	localRemoteException1	android.os.RemoteException
    //   324	57	14	localMessage2	android.os.Message
    //   387	9	15	localRemoteException2	android.os.RemoteException
    //   640	74	16	localObject	Object
    //   645	56	17	localMessage3	android.os.Message
    //   716	1	18	localRemoteException3	android.os.RemoteException
    //   551	1	19	localException2	Exception
    //   556	56	20	localMessage4	android.os.Message
    //   627	1	21	localRemoteException4	android.os.RemoteException
    //   513	27	22	l1	long
    //   522	20	24	l2	long
    //   531	13	26	l3	long
    //   436	56	28	localMessage5	android.os.Message
    //   729	1	29	localRemoteException5	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   228	267	269	android/os/RemoteException
    //   0	42	285	java/lang/Exception
    //   47	98	285	java/lang/Exception
    //   103	156	285	java/lang/Exception
    //   158	228	285	java/lang/Exception
    //   228	267	285	java/lang/Exception
    //   271	282	285	java/lang/Exception
    //   292	346	285	java/lang/Exception
    //   346	385	285	java/lang/Exception
    //   389	400	285	java/lang/Exception
    //   403	422	285	java/lang/Exception
    //   433	457	285	java/lang/Exception
    //   457	496	285	java/lang/Exception
    //   496	504	285	java/lang/Exception
    //   553	577	285	java/lang/Exception
    //   577	616	285	java/lang/Exception
    //   616	624	285	java/lang/Exception
    //   629	637	285	java/lang/Exception
    //   642	666	285	java/lang/Exception
    //   666	705	285	java/lang/Exception
    //   705	713	285	java/lang/Exception
    //   713	716	285	java/lang/Exception
    //   718	726	285	java/lang/Exception
    //   731	739	285	java/lang/Exception
    //   346	385	387	android/os/RemoteException
    //   427	433	551	java/lang/Exception
    //   506	548	551	java/lang/Exception
    //   577	616	627	android/os/RemoteException
    //   616	624	627	android/os/RemoteException
    //   427	433	640	finally
    //   506	548	640	finally
    //   666	705	716	android/os/RemoteException
    //   705	713	716	android/os/RemoteException
    //   457	496	729	android/os/RemoteException
    //   496	504	729	android/os/RemoteException
  }
  
  boolean a(a.a parama, boolean paramBoolean, Messenger paramMessenger)
  {
    int i;
    Iterator localIterator2;
    if (paramBoolean)
    {
      i = new Random().nextInt(1000);
      if (this.g == null) {
        break label128;
      }
      localIterator2 = this.g.keySet().iterator();
      if (localIterator2.hasNext()) {
        break label61;
      }
    }
    for (;;)
    {
      if (this.g != null) {
        break label161;
      }
      return false;
      label61:
      a.a locala2 = (a.a)localIterator2.next();
      u.upd.b.c(e, "_" + i + " downling  " + locala2.b + "   " + locala2.c);
      break;
      label128:
      u.upd.b.c(e, "_" + i + "downling  null");
    }
    label161:
    Iterator localIterator1 = this.g.keySet().iterator();
    a.a locala1;
    do
    {
      if (!localIterator1.hasNext()) {
        return false;
      }
      locala1 = (a.a)localIterator1.next();
      if ((parama.e != null) && (parama.e.equals(locala1.e)))
      {
        this.g.put(locala1, paramMessenger);
        return true;
      }
    } while (!locala1.c.equals(parama.c));
    this.g.put(locala1, paramMessenger);
    return true;
  }
  
  int b(a.a parama)
  {
    for (int i = 0;; i++)
    {
      if (i >= this.f.size()) {
        return -1;
      }
      int j = this.f.keyAt(i);
      if ((parama.e != null) && (parama.e.equals(((c.b)this.f.get(j)).e.e))) {
        return ((c.b)this.f.get(j)).c;
      }
      if (((c.b)this.f.get(j)).e.c.equals(parama.c)) {
        return ((c.b)this.f.get(j)).c;
      }
    }
  }
  
  void b(Context paramContext, int paramInt)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getApplicationContext().getSystemService("notification");
    c.b localb = (c.b)this.f.get(paramInt);
    if (localb != null)
    {
      u.upd.b.c(e, "download service clear cache " + localb.e.b);
      if (localb.a != null) {
        localb.a.a(2);
      }
      localNotificationManager.cancel(localb.c);
      if (this.g.containsKey(localb.e)) {
        this.g.remove(localb.e);
      }
      localb.b(this.f);
      this.h.b(paramInt);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */