package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.IBinder;
import android.os.Parcel;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static b b;
  private Context a;
  
  private b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private boolean A()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)b("phone");
    if (localTelephonyManager == null) {
      return false;
    }
    if (localTelephonyManager.getNetworkType() == 13) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean B()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)b("phone");
    if (localTelephonyManager == null) {
      return false;
    }
    switch (localTelephonyManager.getNetworkType())
    {
    default: 
      return false;
    case 7: 
      return false;
    case 4: 
      return false;
    case 2: 
      return false;
    case 5: 
      return true;
    case 6: 
      return true;
    case 1: 
      return false;
    case 8: 
      return true;
    case 10: 
      return true;
    case 9: 
      return true;
    case 3: 
      return true;
    case 14: 
      return true;
    case 12: 
      return true;
    case 15: 
      return true;
    case 11: 
      return false;
    case 13: 
      return true;
    }
    return false;
  }
  
  private String C()
  {
    if (!w()) {}
    File localFile2;
    do
    {
      File localFile1;
      do
      {
        return null;
        localFile1 = new File(x(), "ShareSDK");
      } while (!localFile1.exists());
      localFile2 = new File(localFile1, ".dk");
    } while (!localFile2.exists());
    ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream(localFile2));
    Object localObject = localObjectInputStream.readObject();
    if ((localObject != null) && ((localObject instanceof char[]))) {}
    for (String str = String.valueOf((char[])localObject);; str = null)
    {
      localObjectInputStream.close();
      return str;
    }
  }
  
  public static b a(Context paramContext)
  {
    if (b == null) {
      b = new b(paramContext);
    }
    return b;
  }
  
  private boolean a(PackageInfo paramPackageInfo)
  {
    int i;
    if ((0x1 & paramPackageInfo.applicationInfo.flags) == 1)
    {
      i = 1;
      if ((0x80 & paramPackageInfo.applicationInfo.flags) != 1) {
        break label54;
      }
    }
    label54:
    for (int j = 1;; j = 0)
    {
      boolean bool;
      if (i == 0)
      {
        bool = false;
        if (j == 0) {}
      }
      else
      {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  private Object b(String paramString)
  {
    try
    {
      Object localObject = this.a.getSystemService(paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
    return null;
  }
  
  private void c(String paramString)
  {
    if (!w()) {
      return;
    }
    File localFile1 = new File(x(), "ShareSDK");
    if (!localFile1.exists()) {
      localFile1.mkdirs();
    }
    File localFile2 = new File(localFile1, ".dk");
    if (localFile2.exists()) {
      localFile2.delete();
    }
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(localFile2));
    localObjectOutputStream.writeObject(paramString.toCharArray());
    localObjectOutputStream.flush();
    localObjectOutputStream.close();
  }
  
  public String a()
  {
    WifiManager localWifiManager = (WifiManager)b("wifi");
    if (localWifiManager == null) {}
    WifiInfo localWifiInfo;
    do
    {
      return null;
      localWifiInfo = localWifiManager.getConnectionInfo();
    } while (localWifiInfo == null);
    String str = localWifiInfo.getMacAddress();
    if (str == null) {
      str = null;
    }
    return str;
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      String str1 = Base64.encodeToString(a.a(paramString2, paramString1), 0);
      localObject = str1;
      String str2;
      Throwable localThrowable2;
      e.c(localThrowable2);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (((String)localObject).contains("\n"))
        {
          str2 = ((String)localObject).replace("\n", "");
          localObject = str2;
        }
        return localObject;
      }
      catch (Throwable localThrowable3)
      {
        Object localObject;
        break label50;
      }
      localThrowable1 = localThrowable1;
      localObject = null;
      localThrowable2 = localThrowable1;
    }
    label50:
    return localObject;
  }
  
  public ArrayList<HashMap<String, String>> a(boolean paramBoolean)
  {
    try
    {
      PackageManager localPackageManager = this.a.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
        if ((paramBoolean) || (!a(localPackageInfo)))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pkg", localPackageInfo.packageName);
          localHashMap.put("name", localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString());
          localHashMap.put("version", localPackageInfo.versionName);
          localArrayList.add(localHashMap);
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
      return new ArrayList();
    }
  }
  
  public boolean a(String paramString)
  {
    return this.a.getPackageManager().checkPermission(paramString, q()) == 0;
  }
  
  public String b()
  {
    return Build.MODEL;
  }
  
  public String c()
  {
    return Build.MANUFACTURER;
  }
  
  public String d()
  {
    String str = e();
    if (str == null) {
      str = f();
    }
    return str;
  }
  
  public String e()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)b("phone");
    String str1;
    if (localTelephonyManager == null) {
      str1 = null;
    }
    String str2;
    do
    {
      return str1;
      str1 = localTelephonyManager.getDeviceId();
      str2 = "";
      if (str1 != null) {
        str2 = new String(str1).replace("0", "");
      }
    } while ((str1 != null) && (str2.length() > 0));
    return null;
  }
  
  public String f()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      try
      {
        Class localClass = Class.forName("android.os.SystemProperties");
        String str = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { "ro.serialno", "unknown" });
        return str;
      }
      catch (Throwable localThrowable)
      {
        e.a(localThrowable);
        return null;
      }
    }
    return null;
  }
  
  public String g()
  {
    return a(b() + "|" + i() + "|" + c() + "|" + l() + "|" + k(), p().substring(0, 16));
  }
  
  public String h()
  {
    return b() + "|" + i() + "|" + c() + "|" + l() + "|" + k();
  }
  
  public String i()
  {
    return String.valueOf(Build.VERSION.SDK_INT);
  }
  
  public String j()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String k()
  {
    int[] arrayOfInt = R.getScreenSize(this.a);
    if (this.a.getResources().getConfiguration().orientation == 1) {
      return arrayOfInt[0] + "x" + arrayOfInt[1];
    }
    return arrayOfInt[1] + "x" + arrayOfInt[0];
  }
  
  public String l()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)b("phone");
    String str;
    if (localTelephonyManager == null) {
      str = "-1";
    }
    do
    {
      return str;
      str = localTelephonyManager.getSimOperator();
    } while (!TextUtils.isEmpty(str));
    return "-1";
  }
  
  public String m()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)b("connectivity");
    if (localConnectivityManager == null) {
      return "none";
    }
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable())) {
      return "none";
    }
    switch (localNetworkInfo.getType())
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      return "none";
    case 1: 
      return "wifi";
    case 0: 
      String str1 = Proxy.getDefaultHost();
      String str2 = "";
      if ((str1 != null) && (str1.length() > 0)) {
        str2 = " wap";
      }
      if (A()) {
        return "4G" + str2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (B()) {}
      for (String str3 = "3G";; str3 = "2G") {
        return str3 + str2;
      }
    case 7: 
      return "bluetooth";
    case 8: 
      return "dummy";
    case 9: 
      return "ethernet";
    }
    return "wimax";
  }
  
  public String n()
  {
    String str = m();
    if ((TextUtils.isEmpty(str)) || ("none".equals(str))) {
      return "none";
    }
    if ((str.startsWith("4G")) || (str.startsWith("3G")) || (str.startsWith("2G"))) {
      return "cell";
    }
    if (str.startsWith("wifi")) {
      return "wifi";
    }
    return "other";
  }
  
  public int o()
  {
    return 1;
  }
  
  /* Error */
  public String p()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 439	cn/sharesdk/framework/utils/b:C	()Ljava/lang/String;
    //   4: astore 13
    //   6: aload 13
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +20 -> 30
    //   13: aload_3
    //   14: astore 6
    //   16: aload 6
    //   18: areturn
    //   19: astore_1
    //   20: aload_1
    //   21: invokestatic 112	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   24: pop
    //   25: aconst_null
    //   26: astore_3
    //   27: goto -18 -> 9
    //   30: aload_0
    //   31: invokevirtual 441	cn/sharesdk/framework/utils/b:a	()Ljava/lang/String;
    //   34: astore 9
    //   36: aload_0
    //   37: invokevirtual 443	cn/sharesdk/framework/utils/b:d	()Ljava/lang/String;
    //   40: astore 10
    //   42: aload_0
    //   43: invokevirtual 309	cn/sharesdk/framework/utils/b:b	()Ljava/lang/String;
    //   46: astore 11
    //   48: new 306	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   55: aload 9
    //   57: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 445
    //   63: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 10
    //   68: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 445
    //   74: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 11
    //   79: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 448	cn/sharesdk/framework/utils/a:a	(Ljava/lang/String;)[B
    //   88: invokestatic 451	cn/sharesdk/framework/utils/a:b	([B)Ljava/lang/String;
    //   91: astore 12
    //   93: aload 12
    //   95: astore 6
    //   97: aload 6
    //   99: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +8 -> 110
    //   105: ldc_w 453
    //   108: astore 6
    //   110: aload 6
    //   112: ifnull -96 -> 16
    //   115: aload_0
    //   116: aload 6
    //   118: invokespecial 455	cn/sharesdk/framework/utils/b:c	(Ljava/lang/String;)V
    //   121: aload 6
    //   123: areturn
    //   124: astore 7
    //   126: aload 7
    //   128: invokestatic 112	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   131: pop
    //   132: aload 6
    //   134: areturn
    //   135: astore 4
    //   137: aload 4
    //   139: invokestatic 303	cn/sharesdk/framework/utils/e:a	(Ljava/lang/Throwable;)I
    //   142: pop
    //   143: aconst_null
    //   144: astore 6
    //   146: goto -49 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	b
    //   19	2	1	localThrowable1	Throwable
    //   8	19	3	str1	String
    //   135	3	4	localThrowable2	Throwable
    //   14	131	6	localObject	Object
    //   124	3	7	localThrowable3	Throwable
    //   34	22	9	str2	String
    //   40	27	10	str3	String
    //   46	32	11	str4	String
    //   91	3	12	str5	String
    //   4	3	13	str6	String
    // Exception table:
    //   from	to	target	type
    //   0	6	19	java/lang/Throwable
    //   115	121	124	java/lang/Throwable
    //   30	93	135	java/lang/Throwable
  }
  
  public String q()
  {
    return this.a.getPackageName();
  }
  
  public String r()
  {
    String str = this.a.getApplicationInfo().name;
    if (str != null) {}
    int i;
    do
    {
      return str;
      i = this.a.getApplicationInfo().labelRes;
    } while (i <= 0);
    return this.a.getString(i);
  }
  
  public int s()
  {
    try
    {
      int i = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Throwable localThrowable)
    {
      e.a(localThrowable);
    }
    return 0;
  }
  
  public String t()
  {
    try
    {
      String str = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionName;
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.a(localThrowable);
    }
    return "1.0";
  }
  
  public String u()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)b("phone");
    if (localTelephonyManager == null) {
      return null;
    }
    return localTelephonyManager.getNetworkOperator();
  }
  
  /* Error */
  public String v()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 489
    //   4: invokevirtual 491	cn/sharesdk/framework/utils/b:a	(Ljava/lang/String;)Z
    //   7: istore 8
    //   9: iload 8
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +67 -> 80
    //   16: aload_0
    //   17: ldc_w 493
    //   20: invokespecial 28	cn/sharesdk/framework/utils/b:b	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 495	android/app/ActivityManager
    //   26: astore 6
    //   28: aload 6
    //   30: ifnonnull +16 -> 46
    //   33: aconst_null
    //   34: areturn
    //   35: astore_1
    //   36: aload_1
    //   37: invokestatic 112	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   40: pop
    //   41: iconst_0
    //   42: istore_3
    //   43: goto -31 -> 12
    //   46: aload 6
    //   48: iconst_1
    //   49: invokevirtual 498	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   52: iconst_0
    //   53: invokeinterface 501 2 0
    //   58: checkcast 503	android/app/ActivityManager$RunningTaskInfo
    //   61: getfield 507	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   64: invokevirtual 510	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   67: astore 7
    //   69: aload 7
    //   71: areturn
    //   72: astore 4
    //   74: aload 4
    //   76: invokestatic 112	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   79: pop
    //   80: aconst_null
    //   81: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	b
    //   35	2	1	localThrowable1	Throwable
    //   11	32	3	bool1	boolean
    //   72	3	4	localThrowable2	Throwable
    //   26	21	6	localActivityManager	android.app.ActivityManager
    //   67	3	7	str	String
    //   7	3	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	9	35	java/lang/Throwable
    //   16	28	72	java/lang/Throwable
    //   46	69	72	java/lang/Throwable
  }
  
  public boolean w()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
    return false;
  }
  
  public String x()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath();
  }
  
  public String y()
  {
    String str = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
    e.b("getAndroidID === %s", new Object[] { str });
    return str;
  }
  
  public String z()
  {
    try
    {
      Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
      localIntent.setPackage("com.google.android.gms");
      b.a locala = new b.a(this, null);
      this.a.bindService(localIntent, locala, 1);
      IBinder localIBinder = locala.a();
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      localIBinder.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      localParcel2.recycle();
      localParcel1.recycle();
      e.b("getAdvertisingID === %s", new Object[] { str });
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.b(localThrowable);
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */