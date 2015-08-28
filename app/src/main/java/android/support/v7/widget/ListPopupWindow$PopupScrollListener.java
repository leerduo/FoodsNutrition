package android.support.v7.widget;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.PopupWindow;

class ListPopupWindow$PopupScrollListener
  implements AbsListView.OnScrollListener
{
  private ListPopupWindow$PopupScrollListener(ListPopupWindow paramListPopupWindow) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) && (!this.a.f()) && (ListPopupWindow.b(this.a).getContentView() != null))
    {
      ListPopupWindow.d(this.a).removeCallbacks(ListPopupWindow.c(this.a));
      ListPopupWindow.c(this.a).run();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.PopupScrollListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */