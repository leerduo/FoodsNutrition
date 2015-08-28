package com.astuetz;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

class PagerSlidingTabStrip$2
  implements View.OnClickListener
{
  PagerSlidingTabStrip$2(PagerSlidingTabStrip paramPagerSlidingTabStrip, int paramInt, View paramView) {}
  
  public void onClick(View paramView)
  {
    if (PagerSlidingTabStrip.a(this.c).getCurrentItem() != this.a)
    {
      View localView = PagerSlidingTabStrip.c(this.c).getChildAt(PagerSlidingTabStrip.a(this.c).getCurrentItem());
      PagerSlidingTabStrip.a(this.c, localView);
      PagerSlidingTabStrip.a(this.c).setCurrentItem(this.a);
    }
    do
    {
      do
      {
        return;
        if (PagerSlidingTabStrip.d(this.c) != null) {
          PagerSlidingTabStrip.d(this.c).a(this.a);
        }
      } while (this.a == 0);
      ImageView localImageView = (ImageView)this.b.findViewById(R.id.iv_indicator);
      PagerSlidingTabStrip.a(this.c, localImageView, this.a, true);
    } while (PagerSlidingTabStrip.e(this.c) == null);
    int i = PagerSlidingTabStrip.a(this.c).getCurrentItem();
    PagerSlidingTabStrip.e(this.c).a(i, PagerSlidingTabStrip.f(this.c)[i]);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.PagerSlidingTabStrip.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */