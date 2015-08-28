package android.support.v7.internal.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuItem;

public class SupportActionModeWrapper$CallbackWrapper
  implements android.support.v7.view.ActionMode.Callback
{
  final android.view.ActionMode.Callback a;
  final Context b;
  final SimpleArrayMap<android.support.v7.view.ActionMode, SupportActionModeWrapper> c;
  final SimpleArrayMap<Menu, Menu> d;
  
  public SupportActionModeWrapper$CallbackWrapper(Context paramContext, android.view.ActionMode.Callback paramCallback)
  {
    this.b = paramContext;
    this.a = paramCallback;
    this.c = new SimpleArrayMap();
    this.d = new SimpleArrayMap();
  }
  
  private Menu a(Menu paramMenu)
  {
    Menu localMenu = (Menu)this.d.get(paramMenu);
    if (localMenu == null)
    {
      localMenu = MenuWrapperFactory.a(this.b, (SupportMenu)paramMenu);
      this.d.put(paramMenu, localMenu);
    }
    return localMenu;
  }
  
  private android.view.ActionMode b(android.support.v7.view.ActionMode paramActionMode)
  {
    SupportActionModeWrapper localSupportActionModeWrapper1 = (SupportActionModeWrapper)this.c.get(paramActionMode);
    if (localSupportActionModeWrapper1 != null) {
      return localSupportActionModeWrapper1;
    }
    SupportActionModeWrapper localSupportActionModeWrapper2 = new SupportActionModeWrapper(this.b, paramActionMode);
    this.c.put(paramActionMode, localSupportActionModeWrapper2);
    return localSupportActionModeWrapper2;
  }
  
  public void a(android.support.v7.view.ActionMode paramActionMode)
  {
    this.a.onDestroyActionMode(b(paramActionMode));
  }
  
  public boolean a(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
  {
    return this.a.onCreateActionMode(b(paramActionMode), a(paramMenu));
  }
  
  public boolean a(android.support.v7.view.ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.a.onActionItemClicked(b(paramActionMode), MenuWrapperFactory.a(this.b, (SupportMenuItem)paramMenuItem));
  }
  
  public boolean b(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
  {
    return this.a.onPrepareActionMode(b(paramActionMode), a(paramMenu));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportActionModeWrapper.CallbackWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */