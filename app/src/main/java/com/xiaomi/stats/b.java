package com.xiaomi.stats;

import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.x;
import java.util.Hashtable;

public class b
{
  private static final int a = com.xiaomi.xmpush.thrift.b.a.a();
  private static final int b = com.xiaomi.xmpush.thrift.b.b.a();
  private static final int c = com.xiaomi.xmpush.thrift.b.c.a();
  
  public static void a()
  {
    a(0, c);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    int i = paramInt2 | paramInt1 << 24;
    try
    {
      b.a.a.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    a.a().a(paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public static void a(long paramLong, String paramString)
  {
    a.a().a(0, b, (int)paramLong, paramString);
  }
  
  public static void a(String paramString)
  {
    a.a().a(0, a, 1, paramString);
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    return a.a().a(paramInt1, paramInt2, paramInt3, paramString1, paramString2);
  }
  
  public static void b()
  {
    b(0, c);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    try
    {
      long l = System.currentTimeMillis();
      int i = paramInt2 | paramInt1 << 24;
      if (b.a.a.contains(Integer.valueOf(i)))
      {
        a.a().a(paramInt1, paramInt2, (int)(l - ((Long)b.a.a.get(Integer.valueOf(i))).longValue()), null);
        b.a.a.remove(Integer.valueOf(paramInt2));
      }
      return;
    }
    finally {}
  }
  
  public static String c()
  {
    f localf = a.a().c();
    String str = null;
    if (localf != null)
    {
      byte[] arrayOfByte = x.a(localf);
      str = null;
      if (arrayOfByte != null)
      {
        str = new String(com.xiaomi.channel.commonutils.string.a.a(arrayOfByte));
        com.xiaomi.channel.commonutils.logger.b.b(str);
      }
    }
    return str;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.stats.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */