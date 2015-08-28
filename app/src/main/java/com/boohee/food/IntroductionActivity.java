package com.boohee.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import butterknife.ButterKnife;
import com.boohee.food.adapter.IntroductionAdapter;
import com.viewpagerindicator.LinePageIndicator;

public class IntroductionActivity
  extends FragmentActivity
{
  private static final int[] c = { 2130837687, 2130837688, 2130837689, 2130837690 };
  ViewPager a;
  LinePageIndicator b;
  private IntroductionAdapter d;
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      paramActivity.startActivity(new Intent(paramActivity, IntroductionActivity.class));
      paramActivity.finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903074);
    ButterKnife.a(this);
    this.d = new IntroductionAdapter(getSupportFragmentManager(), c);
    this.a.setAdapter(this.d);
    this.b.setViewPager(this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.IntroductionActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */