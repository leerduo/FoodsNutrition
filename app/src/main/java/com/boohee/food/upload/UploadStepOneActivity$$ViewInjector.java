package com.boohee.food.upload;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class UploadStepOneActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, UploadStepOneActivity paramUploadStepOneActivity, Object paramObject)
  {
    paramUploadStepOneActivity.b = ((TextView)paramFinder.a(paramObject, 2131427508, "field 'tvCode'"));
    paramUploadStepOneActivity.c = ((EditText)paramFinder.a(paramObject, 2131427509, "field 'etName'"));
    View localView = paramFinder.a(paramObject, 2131427518, "field 'btNext' and method 'onClick'");
    paramUploadStepOneActivity.d = ((Button)localView);
    localView.setOnClickListener(new UploadStepOneActivity..ViewInjector.1(paramUploadStepOneActivity));
    paramFinder.a(paramObject, 2131427517, "method 'onClick'").setOnClickListener(new UploadStepOneActivity..ViewInjector.2(paramUploadStepOneActivity));
  }
  
  public static void reset(UploadStepOneActivity paramUploadStepOneActivity)
  {
    paramUploadStepOneActivity.b = null;
    paramUploadStepOneActivity.c = null;
    paramUploadStepOneActivity.d = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStepOneActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */