package com.boohee.pictures;

import com.qiniu.android.storage.UpCancellationSignal;

final class QiniuUploader$3
  implements UpCancellationSignal
{
  public boolean isCancelled()
  {
    return QiniuUploader.access$100();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.QiniuUploader.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */