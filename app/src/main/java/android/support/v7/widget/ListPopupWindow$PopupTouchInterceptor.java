package android.support.v7.widget;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class ListPopupWindow$PopupTouchInterceptor
  implements View.OnTouchListener
{
  private ListPopupWindow$PopupTouchInterceptor(ListPopupWindow paramListPopupWindow) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (ListPopupWindow.b(this.a) != null) && (ListPopupWindow.b(this.a).isShowing()) && (j >= 0) && (j < ListPopupWindow.b(this.a).getWidth()) && (k >= 0) && (k < ListPopupWindow.b(this.a).getHeight())) {
      ListPopupWindow.d(this.a).postDelayed(ListPopupWindow.c(this.a), 250L);
    }
    for (;;)
    {
      return false;
      if (i == 1) {
        ListPopupWindow.d(this.a).removeCallbacks(ListPopupWindow.c(this.a));
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.PopupTouchInterceptor
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */