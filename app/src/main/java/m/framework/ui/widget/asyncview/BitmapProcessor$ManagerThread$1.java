package m.framework.ui.widget.asyncview;

import java.util.TimerTask;

class BitmapProcessor$ManagerThread$1
  extends TimerTask
{
  private int b;
  
  BitmapProcessor$ManagerThread$1(BitmapProcessor.ManagerThread paramManagerThread) {}
  
  public void run()
  {
    if (BitmapProcessor.a(BitmapProcessor.ManagerThread.a(this.a)))
    {
      this.b = (-1 + this.b);
      if (this.b <= 0)
      {
        this.b = 100;
        BitmapProcessor.ManagerThread.b(this.a);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.BitmapProcessor.ManagerThread.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */