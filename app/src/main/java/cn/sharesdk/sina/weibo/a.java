package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(SinaWeibo paramSinaWeibo, e parame) {}
  
  public void onCancel()
  {
    if (SinaWeibo.h(this.b) != null) {
      SinaWeibo.i(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uid");
    String str2 = paramBundle.getString("access_token");
    String str3 = paramBundle.getString("expires_in");
    SinaWeibo.a(this.b).put("nickname", paramBundle.getString("userName"));
    SinaWeibo.b(this.b).put("remind_in", paramBundle.getString("remind_in"));
    SinaWeibo.c(this.b).putToken(str2);
    try
    {
      long l2 = Long.parseLong(str3);
      l1 = l2;
      SinaWeibo.d(this.b).putExpiresIn(l1);
      SinaWeibo.e(this.b).putUserId(str1);
      this.a.b(str2);
      SinaWeibo.a(this.b, 1, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (SinaWeibo.f(this.b) != null) {
      SinaWeibo.g(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.sina.weibo.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */