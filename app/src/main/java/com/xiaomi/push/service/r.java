package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.xmpush.thrift.d;
import com.xiaomi.xmpush.thrift.k;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class r
{
  public static long a = 0L;
  
  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.equals(paramContext.getPackageName())) {
      return paramContext.getResources().getIdentifier(paramString2, "drawable", paramString1);
    }
    return 0;
  }
  
  private static Notification a(Notification paramNotification, String paramString)
  {
    try
    {
      Field localField = Notification.class.getDeclaredField("extraNotification");
      localField.setAccessible(true);
      Object localObject = localField.get(paramNotification);
      Method localMethod = localObject.getClass().getDeclaredMethod("setTargetPkg", new Class[] { CharSequence.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localObject, new Object[] { paramString });
      return paramNotification;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
    return paramNotification;
  }
  
  @SuppressLint({"NewApi"})
  private static Notification a(Context paramContext, k paramk, byte[] paramArrayOfByte, RemoteViews paramRemoteViews)
  {
    d locald = paramk.m();
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    String[] arrayOfString = a(paramContext, locald);
    localBuilder.setContentTitle(arrayOfString[0]);
    localBuilder.setContentText(arrayOfString[1]);
    label132:
    int k;
    if (paramRemoteViews != null)
    {
      localBuilder.setContent(paramRemoteViews);
      localBuilder.setWhen(System.currentTimeMillis());
      localBuilder.setContentIntent(a(paramContext, paramk, locald, paramArrayOfByte));
      int i = a(paramContext, a(paramk), "mipush_notification");
      int j = a(paramContext, a(paramk), "mipush_small_notification");
      if ((i <= 0) || (j <= 0)) {
        break label327;
      }
      localBuilder.setLargeIcon(a(paramContext, i));
      localBuilder.setSmallIcon(j);
      localBuilder.setAutoCancel(true);
      long l = System.currentTimeMillis();
      if (l - a > 10000L)
      {
        a = l;
        k = locald.f;
        if (!e(paramContext, a(paramk))) {
          break label344;
        }
      }
    }
    label327:
    label344:
    for (int m = c(paramContext, a(paramk));; m = k)
    {
      localBuilder.setDefaults(m);
      Map localMap = locald.s();
      if ((localMap != null) && ((m & 0x1) != 0))
      {
        String str = (String)localMap.get("sound_uri");
        if ((!TextUtils.isEmpty(str)) && (str.startsWith("android.resource://" + a(paramk))))
        {
          localBuilder.setDefaults(m ^ 0x1);
          localBuilder.setSound(Uri.parse(str));
        }
      }
      return localBuilder.getNotification();
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      localBuilder.setStyle(new Notification.BigTextStyle().bigText(arrayOfString[1]));
      break;
      localBuilder.setSmallIcon(f(paramContext, a(paramk)));
      break label132;
    }
  }
  
  private static PendingIntent a(Context paramContext, k paramk, d paramd, byte[] paramArrayOfByte)
  {
    if ((paramd != null) && (!TextUtils.isEmpty(paramd.g)))
    {
      Intent localIntent2 = new Intent("android.intent.action.VIEW");
      localIntent2.setData(Uri.parse(paramd.g));
      localIntent2.addFlags(268435456);
      return PendingIntent.getActivity(paramContext, 0, localIntent2, 134217728);
    }
    Intent localIntent1 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent1.setComponent(new ComponentName(paramk.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
    localIntent1.putExtra("mipush_payload", paramArrayOfByte);
    localIntent1.putExtra("mipush_notified", true);
    localIntent1.addCategory(String.valueOf(paramd.q()));
    return PendingIntent.getService(paramContext, 0, localIntent1, 134217728);
  }
  
  private static Bitmap a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources().getDrawable(paramInt));
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    int i = 1;
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int j = paramDrawable.getIntrinsicWidth();
    if (j > 0) {}
    for (;;)
    {
      int k = paramDrawable.getIntrinsicHeight();
      if (k > 0) {
        i = k;
      }
      Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
      j = i;
    }
  }
  
  static String a(k paramk)
  {
    if ("com.xiaomi.xmsf".equals(paramk.f))
    {
      d locald = paramk.m();
      if ((locald != null) && (locald.s() != null))
      {
        String str = (String)locald.s().get("miui_package_name");
        if (!TextUtils.isEmpty(str)) {
          return str;
        }
      }
    }
    return paramk.f;
  }
  
  public static void a(Context paramContext, k paramk, byte[] paramArrayOfByte)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    d locald = paramk.m();
    RemoteViews localRemoteViews = b(paramContext, paramk, paramArrayOfByte);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = a(paramContext, paramk, paramArrayOfByte, localRemoteViews);
      if ("com.xiaomi.xmsf".equals(paramContext.getPackageName())) {
        a((Notification)localObject, a(paramk));
      }
      localNotificationManager.notify(locald.q() + 10 * (a(paramk).hashCode() / 10), (Notification)localObject);
      return;
    }
    Notification localNotification = new Notification(f(paramContext, a(paramk)), null, System.currentTimeMillis());
    String[] arrayOfString = a(paramContext, locald);
    localNotification.setLatestEventInfo(paramContext, arrayOfString[0], arrayOfString[1], a(paramContext, paramk, locald, paramArrayOfByte));
    long l = System.currentTimeMillis();
    int i;
    if (l - a > 10000L)
    {
      a = l;
      i = locald.f;
      if (!e(paramContext, a(paramk))) {
        break label323;
      }
    }
    label323:
    for (int j = c(paramContext, a(paramk));; j = i)
    {
      localNotification.defaults = j;
      Map localMap = locald.s();
      if ((localMap != null) && ((j & 0x1) != 0))
      {
        String str = (String)localMap.get("sound_uri");
        if ((!TextUtils.isEmpty(str)) && (str.startsWith("android.resource://" + a(paramk))))
        {
          localNotification.defaults = (j ^ 0x1);
          localNotification.sound = Uri.parse(str);
        }
      }
      localNotification.flags = (0x10 | localNotification.flags);
      if (localRemoteViews != null) {
        localNotification.contentView = localRemoteViews;
      }
      localObject = localNotification;
      break;
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(paramInt + 10 * (paramString.hashCode() / 10));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    List localList;
    try
    {
      localList = localActivityManager.getRunningTasks(1);
      if ((localList == null) || (localList.isEmpty())) {
        return false;
      }
    }
    catch (Exception localException)
    {
      b.a(localException);
      return false;
    }
    return ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName().equals(paramString);
  }
  
  private static String[] a(Context paramContext, d paramd)
  {
    Object localObject1 = paramd.h();
    Object localObject2 = paramd.j();
    Map localMap = paramd.s();
    int j;
    Object localObject3;
    if (localMap != null)
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      float f = paramContext.getResources().getDisplayMetrics().density;
      j = Float.valueOf(0.5F + i / f).intValue();
      if (j > 320) {
        break label136;
      }
      String str3 = (String)localMap.get("title_short");
      if (!TextUtils.isEmpty(str3)) {
        localObject1 = str3;
      }
      localObject3 = (String)localMap.get("description_short");
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label199;
      }
    }
    for (;;)
    {
      localObject2 = localObject3;
      for (;;)
      {
        return new String[] { localObject1, localObject2 };
        label136:
        if (j > 360)
        {
          String str1 = (String)localMap.get("title_long");
          if (!TextUtils.isEmpty(str1)) {
            localObject1 = str1;
          }
          String str2 = (String)localMap.get("description_long");
          if (!TextUtils.isEmpty(str2)) {
            localObject2 = str2;
          }
        }
      }
      label199:
      localObject3 = localObject2;
    }
  }
  
  private static RemoteViews b(Context paramContext, k paramk, byte[] paramArrayOfByte)
  {
    d locald = paramk.m();
    String str1 = a(paramk);
    Map localMap = locald.s();
    if (localMap == null) {
      return null;
    }
    String str2 = (String)localMap.get("layout_name");
    String str3 = (String)localMap.get("layout_value");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
      return null;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Resources localResources;
    int i;
    try
    {
      localResources = localPackageManager.getResourcesForApplication(str1);
      i = localResources.getIdentifier(str2, "layout", str1);
      if (i == 0) {
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      b.a(localNameNotFoundException);
      return null;
    }
    RemoteViews localRemoteViews = new RemoteViews(str1, i);
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject(str3);
      if (localJSONObject1.has("text"))
      {
        JSONObject localJSONObject3 = localJSONObject1.getJSONObject("text");
        Iterator localIterator2 = localJSONObject3.keys();
        while (localIterator2.hasNext())
        {
          String str6 = (String)localIterator2.next();
          String str7 = localJSONObject3.getString(str6);
          int m = localResources.getIdentifier(str6, "id", str1);
          if (m > 0) {
            localRemoteViews.setTextViewText(m, str7);
          }
        }
      }
      if (!localJSONObject1.has("image")) {
        break label343;
      }
    }
    catch (JSONException localJSONException)
    {
      b.a(localJSONException);
      return null;
    }
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("image");
    Iterator localIterator1 = localJSONObject2.keys();
    while (localIterator1.hasNext())
    {
      String str4 = (String)localIterator1.next();
      String str5 = localJSONObject2.getString(str4);
      int j = localResources.getIdentifier(str4, "id", str1);
      int k = localResources.getIdentifier(str5, "drawable", str1);
      if (j > 0) {
        localRemoteViews.setImageViewResource(j, k);
      }
    }
    label343:
    return localRemoteViews;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    for (int i = 0; i <= 4; i++) {
      localNotificationManager.cancel(i + 10 * (paramString.hashCode() / 10));
    }
  }
  
  static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  static int c(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).getInt(paramString, 2147483647);
  }
  
  static void d(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().remove(paramString).commit();
  }
  
  static boolean e(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).contains(paramString);
  }
  
  private static int f(Context paramContext, String paramString)
  {
    int i = a(paramContext, paramString, "mipush_notification");
    int j = a(paramContext, paramString, "mipush_small_notification");
    if (i > 0) {}
    for (;;)
    {
      if ((i == 0) && (Build.VERSION.SDK_INT >= 9)) {
        i = paramContext.getApplicationInfo().logo;
      }
      return i;
      if (j > 0) {
        i = j;
      } else {
        i = paramContext.getApplicationInfo().icon;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.r
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */