package com.boohee.food;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class LightIntroduceActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LightIntroduceActivity paramLightIntroduceActivity, Object paramObject)
  {
    paramLightIntroduceActivity.b = ((TextView)paramFinder.a(paramObject, 2131427465, "field 'tvGreen'"));
    paramLightIntroduceActivity.c = ((TextView)paramFinder.a(paramObject, 2131427468, "field 'tvYellow'"));
    paramLightIntroduceActivity.d = ((TextView)paramFinder.a(paramObject, 2131427471, "field 'tvRed'"));
  }
  
  public static void reset(LightIntroduceActivity paramLightIntroduceActivity)
  {
    paramLightIntroduceActivity.b = null;
    paramLightIntroduceActivity.c = null;
    paramLightIntroduceActivity.d = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.LightIntroduceActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */