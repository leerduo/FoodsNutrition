package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

public class StringCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static StringCodec instance = new StringCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 4)
    {
      String str2 = localJSONLexer.stringVal();
      localJSONLexer.nextToken(16);
      return str2;
    }
    if (localJSONLexer.token() == 2)
    {
      String str1 = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      return str1;
    }
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    write(paramJSONSerializer, (String)paramObject1);
  }
  
  public void write(JSONSerializer paramJSONSerializer, String paramString)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramString == null)
    {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty))
      {
        localSerializeWriter.writeString("");
        return;
      }
      localSerializeWriter.writeNull();
      return;
    }
    localSerializeWriter.writeString(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.StringCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */