package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;

public final class ActivityManagerCompat
{
  public static boolean isLowRamDevice(ActivityManager paramActivityManager)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ActivityManagerCompatKitKat.isLowRamDevice(paramActivityManager);
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityManagerCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */