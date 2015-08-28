package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public abstract interface ObjectDeserializer
{
  public abstract <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject);
  
  public abstract int getFastMatchToken();
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */