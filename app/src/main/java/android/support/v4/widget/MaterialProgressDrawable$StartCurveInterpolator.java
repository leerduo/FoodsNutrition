package android.support.v4.widget;

import android.view.animation.AccelerateDecelerateInterpolator;

class MaterialProgressDrawable$StartCurveInterpolator
  extends AccelerateDecelerateInterpolator
{
  public float getInterpolation(float paramFloat)
  {
    return super.getInterpolation(Math.min(1.0F, 2.0F * paramFloat));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.StartCurveInterpolator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */