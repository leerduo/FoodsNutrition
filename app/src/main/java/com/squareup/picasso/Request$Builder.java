package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.List;

public final class Request$Builder
{
  private Uri a;
  private int b;
  private String c;
  private int d;
  private int e;
  private boolean f;
  private boolean g;
  private float h;
  private float i;
  private float j;
  private boolean k;
  private List<Transformation> l;
  private Bitmap.Config m;
  private Picasso.Priority n;
  
  Request$Builder(Uri paramUri, int paramInt)
  {
    this.a = paramUri;
    this.b = paramInt;
  }
  
  public Builder a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Width must be positive number or 0.");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Height must be positive number or 0.");
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      throw new IllegalArgumentException("At least one dimension has to be positive number.");
    }
    this.d = paramInt1;
    this.e = paramInt2;
    return this;
  }
  
  boolean a()
  {
    return (this.a != null) || (this.b != 0);
  }
  
  boolean b()
  {
    return (this.d != 0) || (this.e != 0);
  }
  
  public Builder c()
  {
    if (this.f) {
      throw new IllegalStateException("Center inside can not be used after calling centerCrop");
    }
    this.g = true;
    return this;
  }
  
  public Request d()
  {
    if ((this.g) && (this.f)) {
      throw new IllegalStateException("Center crop and center inside can not be used together.");
    }
    if ((this.f) && ((this.d == 0) || (this.e == 0))) {
      throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
    }
    if ((this.g) && ((this.d == 0) || (this.e == 0))) {
      throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
    }
    if (this.n == null) {
      this.n = Picasso.Priority.b;
    }
    return new Request(this.a, this.b, this.c, this.l, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.m, this.n, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Request.Builder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */