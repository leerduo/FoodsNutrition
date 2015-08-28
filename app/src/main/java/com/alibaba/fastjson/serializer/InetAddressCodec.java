package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static InetAddressCodec instance = new InetAddressCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    String str = (String)paramDefaultJSONParser.parse();
    if (str == null) {
      return null;
    }
    if (str.length() == 0) {
      return null;
    }
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(str);
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      throw new JSONException("deserialize error", localUnknownHostException);
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
    paramJSONSerializer.write(((InetAddress)paramObject1).getHostAddress());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.InetAddressCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */