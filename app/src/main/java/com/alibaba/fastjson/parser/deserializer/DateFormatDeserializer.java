package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public class DateFormatDeserializer
  extends AbstractDateDeserializer
  implements ObjectDeserializer
{
  public static final DateFormatDeserializer instance = new DateFormatDeserializer();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {}
    String str;
    do
    {
      return null;
      if (!(paramObject2 instanceof String)) {
        break;
      }
      str = (String)paramObject2;
    } while (str.length() == 0);
    return new SimpleDateFormat(str);
    throw new JSONException("parse error");
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.DateFormatDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */