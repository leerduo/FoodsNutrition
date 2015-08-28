package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class BooleanCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BooleanCodec instance = new BooleanCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 6)
    {
      localJSONLexer.nextToken(16);
      return Boolean.TRUE;
    }
    if (localJSONLexer.token() == 7)
    {
      localJSONLexer.nextToken(16);
      return Boolean.FALSE;
    }
    if (localJSONLexer.token() == 2)
    {
      int i = localJSONLexer.intValue();
      localJSONLexer.nextToken(16);
      if (i == 1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToBoolean(localObject);
  }
  
  public int getFastMatchToken()
  {
    return 6;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    Boolean localBoolean = (Boolean)paramObject1;
    if (localBoolean == null)
    {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullBooleanAsFalse))
      {
        localSerializeWriter.write("false");
        return;
      }
      localSerializeWriter.writeNull();
      return;
    }
    if (localBoolean.booleanValue())
    {
      localSerializeWriter.write("true");
      return;
    }
    localSerializeWriter.write("false");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.BooleanCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */