package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

class Dispatcher$NetworkBroadcastReceiver
  extends BroadcastReceiver
{
  private final Dispatcher a;
  
  Dispatcher$NetworkBroadcastReceiver(Dispatcher paramDispatcher)
  {
    this.a = paramDispatcher;
  }
  
  void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.AIRPLANE_MODE");
    if (this.a.o) {
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }
    this.a.b.registerReceiver(this, localIntentFilter);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getAction();
        if (!"android.intent.action.AIRPLANE_MODE".equals(str)) {
          break;
        }
      } while (!paramIntent.hasExtra("state"));
      this.a.a(paramIntent.getBooleanExtra("state", false));
      return;
    } while (!"android.net.conn.CONNECTIVITY_CHANGE".equals(str));
    ConnectivityManager localConnectivityManager = (ConnectivityManager)Utils.a(paramContext, "connectivity");
    this.a.a(localConnectivityManager.getActiveNetworkInfo());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Dispatcher.NetworkBroadcastReceiver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */