package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatSerializer
  implements ObjectSerializer
{
  private final String pattern;
  
  public SimpleDateFormatSerializer(String paramString)
  {
    this.pattern = paramString;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer.getWriter().writeNull();
      return;
    }
    Date localDate = (Date)paramObject1;
    paramJSONSerializer.write(new SimpleDateFormat(this.pattern).format(localDate));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SimpleDateFormatSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */