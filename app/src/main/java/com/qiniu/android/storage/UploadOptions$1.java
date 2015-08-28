package com.qiniu.android.storage;

import android.util.Log;

class UploadOptions$1
  implements UpProgressHandler
{
  UploadOptions$1(UploadOptions paramUploadOptions) {}
  
  public void progress(String paramString, double paramDouble)
  {
    Log.d("qiniu up progress", "" + paramDouble);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.UploadOptions.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */