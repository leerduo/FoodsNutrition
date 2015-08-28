package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.d;
import java.util.HashMap;

class c
  extends Thread
{
  c(b paramb, Platform paramPlatform, String paramString) {}
  
  public void run()
  {
    e locale = e.a(this.a);
    try
    {
      String str2 = locale.a(this.a.getContext(), this.b);
      str1 = str2;
      if (str1 == null)
      {
        b.b(this.c).onError(new Throwable("Authorize token is empty"));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      String str1;
      for (;;)
      {
        b.a(this.c).onError(localThrowable);
        str1 = null;
      }
      HashMap localHashMap = new d().a(str1);
      Bundle localBundle = new Bundle();
      localBundle.putString("access_token", String.valueOf(localHashMap.get("access_token")));
      localBundle.putString("remind_in", String.valueOf(localHashMap.get("remind_in")));
      localBundle.putString("expires_in", String.valueOf(localHashMap.get("expires_in")));
      localBundle.putString("uid", String.valueOf(localHashMap.get("uid")));
      b.c(this.c).onComplete(localBundle);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.sina.weibo.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */