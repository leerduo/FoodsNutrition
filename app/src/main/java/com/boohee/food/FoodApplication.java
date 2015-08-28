package com.boohee.food;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.activeandroid.app.Application;
import com.boohee.food.push.XMPush;
import com.umeng.analytics.MobclickAgent;

public class FoodApplication
  extends Application
{
  private static Context a;
  private boolean b;
  
  public static Context a()
  {
    return a;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a = getApplicationContext();
    MobclickAgent.updateOnlineConfig(getApplicationContext());
    XMPush.a(a);
    ShareSDK.initSDK(a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.FoodApplication
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */