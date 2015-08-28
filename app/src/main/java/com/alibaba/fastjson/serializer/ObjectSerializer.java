package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public abstract interface ObjectSerializer
{
  public abstract void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ObjectSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */