package com.boohee.food.model;

import android.text.TextUtils;
import com.activeandroid.Model;
import com.alibaba.fastjson.JSONObject;

public class BaseModel<T>
  extends Model
{
  public static <T> T parse(String paramString, Class<T> paramClass)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = JSONObject.parseObject(paramString, paramClass);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public String toString()
  {
    try
    {
      String str = JSONObject.toJSONString(this);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.BaseModel
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */