package com.boohee.food;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import com.umeng.analytics.MobclickAgent;
import org.json.JSONObject;

class DetailInfoActivity$4
  extends JsonCallback
{
  DetailInfoActivity$4(DetailInfoActivity paramDetailInfoActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(String paramString)
  {
    ToastUtils.b(paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.optBoolean("status");
      MenuItem localMenuItem = DetailInfoActivity.d(this.a).getItem(0);
      if (bool)
      {
        MobclickAgent.onEvent(this.a.a, "click_fav");
        localMenuItem.setTitle(2131558450);
        localMenuItem.setIcon(2130837605);
        return;
      }
      MobclickAgent.onEvent(this.a.a, "click_un_fav");
      localMenuItem.setTitle(2131558460);
      localMenuItem.setIcon(2130837606);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DetailInfoActivity.4
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */