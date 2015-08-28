package com.boohee.food.model;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

public class Banner
{
  public static String KEY = "banner";
  public static String KEY_OTHERS = "others";
  public String food_code;
  public int food_id;
  public String food_name;
  public String image_url;
  
  public static Banner parse(String paramString)
  {
    try
    {
      Banner localBanner = (Banner)JSONObject.parseObject(paramString, Banner.class);
      return localBanner;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static List<Banner> parseOthers(String paramString)
  {
    try
    {
      List localList = JSONObject.parseArray(paramString, Banner.class);
      return localList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    return JSONObject.toJSONString(this);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.Banner
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */