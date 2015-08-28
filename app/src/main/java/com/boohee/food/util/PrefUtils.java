package com.boohee.food.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.boohee.food.FoodApplication;

public class PrefUtils
{
  private static SharedPreferences a = PreferenceManager.getDefaultSharedPreferences(FoodApplication.a());
  
  public static int a()
  {
    return a.getInt("pref_version_code", 0);
  }
  
  public static void a(String paramString)
  {
    a.edit().putString("pref_search_history", paramString).commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    a.edit().putBoolean("pref_health_light_open", paramBoolean).commit();
  }
  
  public static void b()
  {
    int i = SystemUtils.c();
    a.edit().putInt("pref_version_code", i).commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    a.edit().putBoolean("pref_show_unit", paramBoolean).commit();
  }
  
  public static String c()
  {
    return a.getString("pref_search_history", "");
  }
  
  public static void d()
  {
    a.edit().remove("pref_search_history").commit();
  }
  
  public static Boolean e()
  {
    return Boolean.valueOf(a.getBoolean("pref_health_light_open", false));
  }
  
  public static boolean f()
  {
    return a.getBoolean("pref_show_unit", true);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.PrefUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */