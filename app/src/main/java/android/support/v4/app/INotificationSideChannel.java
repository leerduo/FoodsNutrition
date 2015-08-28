package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;

public abstract interface INotificationSideChannel
  extends IInterface
{
  public abstract void cancel(String paramString1, int paramInt, String paramString2);
  
  public abstract void cancelAll(String paramString);
  
  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.INotificationSideChannel
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */