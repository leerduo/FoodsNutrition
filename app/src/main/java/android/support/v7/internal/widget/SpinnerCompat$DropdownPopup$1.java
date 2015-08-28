package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

class SpinnerCompat$DropdownPopup$1
  implements AdapterView.OnItemClickListener
{
  SpinnerCompat$DropdownPopup$1(SpinnerCompat.DropdownPopup paramDropdownPopup, SpinnerCompat paramSpinnerCompat) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.a.setSelection(paramInt);
    if (this.b.a.s != null) {
      this.b.a.a(paramView, paramInt, SpinnerCompat.DropdownPopup.a(this.b).getItemId(paramInt));
    }
    this.b.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */