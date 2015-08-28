package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class ViewPropertyAnimatorCompatKK$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ViewPropertyAnimatorCompatKK$1(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$listener.onAnimationUpdate(this.val$view);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatKK.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */