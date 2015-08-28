package com.boohee.pictures;

import com.qiniu.android.storage.UpProgressHandler;

final class QiniuUploader$2
  implements UpProgressHandler
{
  public void progress(String paramString, double paramDouble)
  {
    QiniuUploader.access$000().onProgress((int)(100.0D * paramDouble));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.QiniuUploader.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */