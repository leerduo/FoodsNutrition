package com.umeng.update.net;

import android.util.SparseArray;

class c$b
{
  DownloadingService.b a;
  c.a b;
  int c;
  int d;
  a.a e;
  long[] f = new long[3];
  
  public c$b(a.a parama, int paramInt)
  {
    this.c = paramInt;
    this.e = parama;
  }
  
  public void a(SparseArray<b> paramSparseArray)
  {
    paramSparseArray.put(this.c, this);
  }
  
  public void b(SparseArray<b> paramSparseArray)
  {
    if (paramSparseArray.indexOfKey(this.c) >= 0) {
      paramSparseArray.remove(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.c.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */