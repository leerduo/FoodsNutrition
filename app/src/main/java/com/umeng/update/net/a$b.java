package com.umeng.update.net;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import u.upd.b;

class a$b
  extends Handler
{
  a$b(a parama) {}
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      b.c(a.b(), "DownloadAgent.handleMessage(" + paramMessage.what + "): ");
      switch (paramMessage.what)
      {
      case 4: 
      default: 
        super.handleMessage(paramMessage);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      b.c(a.b(), "DownloadAgent.handleMessage(" + paramMessage.what + "): " + localException.getMessage());
      return;
    }
    if (a.k(this.a) != null)
    {
      a.k(this.a).d();
      return;
      if (a.k(this.a) != null)
      {
        a.k(this.a).a(paramMessage.arg1);
        return;
        a.l(this.a).unbindService(a.m(this.a));
        if (a.k(this.a) != null)
        {
          if ((paramMessage.arg1 == 1) || (paramMessage.arg1 == 3) || (paramMessage.arg1 == 5))
          {
            a.k(this.a).a(paramMessage.arg1, paramMessage.arg2, paramMessage.getData().getString("filename"));
            return;
          }
          a.k(this.a).a(0, 0, null);
          b.c(a.b(), "DownloadAgent.handleMessage(DownloadingService.DOWNLOAD_COMPLETE_FAIL): ");
          return;
          a.k(this.a).b(paramMessage.arg1);
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.a.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */