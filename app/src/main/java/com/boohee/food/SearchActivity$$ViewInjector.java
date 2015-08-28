package com.boohee.food;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.boohee.food.view.NoScrollGridView;

public class SearchActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SearchActivity paramSearchActivity, Object paramObject)
  {
    paramSearchActivity.b = ((NoScrollGridView)paramFinder.a(paramObject, 2131427499, "field 'gv_hot'"));
    paramSearchActivity.c = ((EditText)paramFinder.a(paramObject, 2131427492, "field 'et_search'"));
    View localView = paramFinder.a(paramObject, 2131427493, "field 'iv_clear' and method 'onClick'");
    paramSearchActivity.d = ((ImageView)localView);
    localView.setOnClickListener(new SearchActivity..ViewInjector.1(paramSearchActivity));
    paramSearchActivity.e = ((LinearLayout)paramFinder.a(paramObject, 2131427496, "field 'll_history'"));
    paramSearchActivity.f = ((LinearLayout)paramFinder.a(paramObject, 2131427497, "field 'll_history_content'"));
    paramSearchActivity.g = ((ListView)paramFinder.a(paramObject, 2131427500, "field 'lv_result'"));
    paramSearchActivity.h = ((TextView)paramFinder.a(paramObject, 2131427501, "field 'tv_null'"));
    paramSearchActivity.i = ((ScrollView)paramFinder.a(paramObject, 2131427495, "field 'sv_search'"));
    paramFinder.a(paramObject, 2131427491, "method 'onClick'").setOnClickListener(new SearchActivity..ViewInjector.2(paramSearchActivity));
    paramFinder.a(paramObject, 2131427498, "method 'onClick'").setOnClickListener(new SearchActivity..ViewInjector.3(paramSearchActivity));
    paramFinder.a(paramObject, 2131427494, "method 'onClick'").setOnClickListener(new SearchActivity..ViewInjector.4(paramSearchActivity));
  }
  
  public static void reset(SearchActivity paramSearchActivity)
  {
    paramSearchActivity.b = null;
    paramSearchActivity.c = null;
    paramSearchActivity.d = null;
    paramSearchActivity.e = null;
    paramSearchActivity.f = null;
    paramSearchActivity.g = null;
    paramSearchActivity.h = null;
    paramSearchActivity.i = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SearchActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */