package android.support.v7.widget;

import android.widget.PopupWindow;

class ListPopupWindow$ResizePopupRunnable
  implements Runnable
{
  private ListPopupWindow$ResizePopupRunnable(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    if ((ListPopupWindow.a(this.a) != null) && (ListPopupWindow.a(this.a).getCount() > ListPopupWindow.a(this.a).getChildCount()) && (ListPopupWindow.a(this.a).getChildCount() <= this.a.b))
    {
      ListPopupWindow.b(this.a).setInputMethodMode(2);
      this.a.c();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ResizePopupRunnable
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */