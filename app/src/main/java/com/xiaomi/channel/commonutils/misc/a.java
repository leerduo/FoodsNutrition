package com.xiaomi.channel.commonutils.misc;

public class a
{
  public static final boolean a = "sdk".contains("2A2FE0D7");
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public static boolean e;
  public static final boolean f;
  public static final boolean g;
  private static int h = 1;
  
  static
  {
    if ((a) || ("DEBUG".equalsIgnoreCase("sdk"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      b = bool1;
      c = "LOGABLE".equalsIgnoreCase("sdk");
      d = "sdk".contains("YY");
      e = "sdk".equalsIgnoreCase("TEST");
      f = "BETA".equalsIgnoreCase("sdk");
      boolean bool2 = false;
      if ("sdk" != null)
      {
        boolean bool3 = "sdk".startsWith("RC");
        bool2 = false;
        if (bool3) {
          bool2 = true;
        }
      }
      g = bool2;
      h = 1;
      if (!"sdk".equalsIgnoreCase("SANDBOX")) {
        break;
      }
      h = 2;
      return;
    }
    if ("sdk".equalsIgnoreCase("ONEBOX"))
    {
      h = 3;
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    h = paramInt;
  }
  
  public static boolean a()
  {
    return h == 2;
  }
  
  public static boolean b()
  {
    return h == 3;
  }
  
  public static int c()
  {
    return h;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.misc.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */