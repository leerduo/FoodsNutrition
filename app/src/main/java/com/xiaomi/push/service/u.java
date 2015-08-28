package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class u
  implements Runnable
{
  public void run()
  {
    String str = t.b();
    if (!TextUtils.isEmpty(str))
    {
      b.a("Network Checkup: get gateway:" + str);
      t.a(str);
    }
    for (;;)
    {
      try
      {
        InetAddress localInetAddress = InetAddress.getByName("www.baidu.com");
        b.a("Network Checkup: get address for www.baidu.com:" + localInetAddress.getAddress());
        t.a(localInetAddress.getHostAddress());
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        b.a("Network Checkup: cannot resolve the host www.baidu.com");
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a("the checkup failure." + localThrowable);
      }
      b.a("Network Checkup: cannot get gateway");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.u
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */