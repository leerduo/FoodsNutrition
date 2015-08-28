package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;

class ActionBarActivityDelegateBase$3
  implements FitWindowsViewGroup.OnFitSystemWindowsListener
{
  ActionBarActivityDelegateBase$3(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public void a(Rect paramRect)
  {
    paramRect.top = ActionBarActivityDelegateBase.c(this.a, paramRect.top);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */