package com.boohee.food;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.boohee.food.util.PrefUtils;
import com.boohee.food.util.SystemUtils;

public class WelcomeActivity
  extends FragmentActivity
{
  private Handler a = new Handler();
  
  private void a()
  {
    this.a.postDelayed(new WelcomeActivity.1(this), getResources().getInteger(2131492875));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903091);
    if ((PrefUtils.a() == 0) || (PrefUtils.a() < SystemUtils.c()))
    {
      PrefUtils.b();
      IntroductionActivity.a(this);
      return;
    }
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    System.gc();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.WelcomeActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */