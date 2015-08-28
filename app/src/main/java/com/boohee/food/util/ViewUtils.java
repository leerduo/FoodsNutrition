package com.boohee.food.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.boohee.food.R.drawable;
import java.lang.reflect.Field;

public class ViewUtils
{
  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    int i = paramContext.getResources().getDimensionPixelSize(paramInt1);
    return paramContext.getResources().getDimensionPixelSize(paramInt2) * paramContext.getResources().getDisplayMetrics().widthPixels / i;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      int i = R.drawable.class.getDeclaredField(paramString).getInt(null);
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return 2130837637;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (Build.VERSION.SDK_INT >= 19))
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
      localLayoutParams.flags = (0x4000000 | localLayoutParams.flags);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.ViewUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */