package com.astuetz;

import android.database.DataSetObserver;

class PagerSlidingTabStrip$PagerAdapterObserver
  extends DataSetObserver
{
  private boolean b = false;
  
  private PagerSlidingTabStrip$PagerAdapterObserver(PagerSlidingTabStrip paramPagerSlidingTabStrip) {}
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void onChanged()
  {
    this.a.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.PagerSlidingTabStrip.PagerAdapterObserver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */