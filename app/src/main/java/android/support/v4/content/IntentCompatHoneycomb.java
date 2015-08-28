package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class IntentCompatHoneycomb
{
  public static Intent makeMainActivity(ComponentName paramComponentName)
  {
    return Intent.makeMainActivity(paramComponentName);
  }
  
  public static Intent makeRestartActivityTask(ComponentName paramComponentName)
  {
    return Intent.makeRestartActivityTask(paramComponentName);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.IntentCompatHoneycomb
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */