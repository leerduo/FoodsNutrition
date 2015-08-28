package android.support.v7.app;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;

final class ActionBarActivityDelegateBase$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private ActionBarActivityDelegateBase$ActionMenuPresenterCallback(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    ActionBarActivityDelegateBase.a(this.a, paramMenuBuilder);
  }
  
  public boolean a(MenuBuilder paramMenuBuilder)
  {
    WindowCallback localWindowCallback = this.a.m();
    if (localWindowCallback != null) {
      localWindowCallback.c(8, paramMenuBuilder);
    }
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.ActionMenuPresenterCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */