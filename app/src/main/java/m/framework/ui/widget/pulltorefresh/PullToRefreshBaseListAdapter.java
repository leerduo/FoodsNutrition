package m.framework.ui.widget.pulltorefresh;

import android.view.View;
import android.view.ViewGroup;

public abstract class PullToRefreshBaseListAdapter
  extends PullToRefreshAdatper
{
  public PullToRefreshBaseListAdapter(PullToRefreshView paramPullToRefreshView)
  {
    super(paramPullToRefreshView);
  }
  
  public abstract int getCount();
  
  public abstract Object getItem(int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract boolean isFling();
  
  public abstract void onScroll(Scrollable paramScrollable, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.pulltorefresh.PullToRefreshBaseListAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */