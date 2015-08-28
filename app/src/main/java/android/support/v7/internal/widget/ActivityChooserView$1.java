package android.support.v7.internal.widget;

import android.database.DataSetObserver;

class ActivityChooserView$1
  extends DataSetObserver
{
  ActivityChooserView$1(ActivityChooserView paramActivityChooserView) {}
  
  public void onChanged()
  {
    super.onChanged();
    ActivityChooserView.a(this.a).notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    ActivityChooserView.a(this.a).notifyDataSetInvalidated();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */