package com.boohee.food.util;

import android.app.Activity;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.wechat.friends.Wechat;
import java.util.Date;
import java.util.HashMap;

final class MobUtils$2
  implements PlatformActionListener
{
  MobUtils$2(MobUtils.OnLoginListener paramOnLoginListener, Activity paramActivity, String paramString) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    this.a.a(false, this.b.getString(2131558432));
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (paramInt != 8)
    {
      this.a.a(false, this.b.getString(2131558433));
      return;
    }
    String str1 = "";
    PlatformDb localPlatformDb = paramPlatform.getDb();
    if (Wechat.NAME.equals(this.c)) {
      str1 = paramHashMap.get("unionid").toString();
    }
    for (;;)
    {
      String str2 = localPlatformDb.getToken();
      String str3 = localPlatformDb.getUserName();
      String str4 = localPlatformDb.getUserIcon();
      String str5 = DateFormatUtils.a(new Date(localPlatformDb.getExpiresTime()), "yyyy-MM-dd HH:mm:ss");
      MobUtils.a(this.b, this.c, this.a, str1, str2, str3, str4, str5);
      return;
      if (SinaWeibo.NAME.equals(this.c)) {
        str1 = localPlatformDb.getUserId();
      }
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    this.a.a(false, paramThrowable.getClass().getSimpleName());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.MobUtils.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */