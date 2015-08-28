package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.SubMenu;
import android.view.View;

class MenuItemWrapperICS$ActionProviderWrapper
  extends android.support.v4.view.ActionProvider
{
  final android.view.ActionProvider a;
  
  public MenuItemWrapperICS$ActionProviderWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, Context paramContext, android.view.ActionProvider paramActionProvider)
  {
    super(paramContext);
    this.a = paramActionProvider;
  }
  
  public boolean hasSubMenu()
  {
    return this.a.hasSubMenu();
  }
  
  public View onCreateActionView()
  {
    return this.a.onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return this.a.onPerformDefaultAction();
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    this.a.onPrepareSubMenu(this.b.a(paramSubMenu));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.ActionProviderWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */