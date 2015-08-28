package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;

class g
  implements SSOListener
{
  g(f paramf, AuthorizeListener paramAuthorizeListener) {}
  
  public void onCancel()
  {
    this.a.onCancel();
  }
  
  public void onComplete(Bundle paramBundle)
  {
    this.a.onComplete(paramBundle);
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    f.a(this.b, this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */