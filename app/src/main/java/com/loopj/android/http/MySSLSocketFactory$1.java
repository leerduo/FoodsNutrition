package com.loopj.android.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class MySSLSocketFactory$1
  implements X509TrustManager
{
  MySSLSocketFactory$1(MySSLSocketFactory paramMySSLSocketFactory) {}
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.MySSLSocketFactory.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */