package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

abstract interface MenuItemCompat$MenuVersionImpl
{
  public abstract boolean collapseActionView(MenuItem paramMenuItem);
  
  public abstract boolean expandActionView(MenuItem paramMenuItem);
  
  public abstract View getActionView(MenuItem paramMenuItem);
  
  public abstract boolean isActionViewExpanded(MenuItem paramMenuItem);
  
  public abstract MenuItem setActionView(MenuItem paramMenuItem, int paramInt);
  
  public abstract MenuItem setActionView(MenuItem paramMenuItem, View paramView);
  
  public abstract MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener);
  
  public abstract void setShowAsAction(MenuItem paramMenuItem, int paramInt);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat.MenuVersionImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */