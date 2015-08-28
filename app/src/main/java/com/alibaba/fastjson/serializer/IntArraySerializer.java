package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class IntArraySerializer
  implements ObjectSerializer
{
  public static IntArraySerializer instance = new IntArraySerializer();
  
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
    int[] arrayOfInt = (int[])paramObject1;
    localSerializeWriter.write('[');
    for (int i = 0; i < arrayOfInt.length; i++)
    {
      if (i != 0) {
        localSerializeWriter.write(',');
      }
      localSerializeWriter.writeInt(arrayOfInt[i]);
    }
    localSerializeWriter.write(']');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.IntArraySerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */