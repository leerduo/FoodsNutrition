package com.google.zxing.client.androidlegacy;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

final class HelpActivity$HelpClient
  extends WebViewClient
{
  private HelpActivity$HelpClient(HelpActivity paramHelpActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.setTitle(paramWebView.getTitle());
    HelpActivity.b(this.a).setEnabled(paramWebView.canGoBack());
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith("file")) {
      return false;
    }
    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.HelpActivity.HelpClient
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */