package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.TimeZone;

public class TimeZoneCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final TimeZoneCodec instance = new TimeZoneCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    String str = (String)paramDefaultJSONParser.parse();
    if (str == null) {
      return null;
    }
    return TimeZone.getTimeZone(str);
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull();
      return;
    }
    paramJSONSerializer.write(((TimeZone)paramObject1).getID());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.TimeZoneCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */