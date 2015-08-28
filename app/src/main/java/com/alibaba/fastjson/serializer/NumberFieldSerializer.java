package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;

final class NumberFieldSerializer
  extends FieldSerializer
{
  public NumberFieldSerializer(FieldInfo paramFieldInfo)
  {
    super(paramFieldInfo);
  }
  
  public void writeProperty(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    writePrefix(paramJSONSerializer);
    writeValue(paramJSONSerializer, paramObject);
  }
  
  public void writeValue(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject == null)
    {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullNumberAsZero))
      {
        localSerializeWriter.write('0');
        return;
      }
      localSerializeWriter.writeNull();
      return;
    }
    localSerializeWriter.append(paramObject.toString());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.NumberFieldSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */