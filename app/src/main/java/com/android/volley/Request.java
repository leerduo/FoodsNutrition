package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Request<T>
  implements Comparable<Request<T>>
{
  private final VolleyLog.MarkerLog a;
  private final int b;
  private final String c;
  private String d;
  private final int e;
  private final Response.ErrorListener f;
  private Integer g;
  private RequestQueue h;
  private boolean i;
  private boolean j;
  private boolean k;
  private long l;
  private RetryPolicy m;
  private Cache.Entry n;
  private Object o;
  
  public Request(int paramInt, String paramString, Response.ErrorListener paramErrorListener)
  {
    if (VolleyLog.MarkerLog.a) {}
    for (VolleyLog.MarkerLog localMarkerLog = new VolleyLog.MarkerLog();; localMarkerLog = null)
    {
      this.a = localMarkerLog;
      this.i = true;
      this.j = false;
      this.k = false;
      this.l = 0L;
      this.n = null;
      this.b = paramInt;
      this.c = paramString;
      this.f = paramErrorListener;
      a(new DefaultRetryPolicy());
      this.e = d(paramString);
      return;
    }
  }
  
  private byte[] a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
        localStringBuilder.append('&');
      }
      arrayOfByte = localStringBuilder.toString().getBytes(paramString);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("Encoding not supported: " + paramString, localUnsupportedEncodingException);
    }
    byte[] arrayOfByte;
    return arrayOfByte;
  }
  
  private static int d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri != null)
      {
        String str = localUri.getHost();
        if (str != null) {
          return str.hashCode();
        }
      }
    }
    return 0;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(Request<T> paramRequest)
  {
    Request.Priority localPriority1 = t();
    Request.Priority localPriority2 = paramRequest.t();
    if (localPriority1 == localPriority2) {
      return this.g.intValue() - paramRequest.g.intValue();
    }
    return localPriority2.ordinal() - localPriority1.ordinal();
  }
  
  public final Request<?> a(int paramInt)
  {
    this.g = Integer.valueOf(paramInt);
    return this;
  }
  
  public Request<?> a(Cache.Entry paramEntry)
  {
    this.n = paramEntry;
    return this;
  }
  
  public Request<?> a(RequestQueue paramRequestQueue)
  {
    this.h = paramRequestQueue;
    return this;
  }
  
  public Request<?> a(RetryPolicy paramRetryPolicy)
  {
    this.m = paramRetryPolicy;
    return this;
  }
  
  public Request<?> a(Object paramObject)
  {
    this.o = paramObject;
    return this;
  }
  
  protected abstract Response<T> a(NetworkResponse paramNetworkResponse);
  
  protected VolleyError a(VolleyError paramVolleyError)
  {
    return paramVolleyError;
  }
  
  public void a(String paramString)
  {
    if (VolleyLog.MarkerLog.a) {
      this.a.a(paramString, Thread.currentThread().getId());
    }
    while (this.l != 0L) {
      return;
    }
    this.l = SystemClock.elapsedRealtime();
  }
  
  public Object b()
  {
    return this.o;
  }
  
  public void b(VolleyError paramVolleyError)
  {
    if (this.f != null) {
      this.f.a(paramVolleyError);
    }
  }
  
  protected abstract void b(T paramT);
  
  void b(String paramString)
  {
    if (this.h != null) {
      this.h.b(this);
    }
    long l2;
    if (VolleyLog.MarkerLog.a)
    {
      l2 = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        new Handler(Looper.getMainLooper()).post(new Request.1(this, paramString, l2));
      }
    }
    long l1;
    do
    {
      return;
      this.a.a(paramString, l2);
      this.a.a(toString());
      return;
      l1 = SystemClock.elapsedRealtime() - this.l;
    } while (l1 < 3000L);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(l1);
    arrayOfObject[1] = toString();
    VolleyLog.b("%d ms: %s", arrayOfObject);
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    if (this.d != null) {
      return this.d;
    }
    return this.c;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public String f()
  {
    return d();
  }
  
  public Cache.Entry g()
  {
    return this.n;
  }
  
  public void h()
  {
    this.j = true;
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public Map<String, String> j()
  {
    return Collections.emptyMap();
  }
  
  @Deprecated
  protected Map<String, String> k()
  {
    return o();
  }
  
  @Deprecated
  protected String l()
  {
    return p();
  }
  
  @Deprecated
  public String m()
  {
    return q();
  }
  
  @Deprecated
  public byte[] n()
  {
    Map localMap = k();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, l());
    }
    return null;
  }
  
  protected Map<String, String> o()
  {
    return null;
  }
  
  protected String p()
  {
    return "UTF-8";
  }
  
  public String q()
  {
    return "application/x-www-form-urlencoded; charset=" + p();
  }
  
  public byte[] r()
  {
    Map localMap = o();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, p());
    }
    return null;
  }
  
  public final boolean s()
  {
    return this.i;
  }
  
  public Request.Priority t()
  {
    return Request.Priority.b;
  }
  
  public String toString()
  {
    String str1 = "0x" + Integer.toHexString(c());
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.j) {}
    for (String str2 = "[X] ";; str2 = "[ ] ") {
      return str2 + d() + " " + str1 + " " + t() + " " + this.g;
    }
  }
  
  public final int u()
  {
    return this.m.a();
  }
  
  public RetryPolicy v()
  {
    return this.m;
  }
  
  public void w()
  {
    this.k = true;
  }
  
  public boolean x()
  {
    return this.k;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.Request
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */