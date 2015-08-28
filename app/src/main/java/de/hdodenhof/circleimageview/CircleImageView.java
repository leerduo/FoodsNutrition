package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class CircleImageView
  extends ImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Matrix e = new Matrix();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private int h = -16777216;
  private int i = 0;
  private Bitmap j;
  private BitmapShader k;
  private int l;
  private int m;
  private float n;
  private float o;
  private boolean p;
  private boolean q;
  
  public CircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleImageView, paramInt, 0);
    this.i = localTypedArray.getDimensionPixelSize(R.styleable.CircleImageView_border_width, 0);
    this.h = localTypedArray.getColor(R.styleable.CircleImageView_border_color, -16777216);
    localTypedArray.recycle();
    a();
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      Bitmap localBitmap;
      for (Object localObject = Bitmap.createBitmap(2, 2, b);; localObject = localBitmap)
      {
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localObject;
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), b);
      }
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void a()
  {
    super.setScaleType(a);
    this.p = true;
    if (this.q)
    {
      b();
      this.q = false;
    }
  }
  
  private void b()
  {
    if (!this.p) {
      this.q = true;
    }
    while (this.j == null) {
      return;
    }
    this.k = new BitmapShader(this.j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.f.setAntiAlias(true);
    this.f.setShader(this.k);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setColor(this.h);
    this.g.setStrokeWidth(this.i);
    this.m = this.j.getHeight();
    this.l = this.j.getWidth();
    this.d.set(0.0F, 0.0F, getWidth(), getHeight());
    this.o = Math.min((this.d.height() - this.i) / 2.0F, (this.d.width() - this.i) / 2.0F);
    this.c.set(this.i, this.i, this.d.width() - this.i, this.d.height() - this.i);
    this.n = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
    c();
    invalidate();
  }
  
  private void c()
  {
    float f1 = 0.0F;
    this.e.set(null);
    float f2;
    if (this.l * this.c.height() > this.c.width() * this.m) {
      f2 = this.c.height() / this.m;
    }
    for (float f3 = 0.5F * (this.c.width() - f2 * this.l);; f3 = 0.0F)
    {
      this.e.setScale(f2, f2);
      this.e.postTranslate((int)(f3 + 0.5F) + this.i, (int)(f1 + 0.5F) + this.i);
      this.k.setLocalMatrix(this.e);
      return;
      f2 = this.c.width() / this.l;
      f1 = 0.5F * (this.c.height() - f2 * this.m);
    }
  }
  
  public int getBorderColor()
  {
    return this.h;
  }
  
  public int getBorderWidth()
  {
    return this.i;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {}
    do
    {
      return;
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.n, this.f);
    } while (this.i == 0);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.o, this.g);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.h) {
      return;
    }
    this.h = paramInt;
    this.g.setColor(this.h);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.j = paramBitmap;
    b();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.j = a(paramDrawable);
    b();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.j = a(getDrawable());
    b();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    this.j = a(getDrawable());
    b();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != a) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     de.hdodenhof.circleimageview.CircleImageView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */