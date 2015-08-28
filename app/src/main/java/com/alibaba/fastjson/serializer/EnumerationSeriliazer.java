package com.alibaba.fastjson.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public class EnumerationSeriliazer
  implements ObjectSerializer
{
  public static EnumerationSeriliazer instance = new EnumerationSeriliazer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    int i = 0;
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null)
    {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty))
      {
        localSerializeWriter.write("[]");
        return;
      }
      localSerializeWriter.writeNull();
      return;
    }
    if ((paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) && ((paramType instanceof ParameterizedType))) {}
    for (Type localType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; localType = null)
    {
      Enumeration localEnumeration = (Enumeration)paramObject1;
      SerialContext localSerialContext = paramJSONSerializer.getContext();
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
      try
      {
        localSerializeWriter.append('[');
        while (localEnumeration.hasMoreElements())
        {
          Object localObject2 = localEnumeration.nextElement();
          int j = i + 1;
          if (i != 0) {
            localSerializeWriter.append(',');
          }
          if (localObject2 == null)
          {
            localSerializeWriter.writeNull();
            i = j;
          }
          else
          {
            paramJSONSerializer.getObjectWriter(localObject2.getClass()).write(paramJSONSerializer, localObject2, Integer.valueOf(j - 1), localType);
            i = j;
          }
        }
        localSerializeWriter.append(']');
        return;
      }
      finally
      {
        paramJSONSerializer.setContext(localSerialContext);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.EnumerationSeriliazer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */