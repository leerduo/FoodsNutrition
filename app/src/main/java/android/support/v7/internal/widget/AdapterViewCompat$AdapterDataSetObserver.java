package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

class AdapterViewCompat$AdapterDataSetObserver
  extends DataSetObserver
{
  private Parcelable b = null;
  
  AdapterViewCompat$AdapterDataSetObserver(AdapterViewCompat paramAdapterViewCompat) {}
  
  public void onChanged()
  {
    this.a.u = true;
    this.a.A = this.a.z;
    this.a.z = this.a.getAdapter().getCount();
    if ((this.a.getAdapter().hasStableIds()) && (this.b != null) && (this.a.A == 0) && (this.a.z > 0))
    {
      AdapterViewCompat.a(this.a, this.b);
      this.b = null;
    }
    for (;;)
    {
      this.a.e();
      this.a.requestLayout();
      return;
      this.a.j();
    }
  }
  
  public void onInvalidated()
  {
    this.a.u = true;
    if (this.a.getAdapter().hasStableIds()) {
      this.b = AdapterViewCompat.a(this.a);
    }
    this.a.A = this.a.z;
    this.a.z = 0;
    this.a.x = -1;
    this.a.y = -9223372036854775808L;
    this.a.v = -1;
    this.a.w = -9223372036854775808L;
    this.a.o = false;
    this.a.e();
    this.a.requestLayout();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewCompat.AdapterDataSetObserver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */