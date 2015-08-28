package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.view.View;

class ActionMenuPresenter$OverflowPopup
  extends MenuPopupHelper
{
  public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
  {
    super(paramContext, paramMenuBuilder, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
    a(8388613);
    a(paramActionMenuPresenter.g);
  }
  
  public void onDismiss()
  {
    super.onDismiss();
    ActionMenuPresenter.c(this.c).close();
    ActionMenuPresenter.a(this.c, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowPopup
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */