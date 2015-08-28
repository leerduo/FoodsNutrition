package com.umeng.update;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class UmengUpdateAgent$1
  extends Handler
{
  UmengUpdateAgent$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == 0) && (UpdateConfig.isUpdateAutoPopup())) {
      UmengUpdateAgent.a(UmengUpdateAgent.a(), (UpdateResponse)paramMessage.obj, UpdateConfig.getStyle());
    }
    UmengUpdateAgent.a(null);
    if (UmengUpdateAgent.b() != null) {
      UmengUpdateAgent.b().onUpdateReturned(paramMessage.what, (UpdateResponse)paramMessage.obj);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.UmengUpdateAgent.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */