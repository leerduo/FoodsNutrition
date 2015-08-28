package com.xiaomi.channel.commonutils.network;

import java.util.Map;

public class a$b
{
  public int a;
  public Map<String, String> b;
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b.toString();
    return String.format("resCode = %1$d, headers = %2$s", arrayOfObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.network.a.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */