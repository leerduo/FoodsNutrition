package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateDeserializer
  extends AbstractDateDeserializer
  implements ObjectDeserializer
{
  public static final DateDeserializer instance = new DateDeserializer();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      paramObject2 = null;
    }
    while ((paramObject2 instanceof Date)) {
      return paramObject2;
    }
    if ((paramObject2 instanceof Number)) {
      return new Date(((Number)paramObject2).longValue());
    }
    if ((paramObject2 instanceof String))
    {
      str = (String)paramObject2;
      if (str.length() == 0) {
        return null;
      }
      JSONScanner localJSONScanner = new JSONScanner(str);
      try
      {
        if (localJSONScanner.scanISO8601DateIfMatch(false))
        {
          Calendar localCalendar = localJSONScanner.getCalendar();
          if (paramType == Calendar.class)
          {
            localJSONScanner.close();
            return localCalendar;
          }
          Date localDate2 = localCalendar.getTime();
          localJSONScanner.close();
          return localDate2;
        }
        localJSONScanner.close();
        DateFormat localDateFormat = paramDefaultJSONParser.getDateFormat();
        Date localDate1;
        throw new JSONException("parse error");
      }
      finally
      {
        try
        {
          localDate1 = localDateFormat.parse(str);
          return localDate1;
        }
        catch (ParseException localParseException)
        {
          return new Date(Long.parseLong(str));
        }
        localObject = finally;
        localJSONScanner.close();
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.DateDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */