package org.apache.thrift.meta_data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class b
  implements Serializable
{
  private static Map<Class<? extends org.apache.thrift.b>, Map<?, b>> d = new HashMap();
  public final String a;
  public final byte b;
  public final c c;
  
  public b(String paramString, byte paramByte, c paramc)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramc;
  }
  
  public static void a(Class<? extends org.apache.thrift.b> paramClass, Map<?, b> paramMap)
  {
    d.put(paramClass, paramMap);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.meta_data.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */