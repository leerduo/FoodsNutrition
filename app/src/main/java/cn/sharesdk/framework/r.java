package cn.sharesdk.framework;

import cn.sharesdk.framework.statistics.a;
import cn.sharesdk.framework.utils.d;
import java.util.HashMap;

class r
  extends Thread
{
  r(p paramp, a parama) {}
  
  public void run()
  {
    try
    {
      String str = this.a.f(p.a(this.b));
      this.a.a(p.a(this.b), str);
      HashMap localHashMap1 = new d().a(str);
      HashMap localHashMap2 = new HashMap();
      if (p.a(this.b, this.a, localHashMap1, localHashMap2)) {
        this.b.b(localHashMap2);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!ShareSDK.isDebug()) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.r
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */