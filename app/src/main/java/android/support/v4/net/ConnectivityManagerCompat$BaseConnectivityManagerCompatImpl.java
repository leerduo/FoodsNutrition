package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl
  implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
{
  public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return true;
    }
    switch (localNetworkInfo.getType())
    {
    case 0: 
    default: 
      return true;
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat.BaseConnectivityManagerCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */