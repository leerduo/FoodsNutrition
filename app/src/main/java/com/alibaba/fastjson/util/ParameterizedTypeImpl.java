package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParameterizedTypeImpl
  implements ParameterizedType
{
  private final Type[] actualTypeArguments;
  private final Type ownerType;
  private final Type rawType;
  
  public ParameterizedTypeImpl(Type[] paramArrayOfType, Type paramType1, Type paramType2)
  {
    this.actualTypeArguments = paramArrayOfType;
    this.ownerType = paramType1;
    this.rawType = paramType2;
  }
  
  public Type[] getActualTypeArguments()
  {
    return this.actualTypeArguments;
  }
  
  public Type getOwnerType()
  {
    return this.ownerType;
  }
  
  public Type getRawType()
  {
    return this.rawType;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.util.ParameterizedTypeImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */