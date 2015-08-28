package com.boohee.food.util;

import java.io.File;

final class SDcard$1
  implements Runnable
{
  SDcard$1(File[] paramArrayOfFile) {}
  
  public void run()
  {
    try
    {
      File[] arrayOfFile = this.a;
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        arrayOfFile[j].delete();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.SDcard.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */