package com.astuetz;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;

class PagerSlidingTabStrip$PageListener
  implements ViewPager.OnPageChangeListener
{
  private PagerSlidingTabStrip$PageListener(PagerSlidingTabStrip paramPagerSlidingTabStrip) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      PagerSlidingTabStrip.a(this.a, PagerSlidingTabStrip.a(this.a).getCurrentItem(), 0);
    }
    View localView1 = PagerSlidingTabStrip.c(this.a).getChildAt(PagerSlidingTabStrip.a(this.a).getCurrentItem());
    PagerSlidingTabStrip.b(this.a, localView1);
    if (-1 + PagerSlidingTabStrip.a(this.a).getCurrentItem() >= 0)
    {
      View localView3 = PagerSlidingTabStrip.c(this.a).getChildAt(-1 + PagerSlidingTabStrip.a(this.a).getCurrentItem());
      PagerSlidingTabStrip.a(this.a, localView3);
    }
    if (1 + PagerSlidingTabStrip.a(this.a).getCurrentItem() <= -1 + PagerSlidingTabStrip.a(this.a).getAdapter().getCount())
    {
      View localView2 = PagerSlidingTabStrip.c(this.a).getChildAt(1 + PagerSlidingTabStrip.a(this.a).getCurrentItem());
      PagerSlidingTabStrip.a(this.a, localView2);
    }
    if (this.a.a != null) {
      this.a.a.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    PagerSlidingTabStrip.a(this.a, paramInt1);
    PagerSlidingTabStrip.a(this.a, paramFloat);
    if (PagerSlidingTabStrip.j(this.a) > 0) {}
    for (int i = (int)(paramFloat * PagerSlidingTabStrip.c(this.a).getChildAt(paramInt1).getWidth());; i = 0)
    {
      PagerSlidingTabStrip.a(this.a, paramInt1, i);
      this.a.invalidate();
      if (this.a.a != null) {
        this.a.a.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    PagerSlidingTabStrip.b(this.a, paramInt);
    PagerSlidingTabStrip.e(this.a, paramInt);
    if (this.a.a != null) {
      this.a.a.onPageSelected(paramInt);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.PagerSlidingTabStrip.PageListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */