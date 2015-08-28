package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.widget.ImageButton;

class Toolbar$ExpandedActionViewMenuPresenter
  implements MenuPresenter
{
  MenuBuilder a;
  MenuItemImpl b;
  
  private Toolbar$ExpandedActionViewMenuPresenter(Toolbar paramToolbar) {}
  
  public void a(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    if ((this.a != null) && (this.b != null)) {
      this.a.d(this.b);
    }
    this.a = paramMenuBuilder;
  }
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    int i;
    int j;
    if (this.b != null)
    {
      MenuBuilder localMenuBuilder = this.a;
      i = 0;
      if (localMenuBuilder != null) {
        j = this.a.size();
      }
    }
    for (int k = 0;; k++)
    {
      i = 0;
      if (k < j)
      {
        if (this.a.getItem(k) == this.b) {
          i = 1;
        }
      }
      else
      {
        if (i == 0) {
          b(this.a, this.b);
        }
        return;
      }
    }
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    Toolbar.b(this.c);
    if (Toolbar.c(this.c).getParent() != this.c) {
      this.c.addView(Toolbar.c(this.c));
    }
    this.c.a = paramMenuItemImpl.getActionView();
    this.b = paramMenuItemImpl;
    if (this.c.a.getParent() != this.c)
    {
      Toolbar.LayoutParams localLayoutParams = this.c.i();
      localLayoutParams.a = (0x800003 | 0x70 & Toolbar.d(this.c));
      localLayoutParams.b = 2;
      this.c.a.setLayoutParams(localLayoutParams);
      this.c.addView(this.c.a);
    }
    Toolbar.a(this.c, true);
    this.c.requestLayout();
    paramMenuItemImpl.e(true);
    if ((this.c.a instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.c.a).a();
    }
    return true;
  }
  
  public boolean a(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    if ((this.c.a instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.c.a).b();
    }
    this.c.removeView(this.c.a);
    this.c.removeView(Toolbar.c(this.c));
    this.c.a = null;
    Toolbar.a(this.c, false);
    this.b = null;
    this.c.requestLayout();
    paramMenuItemImpl.e(false);
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.Toolbar.ExpandedActionViewMenuPresenter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */