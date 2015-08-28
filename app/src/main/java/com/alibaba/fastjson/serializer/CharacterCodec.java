package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class CharacterCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CharacterCodec instance = new CharacterCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToChar(localObject);
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    Character localCharacter = (Character)paramObject1;
    if (localCharacter == null)
    {
      localSerializeWriter.writeString("");
      return;
    }
    if (localCharacter.charValue() == 0)
    {
      localSerializeWriter.writeString("");
      return;
    }
    localSerializeWriter.writeString(localCharacter.toString());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.CharacterCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */