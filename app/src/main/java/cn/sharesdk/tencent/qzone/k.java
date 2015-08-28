package cn.sharesdk.tencent.qzone;

import android.app.Instrumentation;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.e;

class k
  extends Thread
{
  k(j paramj) {}
  
  public void run()
  {
    try
    {
      new Instrumentation().sendKeyDownUpSync(4);
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
      this.a.a.finish();
      i.a(this.a.a).onCancel(null, 0);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.k
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */