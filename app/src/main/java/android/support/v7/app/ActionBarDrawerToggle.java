package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private final ActionBarDrawerToggle.Delegate a;
  private ActionBarDrawerToggle.DrawerToggle b;
  private boolean c;
  private final int d;
  private final int e;
  
  void a(int paramInt)
  {
    this.a.setActionBarDescription(paramInt);
  }
  
  public void onDrawerClosed(View paramView)
  {
    this.b.a(0.0F);
    if (this.c) {
      a(this.d);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    this.b.a(1.0F);
    if (this.c) {
      a(this.e);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    this.b.a(Math.min(1.0F, Math.max(0.0F, paramFloat)));
  }
  
  public void onDrawerStateChanged(int paramInt) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */