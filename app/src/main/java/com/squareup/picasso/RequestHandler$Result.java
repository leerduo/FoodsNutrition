package com.squareup.picasso;

import android.graphics.Bitmap;

public final class RequestHandler$Result
{
  private final Picasso.LoadedFrom a;
  private final Bitmap b;
  private final int c;
  
  public RequestHandler$Result(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    this(paramBitmap, paramLoadedFrom, 0);
  }
  
  RequestHandler$Result(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom, int paramInt)
  {
    this.b = paramBitmap;
    this.a = paramLoadedFrom;
    this.c = paramInt;
  }
  
  public Bitmap a()
  {
    return this.b;
  }
  
  public Picasso.LoadedFrom b()
  {
    return this.a;
  }
  
  int c()
  {
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RequestHandler.Result
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */