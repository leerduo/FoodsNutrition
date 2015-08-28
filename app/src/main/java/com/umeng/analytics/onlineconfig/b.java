package com.umeng.analytics.onlineconfig;

import java.util.Locale;
import org.json.JSONObject;
import u.aly.bj;
import u.aly.bq;

public class b
  extends bq
{
  public JSONObject a = null;
  boolean b = false;
  int c = -1;
  int d = -1;
  String e;
  private final String f = "config_update";
  private final String g = "report_policy";
  private final String h = "online_params";
  private final String i = "last_config_time";
  private final String j = "report_interval";
  
  public b(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (paramJSONObject == null) {
      return;
    }
    a(paramJSONObject);
    a();
  }
  
  private void a()
  {
    if ((this.c < 0) || (this.c > 6)) {
      this.c = 1;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("config_update")) {
          break;
        }
        if (paramJSONObject.getString("config_update").toLowerCase(Locale.US).equals("no")) {
          return;
        }
        if (paramJSONObject.has("report_policy"))
        {
          this.c = paramJSONObject.getInt("report_policy");
          this.d = (1000 * paramJSONObject.optInt("report_interval"));
          this.e = paramJSONObject.optString("last_config_time");
          this.a = paramJSONObject.optJSONObject("online_params");
          this.b = true;
          return;
        }
      }
      catch (Exception localException)
      {
        bj.d("MobclickAgent", "fail to parce online config response", localException);
        return;
      }
      bj.d("MobclickAgent", " online config fetch no report policy");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.onlineconfig.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */