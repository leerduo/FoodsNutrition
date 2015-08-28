package android.support.v7.internal.view.menu;

import android.content.Context;

public abstract interface MenuPresenter
{
  public abstract void a(Context paramContext, MenuBuilder paramMenuBuilder);
  
  public abstract void a(MenuBuilder paramMenuBuilder, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
  
  public abstract boolean a(SubMenuBuilder paramSubMenuBuilder);
  
  public abstract boolean b();
  
  public abstract boolean b(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuPresenter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */