package m.framework.ui.widget.pulltorefresh;

import android.content.Context;
import android.view.View;

public abstract class PullToRefreshAdatper
{
  private Context context;
  private PullToRefreshView parent;
  
  public PullToRefreshAdatper(PullToRefreshView paramPullToRefreshView)
  {
    this.context = paramPullToRefreshView.getContext();
    this.parent = paramPullToRefreshView;
  }
  
  public abstract Scrollable getBodyView();
  
  public Context getContext()
  {
    return this.context;
  }
  
  public abstract View getHeaderView();
  
  protected PullToRefreshView getParent()
  {
    return this.parent;
  }
  
  public abstract boolean isPullReady();
  
  public void notifyDataSetChanged()
  {
    this.parent.a();
  }
  
  public abstract void onPullDown(int paramInt);
  
  public abstract void onRequest();
  
  public void onReversed() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.pulltorefresh.PullToRefreshAdatper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */