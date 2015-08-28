package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

class DiskBasedCache$CacheHeader
{
  public long a;
  public String b;
  public String c;
  public long d;
  public long e;
  public long f;
  public Map<String, String> g;
  
  private DiskBasedCache$CacheHeader() {}
  
  public DiskBasedCache$CacheHeader(String paramString, Cache.Entry paramEntry)
  {
    this.b = paramString;
    this.a = paramEntry.a.length;
    this.c = paramEntry.b;
    this.d = paramEntry.c;
    this.e = paramEntry.d;
    this.f = paramEntry.e;
    this.g = paramEntry.f;
  }
  
  public static CacheHeader a(InputStream paramInputStream)
  {
    CacheHeader localCacheHeader = new CacheHeader();
    if (DiskBasedCache.a(paramInputStream) != 538183203) {
      throw new IOException();
    }
    localCacheHeader.b = DiskBasedCache.c(paramInputStream);
    localCacheHeader.c = DiskBasedCache.c(paramInputStream);
    if (localCacheHeader.c.equals("")) {
      localCacheHeader.c = null;
    }
    localCacheHeader.d = DiskBasedCache.b(paramInputStream);
    localCacheHeader.e = DiskBasedCache.b(paramInputStream);
    localCacheHeader.f = DiskBasedCache.b(paramInputStream);
    localCacheHeader.g = DiskBasedCache.d(paramInputStream);
    return localCacheHeader;
  }
  
  public Cache.Entry a(byte[] paramArrayOfByte)
  {
    Cache.Entry localEntry = new Cache.Entry();
    localEntry.a = paramArrayOfByte;
    localEntry.b = this.c;
    localEntry.c = this.d;
    localEntry.d = this.e;
    localEntry.e = this.f;
    localEntry.f = this.g;
    return localEntry;
  }
  
  public boolean a(OutputStream paramOutputStream)
  {
    try
    {
      DiskBasedCache.a(paramOutputStream, 538183203);
      DiskBasedCache.a(paramOutputStream, this.b);
      if (this.c == null) {}
      for (String str = "";; str = this.c)
      {
        DiskBasedCache.a(paramOutputStream, str);
        DiskBasedCache.a(paramOutputStream, this.d);
        DiskBasedCache.a(paramOutputStream, this.e);
        DiskBasedCache.a(paramOutputStream, this.f);
        DiskBasedCache.a(this.g, paramOutputStream);
        paramOutputStream.flush();
        return true;
      }
      Object[] arrayOfObject;
      return false;
    }
    catch (IOException localIOException)
    {
      arrayOfObject = new Object[1];
      arrayOfObject[0] = localIOException.toString();
      VolleyLog.b("%s", arrayOfObject);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.DiskBasedCache.CacheHeader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */