package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.n;
import java.text.SimpleDateFormat;
import java.util.Date;

class d
  implements n
{
  d(a parama) {}
  
  public void a(com.xiaomi.smack.packet.d paramd)
  {
    if (a.a) {
      b.b("SMACK " + a.a(this.a).format(new Date()) + " RCV PKT (" + a.b(this.a).hashCode() + "): " + paramd.c());
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.measite.smack.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */