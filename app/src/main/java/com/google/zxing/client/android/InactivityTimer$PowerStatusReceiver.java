package com.google.zxing.client.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class InactivityTimer$PowerStatusReceiver
  extends BroadcastReceiver
{
  private InactivityTimer$PowerStatusReceiver(InactivityTimer paramInactivityTimer) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction())) {
      if (paramIntent.getIntExtra("plugged", -1) > 0) {
        break label36;
      }
    }
    label36:
    for (int i = 1; i != 0; i = 0)
    {
      this.a.a();
      return;
    }
    InactivityTimer.a(this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.InactivityTimer.PowerStatusReceiver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */