package com.boohee.food.wxapi;

import android.content.pm.PackageManager;
import android.widget.Toast;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;

public class WXEntryActivity
  extends WechatHandlerActivity
{
  public void onGetMessageFromWXReq(WXMediaMessage paramWXMediaMessage)
  {
    startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
  }
  
  public void onShowMessageFromWXReq(WXMediaMessage paramWXMediaMessage)
  {
    if ((paramWXMediaMessage != null) && (paramWXMediaMessage.mediaObject != null) && ((paramWXMediaMessage.mediaObject instanceof WXAppExtendObject))) {
      Toast.makeText(this, ((WXAppExtendObject)paramWXMediaMessage.mediaObject).extInfo, 0).show();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */