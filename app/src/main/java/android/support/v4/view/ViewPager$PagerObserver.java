package android.support.v4.view;

import android.database.DataSetObserver;

class ViewPager$PagerObserver
  extends DataSetObserver
{
  private ViewPager$PagerObserver(ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    this.this$0.dataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.this$0.dataSetChanged();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager.PagerObserver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */