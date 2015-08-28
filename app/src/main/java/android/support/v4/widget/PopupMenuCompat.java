package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;

public class PopupMenuCompat
{
  static final PopupMenuCompat.PopupMenuImpl IMPL = new PopupMenuCompat.BasePopupMenuImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new PopupMenuCompat.KitKatPopupMenuImpl();
      return;
    }
  }
  
  public static View.OnTouchListener getDragToOpenListener(Object paramObject)
  {
    return IMPL.getDragToOpenListener(paramObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.PopupMenuCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */