package com.umeng.analytics;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

final class MobclickAgentJSInterface$a
  extends WebChromeClient
{
  WebChromeClient a = null;
  private final String c = "ekv";
  private final String d = "event";
  
  public MobclickAgentJSInterface$a(MobclickAgentJSInterface paramMobclickAgentJSInterface, WebChromeClient paramWebChromeClient)
  {
    if (paramWebChromeClient == null)
    {
      this.a = new WebChromeClient();
      return;
    }
    this.a = paramWebChromeClient;
  }
  
  public void onCloseWindow(WebView paramWebView)
  {
    this.a.onCloseWindow(paramWebView);
  }
  
  public boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    return this.a.onCreateWindow(paramWebView, paramBoolean1, paramBoolean2, paramMessage);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    JSONObject localJSONObject2;
    HashMap localHashMap;
    String str2;
    int i;
    if ("ekv".equals(paramString2)) {
      try
      {
        localJSONObject2 = new JSONObject(paramString3);
        localHashMap = new HashMap();
        str2 = (String)localJSONObject2.remove("id");
        if (localJSONObject2.isNull("duration"))
        {
          i = 0;
          Iterator localIterator = localJSONObject2.keys();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            localHashMap.put(str3, localJSONObject2.getString(str3));
            continue;
            paramJsPromptResult.confirm();
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    for (;;)
    {
      return true;
      i = ((Integer)localJSONObject2.remove("duration")).intValue();
      break;
      MobclickAgent.getAgent().a(MobclickAgentJSInterface.a(this.b), str2, localHashMap, i);
      continue;
      if (!"event".equals(paramString2)) {
        break label237;
      }
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString3);
        String str1 = localJSONObject1.optString("label");
        if ("".equals(str1)) {
          str1 = null;
        }
        MobclickAgent.getAgent().a(MobclickAgentJSInterface.a(this.b), localJSONObject1.getString("tag"), str1, localJSONObject1.optInt("duration"), 1);
      }
      catch (Exception localException1) {}
    }
    label237:
    return this.a.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    this.a.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap)
  {
    this.a.onReceivedIcon(paramWebView, paramBitmap);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.onReceivedTitle(paramWebView, paramString);
  }
  
  public void onRequestFocus(WebView paramWebView)
  {
    this.a.onRequestFocus(paramWebView);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.MobclickAgentJSInterface.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */