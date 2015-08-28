package cn.sharesdk.onekeyshare;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import cn.sharesdk.framework.utils.BitmapHelper;
import java.util.ArrayList;
import java.util.Iterator;

class EditPageFakeActivity$1
  extends AsyncTask<Object, Void, EditPageFakeActivity.ImageListResultsCallback>
{
  EditPageFakeActivity$1(EditPageFakeActivity paramEditPageFakeActivity) {}
  
  protected EditPageFakeActivity.ImageListResultsCallback doInBackground(Object... paramVarArgs)
  {
    Iterator localIterator = EditPageFakeActivity.access$000(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      EditPageFakeActivity.ImageInfo localImageInfo = (EditPageFakeActivity.ImageInfo)localIterator.next();
      if (localImageInfo.bitmap == null) {
        try
        {
          String str = localImageInfo.srcValue;
          if ((str.startsWith("http://")) || (str.startsWith("https://"))) {
            str = BitmapHelper.downloadBitmap(EditPageFakeActivity.access$100(this.this$0), str);
          }
          Bitmap localBitmap = BitmapHelper.getBitmap(str);
          if (localBitmap != null) {
            localImageInfo.bitmap = localBitmap;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    return (EditPageFakeActivity.ImageListResultsCallback)paramVarArgs[0];
  }
  
  protected void onPostExecute(EditPageFakeActivity.ImageListResultsCallback paramImageListResultsCallback)
  {
    paramImageListResultsCallback.onFinish(EditPageFakeActivity.access$000(this.this$0));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.EditPageFakeActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */