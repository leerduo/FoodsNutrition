package com.boohee.pictures;

import android.content.Context;
import android.os.AsyncTask;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;

class QiniuUploader$UploadTask
  extends AsyncTask<String, String, String>
{
  private Context context;
  private List<Picture> pics;
  
  public QiniuUploader$UploadTask(Context paramContext, List<Picture> paramList)
  {
    this.pics = paramList;
    this.context = paramContext;
  }
  
  protected String doInBackground(String... paramVarArgs)
  {
    QiniuUploader.access$200().clear();
    QiniuUploader.access$400().clear();
    QiniuUploader.access$500().clear();
    QiniuUploader.access$200().addAll(this.pics);
    QiniuUploader.access$102(false);
    Iterator localIterator = QiniuUploader.access$200().iterator();
    while (localIterator.hasNext())
    {
      Picture localPicture = (Picture)localIterator.next();
      QiniuUploader.access$600(this.context, PictureUpload.MAX_PIC_SIZE, localPicture);
    }
    if (ImageGridViewActivity.instance != null) {
      ImageGridViewActivity.instance.finish();
    }
    return "";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.QiniuUploader.UploadTask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */