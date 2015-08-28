package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class BaseMenuWrapper<T>
  extends BaseWrapper<T>
{
  final Context a;
  private Map<SupportMenuItem, MenuItem> c;
  private Map<SupportSubMenu, SubMenu> d;
  
  BaseMenuWrapper(Context paramContext, T paramT)
  {
    super(paramT);
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)paramMenuItem;
      if (this.c == null) {
        this.c = new ArrayMap();
      }
      MenuItem localMenuItem = (MenuItem)this.c.get(paramMenuItem);
      if (localMenuItem == null)
      {
        localMenuItem = MenuWrapperFactory.a(this.a, localSupportMenuItem);
        this.c.put(localSupportMenuItem, localMenuItem);
      }
      return localMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof SupportSubMenu))
    {
      SupportSubMenu localSupportSubMenu = (SupportSubMenu)paramSubMenu;
      if (this.d == null) {
        this.d = new ArrayMap();
      }
      SubMenu localSubMenu = (SubMenu)this.d.get(localSupportSubMenu);
      if (localSubMenu == null)
      {
        localSubMenu = MenuWrapperFactory.a(this.a, localSupportSubMenu);
        this.d.put(localSupportSubMenu, localSubMenu);
      }
      return localSubMenu;
    }
    return paramSubMenu;
  }
  
  final void a()
  {
    if (this.c != null) {
      this.c.clear();
    }
    if (this.d != null) {
      this.d.clear();
    }
  }
  
  final void a(int paramInt)
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
          localIterator.remove();
        }
      }
    }
  }
  
  final void b(int paramInt)
  {
    if (this.c == null) {}
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext()) {
        localIterator = this.c.keySet().iterator();
      }
    } while (paramInt != ((MenuItem)localIterator.next()).getItemId());
    localIterator.remove();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.BaseMenuWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */