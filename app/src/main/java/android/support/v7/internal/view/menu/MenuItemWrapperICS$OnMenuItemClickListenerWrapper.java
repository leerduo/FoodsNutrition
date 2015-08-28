package android.support.v7.internal.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MenuItemWrapperICS$OnMenuItemClickListenerWrapper
  extends BaseWrapper<MenuItem.OnMenuItemClickListener>
  implements MenuItem.OnMenuItemClickListener
{
  MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)this.b).onMenuItemClick(this.a.a(paramMenuItem));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.OnMenuItemClickListenerWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */