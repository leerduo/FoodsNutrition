package com.loopj.android.http;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.HttpContext;

public class PreemtiveAuthorizationHttpRequestInterceptor
  implements HttpRequestInterceptor
{
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    AuthState localAuthState = (AuthState)paramHttpContext.getAttribute("http.auth.target-scope");
    CredentialsProvider localCredentialsProvider = (CredentialsProvider)paramHttpContext.getAttribute("http.auth.credentials-provider");
    HttpHost localHttpHost = (HttpHost)paramHttpContext.getAttribute("http.target_host");
    if (localAuthState.getAuthScheme() == null)
    {
      Credentials localCredentials = localCredentialsProvider.getCredentials(new AuthScope(localHttpHost.getHostName(), localHttpHost.getPort()));
      if (localCredentials != null)
      {
        localAuthState.setAuthScheme(new BasicScheme());
        localAuthState.setCredentials(localCredentials);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.PreemtiveAuthorizationHttpRequestInterceptor
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */