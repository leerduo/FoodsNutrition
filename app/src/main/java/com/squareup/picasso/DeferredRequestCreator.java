package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator
  implements ViewTreeObserver.OnPreDrawListener
{
  final RequestCreator a;
  final WeakReference<ImageView> b;
  Callback c;
  
  DeferredRequestCreator(RequestCreator paramRequestCreator, ImageView paramImageView, Callback paramCallback)
  {
    this.a = paramRequestCreator;
    this.b = new WeakReference(paramImageView);
    this.c = paramCallback;
    paramImageView.getViewTreeObserver().addOnPreDrawListener(this);
  }
  
  void a()
  {
    this.c = null;
    ImageView localImageView = (ImageView)this.b.get();
    if (localImageView == null) {}
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = localImageView.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.removeOnPreDrawListener(this);
  }
  
  public boolean onPreDraw()
  {
    ImageView localImageView = (ImageView)this.b.get();
    if (localImageView == null) {}
    ViewTreeObserver localViewTreeObserver;
    int i;
    int j;
    do
    {
      do
      {
        return true;
        localViewTreeObserver = localImageView.getViewTreeObserver();
      } while (!localViewTreeObserver.isAlive());
      i = localImageView.getWidth();
      j = localImageView.getHeight();
    } while ((i <= 0) || (j <= 0));
    localViewTreeObserver.removeOnPreDrawListener(this);
    this.a.a().a(i, j).a(localImageView, this.c);
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.DeferredRequestCreator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */