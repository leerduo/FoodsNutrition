package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionDownloader
  implements Downloader
{
  static volatile Object a;
  private static final Object b = new Object();
  private final Context c;
  
  public UrlConnectionDownloader(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }
  
  private static void a(Context paramContext)
  {
    if (a == null) {
      try
      {
        synchronized (b)
        {
          if (a == null) {
            a = UrlConnectionDownloader.ResponseCacheIcs.a(paramContext);
          }
          return;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  public Downloader.Response a(Uri paramUri, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      a(this.c);
    }
    HttpURLConnection localHttpURLConnection = a(paramUri);
    localHttpURLConnection.setUseCaches(true);
    if (paramBoolean) {
      localHttpURLConnection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
    }
    int i = localHttpURLConnection.getResponseCode();
    if (i >= 300)
    {
      localHttpURLConnection.disconnect();
      throw new Downloader.ResponseException(i + " " + localHttpURLConnection.getResponseMessage());
    }
    long l = localHttpURLConnection.getHeaderFieldInt("Content-Length", -1);
    boolean bool = Utils.a(localHttpURLConnection.getHeaderField("X-Android-Response-Source"));
    return new Downloader.Response(localHttpURLConnection.getInputStream(), bool, l);
  }
  
  protected HttpURLConnection a(Uri paramUri)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramUri.toString()).openConnection();
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(20000);
    return localHttpURLConnection;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.UrlConnectionDownloader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */