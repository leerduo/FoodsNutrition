package com.xiaomi.kenai.jbosh;

import android.content.Context;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

final class e
  implements am
{
  private final Lock a = new ReentrantLock();
  private v b;
  private HttpClient c;
  
  e()
  {
    HttpClient.class.getName();
  }
  
  private HttpClient b(v paramv)
  {
    try
    {
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 100);
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
      if ((paramv != null) && (paramv.f() != null) && (paramv.g() != 0)) {
        localBasicHttpParams.setParameter("http.route.default-proxy", new HttpHost(paramv.f(), paramv.g()));
      }
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      localDefaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
      return localDefaultHttpClient;
    }
    finally {}
  }
  
  public al a(ah paramah, b paramb, Context paramContext)
  {
    this.a.lock();
    try
    {
      if (this.c == null) {
        this.c = b(this.b);
      }
      HttpClient localHttpClient = this.c;
      HttpParams localHttpParams = localHttpClient.getParams();
      HttpConnectionParams.setConnectionTimeout(localHttpParams, 10000);
      if (paramah != null) {
        HttpConnectionParams.setSoTimeout(localHttpParams, (int)(1000L * (30 + ((Integer)paramah.b().a()).intValue())));
      }
      v localv = this.b;
      return new d(localHttpClient, localv, paramah, paramb, paramContext);
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public void a()
  {
    this.a.lock();
    try
    {
      if (this.c != null) {
        this.c.getConnectionManager().shutdown();
      }
      return;
    }
    finally
    {
      this.b = null;
      this.c = null;
      this.a.unlock();
    }
  }
  
  public void a(v paramv)
  {
    this.a.lock();
    try
    {
      this.b = paramv;
      this.c = b(paramv);
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */