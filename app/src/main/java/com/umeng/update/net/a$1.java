package com.umeng.update.net;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import u.upd.b;

class a$1
  implements ServiceConnection
{
  a$1(a parama) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    b.c(a.b(), "ServiceConnection.onServiceConnected");
    a.a(this.a, new Messenger(paramIBinder));
    try
    {
      Message localMessage = Message.obtain(null, 4);
      a.a locala = new a.a(a.a(this.a), a.b(this.a), a.c(this.a));
      locala.d = a.d(this.a);
      locala.e = a.e(this.a);
      locala.f = a.f(this.a);
      locala.g = a.g(this.a);
      locala.h = a.h(this.a);
      locala.i = a.i(this.a);
      localMessage.setData(locala.a());
      localMessage.replyTo = this.a.a;
      a.j(this.a).send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    b.c(a.b(), "ServiceConnection.onServiceDisconnected");
    a.a(this.a, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.a.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */