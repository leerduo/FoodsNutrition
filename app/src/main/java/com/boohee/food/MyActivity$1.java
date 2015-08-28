package com.boohee.food;

import android.app.Activity;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

class MyActivity$1
  extends JsonCallback
{
  MyActivity$1(MyActivity paramMyActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(String paramString)
  {
    ToastUtils.b(paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      MyActivity.a(this.a, paramJSONObject.optInt("count"));
      MyActivity.a(this.a, this.a.findViewById(2131427486), 2130837582, 2131558534, String.valueOf(MyActivity.a(this.a)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.MyActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */