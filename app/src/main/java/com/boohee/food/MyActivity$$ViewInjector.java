package com.boohee.food;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MyActivity paramMyActivity, Object paramObject)
  {
    paramMyActivity.b = ((TextView)paramFinder.a(paramObject, 2131427485, "field 'tvNickName'"));
    View localView1 = paramFinder.a(paramObject, 2131427484, "field 'civAvatar' and method 'onLongClick'");
    paramMyActivity.c = ((CircleImageView)localView1);
    localView1.setOnLongClickListener(new MyActivity..ViewInjector.1(paramMyActivity));
    View localView2 = paramFinder.a(paramObject, 2131427489, "field 'btUploadFood' and method 'onClick'");
    paramMyActivity.d = ((Button)localView2);
    localView2.setOnClickListener(new MyActivity..ViewInjector.2(paramMyActivity));
    View localView3 = paramFinder.a(paramObject, 2131427490, "field 'btAuth' and method 'onClick'");
    paramMyActivity.e = ((Button)localView3);
    localView3.setOnClickListener(new MyActivity..ViewInjector.3(paramMyActivity));
  }
  
  public static void reset(MyActivity paramMyActivity)
  {
    paramMyActivity.b = null;
    paramMyActivity.c = null;
    paramMyActivity.d = null;
    paramMyActivity.e = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.MyActivity..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */