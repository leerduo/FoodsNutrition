package android.support.v7.internal.view;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import java.util.ArrayList;

class ViewPropertyAnimatorCompatSet$1
  extends ViewPropertyAnimatorListenerAdapter
{
  private boolean b = false;
  private int c = 0;
  
  ViewPropertyAnimatorCompatSet$1(ViewPropertyAnimatorCompatSet paramViewPropertyAnimatorCompatSet) {}
  
  void a()
  {
    this.c = 0;
    this.b = false;
    ViewPropertyAnimatorCompatSet.b(this.a);
  }
  
  public void onAnimationEnd(View paramView)
  {
    int i = 1 + this.c;
    this.c = i;
    if (i == ViewPropertyAnimatorCompatSet.c(this.a).size())
    {
      if (ViewPropertyAnimatorCompatSet.a(this.a) != null) {
        ViewPropertyAnimatorCompatSet.a(this.a).onAnimationEnd(null);
      }
      a();
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    if (this.b) {}
    do
    {
      return;
      this.b = true;
    } while (ViewPropertyAnimatorCompatSet.a(this.a) == null);
    ViewPropertyAnimatorCompatSet.a(this.a).onAnimationStart(null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.ViewPropertyAnimatorCompatSet.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */