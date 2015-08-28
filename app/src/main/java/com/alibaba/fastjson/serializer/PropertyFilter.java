package com.alibaba.fastjson.serializer;

public abstract interface PropertyFilter
  extends SerializeFilter
{
  public abstract boolean apply(Object paramObject1, String paramString, Object paramObject2);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.PropertyFilter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */