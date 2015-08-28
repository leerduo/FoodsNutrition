package android.support.v7.app;

import android.support.v7.internal.app.WindowCallback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

class ActionBarActivityDelegate$1
  implements WindowCallback
{
  ActionBarActivityDelegate$1(ActionBarActivityDelegate paramActionBarActivityDelegate) {}
  
  public View a(int paramInt)
  {
    return null;
  }
  
  public boolean a(int paramInt, Menu paramMenu)
  {
    return this.a.a.a(paramInt, paramMenu);
  }
  
  public boolean a(int paramInt, MenuItem paramMenuItem)
  {
    return this.a.a.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean a(int paramInt, View paramView, Menu paramMenu)
  {
    return this.a.a.a(paramInt, paramView, paramMenu);
  }
  
  public void b(int paramInt, Menu paramMenu)
  {
    this.a.a.onPanelClosed(paramInt, paramMenu);
  }
  
  public boolean c(int paramInt, Menu paramMenu)
  {
    return this.a.a.onMenuOpened(paramInt, paramMenu);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegate.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */