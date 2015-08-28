package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.widget.ListAdapter;

class SpinnerCompat$DropdownPopup
  extends ListPopupWindow
  implements SpinnerCompat.SpinnerPopup
{
  private CharSequence c;
  private ListAdapter d;
  
  public SpinnerCompat$DropdownPopup(SpinnerCompat paramSpinnerCompat, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramSpinnerCompat);
    a(true);
    a(0);
    a(new SpinnerCompat.DropdownPopup.1(this, paramSpinnerCompat));
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    super.a(paramListAdapter);
    this.d = paramListAdapter;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.DropdownPopup
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */