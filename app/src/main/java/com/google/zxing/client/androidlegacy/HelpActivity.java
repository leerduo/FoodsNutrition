package com.google.zxing.client.androidlegacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public final class HelpActivity
  extends Activity
{
  private WebView a;
  private Button b;
  private final View.OnClickListener c = new HelpActivity.1(this);
  private final View.OnClickListener d = new HelpActivity.2(this);
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.zxinglegacy_help);
    this.a = ((WebView)findViewById(R.id.zxinglegacy_help_contents));
    this.a.setWebViewClient(new HelpActivity.HelpClient(this, null));
    Intent localIntent = getIntent();
    if ((paramBundle != null) && (paramBundle.getBoolean("webview_state_present", false))) {
      this.a.restoreState(paramBundle);
    }
    for (;;)
    {
      this.b = ((Button)findViewById(R.id.zxinglegacy_back_button));
      this.b.setOnClickListener(this.c);
      findViewById(R.id.zxinglegacy_done_button).setOnClickListener(this.d);
      return;
      if (localIntent != null)
      {
        String str = localIntent.getStringExtra("requested_page_key");
        if ((str != null) && (str.length() > 0)) {
          this.a.loadUrl("file:///android_asset/zxinglegacy/html-en/" + str);
        } else {
          this.a.loadUrl("file:///android_asset/zxinglegacy/html-en/index.html");
        }
      }
      else
      {
        this.a.loadUrl("file:///android_asset/zxinglegacy/html-en/index.html");
      }
    }
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
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    String str = this.a.getUrl();
    if ((str != null) && (str.length() > 0))
    {
      this.a.saveState(paramBundle);
      paramBundle.putBoolean("webview_state_present", true);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.HelpActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */