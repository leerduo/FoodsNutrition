package com.boohee.food;

import android.view.View;
import butterknife.ButterKnife.Finder;
import com.boohee.food.view.BooheeListView;

public class CollectionActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, CollectionActivity paramCollectionActivity, Object paramObject)
  {
    paramCollectionActivity.b = ((BooheeListView)paramFinder.a(paramObject, 2131427421, "field 'blvContent'"));
    paramCollectionActivity.c = paramFinder.a(paramObject, 2131427422, "field 'viewOperate'");
    paramFinder.a(paramObject, 2131427424, "method 'onClick'").setOnClickListener(new CollectionActivity..ViewInjector.1(paramCollectionActivity));
    paramFinder.a(paramObject, 2131427425, "method 'onClick'").setOnClickListener(new CollectionActivity..ViewInjector.2(paramCollectionActivity));
  }
  
  public static void reset(CollectionActivity paramCollectionActivity)
  {
    paramCollectionActivity.b = null;
    paramCollectionActivity.c = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.CollectionActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */