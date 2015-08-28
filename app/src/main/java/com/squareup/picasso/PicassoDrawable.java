package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;

final class PicassoDrawable
  extends BitmapDrawable
{
  private static final Paint e = new Paint();
  Drawable a;
  long b;
  boolean c;
  int d = 255;
  private final boolean f;
  private final float g;
  private final Picasso.LoadedFrom h;
  
  PicassoDrawable(Context paramContext, Bitmap paramBitmap, Drawable paramDrawable, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext.getResources(), paramBitmap);
    this.f = paramBoolean2;
    this.g = paramContext.getResources().getDisplayMetrics().density;
    this.h = paramLoadedFrom;
    if ((paramLoadedFrom != Picasso.LoadedFrom.a) && (!paramBoolean1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.a = paramDrawable;
        this.c = true;
        this.b = SystemClock.uptimeMillis();
      }
      return;
    }
  }
  
  private static Path a(Point paramPoint, int paramInt)
  {
    Point localPoint1 = new Point(paramInt + paramPoint.x, paramPoint.y);
    Point localPoint2 = new Point(paramPoint.x, paramInt + paramPoint.y);
    Path localPath = new Path();
    localPath.moveTo(paramPoint.x, paramPoint.y);
    localPath.lineTo(localPoint1.x, localPoint1.y);
    localPath.lineTo(localPoint2.x, localPoint2.y);
    return localPath;
  }
  
  private void a(Canvas paramCanvas)
  {
    e.setColor(-1);
    paramCanvas.drawPath(a(new Point(0, 0), (int)(16.0F * this.g)), e);
    e.setColor(this.h.d);
    paramCanvas.drawPath(a(new Point(0, 0), (int)(15.0F * this.g)), e);
  }
  
  static void a(ImageView paramImageView, Context paramContext, Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).stop();
    }
    paramImageView.setImageDrawable(new PicassoDrawable(paramContext, paramBitmap, localDrawable, paramLoadedFrom, paramBoolean1, paramBoolean2));
  }
  
  static void a(ImageView paramImageView, Drawable paramDrawable)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if ((paramImageView.getDrawable() instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramImageView.getDrawable()).start();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.c) {
      super.draw(paramCanvas);
    }
    for (;;)
    {
      if (this.f) {
        a(paramCanvas);
      }
      return;
      float f1 = (float)(SystemClock.uptimeMillis() - this.b) / 200.0F;
      if (f1 >= 1.0F)
      {
        this.c = false;
        this.a = null;
        super.draw(paramCanvas);
      }
      else
      {
        if (this.a != null) {
          this.a.draw(paramCanvas);
        }
        super.setAlpha((int)(f1 * this.d));
        super.draw(paramCanvas);
        super.setAlpha(this.d);
        if (Build.VERSION.SDK_INT <= 10) {
          invalidateSelf();
        }
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.a != null) {
      this.a.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.d = paramInt;
    if (this.a != null) {
      this.a.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.a != null) {
      this.a.setColorFilter(paramColorFilter);
    }
    super.setColorFilter(paramColorFilter);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.PicassoDrawable
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */