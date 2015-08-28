package com.umeng.update.net;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import java.util.Map;
import u.upd.a;
import u.upd.b;
import u.upd.l;
import u.upd.n;

class c$c
  extends AsyncTask<String, Void, Integer>
{
  public int a;
  public String b;
  private a.a d;
  private Context e;
  private NotificationManager f;
  
  public c$c(c paramc, Context paramContext, int paramInt, a.a parama, String paramString)
  {
    this.e = paramContext.getApplicationContext();
    this.f = ((NotificationManager)this.e.getSystemService("notification"));
    this.a = paramInt;
    this.d = parama;
    this.b = paramString;
  }
  
  protected Integer a(String... paramVarArgs)
  {
    int i = 1 + DeltaUpdate.a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
    new File(paramVarArgs[2]).delete();
    if (i == 1)
    {
      if (!n.a(new File(paramVarArgs[1])).equalsIgnoreCase(this.d.e))
      {
        b.a(c.a(), "file patch error");
        return Integer.valueOf(0);
      }
      b.a(c.a(), "file patch success");
    }
    for (;;)
    {
      return Integer.valueOf(i);
      b.a(c.a(), "file patch error");
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      j.a(this.b, 39, -1, -1);
      Notification localNotification = new Notification(17301634, this.e.getString(l.l(this.e)), System.currentTimeMillis());
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(new File(this.b)), "application/vnd.android.package-archive");
      PendingIntent localPendingIntent = PendingIntent.getActivity(this.e, 0, localIntent, 134217728);
      localNotification.setLatestEventInfo(this.e, a.j(this.e), this.e.getString(l.l(this.e)), localPendingIntent);
      localNotification.flags = 16;
      this.f.notify(1 + this.a, localNotification);
      if ((this.c.a(this.e)) && (!this.d.h))
      {
        this.f.cancel(1 + this.a);
        this.e.startActivity(localIntent);
      }
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("filename", this.b);
      Message localMessage2 = Message.obtain();
      localMessage2.what = 5;
      localMessage2.arg1 = 1;
      localMessage2.arg2 = this.a;
      localMessage2.setData(localBundle2);
      try
      {
        if (c.a(this.c).get(this.d) != null) {
          ((Messenger)c.a(this.c).get(this.d)).send(localMessage2);
        }
        this.c.b(this.e, this.a);
        return;
      }
      catch (RemoteException localRemoteException2)
      {
        this.c.b(this.e, this.a);
        return;
      }
    }
    this.f.cancel(1 + this.a);
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("filename", this.b);
    Message localMessage1 = Message.obtain();
    localMessage1.what = 5;
    localMessage1.arg1 = 3;
    localMessage1.arg2 = this.a;
    localMessage1.setData(localBundle1);
    try
    {
      if (c.a(this.c).get(this.d) != null) {
        ((Messenger)c.a(this.c).get(this.d)).send(localMessage1);
      }
      this.c.b(this.e, this.a);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      this.c.b(this.e, this.a);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.c.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */