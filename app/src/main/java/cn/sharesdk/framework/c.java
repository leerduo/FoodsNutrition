package cn.sharesdk.framework;

import android.os.Handler.Callback;
import android.os.Message;

class c
  implements Handler.Callback
{
  c(FakeActivity paramFakeActivity, Runnable paramRunnable) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.run();
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */