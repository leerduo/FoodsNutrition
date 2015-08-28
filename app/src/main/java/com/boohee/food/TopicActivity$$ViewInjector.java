package com.boohee.food;

import android.support.v4.view.ViewPager;
import butterknife.ButterKnife.Finder;
import com.viewpagerindicator.LinePageIndicator;

public class TopicActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, TopicActivity paramTopicActivity, Object paramObject)
  {
    paramTopicActivity.b = ((ViewPager)paramFinder.a(paramObject, 2131427460, "field 'mPager'"));
    paramTopicActivity.c = ((LinePageIndicator)paramFinder.a(paramObject, 2131427461, "field 'mIndicator'"));
  }
  
  public static void reset(TopicActivity paramTopicActivity)
  {
    paramTopicActivity.b = null;
    paramTopicActivity.c = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.TopicActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */