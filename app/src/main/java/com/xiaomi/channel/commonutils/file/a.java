package com.xiaomi.channel.commonutils.file;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

public class a
{
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("removed");
  }
  
  public static boolean b()
  {
    return !Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean c()
  {
    return e() <= 102400L;
  }
  
  public static boolean d()
  {
    return (!b()) && (!c()) && (!a());
  }
  
  public static long e()
  {
    if (b()) {}
    File localFile;
    do
    {
      return 0L;
      localFile = Environment.getExternalStorageDirectory();
    } while ((localFile == null) || (TextUtils.isEmpty(localFile.getPath())));
    StatFs localStatFs = new StatFs(localFile.getPath());
    return localStatFs.getBlockSize() * (localStatFs.getAvailableBlocks() - 4L);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.file.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */