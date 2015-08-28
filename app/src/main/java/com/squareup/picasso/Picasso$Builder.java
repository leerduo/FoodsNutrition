package com.squareup.picasso;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Picasso$Builder
{
  private final Context a;
  private Downloader b;
  private ExecutorService c;
  private Cache d;
  private Picasso.Listener e;
  private Picasso.RequestTransformer f;
  private List<RequestHandler> g;
  private boolean h;
  private boolean i;
  
  public Picasso$Builder(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null.");
    }
    this.a = paramContext.getApplicationContext();
  }
  
  public Picasso a()
  {
    Context localContext = this.a;
    if (this.b == null) {
      this.b = Utils.a(localContext);
    }
    if (this.d == null) {
      this.d = new LruCache(localContext);
    }
    if (this.c == null) {
      this.c = new PicassoExecutorService();
    }
    if (this.f == null) {
      this.f = Picasso.RequestTransformer.a;
    }
    Stats localStats = new Stats(this.d);
    return new Picasso(localContext, new Dispatcher(localContext, this.c, Picasso.a, this.b, this.d, localStats), this.d, this.e, this.f, this.g, localStats, this.h, this.i);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.Builder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */