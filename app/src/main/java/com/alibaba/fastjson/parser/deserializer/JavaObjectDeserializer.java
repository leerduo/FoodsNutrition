package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class JavaObjectDeserializer
  implements ObjectDeserializer
{
  public static final JavaObjectDeserializer instance = new JavaObjectDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if ((paramType instanceof GenericArrayType))
    {
      Type localType = ((GenericArrayType)paramType).getGenericComponentType();
      if ((localType instanceof TypeVariable)) {
        localType = ((TypeVariable)localType).getBounds()[0];
      }
      ArrayList localArrayList = new ArrayList();
      paramDefaultJSONParser.parseArray(localType, localArrayList);
      if ((localType instanceof Class))
      {
        Class localClass = (Class)localType;
        if (localClass == Boolean.TYPE) {
          return TypeUtils.cast(localArrayList, [Z.class, paramDefaultJSONParser.getConfig());
        }
        if (localClass == Short.TYPE) {
          return TypeUtils.cast(localArrayList, [S.class, paramDefaultJSONParser.getConfig());
        }
        if (localClass == Integer.TYPE) {
          return TypeUtils.cast(localArrayList, [I.class, paramDefaultJSONParser.getConfig());
        }
        if (localClass == Long.TYPE) {
          return TypeUtils.cast(localArrayList, [J.class, paramDefaultJSONParser.getConfig());
        }
        if (localClass == Float.TYPE) {
          return TypeUtils.cast(localArrayList, [F.class, paramDefaultJSONParser.getConfig());
        }
        if (localClass == Double.TYPE) {
          return TypeUtils.cast(localArrayList, [D.class, paramDefaultJSONParser.getConfig());
        }
        Object[] arrayOfObject = (Object[])Array.newInstance(localClass, localArrayList.size());
        localArrayList.toArray(arrayOfObject);
        return arrayOfObject;
      }
      return localArrayList.toArray();
    }
    return paramDefaultJSONParser.parse(paramObject);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */