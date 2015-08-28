package com.boohee.food.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;

final class XMPush$1
  implements LoggerInterface
{
  public void a(String paramString)
  {
    Log.d("XMPush", paramString);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    Log.d("XMPush", paramString, paramThrowable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.push.XMPush.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */