package com.boohee.food;

import android.widget.ImageView;
import butterknife.ButterKnife.Finder;

public class LargeImageActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LargeImageActivity paramLargeImageActivity, Object paramObject)
  {
    paramLargeImageActivity.a = ((ImageView)paramFinder.a(paramObject, 2131427462, "field 'ivLargeImage'"));
  }
  
  public static void reset(LargeImageActivity paramLargeImageActivity)
  {
    paramLargeImageActivity.a = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.LargeImageActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */