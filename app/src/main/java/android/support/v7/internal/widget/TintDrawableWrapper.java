package android.support.v7.internal.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class TintDrawableWrapper
  extends DrawableWrapper
{
  private final ColorStateList a;
  private final PorterDuff.Mode b;
  private int c;
  
  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    this(paramDrawable, paramColorStateList, TintManager.a);
  }
  
  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    super(paramDrawable);
    this.a = paramColorStateList;
    this.b = paramMode;
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    if (this.a != null)
    {
      int i = this.a.getColorForState(paramArrayOfInt, this.c);
      if (i != this.c)
      {
        if (i != 0) {
          setColorFilter(i, this.b);
        }
        for (;;)
        {
          this.c = i;
          return true;
          clearColorFilter();
        }
      }
    }
    return false;
  }
  
  public boolean isStateful()
  {
    return ((this.a != null) && (this.a.isStateful())) || (super.isStateful());
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = super.setState(paramArrayOfInt);
    return (a(paramArrayOfInt)) || (bool);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintDrawableWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */