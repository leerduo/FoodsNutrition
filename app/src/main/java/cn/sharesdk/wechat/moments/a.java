package cn.sharesdk.wechat.moments;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(WechatMoments paramWechatMoments) {}
  
  public void onCancel()
  {
    if (WechatMoments.c(this.a) != null) {
      WechatMoments.d(this.a).onCancel(this.a, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    WechatMoments.a(this.a, 1, null);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (WechatMoments.a(this.a) != null) {
      WechatMoments.b(this.a).onError(this.a, 1, paramThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.moments.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */