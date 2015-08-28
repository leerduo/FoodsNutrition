package m.framework.ui.widget.asyncview;

import android.graphics.Bitmap;
import java.io.File;
import java.util.Vector;
import java.util.WeakHashMap;

public class BitmapProcessor
{
  private static BitmapProcessor a;
  private WeakHashMap<String, Bitmap> b = new WeakHashMap();
  private boolean c;
  private Vector<BitmapProcessor.ImageReq> d = new Vector();
  private File e;
  private BitmapProcessor.WorkerThread[] f = new BitmapProcessor.WorkerThread[5];
  private Vector<BitmapProcessor.ImageReq> g = new Vector();
  
  private BitmapProcessor(String paramString)
  {
    this.e = new File(paramString);
    if (!this.e.exists()) {
      this.e.mkdirs();
    }
    new BitmapProcessor.ManagerThread(this);
  }
  
  public static void a()
  {
    if (a == null) {
      throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
    }
    a.c = true;
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (a == null) {
        a = new BitmapProcessor(paramString);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(String paramString, BitmapCallback paramBitmapCallback)
  {
    if (a == null) {
      throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
    }
    if (paramString == null) {
      return;
    }
    BitmapProcessor.ImageReq localImageReq = new BitmapProcessor.ImageReq();
    BitmapProcessor.ImageReq.a(localImageReq, paramString);
    BitmapProcessor.ImageReq.a(localImageReq, paramBitmapCallback);
    a.d.add(localImageReq);
    if (a.d.size() > 50) {}
    for (;;)
    {
      if (a.d.size() <= 40)
      {
        a();
        return;
      }
      a.d.remove(0);
    }
  }
  
  public static Bitmap b(String paramString)
  {
    if (a == null) {
      throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
    }
    return (Bitmap)a.b.get(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.BitmapProcessor
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */