package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONStreamAware;
import java.lang.reflect.Type;

public class JSONStreamAwareSerializer
  implements ObjectSerializer
{
  public static JSONStreamAwareSerializer instance = new JSONStreamAwareSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    ((JSONStreamAware)paramObject1).writeJSONString(localSerializeWriter);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JSONStreamAwareSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */