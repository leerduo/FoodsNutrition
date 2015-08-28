package com.android.volley.toolbox;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class HttpClientStack$HttpPatch
  extends HttpEntityEnclosingRequestBase
{
  public HttpClientStack$HttpPatch() {}
  
  public HttpClientStack$HttpPatch(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public String getMethod()
  {
    return "PATCH";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.HttpClientStack.HttpPatch
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */