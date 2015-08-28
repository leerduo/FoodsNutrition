package com.boohee.food.util;

import android.app.Activity;
import com.boohee.food.view.LightAlertDialog;

public class AlertDialogUtil
{
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    try
    {
      LightAlertDialog localLightAlertDialog = LightAlertDialog.a(paramActivity, 2131558431, 2131558652);
      localLightAlertDialog.setCancelable(false);
      localLightAlertDialog.b(2131558444, null);
      localLightAlertDialog.a(2131558445, new AlertDialogUtil.1(paramActivity));
      localLightAlertDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.AlertDialogUtil
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */