package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.View;

class SpinnerCompat$1
  extends ListPopupWindow.ForwardingListener
{
  SpinnerCompat$1(SpinnerCompat paramSpinnerCompat, View paramView, SpinnerCompat.DropdownPopup paramDropdownPopup)
  {
    super(paramView);
  }
  
  public ListPopupWindow a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    if (!SpinnerCompat.a(this.b).b()) {
      SpinnerCompat.a(this.b).c();
    }
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */