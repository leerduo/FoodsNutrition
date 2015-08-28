package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class ActionBarOverlayLayout$2
  extends ViewPropertyAnimatorListenerAdapter
{
  ActionBarOverlayLayout$2(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void onAnimationCancel(View paramView)
  {
    ActionBarOverlayLayout.b(this.a, null);
    ActionBarOverlayLayout.a(this.a, false);
  }
  
  public void onAnimationEnd(View paramView)
  {
    ActionBarOverlayLayout.b(this.a, null);
    ActionBarOverlayLayout.a(this.a, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarOverlayLayout.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */