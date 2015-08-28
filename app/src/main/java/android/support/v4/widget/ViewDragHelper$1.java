package android.support.v4.widget;

import android.view.animation.Interpolator;

final class ViewDragHelper$1
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    float f = paramFloat - 1.0F;
    return 1.0F + f * (f * (f * (f * f)));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ViewDragHelper.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */