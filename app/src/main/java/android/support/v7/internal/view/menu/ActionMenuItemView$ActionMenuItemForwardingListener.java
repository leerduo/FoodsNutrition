package android.support.v7.internal.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;

class ActionMenuItemView$ActionMenuItemForwardingListener
  extends ListPopupWindow.ForwardingListener
{
  public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public ListPopupWindow a()
  {
    if (ActionMenuItemView.a(this.a) != null) {
      return ActionMenuItemView.a(this.a).a();
    }
    return null;
  }
  
  protected boolean b()
  {
    MenuBuilder.ItemInvoker localItemInvoker = ActionMenuItemView.b(this.a);
    boolean bool1 = false;
    if (localItemInvoker != null)
    {
      boolean bool2 = ActionMenuItemView.b(this.a).a(ActionMenuItemView.c(this.a));
      bool1 = false;
      if (bool2)
      {
        ListPopupWindow localListPopupWindow = a();
        bool1 = false;
        if (localListPopupWindow != null)
        {
          boolean bool3 = localListPopupWindow.b();
          bool1 = false;
          if (bool3) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean c()
  {
    ListPopupWindow localListPopupWindow = a();
    if (localListPopupWindow != null)
    {
      localListPopupWindow.a();
      return true;
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */