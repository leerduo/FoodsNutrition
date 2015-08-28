package com.xiaomi.push.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.kenai.jbosh.s;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.smack.n;
import com.xiaomi.smack.packet.f.b;
import com.xiaomi.smack.w;
import com.xiaomi.xmpush.thrift.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.e;

public class XMPushService
  extends Service
  implements com.xiaomi.smack.l
{
  public static int a = 1;
  private com.xiaomi.smack.k b;
  private com.xiaomi.smack.a c;
  private aa d;
  private long e = 0L;
  private com.xiaomi.smack.t f;
  private com.xiaomi.smack.b g;
  private com.xiaomi.smack.j h;
  private b i;
  private PacketSync j = null;
  private com.xiaomi.push.service.timers.a k = null;
  private d l = null;
  private n m = new ad(this);
  
  static
  {
    HostManager.a("app.chat.xiaomi.net", "58.68.235.232");
    HostManager.a("app.chat.xiaomi.net", "app01.nodes.gslb.mi-idc.com");
    HostManager.a("app.chat.xiaomi.net", "42.62.48.181");
    HostManager.a("app.chat.xiaomi.net", "223.202.68.46");
    HostManager.a("app.chat.xiaomi.net", "app02.nodes.gslb.mi-idc.com");
    com.xiaomi.smack.t.c = true;
    if ((com.xiaomi.channel.commonutils.misc.a.b) || (com.xiaomi.channel.commonutils.misc.a.e) || (com.xiaomi.channel.commonutils.misc.a.c) || (com.xiaomi.channel.commonutils.misc.a.g)) {
      com.xiaomi.channel.commonutils.logger.b.a(0);
    }
  }
  
  private v.b a(String paramString, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra(x.m);
    v.b localb = v.a().b(paramString, str);
    if (localb == null) {
      localb = new v.b(this);
    }
    localb.h = paramIntent.getStringExtra(x.n);
    localb.b = paramIntent.getStringExtra(x.m);
    localb.c = paramIntent.getStringExtra(x.p);
    localb.a = paramIntent.getStringExtra(x.v);
    localb.f = paramIntent.getStringExtra(x.t);
    localb.g = paramIntent.getStringExtra(x.u);
    localb.e = paramIntent.getBooleanExtra(x.s, false);
    localb.i = paramIntent.getStringExtra(x.r);
    localb.d = paramIntent.getStringExtra(x.q);
    localb.k = this.i;
    localb.l = getApplicationContext();
    v.a().a(localb);
    return localb;
  }
  
  private com.xiaomi.smack.packet.c a(com.xiaomi.smack.packet.c paramc, String paramString)
  {
    byte[] arrayOfByte = z.a(paramString, paramc.k());
    com.xiaomi.smack.packet.c localc = new com.xiaomi.smack.packet.c();
    localc.n(paramc.n());
    localc.m(paramc.m());
    localc.k(paramc.k());
    localc.l(paramc.l());
    localc.b(true);
    String str = z.a(arrayOfByte, com.xiaomi.smack.util.g.c(paramc.c()));
    com.xiaomi.smack.packet.a locala = new com.xiaomi.smack.packet.a("s", null, (String[])null, (String[])null);
    locala.b(str);
    localc.a(locala);
    return localc;
  }
  
  private com.xiaomi.smack.packet.d a(com.xiaomi.smack.packet.d paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    v localv = v.a();
    List localList = localv.b(paramString1);
    if (localList.isEmpty())
    {
      com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before sending a packet, pkg=" + paramString1);
      paramd = null;
    }
    v.b localb;
    do
    {
      return paramd;
      paramd.o(paramString1);
      String str = paramd.l();
      if (TextUtils.isEmpty(str))
      {
        str = (String)localList.get(0);
        paramd.l(str);
      }
      localb = localv.b(str, paramd.n());
      if (!f())
      {
        com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not connected, chid=" + str);
        break;
      }
      if ((localb == null) || (localb.m != v.c.c))
      {
        com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not opened, chid=" + str);
        break;
      }
      if (!TextUtils.equals(paramString2, localb.j))
      {
        com.xiaomi.channel.commonutils.logger.b.a("invalid session. " + paramString2);
        break;
      }
    } while ((!(paramd instanceof com.xiaomi.smack.packet.c)) || (!paramBoolean));
    return a((com.xiaomi.smack.packet.c)paramd, localb.i);
  }
  
  private String a(String paramString)
  {
    return "<iq to='" + paramString + "' id='0' chid='0' type='get'><ping xmlns='urn:xmpp:ping'>%1$s%2$s</ping></iq>";
  }
  
  private void a(Intent paramIntent)
  {
    if (!x.j.equals(paramIntent.getAction())) {}
    int n;
    int i1;
    int i2;
    String str1;
    String str2;
    do
    {
      return;
      n = paramIntent.getIntExtra(x.n, -1);
      i1 = paramIntent.getIntExtra("ext_stats_key", -1);
      i2 = paramIntent.getIntExtra("ext_stats_val", 0);
      str1 = paramIntent.getStringExtra("ext_stats_host");
      str2 = paramIntent.getStringExtra("ext_stats_magic");
    } while ((n <= 0) || (n >= 255) || (i1 == -1) || (!com.xiaomi.stats.b.a(n, i1, i2, str1, str2)));
    com.xiaomi.stats.b.a(n, i1, i2, str1);
  }
  
  private void a(String paramString, int paramInt)
  {
    Collection localCollection = v.a().c(paramString);
    if (localCollection != null)
    {
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        v.b localb = (v.b)localIterator.next();
        if (localb != null) {
          a(new XMPushService.l(this, localb, paramInt, null, null));
        }
      }
    }
    v.a().a(paramString);
  }
  
  private void j()
  {
    if (g.a(getApplicationContext()) != null)
    {
      v.b localb = g.a(getApplicationContext()).a(this);
      a(localb);
      v.a().a(localb);
      if (com.xiaomi.channel.commonutils.network.a.d(getApplicationContext())) {
        a(true);
      }
    }
  }
  
  private void k()
  {
    if (c())
    {
      if (!this.k.b()) {
        this.k.a(true);
      }
      return;
    }
    this.k.a();
  }
  
  private void l()
  {
    if ((this.h != null) && (this.h.i())) {
      com.xiaomi.channel.commonutils.logger.b.c("try to connect while connecting.");
    }
    for (;;)
    {
      return;
      if ((this.h != null) && (this.h.j()))
      {
        com.xiaomi.channel.commonutils.logger.b.c("try to connect while is connected.");
        return;
      }
      this.b.b(com.xiaomi.channel.commonutils.network.a.f(this));
      if (!this.f.r())
      {
        m();
        if ((this.h == null) || (this.h.o() == 2)) {
          n();
        }
      }
      while (this.h == null)
      {
        t.a();
        v.a().a(this);
        return;
        n();
        if ((this.h == null) || (this.h.o() == 2)) {
          m();
        }
      }
    }
  }
  
  private void m()
  {
    try
    {
      this.f.t();
      this.f.a(this.m, new an(this));
      this.h = this.f;
      return;
    }
    catch (w localw)
    {
      com.xiaomi.channel.commonutils.logger.b.a("fail to create xmpp connection", localw);
      this.f.a(new com.xiaomi.smack.packet.f(f.b.b), 3, localw);
    }
  }
  
  private void n()
  {
    try
    {
      Fallback localFallback = HostManager.a().a("mibind.chat.gslb.mi-idc.com");
      if (localFallback != null) {
        this.c.a(localFallback);
      }
      this.g.a();
      this.g.a(this.m, new ae(this));
      this.h = this.g;
      return;
    }
    catch (w localw)
    {
      com.xiaomi.channel.commonutils.logger.b.a("fail to create BOSH connection", localw);
      this.g.a(new com.xiaomi.smack.packet.f(f.b.b), 3, localw);
    }
  }
  
  public com.xiaomi.smack.packet.c a(com.xiaomi.xmpush.thrift.k paramk)
  {
    try
    {
      com.xiaomi.smack.packet.c localc = new com.xiaomi.smack.packet.c();
      localc.l("5");
      localc.m("xiaomi.com");
      localc.n(g.a(this).a);
      localc.b(true);
      localc.f("push");
      localc.o(paramk.f);
      String str1 = g.a(this).a;
      paramk.g.b = str1.substring(0, str1.indexOf("@"));
      paramk.g.d = str1.substring(1 + str1.indexOf("/"));
      byte[] arrayOfByte = com.xiaomi.xmpush.thrift.x.a(paramk);
      String str2 = String.valueOf(com.xiaomi.channel.commonutils.string.a.a(z.a(z.a(g.a(this).c, localc.k()), arrayOfByte)));
      com.xiaomi.smack.packet.a locala = new com.xiaomi.smack.packet.a("s", null, (String[])null, (String[])null);
      locala.b(str2);
      localc.a(locala);
      com.xiaomi.channel.commonutils.logger.b.a("try send mi push message. packagename:" + paramk.f + " action:" + paramk.a);
      return localc;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localNullPointerException);
    }
    return null;
  }
  
  public com.xiaomi.smack.packet.c a(byte[] paramArrayOfByte)
  {
    com.xiaomi.xmpush.thrift.k localk = new com.xiaomi.xmpush.thrift.k();
    try
    {
      com.xiaomi.xmpush.thrift.x.a(localk, paramArrayOfByte);
      com.xiaomi.smack.packet.c localc = a(localk);
      return localc;
    }
    catch (e locale)
    {
      com.xiaomi.channel.commonutils.logger.b.a(locale);
    }
    return null;
  }
  
  public com.xiaomi.smack.t a(com.xiaomi.smack.k paramk)
  {
    return new com.xiaomi.smack.t(this, paramk);
  }
  
  public com.xiaomi.xmpush.thrift.k a(String paramString1, String paramString2)
  {
    com.xiaomi.xmpush.thrift.l locall = new com.xiaomi.xmpush.thrift.l();
    locall.b(paramString2);
    locall.c("package uninstalled");
    locall.a(com.xiaomi.smack.packet.d.j());
    locall.a(false);
    return a(paramString1, paramString2, locall, com.xiaomi.xmpush.thrift.a.i);
  }
  
  public <T extends org.apache.thrift.b<T, ?>> com.xiaomi.xmpush.thrift.k a(String paramString1, String paramString2, T paramT, com.xiaomi.xmpush.thrift.a parama)
  {
    byte[] arrayOfByte = com.xiaomi.xmpush.thrift.x.a(paramT);
    com.xiaomi.xmpush.thrift.k localk = new com.xiaomi.xmpush.thrift.k();
    com.xiaomi.xmpush.thrift.g localg = new com.xiaomi.xmpush.thrift.g();
    localg.a = 5L;
    localg.b = "fakeid";
    localk.a(localg);
    localk.a(ByteBuffer.wrap(arrayOfByte));
    localk.a(parama);
    localk.c(true);
    localk.b(paramString1);
    localk.a(false);
    localk.a(paramString2);
    return localk;
  }
  
  public void a()
  {
    this.d.a();
    Iterator localIterator = v.a().b().iterator();
    while (localIterator.hasNext()) {
      a(new XMPushService.a(this, (v.b)localIterator.next()));
    }
  }
  
  public void a(int paramInt)
  {
    this.l.a(paramInt);
  }
  
  public void a(int paramInt, Exception paramException)
  {
    a(false);
  }
  
  public void a(XMPushService.e parame)
  {
    a(parame, 0L);
  }
  
  public void a(XMPushService.e parame, long paramLong)
  {
    this.l.a(parame, paramLong);
  }
  
  public void a(v.b paramb)
  {
    paramb.a(new al(this));
  }
  
  public void a(com.xiaomi.smack.packet.d paramd)
  {
    if (this.h != null)
    {
      this.h.a(paramd);
      return;
    }
    throw new w("try send msg while connection is null.");
  }
  
  public void a(Exception paramException)
  {
    a(false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    v.b localb = v.a().b(paramString1, paramString2);
    if (localb != null) {
      a(new XMPushService.l(this, localb, paramInt, paramString4, paramString3));
    }
    v.a().a(paramString1, paramString2);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.h != null)
    {
      com.xiaomi.smack.packet.c localc = a(paramArrayOfByte);
      if (localc != null)
      {
        this.h.a(localc);
        return;
      }
      j.a(this, paramString, paramArrayOfByte, 70000003, "not a valid message");
      return;
    }
    throw new w("try send msg while connection is null.");
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null)
    {
      j.a(this, paramString, paramArrayOfByte, 70000003, "null payload");
      com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
      return;
    }
    com.xiaomi.xmpush.thrift.k localk = new com.xiaomi.xmpush.thrift.k();
    try
    {
      com.xiaomi.xmpush.thrift.x.a(localk, paramArrayOfByte);
      if (localk.a == com.xiaomi.xmpush.thrift.a.a)
      {
        m localm = new m();
        try
        {
          com.xiaomi.xmpush.thrift.x.a(localm, localk.f());
          j.a(localk.j(), paramArrayOfByte);
          a(new i(this, localk.j(), localm.d(), localm.h(), paramArrayOfByte));
          return;
        }
        catch (e locale2)
        {
          com.xiaomi.channel.commonutils.logger.b.a(locale2);
          j.a(this, paramString, paramArrayOfByte, 70000003, " data action error.");
          return;
        }
      }
      j.a(this, paramString, paramArrayOfByte, 70000003, " registration action required.");
    }
    catch (e locale1)
    {
      com.xiaomi.channel.commonutils.logger.b.a(locale1);
      j.a(this, paramString, paramArrayOfByte, 70000003, " data container error.");
      return;
    }
    com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
  }
  
  public void a(com.xiaomi.smack.packet.d[] paramArrayOfd)
  {
    if (this.h != null)
    {
      this.h.a(paramArrayOfd);
      return;
    }
    throw new w("try send msg while connection is null.");
  }
  
  public void b()
  {
    com.xiaomi.channel.commonutils.logger.b.b("begin to connect...");
  }
  
  public void b(int paramInt, Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("disconnect ").append(hashCode()).append(", ");
    if (this.h == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(this.h.hashCode()))
    {
      com.xiaomi.channel.commonutils.logger.b.a(localObject);
      if (this.h != null)
      {
        this.h.a(new com.xiaomi.smack.packet.f(f.b.b), paramInt, paramException);
        this.h = null;
      }
      a(7);
      a(4);
      v.a().a(this, paramInt);
      return;
    }
  }
  
  public void b(XMPushService.e parame)
  {
    this.l.a(parame.d, parame);
  }
  
  public void b(v.b paramb)
  {
    if (paramb != null)
    {
      long l1 = paramb.a();
      com.xiaomi.channel.commonutils.logger.b.a("schedule rebind job in " + l1 / 1000L);
      a(new XMPushService.a(this, paramb), l1);
    }
  }
  
  public void b(com.xiaomi.xmpush.thrift.k paramk)
  {
    if (this.h != null)
    {
      com.xiaomi.smack.packet.c localc = a(paramk);
      if (localc != null) {
        this.h.a(localc);
      }
      return;
    }
    throw new w("try send msg while connection is null.");
  }
  
  public boolean b(int paramInt)
  {
    return this.l.b(paramInt);
  }
  
  public boolean c()
  {
    return (com.xiaomi.channel.commonutils.network.a.d(this)) && (v.a().c() > 0);
  }
  
  public b d()
  {
    return new b();
  }
  
  public b e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    return (this.h != null) && (this.h.j());
  }
  
  public boolean g()
  {
    return (this.h != null) && (this.h.i());
  }
  
  public com.xiaomi.smack.j h()
  {
    return this.h;
  }
  
  public void i()
  {
    a(new af(this, 10), 120000L);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return new XMPushService.g(this);
  }
  
  public void onCreate()
  {
    super.onCreate();
    f localf = g.a(this);
    if (localf != null) {
      com.xiaomi.channel.commonutils.misc.a.a(localf.g);
    }
    HostManager.a(this, null, null, "0", "push", "2.1");
    this.b = new com.xiaomi.smack.k(null, 5222, "xiaomi.com", null);
    this.b.a(true);
    this.f = a(this.b);
    this.f.b(a("xiaomi.com"));
    this.c = new com.xiaomi.smack.a(false, new Fallback("mibind.chat.gslb.mi-idc.com"), 80, "mibind/http-bind", "xiaomi.com", null);
    System.setProperty(s.class.getName() + ".emptyRequestDelay", String.valueOf(1000));
    this.g = new com.xiaomi.smack.b(this, this.c);
    this.i = d();
    this.i.a(this);
    this.k = new com.xiaomi.push.service.timers.a(this);
    this.f.a(this);
    this.g.a(this);
    this.j = new PacketSync(this);
    this.d = new aa(this);
    new c().a();
    this.l = new d("Connection Controller Thread");
    this.l.start();
    a(new ag(this, 11));
    v localv = v.a();
    localv.e();
    localv.a(new ah(this));
  }
  
  public void onDestroy()
  {
    this.l.a();
    a(new am(this, 2));
    a(new XMPushService.f(this));
    v.a().e();
    v.a().a(this, 15);
    v.a().d();
    this.f.b(this);
    this.g.b(this);
    this.k.a();
    super.onDestroy();
    com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    int n = 1;
    int i2 = 0;
    if (paramIntent == null) {
      com.xiaomi.channel.commonutils.logger.b.c("onStart() with intent NULL");
    }
    v localv;
    String str1;
    String str2;
    for (;;)
    {
      localv = v.a();
      if ((paramIntent != null) && (paramIntent.getAction() != null))
      {
        if ((!x.a.equalsIgnoreCase(paramIntent.getAction())) && (!x.g.equalsIgnoreCase(paramIntent.getAction()))) {
          break label358;
        }
        str1 = paramIntent.getStringExtra(x.n);
        str2 = paramIntent.getStringExtra(x.y);
        if (!TextUtils.isEmpty(paramIntent.getStringExtra(x.r))) {
          break;
        }
        com.xiaomi.channel.commonutils.logger.b.a("security is empty. ignore.");
      }
      return;
      com.xiaomi.channel.commonutils.logger.b.b("onStart() with intent.Action = " + paramIntent.getAction());
    }
    v.b localb1;
    if (str1 != null)
    {
      localb1 = a(str1, paramIntent);
      if ((TextUtils.isEmpty(localb1.j)) || (TextUtils.equals(str2, localb1.j))) {
        break label2305;
      }
      com.xiaomi.channel.commonutils.logger.b.a("session changed. old session=" + localb1.j + ", new session=" + str2);
    }
    label358:
    int i4;
    label2305:
    for (int i3 = n;; i4 = 0) {
      for (;;)
      {
        localb1.j = str2;
        if (!com.xiaomi.channel.commonutils.network.a.d(this))
        {
          this.i.a(this, localb1, false, 2, null);
          return;
        }
        if (f())
        {
          if (i3 != 0)
          {
            a(new XMPushService.j(this, localb1));
            return;
          }
          if (localb1.m == v.c.b)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = localb1.h;
            arrayOfObject[n] = localb1.b;
            com.xiaomi.channel.commonutils.logger.b.a(String.format("the client is binding. %1$s %2$s.", arrayOfObject));
            return;
          }
          if (localb1.m == v.c.c)
          {
            this.i.a(this, localb1, n, 0, null);
            return;
          }
          a(new XMPushService.a(this, localb1));
          return;
        }
        a(n);
        return;
        com.xiaomi.channel.commonutils.logger.b.c("channel id is empty, do nothing!");
        return;
        if (x.f.equalsIgnoreCase(paramIntent.getAction()))
        {
          String str23 = paramIntent.getStringExtra(x.v);
          String str24 = paramIntent.getStringExtra(x.n);
          String str25 = paramIntent.getStringExtra(x.m);
          if (TextUtils.isEmpty(str24))
          {
            Iterator localIterator = localv.b(str23).iterator();
            while (localIterator.hasNext()) {
              a((String)localIterator.next(), 2);
            }
            break;
          }
          if (TextUtils.isEmpty(str25))
          {
            a(str24, 2);
            return;
          }
          a(str24, str25, 2, null, null);
          return;
        }
        if (x.b.equalsIgnoreCase(paramIntent.getAction()))
        {
          String str21 = paramIntent.getStringExtra(x.v);
          String str22 = paramIntent.getStringExtra(x.y);
          Bundle localBundle = paramIntent.getBundleExtra("ext_packet");
          boolean bool4 = paramIntent.getBooleanExtra("ext_encrypt", n);
          com.xiaomi.smack.packet.d locald = a(new com.xiaomi.smack.packet.c(localBundle), str21, str22, bool4);
          if (locald == null) {
            break;
          }
          a(new ab(this, locald));
          return;
        }
        if (x.d.equalsIgnoreCase(paramIntent.getAction()))
        {
          String str19 = paramIntent.getStringExtra(x.v);
          String str20 = paramIntent.getStringExtra(x.y);
          Parcelable[] arrayOfParcelable = paramIntent.getParcelableArrayExtra("ext_packets");
          com.xiaomi.smack.packet.c[] arrayOfc = new com.xiaomi.smack.packet.c[arrayOfParcelable.length];
          boolean bool3 = paramIntent.getBooleanExtra("ext_encrypt", n);
          for (;;)
          {
            if (i2 >= arrayOfParcelable.length) {
              break label690;
            }
            arrayOfc[i2] = new com.xiaomi.smack.packet.c((Bundle)arrayOfParcelable[i2]);
            arrayOfc[i2] = ((com.xiaomi.smack.packet.c)a(arrayOfc[i2], str19, str20, bool3));
            if (arrayOfc[i2] == null) {
              break;
            }
            i2++;
          }
          label690:
          a(new a(this, arrayOfc));
          return;
        }
        if (x.c.equalsIgnoreCase(paramIntent.getAction()))
        {
          String str17 = paramIntent.getStringExtra(x.v);
          String str18 = paramIntent.getStringExtra(x.y);
          com.xiaomi.smack.packet.b localb = new com.xiaomi.smack.packet.b(paramIntent.getBundleExtra("ext_packet"));
          if (a(localb, str17, str18, false) == null) {
            break;
          }
          a(new ab(this, localb));
          return;
        }
        if (x.e.equalsIgnoreCase(paramIntent.getAction()))
        {
          String str15 = paramIntent.getStringExtra(x.v);
          String str16 = paramIntent.getStringExtra(x.y);
          com.xiaomi.smack.packet.f localf = new com.xiaomi.smack.packet.f(paramIntent.getBundleExtra("ext_packet"));
          if (a(localf, str15, str16, false) == null) {
            break;
          }
          a(new ab(this, localf));
          return;
        }
        if (("com.xiaomi.push.timer".equalsIgnoreCase(paramIntent.getAction())) || ("com.xiaomi.push.check_alive".equalsIgnoreCase(paramIntent.getAction())))
        {
          if ("com.xiaomi.push.timer".equalsIgnoreCase(paramIntent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("Service called on timer");
          }
          for (;;)
          {
            if (!this.l.b()) {
              break label963;
            }
            com.xiaomi.channel.commonutils.logger.b.c("ERROR, the job controller is blocked.");
            v.a().a(this, 14);
            stopSelf();
            return;
            if (System.currentTimeMillis() - this.e < 30000L) {
              break;
            }
            this.e = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.a("Service called on check alive.");
          }
          label963:
          if (!f())
          {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(paramIntent.getAction()))
            {
              a(false);
              return;
            }
            a(n);
            return;
          }
          if (this.h.q())
          {
            a(new XMPushService.i(this));
            return;
          }
          a(new XMPushService.d(this, 17, null));
          return;
        }
        if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(paramIntent.getAction())) {
          try
          {
            NetworkInfo localNetworkInfo2 = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
            localNetworkInfo1 = localNetworkInfo2;
            if (localNetworkInfo1 != null)
            {
              com.xiaomi.channel.commonutils.logger.b.a("network changed, " + localNetworkInfo1.toString());
              this.f.s();
              this.g.s();
              if (!com.xiaomi.channel.commonutils.network.a.d(this)) {
                break label1180;
              }
              if ((!f()) && (!g()))
              {
                this.l.a(n);
                a(new XMPushService.c(this));
              }
              k();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.xiaomi.channel.commonutils.logger.b.a(localException);
              NetworkInfo localNetworkInfo1 = null;
              continue;
              com.xiaomi.channel.commonutils.logger.b.a("network changed, no active network");
              continue;
              label1180:
              a(new XMPushService.d(this, 2, null));
            }
          }
        }
        if (x.h.equals(paramIntent.getAction()))
        {
          String str14 = paramIntent.getStringExtra(x.n);
          if (str14 != null) {
            a(str14, paramIntent).j = paramIntent.getStringExtra(x.y);
          }
          a(new XMPushService.k(this));
          return;
        }
        if (x.i.equals(paramIntent.getAction()))
        {
          String str11 = paramIntent.getStringExtra(x.v);
          List localList = localv.b(str11);
          if (localList.isEmpty())
          {
            com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before update info, pkg=" + str11);
            return;
          }
          String str12 = paramIntent.getStringExtra(x.n);
          String str13 = paramIntent.getStringExtra(x.m);
          if (TextUtils.isEmpty(str12)) {
            str12 = (String)localList.get(0);
          }
          Collection localCollection2;
          if (TextUtils.isEmpty(str13))
          {
            localCollection2 = localv.c(str12);
            localb2 = null;
            if (localCollection2 != null)
            {
              boolean bool2 = localCollection2.isEmpty();
              localb2 = null;
              if (bool2) {}
            }
          }
          for (v.b localb2 = (v.b)localCollection2.iterator().next();; localb2 = localv.b(str12, str13))
          {
            if (localb2 == null) {
              break label1480;
            }
            if (paramIntent.hasExtra(x.t)) {
              localb2.f = paramIntent.getStringExtra(x.t);
            }
            if (!paramIntent.hasExtra(x.u)) {
              break;
            }
            localb2.g = paramIntent.getStringExtra(x.u);
            return;
          }
          label1480:
          break;
        }
        if ("com.xiaomi.mipush.REGISTER_APP".equals(paramIntent.getAction()))
        {
          if ((ac.a(getApplicationContext()).a()) && (ac.a(getApplicationContext()).b() == 0))
          {
            com.xiaomi.channel.commonutils.logger.b.a("register without being provisioned. " + paramIntent.getStringExtra("mipush_app_package"));
            return;
          }
          byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("mipush_payload");
          String str10 = paramIntent.getStringExtra("mipush_app_package");
          boolean bool1 = paramIntent.getBooleanExtra("mipush_env_chanage", false);
          int i7 = paramIntent.getIntExtra("mipush_env_type", n);
          h.a(this).c(str10);
          if ((bool1) && (!"com.xiaomi.xmsf".equals(getPackageName())))
          {
            a(new ai(this, 14, i7, arrayOfByte2, str10));
            return;
          }
          a(arrayOfByte2, str10);
          return;
        }
        if (("com.xiaomi.mipush.SEND_MESSAGE".equals(paramIntent.getAction())) || ("com.xiaomi.mipush.UNREGISTER_APP".equals(paramIntent.getAction())))
        {
          String str3 = paramIntent.getStringExtra("mipush_app_package");
          byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("mipush_payload");
          Collection localCollection1 = v.a().c("5");
          if ("com.xiaomi.mipush.UNREGISTER_APP".equals(paramIntent.getAction())) {
            h.a(this).b(str3);
          }
          if (localCollection1.isEmpty())
          {
            j.b(str3, arrayOfByte1);
            return;
          }
          if (((v.b)localCollection1.iterator().next()).m != v.c.c)
          {
            j.b(str3, arrayOfByte1);
            return;
          }
          a(new aj(this, 4, str3, arrayOfByte1));
          return;
        }
        String str8;
        if (y.a.equals(paramIntent.getAction()))
        {
          str8 = paramIntent.getStringExtra("com.xiaomi.xmsf");
          if ((str8 == null) || (TextUtils.isEmpty(str8.trim()))) {
            break;
          }
        }
        try
        {
          getPackageManager().getPackageInfo(str8, 256);
          int i1 = 0;
          label1844:
          if (("com.xiaomi.channel".equals(str8)) && (!v.a().c("1").isEmpty()) && (i1 != 0))
          {
            a("1", 0);
            com.xiaomi.channel.commonutils.logger.b.a("close the miliao channel as the app is uninstalled.");
            return;
          }
          SharedPreferences localSharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
          if ((!localSharedPreferences.contains(str8)) || (i1 == 0)) {
            break;
          }
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          localEditor.remove(str8);
          localEditor.commit();
          if (!f()) {
            break;
          }
          String str9 = localSharedPreferences.getString(str8, null);
          if (str9 == null) {
            break;
          }
          try
          {
            b(a(str8, str9));
            com.xiaomi.channel.commonutils.logger.b.a("\"uninstall " + str8 + "\" msg sent");
            return;
          }
          catch (w localw)
          {
            com.xiaomi.channel.commonutils.logger.b.c("Fail to send Message: " + localw.getMessage());
            b(10, localw);
            return;
          }
          if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(paramIntent.getAction()))
          {
            String str7 = paramIntent.getStringExtra(x.v);
            int i6 = paramIntent.getIntExtra(x.w, 0);
            if (TextUtils.isEmpty(str7)) {
              break;
            }
            if (i6 >= 0)
            {
              r.a(this, str7, i6);
              return;
            }
            if (i6 != -1) {
              break;
            }
            r.b(this, str7);
            return;
          }
          if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(paramIntent.getAction()))
          {
            String str4 = paramIntent.getStringExtra(x.v);
            String str5 = paramIntent.getStringExtra(x.z);
            int i5;
            String str6;
            if (paramIntent.hasExtra(x.x))
            {
              i5 = paramIntent.getIntExtra(x.x, 0);
              str6 = com.xiaomi.channel.commonutils.string.c.b(str4 + i5);
            }
            while ((TextUtils.isEmpty(str4)) || (!TextUtils.equals(str5, str6)))
            {
              com.xiaomi.channel.commonutils.logger.b.c("invalid notification for " + str4);
              return;
              str6 = com.xiaomi.channel.commonutils.string.c.b(str4);
              i2 = i1;
              i5 = 0;
            }
            if (i2 != 0)
            {
              r.d(this, str4);
              return;
            }
            r.b(this, str4, i5);
            return;
          }
          if (!x.j.equals(paramIntent.getAction())) {
            break;
          }
          a(new ak(this, 4, paramIntent));
          return;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          break label1844;
        }
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */