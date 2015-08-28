package com.squareup.picasso;

import android.graphics.Bitmap;
import java.io.InputStream;

public class Downloader$Response
{
  final InputStream a;
  final Bitmap b;
  final boolean c;
  final long d;
  
  public Downloader$Response(InputStream paramInputStream, boolean paramBoolean, long paramLong)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Stream may not be null.");
    }
    this.a = paramInputStream;
    this.b = null;
    this.c = paramBoolean;
    this.d = paramLong;
  }
  
  public InputStream a()
  {
    return this.a;
  }
  
  public Bitmap b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Downloader.Response
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */