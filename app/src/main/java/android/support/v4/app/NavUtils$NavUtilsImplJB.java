package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class NavUtils$NavUtilsImplJB
  extends NavUtils.NavUtilsImplBase
{
  public Intent getParentActivityIntent(Activity paramActivity)
  {
    Intent localIntent = NavUtilsJB.getParentActivityIntent(paramActivity);
    if (localIntent == null) {
      localIntent = superGetParentActivityIntent(paramActivity);
    }
    return localIntent;
  }
  
  public String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
  {
    String str = NavUtilsJB.getParentActivityName(paramActivityInfo);
    if (str == null) {
      str = super.getParentActivityName(paramContext, paramActivityInfo);
    }
    return str;
  }
  
  public void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    NavUtilsJB.navigateUpTo(paramActivity, paramIntent);
  }
  
  public boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    return NavUtilsJB.shouldUpRecreateTask(paramActivity, paramIntent);
  }
  
  Intent superGetParentActivityIntent(Activity paramActivity)
  {
    return super.getParentActivityIntent(paramActivity);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NavUtils.NavUtilsImplJB
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */