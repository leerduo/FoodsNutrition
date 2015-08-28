package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;
import java.text.SimpleDateFormat;
import java.util.Date;

class e
  implements l
{
  e(a parama) {}
  
  public void a()
  {
    b.b("SMACK " + a.a(this.a).format(new Date()) + " Connection reconnected (" + a.b(this.a).hashCode() + ")");
  }
  
  public void a(int paramInt, Exception paramException)
  {
    b.b("SMACK " + a.a(this.a).format(new Date()) + " Connection closed (" + a.b(this.a).hashCode() + ")");
  }
  
  public void a(Exception paramException)
  {
    b.b("SMACK " + a.a(this.a).format(new Date()) + " Reconnection failed due to an exception (" + a.b(this.a).hashCode() + ")");
    paramException.printStackTrace();
  }
  
  public void b()
  {
    b.b("SMACK " + a.a(this.a).format(new Date()) + " Connection started (" + a.b(this.a).hashCode() + ")");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.measite.smack.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */