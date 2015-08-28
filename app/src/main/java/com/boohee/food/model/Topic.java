package com.boohee.food.model;

import com.alibaba.fastjson.JSONObject;

public class Topic
{
  public int id;
  public String image_url;
  public int page_count;
  public String sub_title;
  public String title;
  
  public static Topic parse(String paramString)
  {
    try
    {
      Topic localTopic = (Topic)JSONObject.parseObject(paramString, Topic.class);
      return localTopic;
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
 * Qualified Name:     com.boohee.food.model.Topic
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */