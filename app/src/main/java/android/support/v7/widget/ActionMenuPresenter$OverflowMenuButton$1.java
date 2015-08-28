package android.support.v7.widget;

import android.view.View;

class ActionMenuPresenter$OverflowMenuButton$1
  extends ListPopupWindow.ForwardingListener
{
  ActionMenuPresenter$OverflowMenuButton$1(ActionMenuPresenter.OverflowMenuButton paramOverflowMenuButton, View paramView, ActionMenuPresenter paramActionMenuPresenter)
  {
    super(paramView);
  }
  
  public ListPopupWindow a()
  {
    if (ActionMenuPresenter.a(this.b.a) == null) {
      return null;
    }
    return ActionMenuPresenter.a(this.b.a).c();
  }
  
  public boolean b()
  {
    this.b.a.c();
    return true;
  }
  
  public boolean c()
  {
    if (ActionMenuPresenter.b(this.b.a) != null) {
      return false;
    }
    this.b.a.d();
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */