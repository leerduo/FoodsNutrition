package m.framework.ui.widget.pulltorefresh;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListInnerAdapter
  extends BaseAdapter
{
  private PullToRefreshBaseListAdapter a;
  
  public ListInnerAdapter(PullToRefreshBaseListAdapter paramPullToRefreshBaseListAdapter)
  {
    this.a = paramPullToRefreshBaseListAdapter;
  }
  
  public int getCount()
  {
    return this.a.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.a.getItemId(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a.getView(paramInt, paramView, paramViewGroup);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.pulltorefresh.ListInnerAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */