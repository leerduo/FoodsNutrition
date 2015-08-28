package com.boohee.food.model;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

public class User
  implements Serializable
{
  public String at_coin_balance;
  public String avatar_url;
  public String birthday;
  public String cellphone;
  public boolean cellphone_state;
  public String email;
  public String gender;
  public String height;
  public String nick_name;
  public String user_key;
  public String user_name;
  public String user_type;
  
  public static User parse(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (User)JSON.parseObject(paramString, User.class);
    }
    return null;
  }
  
  public String toString()
  {
    return JSONObject.toJSONString(this);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.User
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */