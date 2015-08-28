package android.support.v7.internal.widget;

import android.support.v7.app.ActionBar.Tab;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.View.OnClickListener;

class ScrollingTabContainerView$TabClickListener
  implements View.OnClickListener
{
  private ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public void onClick(View paramView)
  {
    ((ScrollingTabContainerView.TabView)paramView).b().d();
    int i = ScrollingTabContainerView.a(this.a).getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = ScrollingTabContainerView.a(this.a).getChildAt(j);
      if (localView == paramView) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        j++;
        break;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabClickListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */