package com.boohee.food;

import android.app.Activity;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

class MyActivity$2
  extends JsonCallback
{
  MyActivity$2(MyActivity paramMyActivity, Activity paramActivity)
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
      MyActivity.b(this.a, paramJSONObject.optInt("count"));
      MyActivity.a(this.a, this.a.findViewById(2131427487), 2130837583, 2131558536, String.valueOf(MyActivity.b(this.a)));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.MyActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */