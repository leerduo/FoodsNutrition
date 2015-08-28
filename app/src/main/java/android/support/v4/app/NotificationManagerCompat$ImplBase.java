package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class NotificationManagerCompat$ImplBase
  implements NotificationManagerCompat.Impl
{
  public void cancelNotification(NotificationManager paramNotificationManager, String paramString, int paramInt)
  {
    paramNotificationManager.cancel(paramInt);
  }
  
  public int getSideChannelBindFlags()
  {
    return 1;
  }
  
  public void postNotification(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification)
  {
    paramNotificationManager.notify(paramInt, paramNotification);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat.ImplBase
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */