package com.boohee.food.util;

import android.app.Activity;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

final class MobUtils$1
  extends JsonCallback
{
  MobUtils$1(Activity paramActivity1, MobUtils.OnLoginListener paramOnLoginListener, Activity paramActivity2)
  {
    super(paramActivity1);
  }
  
  public void a(String paramString)
  {
    if (paramString.contains("网络异常"))
    {
      this.a.a(false, paramString);
      return;
    }
    this.a.a(false, this.b.getString(2131558510));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    AccountUtils.a(paramJSONObject);
    this.a.a(true, this.b.getString(2131558512));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.MobUtils.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */