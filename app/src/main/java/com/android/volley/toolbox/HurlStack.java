package com.android.volley.toolbox;

import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class HurlStack
  implements HttpStack
{
  private final HurlStack.UrlRewriter a;
  private final SSLSocketFactory b;
  
  public HurlStack()
  {
    this(null);
  }
  
  public HurlStack(HurlStack.UrlRewriter paramUrlRewriter)
  {
    this(paramUrlRewriter, null);
  }
  
  public HurlStack(HurlStack.UrlRewriter paramUrlRewriter, SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paramUrlRewriter;
    this.b = paramSSLSocketFactory;
  }
  
  private HttpURLConnection a(URL paramURL, Request<?> paramRequest)
  {
    HttpURLConnection localHttpURLConnection = a(paramURL);
    int i = paramRequest.u();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(paramURL.getProtocol())) && (this.b != null)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.b);
    }
    return localHttpURLConnection;
  }
  
  private static HttpEntity a(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream2 = paramHttpURLConnection.getInputStream();
      localInputStream1 = localInputStream2;
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        InputStream localInputStream1 = paramHttpURLConnection.getErrorStream();
      }
    }
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
  {
    switch (paramRequest.a())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case -1: 
      byte[] arrayOfByte = paramRequest.n();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.addRequestProperty("Content-Type", paramRequest.m());
        DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
        localDataOutputStream.write(arrayOfByte);
        localDataOutputStream.close();
      }
      return;
    case 0: 
      paramHttpURLConnection.setRequestMethod("GET");
      return;
    case 3: 
      paramHttpURLConnection.setRequestMethod("DELETE");
      return;
    case 1: 
      paramHttpURLConnection.setRequestMethod("POST");
      b(paramHttpURLConnection, paramRequest);
      return;
    case 2: 
      paramHttpURLConnection.setRequestMethod("PUT");
      b(paramHttpURLConnection, paramRequest);
      return;
    case 4: 
      paramHttpURLConnection.setRequestMethod("HEAD");
      return;
    case 5: 
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      return;
    case 6: 
      paramHttpURLConnection.setRequestMethod("TRACE");
      return;
    }
    paramHttpURLConnection.setRequestMethod("PATCH");
    b(paramHttpURLConnection, paramRequest);
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
  {
    byte[] arrayOfByte = paramRequest.r();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", paramRequest.q());
      DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      localDataOutputStream.write(arrayOfByte);
      localDataOutputStream.close();
    }
  }
  
  protected HttpURLConnection a(URL paramURL)
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public HttpResponse a(Request<?> paramRequest, Map<String, String> paramMap)
  {
    String str1 = paramRequest.d();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramRequest.j());
    localHashMap.putAll(paramMap);
    String str2;
    if (this.a != null)
    {
      str2 = this.a.a(str1);
      if (str2 == null) {
        throw new IOException("URL blocked by rewriter: " + str1);
      }
    }
    else
    {
      str2 = str1;
    }
    HttpURLConnection localHttpURLConnection = a(new URL(str2), paramRequest);
    Iterator localIterator1 = localHashMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str3 = (String)localIterator1.next();
      localHttpURLConnection.addRequestProperty(str3, (String)localHashMap.get(str3));
    }
    a(localHttpURLConnection, paramRequest);
    ProtocolVersion localProtocolVersion = new ProtocolVersion("HTTP", 1, 1);
    if (localHttpURLConnection.getResponseCode() == -1) {
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }
    BasicHttpResponse localBasicHttpResponse = new BasicHttpResponse(new BasicStatusLine(localProtocolVersion, localHttpURLConnection.getResponseCode(), localHttpURLConnection.getResponseMessage()));
    localBasicHttpResponse.setEntity(a(localHttpURLConnection));
    Iterator localIterator2 = localHttpURLConnection.getHeaderFields().entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      if (localEntry.getKey() != null) {
        localBasicHttpResponse.addHeader(new BasicHeader((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0)));
      }
    }
    return localBasicHttpResponse;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.HurlStack
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */