package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListAdapter;

class SpinnerCompat$DialogPopup
  implements DialogInterface.OnClickListener, SpinnerCompat.SpinnerPopup
{
  private AlertDialog b;
  private ListAdapter c;
  private CharSequence d;
  
  private SpinnerCompat$DialogPopup(SpinnerCompat paramSpinnerCompat) {}
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.dismiss();
      this.b = null;
    }
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    this.c = paramListAdapter;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  public boolean b()
  {
    if (this.b != null) {
      return this.b.isShowing();
    }
    return false;
  }
  
  public void c()
  {
    if (this.c == null) {
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a.getContext());
    if (this.d != null) {
      localBuilder.setTitle(this.d);
    }
    this.b = localBuilder.setSingleChoiceItems(this.c, this.a.getSelectedItemPosition(), this).create();
    this.b.show();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setSelection(paramInt);
    if (this.a.s != null) {
      this.a.a(null, paramInt, this.c.getItemId(paramInt));
    }
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.DialogPopup
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */