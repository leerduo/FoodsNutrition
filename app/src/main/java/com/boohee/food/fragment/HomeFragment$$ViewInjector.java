package com.boohee.food.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.boohee.food.view.MultiViewPager;

public class HomeFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, HomeFragment paramHomeFragment, Object paramObject)
  {
    paramHomeFragment.a = ((MultiViewPager)paramFinder.a(paramObject, 2131427448, "field 'mViewPager'"));
    paramHomeFragment.b = ((TextView)paramFinder.a(paramObject, 2131427572, "field 'mTileTextView'"));
    paramHomeFragment.c = ((TextView)paramFinder.a(paramObject, 2131427573, "field 'mSubTitle'"));
    paramHomeFragment.d = ((ImageView)paramFinder.a(paramObject, 2131427570, "field 'iv_bg'"));
    paramHomeFragment.e = ((SwipeRefreshLayout)paramFinder.a(paramObject, 2131427569, "field 'viewSwipeRefresh'"));
    paramFinder.a(paramObject, 2131427571, "method 'onClick'").setOnClickListener(new HomeFragment..ViewInjector.1(paramHomeFragment));
    paramFinder.a(paramObject, 2131427453, "method 'onClick'").setOnClickListener(new HomeFragment..ViewInjector.2(paramHomeFragment));
  }
  
  public static void reset(HomeFragment paramHomeFragment)
  {
    paramHomeFragment.a = null;
    paramHomeFragment.b = null;
    paramHomeFragment.c = null;
    paramHomeFragment.d = null;
    paramHomeFragment.e = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */