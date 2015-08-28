package com.xiaomi.smack;

import com.xiaomi.smack.packet.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class b$b
  implements Runnable
{
  private d b;
  
  public b$b(b paramb, d paramd)
  {
    this.b = paramd;
  }
  
  public void run()
  {
    Iterator localIterator = this.a.f.values().iterator();
    while (localIterator.hasNext()) {
      ((j.a)localIterator.next()).a(this.b);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.b.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */