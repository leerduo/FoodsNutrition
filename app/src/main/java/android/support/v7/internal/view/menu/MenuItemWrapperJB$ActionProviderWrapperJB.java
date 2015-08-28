package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class MenuItemWrapperJB$ActionProviderWrapperJB
  extends MenuItemWrapperICS.ActionProviderWrapper
  implements android.view.ActionProvider.VisibilityListener
{
  android.support.v4.view.ActionProvider.VisibilityListener c;
  
  public MenuItemWrapperJB$ActionProviderWrapperJB(MenuItemWrapperJB paramMenuItemWrapperJB, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramMenuItemWrapperJB, paramContext, paramActionProvider);
  }
  
  public boolean isVisible()
  {
    return this.a.isVisible();
  }
  
  public void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.onActionProviderVisibilityChanged(paramBoolean);
    }
  }
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return this.a.onCreateActionView(paramMenuItem);
  }
  
  public boolean overridesItemVisibility()
  {
    return this.a.overridesItemVisibility();
  }
  
  public void refreshVisibility()
  {
    this.a.refreshVisibility();
  }
  
  public void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener paramVisibilityListener)
  {
    this.c = paramVisibilityListener;
    ActionProvider localActionProvider = this.a;
    if (paramVisibilityListener != null) {}
    for (;;)
    {
      localActionProvider.setVisibilityListener(this);
      return;
      this = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperJB.ActionProviderWrapperJB
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */