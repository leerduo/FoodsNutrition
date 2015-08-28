package com.boohee.food.model;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;

public class UserConnections
  implements Serializable
{
  public String access_token;
  public String avatar_url;
  public String created_at;
  public String expires_at;
  public String id;
  public String identity;
  public String nickname;
  public String provider;
  public String updated_at;
  public String user_id;
  
  public static List<UserConnections> parse(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return JSON.parseArray(paramString, UserConnections.class);
    }
    return null;
  }
  
  public String toString()
  {
    return JSONObject.toJSONString(this);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.UserConnections
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */