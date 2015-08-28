package cn.sharesdk.framework.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.sharesdk.framework.network.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class R
{
  private static String a;
  private static float b;
  
  public static void clearCache(Context paramContext)
  {
    deleteFileAndFolder(new File(getCachePath(paramContext, null)));
  }
  
  public static String contentUriToPath(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    if (new File(paramUri.getPath()).exists()) {
      return paramUri.getPath();
    }
    try
    {
      Cursor localCursor = paramContext.getContentResolver().query(paramUri, null, null, null, null);
      if (localCursor != null) {
        if (localCursor.moveToFirst())
        {
          str = localCursor.getString(localCursor.getColumnIndex("_data"));
          localCursor.close();
          return str;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.b(localThrowable);
        String str = null;
        continue;
        str = null;
        continue;
        str = null;
      }
    }
  }
  
  public static void copyFile(FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream)
  {
    byte[] arrayOfByte = new byte[65536];
    for (int i = paramFileInputStream.read(arrayOfByte); i > 0; i = paramFileInputStream.read(arrayOfByte)) {
      paramFileOutputStream.write(arrayOfByte, 0, i);
    }
    paramFileInputStream.close();
    paramFileOutputStream.close();
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (!new File(paramString1).exists()) {
      return false;
    }
    try
    {
      copyFile(new FileInputStream(paramString1), new FileOutputStream(paramString2));
      return true;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static int[] covertTimeInYears(long paramLong)
  {
    long l1 = System.currentTimeMillis() - paramLong;
    if (l1 <= 0L) {
      return new int[] { 0, 0 };
    }
    long l2 = l1 / 1000L;
    if (l2 < 60L)
    {
      int[] arrayOfInt6 = new int[2];
      arrayOfInt6[0] = ((int)l2);
      arrayOfInt6[1] = 0;
      return arrayOfInt6;
    }
    long l3 = l2 / 60L;
    if (l3 < 60L)
    {
      int[] arrayOfInt5 = new int[2];
      arrayOfInt5[0] = ((int)l3);
      arrayOfInt5[1] = 1;
      return arrayOfInt5;
    }
    long l4 = l3 / 60L;
    if (l4 < 24L)
    {
      int[] arrayOfInt4 = new int[2];
      arrayOfInt4[0] = ((int)l4);
      arrayOfInt4[1] = 2;
      return arrayOfInt4;
    }
    long l5 = l4 / 24L;
    if (l5 < 30L)
    {
      int[] arrayOfInt3 = new int[2];
      arrayOfInt3[0] = ((int)l5);
      arrayOfInt3[1] = 3;
      return arrayOfInt3;
    }
    long l6 = l5 / 30L;
    if (l6 < 12L)
    {
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = ((int)l6);
      arrayOfInt2[1] = 4;
      return arrayOfInt2;
    }
    long l7 = l6 / 12L;
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = ((int)l7);
    arrayOfInt1[1] = 5;
    return arrayOfInt1;
  }
  
  public static long dateStrToLong(String paramString)
  {
    return new SimpleDateFormat("yyyy-MM-dd").parse(paramString, new ParsePosition(0)).getTime();
  }
  
  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      String[] arrayOfString1 = paramString.split("&");
      int i = arrayOfString1.length;
      int j = 0;
      if (j < i)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        if ((arrayOfString2.length < 2) || (arrayOfString2[1] == null)) {
          localBundle.putString(URLDecoder.decode(arrayOfString2[0]), "");
        }
        for (;;)
        {
          j++;
          break;
          localBundle.putString(URLDecoder.decode(arrayOfString2[0]), URLDecoder.decode(arrayOfString2[1]));
        }
      }
    }
    return localBundle;
  }
  
  public static void deleteFileAndFolder(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    String[] arrayOfString = paramFile.list();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      paramFile.delete();
      return;
    }
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      File localFile = new File(paramFile, arrayOfString[j]);
      if (localFile.isDirectory()) {
        deleteFileAndFolder(localFile);
      }
      for (;;)
      {
        j++;
        break;
        localFile.delete();
      }
    }
    paramFile.delete();
  }
  
  public static int dipToPx(Context paramContext, int paramInt)
  {
    if (b <= 0.0F) {
      b = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(0.5F + paramInt * b);
  }
  
  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject == null) {
        localObject = "";
      }
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(a.d(str) + "=" + a.d(String.valueOf(localObject)));
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String encodeUrl(ArrayList<f<String>> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (i > 0) {
        localStringBuilder.append('&');
      }
      String str1 = localf.a;
      String str2 = (String)localf.b;
      if (str1 != null)
      {
        if (str2 == null) {
          str2 = "";
        }
        localStringBuilder.append(a.d(str1) + "=" + a.d(str2));
        i++;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static int getBitmapRes(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    try
    {
      int j = getResId(Class.forName(str + ".R$drawable"), paramString);
      i = j;
      if (i <= 0) {
        i = paramContext.getResources().getIdentifier(paramString.toLowerCase(), "drawable", str);
      }
      if (i <= 0) {
        System.err.println("failed to parse drawable resource \"" + paramString + "\"");
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.c(localThrowable);
        int i = 0;
      }
    }
  }
  
  public static String getCachePath(Context paramContext, String paramString)
  {
    String str1 = a;
    if (TextUtils.isEmpty(str1)) {
      str1 = "ShareSDK";
    }
    String str2 = paramContext.getFilesDir().getAbsolutePath() + "/" + str1 + "/cache/";
    b localb = b.a(paramContext);
    if (localb.w()) {}
    for (String str3 = localb.x() + "/" + str1 + "/" + localb.q() + "/cache/";; str3 = str2)
    {
      if (!TextUtils.isEmpty(paramString)) {
        str3 = str3 + paramString + "/";
      }
      File localFile = new File(str3);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str3;
    }
  }
  
  public static int getColorRes(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    try
    {
      int j = getResId(Class.forName(str + ".R$color"), paramString);
      i = j;
      if (i <= 0) {
        i = paramContext.getResources().getIdentifier(paramString, "color", str);
      }
      if (i <= 0) {
        System.err.println("failed to parse color resource \"" + paramString + "\"");
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.c(localThrowable);
        int i = 0;
      }
    }
  }
  
  public static int getIdRes(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    try
    {
      int j = getResId(Class.forName(str + ".R$id"), paramString);
      i = j;
      if (i <= 0) {
        i = paramContext.getResources().getIdentifier(paramString, "id", str);
      }
      if (i <= 0) {
        System.err.println("failed to parse id resource \"" + paramString + "\"");
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.c(localThrowable);
        int i = 0;
      }
    }
  }
  
  public static String getImageCachePath(Context paramContext)
  {
    return getCachePath(paramContext, "images");
  }
  
  public static int getLayoutRes(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    try
    {
      int j = getResId(Class.forName(str + ".R$layout"), paramString);
      i = j;
      if (i <= 0) {
        i = paramContext.getResources().getIdentifier(paramString, "layout", str);
      }
      if (i <= 0) {
        System.err.println("failed to parse layout resource \"" + paramString + "\"");
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.c(localThrowable);
        int i = 0;
      }
    }
  }
  
  public static int getRawRes(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    try
    {
      int j = getResId(Class.forName(str + ".R$raw"), paramString);
      i = j;
      if (i <= 0) {
        i = paramContext.getResources().getIdentifier(paramString, "raw", str);
      }
      if (i <= 0) {
        System.err.println("failed to parse raw resource \"" + paramString + "\"");
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.c(localThrowable);
        int i = 0;
      }
    }
  }
  
  public static int getResId(Class<?> paramClass, String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        Field localField2 = paramClass.getField(paramString);
        localField2.setAccessible(true);
        int k = ((Integer)localField2.get(null)).intValue();
        i = k;
        if (i <= 0) {
          e.c("resource " + paramClass.getName() + "." + paramString + " not found!", new Object[0]);
        }
        return i;
      }
      catch (Throwable localThrowable1)
      {
        String str = paramString.toLowerCase();
        try
        {
          Field localField1 = paramClass.getField(str);
          localField1.setAccessible(true);
          int j = ((Integer)localField1.get(null)).intValue();
          i = j;
        }
        catch (Throwable localThrowable2)
        {
          i = 0;
        }
        continue;
      }
      int i = 0;
    }
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return getScreenSize(paramContext)[1];
  }
  
  public static int[] getScreenSize(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT < 13)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplay.getMetrics(localDisplayMetrics);
      int[] arrayOfInt1 = new int[2];
      arrayOfInt1[0] = localDisplayMetrics.widthPixels;
      arrayOfInt1[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt1;
    }
    try
    {
      Point localPoint = new Point();
      Method localMethod = localDisplay.getClass().getMethod("getRealSize", new Class[] { Point.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localDisplay, new Object[] { localPoint });
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = localPoint.x;
      arrayOfInt2[1] = localPoint.y;
      return arrayOfInt2;
    }
    catch (Throwable localThrowable)
    {
      e.b(localThrowable);
    }
    return // INTERNAL ERROR //

/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.R
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */