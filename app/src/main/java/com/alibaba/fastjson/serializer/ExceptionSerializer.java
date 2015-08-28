package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ExceptionSerializer
  extends JavaBeanSerializer
{
  public ExceptionSerializer(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  protected boolean isWriteClassName(JSONSerializer paramJSONSerializer, Object paramObject1, Type paramType, Object paramObject2)
  {
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ExceptionSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */