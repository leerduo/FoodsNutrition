package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import java.lang.reflect.Type;

public class JSONAwareSerializer
  implements ObjectSerializer
{
  public static JSONAwareSerializer instance = new JSONAwareSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer.getWriter().write(((JSONAware)paramObject1).toJSONString());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JSONAwareSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */