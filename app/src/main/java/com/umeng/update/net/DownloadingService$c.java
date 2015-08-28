package com.umeng.update.net;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.widget.Toast;
import java.util.Map;
import u.upd.a;
import u.upd.b;
import u.upd.l;

class DownloadingService$c
  extends Handler
{
  DownloadingService$c(DownloadingService paramDownloadingService) {}
  
  public void handleMessage(Message paramMessage)
  {
    b.c(DownloadingService.a(), "IncomingHandler(msg.what:" + paramMessage.what + " msg.arg1:" + paramMessage.arg1 + " msg.arg2:" + paramMessage.arg2 + " msg.replyTo:" + paramMessage.replyTo);
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    Bundle localBundle = paramMessage.getData();
    b.c(DownloadingService.a(), "IncomingHandler(msg.getData():" + localBundle);
    a.a locala = a.a.a(localBundle);
    if (DownloadingService.a(this.a).a(locala, DownloadingService.r, paramMessage.replyTo))
    {
      b.a(DownloadingService.a(), locala.b + " is already in downloading list. ");
      int i = DownloadingService.a(this.a).b(locala);
      if ((i != -1) && (((c.b)DownloadingService.b().get(i)).a == null))
      {
        String str = f.a(i, "continue");
        Intent localIntent = new Intent(DownloadingService.b(this.a), DownloadingService.class);
        localIntent.putExtra("com.umeng.broadcast.download.msg", str);
        DownloadingService.a(this.a).a(this.a, localIntent);
        return;
      }
      Toast.makeText(DownloadingService.b(this.a), l.b(DownloadingService.b(this.a)), 0).show();
      Message localMessage3 = Message.obtain();
      localMessage3.what = 2;
      localMessage3.arg1 = 2;
      localMessage3.arg2 = 0;
      try
      {
        paramMessage.replyTo.send(localMessage3);
        return;
      }
      catch (RemoteException localRemoteException3)
      {
        localRemoteException3.printStackTrace();
        return;
      }
    }
    if (a.e(this.a.getApplicationContext()))
    {
      DownloadingService.c().put(locala, paramMessage.replyTo);
      Message localMessage2 = Message.obtain();
      localMessage2.what = 1;
      localMessage2.arg1 = 1;
      localMessage2.arg2 = 0;
      try
      {
        paramMessage.replyTo.send(localMessage2);
        DownloadingService.a(this.a, locala);
        return;
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          localRemoteException2.printStackTrace();
        }
      }
    }
    Toast.makeText(DownloadingService.b(this.a), l.a(DownloadingService.b(this.a)), 0).show();
    Message localMessage1 = Message.obtain();
    localMessage1.what = 2;
    localMessage1.arg1 = 4;
    localMessage1.arg2 = 0;
    try
    {
      paramMessage.replyTo.send(localMessage1);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      localRemoteException1.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.DownloadingService.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */