package android.support.v7.widget;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;

class ActionMenuView$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  private ActionMenuView$MenuBuilderCallback(ActionMenuView paramActionMenuView) {}
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    if (ActionMenuView.b(this.a) != null) {
      ActionMenuView.b(this.a).a(paramMenuBuilder);
    }
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (ActionMenuView.a(this.a) != null) && (ActionMenuView.a(this.a).a(paramMenuItem));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView.MenuBuilderCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */