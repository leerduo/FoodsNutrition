package com.boohee.food.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.boohee.food.volley.JsonParams;
import com.boohee.food.volley.PassportRequest;

public class MobUtils
{
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return "";
      if ((Wechat.NAME.equals(paramString)) || (WechatMoments.NAME.equals(paramString))) {
        return "weixin";
      }
    } while (!SinaWeibo.NAME.equals(paramString));
    return "sina_weibo";
  }
  
  public static void a(Activity paramActivity, String paramString, MobUtils.OnLoginListener paramOnLoginListener)
  {
    Platform localPlatform = ShareSDK.getPlatform(paramString);
    localPlatform.SSOSetting(false);
    localPlatform.setPlatformActionListener(new MobUtils.2(paramOnLoginListener, paramActivity, paramString));
    localPlatform.showUser(null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, MobUtils.OnLoginListener paramOnLoginListener)
  {
    JsonParams localJsonParams = new JsonParams();
    localJsonParams.a("login", paramString1);
    localJsonParams.a("password", paramString2);
    PassportRequest.a("/api/v1/users/login", localJsonParams, new MobUtils.1(paramActivity, paramOnLoginListener, paramActivity), paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "";
    }
    if (TextUtils.isEmpty(paramString4)) {
      paramString4 = "";
    }
    OnekeyShare localOnekeyShare = new OnekeyShare();
    localOnekeyShare.setSilent(true);
    localOnekeyShare.setNotification(2130837631, paramContext.getString(2131558431));
    localOnekeyShare.setTitle(paramString1);
    localOnekeyShare.setTitleUrl(paramString3);
    localOnekeyShare.setText(paramString2);
    localOnekeyShare.setUrl(paramString3);
    localOnekeyShare.setSite(paramContext.getString(2131558431));
    localOnekeyShare.setSiteUrl(paramString3);
    localOnekeyShare.setImageUrl(paramString4);
    localOnekeyShare.show(paramContext);
  }
  
  private static void b(Activity paramActivity, String paramString1, MobUtils.OnLoginListener paramOnLoginListener, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      JsonParams localJsonParams1 = new JsonParams();
      localJsonParams1.a("identity", paramString2);
      localJsonParams1.a("access_token", paramString3);
      localJsonParams1.a("nickname", paramString4);
      localJsonParams1.a("avatar_url", paramString5);
      localJsonParams1.a("provider", a(paramString1));
      localJsonParams1.a("expires_at", paramString6);
      JsonParams localJsonParams2 = new JsonParams();
      localJsonParams2.a("user_connection", localJsonParams1);
      PassportRequest.a("/api/v1/user_connections/authenticate_sns", localJsonParams2, new MobUtils.3(paramActivity, paramString4, paramString5, paramOnLoginListener, paramActivity), paramActivity);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.MobUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */