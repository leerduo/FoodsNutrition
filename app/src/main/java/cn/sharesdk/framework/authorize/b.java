package cn.sharesdk.framework.authorize;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import cn.sharesdk.framework.m;

public abstract class b
  extends m
{
  protected g a;
  protected String b;
  protected AuthorizeListener c;
  
  public b(g paramg)
  {
    this.a = paramg;
    AuthorizeHelper localAuthorizeHelper = paramg.a();
    this.b = localAuthorizeHelper.getRedirectUri();
    this.c = localAuthorizeHelper.getAuthorizeListener();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView.stopLoading();
    AuthorizeListener localAuthorizeListener = this.a.a().getAuthorizeListener();
    this.a.finish();
    if (localAuthorizeListener != null) {
      localAuthorizeListener.onError(new Throwable(paramString1 + " (" + paramInt + "): " + paramString2));
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.proceed();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */