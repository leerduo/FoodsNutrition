package u.aly;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.microedition.khronos.opengles.GL10;

public class bi
{
  protected static final String a = bi.class.getName();
  
  private static int a(Object paramObject, String paramString)
  {
    try
    {
      Field localField = DisplayMetrics.class.getDeclaredField(paramString);
      localField.setAccessible(true);
      int i = localField.getInt(paramObject);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public static String a()
  {
    String str = null;
    try
    {
      FileReader localFileReader = new FileReader("/proc/cpuinfo");
      str = null;
      if (localFileReader != null) {}
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(localFileReader, 1024);
        str = localBufferedReader.readLine();
        localBufferedReader.close();
        localFileReader.close();
        if (str != null) {
          return str.substring(1 + str.indexOf(':')).trim();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          bj.b(a, "Could not read from file /proc/cpuinfo", localIOException);
        }
      }
      return "";
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        bj.b(a, "Could not open file /proc/cpuinfo", localFileNotFoundException);
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str = String.valueOf(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "";
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }
  
  public static String[] a(GL10 paramGL10)
  {
    try
    {
      String[] arrayOfString = new String[2];
      String str1 = paramGL10.glGetString(7936);
      String str2 = paramGL10.glGetString(7937);
      arrayOfString[0] = str1;
      arrayOfString[1] = str2;
      return arrayOfString;
    }
    catch (Exception localException)
    {
      bj.b(a, "Could not read gpu infor:", localException);
    }
    return new String[0];
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "";
  }
  
  public static String c(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null) {
      bj.d(a, "No IMEI.");
    }
    try
    {
      if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        String str2 = localTelephonyManager.getDeviceId();
        str1 = str2;
        if (TextUtils.isEmpty(str1))
        {
          bj.d(a, "No IMEI.");
          str1 = k(paramContext);
          if (TextUtils.isEmpty(str1))
          {
            bj.d(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
            str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            bj.a(a, "getDeviceId: Secure.ANDROID_ID: " + str1);
          }
        }
        return str1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bj.d(a, "No IMEI.", localException);
        String str1 = "";
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    return bv.b(c(paramContext));
  }
  
  public static String[] e(Context paramContext)
  {
    String[] arrayOfString = { "", "" };
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
      {
        arrayOfString[0] = "";
        return arrayOfString;
      }
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
      {
        arrayOfString[0] = "";
        return arrayOfString;
      }
      if (localConnectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED)
      {
        arrayOfString[0] = "Wi-Fi";
        return arrayOfString;
      }
      NetworkInfo localNetworkInfo = localConnectivityManager.getNetworkInfo(0);
      if (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED)
      {
        arrayOfString[0] = "2G/3G";
        arrayOfString[1] = localNetworkInfo.getSubtypeName();
        return arrayOfString;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfString;
  }
  
  public static boolean f(Context paramContext)
  {
    return "Wi-Fi".equals(e(paramContext)[0]);
  }
  
  public static boolean g(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnectedOrConnecting();
        return bool;
      }
      return false;
    }
    catch (Exception localException) {}
    return true;
  }
  
  public static int h(Context paramContext)
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance(r(paramContext));
      if (localCalendar != null)
      {
        int i = localCalendar.getTimeZone().getRawOffset() / 3600000;
        return i;
      }
    }
    catch (Exception localException)
    {
      bj.a(a, "error in getTimeZone", localException);
    }
    return 8;
  }
  
  public static String[] i(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    try
    {
      Locale localLocale = r(paramContext);
      if (localLocale != null)
      {
        arrayOfString[0] = localLocale.getCountry();
        arrayOfString[1] = localLocale.getLanguage();
      }
      if (TextUtils.isEmpty(arrayOfString[0])) {
        arrayOfString[0] = "Unknown";
      }
      if (TextUtils.isEmpty(arrayOfString[1])) {
        arrayOfString[1] = "Unknown";
      }
      return arrayOfString;
    }
    catch (Exception localException)
    {
      bj.b(a, "error in getLocaleInfo", localException);
    }
    return arrayOfString;
  }
  
  public static String j(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        String str = localApplicationInfo.metaData.getString("UMENG_APPKEY");
        if (str != null) {
          return str.trim();
        }
        bj.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
      }
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bj.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", localException);
      }
    }
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        return localWifiManager.getConnectionInfo().getMacAddress();
      }
      bj.d(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
      return "";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bj.d(a, "Could not get mac address." + localException.toString());
      }
    }
  }
  
  public static int[] l(Context paramContext)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if ((0x2000 & paramContext.getApplicationInfo().flags) != 0) {
          break label146;
        }
        j = a(localDisplayMetrics, "noncompatWidthPixels");
        i = a(localDisplayMetrics, "noncompatHeightPixels");
      }
      catch (Exception localException)
      {
        DisplayMetrics localDisplayMetrics;
        int k;
        int m;
        int[] arrayOfInt;
        bj.b(a, "read resolution fail", localException);
        return null;
      }
      k = localDisplayMetrics.widthPixels;
      m = localDisplayMetrics.heightPixels;
      int n = k;
      int i1 = m;
      label81:
      arrayOfInt = new int[2];
      if (n > i1)
      {
        arrayOfInt[0] = i1;
        arrayOfInt[1] = n;
        return arrayOfInt;
      }
      arrayOfInt[0] = n;
      arrayOfInt[1] = i1;
      return arrayOfInt;
      label146:
      do
      {
        n = j;
        i1 = i;
        break label81;
        i = -1;
        j = -1;
        if (j == -1) {
          break;
        }
      } while (i != -1);
    }
  }
  
  public static String m(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      return str;
    }
    catch (Exception localException)
    {
      bj.a(a, "read carrier fail", localException);
    }
    return "Unknown";
  }
  
  public static String n(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
      {
        Object localObject = localApplicationInfo.metaData.get("UMENG_CHANNEL");
        if (localObject != null)
        {
          String str = localObject.toString();
          if (str != null) {
            return str;
          }
          bj.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
          return "Unknown";
        }
      }
    }
    catch (Exception localException)
    {
      bj.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
      localException.printStackTrace();
    }
    return "Unknown";
  }
  
  public static String o(Context paramContext)
  {
    return paramContext.getPackageName();
  }
  
  public static String p(Context paramContext)
  {
    return paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo()).toString();
  }
  
  public static boolean q(Context paramContext)
  {
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      int j = i & 0x2;
      boolean bool = false;
      if (j != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static Locale r(Context paramContext)
  {
    try
    {
      Configuration localConfiguration = new Configuration();
      localConfiguration.setToDefaults();
      Settings.System.getConfiguration(paramContext.getContentResolver(), localConfiguration);
      localLocale = null;
      if (localConfiguration != null) {
        localLocale = localConfiguration.locale;
      }
      if (localLocale == null) {
        localLocale = Locale.getDefault();
      }
      return localLocale;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bj.b(a, "fail to read user config locale");
        Locale localLocale = null;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bi
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */