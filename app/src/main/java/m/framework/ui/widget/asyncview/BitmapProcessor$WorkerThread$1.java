package m.framework.ui.widget.asyncview;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;
import java.util.WeakHashMap;
import m.framework.network.ResponseCallback;
import m.framework.utils.Utils;

class BitmapProcessor$WorkerThread$1
  implements ResponseCallback
{
  BitmapProcessor$WorkerThread$1(BitmapProcessor.WorkerThread paramWorkerThread, File paramFile, BitmapProcessor.ImageReq paramImageReq) {}
  
  public void a(InputStream paramInputStream)
  {
    Bitmap localBitmap = Utils.a(new BitmapProcessor.PatchInputStream(paramInputStream));
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      BitmapProcessor.WorkerThread.a(this.a, null);
      return;
    }
    BitmapProcessor.WorkerThread.a(this.a, localBitmap, this.b);
    if (localBitmap != null)
    {
      BitmapProcessor.d(BitmapProcessor.WorkerThread.c(this.a)).put(BitmapProcessor.ImageReq.a(this.c), localBitmap);
      BitmapProcessor.ImageReq.a(this.c, localBitmap);
    }
    BitmapProcessor.WorkerThread.a(this.a, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.BitmapProcessor.WorkerThread.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */