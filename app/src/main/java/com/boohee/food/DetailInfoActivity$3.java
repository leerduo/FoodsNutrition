package com.boohee.food;

import android.app.Activity;
import com.boohee.food.model.FoodInfo;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

class DetailInfoActivity$3
  extends JsonCallback
{
  DetailInfoActivity$3(DetailInfoActivity paramDetailInfoActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    DetailInfoActivity.a(this.a, FoodInfo.parse(paramJSONObject.toString()));
    if (DetailInfoActivity.a(this.a) != null)
    {
      DetailInfoActivity.c(this.a);
      DetailInfoActivity.b(this.a);
      DetailInfoActivity.a(this.a, DetailInfoActivity.a(this.a).id);
      return;
    }
    ToastUtils.b("Data error!");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DetailInfoActivity.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */