package com.umeng.update.net;

import u.upd.b;
import u.upd.e;
import u.upd.f;
import u.upd.f.a;

public class g
  extends u.upd.g
{
  private static final String a = g.class.getName();
  
  public f.a a(e parame)
  {
    f localf = (f)a(parame, f.class);
    if (localf == null) {
      return f.a.b;
    }
    return localf.a;
  }
  
  public void a(e parame, g.a parama)
  {
    try
    {
      new g.b(this, parame, parama).execute(new Integer[0]);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        b.b(a, "", localException);
      } while (parama == null);
      parama.a(f.a.b);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */