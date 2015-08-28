package com.boohee.food;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.boohee.food.util.ToastUtils;

class AuthActivity$1
  extends Handler
{
  AuthActivity$1(AuthActivity paramAuthActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.getData() != null))
    {
      Bundle localBundle = paramMessage.getData();
      boolean bool = localBundle.getBoolean(AuthActivity.a());
      String str = localBundle.getString(AuthActivity.b());
      if ("WechatClientNotExistException".equals(str)) {
        str = "未检测到微信,请先安装";
      }
      ToastUtils.b(str);
      if (bool) {
        MyActivity.a(this.a);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.AuthActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */