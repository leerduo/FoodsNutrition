package com.boohee.food.util;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public class SDcard
{
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1L;
      try
      {
        File localFile = new File(paramString);
        if ((localFile.exists()) && (localFile.isFile()))
        {
          long l = localFile.length();
          return l;
        }
      }
      catch (Exception localException) {}
    }
    return -1L;
  }
  
  public static File a()
  {
    if (e())
    {
      File localFile = new File(Environment.getExternalStorageDirectory(), "boohee/food");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile;
    }
    return null;
  }
  
  public static File b()
  {
    File localFile1 = a();
    if (localFile1 != null)
    {
      File localFile2 = new File(localFile1, "images");
      if (!localFile2.exists()) {
        localFile2.mkdirs();
      }
      return localFile2;
    }
    return null;
  }
  
  public static File c()
  {
    File localFile1 = b();
    Object localObject = null;
    File localFile2;
    if (localFile1 != null)
    {
      localFile2 = new File(localFile1, System.currentTimeMillis() + ".jpg");
      if (localFile2.exists()) {}
    }
    try
    {
      localFile2.createNewFile();
      localObject = localFile2;
      return localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  public static void d()
  {
    File[] arrayOfFile = b().listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
      new Thread(new SDcard.1(arrayOfFile)).start();
    }
  }
  
  public static boolean e()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.SDcard
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */