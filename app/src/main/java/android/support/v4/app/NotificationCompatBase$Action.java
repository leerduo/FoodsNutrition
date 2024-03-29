package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public abstract class NotificationCompatBase$Action
{
  protected abstract PendingIntent getActionIntent();
  
  protected abstract Bundle getExtras();
  
  protected abstract int getIcon();
  
  protected abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();
  
  protected abstract CharSequence getTitle();
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatBase.Action
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */