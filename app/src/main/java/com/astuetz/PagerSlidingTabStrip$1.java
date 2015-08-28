package com.astuetz;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class PagerSlidingTabStrip$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PagerSlidingTabStrip$1(PagerSlidingTabStrip paramPagerSlidingTabStrip) {}
  
  @SuppressLint({"NewApi"})
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      PagerSlidingTabStrip.a(this.a, PagerSlidingTabStrip.a(this.a).getCurrentItem());
      PagerSlidingTabStrip.a(this.a, 0.0F);
      PagerSlidingTabStrip.a(this.a, PagerSlidingTabStrip.b(this.a), 0);
      PagerSlidingTabStrip.b(this.a, PagerSlidingTabStrip.b(this.a));
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.PagerSlidingTabStrip.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */