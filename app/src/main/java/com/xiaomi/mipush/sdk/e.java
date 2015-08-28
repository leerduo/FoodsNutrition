package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ac;
import com.xiaomi.xmpush.thrift.k;
import com.xiaomi.xmpush.thrift.m;
import com.xiaomi.xmpush.thrift.t;
import com.xiaomi.xmpush.thrift.x;
import java.util.ArrayList;
import java.util.Iterator;

public class e
{
  private static e b;
  private static final ArrayList<e.a> e = new ArrayList();
  private boolean a = false;
  private Context c;
  private String d;
  private Intent f = null;
  private Integer g = null;
  
  private e(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.d = com.xiaomi.channel.commonutils.string.d.a(6);
    this.a = f();
  }
  
  public static e a(Context paramContext)
  {
    if (b == null) {
      b = new e(paramContext);
    }
    return b;
  }
  
  private final <T extends org.apache.thrift.b<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean1, boolean paramBoolean2, com.xiaomi.xmpush.thrift.d paramd)
  {
    if (!a.a(this.c).i())
    {
      if (paramBoolean2)
      {
        a(paramT, parama, paramBoolean1);
        return;
      }
      com.xiaomi.channel.commonutils.logger.b.a("drop the message before initialization.");
      return;
    }
    Intent localIntent = g();
    k localk = c.a(this.c, paramT, parama, paramBoolean1);
    if (paramd != null) {
      localk.a(paramd);
    }
    byte[] arrayOfByte = x.a(localk);
    if (arrayOfByte == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.SEND_MESSAGE");
    localIntent.putExtra("mipush_payload", arrayOfByte);
    this.c.startService(localIntent);
  }
  
  private boolean f()
  {
    PackageManager localPackageManager = this.c.getPackageManager();
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.xiaomi.xmsf", 4);
      if (localPackageInfo == null) {
        return false;
      }
      int i = localPackageInfo.versionCode;
      if (i >= 105) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private Intent g()
  {
    String str = this.c.getPackageName();
    if ((b()) && (!"com.xiaomi.xmsf".equals(str)))
    {
      Intent localIntent2 = new Intent();
      localIntent2.setPackage("com.xiaomi.xmsf");
      localIntent2.setClassName("com.xiaomi.xmsf", h());
      localIntent2.putExtra("mipush_app_package", str);
      i();
      return localIntent2;
    }
    j();
    Intent localIntent1 = new Intent(this.c, XMPushService.class);
    localIntent1.putExtra("mipush_app_package", str);
    return localIntent1;
  }
  
  private String h()
  {
    try
    {
      if (this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
        return "com.xiaomi.push.service.XMPushService";
      }
    }
    catch (Exception localException) {}
    return "com.xiaomi.xmsf.push.service.XMPushService";
  }
  
  private void i()
  {
    this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, XMPushService.class), 2, 1);
  }
  
  private void j()
  {
    this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, XMPushService.class), 1, 1);
  }
  
  public void a()
  {
    this.c.startService(g());
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    this.f = null;
    Intent localIntent = g();
    byte[] arrayOfByte = x.a(c.a(this.c, paramm, com.xiaomi.xmpush.thrift.a.a));
    if (arrayOfByte == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("register fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.REGISTER_APP");
    localIntent.putExtra("mipush_app_id", a.a(this.c).c());
    localIntent.putExtra("mipush_payload", arrayOfByte);
    localIntent.putExtra("mipush_session", this.d);
    localIntent.putExtra("mipush_env_chanage", paramBoolean);
    localIntent.putExtra("mipush_env_type", a.a(this.c).m());
    if ((com.xiaomi.channel.commonutils.network.a.d(this.c)) && (e()))
    {
      this.c.startService(localIntent);
      return;
    }
    this.f = localIntent;
  }
  
  public final void a(t paramt)
  {
    Intent localIntent = g();
    byte[] arrayOfByte = x.a(c.a(this.c, paramt, com.xiaomi.xmpush.thrift.a.b));
    if (arrayOfByte == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("unregister fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.UNREGISTER_APP");
    localIntent.putExtra("mipush_app_id", a.a(this.c).c());
    localIntent.putExtra("mipush_payload", arrayOfByte);
    this.c.startService(localIntent);
  }
  
  public final <T extends org.apache.thrift.b<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, com.xiaomi.xmpush.thrift.d paramd)
  {
    if (!parama.equals(com.xiaomi.xmpush.thrift.a.a)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramT, parama, bool, paramd);
      return;
    }
  }
  
  public <T extends org.apache.thrift.b<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean)
  {
    e.a locala = new e.a();
    locala.a = paramT;
    locala.b = parama;
    locala.c = paramBoolean;
    synchronized (e)
    {
      e.add(locala);
      if (e.size() > 10) {
        e.remove(0);
      }
      return;
    }
  }
  
  public final <T extends org.apache.thrift.b<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean, com.xiaomi.xmpush.thrift.d paramd)
  {
    a(paramT, parama, paramBoolean, true, paramd);
  }
  
  public boolean b()
  {
    return (this.a) && (1 == a.a(this.c).m());
  }
  
  public void c()
  {
    if (this.f != null)
    {
      this.c.startService(this.f);
      this.f = null;
    }
  }
  
  public void d()
  {
    synchronized (e)
    {
      Iterator localIterator = e.iterator();
      if (localIterator.hasNext())
      {
        e.a locala = (e.a)localIterator.next();
        a(locala.a, locala.b, locala.c, false, null);
      }
    }
    e.clear();
  }
  
  public boolean e()
  {
    if ((b()) && (ac.a(this.c).a())) {
      if (this.g == null)
      {
        this.g = Integer.valueOf(ac.a(this.c).b());
        if (this.g.intValue() == 0)
        {
          f localf = new f(this, new Handler(Looper.getMainLooper()));
          this.c.getContentResolver().registerContentObserver(ac.a(this.c).c(), false, localf);
        }
      }
    }
    return this.g.intValue() != 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */