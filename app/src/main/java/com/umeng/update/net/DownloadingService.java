package com.umeng.update.net;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DownloadingService
  extends Service
{
  private static final long C = 8000L;
  private static final long D = 500L;
  private static Map<a.a, Messenger> E = new HashMap();
  private static SparseArray<c.b> F = new SparseArray();
  private static Boolean I = Boolean.valueOf(false);
  static final int a = 1;
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  public static final int m = 6;
  public static final int n = 7;
  static final int o = 100;
  static final String p = "filename";
  public static boolean r = false;
  private static final String t = DownloadingService.class.getName();
  private static final long w = 104857600L;
  private static final long x = 10485760L;
  private static final long y = 259200000L;
  private static final int z = 3;
  private Context A;
  private Handler B;
  private e G;
  private boolean H = true;
  DownloadingService.a q;
  final Messenger s = new Messenger(new DownloadingService.c(this));
  private NotificationManager u;
  private c v;
  
  static
  {
    r = false;
  }
  
  private void a(a.a parama)
  {
    u.upd.b.c(t, "startDownload([mComponentName:" + parama.a + " mTitle:" + parama.b + " mUrl:" + parama.c + "])");
    int i1 = this.v.a(parama);
    DownloadingService.b localb = new DownloadingService.b(this, getApplicationContext(), parama, i1, 0, this.q);
    c.b localb1 = new c.b(parama, i1);
    this.G.a(i1);
    localb1.a(F);
    localb1.a = localb;
    localb.start();
    e();
    boolean bool = r;
    int i2 = 0;
    if (bool) {}
    for (;;)
    {
      if (i2 >= F.size()) {
        return;
      }
      c.b localb2 = (c.b)F.valueAt(i2);
      u.upd.b.c(t, "Running task " + localb2.e.b);
      i2++;
    }
  }
  
  private void a(String paramString)
  {
    synchronized (I)
    {
      if (!I.booleanValue())
      {
        u.upd.b.c(t, "show single toast.[" + paramString + "]");
        I = Boolean.valueOf(true);
        this.B.post(new DownloadingService.3(this, paramString));
        this.B.postDelayed(new DownloadingService.4(this), 1200L);
      }
      return;
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.G.a().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Integer localInteger = (Integer)localIterator.next();
      this.u.cancel(localInteger.intValue());
    }
  }
  
  private void e()
  {
    if (r)
    {
      int i1 = E.size();
      int i2 = F.size();
      u.upd.b.a(t, "Client size =" + i1 + "   cacheSize = " + i2);
      if (i1 != i2) {
        throw new RuntimeException("Client size =" + i1 + "   cacheSize = " + i2);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    u.upd.b.c(t, "onBind ");
    return this.s.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (r)
    {
      u.upd.b.a = true;
      Debug.waitForDebugger();
    }
    u.upd.b.c(t, "onCreate ");
    this.u = ((NotificationManager)getSystemService("notification"));
    this.A = this;
    this.G = new e(this.A);
    this.v = new c(F, E, this.G);
    this.B = new DownloadingService.1(this);
    this.q = new DownloadingService.2(this);
  }
  
  public void onDestroy()
  {
    try
    {
      b.a(getApplicationContext()).a(259200);
      b.a(getApplicationContext()).finalize();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        u.upd.b.b(t, localException.getMessage());
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      this.v.a(this, paramIntent);
    }
    if ((Build.VERSION.SDK_INT >= 19) && ((this.G.b()) || (this.H))) {}
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), getClass());
      localIntent.setPackage(getPackageName());
      PendingIntent localPendingIntent = PendingIntent.getService(getApplicationContext(), 1, localIntent, 1073741824);
      ((AlarmManager)getApplicationContext().getSystemService("alarm")).set(3, 5000L + SystemClock.elapsedRealtime(), localPendingIntent);
      label114:
      if (this.H)
      {
        d();
        this.H = false;
      }
      return 1;
    }
    catch (Exception localException)
    {
      break label114;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.DownloadingService
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */