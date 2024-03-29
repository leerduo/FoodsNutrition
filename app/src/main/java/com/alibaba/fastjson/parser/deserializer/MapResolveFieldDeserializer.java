package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.util.Map;

public final class MapResolveFieldDeserializer
  extends FieldDeserializer
{
  private final String key;
  private final Map map;
  
  public MapResolveFieldDeserializer(Map paramMap, String paramString)
  {
    super(null, null);
    this.key = paramString;
    this.map = paramMap;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {}
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    this.map.put(this.key, paramObject2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.MapResolveFieldDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */