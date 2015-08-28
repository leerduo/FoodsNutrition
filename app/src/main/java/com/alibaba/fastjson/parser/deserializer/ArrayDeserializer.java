package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class ArrayDeserializer
  implements ObjectDeserializer
{
  public static final ArrayDeserializer instance = new ArrayDeserializer();
  
  private <T> T toObjectArray(DefaultJSONParser paramDefaultJSONParser, Class<?> paramClass, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int i = paramJSONArray.size();
    Object localObject1 = Array.newInstance(paramClass, i);
    int j = 0;
    Object localObject2;
    JSONArray localJSONArray;
    while (j < i)
    {
      localObject2 = paramJSONArray.get(j);
      if (localObject2 == paramJSONArray)
      {
        Array.set(localObject1, j, localObject1);
        j++;
      }
      else
      {
        if (paramClass.isArray())
        {
          if (paramClass.isInstance(localObject2)) {}
          for (;;)
          {
            Array.set(localObject1, j, localObject2);
            break;
            localObject2 = toObjectArray(paramDefaultJSONParser, paramClass, (JSONArray)localObject2);
          }
        }
        if (!(localObject2 instanceof JSONArray)) {
          break label230;
        }
        localJSONArray = (JSONArray)localObject2;
        int k = localJSONArray.size();
        int m = 0;
        int n = 0;
        while (m < k)
        {
          if (localJSONArray.get(m) == paramJSONArray)
          {
            localJSONArray.set(j, localObject1);
            n = 1;
          }
          m++;
        }
        if (n == 0) {
          break label230;
        }
      }
    }
    label230:
    for (Object[] arrayOfObject = localJSONArray.toArray();; arrayOfObject = null)
    {
      if (arrayOfObject == null) {}
      for (Object localObject3 = TypeUtils.cast(localObject2, paramClass, paramDefaultJSONParser.getConfig());; localObject3 = arrayOfObject)
      {
        Array.set(localObject1, j, localObject3);
        break;
        paramJSONArray.setRelatedArray(localObject1);
        paramJSONArray.setComponentType(paramClass);
        return localObject1;
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken(16);
      return null;
    }
    if (localJSONLexer.token() == 4)
    {
      byte[] arrayOfByte = localJSONLexer.bytesValue();
      localJSONLexer.nextToken(16);
      return arrayOfByte;
    }
    Type localType1;
    Type localType5;
    if ((paramType instanceof GenericArrayType))
    {
      localType1 = ((GenericArrayType)paramType).getGenericComponentType();
      if ((localType1 instanceof TypeVariable))
      {
        TypeVariable localTypeVariable = (TypeVariable)localType1;
        Type localType2 = paramDefaultJSONParser.getContext().getType();
        if ((localType2 instanceof ParameterizedType))
        {
          ParameterizedType localParameterizedType = (ParameterizedType)localType2;
          Type localType3 = localParameterizedType.getRawType();
          if (!(localType3 instanceof Class)) {
            break label283;
          }
          TypeVariable[] arrayOfTypeVariable = ((Class)localType3).getTypeParameters();
          localType5 = null;
          for (int i = 0; i < arrayOfTypeVariable.length; i++) {
            if (arrayOfTypeVariable[i].getName().equals(localTypeVariable.getName())) {
              localType5 = localParameterizedType.getActualTypeArguments()[i];
            }
          }
        }
      }
    }
    label283:
    for (Type localType4 = localType5;; localType4 = null)
    {
      Object localObject;
      if ((localType4 instanceof Class)) {
        localObject = (Class)localType4;
      }
      for (;;)
      {
        JSONArray localJSONArray = new JSONArray();
        paramDefaultJSONParser.parseArray((Type)localObject, localJSONArray, paramObject);
        return toObjectArray(paramDefaultJSONParser, (Class)localObject, localJSONArray);
        localObject = Object.class;
        continue;
        localObject = Object.class;
        continue;
        localObject = (Class)localType1;
        continue;
        localObject = ((Class)paramType).getComponentType();
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ArrayDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */