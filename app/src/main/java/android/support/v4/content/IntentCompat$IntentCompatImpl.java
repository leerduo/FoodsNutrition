package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

abstract interface IntentCompat$IntentCompatImpl
{
  public abstract Intent makeMainActivity(ComponentName paramComponentName);
  
  public abstract Intent makeMainSelectorActivity(String paramString1, String paramString2);
  
  public abstract Intent makeRestartActivityTask(ComponentName paramComponentName);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.IntentCompat.IntentCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */