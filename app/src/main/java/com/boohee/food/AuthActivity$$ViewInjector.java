package com.boohee.food;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AuthActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AuthActivity paramAuthActivity, Object paramObject)
  {
    paramFinder.a(paramObject, 2131427417, "method 'onClick'").setOnClickListener(new AuthActivity..ViewInjector.1(paramAuthActivity));
    paramFinder.a(paramObject, 2131427416, "method 'onClick'").setOnClickListener(new AuthActivity..ViewInjector.2(paramAuthActivity));
    paramFinder.a(paramObject, 2131427418, "method 'onClick'").setOnClickListener(new AuthActivity..ViewInjector.3(paramAuthActivity));
  }
  
  public static void reset(AuthActivity paramAuthActivity) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.AuthActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */