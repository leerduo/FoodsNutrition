package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplIceCreamSandwich
  extends NotificationCompat.NotificationCompatImplBase
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    return NotificationCompatIceCreamSandwich.add(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplIceCreamSandwich
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */