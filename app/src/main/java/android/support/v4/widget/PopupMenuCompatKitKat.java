package android.support.v4.widget;

import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

class PopupMenuCompatKitKat
{
  public static View.OnTouchListener getDragToOpenListener(Object paramObject)
  {
    return ((PopupMenu)paramObject).getDragToOpenListener();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.PopupMenuCompatKitKat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */