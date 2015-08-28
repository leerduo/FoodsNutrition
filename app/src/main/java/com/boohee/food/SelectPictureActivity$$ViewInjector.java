package com.boohee.food;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SelectPictureActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SelectPictureActivity paramSelectPictureActivity, Object paramObject)
  {
    paramFinder.a(paramObject, 2131427503, "method 'onClick'").setOnClickListener(new SelectPictureActivity..ViewInjector.1(paramSelectPictureActivity));
    paramFinder.a(paramObject, 2131427502, "method 'onClick'").setOnClickListener(new SelectPictureActivity..ViewInjector.2(paramSelectPictureActivity));
  }
  
  public static void reset(SelectPictureActivity paramSelectPictureActivity) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SelectPictureActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */