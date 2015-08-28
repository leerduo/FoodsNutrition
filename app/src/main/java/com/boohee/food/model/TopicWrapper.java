package com.boohee.food.model;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;

public class TopicWrapper
  implements Serializable
{
  public int topic_count;
  public List<Topic> topics;
  
  public static TopicWrapper parse(String paramString)
  {
    try
    {
      TopicWrapper localTopicWrapper = (TopicWrapper)JSONObject.parseObject(paramString, TopicWrapper.class);
      return localTopicWrapper;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public List<Topic> getTopics()
  {
    return this.topics;
  }
  
  public void setTopics(List<Topic> paramList)
  {
    this.topics = paramList;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.TopicWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */