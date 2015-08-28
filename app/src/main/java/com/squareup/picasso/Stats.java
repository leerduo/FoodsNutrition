package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

class Stats
{
  final HandlerThread a;
  final Cache b;
  final Handler c;
  long d;
  long e;
  long f;
  long g;
  long h;
  long i;
  long j;
  long k;
  int l;
  int m;
  int n;
  
  Stats(Cache paramCache)
  {
    this.b = paramCache;
    this.a = new HandlerThread("Picasso-Stats", 10);
    this.a.start();
    this.c = new Stats.StatsHandler(this.a.getLooper(), this);
  }
  
  private static long a(int paramInt, long paramLong)
  {
    return paramLong / paramInt;
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    int i1 = Utils.a(paramBitmap);
    this.c.sendMessage(this.c.obtainMessage(paramInt, i1, 0));
  }
  
  void a()
  {
    this.c.sendEmptyMessage(0);
  }
  
  void a(long paramLong)
  {
    this.c.sendMessage(this.c.obtainMessage(4, Long.valueOf(paramLong)));
  }
  
  void a(Bitmap paramBitmap)
  {
    a(paramBitmap, 2);
  }
  
  void a(Long paramLong)
  {
    this.l = (1 + this.l);
    this.f += paramLong.longValue();
    this.i = a(this.l, this.f);
  }
  
  void b()
  {
    this.c.sendEmptyMessage(1);
  }
  
  void b(long paramLong)
  {
    this.m = (1 + this.m);
    this.g = (paramLong + this.g);
    this.j = a(this.m, this.g);
  }
  
  void b(Bitmap paramBitmap)
  {
    a(paramBitmap, 3);
  }
  
  void c()
  {
    this.d = (1L + this.d);
  }
  
  void c(long paramLong)
  {
    this.n = (1 + this.n);
    this.h = (paramLong + this.h);
    this.k = a(this.m, this.h);
  }
  
  void d()
  {
    this.e = (1L + this.e);
  }
  
  StatsSnapshot e()
  {
    return new StatsSnapshot(this.b.b(), this.b.a(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Stats
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */