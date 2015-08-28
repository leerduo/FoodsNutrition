package m.framework.network;

import java.io.InputStream;
import java.security.KeyStore;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class NetworkHelper
{
  private HttpClient a()
  {
    KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    localKeyStore.load(null, null);
    SSLSocketFactoryEx localSSLSocketFactoryEx = new SSLSocketFactoryEx(localKeyStore);
    localSSLSocketFactoryEx.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", localSSLSocketFactoryEx, 443));
    return new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }
  
  public void a(String paramString, ResponseCallback paramResponseCallback)
  {
    HttpGet localHttpGet = new HttpGet(paramString);
    if (paramString.startsWith("https://")) {}
    HttpResponse localHttpResponse;
    for (Object localObject = a();; localObject = new DefaultHttpClient())
    {
      localHttpResponse = ((HttpClient)localObject).execute(localHttpGet);
      if (localHttpResponse.getStatusLine().getStatusCode() != 200) {
        break;
      }
      InputStream localInputStream = localHttpResponse.getEntity().getContent();
      if (paramResponseCallback != null) {
        paramResponseCallback.a(localInputStream);
      }
      localInputStream.close();
      ((HttpClient)localObject).getConnectionManager().shutdown();
      return;
    }
    String str = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
    ((HttpClient)localObject).getConnectionManager().shutdown();
    throw new Throwable(str);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.network.NetworkHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */