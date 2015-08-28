package cn.sharesdk.framework.network;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class m
  implements X509TrustManager
{
  m(l paraml) {}
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.m
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */