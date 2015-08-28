package cn.sharesdk.tencent.qzone;

import android.webkit.WebView;
import cn.sharesdk.framework.m;

class l
  extends m
{
  l(i parami) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString != null) && (paramString.startsWith(i.b(this.a)))) {
      i.a(this.a, paramString);
    }
    for (;;)
    {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
      if ((paramString != null) && (paramString.startsWith("mqzone://"))) {
        i.b(this.a, paramString);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */