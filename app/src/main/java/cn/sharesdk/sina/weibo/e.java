package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.h;
import cn.sharesdk.framework.network.i;
import cn.sharesdk.framework.network.k;
import cn.sharesdk.framework.utils.BitmapHelper;
import cn.sharesdk.framework.utils.R;
import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends h
{
  private static e b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String[] g;
  private k h = k.a();
  
  private e(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static e a(Platform paramPlatform)
  {
    try
    {
      if (b == null) {
        b = new e(paramPlatform);
      }
      e locale = b;
      return locale;
    }
    finally {}
  }
  
  private HashMap<String, Object> a(String paramString, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    localArrayList.add(new cn.sharesdk.framework.network.f("status", paramString));
    localArrayList.add(new cn.sharesdk.framework.network.f("long", String.valueOf(paramFloat1)));
    localArrayList.add(new cn.sharesdk.framework.network.f("lat", String.valueOf(paramFloat2)));
    String str = this.h.b("https://api.weibo.com/2/statuses/update.json", localArrayList, "/2/statuses/update.json", c());
    if (str != null) {
      return new cn.sharesdk.framework.utils.d().a(str);
    }
    return null;
  }
  
  private HashMap<String, Object> a(String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    localArrayList.add(new cn.sharesdk.framework.network.f("status", paramString1));
    localArrayList.add(new cn.sharesdk.framework.network.f("long", String.valueOf(paramFloat1)));
    localArrayList.add(new cn.sharesdk.framework.network.f("lat", String.valueOf(paramFloat2)));
    localArrayList.add(new cn.sharesdk.framework.network.f("url", paramString2));
    String str = this.h.b("https://api.weibo.com/2/statuses/upload_url_text.json", localArrayList, "/2/statuses/upload_url_text.json", c());
    if (str != null) {
      return new cn.sharesdk.framework.utils.d().a(str);
    }
    return null;
  }
  
  private HashMap<String, Object> b(String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    localArrayList.add(new cn.sharesdk.framework.network.f("status", paramString2));
    localArrayList.add(new cn.sharesdk.framework.network.f("long", String.valueOf(paramFloat1)));
    localArrayList.add(new cn.sharesdk.framework.network.f("lat", String.valueOf(paramFloat2)));
    cn.sharesdk.framework.network.f localf = new cn.sharesdk.framework.network.f("pic", paramString1);
    String str = this.h.a("https://api.weibo.com/2/statuses/upload.json", localArrayList, localf, "/2/statuses/upload.json", c());
    if (str != null) {
      return new cn.sharesdk.framework.utils.d().a(str);
    }
    return null;
  }
  
  public String a(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("client_id", this.c));
    localArrayList.add(new cn.sharesdk.framework.network.f("client_secret", this.d));
    localArrayList.add(new cn.sharesdk.framework.network.f("redirect_uri", this.e));
    localArrayList.add(new cn.sharesdk.framework.network.f("grant_type", "authorization_code"));
    localArrayList.add(new cn.sharesdk.framework.network.f("code", paramString));
    String str = this.h.b("https://api.weibo.com/oauth2/access_token", localArrayList, "/oauth2/access_token", c());
    ShareSDK.logApiEvent("/oauth2/access_token", c());
    return str;
  }
  
  public HashMap<String, Object> a(int paramInt1, int paramInt2, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    int i = 1;
    try
    {
      Long.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new cn.sharesdk.framework.network.f("uid", paramString));
        localArrayList.add(new cn.sharesdk.framework.network.f("count", String.valueOf(paramInt1)));
        localArrayList.add(new cn.sharesdk.framework.network.f("page", String.valueOf(paramInt2)));
        String str = this.h.a("https://api.weibo.com/2/statuses/user_timeline.json", localArrayList, "/2/statuses/user_timeline.json", c());
        if (str == null) {
          break label159;
        }
        return new cn.sharesdk.framework.utils.d().a(str);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new cn.sharesdk.framework.network.f("screen_name", paramString));
      }
    }
    label159:
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      throw new Throwable("weibo content can not be null!");
    }
    if (!TextUtils.isEmpty(paramString3)) {
      return b(paramString3, paramString1, paramFloat1, paramFloat2);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      return a(paramString1, paramString2, paramFloat1, paramFloat2);
    }
    return a(paramString1, paramFloat1, paramFloat2);
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator2 = paramHashMap.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        localArrayList.add(new cn.sharesdk.framework.network.f((String)localEntry2.getKey(), String.valueOf(localEntry2.getValue())));
      }
    }
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    if (this.f != null) {
      localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    }
    cn.sharesdk.framework.network.f localf1;
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      Iterator localIterator1 = paramHashMap1.entrySet().iterator();
      Map.Entry localEntry1;
      for (cn.sharesdk.framework.network.f localf2 = null; localIterator1.hasNext(); localf2 = new cn.sharesdk.framework.network.f((String)localEntry1.getKey(), localEntry1.getValue())) {
        localEntry1 = (Map.Entry)localIterator1.next();
      }
      localf1 = localf2;
    }
    for (;;)
    {
      try
      {
        Object localObject;
        if ("GET".equals(paramString2.toUpperCase()))
        {
          String str2 = new i().a(paramString1, localArrayList, null, null);
          localObject = str2;
          if ((localObject == null) || (((String)localObject).length() <= 0)) {
            break;
          }
          return new cn.sharesdk.framework.utils.d().a((String)localObject);
        }
        if ("POST".equals(paramString2.toUpperCase()))
        {
          String str1 = new i().a(paramString1, localArrayList, localf1, null, null);
          localObject = str1;
        }
        else
        {
          localf1 = null;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        localObject = null;
      }
    }
  }
  
  public void a(AuthorizeListener paramAuthorizeListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramAuthorizeListener);
      return;
    }
    a(new f(this, paramAuthorizeListener));
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString2)))
    {
      File localFile3 = new File(BitmapHelper.downloadBitmap(this.a.getContext(), paramString2));
      if (localFile3.exists()) {
        paramString3 = localFile3.getAbsolutePath();
      }
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.TEXT", paramString1);
    File localFile1;
    File localFile2;
    if (!TextUtils.isEmpty(paramString3))
    {
      localFile1 = new File(paramString3);
      if (localFile1.exists())
      {
        if (!paramString3.startsWith("/data/")) {
          break label270;
        }
        localFile2 = new File(R.getCachePath(this.a.getContext(), "images"), System.currentTimeMillis() + localFile1.getName());
        String str1 = localFile2.getAbsolutePath();
        localFile2.createNewFile();
        if (!R.copyFile(paramString3, str1)) {
          break label270;
        }
      }
    }
    for (;;)
    {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(localFile2));
      String str2 = URLConnection.getFileNameMap().getContentTypeFor(paramString3);
      if ((str2 == null) || (str2.length() <= 0)) {
        str2 = "image/*";
      }
      localIntent.setType(str2);
      for (;;)
      {
        localIntent.setClassName("com.sina.weibo", "com.sina.weibo.EditActivity");
        localIntent.addFlags(268435456);
        this.a.getContext().startActivity(localIntent);
        return;
        localIntent.setType("text/plain");
      }
      label270:
      localFile2 = localFile1;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.g = paramArrayOfString;
  }
  
  public boolean a()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setPackage("com.sina.weibo");
    localIntent.setType("image/*");
    ResolveInfo localResolveInfo = this.a.getContext().getPackageManager().resolveActivity(localIntent, 0);
    boolean bool = false;
    if (localResolveInfo != null) {
      bool = true;
    }
    return bool;
  }
  
  public HashMap<String, Object> b(int paramInt1, int paramInt2, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    if (this.f != null) {
      localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    }
    int i = 1;
    try
    {
      Long.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new cn.sharesdk.framework.network.f("uid", paramString));
        localArrayList.add(new cn.sharesdk.framework.network.f("count", String.valueOf(paramInt1)));
        localArrayList.add(new cn.sharesdk.framework.network.f("cursor", String.valueOf(paramInt2 * paramInt1)));
        String str = this.h.a("https://api.weibo.com/2/friendships/friends.json", localArrayList, "/2/friendships/friends.json", c());
        if (str == null) {
          break label190;
        }
        return new cn.sharesdk.framework.utils.d().a(str);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new cn.sharesdk.framework.network.f("screen_name", paramString));
      }
    }
    label190:
    return null;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    if (this.f != null) {
      localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    }
    int i = 1;
    try
    {
      Long.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new cn.sharesdk.framework.network.f("uid", paramString));
        String str = this.h.a("https://api.weibo.com/2/users/show.json", localArrayList, "/2/users/show.json", c());
        if (str == null) {
          break label143;
        }
        return new cn.sharesdk.framework.utils.d().a(str);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new cn.sharesdk.framework.network.f("screen_name", paramString));
      }
    }
    label143:
    return null;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("source", this.c));
    localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    int i = 1;
    try
    {
      Long.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new cn.sharesdk.framework.network.f("uid", paramString));
        String str = this.h.b("https://api.weibo.com/2/friendships/create.json", localArrayList, "/2/friendships/create.json", c());
        if (str == null) {
          break label136;
        }
        return new cn.sharesdk.framework.utils.d().a(str);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new cn.sharesdk.framework.network.f("screen_name", paramString));
      }
    }
    label136:
    return null;
  }
  
  public String getAuthorizeUrl()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cn.sharesdk.framework.network.f("client_id", this.c));
    localArrayList.add(new cn.sharesdk.framework.network.f("response_type", "code"));
    localArrayList.add(new cn.sharesdk.framework.network.f("redirect_uri", this.e));
    if ((this.g != null) && (this.g.length > 0)) {
      localArrayList.add(new cn.sharesdk.framework.network.f("scope", TextUtils.join(",", this.g)));
    }
    localArrayList.add(new cn.sharesdk.framework.network.f("display", "mobile"));
    String str = "https://api.weibo.com/oauth2/authorize?" + R.encodeUrl(localArrayList);
    ShareSDK.logApiEvent("/oauth2/authorize", c());
    return str;
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(g paramg)
  {
    return new b(paramg);
  }
  
  public String getRedirectUri()
  {
    if (TextUtils.isEmpty(this.e)) {
      return "https://api.weibo.com/oauth2/default.html";
    }
    return this.e;
  }
  
  public cn.sharesdk.framework.authorize.f getSSOProcessor(cn.sharesdk.framework.authorize.e parame)
  {
    d locald = new d(parame);
    locald.a(32973);
    locald.a(this.c, this.e, new String[0]);
    return locald;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.sina.weibo.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */