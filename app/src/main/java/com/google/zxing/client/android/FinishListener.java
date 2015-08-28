package com.google.zxing.client.android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class FinishListener
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
{
  private final Activity a;
  
  public FinishListener(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private void a()
  {
    this.a.finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.FinishListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */