package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class JSONSerializableSerializer
  implements ObjectSerializer
{
  public static JSONSerializableSerializer instance = new JSONSerializableSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    ((JSONSerializable)paramObject1).write(paramJSONSerializer, paramObject2, paramType);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JSONSerializableSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */