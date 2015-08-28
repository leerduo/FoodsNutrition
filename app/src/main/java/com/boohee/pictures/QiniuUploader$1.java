package com.boohee.pictures;

import android.content.Context;
import android.os.AsyncTask;
import java.util.List;

final class QiniuUploader$1
  extends AsyncTask<String, String, String>
{
  QiniuUploader$1(List paramList1, Context paramContext, List paramList2) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    this.val$pics.clear();
    this.val$pics.addAll(PictureHelper.parsePictureListFromPathList(this.val$context, this.val$pathList));
    return null;
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    if (this.val$pics.size() == 0)
    {
      QiniuUploader.access$000().onFailed("无法解析Path指向的图片");
      return;
    }
    new QiniuUploader.UploadTask(this.val$context, this.val$pics).execute(new String[0]);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    QiniuUploader.access$000().onStart();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.QiniuUploader.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */