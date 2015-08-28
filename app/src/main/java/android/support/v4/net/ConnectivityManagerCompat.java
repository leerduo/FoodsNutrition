package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public class ConnectivityManagerCompat
{
  private static final ConnectivityManagerCompat.ConnectivityManagerCompatImpl IMPL = new ConnectivityManagerCompat.BaseConnectivityManagerCompatImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new ConnectivityManagerCompat.JellyBeanConnectivityManagerCompatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 13)
    {
      IMPL = new ConnectivityManagerCompat.HoneycombMR2ConnectivityManagerCompatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      IMPL = new ConnectivityManagerCompat.GingerbreadConnectivityManagerCompatImpl();
      return;
    }
  }
  
  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if (localNetworkInfo != null) {
      return paramConnectivityManager.getNetworkInfo(localNetworkInfo.getType());
    }
    return null;
  }
  
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    return IMPL.isActiveNetworkMetered(paramConnectivityManager);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */