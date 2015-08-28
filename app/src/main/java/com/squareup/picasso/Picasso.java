package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class Picasso
{
  static final Handler a = new Picasso.1(Looper.getMainLooper());
  static Picasso b = null;
  final Context c;
  final Dispatcher d;
  final Cache e;
  final Stats f;
  final Map<Object, Action> g;
  final Map<ImageView, DeferredRequestCreator> h;
  final ReferenceQueue<Object> i;
  boolean j;
  volatile boolean k;
  boolean l;
  private final Picasso.Listener m;
  private final Picasso.RequestTransformer n;
  private final Picasso.CleanupThread o;
  private final List<RequestHandler> p;
  
  Picasso(Context paramContext, Dispatcher paramDispatcher, Cache paramCache, Picasso.Listener paramListener, Picasso.RequestTransformer paramRequestTransformer, List<RequestHandler> paramList, Stats paramStats, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramContext;
    this.d = paramDispatcher;
    this.e = paramCache;
    this.m = paramListener;
    this.n = paramRequestTransformer;
    if (paramList != null) {}
    for (int i1 = paramList.size();; i1 = 0)
    {
      ArrayList localArrayList = new ArrayList(i1 + 7);
      localArrayList.add(new ResourceRequestHandler(paramContext));
      if (paramList != null) {
        localArrayList.addAll(paramList);
      }
      localArrayList.add(new ContactsPhotoRequestHandler(paramContext));
      localArrayList.add(new MediaStoreRequestHandler(paramContext));
      localArrayList.add(new ContentStreamRequestHandler(paramContext));
      localArrayList.add(new AssetRequestHandler(paramContext));
      localArrayList.add(new FileRequestHandler(paramContext));
      localArrayList.add(new NetworkRequestHandler(paramDispatcher.d, paramStats));
      this.p = Collections.unmodifiableList(localArrayList);
      this.f = paramStats;
      this.g = new WeakHashMap();
      this.h = new WeakHashMap();
      this.j = paramBoolean1;
      this.k = paramBoolean2;
      this.i = new ReferenceQueue();
      this.o = new Picasso.CleanupThread(this.i, a);
      this.o.start();
      return;
    }
  }
  
  public static Picasso a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new Picasso.Builder(paramContext).a();
      }
      return b;
    }
    finally {}
  }
  
  private void a(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom, Action paramAction)
  {
    if (paramAction.f()) {}
    do
    {
      do
      {
        return;
        if (!paramAction.g()) {
          this.g.remove(paramAction.d());
        }
        if (paramBitmap == null) {
          break;
        }
        if (paramLoadedFrom == null) {
          throw new AssertionError("LoadedFrom cannot be null.");
        }
        paramAction.a(paramBitmap, paramLoadedFrom);
      } while (!this.k);
      Utils.a("Main", "completed", paramAction.b.a(), "from " + paramLoadedFrom);
      return;
      paramAction.a();
    } while (!this.k);
    Utils.a("Main", "errored", paramAction.b.a());
  }
  
  private void a(Object paramObject)
  {
    Utils.a();
    Action localAction = (Action)this.g.remove(paramObject);
    if (localAction != null)
    {
      localAction.b();
      this.d.b(localAction);
    }
    if ((paramObject instanceof ImageView))
    {
      ImageView localImageView = (ImageView)paramObject;
      DeferredRequestCreator localDeferredRequestCreator = (DeferredRequestCreator)this.h.remove(localImageView);
      if (localDeferredRequestCreator != null) {
        localDeferredRequestCreator.a();
      }
    }
  }
  
  Request a(Request paramRequest)
  {
    Request localRequest = this.n.a(paramRequest);
    if (localRequest == null) {
      throw new IllegalStateException("Request transformer " + this.n.getClass().getCanonicalName() + " returned null for " + paramRequest);
    }
    return localRequest;
  }
  
  public RequestCreator a(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Resource ID must not be zero.");
    }
    return new RequestCreator(this, null, paramInt);
  }
  
  public RequestCreator a(Uri paramUri)
  {
    return new RequestCreator(this, paramUri, 0);
  }
  
  public RequestCreator a(String paramString)
  {
    if (paramString == null) {
      return new RequestCreator(this, null, 0);
    }
    if (paramString.trim().length() == 0) {
      throw new IllegalArgumentException("Path must not be empty.");
    }
    return a(Uri.parse(paramString));
  }
  
  List<RequestHandler> a()
  {
    return this.p;
  }
  
  public void a(ImageView paramImageView)
  {
    a(paramImageView);
  }
  
  void a(ImageView paramImageView, DeferredRequestCreator paramDeferredRequestCreator)
  {
    this.h.put(paramImageView, paramDeferredRequestCreator);
  }
  
  void a(Action paramAction)
  {
    Object localObject = paramAction.d();
    if ((localObject != null) && (this.g.get(localObject) != paramAction))
    {
      a(localObject);
      this.g.put(localObject, paramAction);
    }
    b(paramAction);
  }
  
  void a(BitmapHunter paramBitmapHunter)
  {
    int i1 = 1;
    Action localAction = paramBitmapHunter.i();
    List localList = paramBitmapHunter.k();
    int i2;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i2 = i1;
      if ((localAction == null) && (i2 == 0)) {
        break label51;
      }
      label40:
      if (i1 != 0) {
        break label56;
      }
    }
    label51:
    label56:
    Uri localUri;
    Exception localException;
    do
    {
      return;
      i2 = 0;
      break;
      i1 = 0;
      break label40;
      localUri = paramBitmapHunter.h().d;
      localException = paramBitmapHunter.l();
      Bitmap localBitmap = paramBitmapHunter.f();
      Picasso.LoadedFrom localLoadedFrom = paramBitmapHunter.m();
      if (localAction != null) {
        a(localBitmap, localLoadedFrom, localAction);
      }
      if (i2 != 0)
      {
        int i3 = localList.size();
        for (int i4 = 0; i4 < i3; i4++) {
          a(localBitmap, localLoadedFrom, (Action)localList.get(i4));
        }
      }
    } while ((this.m == null) || (localException == null));
    this.m.a(this, localUri, localException);
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  Bitmap b(String paramString)
  {
    Bitmap localBitmap = this.e.a(paramString);
    if (localBitmap != null)
    {
      this.f.a();
      return localBitmap;
    }
    this.f.b();
    return localBitmap;
  }
  
  void b(Action paramAction)
  {
    this.d.a(paramAction);
  }
  
  void c(Action paramAction)
  {
    boolean bool = paramAction.d;
    Bitmap localBitmap = null;
    if (!bool) {
      localBitmap = b(paramAction.e());
    }
    if (localBitmap != null)
    {
      a(localBitmap, Picasso.LoadedFrom.a, paramAction);
      if (this.k) {
        Utils.a("Main", "completed", paramAction.b.a(), "from " + Picasso.LoadedFrom.a);
      }
    }
    do
    {
      return;
      a(paramAction);
    } while (!this.k);
    Utils.a("Main", "resumed", paramAction.b.a());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */