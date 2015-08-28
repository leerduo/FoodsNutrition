package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public abstract interface JSONSerializable
{
  public abstract void write(JSONSerializer paramJSONSerializer, Object paramObject, Type paramType);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JSONSerializable
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */