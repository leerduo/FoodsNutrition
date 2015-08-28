package com.loopj.android.http;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class MySSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext sslContext = SSLContext.getInstance("TLS");
  
  public MySSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    MySSLSocketFactory.1 local1 = new MySSLSocketFactory.1(this);
    this.sslContext.init(null, new TrustManager[] { local1 }, null);
  }
  
  public static org.apache.http.conn.ssl.SSLSocketFactory getFixedSocketFactory()
  {
    try
    {
      MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(getKeystore());
      localMySSLSocketFactory.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      return localMySSLSocketFactory;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
  }
  
  public static KeyStore getKeystore()
  {
    try
    {
      KeyStore localKeyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore1 = localKeyStore2;
      Throwable localThrowable2;
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localKeyStore1.load(null, null);
        return localKeyStore1;
      }
      catch (Throwable localThrowable3)
      {
        KeyStore localKeyStore1;
        break label22;
      }
      localThrowable1 = localThrowable1;
      localKeyStore1 = null;
      localThrowable2 = localThrowable1;
    }
    label22:
    return localKeyStore1;
  }
  
  /* Error */
  public static KeyStore getKeystoreOfCA(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 78
    //   4: invokestatic 83	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   7: astore 14
    //   9: new 85	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 88	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 5
    //   19: aload 14
    //   21: aload 5
    //   23: invokevirtual 92	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   26: astore 15
    //   28: aload 15
    //   30: astore 6
    //   32: aload 5
    //   34: ifnull +8 -> 42
    //   37: aload 5
    //   39: invokevirtual 97	java/io/InputStream:close	()V
    //   42: invokestatic 61	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   45: astore 7
    //   47: aload 7
    //   49: invokestatic 64	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   52: astore 11
    //   54: aload 11
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 68	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   61: aload 11
    //   63: ldc 99
    //   65: aload 6
    //   67: invokevirtual 103	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   70: aload 11
    //   72: areturn
    //   73: astore 16
    //   75: aload 16
    //   77: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   80: goto -38 -> 42
    //   83: astore 4
    //   85: aconst_null
    //   86: astore 5
    //   88: aload 4
    //   90: invokevirtual 105	java/security/cert/CertificateException:printStackTrace	()V
    //   93: aload 5
    //   95: ifnull +8 -> 103
    //   98: aload 5
    //   100: invokevirtual 97	java/io/InputStream:close	()V
    //   103: aconst_null
    //   104: astore 6
    //   106: goto -64 -> 42
    //   109: astore 13
    //   111: aload 13
    //   113: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: astore 6
    //   119: goto -77 -> 42
    //   122: astore_2
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 97	java/io/InputStream:close	()V
    //   131: aload_2
    //   132: athrow
    //   133: astore_3
    //   134: aload_3
    //   135: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   138: goto -7 -> 131
    //   141: astore 8
    //   143: aconst_null
    //   144: astore 9
    //   146: aload 8
    //   148: astore 10
    //   150: aload 10
    //   152: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   155: aload 9
    //   157: areturn
    //   158: astore 12
    //   160: aload 11
    //   162: astore 9
    //   164: aload 12
    //   166: astore 10
    //   168: goto -18 -> 150
    //   171: astore_2
    //   172: aload 5
    //   174: astore_1
    //   175: goto -52 -> 123
    //   178: astore 4
    //   180: goto -92 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramInputStream	java.io.InputStream
    //   1	174	1	localObject1	java.lang.Object
    //   122	10	2	localObject2	java.lang.Object
    //   171	1	2	localObject3	java.lang.Object
    //   133	2	3	localIOException1	java.io.IOException
    //   83	6	4	localCertificateException1	java.security.cert.CertificateException
    //   178	1	4	localCertificateException2	java.security.cert.CertificateException
    //   17	156	5	localBufferedInputStream	java.io.BufferedInputStream
    //   30	88	6	localCertificate1	java.security.cert.Certificate
    //   45	3	7	str	String
    //   141	6	8	localException1	Exception
    //   144	19	9	localKeyStore1	KeyStore
    //   148	19	10	localObject4	java.lang.Object
    //   52	109	11	localKeyStore2	KeyStore
    //   158	7	12	localException2	Exception
    //   109	3	13	localIOException2	java.io.IOException
    //   7	13	14	localCertificateFactory	java.security.cert.CertificateFactory
    //   26	3	15	localCertificate2	java.security.cert.Certificate
    //   73	3	16	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   37	42	73	java/io/IOException
    //   2	19	83	java/security/cert/CertificateException
    //   98	103	109	java/io/IOException
    //   2	19	122	finally
    //   127	131	133	java/io/IOException
    //   47	54	141	java/lang/Exception
    //   54	70	158	java/lang/Exception
    //   19	28	171	finally
    //   88	93	171	finally
    //   19	28	178	java/security/cert/CertificateException
  }
  
  public static DefaultHttpClient getNewHttpClient(KeyStore paramKeyStore)
  {
    try
    {
      MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(paramKeyStore);
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", localMySSLSocketFactory, 443));
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      return localDefaultHttpClient;
    }
    catch (Exception localException) {}
    return new DefaultHttpClient();
  }
  
  public Socket createSocket()
  {
    return this.sslContext.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public void fixHttpsURLConnection()
  {
    HttpsURLConnection.setDefaultSSLSocketFactory(this.sslContext.getSocketFactory());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.MySSLSocketFactory
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */