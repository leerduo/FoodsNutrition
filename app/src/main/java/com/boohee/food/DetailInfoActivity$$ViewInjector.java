package com.boohee.food;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class DetailInfoActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DetailInfoActivity paramDetailInfoActivity, Object paramObject)
  {
    View localView1 = paramFinder.a(paramObject, 2131427426, "field 'ivFoodIcon' and method 'onClick'");
    paramDetailInfoActivity.b = ((ImageView)localView1);
    localView1.setOnClickListener(new DetailInfoActivity..ViewInjector.1(paramDetailInfoActivity));
    paramDetailInfoActivity.c = ((TextView)paramFinder.a(paramObject, 2131427427, "field 'tvFoodName'"));
    paramDetailInfoActivity.d = ((TextView)paramFinder.a(paramObject, 2131427429, "field 'tvCalory'"));
    paramDetailInfoActivity.e = ((TextView)paramFinder.a(paramObject, 2131427430, "field 'tvWeight'"));
    paramDetailInfoActivity.f = ((RadioGroup)paramFinder.a(paramObject, 2131427432, "field 'rgUnit'"));
    paramDetailInfoActivity.g = ((RadioButton)paramFinder.a(paramObject, 2131427433, "field 'rbCalory'"));
    paramDetailInfoActivity.h = ((RadioButton)paramFinder.a(paramObject, 2131427434, "field 'rbKjoule'"));
    View localView2 = paramFinder.a(paramObject, 2131427435, "field 'ivHealthLight' and method 'onClick'");
    paramDetailInfoActivity.i = ((ImageView)localView2);
    localView2.setOnClickListener(new DetailInfoActivity..ViewInjector.2(paramDetailInfoActivity));
    paramDetailInfoActivity.j = ((LinearLayout)paramFinder.a(paramObject, 2131427437, "field 'llCompare'"));
    paramDetailInfoActivity.k = ((TextView)paramFinder.a(paramObject, 2131427436, "field 'tvAppraise'"));
    paramDetailInfoActivity.l = ((ImageView)paramFinder.a(paramObject, 2131427438, "field 'ivCompare'"));
    paramDetailInfoActivity.m = ((TextView)paramFinder.a(paramObject, 2131427439, "field 'tvCompateAmount'"));
    paramDetailInfoActivity.n = ((TextView)paramFinder.a(paramObject, 2131427440, "field 'tvCompareInfo'"));
    paramDetailInfoActivity.o = ((ListView)paramFinder.a(paramObject, 2131427441, "field 'lvMain'"));
    paramFinder.a(paramObject, 2131427442, "method 'onClick'").setOnClickListener(new DetailInfoActivity..ViewInjector.3(paramDetailInfoActivity));
  }
  
  public static void reset(DetailInfoActivity paramDetailInfoActivity)
  {
    paramDetailInfoActivity.b = null;
    paramDetailInfoActivity.c = null;
    paramDetailInfoActivity.d = null;
    paramDetailInfoActivity.e = null;
    paramDetailInfoActivity.f = null;
    paramDetailInfoActivity.g = null;
    paramDetailInfoActivity.h = null;
    paramDetailInfoActivity.i = null;
    paramDetailInfoActivity.j = null;
    paramDetailInfoActivity.k = null;
    paramDetailInfoActivity.l = null;
    paramDetailInfoActivity.m = null;
    paramDetailInfoActivity.n = null;
    paramDetailInfoActivity.o = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DetailInfoActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */