package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

class NetworkRequestHandler
  extends RequestHandler
{
  private final Downloader a;
  private final Stats b;
  
  public NetworkRequestHandler(Downloader paramDownloader, Stats paramStats)
  {
    this.a = paramDownloader;
    this.b = paramStats;
  }
  
  private Bitmap a(InputStream paramInputStream, Request paramRequest)
  {
    MarkableInputStream localMarkableInputStream = new MarkableInputStream(paramInputStream);
    long l = localMarkableInputStream.a(65536);
    BitmapFactory.Options localOptions = d(paramRequest);
    boolean bool1 = a(localOptions);
    boolean bool2 = Utils.c(localMarkableInputStream);
    localMarkableInputStream.a(l);
    Bitmap localBitmap;
    if (bool2)
    {
      byte[] arrayOfByte = Utils.b(localMarkableInputStream);
      if (bool1)
      {
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        a(paramRequest.h, paramRequest.i, localOptions, paramRequest);
      }
      localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    do
    {
      return localBitmap;
      if (bool1)
      {
        BitmapFactory.decodeStream(localMarkableInputStream, null, localOptions);
        a(paramRequest.h, paramRequest.i, localOptions, paramRequest);
        localMarkableInputStream.a(l);
      }
      localBitmap = BitmapFactory.decodeStream(localMarkableInputStream, null, localOptions);
    } while (localBitmap != null);
    throw new IOException("Failed to decode stream.");
  }
  
  int a()
  {
    return 2;
  }
  
  public boolean a(Request paramRequest)
  {
    String str = paramRequest.d.getScheme();
    return ("http".equals(str)) || ("https".equals(str));
  }
  
  boolean a(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo == null) || (paramNetworkInfo.isConnected());
  }
  
  public RequestHandler.Result b(Request paramRequest)
  {
    Downloader.Response localResponse = this.a.a(paramRequest.d, paramRequest.c);
    if (localResponse == null) {
      return null;
    }
    if (localResponse.c) {}
    for (Picasso.LoadedFrom localLoadedFrom = Picasso.LoadedFrom.b;; localLoadedFrom = Picasso.LoadedFrom.c)
    {
      Bitmap localBitmap = localResponse.b();
      if (localBitmap == null) {
        break;
      }
      return new RequestHandler.Result(localBitmap, localLoadedFrom);
    }
    InputStream localInputStream = localResponse.a();
    if (localInputStream == null) {
      return null;
    }
    if (localResponse.c() == 0L)
    {
      Utils.a(localInputStream);
      throw new IOException("Received response with 0 content-length header.");
    }
    if ((localLoadedFrom == Picasso.LoadedFrom.c) && (localResponse.c() > 0L)) {
      this.b.a(localResponse.c());
    }
    try
    {
      RequestHandler.Result localResult = new RequestHandler.Result(a(localInputStream, paramRequest), localLoadedFrom);
      return localResult;
    }
    finally
    {
      Utils.a(localInputStream);
    }
  }
  
  boolean b()
  {
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.NetworkRequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */