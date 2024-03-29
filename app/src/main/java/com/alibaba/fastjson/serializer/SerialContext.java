package com.alibaba.fastjson.serializer;

public class SerialContext
{
  private int features;
  private final Object fieldName;
  private final Object object;
  private final SerialContext parent;
  
  public SerialContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt)
  {
    this.parent = paramSerialContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
    this.features = paramInt;
  }
  
  public Object getFieldName()
  {
    return this.fieldName;
  }
  
  public Object getObject()
  {
    return this.object;
  }
  
  public SerialContext getParent()
  {
    return this.parent;
  }
  
  public String getPath()
  {
    if (this.parent == null) {
      return "$";
    }
    if ((this.fieldName instanceof Integer)) {
      return this.parent.getPath() + "[" + this.fieldName + "]";
    }
    return this.parent.getPath() + "." + this.fieldName;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return SerializerFeature.isEnabled(this.features, paramSerializerFeature);
  }
  
  public String toString()
  {
    return getPath();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SerialContext
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */