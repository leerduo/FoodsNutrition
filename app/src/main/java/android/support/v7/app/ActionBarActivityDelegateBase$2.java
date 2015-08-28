package android.support.v7.app;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class ActionBarActivityDelegateBase$2
  implements OnApplyWindowInsetsListener
{
  ActionBarActivityDelegateBase$2(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    int j = ActionBarActivityDelegateBase.c(this.a, i);
    if (i != j) {
      paramWindowInsetsCompat = paramWindowInsetsCompat.replaceSystemWindowInsets(paramWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */