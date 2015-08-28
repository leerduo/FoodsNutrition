package android.support.v7.internal.view.menu;

import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemWrapperICS$OnActionExpandListenerWrapper
  extends BaseWrapper<MenuItem.OnActionExpandListener>
  implements MenuItemCompat.OnActionExpandListener
{
  MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionCollapse(this.a.a(paramMenuItem));
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionExpand(this.a.a(paramMenuItem));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.OnActionExpandListenerWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */