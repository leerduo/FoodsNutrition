package com.loopj.android.http;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class AsyncHttpClient$2
  implements HttpResponseInterceptor
{
  AsyncHttpClient$2(AsyncHttpClient paramAsyncHttpClient) {}
  
  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    if (localHttpEntity == null) {}
    for (;;)
    {
      return;
      Header localHeader = localHttpEntity.getContentEncoding();
      if (localHeader != null)
      {
        HeaderElement[] arrayOfHeaderElement = localHeader.getElements();
        int i = arrayOfHeaderElement.length;
        for (int j = 0; j < i; j++) {
          if (arrayOfHeaderElement[j].getName().equalsIgnoreCase("gzip"))
          {
            paramHttpResponse.setEntity(new AsyncHttpClient.InflatingEntity(localHttpEntity));
            return;
          }
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.AsyncHttpClient.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */