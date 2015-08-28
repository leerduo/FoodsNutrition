package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigInteger;

public class BigIntegerCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BigIntegerCodec instance = new BigIntegerCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      String str = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      return new BigInteger(str);
    }
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToBigInteger(localObject);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null)
    {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullNumberAsZero))
      {
        localSerializeWriter.write('0');
        return;
      }
      localSerializeWriter.writeNull();
      return;
    }
    localSerializeWriter.write(((BigInteger)paramObject1).toString());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.BigIntegerCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */