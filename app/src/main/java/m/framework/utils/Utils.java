package m.framework.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Locale;

public class Utils
{
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static Bitmap a(File paramFile, int paramInt)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    Bitmap localBitmap = a(localFileInputStream, paramInt);
    localFileInputStream.close();
    return localBitmap;
  }
  
  public static Bitmap a(InputStream paramInputStream)
  {
    return a(paramInputStream, 1);
  }
  
  private static Bitmap a(InputStream paramInputStream, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    return a(new File(paramString), paramInt);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramContext.getFilesDir().getAbsolutePath() + "/mFramework/cache/";
    DeviceHelper localDeviceHelper = new DeviceHelper(paramContext);
    if (localDeviceHelper.b()) {
      str = localDeviceHelper.c() + "/mFramework/" + localDeviceHelper.a() + "/cache/";
    }
    if (!TextUtils.isEmpty(paramString)) {
      str = str + paramString + "/";
    }
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return str;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() <= 0) || ("null".equals(paramString.trim().toLowerCase(Locale.getDefault())));
  }
  
  public static Bitmap b(String paramString)
  {
    return a(paramString, 1);
  }
  
  public static String c(String paramString)
  {
    Object localObject1 = URLConnection.getFileNameMap().getContentTypeFor(paramString);
    String str1;
    if ((localObject1 == null) || (((String)localObject1).length() <= 0))
    {
      str1 = paramString.toLowerCase(Locale.getDefault());
      if ((str1.endsWith("jpg")) || (str1.endsWith("jepg"))) {
        localObject1 = "image/jpeg";
      }
    }
    else
    {
      return localObject1;
    }
    if (str1.endsWith("png")) {
      return "image/png";
    }
    if (str1.endsWith("gif")) {
      return "image/gif";
    }
    for (;;)
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramString);
        String str2 = URLConnection.guessContentTypeFromStream(localFileInputStream);
        localObject2 = str2;
        Throwable localThrowable2;
        localThrowable2.printStackTrace();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localFileInputStream.close();
          localObject1 = localObject2;
          if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
            break;
          }
          return "application/octet-stream";
        }
        catch (Throwable localThrowable3)
        {
          Object localObject2;
          break label125;
        }
        localThrowable1 = localThrowable1;
        localObject2 = localObject1;
        localThrowable2 = localThrowable1;
      }
      label125:
      localObject1 = localObject2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.utils.Utils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */