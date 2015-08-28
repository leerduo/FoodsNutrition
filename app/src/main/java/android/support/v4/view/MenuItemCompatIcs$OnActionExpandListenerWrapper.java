package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemCompatIcs$OnActionExpandListenerWrapper
  implements MenuItem.OnActionExpandListener
{
  private MenuItemCompatIcs.SupportActionExpandProxy mWrapped;
  
  public MenuItemCompatIcs$OnActionExpandListenerWrapper(MenuItemCompatIcs.SupportActionExpandProxy paramSupportActionExpandProxy)
  {
    this.mWrapped = paramSupportActionExpandProxy;
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return this.mWrapped.onMenuItemActionCollapse(paramMenuItem);
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return this.mWrapped.onMenuItemActionExpand(paramMenuItem);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompatIcs.OnActionExpandListenerWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */