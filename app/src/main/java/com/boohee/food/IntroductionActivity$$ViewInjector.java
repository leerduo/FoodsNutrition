package com.boohee.food;

import android.support.v4.view.ViewPager;
import butterknife.ButterKnife.Finder;
import com.viewpagerindicator.LinePageIndicator;

public class IntroductionActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, IntroductionActivity paramIntroductionActivity, Object paramObject)
  {
    paramIntroductionActivity.a = ((ViewPager)paramFinder.a(paramObject, 2131427460, "field 'mPager'"));
    paramIntroductionActivity.b = ((LinePageIndicator)paramFinder.a(paramObject, 2131427461, "field 'mIndicator'"));
  }
  
  public static void reset(IntroductionActivity paramIntroductionActivity)
  {
    paramIntroductionActivity.a = null;
    paramIntroductionActivity.b = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.IntroductionActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */