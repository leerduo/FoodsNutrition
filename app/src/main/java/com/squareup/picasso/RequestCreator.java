package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.widget.ImageView;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestCreator
{
  private static int a = 0;
  private final Picasso b;
  private final Request.Builder c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private int h;
  private int i;
  private Drawable j;
  private Drawable k;
  private Object l;
  
  RequestCreator()
  {
    this.b = null;
    this.c = new Request.Builder(null, 0);
  }
  
  RequestCreator(Picasso paramPicasso, Uri paramUri, int paramInt)
  {
    if (paramPicasso.l) {
      throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }
    this.b = paramPicasso;
    this.c = new Request.Builder(paramUri, paramInt);
  }
  
  private Request a(long paramLong)
  {
    int m = e();
    Request localRequest1 = this.c.d();
    localRequest1.a = m;
    localRequest1.b = paramLong;
    boolean bool = this.b.k;
    if (bool) {
      Utils.a("Main", "created", localRequest1.b(), localRequest1.toString());
    }
    Request localRequest2 = this.b.a(localRequest1);
    if (localRequest2 != localRequest1)
    {
      localRequest2.a = m;
      localRequest2.b = paramLong;
      if (bool) {
        Utils.a("Main", "changed", localRequest2.a(), "into " + localRequest2);
      }
    }
    return localRequest2;
  }
  
  private static int e()
  {
    if (Utils.b())
    {
      int m = a;
      a = m + 1;
      return m;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AtomicInteger localAtomicInteger = new AtomicInteger();
    Picasso.a.post(new RequestCreator.1(localAtomicInteger, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      return localAtomicInteger.get();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Utils.a(localInterruptedException);
      }
    }
  }
  
  private Drawable f()
  {
    if (this.h != 0) {
      return this.b.c.getResources().getDrawable(this.h);
    }
    return this.j;
  }
  
  RequestCreator a()
  {
    this.f = false;
    return this;
  }
  
  public RequestCreator a(int paramInt)
  {
    if (!this.g) {
      throw new IllegalStateException("Already explicitly declared as no placeholder.");
    }
    if (paramInt == 0) {
      throw new IllegalArgumentException("Placeholder image resource invalid.");
    }
    if (this.j != null) {
      throw new IllegalStateException("Placeholder image already set.");
    }
    this.h = paramInt;
    return this;
  }
  
  public RequestCreator a(int paramInt1, int paramInt2)
  {
    this.c.a(paramInt1, paramInt2);
    return this;
  }
  
  public void a(ImageView paramImageView)
  {
    a(paramImageView, null);
  }
  
  public void a(ImageView paramImageView, Callback paramCallback)
  {
    long l1 = System.nanoTime();
    Utils.a();
    if (paramImageView == null) {
      throw new IllegalArgumentException("Target must not be null.");
    }
    if (!this.c.a())
    {
      this.b.a(paramImageView);
      if (this.g) {
        PicassoDrawable.a(paramImageView, f());
      }
    }
    Request localRequest;
    String str;
    do
    {
      return;
      if (this.f)
      {
        if (this.c.b()) {
          throw new IllegalStateException("Fit cannot be used with resize.");
        }
        int m = paramImageView.getWidth();
        int n = paramImageView.getHeight();
        if ((m == 0) || (n == 0))
        {
          if (this.g) {
            PicassoDrawable.a(paramImageView, f());
          }
          this.b.a(paramImageView, new DeferredRequestCreator(this, paramImageView, paramCallback));
          return;
        }
        this.c.a(m, n);
      }
      localRequest = a(l1);
      str = Utils.a(localRequest);
      if (this.d) {
        break;
      }
      Bitmap localBitmap = this.b.b(str);
      if (localBitmap == null) {
        break;
      }
      this.b.a(paramImageView);
      PicassoDrawable.a(paramImageView, this.b.c, localBitmap, Picasso.LoadedFrom.a, this.e, this.b.j);
      if (this.b.k) {
        Utils.a("Main", "completed", localRequest.b(), "from " + Picasso.LoadedFrom.a);
      }
    } while (paramCallback == null);
    paramCallback.onSuccess();
    return;
    if (this.g) {
      PicassoDrawable.a(paramImageView, f());
    }
    ImageViewAction localImageViewAction = new ImageViewAction(this.b, paramImageView, localRequest, this.d, this.e, this.i, this.k, str, this.l, paramCallback);
    this.b.a(localImageViewAction);
  }
  
  public RequestCreator b()
  {
    this.c.c();
    return this;
  }
  
  public RequestCreator b(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Error image resource invalid.");
    }
    if (this.k != null) {
      throw new IllegalStateException("Error image already set.");
    }
    this.i = paramInt;
    return this;
  }
  
  public RequestCreator c()
  {
    this.d = true;
    return this;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RequestCreator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */