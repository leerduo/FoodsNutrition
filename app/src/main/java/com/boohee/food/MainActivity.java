package com.boohee.food;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import com.boohee.food.fragment.DrawerFragment;
import com.boohee.food.fragment.HomeFragment;
import com.boohee.food.util.ViewUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

public class MainActivity
  extends BaseActivity
{
  private DrawerFragment b;
  private DrawerLayout c;
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, MainActivity.class);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
    paramActivity.finish();
  }
  
  private void b()
  {
    ((FoodApplication)getApplication()).a(true);
    MobclickAgent.onEvent(this.a, "view_home_page");
    UmengUpdateAgent.silentUpdate(this);
    getActionBar().hide();
    e();
    getSupportFragmentManager().beginTransaction().replace(2131427477, new HomeFragment()).commit();
  }
  
  private void e()
  {
    this.c = ((DrawerLayout)findViewById(2131427476));
    this.b = ((DrawerFragment)getSupportFragmentManager().findFragmentById(2131427478));
    this.b.a(2131427478, this.c);
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.openDrawer(8388611);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    ViewUtils.a(this);
    super.onCreate(paramBundle);
    setContentView(2130903080);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((FoodApplication)getApplication()).a(false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.MainActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */