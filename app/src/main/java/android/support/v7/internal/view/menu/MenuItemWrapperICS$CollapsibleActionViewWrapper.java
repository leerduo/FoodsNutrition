package android.support.v7.internal.view.menu;

import android.view.View;
import android.widget.FrameLayout;

class MenuItemWrapperICS$CollapsibleActionViewWrapper
  extends FrameLayout
  implements android.support.v7.view.CollapsibleActionView
{
  final android.view.CollapsibleActionView a;
  
  MenuItemWrapperICS$CollapsibleActionViewWrapper(View paramView)
  {
    super(paramView.getContext());
    this.a = ((android.view.CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  public void a()
  {
    this.a.onActionViewExpanded();
  }
  
  public void b()
  {
    this.a.onActionViewCollapsed();
  }
  
  View c()
  {
    return (View)this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */