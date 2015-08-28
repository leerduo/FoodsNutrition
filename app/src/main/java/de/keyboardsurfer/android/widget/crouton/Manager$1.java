package de.keyboardsurfer.android.widget.crouton;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;

class Manager$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  Manager$1(Manager paramManager, View paramView, Crouton paramCrouton) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      if (this.b.c() != null)
      {
        this.a.startAnimation(this.b.c());
        Manager.a(this.b.l(), this.b.n());
        if (-1 != this.b.k().b) {
          Manager.a(this.c, this.b, -1040155167, this.b.k().b + this.b.c().getDuration());
        }
      }
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     de.keyboardsurfer.android.widget.crouton.Manager.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */