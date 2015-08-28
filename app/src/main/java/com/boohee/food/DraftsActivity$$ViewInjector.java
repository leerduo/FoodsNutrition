package com.boohee.food;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife.Finder;

public class DraftsActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DraftsActivity paramDraftsActivity, Object paramObject)
  {
    paramDraftsActivity.b = ((EditText)paramFinder.a(paramObject, 2131427473, "field 'etUserName'"));
    paramDraftsActivity.c = ((EditText)paramFinder.a(paramObject, 2131427474, "field 'etPassword'"));
    View localView = paramFinder.a(paramObject, 2131427475, "field 'btLogin' and method 'booheeLogin'");
    paramDraftsActivity.d = ((Button)localView);
    localView.setOnClickListener(new DraftsActivity..ViewInjector.1(paramDraftsActivity));
  }
  
  public static void reset(DraftsActivity paramDraftsActivity)
  {
    paramDraftsActivity.b = null;
    paramDraftsActivity.c = null;
    paramDraftsActivity.d = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DraftsActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */