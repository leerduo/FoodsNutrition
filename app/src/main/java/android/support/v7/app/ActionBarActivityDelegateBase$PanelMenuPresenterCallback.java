package android.support.v7.app;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;

final class ActionBarActivityDelegateBase$PanelMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private ActionBarActivityDelegateBase$PanelMenuPresenterCallback(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuBuilder localMenuBuilder = paramMenuBuilder.p();
    if (localMenuBuilder != paramMenuBuilder) {}
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState;
    for (int i = 1;; i = 0)
    {
      ActionBarActivityDelegateBase localActionBarActivityDelegateBase = this.a;
      if (i != 0) {
        paramMenuBuilder = localMenuBuilder;
      }
      localPanelFeatureState = ActionBarActivityDelegateBase.a(localActionBarActivityDelegateBase, paramMenuBuilder);
      if (localPanelFeatureState != null)
      {
        if (i == 0) {
          break;
        }
        ActionBarActivityDelegateBase.a(this.a, localPanelFeatureState.a, localPanelFeatureState, localMenuBuilder);
        ActionBarActivityDelegateBase.a(this.a, localPanelFeatureState, true);
      }
      return;
    }
    this.a.a.closeOptionsMenu();
    ActionBarActivityDelegateBase.a(this.a, localPanelFeatureState, paramBoolean);
  }
  
  public boolean a(MenuBuilder paramMenuBuilder)
  {
    if ((paramMenuBuilder == null) && (this.a.b))
    {
      WindowCallback localWindowCallback = this.a.m();
      if ((localWindowCallback != null) && (!this.a.o())) {
        localWindowCallback.c(8, paramMenuBuilder);
      }
    }
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.PanelMenuPresenterCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */