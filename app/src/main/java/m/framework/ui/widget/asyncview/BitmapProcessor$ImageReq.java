package m.framework.ui.widget.asyncview;

import android.graphics.Bitmap;

public class BitmapProcessor$ImageReq
{
  private String a;
  private BitmapCallback b;
  private BitmapProcessor.WorkerThread c;
  private long d = System.currentTimeMillis();
  private Bitmap e;
  
  private void a(Bitmap paramBitmap)
  {
    this.e = paramBitmap;
    if (this.b != null) {
      this.b.a(this.a, this.e);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url=").append(this.a);
    localStringBuilder.append("time=").append(this.d);
    localStringBuilder.append("worker=").append(this.c.getName()).append(" (").append(this.c.getId()).append("");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.BitmapProcessor.ImageReq
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */