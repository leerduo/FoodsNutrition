package com.boohee.food;

import android.app.Activity;
import android.view.MenuItem;
import com.boohee.food.model.FoodInfo;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

class DetailInfoActivity$5
  extends JsonCallback
{
  DetailInfoActivity$5(DetailInfoActivity paramDetailInfoActivity, Activity paramActivity, MenuItem paramMenuItem, boolean paramBoolean)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.c.d();
  }
  
  public void a(String paramString)
  {
    ToastUtils.b(paramString);
    DetailInfoActivity.a(this.c, DetailInfoActivity.a(this.c).id);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.setEnabled(true);
    if (this.b)
    {
      this.a.setTitle(2131558460);
      this.a.setIcon(2130837606);
      return;
    }
    this.a.setTitle(2131558450);
    this.a.setIcon(2130837605);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DetailInfoActivity.5
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */