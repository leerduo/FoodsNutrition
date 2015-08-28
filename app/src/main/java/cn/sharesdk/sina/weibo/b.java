package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.R;

public class b
  extends cn.sharesdk.framework.authorize.b
{
  private boolean d;
  
  public b(g paramg)
  {
    super(paramg);
  }
  
  private void a(Platform paramPlatform, String paramString)
  {
    new c(this, paramPlatform, paramString).start();
  }
  
  private Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString));
    localIntent.putExtra("sms_body", "");
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  protected void a(String paramString)
  {
    if (this.d) {}
    Bundle localBundle;
    String str1;
    String str2;
    do
    {
      return;
      this.d = true;
      localBundle = R.urlToBundle(paramString);
      str1 = localBundle.getString("error");
      str2 = localBundle.getString("error_code");
    } while (this.c == null);
    if ((str1 == null) && (str2 == null))
    {
      String str4 = localBundle.getString("code");
      if (TextUtils.isEmpty(str4)) {
        this.c.onError(new Throwable("Authorize code is empty"));
      }
      a(this.a.a().getPlatform(), str4);
      return;
    }
    if (str1.equals("access_denied"))
    {
      this.c.onCancel();
      return;
    }
    int i = Integer.parseInt(str2);
    String str3 = str1 + " (" + i + ")";
    this.c.onError(new Throwable(str3));
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(this.b)) && (paramString.startsWith(this.b)))
    {
      paramWebView.stopLoading();
      this.a.finish();
      a(paramString);
    }
    do
    {
      return;
      if (!paramString.startsWith("sms:")) {
        break;
      }
      String str = paramString.substring(4);
      try
      {
        Intent localIntent2 = b(str);
        localIntent2.setPackage("com.android.mms");
        paramWebView.getContext().startActivity(localIntent2);
        return;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Intent localIntent1 = b(str);
          paramWebView.getContext().startActivity(localIntent1);
          return;
        }
        catch (Throwable localThrowable2) {}
      }
    } while (this.c == null);
    this.c.onError(localThrowable2);
    return;
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(this.b)) && (paramString.startsWith(this.b)))
    {
      paramWebView.stopLoading();
      this.a.finish();
      a(paramString);
    }
    do
    {
      return true;
      if (!paramString.startsWith("sms:")) {
        break;
      }
      String str = paramString.substring(4);
      try
      {
        Intent localIntent2 = b(str);
        localIntent2.setPackage("com.android.mms");
        paramWebView.getContext().startActivity(localIntent2);
        return true;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Intent localIntent1 = b(str);
          paramWebView.getContext().startActivity(localIntent1);
          return true;
        }
        catch (Throwable localThrowable2) {}
      }
    } while (this.c == null);
    this.c.onError(localThrowable2);
    return true;
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.sina.weibo.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */