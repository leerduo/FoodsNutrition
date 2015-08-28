package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

public class URLCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final URLCodec instance = new URLCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    String str = (String)paramDefaultJSONParser.parse();
    if (str == null) {
      return null;
    }
    try
    {
      URL localURL = new URL(str);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new JSONException("create url error", localMalformedURLException);
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull();
      return;
    }
    paramJSONSerializer.write(paramObject1.toString());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.URLCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */