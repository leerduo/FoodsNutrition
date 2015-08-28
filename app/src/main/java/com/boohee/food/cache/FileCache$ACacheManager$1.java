package com.boohee.food.cache;

import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class FileCache$ACacheManager$1
  implements Runnable
{
  FileCache$ACacheManager$1(FileCache.ACacheManager paramACacheManager) {}
  
  public void run()
  {
    int i = 0;
    File[] arrayOfFile = this.a.a.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int k = 0;
      int m = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        m = (int)(m + FileCache.ACacheManager.b(this.a, localFile));
        k++;
        FileCache.ACacheManager.a(this.a).put(localFile, Long.valueOf(localFile.lastModified()));
        i++;
      }
      FileCache.ACacheManager.b(this.a).set(m);
      FileCache.ACacheManager.c(this.a).set(k);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.cache.FileCache.ACacheManager.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */