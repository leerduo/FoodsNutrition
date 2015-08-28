package com.umeng.update.net;

import android.os.AsyncTask;
import u.upd.e;
import u.upd.f.a;

class g$b
  extends AsyncTask<Integer, Integer, f.a>
{
  private e b;
  private g.a c;
  
  public g$b(g paramg, e parame, g.a parama)
  {
    this.b = parame;
    this.c = parama;
  }
  
  protected f.a a(Integer... paramVarArgs)
  {
    return this.a.a(this.b);
  }
  
  protected void a(f.a parama)
  {
    if (this.c != null) {
      this.c.a(parama);
    }
  }
  
  protected void onPreExecute()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.g.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */