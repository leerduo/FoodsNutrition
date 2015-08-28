package com.boohee.food.upload;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.boohee.food.view.SquareImageView;

public class UploadEditActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, UploadEditActivity paramUploadEditActivity, Object paramObject)
  {
    paramUploadEditActivity.b = ((TextView)paramFinder.a(paramObject, 2131427508, "field 'tvCode'"));
    paramUploadEditActivity.c = ((EditText)paramFinder.a(paramObject, 2131427509, "field 'etName'"));
    View localView1 = paramFinder.a(paramObject, 2131427602, "field 'ivFront' and method 'onClick'");
    paramUploadEditActivity.d = ((SquareImageView)localView1);
    localView1.setOnClickListener(new UploadEditActivity..ViewInjector.1(paramUploadEditActivity));
    View localView2 = paramFinder.a(paramObject, 2131427491, "field 'ivBack' and method 'onClick'");
    paramUploadEditActivity.e = ((SquareImageView)localView2);
    localView2.setOnClickListener(new UploadEditActivity..ViewInjector.2(paramUploadEditActivity));
    View localView3 = paramFinder.a(paramObject, 2131427510, "field 'btSubmit' and method 'onClick'");
    paramUploadEditActivity.f = ((Button)localView3);
    localView3.setOnClickListener(new UploadEditActivity..ViewInjector.3(paramUploadEditActivity));
    paramFinder.a(paramObject, 2131427511, "method 'onClick'").setOnClickListener(new UploadEditActivity..ViewInjector.4(paramUploadEditActivity));
    paramFinder.a(paramObject, 2131427424, "method 'onClick'").setOnClickListener(new UploadEditActivity..ViewInjector.5(paramUploadEditActivity));
  }
  
  public static void reset(UploadEditActivity paramUploadEditActivity)
  {
    paramUploadEditActivity.b = null;
    paramUploadEditActivity.c = null;
    paramUploadEditActivity.d = null;
    paramUploadEditActivity.e = null;
    paramUploadEditActivity.f = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadEditActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */