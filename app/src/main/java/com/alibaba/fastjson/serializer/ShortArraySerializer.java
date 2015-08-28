package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ShortArraySerializer
  implements ObjectSerializer
{
  public static ShortArraySerializer instance = new ShortArraySerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
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
    short[] arrayOfShort = (short[])paramObject1;
    localSerializeWriter.write('[');
    for (int i = 0; i < arrayOfShort.length; i++)
    {
      if (i != 0) {
        localSerializeWriter.write(',');
      }
      localSerializeWriter.writeInt(arrayOfShort[i]);
    }
    localSerializeWriter.write(']');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ShortArraySerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */