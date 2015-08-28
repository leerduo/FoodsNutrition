package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.util.Collection;

public class ObjectFieldSerializer
  extends FieldSerializer
{
  private String format;
  private ObjectFieldSerializer.RuntimeSerializerInfo runtimeInfo;
  boolean writeEnumUsingToString = false;
  boolean writeNullBooleanAsFalse = false;
  boolean writeNullListAsEmpty = false;
  boolean writeNullStringAsEmpty = false;
  boolean writeNumberAsZero = false;
  
  public ObjectFieldSerializer(FieldInfo paramFieldInfo)
  {
    super(paramFieldInfo);
    JSONField localJSONField = (JSONField)paramFieldInfo.getAnnotation(JSONField.class);
    if (localJSONField != null)
    {
      this.format = localJSONField.format();
      if (this.format.trim().length() == 0) {
        this.format = null;
      }
      SerializerFeature[] arrayOfSerializerFeature = localJSONField.serialzeFeatures();
      int i = arrayOfSerializerFeature.length;
      int j = 0;
      if (j < i)
      {
        SerializerFeature localSerializerFeature = arrayOfSerializerFeature[j];
        if (localSerializerFeature == SerializerFeature.WriteNullNumberAsZero) {
          this.writeNumberAsZero = true;
        }
        for (;;)
        {
          j++;
          break;
          if (localSerializerFeature == SerializerFeature.WriteNullStringAsEmpty) {
            this.writeNullStringAsEmpty = true;
          } else if (localSerializerFeature == SerializerFeature.WriteNullBooleanAsFalse) {
            this.writeNullBooleanAsFalse = true;
          } else if (localSerializerFeature == SerializerFeature.WriteNullListAsEmpty) {
            this.writeNullListAsEmpty = true;
          } else if (localSerializerFeature == SerializerFeature.WriteEnumUsingToString) {
            this.writeEnumUsingToString = true;
          }
        }
      }
    }
  }
  
  public void writeProperty(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    writePrefix(paramJSONSerializer);
    writeValue(paramJSONSerializer, paramObject);
  }
  
  public void writeValue(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    if (this.format != null)
    {
      paramJSONSerializer.writeWithFormat(paramObject, this.format);
      return;
    }
    if (this.runtimeInfo == null) {
      if (paramObject != null) {
        break label94;
      }
    }
    ObjectFieldSerializer.RuntimeSerializerInfo localRuntimeSerializerInfo;
    label94:
    for (Class localClass2 = this.fieldInfo.getFieldClass();; localClass2 = paramObject.getClass())
    {
      this.runtimeInfo = new ObjectFieldSerializer.RuntimeSerializerInfo(paramJSONSerializer.getObjectWriter(localClass2), localClass2);
      localRuntimeSerializerInfo = this.runtimeInfo;
      if (paramObject != null) {
        break label204;
      }
      if ((!this.writeNumberAsZero) || (!Number.class.isAssignableFrom(localRuntimeSerializerInfo.runtimeFieldClass))) {
        break;
      }
      paramJSONSerializer.getWriter().write('0');
      return;
    }
    if ((this.writeNullStringAsEmpty) && (String.class == localRuntimeSerializerInfo.runtimeFieldClass))
    {
      paramJSONSerializer.getWriter().write("\"\"");
      return;
    }
    if ((this.writeNullBooleanAsFalse) && (Boolean.class == localRuntimeSerializerInfo.runtimeFieldClass))
    {
      paramJSONSerializer.getWriter().write("false");
      return;
    }
    if ((this.writeNullListAsEmpty) && (Collection.class.isAssignableFrom(localRuntimeSerializerInfo.runtimeFieldClass)))
    {
      paramJSONSerializer.getWriter().write("[]");
      return;
    }
    localRuntimeSerializerInfo.fieldSerializer.write(paramJSONSerializer, null, this.fieldInfo.getName(), null);
    return;
    label204:
    if ((this.writeEnumUsingToString == true) && (localRuntimeSerializerInfo.runtimeFieldClass.isEnum()))
    {
      paramJSONSerializer.getWriter().writeString(((Enum)paramObject).name());
      return;
    }
    Class localClass1 = paramObject.getClass();
    if (localClass1 == localRuntimeSerializerInfo.runtimeFieldClass)
    {
      localRuntimeSerializerInfo.fieldSerializer.write(paramJSONSerializer, paramObject, this.fieldInfo.getName(), this.fieldInfo.getFieldType());
      return;
    }
    paramJSONSerializer.getObjectWriter(localClass1).write(paramJSONSerializer, paramObject, this.fieldInfo.getName(), this.fieldInfo.getFieldType());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ObjectFieldSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */