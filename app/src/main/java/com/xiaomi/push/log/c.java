package com.xiaomi.push.log;

import android.util.Log;
import com.xiaomi.channel.commonutils.file.a;
import com.xiaomi.channel.commonutils.misc.b.b;
import java.util.List;

class c
  extends b.b
{
  c(b paramb) {}
  
  public void b()
  {
    if (b.a().isEmpty()) {
      return;
    }
    try
    {
      if (!a.d())
      {
        Log.w(b.a(this.a), "SDCard is unavailable.");
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(b.a(this.a), "", localException);
      return;
    }
    b.b(this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.log.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */