package com.xiaomi.xmpush.thrift;

import org.apache.thrift.d;
import org.apache.thrift.e;
import org.apache.thrift.f;
import org.apache.thrift.protocol.a.a;

public class x
{
  public static <T extends org.apache.thrift.b<T, ?>> void a(T paramT, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new e("the message byte is empty.");
    }
    new d().a(paramT, paramArrayOfByte);
  }
  
  public static <T extends org.apache.thrift.b<T, ?>> byte[] a(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new f(new a.a()).a(paramT);
      return arrayOfByte;
    }
    catch (e locale)
    {
      com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", locale);
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.x
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */