package com.umeng.update.net;

import org.json.JSONObject;

public class i
  extends u.upd.i
{
  public i.a a;
  
  public i(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (("ok".equalsIgnoreCase(paramJSONObject.optString("status"))) || ("ok".equalsIgnoreCase(paramJSONObject.optString("success"))))
    {
      this.a = i.a.a;
      return;
    }
    this.a = i.a.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */