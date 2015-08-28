package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

public class ScrollingTabContainerView$VisibilityAnimListener
  implements ViewPropertyAnimatorListener
{
  private boolean b;
  private int c;
  
  public void onAnimationCancel(View paramView)
  {
    this.b = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (this.b) {
      return;
    }
    this.a.d = null;
    this.a.setVisibility(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.a.setVisibility(0);
    this.b = false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.VisibilityAnimListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */