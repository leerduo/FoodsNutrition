package cn.sharesdk.wechat.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.utils.e;

public class WechatHandlerActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973839);
    super.onCreate(paramBundle);
    try
    {
      WechatHelper.a().a(this);
      finish();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.b(localThrowable);
      }
    }
  }
  
  public void onGetMessageFromWXReq(WXMediaMessage paramWXMediaMessage) {}
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    try
    {
      WechatHelper.a().a(this);
      finish();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.b(localThrowable);
      }
    }
  }
  
  public void onShowMessageFromWXReq(WXMediaMessage paramWXMediaMessage) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.WechatHandlerActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */