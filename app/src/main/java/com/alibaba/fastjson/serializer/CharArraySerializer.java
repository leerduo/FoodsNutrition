package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class CharArraySerializer
  implements ObjectSerializer
{
  public static CharArraySerializer instance = new CharArraySerializer();
  
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
    localSerializeWriter.writeString(new String((char[])paramObject1));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.CharArraySerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */