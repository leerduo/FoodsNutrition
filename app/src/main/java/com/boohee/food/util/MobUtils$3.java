package com.boohee.food.util;

import android.app.Activity;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

final class MobUtils$3
  extends JsonCallback
{
  MobUtils$3(Activity paramActivity1, String paramString1, String paramString2, MobUtils.OnLoginListener paramOnLoginListener, Activity paramActivity2)
  {
    super(paramActivity1);
  }
  
  public void a(String paramString)
  {
    this.c.a(false, paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    AccountUtils.a(this.a, this.b, paramJSONObject);
    this.c.a(true, this.d.getString(2131558512));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.MobUtils.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */