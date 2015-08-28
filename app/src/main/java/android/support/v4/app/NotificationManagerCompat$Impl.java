package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

abstract interface NotificationManagerCompat$Impl
{
  public abstract void cancelNotification(NotificationManager paramNotificationManager, String paramString, int paramInt);
  
  public abstract int getSideChannelBindFlags();
  
  public abstract void postNotification(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat.Impl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */