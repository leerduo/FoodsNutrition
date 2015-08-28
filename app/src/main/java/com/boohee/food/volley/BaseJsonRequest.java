package com.boohee.food.volley;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.AppUtils;
import com.boohee.food.util.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class BaseJsonRequest
  extends JsonObjectRequest
{
  public BaseJsonRequest(int paramInt, String paramString, JsonParams paramJsonParams, Response.Listener<JSONObject> paramListener, Response.ErrorListener paramErrorListener) {}
  
  public Map<String, String> j()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_version", AppUtils.a());
    localHashMap.put("app_key", "food");
    localHashMap.put("app_device", "Android");
    localHashMap.put("os_version", SystemUtils.a());
    localHashMap.put("phone_model", SystemUtils.b());
    localHashMap.put("Accept", "application/json");
    localHashMap.put("User-Agent", "Android/Volley");
    if (AccountUtils.d())
    {
      localHashMap.put("token", AccountUtils.a());
      localHashMap.put("user_key", AccountUtils.b());
    }
    return localHashMap;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.volley.BaseJsonRequest
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */