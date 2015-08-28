package com.umeng.update.net;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import u.upd.a;
import u.upd.b;
import u.upd.l;

class DownloadingService$1
  extends Handler
{
  DownloadingService$1(DownloadingService paramDownloadingService) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 5: 
      a.a locala2 = (a.a)paramMessage.obj;
      int j = paramMessage.arg2;
      for (;;)
      {
        PendingIntent localPendingIntent2;
        try
        {
          String str4 = paramMessage.getData().getString("filename");
          j.a(str4, 39, -1, -1);
          b.c(DownloadingService.a(), "Cancel old notification....");
          Intent localIntent = new Intent("android.intent.action.VIEW");
          localIntent.addFlags(268435456);
          localIntent.setDataAndType(Uri.fromFile(new File(str4)), "application/vnd.android.package-archive");
          localPendingIntent2 = PendingIntent.getActivity(DownloadingService.b(this.a), 0, localIntent, 134217728);
          if (locala2.h)
          {
            Notification localNotification2 = new Notification(17301634, DownloadingService.b(this.a).getString(l.m(DownloadingService.b(this.a))), System.currentTimeMillis());
            localNotification2.setLatestEventInfo(DownloadingService.b(this.a), locala2.b, DownloadingService.b(this.a).getString(l.m(DownloadingService.b(this.a))), localPendingIntent2);
            localObject = localNotification2;
            ((Notification)localObject).flags = 16;
            DownloadingService.a(this.a, (NotificationManager)this.a.getSystemService("notification"));
            DownloadingService.c(this.a).notify(j + 1, (Notification)localObject);
            b.c(DownloadingService.a(), "Show new  notification....");
            boolean bool = DownloadingService.a(this.a).a(DownloadingService.b(this.a));
            String str5 = DownloadingService.a();
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = Boolean.valueOf(bool);
            b.c(str5, String.format("isAppOnForeground = %1$B", arrayOfObject1));
            if ((bool) && (!locala2.h))
            {
              DownloadingService.c(this.a).cancel(j + 1);
              DownloadingService.b(this.a).startActivity(localIntent);
            }
            String str6 = DownloadingService.a();
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = locala2.b;
            arrayOfObject2[1] = str4;
            b.a(str6, String.format("%1$10s downloaded. Saved to: %2$s", arrayOfObject2));
            return;
          }
        }
        catch (Exception localException)
        {
          b.b(DownloadingService.a(), "can not install. " + localException.getMessage());
          DownloadingService.c(this.a).cancel(j + 1);
          return;
        }
        Notification localNotification3 = new Notification(17301634, DownloadingService.b(this.a).getString(l.k(DownloadingService.b(this.a))), System.currentTimeMillis());
        localNotification3.setLatestEventInfo(DownloadingService.b(this.a), locala2.b, DownloadingService.b(this.a).getString(l.k(DownloadingService.b(this.a))), localPendingIntent2);
        Object localObject = localNotification3;
      }
    }
    a.a locala1 = (a.a)paramMessage.obj;
    int i = paramMessage.arg2;
    String str1 = paramMessage.getData().getString("filename");
    DownloadingService.c(this.a).cancel(i);
    Notification localNotification1 = new Notification(17301633, DownloadingService.b(this.a).getString(l.n(DownloadingService.b(this.a))), System.currentTimeMillis());
    PendingIntent localPendingIntent1 = PendingIntent.getActivity(DownloadingService.b(this.a), 0, new Intent(), 134217728);
    localNotification1.setLatestEventInfo(DownloadingService.b(this.a), a.j(DownloadingService.b(this.a)), DownloadingService.b(this.a).getString(l.n(DownloadingService.b(this.a))), localPendingIntent1);
    DownloadingService.c(this.a).notify(i + 1, localNotification1);
    String str2 = str1.replace(".patch", ".apk");
    String str3 = DeltaUpdate.a(this.a);
    c localc = DownloadingService.a(this.a);
    localc.getClass();
    new c.c(localc, DownloadingService.b(this.a), i, locala1, str2).execute(new String[] { str3, str2, str1 });
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.DownloadingService.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */