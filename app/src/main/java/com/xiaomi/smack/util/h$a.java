package com.xiaomi.smack.util;

import android.text.TextUtils;

class h$a
{
  public String a = "";
  public long b = 0L;
  public int c = -1;
  public int d = -1;
  public String e = "";
  public long f = 0L;
  
  public h$a(String paramString1, long paramLong1, int paramInt1, int paramInt2, String paramString2, long paramLong2)
  {
    this.a = paramString1;
    this.b = paramLong1;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString2;
    this.f = paramLong2;
  }
  
  public boolean a(a parama)
  {
    return (TextUtils.equals(parama.a, this.a)) && (TextUtils.equals(parama.e, this.e)) && (parama.c == this.c) && (parama.d == this.d) && (Math.abs(parama.b - this.b) <= 5000L);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.util.h.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */