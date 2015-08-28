package com.umeng.analytics;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MobclickAgentJSInterface
{
  private Context a;
  
  public MobclickAgentJSInterface(Context paramContext, WebView paramWebView)
  {
    this.a = paramContext;
    paramWebView.getSettings().setJavaScriptEnabled(true);
    paramWebView.setWebChromeClient(new MobclickAgentJSInterface.a(this, null));
  }
  
  public MobclickAgentJSInterface(Context paramContext, WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    this.a = paramContext;
    paramWebView.getSettings().setJavaScriptEnabled(true);
    paramWebView.setWebChromeClient(new MobclickAgentJSInterface.a(this, paramWebChromeClient));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.MobclickAgentJSInterface
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */