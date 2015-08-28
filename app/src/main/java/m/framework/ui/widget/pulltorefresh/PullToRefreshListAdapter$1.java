package m.framework.ui.widget.pulltorefresh;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class PullToRefreshListAdapter$1
  implements AbsListView.OnScrollListener
{
  private int b;
  private int c;
  
  PullToRefreshListAdapter$1(PullToRefreshListAdapter paramPullToRefreshListAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a.onScroll(PullToRefreshListAdapter.access$3(this.a), paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    PullToRefreshListAdapter localPullToRefreshListAdapter = this.a;
    boolean bool;
    if (paramInt == 2)
    {
      bool = true;
      PullToRefreshListAdapter.access$0(localPullToRefreshListAdapter, bool);
      if (paramInt == 0)
      {
        if (PullToRefreshListAdapter.access$1(this.a) == null) {
          break label60;
        }
        PullToRefreshListAdapter.access$1(this.a).a(this.b, this.c);
      }
    }
    label60:
    while (PullToRefreshListAdapter.access$2(this.a) == null)
    {
      return;
      bool = false;
      break;
    }
    PullToRefreshListAdapter.access$2(this.a).notifyDataSetChanged();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.pulltorefresh.PullToRefreshListAdapter.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */