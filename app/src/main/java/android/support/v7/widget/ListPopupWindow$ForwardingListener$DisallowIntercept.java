package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;

class ListPopupWindow$ForwardingListener$DisallowIntercept
  implements Runnable
{
  private ListPopupWindow$ForwardingListener$DisallowIntercept(ListPopupWindow.ForwardingListener paramForwardingListener) {}
  
  public void run()
  {
    ListPopupWindow.ForwardingListener.a(this.a).getParent().requestDisallowInterceptTouchEvent(true);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ForwardingListener.DisallowIntercept
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */