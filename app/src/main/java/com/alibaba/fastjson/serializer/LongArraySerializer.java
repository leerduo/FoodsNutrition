package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class LongArraySerializer
  implements ObjectSerializer
{
  public static LongArraySerializer instance = new LongArraySerializer();
  
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
    long[] arrayOfLong = (long[])paramObject1;
    localSerializeWriter.write('[');
    for (int i = 0; i < arrayOfLong.length; i++)
    {
      if (i != 0) {
        localSerializeWriter.write(',');
      }
      localSerializeWriter.writeLong(arrayOfLong[i]);
    }
    localSerializeWriter.write(']');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.LongArraySerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */