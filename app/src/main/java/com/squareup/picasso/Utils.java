package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

final class Utils
{
  static final StringBuilder a = new StringBuilder();
  
  static int a(Resources paramResources, Request paramRequest)
  {
    if ((paramRequest.e != 0) || (paramRequest.d == null)) {
      return paramRequest.e;
    }
    String str1 = paramRequest.d.getAuthority();
    if (str1 == null) {
      throw new FileNotFoundException("No package provided: " + paramRequest.d);
    }
    List localList = paramRequest.d.getPathSegments();
    if ((localList == null) || (localList.isEmpty())) {
      throw new FileNotFoundException("No path segments: " + paramRequest.d);
    }
    if (localList.size() == 1) {
      try
      {
        int i = Integer.parseInt((String)localList.get(0));
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new FileNotFoundException("Last path segment is not a resource ID: " + paramRequest.d);
      }
    }
    if (localList.size() == 2)
    {
      String str2 = (String)localList.get(0);
      return paramResources.getIdentifier((String)localList.get(1), str2, str1);
    }
    throw new FileNotFoundException("More than two path segments: " + paramRequest.d);
  }
  
  static int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 12) {}
    for (int i = Utils.BitmapHoneycombMR1.a(paramBitmap); i < 0; i = paramBitmap.getRowBytes() * paramBitmap.getHeight()) {
      throw new IllegalStateException("Negative size: " + paramBitmap);
    }
    return i;
  }
  
  static long a(File paramFile)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramFile.getAbsolutePath());
      l = localStatFs.getBlockCount() * localStatFs.getBlockSize() / 50L;
      return Math.max(Math.min(l, 52428800L), 5242880L);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        long l = 5242880L;
      }
    }
  }
  
  static Resources a(Context paramContext, Request paramRequest)
  {
    if ((paramRequest.e != 0) || (paramRequest.d == null)) {
      return paramContext.getResources();
    }
    String str = paramRequest.d.getAuthority();
    if (str == null) {
      throw new FileNotFoundException("No package provided: " + paramRequest.d);
    }
    try
    {
      Resources localResources = paramContext.getPackageManager().getResourcesForApplication(str);
      return localResources;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new FileNotFoundException("Unable to obtain resources for package: " + paramRequest.d);
    }
  }
  
  static Downloader a(Context paramContext)
  {
    i = 1;
    try
    {
      Class.forName("com.squareup.okhttp.OkUrlFactory");
      int j = i;
      return new UrlConnectionDownloader(paramContext);
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        try
        {
          Class.forName("com.squareup.okhttp.OkHttpClient");
          if (i == j) {
            continue;
          }
          throw new RuntimeException("Picasso detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Picasso, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          i = 0;
          continue;
          if (i == 0) {
            break label53;
          }
          return Utils.OkHttpLoaderCreator.a(paramContext);
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        j = 0;
      }
    }
  }
  
  static <T> T a(Context paramContext, String paramString)
  {
    return paramContext.getSystemService(paramString);
  }
  
  static String a(BitmapHunter paramBitmapHunter)
  {
    return a(paramBitmapHunter, "");
  }
  
  static String a(BitmapHunter paramBitmapHunter, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    Action localAction = paramBitmapHunter.i();
    if (localAction != null) {
      localStringBuilder.append(localAction.b.a());
    }
    List localList = paramBitmapHunter.k();
    if (localList != null)
    {
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        if ((j > 0) || (localAction != null)) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(((Action)localList.get(j)).b.a());
      }
    }
    return localStringBuilder.toString();
  }
  
  static String a(Request paramRequest)
  {
    String str = a(paramRequest, a);
    a.setLength(0);
    return str;
  }
  
  static String a(Request paramRequest, StringBuilder paramStringBuilder)
  {
    if (paramRequest.f != null)
    {
      paramStringBuilder.ensureCapacity(50 + paramRequest.f.length());
      paramStringBuilder.append(paramRequest.f);
      paramStringBuilder.append('\n');
      if (paramRequest.l != 0.0F)
      {
        paramStringBuilder.append("rotation:").append(paramRequest.l);
        if (paramRequest.o) {
          paramStringBuilder.append('@').append(paramRequest.m).append('x').append(paramRequest.n);
        }
        paramStringBuilder.append('\n');
      }
      if (paramRequest.d())
      {
        paramStringBuilder.append("resize:").append(paramRequest.h).append('x').append(paramRequest.i);
        paramStringBuilder.append('\n');
      }
      if (!paramRequest.j) {
        break label277;
      }
      paramStringBuilder.append("centerCrop\n");
    }
    for (;;)
    {
      if (paramRequest.g == null) {
        break label295;
      }
      int i = paramRequest.g.size();
      for (int j = 0; j < i; j++)
      {
        paramStringBuilder.append(((Transformation)paramRequest.g.get(j)).a());
        paramStringBuilder.append('\n');
      }
      if (paramRequest.d != null)
      {
        String str = paramRequest.d.toString();
        paramStringBuilder.ensureCapacity(50 + str.length());
        paramStringBuilder.append(str);
        break;
      }
      paramStringBuilder.ensureCapacity(50);
      paramStringBuilder.append(paramRequest.e);
      break;
      label277:
      if (paramRequest.k) {
        paramStringBuilder.append("centerInside\n");
      }
    }
    label295:
    return paramStringBuilder.toString();
  }
  
  static void a()
  {
    if (!b()) {
      throw new IllegalStateException("Method call should happen from the main thread.");
    }
  }
  
  static void a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return;
    }
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  static void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, "");
  }
  
  static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
  }
  
  static void a(Throwable paramThrowable)
  {
    b(paramThrowable);
  }
  
  static boolean a(String paramString)
  {
    int i = 1;
    if (paramString == null) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = paramString.split(" ", 2);
      if ("CACHE".equals(arrayOfString[0])) {
        return i;
      }
    } while (arrayOfString.length == i);
    try
    {
      if ("CONDITIONAL_CACHE".equals(arrayOfString[0]))
      {
        int k = Integer.parseInt(arrayOfString[1]);
        if (k != 304) {}
      }
      for (;;)
      {
        return i;
        int j = 0;
      }
      return false;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  static File b(Context paramContext)
  {
    File localFile = new File(paramContext.getApplicationContext().getCacheDir(), "picasso-cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  private static <T extends Throwable> void b(Throwable paramThrowable)
  {
    throw paramThrowable;
  }
  
  static boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  static boolean b(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  static byte[] b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  static int c(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)a(paramContext, "activity");
    int i;
    int j;
    if ((0x100000 & paramContext.getApplicationInfo().flags) != 0)
    {
      i = 1;
      j = localActivityManager.getMemoryClass();
      if ((i == 0) || (Build.VERSION.SDK_INT < 11)) {
        break label65;
      }
    }
    label65:
    for (int k = Utils.ActivityManagerHoneycomb.a(localActivityManager);; k = j)
    {
      return k * 1048576 / 7;
      i = 0;
      break;
    }
  }
  
  static boolean c(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[12];
    int i = paramInputStream.read(arrayOfByte, 0, 12);
    boolean bool1 = false;
    if (i == 12)
    {
      boolean bool2 = "RIFF".equals(new String(arrayOfByte, 0, 4, "US-ASCII"));
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = "WEBP".equals(new String(arrayOfByte, 8, 4, "US-ASCII"));
        bool1 = false;
        if (bool3) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  static boolean d(Context paramContext)
  {
    int i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
    boolean bool = false;
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Utils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */