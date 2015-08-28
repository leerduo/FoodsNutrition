package com.boohee.food;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class MoreActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MoreActivity paramMoreActivity, Object paramObject)
  {
    paramMoreActivity.b = ((TextView)paramFinder.a(paramObject, 2131427482, "field 'tvVersion'"));
    paramFinder.a(paramObject, 2131427479, "method 'onClick'").setOnClickListener(new MoreActivity..ViewInjector.1(paramMoreActivity));
    paramFinder.a(paramObject, 2131427480, "method 'onClick'").setOnClickListener(new MoreActivity..ViewInjector.2(paramMoreActivity));
    paramFinder.a(paramObject, 2131427481, "method 'onClick'").setOnClickListener(new MoreActivity..ViewInjector.3(paramMoreActivity));
  }
  
  public static void reset(MoreActivity paramMoreActivity)
  {
    paramMoreActivity.b = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.MoreActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */