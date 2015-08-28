package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ArraySerializer
  implements ObjectSerializer
{
  private final ObjectSerializer compObjectSerializer;
  private final Class<?> componentType;
  
  public ArraySerializer(Class<?> paramClass, ObjectSerializer paramObjectSerializer)
  {
    this.componentType = paramClass;
    this.compObjectSerializer = paramObjectSerializer;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
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
    Object[] arrayOfObject = (Object[])paramObject1;
    int j = arrayOfObject.length;
    SerialContext localSerialContext = paramJSONSerializer.getContext();
    paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
    for (;;)
    {
      Object localObject2;
      try
      {
        localSerializeWriter.append('[');
        if (i >= j) {
          break label188;
        }
        if (i != 0) {
          localSerializeWriter.append(',');
        }
        localObject2 = arrayOfObject[i];
        if (localObject2 == null) {
          localSerializeWriter.append("null");
        } else if (localObject2.getClass() == this.componentType) {
          this.compObjectSerializer.write(paramJSONSerializer, localObject2, Integer.valueOf(i), null);
        }
      }
      finally
      {
        paramJSONSerializer.setContext(localSerialContext);
      }
      paramJSONSerializer.getObjectWriter(localObject2.getClass()).write(paramJSONSerializer, localObject2, Integer.valueOf(i), null);
      break label203;
      label188:
      localSerializeWriter.append(']');
      paramJSONSerializer.setContext(localSerialContext);
      return;
      label203:
      i++;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ArraySerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */