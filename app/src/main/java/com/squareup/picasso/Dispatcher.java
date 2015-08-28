package com.squareup.picasso;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class Dispatcher
{
  final Dispatcher.DispatcherThread a = new Dispatcher.DispatcherThread();
  final Context b;
  final ExecutorService c;
  final Downloader d;
  final Map<String, BitmapHunter> e;
  final Map<Object, Action> f;
  final Map<Object, Action> g;
  final Set<Object> h;
  final Handler i;
  final Handler j;
  final Cache k;
  final Stats l;
  final List<BitmapHunter> m;
  final Dispatcher.NetworkBroadcastReceiver n;
  final boolean o;
  boolean p;
  
  Dispatcher(Context paramContext, ExecutorService paramExecutorService, Handler paramHandler, Downloader paramDownloader, Cache paramCache, Stats paramStats)
  {
    this.a.start();
    this.b = paramContext;
    this.c = paramExecutorService;
    this.e = new LinkedHashMap();
    this.f = new WeakHashMap();
    this.g = new WeakHashMap();
    this.h = new HashSet();
    this.i = new Dispatcher.DispatcherHandler(this.a.getLooper(), this);
    this.d = paramDownloader;
    this.j = paramHandler;
    this.k = paramCache;
    this.l = paramStats;
    this.m = new ArrayList(4);
    this.p = Utils.d(this.b);
    this.o = Utils.b(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    this.n = new Dispatcher.NetworkBroadcastReceiver(this);
    this.n.a();
  }
  
  private void a(List<BitmapHunter> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    while (!((BitmapHunter)paramList.get(0)).j().k) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BitmapHunter localBitmapHunter = (BitmapHunter)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(Utils.a(localBitmapHunter));
    }
    Utils.a("Dispatcher", "delivered", localStringBuilder.toString());
  }
  
  private void b()
  {
    if (!this.f.isEmpty())
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        Action localAction = (Action)localIterator.next();
        localIterator.remove();
        if (localAction.h().k) {
          Utils.a("Dispatcher", "replaying", localAction.c().a());
        }
        a(localAction, false);
      }
    }
  }
  
  private void e(Action paramAction)
  {
    Object localObject = paramAction.d();
    if (localObject != null)
    {
      paramAction.j = true;
      this.f.put(localObject, paramAction);
    }
  }
  
  private void f(BitmapHunter paramBitmapHunter)
  {
    Action localAction = paramBitmapHunter.i();
    if (localAction != null) {
      e(localAction);
    }
    List localList = paramBitmapHunter.k();
    if (localList != null)
    {
      int i1 = localList.size();
      for (int i2 = 0; i2 < i1; i2++) {
        e((Action)localList.get(i2));
      }
    }
  }
  
  private void g(BitmapHunter paramBitmapHunter)
  {
    if (paramBitmapHunter.c()) {}
    do
    {
      return;
      this.m.add(paramBitmapHunter);
    } while (this.i.hasMessages(7));
    this.i.sendEmptyMessageDelayed(7, 200L);
  }
  
  void a()
  {
    ArrayList localArrayList = new ArrayList(this.m);
    this.m.clear();
    this.j.sendMessage(this.j.obtainMessage(8, localArrayList));
    a(localArrayList);
  }
  
  void a(NetworkInfo paramNetworkInfo)
  {
    this.i.sendMessage(this.i.obtainMessage(9, paramNetworkInfo));
  }
  
  void a(Action paramAction)
  {
    this.i.sendMessage(this.i.obtainMessage(1, paramAction));
  }
  
  void a(Action paramAction, boolean paramBoolean)
  {
    if (this.h.contains(paramAction.j()))
    {
      this.g.put(paramAction.d(), paramAction);
      if (paramAction.h().k) {
        Utils.a("Dispatcher", "paused", paramAction.b.a(), "because tag '" + paramAction.j() + "' is paused");
      }
    }
    do
    {
      do
      {
        return;
        BitmapHunter localBitmapHunter1 = (BitmapHunter)this.e.get(paramAction.e());
        if (localBitmapHunter1 != null)
        {
          localBitmapHunter1.a(paramAction);
          return;
        }
        if (!this.c.isShutdown()) {
          break;
        }
      } while (!paramAction.h().k);
      Utils.a("Dispatcher", "ignored", paramAction.b.a(), "because shut down");
      return;
      BitmapHunter localBitmapHunter2 = BitmapHunter.a(paramAction.h(), this, this.k, this.l, paramAction);
      localBitmapHunter2.m = this.c.submit(localBitmapHunter2);
      this.e.put(paramAction.e(), localBitmapHunter2);
      if (paramBoolean) {
        this.f.remove(paramAction.d());
      }
    } while (!paramAction.h().k);
    Utils.a("Dispatcher", "enqueued", paramAction.b.a());
  }
  
  void a(BitmapHunter paramBitmapHunter)
  {
    this.i.sendMessage(this.i.obtainMessage(4, paramBitmapHunter));
  }
  
  void a(BitmapHunter paramBitmapHunter, boolean paramBoolean)
  {
    String str1;
    StringBuilder localStringBuilder;
    if (paramBitmapHunter.j().k)
    {
      str1 = Utils.a(paramBitmapHunter);
      localStringBuilder = new StringBuilder().append("for error");
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (String str2 = " (will replay)";; str2 = "")
    {
      Utils.a("Dispatcher", "batched", str1, str2);
      this.e.remove(paramBitmapHunter.g());
      g(paramBitmapHunter);
      return;
    }
  }
  
  void a(Object paramObject)
  {
    if (!this.h.add(paramObject)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.e.values().iterator();
      while (localIterator.hasNext())
      {
        BitmapHunter localBitmapHunter = (BitmapHunter)localIterator.next();
        boolean bool = localBitmapHunter.j().k;
        Action localAction1 = localBitmapHunter.i();
        List localList = localBitmapHunter.k();
        int i1;
        label87:
        int i2;
        label200:
        Action localAction2;
        if ((localList != null) && (!localList.isEmpty()))
        {
          i1 = 1;
          if ((localAction1 == null) && (i1 == 0)) {
            break label241;
          }
          if ((localAction1 != null) && (localAction1.j().equals(paramObject)))
          {
            localBitmapHunter.b(localAction1);
            this.g.put(localAction1.d(), localAction1);
            if (bool) {
              Utils.a("Dispatcher", "paused", localAction1.b.a(), "because tag '" + paramObject + "' was paused");
            }
          }
          if (i1 == 0) {
            break label316;
          }
          i2 = -1 + localList.size();
          if (i2 < 0) {
            break label316;
          }
          localAction2 = (Action)localList.get(i2);
          if (localAction2.j().equals(paramObject)) {
            break label243;
          }
        }
        for (;;)
        {
          i2--;
          break label200;
          i1 = 0;
          break label87;
          label241:
          break;
          label243:
          localBitmapHunter.b(localAction2);
          this.g.put(localAction2.d(), localAction2);
          if (bool) {
            Utils.a("Dispatcher", "paused", localAction2.b.a(), "because tag '" + paramObject + "' was paused");
          }
        }
        label316:
        if (localBitmapHunter.b())
        {
          localIterator.remove();
          if (bool) {
            Utils.a("Dispatcher", "canceled", Utils.a(localBitmapHunter), "all actions paused");
          }
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    Handler localHandler1 = this.i;
    Handler localHandler2 = this.i;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      localHandler1.sendMessage(localHandler2.obtainMessage(10, i1, 0));
      return;
    }
  }
  
  void b(NetworkInfo paramNetworkInfo)
  {
    if ((this.c instanceof PicassoExecutorService)) {
      ((PicassoExecutorService)this.c).a(paramNetworkInfo);
    }
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected())) {
      b();
    }
  }
  
  void b(Action paramAction)
  {
    this.i.sendMessage(this.i.obtainMessage(2, paramAction));
  }
  
  void b(BitmapHunter paramBitmapHunter)
  {
    this.i.sendMessageDelayed(this.i.obtainMessage(5, paramBitmapHunter), 500L);
  }
  
  void b(Object paramObject)
  {
    if (!this.h.remove(paramObject)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = null;
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext())
      {
        Action localAction = (Action)localIterator.next();
        if (localAction.j().equals(paramObject))
        {
          if (localArrayList == null) {
            localArrayList = new ArrayList();
          }
          localArrayList.add(localAction);
          localIterator.remove();
        }
      }
    } while (localArrayList == null);
    this.j.sendMessage(this.j.obtainMessage(13, localArrayList));
  }
  
  void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  void c(Action paramAction)
  {
    a(paramAction, true);
  }
  
  void c(BitmapHunter paramBitmapHunter)
  {
    this.i.sendMessage(this.i.obtainMessage(6, paramBitmapHunter));
  }
  
  void d(Action paramAction)
  {
    String str = paramAction.e();
    BitmapHunter localBitmapHunter = (BitmapHunter)this.e.get(str);
    if (localBitmapHunter != null)
    {
      localBitmapHunter.b(paramAction);
      if (localBitmapHunter.b())
      {
        this.e.remove(str);
        if (paramAction.h().k) {
          Utils.a("Dispatcher", "canceled", paramAction.c().a());
        }
      }
    }
    if (this.h.contains(paramAction.j()))
    {
      this.g.remove(paramAction.d());
      if (paramAction.h().k) {
        Utils.a("Dispatcher", "canceled", paramAction.c().a(), "because paused request got canceled");
      }
    }
    Action localAction = (Action)this.f.remove(paramAction.d());
    if ((localAction != null) && (localAction.h().k)) {
      Utils.a("Dispatcher", "canceled", localAction.c().a(), "from replaying");
    }
  }
  
  void d(BitmapHunter paramBitmapHunter)
  {
    boolean bool1 = true;
    if (paramBitmapHunter.c()) {
      return;
    }
    if (this.c.isShutdown())
    {
      a(paramBitmapHunter, false);
      return;
    }
    if (this.o) {}
    for (NetworkInfo localNetworkInfo = ((ConnectivityManager)Utils.a(this.b, "connectivity")).getActiveNetworkInfo();; localNetworkInfo = null)
    {
      boolean bool2;
      label67:
      boolean bool4;
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        bool2 = bool1;
        boolean bool3 = paramBitmapHunter.a(this.p, localNetworkInfo);
        bool4 = paramBitmapHunter.e();
        if (bool3) {
          break label128;
        }
        if ((!this.o) || (!bool4)) {
          break label123;
        }
      }
      for (;;)
      {
        a(paramBitmapHunter, bool1);
        if (!bool1) {
          break;
        }
        f(paramBitmapHunter);
        return;
        bool2 = false;
        break label67;
        label123:
        bool1 = false;
      }
      label128:
      if ((!this.o) || (bool2))
      {
        if (paramBitmapHunter.j().k) {
          Utils.a("Dispatcher", "retrying", Utils.a(paramBitmapHunter));
        }
        paramBitmapHunter.m = this.c.submit(paramBitmapHunter);
        return;
      }
      a(paramBitmapHunter, bool4);
      if (!bool4) {
        break;
      }
      f(paramBitmapHunter);
      return;
    }
  }
  
  void e(BitmapHunter paramBitmapHunter)
  {
    if (!paramBitmapHunter.d()) {
      this.k.a(paramBitmapHunter.g(), paramBitmapHunter.f());
    }
    this.e.remove(paramBitmapHunter.g());
    g(paramBitmapHunter);
    if (paramBitmapHunter.j().k) {
      Utils.a("Dispatcher", "batched", Utils.a(paramBitmapHunter), "for completion");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Dispatcher
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */