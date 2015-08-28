package com.boohee.food.fragment;

import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;

public class HomeItemFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, HomeItemFragment paramHomeItemFragment, Object paramObject)
  {
    paramHomeItemFragment.a = ((ImageView)paramFinder.a(paramObject, 2131427575, "field 'mImageView'"));
    paramHomeItemFragment.b = ((FrameLayout)paramFinder.a(paramObject, 2131427574, "field 'mCoverLayout'"));
  }
  
  public static void reset(HomeItemFragment paramHomeItemFragment)
  {
    paramHomeItemFragment.a = null;
    paramHomeItemFragment.b = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeItemFragment..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */