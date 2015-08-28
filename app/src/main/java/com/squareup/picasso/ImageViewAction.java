package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class ImageViewAction
  extends Action<ImageView>
{
  Callback l;
  
  ImageViewAction(Picasso paramPicasso, ImageView paramImageView, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Drawable paramDrawable, String paramString, Object paramObject, Callback paramCallback)
  {
    super(paramPicasso, paramImageView, paramRequest, paramBoolean1, paramBoolean2, paramInt, paramDrawable, paramString, paramObject);
    this.l = paramCallback;
  }
  
  public void a()
  {
    ImageView localImageView = (ImageView)this.c.get();
    if (localImageView == null) {}
    for (;;)
    {
      return;
      if (this.f != 0) {
        localImageView.setImageResource(this.f);
      }
      while (this.l != null)
      {
        this.l.onError();
        return;
        if (this.g != null) {
          localImageView.setImageDrawable(this.g);
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    if (paramBitmap == null) {
      throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
    }
    ImageView localImageView = (ImageView)this.c.get();
    if (localImageView == null) {}
    do
    {
      return;
      Context localContext = this.a.c;
      boolean bool = this.a.j;
      PicassoDrawable.a(localImageView, localContext, paramBitmap, paramLoadedFrom, this.e, bool);
    } while (this.l == null);
    this.l.onSuccess();
  }
  
  void b()
  {
    super.b();
    if (this.l != null) {
      this.l = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ImageViewAction
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */