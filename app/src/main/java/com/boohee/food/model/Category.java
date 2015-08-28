package com.boohee.food.model;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;

public class Category
  implements Serializable
{
  public String description;
  public int id;
  public String image_url;
  public String name;
  public List<Category> sub_categories;
  public int sub_category_count;
  
  public static List<Category> parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      List localList = JSONObject.parseArray(paramString, Category.class);
      return localList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.Category
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */