package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Request
{
  private static final long r = TimeUnit.SECONDS.toNanos(5L);
  int a;
  long b;
  boolean c;
  public final Uri d;
  public final int e;
  public final String f;
  public final List<Transformation> g;
  public final int h;
  public final int i;
  public final boolean j;
  public final boolean k;
  public final float l;
  public final float m;
  public final float n;
  public final boolean o;
  public final Bitmap.Config p;
  public final Picasso.Priority q;
  
  private Request(Uri paramUri, int paramInt1, String paramString, List<Transformation> paramList, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean3, Bitmap.Config paramConfig, Picasso.Priority paramPriority)
  {
    this.d = paramUri;
    this.e = paramInt1;
    this.f = paramString;
    if (paramList == null) {}
    for (this.g = null;; this.g = Collections.unmodifiableList(paramList))
    {
      this.h = paramInt2;
      this.i = paramInt3;
      this.j = paramBoolean1;
      this.k = paramBoolean2;
      this.l = paramFloat1;
      this.m = paramFloat2;
      this.n = paramFloat3;
      this.o = paramBoolean3;
      this.p = paramConfig;
      this.q = paramPriority;
      return;
    }
  }
  
  String a()
  {
    long l1 = System.nanoTime() - this.b;
    if (l1 > r) {
      return b() + '+' + TimeUnit.NANOSECONDS.toSeconds(l1) + 's';
    }
    return b() + '+' + TimeUnit.NANOSECONDS.toMillis(l1) + "ms";
  }
  
  String b()
  {
    return "[R" + this.a + ']';
  }
  
  String c()
  {
    if (this.d != null) {
      return String.valueOf(this.d.getPath());
    }
    return Integer.toHexString(this.e);
  }
  
  public boolean d()
  {
    return (this.h != 0) || (this.i != 0);
  }
  
  boolean e()
  {
    return (f()) || (g());
  }
  
  boolean f()
  {
    return (d()) || (this.l != 0.0F);
  }
  
  boolean g()
  {
    return this.g != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request{");
    if (this.e > 0) {
      localStringBuilder.append(this.e);
    }
    while ((this.g != null) && (!this.g.isEmpty()))
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        Transformation localTransformation = (Transformation)localIterator.next();
        localStringBuilder.append(' ').append(localTransformation.a());
      }
      localStringBuilder.append(this.d);
    }
    if (this.f != null) {
      localStringBuilder.append(" stableKey(").append(this.f).append(')');
    }
    if (this.h > 0) {
      localStringBuilder.append(" resize(").append(this.h).append(',').append(this.i).append(')');
    }
    if (this.j) {
      localStringBuilder.append(" centerCrop");
    }
    if (this.k) {
      localStringBuilder.append(" centerInside");
    }
    if (this.l != 0.0F)
    {
      localStringBuilder.append(" rotation(").append(this.l);
      if (this.o) {
        localStringBuilder.append(" @ ").append(this.m).append(',').append(this.n);
      }
      localStringBuilder.append(')');
    }
    if (this.p != null) {
      localStringBuilder.append(' ').append(this.p);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Request
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */