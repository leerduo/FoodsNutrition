package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class IntegerCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static IntegerCodec instance = new IntegerCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken(16);
      return null;
    }
    if (localJSONLexer.token() == 2)
    {
      int i = localJSONLexer.intValue();
      localJSONLexer.nextToken(16);
      return Integer.valueOf(i);
    }
    if (localJSONLexer.token() == 3)
    {
      BigDecimal localBigDecimal = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      return Integer.valueOf(localBigDecimal.intValue());
    }
    return TypeUtils.castToInt(paramDefaultJSONParser.parse());
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    Number localNumber = (Number)paramObject1;
    if (localNumber == null) {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        localSerializeWriter.write('0');
      }
    }
    Class localClass;
    do
    {
      do
      {
        return;
        localSerializeWriter.writeNull();
        return;
        localSerializeWriter.writeInt(localNumber.intValue());
      } while (!paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName));
      localClass = localNumber.getClass();
      if (localClass == Byte.class)
      {
        localSerializeWriter.write('B');
        return;
      }
    } while (localClass != Short.class);
    localSerializeWriter.write('S');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.IntegerCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */