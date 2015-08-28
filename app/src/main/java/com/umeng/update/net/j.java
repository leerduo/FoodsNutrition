package com.umeng.update.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;
import u.upd.a;
import u.upd.b;
import u.upd.f.a;
import u.upd.n;

public class j
{
  public static boolean a = false;
  private static final String b = j.class.getName();
  private static final long c = 52428800L;
  private static final long d = 10485760L;
  private static final long e = 1800000L;
  private static final Map<ImageView, String> f = Collections.synchronizedMap(new WeakHashMap());
  private static Thread g;
  
  private static long a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      l1 = 0L;
      return l1;
    }
    Stack localStack = new Stack();
    localStack.clear();
    localStack.push(paramFile);
    long l1 = 0L;
    label42:
    File[] arrayOfFile;
    int i;
    long l2;
    if (!localStack.isEmpty())
    {
      arrayOfFile = ((File)localStack.pop()).listFiles();
      i = arrayOfFile.length;
      l2 = l1;
    }
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        l1 = l2;
        break label42;
        break;
      }
      File localFile = arrayOfFile[j];
      if (!localFile.isDirectory()) {
        l2 += localFile.length();
      }
    }
  }
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF = new RectF(localRect);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramBitmap.getWidth() / 6, paramBitmap.getHeight() / 6, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      b.d(b, "Cant`t create round corner bitmap. [OutOfMemoryError] ");
    }
    return null;
  }
  
  public static File a(String paramString, Context paramContext, boolean[] paramArrayOfBoolean)
  {
    if (a.a())
    {
      File localFile1 = new File(Environment.getExternalStorageDirectory().getCanonicalPath() + "/download/.um" + paramString);
      localFile1.mkdirs();
      if (localFile1.exists())
      {
        paramArrayOfBoolean[0] = true;
        return localFile1;
      }
    }
    String str1 = paramContext.getCacheDir().getAbsolutePath();
    new File(str1).mkdir();
    a(str1, 505, -1, -1);
    String str2 = str1 + "/umdownload";
    new File(str2).mkdir();
    a(str2, 505, -1, -1);
    File localFile2 = new File(str2);
    paramArrayOfBoolean[0] = false;
    return localFile2;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (n.d(paramString)) {
      return null;
    }
    try
    {
      String str1 = b(paramString) + ".tmp";
      Object localObject;
      long l;
      if (a.a())
      {
        localObject = Environment.getExternalStorageDirectory().getCanonicalPath();
        l = 52428800L;
      }
      for (;;)
      {
        File localFile2 = new File(localObject + "/download/.um");
        a(localFile2, l, 1800000L);
        localFile1 = new File(localFile2, str1);
        try
        {
          localFile1.createNewFile();
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile1);
          InputStream localInputStream = (InputStream)new URL(paramString).openConnection().getContent();
          byte[] arrayOfByte = new byte[4096];
          for (;;)
          {
            int i = localInputStream.read(arrayOfByte);
            if (i == -1)
            {
              localFileOutputStream.flush();
              localInputStream.close();
              localFileOutputStream.close();
              File localFile3 = new File(localFile1.getParent(), localFile1.getName().replace(".tmp", ""));
              localFile1.renameTo(localFile3);
              b.a(b, "download img[" + paramString + "]  to " + localFile3.getCanonicalPath());
              String str3 = localFile3.getCanonicalPath();
              return str3;
              String str2 = paramContext.getCacheDir().getCanonicalPath();
              localObject = str2;
              l = 10485760L;
              break;
            }
            localFileOutputStream.write(arrayOfByte, 0, i);
          }
          b.a(b, localException1.getStackTrace().toString() + "\t url:\t" + n.a + paramString);
        }
        catch (Exception localException1) {}
      }
      if ((localFile1 != null) && (localFile1.exists())) {
        localFile1.deleteOnExit();
      }
      return null;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        File localFile1 = null;
      }
    }
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramImageView, paramString, paramBoolean, null, null, false);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, boolean paramBoolean, j.a parama)
  {
    a(paramContext, paramImageView, paramString, paramBoolean, parama, null, false);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, boolean paramBoolean, j.a parama, Animation paramAnimation)
  {
    a(paramContext, paramImageView, paramString, paramBoolean, parama, null, false);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, boolean paramBoolean1, j.a parama, Animation paramAnimation, boolean paramBoolean2)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      f.put(paramImageView, paramString);
      try
      {
        File localFile = b(paramContext, paramString);
        if ((localFile == null) || (!localFile.exists()) || (a)) {
          break;
        }
        if (parama != null) {
          parama.a(j.b.a);
        }
        Drawable localDrawable = c(localFile.getAbsolutePath());
        if (localDrawable == null) {
          localFile.delete();
        }
        b(paramContext, paramImageView, localDrawable, paramBoolean1, parama, paramAnimation, paramBoolean2, paramString);
        return;
      }
      catch (Exception localException)
      {
        b.b(b, "", localException);
      }
    } while (parama == null);
    parama.a(f.a.b);
    return;
    new j.c(paramContext, paramImageView, paramString, j.b.b, null, paramBoolean1, parama, paramAnimation, paramBoolean2).execute(new Object[0]);
  }
  
  public static void a(File paramFile, long paramLong1, long paramLong2)
  {
    if (paramFile.exists())
    {
      if (a(paramFile.getCanonicalFile()) > paramLong1)
      {
        if (g == null) {
          g = new Thread(new j.1(paramFile, paramLong2));
        }
        synchronized (g)
        {
          g.start();
          return;
        }
      }
    }
    else if (!paramFile.mkdirs()) {
      b.b(b, "Failed to create directory" + paramFile.getAbsolutePath() + ". Check permission. Make sure WRITE_EXTERNAL_STORAGE is added in your Manifest.xml");
    }
  }
  
  private static boolean a(ImageView paramImageView, String paramString)
  {
    String str = (String)f.get(paramImageView);
    return (str != null) && (!str.equals(paramString));
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    int i = 432;
    if ((paramInt & 0x1) != 0) {
      i = 436;
    }
    if ((paramInt & 0x2) != 0) {
      i |= 2;
    }
    return a(paramString, i, -1, -1);
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Class localClass = Class.forName("android.os.FileUtils");
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Integer.TYPE;
      arrayOfClass[2] = Integer.TYPE;
      arrayOfClass[3] = Integer.TYPE;
      Method localMethod = localClass.getMethod("setPermissions", arrayOfClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = Integer.valueOf(-1);
      arrayOfObject[3] = Integer.valueOf(-1);
      localMethod.invoke(null, arrayOfObject);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      b.b(b, "error when set permissions:", localClassNotFoundException);
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        b.b(b, "error when set permissions:", localNoSuchMethodException);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        b.b(b, "error when set permissions:", localIllegalArgumentException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        b.b(b, "error when set permissions:", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        b.b(b, "error when set permissions:", localInvocationTargetException);
      }
    }
  }
  
  protected static File b(Context paramContext, String paramString)
  {
    String str1 = b(paramString);
    if (a.a()) {}
    for (String str2 = Environment.getExternalStorageDirectory().getCanonicalPath();; str2 = paramContext.getCacheDir().getCanonicalPath())
    {
      File localFile = new File(new File(str2 + "/download/.um"), str1);
      if (!localFile.exists()) {
        break;
      }
      return localFile;
    }
    return null;
  }
  
  private static String b(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    String str = "";
    if (i >= 0) {
      str = paramString.substring(i);
    }
    return n.a(paramString) + str;
  }
  
  private static void b(Context paramContext, ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, j.a parama, Animation paramAnimation, boolean paramBoolean2, String paramString)
  {
    if ((paramBoolean2) && (paramDrawable != null)) {}
    for (;;)
    {
      try
      {
        paramDrawable = new BitmapDrawable(a(((BitmapDrawable)paramDrawable).getBitmap()));
      }
      catch (Exception localException)
      {
        b.b(b, "bind failed", localException);
        if (parama == null) {
          continue;
        }
        parama.a(f.a.b);
        continue;
      }
      finally {}
      if (parama != null) {
        parama.a(f.a.b);
      }
      b.d(b, "bind drawable failed. drawable [" + paramDrawable + "]  imageView[+" + paramImageView + "+]");
      return;
      if (a(paramImageView, paramString))
      {
        if (parama != null) {
          parama.a(f.a.b);
        }
      }
      else
      {
        if (paramBoolean1) {
          paramImageView.setBackgroundDrawable(paramDrawable);
        }
        for (;;)
        {
          if (paramAnimation != null) {
            paramImageView.startAnimation(paramAnimation);
          }
          if (parama == null) {
            break;
          }
          parama.a(f.a.a);
          break;
          paramImageView.setImageDrawable(paramDrawable);
        }
        if (paramDrawable != null) {
          if (paramImageView != null) {}
        }
      }
    }
  }
  
  private static void b(File paramFile, long paramLong)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.canWrite()) || (!paramFile.isDirectory())) {}
    for (;;)
    {
      return;
      for (File localFile : paramFile.listFiles()) {
        if ((!localFile.isDirectory()) && (new Date().getTime() - localFile.lastModified() > paramLong)) {
          localFile.delete();
        }
      }
    }
  }
  
  private static Drawable c(String paramString)
  {
    try
    {
      Drawable localDrawable = Drawable.createFromPath(paramString);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      b.d(b, "Resutil fetchImage OutOfMemoryError:" + localOutOfMemoryError.toString());
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */