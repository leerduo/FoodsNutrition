package com.boohee.pictures.util;

import com.alibaba.fastjson.JSON;
import java.util.List;
import org.json.JSONObject;

public class ParseUtils
{
  public static <T> T fromJson(String paramString, Class<T> paramClass)
  {
    try
    {
      Object localObject = JSON.parseObject(paramString, paramClass);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static <T> T fromJson(JSONObject paramJSONObject, Class<T> paramClass)
  {
    Object localObject1 = null;
    if (paramJSONObject != null) {}
    try
    {
      Object localObject2 = JSON.parseObject(paramJSONObject.toString(), paramClass);
      localObject1 = localObject2;
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static <T> T fromJson(JSONObject paramJSONObject, String paramString, Class<T> paramClass)
  {
    if (paramJSONObject.has(paramString)) {
      return fromJson(paramJSONObject.optJSONObject(paramString), paramClass);
    }
    return null;
  }
  
  public static <T> List<T> parseList(String paramString, Class<T> paramClass)
  {
    try
    {
      List localList = JSON.parseArray(paramString, paramClass);
      return localList;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String toJson(Object paramObject)
  {
    try
    {
      String str = JSON.toJSONString(paramObject);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.util.ParseUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */