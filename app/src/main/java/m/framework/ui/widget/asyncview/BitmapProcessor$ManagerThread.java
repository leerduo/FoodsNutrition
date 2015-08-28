package m.framework.ui.widget.asyncview;

import java.util.Timer;

class BitmapProcessor$ManagerThread
  extends Timer
{
  private BitmapProcessor a;
  
  public BitmapProcessor$ManagerThread(BitmapProcessor paramBitmapProcessor)
  {
    this.a = paramBitmapProcessor;
    schedule(new BitmapProcessor.ManagerThread.1(this), 0L, 200L);
  }
  
  private void a()
  {
    if (!BitmapProcessor.a(this.a)) {
      return;
    }
    long l = System.currentTimeMillis();
    int i = 0;
    label17:
    boolean bool2;
    if (i < BitmapProcessor.b(this.a).length)
    {
      if (BitmapProcessor.b(this.a)[i] != null) {
        break label138;
      }
      BitmapProcessor.b(this.a)[i] = new BitmapProcessor.WorkerThread(this.a);
      BitmapProcessor.b(this.a)[i].setName("worker " + i);
      BitmapProcessor.WorkerThread localWorkerThread = BitmapProcessor.b(this.a)[i];
      if (i != 0) {
        break label132;
      }
      bool2 = true;
      label107:
      BitmapProcessor.WorkerThread.a(localWorkerThread, bool2);
      BitmapProcessor.b(this.a)[i].start();
    }
    for (;;)
    {
      i++;
      break label17;
      break;
      label132:
      bool2 = false;
      break label107;
      label138:
      if (l - BitmapProcessor.WorkerThread.a(BitmapProcessor.b(this.a)[i]) > 20000L)
      {
        BitmapProcessor.b(this.a)[i].interrupt();
        boolean bool1 = BitmapProcessor.WorkerThread.b(BitmapProcessor.b(this.a)[i]);
        BitmapProcessor.b(this.a)[i] = new BitmapProcessor.WorkerThread(this.a);
        BitmapProcessor.b(this.a)[i].setName("worker " + i);
        BitmapProcessor.WorkerThread.a(BitmapProcessor.b(this.a)[i], bool1);
        BitmapProcessor.b(this.a)[i].start();
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.BitmapProcessor.ManagerThread
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */