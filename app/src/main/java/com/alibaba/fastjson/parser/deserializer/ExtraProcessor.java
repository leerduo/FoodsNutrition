package com.alibaba.fastjson.parser.deserializer;

public abstract interface ExtraProcessor
  extends ParseProcess
{
  public abstract void processExtra(Object paramObject1, String paramString, Object paramObject2);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ExtraProcessor
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */