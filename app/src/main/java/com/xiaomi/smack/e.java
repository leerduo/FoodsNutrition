package com.xiaomi.smack;

import com.xiaomi.kenai.jbosh.ab;
import com.xiaomi.kenai.jbosh.z;
import java.io.PipedWriter;

class e
  implements z
{
  e(b paramb) {}
  
  public boolean a(ab paramab)
  {
    if (paramab.a() != null) {}
    try
    {
      b.a(this.a).write(paramab.a().d());
      b.a(this.a).flush();
      label34:
      return false;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */