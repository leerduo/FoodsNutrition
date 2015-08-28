package m.framework.ui.widget.asyncview;

import java.io.FilterInputStream;
import java.io.InputStream;

class BitmapProcessor$PatchInputStream
  extends FilterInputStream
{
  InputStream a;
  
  protected BitmapProcessor$PatchInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
    this.a = paramInputStream;
  }
  
  public long skip(long paramLong)
  {
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      if (l1 >= paramLong) {}
      do
      {
        return l1;
        l2 = this.a.skip(paramLong - l1);
      } while (l2 == 0L);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.BitmapProcessor.PatchInputStream
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */