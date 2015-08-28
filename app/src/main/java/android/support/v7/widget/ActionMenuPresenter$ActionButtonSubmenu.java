package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.MenuItem;
import android.view.View;

class ActionMenuPresenter$ActionButtonSubmenu
  extends MenuPopupHelper
{
  private SubMenuBuilder d;
  
  public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, SubMenuBuilder paramSubMenuBuilder)
  {
    super(paramContext, paramSubMenuBuilder, null, false, R.attr.actionOverflowMenuStyle);
    this.d = paramSubMenuBuilder;
    View localView;
    int i;
    if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).i())
    {
      if (ActionMenuPresenter.d(paramActionMenuPresenter) == null)
      {
        localView = (View)ActionMenuPresenter.e(paramActionMenuPresenter);
        a(localView);
      }
    }
    else
    {
      a(paramActionMenuPresenter.g);
      i = paramSubMenuBuilder.size();
    }
    for (int j = 0;; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        MenuItem localMenuItem = paramSubMenuBuilder.getItem(j);
        if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null)) {
          bool = true;
        }
      }
      else
      {
        b(bool);
        return;
        localView = ActionMenuPresenter.d(paramActionMenuPresenter);
        break;
      }
    }
  }
  
  public void onDismiss()
  {
    super.onDismiss();
    ActionMenuPresenter.a(this.c, null);
    this.c.h = 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionButtonSubmenu
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */