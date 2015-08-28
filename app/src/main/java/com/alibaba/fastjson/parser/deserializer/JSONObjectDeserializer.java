package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public class JSONObjectDeserializer
  implements ObjectDeserializer
{
  public static final JSONObjectDeserializer instance = new JSONObjectDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return paramDefaultJSONParser.parseObject();
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.JSONObjectDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */