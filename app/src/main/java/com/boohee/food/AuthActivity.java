package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import butterknife.ButterKnife;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.wechat.friends.Wechat;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.LogUtils;
import com.boohee.food.util.MobUtils;
import com.boohee.food.util.MobUtils.OnLoginListener;

public class AuthActivity
  extends BaseActivity
  implements MobUtils.OnLoginListener
{
  private static String b = "isLogin";
  private static String c = "message";
  private Handler d = new AuthActivity.1(this);
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, AuthActivity.class));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    d();
    LogUtils.a(paramString);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean(b, paramBoolean);
    localBundle.putString(c, paramString);
    Message localMessage = new Message();
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427417: 
      c();
      MobUtils.a(this, SinaWeibo.NAME, this);
      return;
    case 2131427416: 
      MobUtils.a(this, Wechat.NAME, this);
      return;
    }
    LoginActivity.a(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903064);
    ButterKnife.a(this);
  }
  
  public void onResume()
  {
    super.onResume();
    if (AccountUtils.d()) {
      finish();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.AuthActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */