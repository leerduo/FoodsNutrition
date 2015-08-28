package com.umeng.analytics.social;

import android.content.Context;
import android.util.Log;

public abstract class UMSocialService
{
  private static void a(Context paramContext, UMSocialService.b paramb, String paramString, UMPlatformData... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs != null) {}
    try
    {
      int j = paramVarArgs.length;
      if (i < j) {
        if (!paramVarArgs[i].isValid()) {
          throw new a("parameter is not valid.");
        }
      }
    }
    catch (a locala)
    {
      for (;;)
      {
        Log.e("MobclickAgent", "unable send event.", locala);
        return;
        i++;
      }
      new UMSocialService.a(f.a(paramContext, paramString, paramVarArgs), paramb, paramVarArgs).execute(new Void[0]);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MobclickAgent", "", localException);
    }
  }
  
  public static void share(Context paramContext, String paramString, UMPlatformData... paramVarArgs)
  {
    a(paramContext, null, paramString, paramVarArgs);
  }
  
  public static void share(Context paramContext, UMPlatformData... paramVarArgs)
  {
    a(paramContext, null, null, paramVarArgs);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.UMSocialService
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */