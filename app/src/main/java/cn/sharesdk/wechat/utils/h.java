package cn.sharesdk.wechat.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.network.f;
import cn.sharesdk.framework.network.k;
import java.util.ArrayList;

class h
  extends Thread
{
  h(g paramg, String paramString, AuthorizeListener paramAuthorizeListener) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new f("appid", g.d(this.c)));
    localArrayList.add(new f("secret", g.e(this.c)));
    localArrayList.add(new f("code", this.a));
    localArrayList.add(new f("grant_type", "authorization_code"));
    String str;
    do
    {
      try
      {
        str = g.c(this.c).a("https://api.weixin.qq.com/sns/oauth2/access_token", localArrayList, "/sns/oauth2/access_token", g.b(this.c));
        if (TextUtils.isEmpty(str))
        {
          this.b.onError(new Throwable("Authorize token is empty"));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.b.onError(localThrowable);
        return;
      }
      if (!str.contains("errcode")) {
        break;
      }
    } while (this.b == null);
    this.b.onError(new Throwable(str));
    return;
    g.a(this.c, str);
    this.b.onComplete(null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */