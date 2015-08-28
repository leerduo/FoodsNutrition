package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompatHoneycombMR2
{
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return true;
    }
    switch (localNetworkInfo.getType())
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    default: 
      return true;
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompatHoneycombMR2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */