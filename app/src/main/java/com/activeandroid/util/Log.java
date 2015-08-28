package com.activeandroid.util;

public final class Log
{
  private static String a = "ActiveAndroid";
  private static boolean b = false;
  
  public static int a(String paramString)
  {
    if (b) {
      return android.util.Log.v(a, paramString);
    }
    return 0;
  }
  
  public static int a(String paramString, Throwable paramThrowable)
  {
    if (b) {
      return android.util.Log.w(a, paramString, paramThrowable);
    }
    return 0;
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static int b(String paramString)
  {
    if (b) {
      return android.util.Log.i(a, paramString);
    }
    return 0;
  }
  
  public static int b(String paramString, Throwable paramThrowable)
  {
    if (b) {
      return android.util.Log.e(a, paramString, paramThrowable);
    }
    return 0;
  }
  
  public static int c(String paramString)
  {
    if (b) {
      return android.util.Log.w(a, paramString);
    }
    return 0;
  }
  
  public static int d(String paramString)
  {
    if (b) {
      return android.util.Log.e(a, paramString);
    }
    return 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.Log
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */