package android.support.v7.internal.widget;

import android.support.v7.app.ActionBar.Tab;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ScrollingTabContainerView$TabAdapter
  extends BaseAdapter
{
  private ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public int getCount()
  {
    return ScrollingTabContainerView.a(this.a).getChildCount();
  }
  
  public Object getItem(int paramInt)
  {
    return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.a(this.a).getChildAt(paramInt)).b();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      return ScrollingTabContainerView.a(this.a, (ActionBar.Tab)getItem(paramInt), true);
    }
    ((ScrollingTabContainerView.TabView)paramView).a((ActionBar.Tab)getItem(paramInt));
    return paramView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */