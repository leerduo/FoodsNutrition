package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BigDecimalCodec instance = new BigDecimalCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      long l = localJSONLexer.longValue();
      localJSONLexer.nextToken(16);
      return new BigDecimal(l);
    }
    if (localJSONLexer.token() == 3)
    {
      BigDecimal localBigDecimal = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      return localBigDecimal;
    }
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToBigDecimal(localObject);
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
    if (paramObject1 == null) {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        localSerializeWriter.write('0');
      }
    }
    BigDecimal localBigDecimal;
    do
    {
      return;
      localSerializeWriter.writeNull();
      return;
      localBigDecimal = (BigDecimal)paramObject1;
      localSerializeWriter.write(localBigDecimal.toString());
    } while ((!localSerializeWriter.isEnabled(SerializerFeature.WriteClassName)) || (paramType == BigDecimal.class) || (localBigDecimal.scale() != 0));
    localSerializeWriter.write('.');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.BigDecimalCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */