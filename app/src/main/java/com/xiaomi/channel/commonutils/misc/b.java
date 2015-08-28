package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;

public class b
{
  private b.a a;
  private Handler b = null;
  private volatile boolean c = false;
  private final boolean d;
  private volatile b.b e;
  
  public b()
  {
    this(false);
  }
  
  public b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void a(b.b paramb)
  {
    try
    {
      if (this.a == null)
      {
        this.a = new b.a(this);
        this.a.setDaemon(this.d);
        this.a.start();
      }
      this.a.a(paramb);
      return;
    }
    finally {}
  }
  
  public void a(b.b paramb, long paramLong)
  {
    this.b.postDelayed(new d(this, paramb), paramLong);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.misc.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */