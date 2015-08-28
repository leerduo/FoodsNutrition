package com.xiaomi.smack;

import com.xiaomi.kenai.jbosh.w;
import com.xiaomi.kenai.jbosh.x;

class b$a
  implements x
{
  private b$a(b paramb) {}
  
  public void a(w paramw)
  {
    if (!paramw.a())
    {
      this.a.a(2, 0, null);
      this.a.a((Exception)paramw.b());
    }
    synchronized (b.d(this.a))
    {
      b.d(this.a).notifyAll();
      return;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.b.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */