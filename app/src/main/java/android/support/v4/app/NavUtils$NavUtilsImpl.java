package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

abstract interface NavUtils$NavUtilsImpl
{
  public abstract Intent getParentActivityIntent(Activity paramActivity);
  
  public abstract String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo);
  
  public abstract void navigateUpTo(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NavUtils.NavUtilsImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */