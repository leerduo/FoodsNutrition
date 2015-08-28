package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;

class f
  implements SSOListener
{
  f(e parame, AuthorizeListener paramAuthorizeListener) {}
  
  public void onCancel()
  {
    this.a.onCancel();
  }
  
  public void onComplete(Bundle paramBundle)
  {
    try
    {
      Long.parseLong(paramBundle.getString("expires_in"));
      this.a.onComplete(paramBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      onFailed(localThrowable);
    }
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    cn.sharesdk.framework.utils.e.c(paramThrowable);
    e.a(this.b, this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.sina.weibo.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */