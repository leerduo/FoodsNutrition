package android.support.v7.widget;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.MenuItem;

class ActionMenuPresenter$PopupPresenterCallback
  implements MenuPresenter.Callback
{
  private ActionMenuPresenter$PopupPresenterCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((paramMenuBuilder instanceof SubMenuBuilder)) {
      ((SubMenuBuilder)paramMenuBuilder).p().a(false);
    }
    MenuPresenter.Callback localCallback = this.a.a();
    if (localCallback != null) {
      localCallback.a(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean a(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder == null) {
      return false;
    }
    this.a.h = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
    MenuPresenter.Callback localCallback = this.a.a();
    if (localCallback != null) {}
    for (boolean bool = localCallback.a(paramMenuBuilder);; bool = false) {
      return bool;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.PopupPresenterCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */