package android.support.v7.widget;

import android.view.View;

class ListPopupWindow$2
  implements Runnable
{
  ListPopupWindow$2(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    View localView = this.a.d();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.a.c();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */