package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class LongCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static LongCodec instance = new LongCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      long l = localJSONLexer.longValue();
      localJSONLexer.nextToken(16);
      return Long.valueOf(l);
    }
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToLong(localObject);
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
    long l;
    do
    {
      return;
      localSerializeWriter.writeNull();
      return;
      l = ((Long)paramObject1).longValue();
      localSerializeWriter.writeLong(l);
    } while ((!paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) || (l > 2147483647L) || (l < -2147483648L) || (paramType == Long.class));
    localSerializeWriter.write('L');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.LongCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */