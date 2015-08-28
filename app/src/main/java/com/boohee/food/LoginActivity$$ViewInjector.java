package com.boohee.food;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LoginActivity paramLoginActivity, Object paramObject)
  {
    paramLoginActivity.b = ((EditText)paramFinder.a(paramObject, 2131427473, "field 'etUserName'"));
    paramLoginActivity.c = ((EditText)paramFinder.a(paramObject, 2131427474, "field 'etPassword'"));
    View localView = paramFinder.a(paramObject, 2131427475, "field 'btLogin' and method 'booheeLogin'");
    paramLoginActivity.d = ((Button)localView);
    localView.setOnClickListener(new LoginActivity..ViewInjector.1(paramLoginActivity));
  }
  
  public static void reset(LoginActivity paramLoginActivity)
  {
    paramLoginActivity.b = null;
    paramLoginActivity.c = null;
    paramLoginActivity.d = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.LoginActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */