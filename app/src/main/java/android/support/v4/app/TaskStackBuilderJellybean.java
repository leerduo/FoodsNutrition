package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class TaskStackBuilderJellybean
{
  public static PendingIntent getActivitiesPendingIntent(Context paramContext, int paramInt1, Intent[] paramArrayOfIntent, int paramInt2, Bundle paramBundle)
  {
    return PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, paramInt2, paramBundle);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.TaskStackBuilderJellybean
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */