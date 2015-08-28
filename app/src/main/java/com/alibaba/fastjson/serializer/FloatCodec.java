package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class FloatCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static FloatCodec instance = new FloatCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      String str = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      return Float.valueOf(Float.parseFloat(str));
    }
    if (localJSONLexer.token() == 3)
    {
      float f = localJSONLexer.floatValue();
      localJSONLexer.nextToken(16);
      return Float.valueOf(f);
    }
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToFloat(localObject);
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
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        localSerializeWriter.write('0');
      }
    }
    do
    {
      return;
      localSerializeWriter.writeNull();
      return;
      float f = ((Float)paramObject1).floatValue();
      if (Float.isNaN(f))
      {
        localSerializeWriter.writeNull();
        return;
      }
      if (Float.isInfinite(f))
      {
        localSerializeWriter.writeNull();
        return;
      }
      String str = Float.toString(f);
      if (str.endsWith(".0")) {
        str = str.substring(0, -2 + str.length());
      }
      localSerializeWriter.write(str);
    } while (!paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName));
    localSerializeWriter.write('F');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.FloatCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */