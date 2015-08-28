package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

class ViewPropertyAnimatorCompatJellybeanMr2
{
  public static Interpolator getInterpolator(View paramView)
  {
    return (Interpolator)paramView.animate().getInterpolator();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatJellybeanMr2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */