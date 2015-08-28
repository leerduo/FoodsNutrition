package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.network.k;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class f
  extends cn.sharesdk.framework.h
{
  private static final String[] b = { "get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t" };
  private static f c;
  private String d;
  private String e;
  private String f;
  private k g = k.a();
  private String[] h;
  
  private f(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static f a(Platform paramPlatform)
  {
    if (c == null) {
      c = new f(paramPlatform);
    }
    return c;
  }
  
  private String a()
  {
    int i = 0;
    if (this.h == null) {}
    StringBuilder localStringBuilder;
    for (String[] arrayOfString = b;; arrayOfString = this.h)
    {
      localStringBuilder = new StringBuilder();
      int j = arrayOfString.length;
      int k = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (k > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(str);
        k++;
        i++;
      }
    }
    return localStringBuilder.toString();
  }
  
  private String b()
  {
    try
    {
      String str = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      return str;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b(localThrowable);
    }
    return "0";
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    localArrayList1.add(new cn.sharesdk.framework.network.f("oauth_consumer_key", this.d));
    localArrayList1.add(new cn.sharesdk.framework.network.f("openid", this.e));
    localArrayList1.add(new cn.sharesdk.framework.network.f("format", "json"));
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2.length() > 200) {
        paramString2 = paramString2.substring(0, 199) + "…";
      }
      localArrayList1.add(new cn.sharesdk.framework.network.f("photodesc", paramString2));
    }
    localArrayList1.add(new cn.sharesdk.framework.network.f("mobile", "1"));
    cn.sharesdk.framework.network.f localf = new cn.sharesdk.framework.network.f("picture", paramString1);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    String str = this.g.a("https://graph.qq.com/photo/upload_pic", localArrayList1, localf, localArrayList2, "/photo/upload_pic", c());
    if ((str != null) && (str.length() > 0)) {
      return new cn.sharesdk.framework.utils.d().a(str);
    }
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator2 = paramHashMap.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        localArrayList1.add(new cn.sharesdk.framework.network.f((String)localEntry2.getKey(), String.valueOf(localEntry2.getValue())));
      }
    }
    localArrayList1.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    localArrayList1.add(new cn.sharesdk.framework.network.f("oauth_consumer_key", this.d));
    localArrayList1.add(new cn.sharesdk.framework.network.f("openid", this.e));
    localArrayList1.add(new cn.sharesdk.framework.network.f("format", "json"));
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
      for (;;)
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        try
        {
          String str2;
          if ("GET".equals(paramString2.toUpperCase())) {
            str2 = new cn.sharesdk.framework.network.i().a(paramString1, localArrayList1, localArrayList2, null);
          }
          String str1;
          for (Object localObject = str2; (localObject != null) && (((String)localObject).length() > 0); localObject = str1)
          {
            return new cn.sharesdk.framework.utils.d().a((String)localObject);
            if (!"POST".equals(paramString2.toUpperCase())) {
              break label410;
            }
            str1 = new cn.sharesdk.framework.network.i().a(paramString1, localArrayList1, localf1, localArrayList2, null);
          }
          label410:
          localf1 = null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cn.sharesdk.framework.utils.e.c(localThrowable);
            localObject = null;
          }
        }
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
    a(new g(this, paramAuthorizeListener));
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, PlatformActionListener paramPlatformActionListener)
  {
    String[] arrayOfString = b().split("\\.");
    int[] arrayOfInt = new int[arrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < arrayOfInt.length) {
        try
        {
          arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
          i++;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cn.sharesdk.framework.utils.e.c(localThrowable);
            arrayOfInt[i] = 0;
          }
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://share/to_qzone?");
    localStringBuilder.append("src_type=app&");
    localStringBuilder.append("version=1&");
    localStringBuilder.append("file_type=news&");
    if (!TextUtils.isEmpty(paramString4)) {
      localStringBuilder.append("image_url=").append(Base64.encodeToString(paramString4.getBytes("utf-8"), 2)).append("&");
    }
    localStringBuilder.append("title=").append(Base64.encodeToString(paramString1.getBytes("utf-8"), 2)).append("&");
    localStringBuilder.append("description=").append(Base64.encodeToString(paramString3.getBytes("utf-8"), 2)).append("&");
    localStringBuilder.append("app_name=").append(Base64.encodeToString(paramString5.getBytes("utf-8"), 2)).append("&");
    localStringBuilder.append("open_id=&");
    localStringBuilder.append("share_id=").append(this.d).append("&");
    localStringBuilder.append("url=").append(Base64.encodeToString(paramString2.getBytes("utf-8"), 2)).append("&");
    localStringBuilder.append("req_type=MQ==&");
    if ((arrayOfInt.length > 1) && (arrayOfInt[1] >= 5)) {}
    for (String str = "1";; str = "0")
    {
      localStringBuilder.append("cflag=").append(Base64.encodeToString(str.getBytes("utf-8"), 2));
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      if (this.a.getContext().getPackageManager().resolveActivity(localIntent, 1) != null) {
        break;
      }
      b(paramString1, paramString2, paramString3, paramString4, paramString5, paramPlatformActionListener);
      return;
    }
    i locali = new i();
    locali.a(localStringBuilder.toString(), true);
    locali.a(paramPlatformActionListener);
    locali.a(this.d);
    locali.show(this.a.getContext(), null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, PlatformActionListener paramPlatformActionListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new Throwable("titleUrl is needed");
    }
    if (TextUtils.isEmpty(paramString3)) {
      throw new Throwable("text is needed");
    }
    if (paramString1.length() > 200) {
      paramString1 = paramString1.substring(0, 200);
    }
    if (paramString3.length() > 600) {}
    for (String str1 = paramString3.substring(0, 600);; str1 = paramString3)
    {
      if (TextUtils.isEmpty(paramString5)) {
        paramString5 = cn.sharesdk.framework.utils.b.a(this.a.getContext()).r();
      }
      if (paramString5.length() > 20) {}
      for (String str2 = paramString5.substring(0, 20) + "...";; str2 = paramString5)
      {
        String str3;
        if (TextUtils.isEmpty(paramString1))
        {
          int i = R.getStringRes(this.a.getContext(), "share_to_qzone_default");
          if (i > 0) {
            str3 = this.a.getContext().getString(i, new Object[] { str2 });
          }
        }
        for (;;)
        {
          if (paramBoolean)
          {
            a(str3, paramString2, str1, paramString4, str2, paramPlatformActionListener);
            return;
            str3 = str2;
          }
          else
          {
            b(str3, paramString2, str1, paramString4, str2, paramPlatformActionListener);
            return;
            str3 = paramString1;
          }
        }
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.h = paramArrayOfString;
  }
  
  public HashMap<String, Object> b(String paramString1, String paramString2)
  {
    int i;
    String str1;
    label18:
    String str2;
    ArrayList localArrayList;
    String str3;
    if (!TextUtils.isEmpty(paramString1))
    {
      i = 1;
      if (i == 0) {
        break label238;
      }
      str1 = "/t/add_pic_t";
      str2 = "https://graph.qq.com" + str1;
      localArrayList = new ArrayList();
      localArrayList.add(new cn.sharesdk.framework.network.f("oauth_consumer_key", this.d));
      localArrayList.add(new cn.sharesdk.framework.network.f("access_token", this.f));
      localArrayList.add(new cn.sharesdk.framework.network.f("openid", this.e));
      localArrayList.add(new cn.sharesdk.framework.network.f("format", "json"));
      localArrayList.add(new cn.sharesdk.framework.network.f("content", paramString2));
      if (i == 0) {
        break label246;
      }
      cn.sharesdk.framework.network.f localf = new cn.sharesdk.framework.network.f("pic", paramString1);
      str3 = this.g.a(str2, localArrayList, localf, str1, c());
    }
    for (;;)
    {
      if ((str3 != null) && (str3.length() > 0))
      {
        HashMap localHashMap = new cn.sharesdk.framework.utils.d().a(str3);
        if (((Integer)localHashMap.get("ret")).intValue() != 0)
        {
          throw new Throwable(str3);
          i = 0;
          break;
          label238:
          str1 = "/t/add_t";
          break label18;
          label246:
          str3 = this.g.b(str2, localArrayList, str1, c());
          continue;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, PlatformActionListener paramPlatformActionListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://openmobile.qq.com/api/check2?");
    localStringBuilder.append("page=qzshare.html&");
    localStringBuilder.append("loginpage=loginindex.html&");
    localStringBuilder.append("logintype=qzone&");
    localStringBuilder.append("action=shareToQQ&");
    localStringBuilder.append("sdkv=2.6&");
    localStringBuilder.append("sdkp=a&");
    cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.a.getContext());
    localStringBuilder.append("status_os=").append(a.c(localb.j(), "utf-8")).append("&");
    localStringBuilder.append("status_machine=").append(a.c(localb.b(), "utf-8")).append("&");
    localStringBuilder.append("status_version=").append(a.c(localb.i(), "utf-8")).append("&");
    localStringBuilder.append("appId=").append(this.d).append("&");
    String str = localb.r();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append("appName=").append(a.c(str, "utf-8")).append("&");
    }
    for (;;)
    {
      if (paramString1.length() > 40) {
        paramString1 = paramString1.substring(40) + "...";
      }
      localStringBuilder.append("title=").append(a.c(paramString1, "utf-8")).append("&");
      if (paramString1.length() > 80) {
        new StringBuilder().append(paramString1.substring(80)).append("...").toString();
      }
      localStringBuilder.append("summary=").append(a.c(paramString3, "utf-8")).append("&");
      localStringBuilder.append("targeturl=").append(a.c(paramString2, "utf-8")).append("&");
      if (!TextUtils.isEmpty(paramString4)) {
        localStringBuilder.append("imageUrl=").append(a.c(paramString4, "utf-8")).append("&");
      }
      localStringBuilder.append("site=").append(a.c(paramString5, "utf-8")).append("&");
      localStringBuilder.append("type=1");
      i locali = new i();
      locali.a(localStringBuilder.toString(), false);
      locali.a(paramPlatformActionListener);
      locali.a(this.d);
      locali.show(this.a.getContext(), null);
      return;
      localStringBuilder.append("appName=").append(a.c(paramString5, "utf-8")).append("&");
    }
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new cn.sharesdk.framework.network.f("access_token", this.f));
    localArrayList1.add(new cn.sharesdk.framework.network.f("oauth_consumer_key", this.d));
    localArrayList1.add(new cn.sharesdk.framework.network.f("openid", this.e));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    String str = this.g.a("https://graph.qq.com/user/get_simple_userinfo", localArrayList1, localArrayList2, null, "/user/get_simple_userinfo", c());
    HashMap localHashMap = null;
    if (str != null)
    {
      int i = str.length();
      localHashMap = null;
      if (i > 0) {
        localHashMap = new cn.sharesdk.framework.utils.d().a(str);
      }
    }
    return localHashMap;
  }
  
  public HashMap<String, Object> e(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new cn.sharesdk.framework.network.f("access_token", paramString));
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new cn.sharesdk.framework.network.f("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    String str = this.g.a("https://graph.qq.com/oauth2.0/me", localArrayList1, localArrayList2, null, "/oauth2.0/me", c());
    if (str.startsWith("callback"))
    {
      while ((!str.startsWith("{")) && (str.length() > 0)) {
        str = str.substring(1);
      }
      while ((!str.endsWith("}")) && (str.length() > 0)) {
        str = str.substring(0, -1 + str.length());
      }
    }
    HashMap localHashMap = null;
    if (str != null)
    {
      int i = str.length();
      localHashMap = null;
      if (i > 0) {
        localHashMap = new cn.sharesdk.framework.utils.d().a(str);
      }
    }
    return localHashMap;
  }
  
  public String getAuthorizeUrl()
  {
    ShareSDK.logApiEvent("/oauth2.0/authorize", c());
    String str1 = a();
    String str2 = getRedirectUri();
    try
    {
      String str4 = a.c(str2, "utf-8");
      str3 = str4;
      return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.d + "&" + "redirect_uri=" + str3 + "&" + "display=mobile&" + "scope=" + str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        String str3 = getRedirectUri();
      }
    }
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g paramg)
  {
    return new d(paramg);
  }
  
  public String getRedirectUri()
  {
    return "auth://tauth.qq.com/";
  }
  
  public cn.sharesdk.framework.authorize.f getSSOProcessor(cn.sharesdk.framework.authorize.e parame)
  {
    h localh = new h(parame);
    localh.a(5656);
    localh.a(this.d, a());
    return localh;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */