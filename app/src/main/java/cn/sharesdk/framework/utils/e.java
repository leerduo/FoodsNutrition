package cn.sharesdk.framework.utils;

import android.content.Context;
import android.util.Log;

public class e
{
  protected static e.a a = new e.a();
  protected static e.b b = new e.b();
  private static Context c;
  private static String d;
  
  public static int a(Object paramObject, Object... paramVarArgs)
  {
    if (a.a > 3)
    {
      String str2 = paramObject.toString();
      if (paramVarArgs.length > 0) {
        str2 = String.format(str2, paramVarArgs);
      }
      return b.b(3, str2);
    }
    String str1 = paramObject.toString();
    if (paramVarArgs.length > 0) {
      str1 = String.format(str1, paramVarArgs);
    }
    return b.a(3, str1);
  }
  
  public static int a(Throwable paramThrowable)
  {
    if (a.a <= 3) {
      return b.a(3, Log.getStackTraceString(paramThrowable));
    }
    return b.b(3, Log.getStackTraceString(paramThrowable));
  }
  
  public static int a(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    if (a.a > 6)
    {
      String str3 = paramObject.toString();
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (paramVarArgs.length > 0) {
        str3 = String.format(str3, paramVarArgs);
      }
      String str4 = str3 + '\n' + Log.getStackTraceString(paramThrowable);
      return b.b(6, str4);
    }
    String str1 = paramObject.toString();
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramVarArgs.length > 0) {
      str1 = String.format(str1, paramVarArgs);
    }
    String str2 = str1 + '\n' + Log.getStackTraceString(paramThrowable);
    return b.a(6, str2);
  }
  
  public static void a(Context paramContext)
  {
    c = paramContext.getApplicationContext();
    d = b.a(paramContext).q();
  }
  
  public static int b(Object paramObject, Object... paramVarArgs)
  {
    if (a.a > 4)
    {
      String str2 = paramObject.toString();
      if (paramVarArgs.length > 0) {
        str2 = String.format(str2, paramVarArgs);
      }
      return b.b(4, str2);
    }
    String str1 = paramObject.toString();
    if (paramVarArgs.length > 0) {
      str1 = String.format(str1, paramVarArgs);
    }
    return b.a(4, str1);
  }
  
  public static int b(Throwable paramThrowable)
  {
    if (a.a <= 5) {
      return b.a(5, Log.getStackTraceString(paramThrowable));
    }
    return 0;
  }
  
  public static int c(Object paramObject, Object... paramVarArgs)
  {
    if (a.a > 6)
    {
      String str2 = paramObject.toString();
      if (paramVarArgs.length > 0) {
        str2 = String.format(str2, paramVarArgs);
      }
      return b.b(6, str2);
    }
    String str1 = paramObject.toString();
    if (paramVarArgs.length > 0) {
      str1 = String.format(str1, paramVarArgs);
    }
    return b.a(6, str1);
  }
  
  public static int c(Throwable paramThrowable)
  {
    if (a.a <= 6) {
      return b.a(6, Log.getStackTraceString(paramThrowable));
    }
    return b.b(6, Log.getStackTraceString(paramThrowable));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */