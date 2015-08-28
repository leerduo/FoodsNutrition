package com.astuetz;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class PagerSlidingTabStrip$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PagerSlidingTabStrip$3(PagerSlidingTabStrip paramPagerSlidingTabStrip) {}
  
  public void onGlobalLayout()
  {
    View localView = PagerSlidingTabStrip.c(this.a).getChildAt(0);
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      if (PagerSlidingTabStrip.g(this.a))
      {
        int i = localView.getWidth() / 2;
        PagerSlidingTabStrip.c(this.a, this.a.getWidth() / 2 - i);
      }
      this.a.setPadding(PagerSlidingTabStrip.h(this.a), this.a.getPaddingTop(), PagerSlidingTabStrip.h(this.a), this.a.getPaddingBottom());
      if (PagerSlidingTabStrip.i(this.a) == 0) {
        PagerSlidingTabStrip.d(this.a, this.a.getWidth() / 2 - PagerSlidingTabStrip.h(this.a));
      }
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.PagerSlidingTabStrip.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */