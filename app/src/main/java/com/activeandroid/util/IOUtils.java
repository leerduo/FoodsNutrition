package com.activeandroid.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.b("Couldn't close closeable.", localIOException);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.IOUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */