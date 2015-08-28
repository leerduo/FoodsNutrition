package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.DateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

public class CalendarCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CalendarCodec instance = new CalendarCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject = DateDeserializer.instance.deserialze(paramDefaultJSONParser, paramType, paramObject);
    if ((localObject instanceof Calendar)) {
      return localObject;
    }
    Date localDate = (Date)localObject;
    if (localDate == null) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    return localCalendar;
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer.write(((Calendar)paramObject1).getTime());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.CalendarCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */