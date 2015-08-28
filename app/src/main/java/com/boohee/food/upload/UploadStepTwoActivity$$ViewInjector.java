package com.boohee.food.upload;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class UploadStepTwoActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, UploadStepTwoActivity paramUploadStepTwoActivity, Object paramObject)
  {
    paramUploadStepTwoActivity.b = ((ImageView)paramFinder.a(paramObject, 2131427519, "field 'ivProgress'"));
    View localView1 = paramFinder.a(paramObject, 2131427510, "field 'btSubmit' and method 'onClick'");
    paramUploadStepTwoActivity.c = ((Button)localView1);
    localView1.setOnClickListener(new UploadStepTwoActivity..ViewInjector.1(paramUploadStepTwoActivity));
    View localView2 = paramFinder.a(paramObject, 2131427511, "field 'btSave' and method 'onClick'");
    paramUploadStepTwoActivity.d = ((Button)localView2);
    localView2.setOnClickListener(new UploadStepTwoActivity..ViewInjector.2(paramUploadStepTwoActivity));
    View localView3 = paramFinder.a(paramObject, 2131427602, "field 'ivFront' and method 'onClick'");
    paramUploadStepTwoActivity.e = ((ImageView)localView3);
    localView3.setOnClickListener(new UploadStepTwoActivity..ViewInjector.3(paramUploadStepTwoActivity));
    View localView4 = paramFinder.a(paramObject, 2131427491, "field 'ivBack' and method 'onClick'");
    paramUploadStepTwoActivity.f = ((ImageView)localView4);
    localView4.setOnClickListener(new UploadStepTwoActivity..ViewInjector.4(paramUploadStepTwoActivity));
    paramUploadStepTwoActivity.g = ((TextView)paramFinder.a(paramObject, 2131427520, "field 'tvMoblieAlert'"));
  }
  
  public static void reset(UploadStepTwoActivity paramUploadStepTwoActivity)
  {
    paramUploadStepTwoActivity.b = null;
    paramUploadStepTwoActivity.c = null;
    paramUploadStepTwoActivity.d = null;
    paramUploadStepTwoActivity.e = null;
    paramUploadStepTwoActivity.f = null;
    paramUploadStepTwoActivity.g = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStepTwoActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */