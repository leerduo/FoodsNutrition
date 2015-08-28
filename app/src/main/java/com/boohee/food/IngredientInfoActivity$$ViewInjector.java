package com.boohee.food;

import android.widget.ListView;
import butterknife.ButterKnife.Finder;

public class IngredientInfoActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, IngredientInfoActivity paramIngredientInfoActivity, Object paramObject)
  {
    paramIngredientInfoActivity.b = ((ListView)paramFinder.a(paramObject, 2131427441, "field 'lvMain'"));
  }
  
  public static void reset(IngredientInfoActivity paramIngredientInfoActivity)
  {
    paramIngredientInfoActivity.b = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.IngredientInfoActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */