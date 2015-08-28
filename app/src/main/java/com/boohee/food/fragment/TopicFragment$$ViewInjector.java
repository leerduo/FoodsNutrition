package com.boohee.food.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class TopicFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, TopicFragment paramTopicFragment, Object paramObject)
  {
    paramTopicFragment.a = ((ImageView)paramFinder.a(paramObject, 2131427580, "field 'ivHead'"));
    paramTopicFragment.b = ((TextView)paramFinder.a(paramObject, 2131427581, "field 'tvName'"));
    paramTopicFragment.c = ((TextView)paramFinder.a(paramObject, 2131427582, "field 'tvDescription'"));
    paramFinder.a(paramObject, 2131427583, "method 'onSeeDetail'").setOnClickListener(new TopicFragment..ViewInjector.1(paramTopicFragment));
  }
  
  public static void reset(TopicFragment paramTopicFragment)
  {
    paramTopicFragment.a = null;
    paramTopicFragment.b = null;
    paramTopicFragment.c = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.TopicFragment..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */