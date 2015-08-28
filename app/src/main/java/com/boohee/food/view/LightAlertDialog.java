package com.boohee.food.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;

public class LightAlertDialog
  extends AlertDialog
{
  protected LightAlertDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  protected LightAlertDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static LightAlertDialog a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new LightAlertDialog(paramContext, 3);
    }
    LightAlertDialog localLightAlertDialog = new LightAlertDialog(paramContext);
    localLightAlertDialog.setInverseBackgroundForced(true);
    return localLightAlertDialog;
  }
  
  public static LightAlertDialog a(Context paramContext, int paramInt1, int paramInt2)
  {
    LightAlertDialog localLightAlertDialog = a(paramContext);
    localLightAlertDialog.setTitle(paramInt1);
    localLightAlertDialog.setMessage(paramContext.getString(paramInt2));
    return localLightAlertDialog;
  }
  
  public LightAlertDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(getContext().getString(paramInt), paramOnClickListener);
  }
  
  public LightAlertDialog a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    setButton(-1, paramCharSequence, paramOnClickListener);
    return this;
  }
  
  public LightAlertDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    return b(getContext().getString(paramInt), paramOnClickListener);
  }
  
  public LightAlertDialog b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    setButton(-2, paramCharSequence, paramOnClickListener);
    return this;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.view.LightAlertDialog
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */