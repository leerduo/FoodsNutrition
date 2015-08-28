package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddressCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static InetSocketAddressCodec instance = new InetSocketAddressCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject1 = null;
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      return null;
    }
    paramDefaultJSONParser.accept(12);
    int i = 0;
    String str = localJSONLexer.stringVal();
    localJSONLexer.nextToken(17);
    Object localObject2;
    int j;
    if (str.equals("address"))
    {
      paramDefaultJSONParser.accept(17);
      InetAddress localInetAddress = (InetAddress)paramDefaultJSONParser.parseObject(InetAddress.class);
      int k = i;
      localObject2 = localInetAddress;
      j = k;
    }
    for (;;)
    {
      if (localJSONLexer.token() != 16) {
        break label208;
      }
      localJSONLexer.nextToken();
      localObject1 = localObject2;
      i = j;
      break;
      if (str.equals("port"))
      {
        paramDefaultJSONParser.accept(17);
        if (localJSONLexer.token() != 2) {
          throw new JSONException("port is not int");
        }
        j = localJSONLexer.intValue();
        localJSONLexer.nextToken();
        localObject2 = localObject1;
      }
      else
      {
        paramDefaultJSONParser.accept(17);
        paramDefaultJSONParser.parse();
        j = i;
        localObject2 = localObject1;
      }
    }
    label208:
    paramDefaultJSONParser.accept(13);
    return new InetSocketAddress((InetAddress)localObject2, j);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null)
    {
      paramJSONSerializer.writeNull();
      return;
    }
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramObject1;
    InetAddress localInetAddress = localInetSocketAddress.getAddress();
    localSerializeWriter.write('{');
    if (localInetAddress != null)
    {
      localSerializeWriter.writeFieldName("address");
      paramJSONSerializer.write(localInetAddress);
      localSerializeWriter.write(',');
    }
    localSerializeWriter.writeFieldName("port");
    localSerializeWriter.writeInt(localInetSocketAddress.getPort());
    localSerializeWriter.write('}');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.InetSocketAddressCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */