package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class OkHttpDownloader
  implements Downloader
{
  private final OkUrlFactory a;
  
  public OkHttpDownloader(Context paramContext)
  {
    this(Utils.b(paramContext));
  }
  
  public OkHttpDownloader(OkHttpClient paramOkHttpClient)
  {
    this.a = new OkUrlFactory(paramOkHttpClient);
  }
  
  public OkHttpDownloader(File paramFile)
  {
    this(paramFile, Utils.a(paramFile));
  }
  
  public OkHttpDownloader(File paramFile, long paramLong)
  {
    this(new OkHttpClient());
    try
    {
      this.a.client().setCache(new Cache(paramFile, paramLong));
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public Downloader.Response a(Uri paramUri, boolean paramBoolean)
  {
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
    String str = localHttpURLConnection.getHeaderField("OkHttp-Response-Source");
    if (str == null) {
      str = localHttpURLConnection.getHeaderField("X-Android-Response-Source");
    }
    long l = localHttpURLConnection.getHeaderFieldInt("Content-Length", -1);
    boolean bool = Utils.a(str);
    return new Downloader.Response(localHttpURLConnection.getInputStream(), bool, l);
  }
  
  protected HttpURLConnection a(Uri paramUri)
  {
    HttpURLConnection localHttpURLConnection = this.a.open(new URL(paramUri.toString()));
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(20000);
    return localHttpURLConnection;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.OkHttpDownloader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */