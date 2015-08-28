package android.support.v7.internal.app;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.widget.ActionBarContainer;
import android.view.View;

class WindowDecorActionBar$2
  extends ViewPropertyAnimatorListenerAdapter
{
  WindowDecorActionBar$2(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void onAnimationEnd(View paramView)
  {
    WindowDecorActionBar.a(this.a, null);
    WindowDecorActionBar.c(this.a).requestLayout();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowDecorActionBar.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */