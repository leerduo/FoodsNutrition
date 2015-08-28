package android.support.v7.internal.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class ActionBarOverlayLayout$3
  implements Runnable
{
  ActionBarOverlayLayout$3(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void run()
  {
    ActionBarOverlayLayout.a(this.a);
    ActionBarOverlayLayout.a(this.a, ViewCompat.animate(ActionBarOverlayLayout.c(this.a)).translationY(0.0F).setListener(ActionBarOverlayLayout.b(this.a)));
    if ((ActionBarOverlayLayout.d(this.a) != null) && (ActionBarOverlayLayout.d(this.a).getVisibility() != 8)) {
      ActionBarOverlayLayout.b(this.a, ViewCompat.animate(ActionBarOverlayLayout.d(this.a)).translationY(0.0F).setListener(ActionBarOverlayLayout.e(this.a)));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarOverlayLayout.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */