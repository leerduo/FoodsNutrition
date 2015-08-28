package com.android.volley.toolbox;

import com.android.volley.Request;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientStack
  implements HttpStack
{
  protected final HttpClient a;
  
  public HttpClientStack(HttpClient paramHttpClient)
  {
    this.a = paramHttpClient;
  }
  
  private static void a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, Request<?> paramRequest)
  {
    byte[] arrayOfByte = paramRequest.r();
    if (arrayOfByte != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(arrayOfByte));
    }
  }
  
  private static void a(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  static HttpUriRequest b(Request<?> paramRequest, Map<String, String> paramMap)
  {
    switch (paramRequest.a())
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case -1: 
      byte[] arrayOfByte = paramRequest.n();
      if (arrayOfByte != null)
      {
        HttpPost localHttpPost2 = new HttpPost(paramRequest.d());
        localHttpPost2.addHeader("Content-Type", paramRequest.m());
        localHttpPost2.setEntity(new ByteArrayEntity(arrayOfByte));
        return localHttpPost2;
      }
      return new HttpGet(paramRequest.d());
    case 0: 
      return new HttpGet(paramRequest.d());
    case 3: 
      return new HttpDelete(paramRequest.d());
    case 1: 
      HttpPost localHttpPost1 = new HttpPost(paramRequest.d());
      localHttpPost1.addHeader("Content-Type", paramRequest.q());
      a(localHttpPost1, paramRequest);
      return localHttpPost1;
    case 2: 
      HttpPut localHttpPut = new HttpPut(paramRequest.d());
      localHttpPut.addHeader("Content-Type", paramRequest.q());
      a(localHttpPut, paramRequest);
      return localHttpPut;
    case 4: 
      return new HttpHead(paramRequest.d());
    case 5: 
      return new HttpOptions(paramRequest.d());
    case 6: 
      return new HttpTrace(paramRequest.d());
    }
    HttpClientStack.HttpPatch localHttpPatch = new HttpClientStack.HttpPatch(paramRequest.d());
    localHttpPatch.addHeader("Content-Type", paramRequest.q());
    a(localHttpPatch, paramRequest);
    return localHttpPatch;
  }
  
  public HttpResponse a(Request<?> paramRequest, Map<String, String> paramMap)
  {
    HttpUriRequest localHttpUriRequest = b(paramRequest, paramMap);
    a(localHttpUriRequest, paramMap);
    a(localHttpUriRequest, paramRequest.j());
    a(localHttpUriRequest);
    HttpParams localHttpParams = localHttpUriRequest.getParams();
    int i = paramRequest.u();
    HttpConnectionParams.setConnectionTimeout(localHttpParams, 5000);
    HttpConnectionParams.setSoTimeout(localHttpParams, i);
    return this.a.execute(localHttpUriRequest);
  }
  
  protected void a(HttpUriRequest paramHttpUriRequest) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.HttpClientStack
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */