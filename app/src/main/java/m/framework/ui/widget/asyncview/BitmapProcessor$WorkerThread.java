package m.framework.ui.widget.asyncview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Vector;
import java.util.WeakHashMap;
import m.framework.network.NetworkHelper;
import m.framework.utils.Data;
import m.framework.utils.Utils;

class BitmapProcessor$WorkerThread
  extends Thread
{
  private BitmapProcessor a;
  private long b;
  private boolean c;
  private BitmapProcessor.ImageReq d;
  
  public BitmapProcessor$WorkerThread(BitmapProcessor paramBitmapProcessor)
  {
    this.a = paramBitmapProcessor;
    this.b = System.currentTimeMillis();
  }
  
  private void a()
  {
    int i = BitmapProcessor.c(this.a).size();
    if (i > 0) {}
    for (BitmapProcessor.ImageReq localImageReq = (BitmapProcessor.ImageReq)BitmapProcessor.c(this.a).remove(i - 1);; localImageReq = null)
    {
      if (localImageReq != null)
      {
        Bitmap localBitmap = (Bitmap)BitmapProcessor.d(this.a).get(BitmapProcessor.ImageReq.a(localImageReq));
        if (localBitmap != null)
        {
          this.d = localImageReq;
          BitmapProcessor.ImageReq.a(this.d, this);
          BitmapProcessor.ImageReq.a(localImageReq, localBitmap);
          this.b = System.currentTimeMillis();
          return;
        }
        if (new File(BitmapProcessor.e(this.a), Data.a(BitmapProcessor.ImageReq.a(localImageReq))).exists())
        {
          a(localImageReq);
          this.b = System.currentTimeMillis();
          return;
        }
        if (BitmapProcessor.f(this.a).size() > 40) {}
        for (;;)
        {
          if (BitmapProcessor.c(this.a).size() <= 0)
          {
            BitmapProcessor.f(this.a).remove(0);
            BitmapProcessor.f(this.a).add(localImageReq);
            break;
          }
          BitmapProcessor.c(this.a).remove(0);
        }
      }
      this.b = System.currentTimeMillis();
      Thread.sleep(30L);
      return;
    }
  }
  
  private void a(Bitmap paramBitmap, File paramFile)
  {
    try
    {
      if (paramFile.exists()) {
        paramFile.delete();
      }
      if (!paramFile.getParentFile().exists()) {
        paramFile.getParentFile().mkdirs();
      }
      paramFile.createNewFile();
      Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
      String str = Utils.c(paramFile.getAbsolutePath());
      if ((str != null) && ((str.endsWith("png")) || (str.endsWith("gif")))) {
        localCompressFormat = Bitmap.CompressFormat.PNG;
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
      paramBitmap.compress(localCompressFormat, 100, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!paramFile.exists()) {}
      paramFile.delete();
    }
  }
  
  private void a(BitmapProcessor.ImageReq paramImageReq)
  {
    this.d = paramImageReq;
    BitmapProcessor.ImageReq.a(this.d, this);
    File localFile = new File(BitmapProcessor.e(this.a), Data.a(BitmapProcessor.ImageReq.a(paramImageReq)));
    Bitmap localBitmap;
    if (localFile.exists())
    {
      localBitmap = Utils.b(localFile.getAbsolutePath());
      if (localBitmap != null)
      {
        BitmapProcessor.d(this.a).put(BitmapProcessor.ImageReq.a(paramImageReq), localBitmap);
        BitmapProcessor.ImageReq.a(paramImageReq, localBitmap);
      }
      this.d = null;
    }
    for (;;)
    {
      if (localBitmap != null)
      {
        BitmapProcessor.d(this.a).put(BitmapProcessor.ImageReq.a(paramImageReq), localBitmap);
        BitmapProcessor.ImageReq.a(paramImageReq, localBitmap);
      }
      this.d = null;
      return;
      new NetworkHelper().a(BitmapProcessor.ImageReq.a(paramImageReq), new BitmapProcessor.WorkerThread.1(this, localFile, paramImageReq));
      localBitmap = null;
    }
  }
  
  private void b()
  {
    int i = BitmapProcessor.f(this.a).size();
    BitmapProcessor.ImageReq localImageReq1 = null;
    if (i > 0) {
      localImageReq1 = (BitmapProcessor.ImageReq)BitmapProcessor.f(this.a).remove(0);
    }
    int j;
    if (localImageReq1 == null)
    {
      j = BitmapProcessor.c(this.a).size();
      if (j <= 0) {}
    }
    for (BitmapProcessor.ImageReq localImageReq2 = (BitmapProcessor.ImageReq)BitmapProcessor.c(this.a).remove(j - 1);; localImageReq2 = localImageReq1)
    {
      if (localImageReq2 != null)
      {
        Bitmap localBitmap = (Bitmap)BitmapProcessor.d(this.a).get(BitmapProcessor.ImageReq.a(localImageReq2));
        if (localBitmap != null)
        {
          this.d = localImageReq2;
          BitmapProcessor.ImageReq.a(this.d, this);
          BitmapProcessor.ImageReq.a(localImageReq2, localBitmap);
        }
        for (;;)
        {
          this.b = System.currentTimeMillis();
          return;
          a(localImageReq2);
        }
      }
      this.b = System.currentTimeMillis();
      Thread.sleep(30L);
      return;
    }
  }
  
  public void interrupt()
  {
    try
    {
      super.interrupt();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void run()
  {
    for (;;)
    {
      if (!BitmapProcessor.a(this.a)) {
        return;
      }
      try
      {
        if (!this.c) {
          break label33;
        }
        a();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      continue;
      label33:
      b();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.BitmapProcessor.WorkerThread
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */