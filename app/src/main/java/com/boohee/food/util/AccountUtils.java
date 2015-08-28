package com.boohee.food.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.boohee.food.FoodApplication;
import com.boohee.food.model.User;
import com.boohee.food.model.UserConnections;
import java.util.List;

public class AccountUtils
{
  public static String a()
  {
    return g().getString("key_token", "");
  }
  
  public static void a(String paramString)
  {
    g().edit().putString("key_user_name", paramString).commit();
  }
  
  public static void a(String paramString, User paramUser, List<UserConnections> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUser == null) || (TextUtils.isEmpty(paramUser.user_key))) {
      return;
    }
    SharedPreferences.Editor localEditor = g().edit();
    localEditor.putString("key_user", paramUser.toString());
    if ((paramList != null) && (paramList.size() > 0)) {
      localEditor.putString("key_user_connections", paramList.toString());
    }
    localEditor.putString("key_token", paramString);
    localEditor.putString("key_user_key", paramUser.user_key);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2, org.json.JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      a(paramJSONObject.getString("token"), (User)com.alibaba.fastjson.JSONObject.parseObject(paramJSONObject.getString("user"), User.class), com.alibaba.fastjson.JSONObject.parseArray(paramJSONObject.getString("user_connections"), UserConnections.class));
      a(paramString1);
      b(paramString2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void a(org.json.JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str1 = paramJSONObject.optString("token");
    User localUser = (User)com.alibaba.fastjson.JSONObject.parseObject(paramJSONObject.optString("user"), User.class);
    try
    {
      String str2 = paramJSONObject.optString("user_connections");
      boolean bool = TextUtils.isEmpty(str2);
      localObject = null;
      if (!bool)
      {
        List localList = com.alibaba.fastjson.JSONObject.parseArray(str2, UserConnections.class);
        localObject = localList;
      }
      a(str1, localUser, localObject);
      a(localUser.user_name);
      b(localUser.avatar_url);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public static String b()
  {
    return g().getString("key_user_key", "");
  }
  
  public static void b(String paramString)
  {
    g().edit().putString("key_avatar_url", paramString).commit();
  }
  
  public static void c()
  {
    g().edit().clear().commit();
  }
  
  public static boolean d()
  {
    return !TextUtils.isEmpty(g().getString("key_user", ""));
  }
  
  public static String e()
  {
    return g().getString("key_user_name", "");
  }
  
  public static String f()
  {
    return g().getString("key_avatar_url", "");
  }
  
  private static SharedPreferences g()
  {
    return FoodApplication.a().getSharedPreferences("account_shared_preferences", 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.AccountUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */