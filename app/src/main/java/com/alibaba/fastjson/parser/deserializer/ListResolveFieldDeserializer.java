package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public final class ListResolveFieldDeserializer
  extends FieldDeserializer
{
  private final int index;
  private final List list;
  private final DefaultJSONParser parser;
  
  public ListResolveFieldDeserializer(DefaultJSONParser paramDefaultJSONParser, List paramList, int paramInt)
  {
    super(null, null);
    this.parser = paramDefaultJSONParser;
    this.index = paramInt;
    this.list = paramList;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {}
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    this.list.set(this.index, paramObject2);
    if ((this.list instanceof JSONArray))
    {
      JSONArray localJSONArray = (JSONArray)this.list;
      Object localObject = localJSONArray.getRelatedArray();
      if ((localObject != null) && (Array.getLength(localObject) > this.index))
      {
        if (localJSONArray.getComponentType() != null) {
          paramObject2 = TypeUtils.cast(paramObject2, localJSONArray.getComponentType(), this.parser.getConfig());
        }
        Array.set(localObject, this.index, paramObject2);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ListResolveFieldDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */