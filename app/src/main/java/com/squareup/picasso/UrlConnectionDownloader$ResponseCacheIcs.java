package com.squareup.picasso;

import android.content.Context;
import android.net.http.HttpResponseCache;
import java.io.File;

class UrlConnectionDownloader$ResponseCacheIcs
{
  static Object a(Context paramContext)
  {
    File localFile = Utils.b(paramContext);
    HttpResponseCache localHttpResponseCache = HttpResponseCache.getInstalled();
    if (localHttpResponseCache == null) {
      localHttpResponseCache = HttpResponseCache.install(localFile, Utils.a(localFile));
    }
    return localHttpResponseCache;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.UrlConnectionDownloader.ResponseCacheIcs
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */