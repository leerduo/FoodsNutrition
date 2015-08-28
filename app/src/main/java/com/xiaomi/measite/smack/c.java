package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.util.j;
import java.text.SimpleDateFormat;
import java.util.Date;

class c
  implements j
{
  c(a parama) {}
  
  public void a(String paramString)
  {
    b.b("SMACK " + a.a(this.a).format(new Date()) + " SENT (" + a.b(this.a).hashCode() + "): " + paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.measite.smack.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */