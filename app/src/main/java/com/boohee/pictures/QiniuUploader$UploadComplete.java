package com.boohee.pictures;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import java.util.concurrent.BlockingQueue;
import org.json.JSONObject;

class QiniuUploader$UploadComplete
  implements UpCompletionHandler
{
  private final Picture mPicture;
  
  public QiniuUploader$UploadComplete(Picture paramPicture)
  {
    this.mPicture = paramPicture;
  }
  
  public void complete(String paramString, ResponseInfo paramResponseInfo, JSONObject paramJSONObject)
  {
    QiniuUploader.access$200().remove(this.mPicture);
    if (paramResponseInfo.isOK()) {
      QiniuUploader.access$300(paramJSONObject, this.mPicture);
    }
    do
    {
      return;
      if (paramResponseInfo.isNetworkBroken())
      {
        QiniuUploader.access$400().add(this.mPicture);
        BooheeUploader.uploadToBoohee(this.mPicture, new QiniuUploader.BooheeUploadHandler(this.mPicture));
        return;
      }
    } while (!paramResponseInfo.isCancelled());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.QiniuUploader.UploadComplete
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */