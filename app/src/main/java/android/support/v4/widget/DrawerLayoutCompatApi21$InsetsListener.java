package android.support.v4.widget;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class DrawerLayoutCompatApi21$InsetsListener
  implements View.OnApplyWindowInsetsListener
{
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    DrawerLayoutImpl localDrawerLayoutImpl = (DrawerLayoutImpl)paramView;
    if (paramWindowInsets.getSystemWindowInsetTop() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localDrawerLayoutImpl.setChildInsets(paramWindowInsets, bool);
      return paramWindowInsets.consumeSystemWindowInsets();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayoutCompatApi21.InsetsListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */