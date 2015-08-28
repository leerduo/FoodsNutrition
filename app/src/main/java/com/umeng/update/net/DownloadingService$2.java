package com.umeng.update.net;

import android.app.NotificationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.Map;

class DownloadingService$2
  implements DownloadingService.a
{
  SparseArray<Long> a = new SparseArray();
  
  DownloadingService$2(DownloadingService paramDownloadingService) {}
  
  public void a(int paramInt)
  {
    if (DownloadingService.b().indexOfKey(paramInt) >= 0)
    {
      c.b localb = (c.b)DownloadingService.b().get(paramInt);
      long[] arrayOfLong = localb.f;
      int i = 0;
      if (arrayOfLong != null)
      {
        boolean bool = arrayOfLong[1] < 0L;
        i = 0;
        if (bool)
        {
          i = (int)(100.0F * ((float)arrayOfLong[0] / (float)arrayOfLong[1]));
          if (i > 100) {
            i = 99;
          }
        }
      }
      if (!localb.e.h)
      {
        this.a.put(paramInt, Long.valueOf(-1L));
        c.a locala = DownloadingService.a(this.b).a(this.b, localb.e, paramInt, i);
        localb.b = locala;
        DownloadingService.c(this.b).notify(paramInt, locala.d());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (DownloadingService.b().indexOfKey(paramInt1) >= 0)
    {
      c.b localb = (c.b)DownloadingService.b().get(paramInt1);
      a.a locala = localb.e;
      long l = System.currentTimeMillis();
      if ((!locala.h) && (l - ((Long)this.a.get(paramInt1)).longValue() > 500L))
      {
        this.a.put(paramInt1, Long.valueOf(l));
        c.a locala1 = localb.b;
        locala1.a(100, paramInt2, false).a(String.valueOf(paramInt2) + "%");
        DownloadingService.c(this.b).notify(paramInt1, locala1.d());
      }
      String str = DownloadingService.a();
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = locala.b;
      u.upd.b.c(str, String.format("%3$10s Notification: mNotificationId = %1$15s\t|\tprogress = %2$15s", arrayOfObject));
    }
  }
  
  public void a(int paramInt, Exception paramException)
  {
    if (DownloadingService.b().indexOfKey(paramInt) >= 0) {
      DownloadingService.a(this.b).b(DownloadingService.b(this.b), paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    a.a locala;
    Bundle localBundle;
    if (DownloadingService.b().indexOfKey(paramInt) >= 0)
    {
      c.b localb = (c.b)DownloadingService.b().get(paramInt);
      if (localb != null)
      {
        locala = localb.e;
        b.a(DownloadingService.b(this.b)).a(locala.a, locala.c, 100);
        localBundle = new Bundle();
        localBundle.putString("filename", paramString);
        if (!locala.a.equalsIgnoreCase("delta_update")) {
          break label138;
        }
        Message localMessage3 = Message.obtain();
        localMessage3.what = 6;
        localMessage3.arg1 = 1;
        localMessage3.obj = locala;
        localMessage3.arg2 = paramInt;
        localMessage3.setData(localBundle);
        DownloadingService.d(this.b).sendMessage(localMessage3);
      }
    }
    return;
    label138:
    Message localMessage1 = Message.obtain();
    localMessage1.what = 5;
    localMessage1.arg1 = 1;
    localMessage1.obj = locala;
    localMessage1.arg2 = paramInt;
    localMessage1.setData(localBundle);
    DownloadingService.d(this.b).sendMessage(localMessage1);
    Message localMessage2 = Message.obtain();
    localMessage2.what = 5;
    localMessage2.arg1 = 1;
    localMessage2.arg2 = paramInt;
    localMessage2.setData(localBundle);
    try
    {
      if (DownloadingService.c().get(locala) != null) {
        ((Messenger)DownloadingService.c().get(locala)).send(localMessage2);
      }
      DownloadingService.a(this.b).b(DownloadingService.b(this.b), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      DownloadingService.a(this.b).b(DownloadingService.b(this.b), paramInt);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.DownloadingService.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */