package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory
{
  public static Menu a(Context paramContext, SupportMenu paramSupportMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new MenuWrapperICS(paramContext, paramSupportMenu);
    }
    throw new UnsupportedOperationException();
  }
  
  public static MenuItem a(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new MenuItemWrapperJB(paramContext, paramSupportMenuItem);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new MenuItemWrapperICS(paramContext, paramSupportMenuItem);
    }
    throw new UnsupportedOperationException();
  }
  
  public static SubMenu a(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new SubMenuWrapperICS(paramContext, paramSupportSubMenu);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuWrapperFactory
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */