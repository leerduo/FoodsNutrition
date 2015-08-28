package cn.sharesdk.framework.authorize;

import android.app.Instrumentation;
import cn.sharesdk.framework.utils.e;

class i
  extends Thread
{
  i(h paramh) {}
  
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
      AuthorizeListener localAuthorizeListener = this.a.a.a.getAuthorizeListener();
      if (localAuthorizeListener != null) {
        localAuthorizeListener.onCancel();
      }
      this.a.a.finish();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */