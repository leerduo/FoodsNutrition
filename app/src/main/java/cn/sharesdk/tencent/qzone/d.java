package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.authorize.g;
import java.net.URLDecoder;
import java.util.HashMap;

public class d
  extends b
{
  public d(g paramg)
  {
    super(paramg);
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    String str1 = (String)paramHashMap.get("access_token");
    String str2 = (String)paramHashMap.get("expires_in");
    String str3 = (String)paramHashMap.get("error");
    String str4 = (String)paramHashMap.get("error_description");
    if ((str1 != null) && (str1.trim().length() > 0))
    {
      HashMap localHashMap;
      try
      {
        localHashMap = f.a(this.a.a().getPlatform()).e(str1);
        if ((localHashMap == null) || (localHashMap.size() <= 0))
        {
          if (this.c == null) {
            return;
          }
          this.c.onError(new Throwable());
          return;
        }
        if (localHashMap.containsKey("openid")) {
          break label169;
        }
        if (this.c == null) {
          return;
        }
        this.c.onError(new Throwable());
        return;
      }
      catch (Throwable localThrowable)
      {
        if (this.c == null) {
          return;
        }
      }
      this.c.onError(localThrowable);
      return;
      label169:
      Bundle localBundle = new Bundle();
      localBundle.putString("access_token", str1);
      localBundle.putString("open_id", String.valueOf(localHashMap.get("openid")));
      localBundle.putString("expires_in", str2);
      if (this.c != null) {
        this.c.onComplete(localBundle);
      }
    }
    else if ((str3 != null) && (str3.trim().length() > 0))
    {
      String str5 = str4 + " (" + str3 + ")";
      if (this.c != null) {
        this.c.onError(new Throwable(str5));
      }
    }
    else
    {
      this.c.onError(new Throwable());
    }
  }
  
  protected void a(String paramString)
  {
    if (paramString.startsWith(this.b)) {
      paramString = paramString.substring(1 + paramString.indexOf('#'));
    }
    String[] arrayOfString1 = paramString.split("&");
    HashMap localHashMap = new HashMap();
    int i = arrayOfString1.length;
    int j = 0;
    while (j < i)
    {
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length < 2)
      {
        localHashMap.put(URLDecoder.decode(arrayOfString2[0]), "");
        j++;
      }
      else
      {
        String str1 = URLDecoder.decode(arrayOfString2[0]);
        if (arrayOfString2[1] == null) {}
        for (String str2 = "";; str2 = arrayOfString2[1])
        {
          localHashMap.put(str1, URLDecoder.decode(str2));
          break;
        }
      }
    }
    a(localHashMap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith(this.b))
    {
      paramWebView.setVisibility(4);
      paramWebView.stopLoading();
      this.a.finish();
      new e(this, paramString).start();
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */