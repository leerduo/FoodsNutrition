package android.support.v7.internal.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public abstract interface WindowCallback
{
  public abstract View a(int paramInt);
  
  public abstract boolean a(int paramInt, Menu paramMenu);
  
  public abstract boolean a(int paramInt, MenuItem paramMenuItem);
  
  public abstract boolean a(int paramInt, View paramView, Menu paramMenu);
  
  public abstract void b(int paramInt, Menu paramMenu);
  
  public abstract boolean c(int paramInt, Menu paramMenu);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */