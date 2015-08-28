package android.support.v7.internal.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class SpinnerCompat$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SpinnerCompat$2(SpinnerCompat paramSpinnerCompat) {}
  
  public void onGlobalLayout()
  {
    if (!SpinnerCompat.a(this.a).b()) {
      SpinnerCompat.a(this.a).c();
    }
    ViewTreeObserver localViewTreeObserver = this.a.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */