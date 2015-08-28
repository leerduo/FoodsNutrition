package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.ActionMenuView;
import android.view.View;

public class AbsActionBarView$VisibilityAnimListener
  implements ViewPropertyAnimatorListener
{
  int a;
  private boolean c = false;
  
  protected AbsActionBarView$VisibilityAnimListener(AbsActionBarView paramAbsActionBarView) {}
  
  public VisibilityAnimListener a(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
  {
    this.b.i = paramViewPropertyAnimatorCompat;
    this.a = paramInt;
    return this;
  }
  
  public void onAnimationCancel(View paramView)
  {
    this.c = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (this.c) {}
    do
    {
      return;
      this.b.i = null;
      this.b.setVisibility(this.a);
    } while ((this.b.e == null) || (this.b.c == null));
    this.b.c.setVisibility(this.a);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.b.setVisibility(0);
    this.c = false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsActionBarView.VisibilityAnimListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */