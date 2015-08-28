package com.umeng.update.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import u.upd.n;

public class DeltaUpdate
{
  private static boolean a = false;
  private static final String b = "bspatch";
  
  static
  {
    try
    {
      System.loadLibrary("bspatch");
      a = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      a = false;
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    return bspatch(paramString1, paramString2, paramString3);
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getApplicationInfo().sourceDir;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static String b(Context paramContext)
  {
    String str = a(paramContext);
    if (!new File(str).exists()) {
      return "";
    }
    return n.a(new File(str));
  }
  
  public static native int bspatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.util.DeltaUpdate
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */