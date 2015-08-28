package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class e$b
{
  protected static String a(int paramInt)
  {
    if (e.a.a <= 3)
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      if ((paramInt >= 0) && (paramInt < arrayOfStackTraceElement.length))
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[paramInt];
        String str1 = localStackTraceElement.getFileName();
        if ((str1 == null) || (str1.length() <= 0)) {}
        for (String str2 = localStackTraceElement.getClassName();; str2 = e.a.c + "/" + str1)
        {
          int i = localStackTraceElement.getLineNumber();
          String str3 = String.valueOf(i);
          if (i < 0)
          {
            str3 = localStackTraceElement.getMethodName();
            if ((str3 == null) || (str3.length() <= 0)) {
              str3 = "Unknown Source";
            }
          }
          return str2 + "(" + str3 + ")";
        }
      }
    }
    return e.a.c;
  }
  
  public int a(int paramInt, String paramString)
  {
    return Log.println(paramInt, a(5), a(paramString));
  }
  
  protected String a(String paramString)
  {
    if (e.a.a <= 3)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Thread.currentThread().getName();
      arrayOfObject[1] = paramString;
      paramString = String.format("%s %s", arrayOfObject);
    }
    return paramString;
  }
  
  public int b(int paramInt, String paramString)
  {
    if (e.a() != null) {}
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("cn.sharesdk.log");
      localIntent.putExtra("package", e.b());
      localIntent.putExtra("priority", paramInt);
      localIntent.putExtra("msg", paramString);
      e.a().sendBroadcast(localIntent);
      label54:
      return 0;
    }
    catch (Throwable localThrowable)
    {
      break label54;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.e.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */