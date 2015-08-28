package com.google.zxing.client.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public final class HelpActivity
  extends Activity
{
  private WebView a;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.zxing_help);
    this.a = ((WebView)findViewById(R.id.zxing_help_contents));
    if (paramBundle == null)
    {
      this.a.loadUrl("file:///android_asset/zxing/html-en/index.html");
      return;
    }
    this.a.restoreState(paramBundle);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.a.canGoBack()))
    {
      this.a.goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.HelpActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */