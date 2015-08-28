package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

public abstract interface ExtraTypeProvider
  extends ParseProcess
{
  public abstract Type getExtraType(Object paramObject, String paramString);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */