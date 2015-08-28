package cn.sharesdk.framework.authorize;

import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.UIHandler;
import cn.sharesdk.framework.utils.b;

class j
  extends Thread
{
  j(g paramg) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    if ("none".equals(b.a(g.a(this.a)).n()))
    {
      localMessage.arg1 = 1;
      UIHandler.sendMessage(localMessage, this.a);
      return;
    }
    if (ShareSDK.isRemoveCookieOnAuthorize())
    {
      CookieSyncManager.createInstance(g.b(this.a));
      CookieManager.getInstance().removeAllCookie();
    }
    localMessage.obj = this.a.a.getAuthorizeUrl();
    UIHandler.sendMessage(localMessage, this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */