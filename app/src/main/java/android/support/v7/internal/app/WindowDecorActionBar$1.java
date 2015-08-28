package android.support.v7.internal.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.widget.ActionBarContainer;
import android.view.View;

class WindowDecorActionBar$1
  extends ViewPropertyAnimatorListenerAdapter
{
  WindowDecorActionBar$1(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void onAnimationEnd(View paramView)
  {
    if ((WindowDecorActionBar.a(this.a)) && (WindowDecorActionBar.b(this.a) != null))
    {
      ViewCompat.setTranslationY(WindowDecorActionBar.b(this.a), 0.0F);
      ViewCompat.setTranslationY(WindowDecorActionBar.c(this.a), 0.0F);
    }
    if ((WindowDecorActionBar.d(this.a) != null) && (WindowDecorActionBar.e(this.a) == 1)) {
      WindowDecorActionBar.d(this.a).setVisibility(8);
    }
    WindowDecorActionBar.c(this.a).setVisibility(8);
    WindowDecorActionBar.c(this.a).setTransitioning(false);
    WindowDecorActionBar.a(this.a, null);
    this.a.e();
    if (WindowDecorActionBar.f(this.a) != null) {
      ViewCompat.requestApplyInsets(WindowDecorActionBar.f(this.a));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowDecorActionBar.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */