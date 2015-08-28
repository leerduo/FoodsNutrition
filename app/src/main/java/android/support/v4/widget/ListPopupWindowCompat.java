package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnTouchListener;

public class ListPopupWindowCompat
{
  static final ListPopupWindowCompat.ListPopupWindowImpl IMPL = new ListPopupWindowCompat.BaseListPopupWindowImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new ListPopupWindowCompat.KitKatListPopupWindowImpl();
      return;
    }
  }
  
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return IMPL.createDragToOpenListener(paramObject, paramView);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ListPopupWindowCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */