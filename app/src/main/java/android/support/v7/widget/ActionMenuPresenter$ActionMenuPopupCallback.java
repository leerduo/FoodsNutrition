package android.support.v7.widget;

import android.support.v7.internal.view.menu.ActionMenuItemView.PopupCallback;

class ActionMenuPresenter$ActionMenuPopupCallback
  extends ActionMenuItemView.PopupCallback
{
  private ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public ListPopupWindow a()
  {
    if (ActionMenuPresenter.h(this.a) != null) {
      return ActionMenuPresenter.h(this.a).c();
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionMenuPopupCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */