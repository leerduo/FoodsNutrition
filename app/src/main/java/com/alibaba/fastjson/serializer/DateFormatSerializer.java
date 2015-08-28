package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public class DateFormatSerializer
  implements ObjectSerializer
{
  public static final DateFormatSerializer instance = new DateFormatSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    String str = ((SimpleDateFormat)paramObject1).toPattern();
    if ((localSerializeWriter.isEnabled(SerializerFeature.WriteClassName)) && (paramObject1.getClass() != paramType))
    {
      localSerializeWriter.write('{');
      localSerializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
      paramJSONSerializer.write(paramObject1.getClass().getName());
      localSerializeWriter.writeFieldValue(',', "val", str);
      localSerializeWriter.write('}');
      return;
    }
    localSerializeWriter.writeString(str);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.DateFormatSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */