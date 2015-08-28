package cn.sharesdk.wechat.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.network.f;
import cn.sharesdk.framework.network.k;
import cn.sharesdk.framework.utils.d;
import cn.sharesdk.framework.utils.e;
import java.util.ArrayList;
import java.util.HashMap;

class i
  extends Thread
{
  i(g paramg, PlatformActionListener paramPlatformActionListener) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new f("access_token", g.a(this.b).getDb().getToken()));
    localArrayList.add(new f("openid", g.a(this.b).getDb().get("openid")));
    HashMap localHashMap;
    String str2;
    int i;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    try
    {
      String str10 = g.c(this.b).a("https://api.weixin.qq.com/sns/userinfo", localArrayList, "/sns/userinfo", g.b(this.b));
      str1 = str10;
      if (TextUtils.isEmpty(str1))
      {
        if (this.a != null) {
          this.a.onError(g.a(this.b), 8, new Throwable());
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        String str1;
        for (;;)
        {
          e.c(localThrowable);
          str1 = null;
        }
        e.a("getUserInfo ==>>" + str1, new Object[0]);
        localHashMap = new d().a(str1);
        if ((!localHashMap.containsKey("errcode")) || (((Integer)localHashMap.get("errcode")).intValue() == 0)) {
          break;
        }
      } while (this.a == null);
      String str9 = new d().a(localHashMap);
      this.a.onError(g.a(this.b), 8, new Throwable(str9));
      return;
      str2 = String.valueOf(localHashMap.get("openid"));
      String str3 = String.valueOf(localHashMap.get("nickname"));
      i = Integer.parseInt(String.valueOf(localHashMap.get("sex")));
      str4 = String.valueOf(localHashMap.get("province"));
      str5 = String.valueOf(localHashMap.get("city"));
      str6 = String.valueOf(localHashMap.get("country"));
      str7 = String.valueOf(localHashMap.get("headimgurl"));
      str8 = String.valueOf(localHashMap.get("unionid"));
      g.a(this.b).getDb().put("nickname", str3);
      if (i != 1) {
        break label541;
      }
    }
    g.a(this.b).getDb().put("gender", "0");
    for (;;)
    {
      g.a(this.b).getDb().putUserId(str2);
      g.a(this.b).getDb().put("icon", str7);
      g.a(this.b).getDb().put("province", str4);
      g.a(this.b).getDb().put("city", str5);
      g.a(this.b).getDb().put("country", str6);
      g.a(this.b).getDb().put("openid", str2);
      g.a(this.b).getDb().put("unionid", str8);
      this.a.onComplete(g.a(this.b), 8, localHashMap);
      return;
      label541:
      if (i == 2) {
        g.a(this.b).getDb().put("gender", "1");
      } else {
        g.a(this.b).getDb().put("gender", "2");
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */