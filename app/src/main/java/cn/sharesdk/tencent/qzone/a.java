package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(QZone paramQZone, f paramf) {}
  
  public void onCancel()
  {
    if (QZone.g(this.b) != null) {
      QZone.h(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("open_id");
    String str2 = paramBundle.getString("access_token");
    String str3 = paramBundle.getString("expires_in");
    QZone.c(this.b).putToken(str2);
    QZone.d(this.b).putTokenSecret("");
    QZone.e(this.b).putExpiresIn(Long.parseLong(str3));
    QZone.f(this.b).putUserId(str1);
    this.a.b(str1);
    this.a.c(str2);
    QZone.a(this.b, 1, null);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (QZone.a(this.b) != null) {
      QZone.b(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */