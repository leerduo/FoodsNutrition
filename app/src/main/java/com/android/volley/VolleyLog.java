package com.android.volley;

import android.util.Log;
import java.util.Locale;

public class VolleyLog
{
  public static String a = "Volley";
  public static boolean b = Log.isLoggable(a, 2);
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (b) {
      Log.v(a, e(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(a, e(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    Log.d(a, e(paramString, paramVarArgs));
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    Log.e(a, e(paramString, paramVarArgs));
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    Log.wtf(a, e(paramString, paramVarArgs));
  }
  
  private static String e(String paramString, Object... paramVarArgs)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    int i;
    label20:
    String str4;
    if (paramVarArgs == null)
    {
      arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= arrayOfStackTraceElement.length) {
        break label174;
      }
      if (arrayOfStackTraceElement[i].getClass().equals(VolleyLog.class)) {
        break label168;
      }
      String str2 = arrayOfStackTraceElement[i].getClassName();
      String str3 = str2.substring(1 + str2.lastIndexOf('.'));
      str4 = str3.substring(1 + str3.lastIndexOf('$'));
    }
    label168:
    label174:
    for (String str1 = str4 + "." + arrayOfStackTraceElement[i].getMethodName();; str1 = "<unknown>")
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(Thread.currentThread().getId());
      arrayOfObject[1] = str1;
      arrayOfObject[2] = paramString;
      return String.format(localLocale, "[%d] %s: %s", arrayOfObject);
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i++;
      break label20;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.VolleyLog
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */