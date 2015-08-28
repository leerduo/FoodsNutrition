package android.support.v7.widget;

import android.database.DataSetObserver;

class ListPopupWindow$PopupDataSetObserver
  extends DataSetObserver
{
  private ListPopupWindow$PopupDataSetObserver(ListPopupWindow paramListPopupWindow) {}
  
  public void onChanged()
  {
    if (this.a.b()) {
      this.a.c();
    }
  }
  
  public void onInvalidated()
  {
    this.a.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.PopupDataSetObserver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */