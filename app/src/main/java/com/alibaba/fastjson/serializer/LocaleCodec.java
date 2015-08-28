package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Locale;

public class LocaleCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final LocaleCodec instance = new LocaleCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    String str = (String)paramDefaultJSONParser.parse();
    if (str == null) {
      return null;
    }
    String[] arrayOfString = str.split("_");
    if (arrayOfString.length == 1) {
      return new Locale(arrayOfString[0]);
    }
    if (arrayOfString.length == 2) {
      return new Locale(arrayOfString[0], arrayOfString[1]);
    }
    return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
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
    paramJSONSerializer.write(((Locale)paramObject1).toString());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.LocaleCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */