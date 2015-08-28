package m.framework.network;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class SSLSocketFactoryEx
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext a = SSLContext.getInstance("TLS");
  
  public SSLSocketFactoryEx(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    SSLSocketFactoryEx.1 local1 = new SSLSocketFactoryEx.1(this);
    this.a.init(null, new TrustManager[] { local1 }, null);
  }
  
  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.network.SSLSocketFactoryEx
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */