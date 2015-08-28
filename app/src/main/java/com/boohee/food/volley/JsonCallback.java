package com.boohee.food.volley;

import android.app.Activity;
import com.android.volley.NetworkResponse;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.boohee.food.model.ApiError;
import com.boohee.food.util.LogUtils;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import de.keyboardsurfer.android.widget.crouton.Style.Builder;
import org.json.JSONObject;

public class JsonCallback
  implements Response.ErrorListener, Response.Listener<JSONObject>
{
  private static final String a = JsonCallback.class.getSimpleName();
  private static final Style b = new Style.Builder().a(-855686076).a();
  private Activity c;
  
  public JsonCallback(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  public void a()
  {
    LogUtils.a(a, "finish");
  }
  
  public void a(VolleyError paramVolleyError)
  {
    String str = "网络异常，请检查网络稍后重试~";
    NetworkResponse localNetworkResponse = paramVolleyError.a;
    int i;
    if (localNetworkResponse != null)
    {
      i = localNetworkResponse.a;
      if ((i <= 200) || (i >= 400)) {
        break label65;
      }
      str = "请求重定向，请稍后重试~ 错误代码: " + i;
    }
    for (;;)
    {
      a(str);
      a();
      return;
      label65:
      if ((i >= 400) && (i < 500)) {
        str = "请求不合法~ 错误代码: " + i;
      } else if (i >= 500) {
        str = "服务器出错啦，请稍后重试~ 错误代码: " + i;
      }
    }
  }
  
  public void a(String paramString)
  {
    LogUtils.a(a, "fail");
    if (this.c != null) {
      Crouton.a(this.c, paramString, b).b();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogUtils.a(a, "ok");
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("errors")) {
      a(paramJSONObject);
    }
    for (;;)
    {
      a();
      return;
      if (this.c != null) {
        Crouton.a(this.c, ApiError.getErrorMessage(paramJSONObject), b).b();
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.volley.JsonCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */