package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.d;
import java.util.ArrayList;
import java.util.HashMap;

public class SinaWeibo
  extends Platform
{
  public static final String NAME = SinaWeibo.class.getSimpleName();
  private String a;
  private String b;
  private String c;
  private boolean d;
  
  public SinaWeibo(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    e locale = e.a(this);
    if ((paramInt == 9) && (this.d) && (locale.a())) {
      return true;
    }
    if (isValid())
    {
      locale.a(this.a, this.b);
      locale.b(this.db.getToken());
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    e locale = e.a(this);
    locale.a(this.a, this.b);
    locale.a(this.c);
    locale.a(paramArrayOfString);
    locale.a(new a(this, locale), isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    HashMap localHashMap;
    try
    {
      localHashMap = e.a(this).a(paramString1, paramString2, paramHashMap, paramHashMap1);
      if ((localHashMap == null) || (localHashMap.size() <= 0))
      {
        if (this.listener == null) {
          return;
        }
        this.listener.onError(this, paramInt, new Throwable());
        return;
      }
      if ((localHashMap.containsKey("error_code")) && (((Integer)localHashMap.get("error_code")).intValue() != 0))
      {
        if (this.listener == null) {
          return;
        }
        String str = new d().a(localHashMap);
        this.listener.onError(this, paramInt, new Throwable(str));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.listener.onError(this, paramInt, localThrowable);
      return;
    }
    if (this.listener != null) {
      this.listener.onComplete(this, paramInt, localHashMap);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    String str1 = paramShareParams.getText();
    int i;
    if (TextUtils.isEmpty(str1))
    {
      i = R.getStringRes(getContext(), "weibo_upload_content");
      if (i <= 0) {}
    }
    for (String str2 = getContext().getString(i);; str2 = str1)
    {
      e locale = e.a(this);
      String str3 = getShortLintk(str2, false);
      String str4 = paramShareParams.getImagePath();
      String str5 = paramShareParams.getImageUrl();
      if ((this.d) && (locale.a())) {}
      HashMap localHashMap1;
      do
      {
        do
        {
          for (;;)
          {
            try
            {
              locale.a(str3, str5, str4);
              HashMap localHashMap2 = new HashMap();
              localHashMap2.put("ShareParams", paramShareParams);
              if (this.listener != null) {
                this.listener.onComplete(this, 9, localHashMap2);
              }
              return;
            }
            catch (Throwable localThrowable2)
            {
              this.listener.onError(this, 9, localThrowable2);
              return;
            }
            try
            {
              float f = paramShareParams.getLatitude();
              localHashMap1 = locale.a(str3, str5, str4, paramShareParams.getLongitude(), f);
              if (localHashMap1 == null)
              {
                if (this.listener == null) {
                  continue;
                }
                this.listener.onError(this, 9, new Throwable());
              }
            }
            catch (Throwable localThrowable1)
            {
              this.listener.onError(this, 9, localThrowable1);
              return;
            }
          }
          if ((!localHashMap1.containsKey("error_code")) || (((Integer)localHashMap1.get("error_code")).intValue() == 0)) {
            break;
          }
        } while (this.listener == null);
        String str6 = new d().a(localHashMap1);
        this.listener.onError(this, 9, new Throwable(str6));
        return;
        localHashMap1.put("ShareParams", paramShareParams);
      } while (this.listener == null);
      this.listener.onComplete(this, 9, localHashMap1);
      return;
    }
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    if (paramHashMap != null)
    {
      locala.a = String.valueOf(paramHashMap.get("id"));
      locala.d.add(String.valueOf(paramHashMap.get("original_pic")));
      locala.g = paramHashMap;
    }
    return locala;
  }
  
  protected void follow(String paramString)
  {
    e locale = e.a(this);
    HashMap localHashMap;
    try
    {
      localHashMap = locale.d(paramString);
      if (localHashMap == null)
      {
        if (this.listener == null) {
          return;
        }
        this.listener.onError(this, 6, new Throwable());
        return;
      }
      if ((localHashMap.containsKey("error_code")) && (((Integer)localHashMap.get("error_code")).intValue() != 0))
      {
        if (this.listener == null) {
          return;
        }
        String str = new d().a(localHashMap);
        this.listener.onError(this, 6, new Throwable(str));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.listener.onError(this, 6, localThrowable);
      return;
    }
    if (this.listener != null) {
      this.listener.onComplete(this, 6, localHashMap);
    }
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = this.db.getUserId();
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = this.db.get("nickname");
    }
    if (TextUtils.isEmpty(paramString)) {
      if (this.listener != null) {
        this.listener.onError(this, 2, new RuntimeException("Both weibo id and screen_name are null"));
      }
    }
    HashMap localHashMap;
    do
    {
      do
      {
        for (;;)
        {
          return;
          e locale = e.a(this);
          try
          {
            localHashMap = locale.b(paramInt1, paramInt2, paramString);
            if (localHashMap == null)
            {
              if (this.listener == null) {
                continue;
              }
              this.listener.onError(this, 2, new Throwable());
            }
          }
          catch (Throwable localThrowable)
          {
            this.listener.onError(this, 2, localThrowable);
            return;
          }
        }
        if ((!localHashMap.containsKey("error_code")) || (((Integer)localHashMap.get("error_code")).intValue() == 0)) {
          break;
        }
      } while (this.listener == null);
      String str = new d().a(localHashMap);
      this.listener.onError(this, 2, new Throwable(str));
      return;
    } while (this.listener == null);
    this.listener.onComplete(this, 2, localHashMap);
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public int getPlatformId()
  {
    return 1;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppKey");
    this.b = getDevinfo("AppSecret");
    this.c = getDevinfo("RedirectUrl");
    this.d = "true".equals(getDevinfo("ShareByAppClient"));
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_key", "AppKey");
    this.b = getNetworkDevinfo("app_secret", "AppSecret");
    this.c = getNetworkDevinfo("redirect_uri", "RedirectUrl");
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = this.db.getUserId();
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = this.db.get("nickname");
    }
    if (TextUtils.isEmpty(paramString)) {
      if (this.listener != null) {
        this.listener.onError(this, 7, new RuntimeException("Both weibo id and screen_name are null"));
      }
    }
    HashMap localHashMap;
    do
    {
      do
      {
        for (;;)
        {
          return;
          e locale = e.a(this);
          try
          {
            localHashMap = locale.a(paramInt1, paramInt2, paramString);
            if (localHashMap == null)
            {
              if (this.listener == null) {
                continue;
              }
              this.listener.onError(this, 7, new Throwable());
            }
          }
          catch (Throwable localThrowable)
          {
            this.listener.onError(this, 7, localThrowable);
            return;
          }
        }
        if ((!localHashMap.containsKey("error_code")) || (((Integer)localHashMap.get("error_code")).intValue() == 0)) {
          break;
        }
      } while (this.listener == null);
      String str = new d().a(localHashMap);
      this.listener.onError(this, 7, new Throwable(str));
      return;
    } while (this.listener == null);
    this.listener.onComplete(this, 7, localHashMap);
  }
  
  protected void userInfor(String paramString)
  {
    int i = 1;
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 0;
    if (bool)
    {
      paramString = this.db.getUserId();
      j = i;
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = this.db.get("nickname");
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString)) {
        if (this.listener != null) {
          this.listener.onError(this, 8, new RuntimeException("Both weibo id and screen_name are null"));
        }
      }
      HashMap localHashMap;
      do
      {
        for (;;)
        {
          return;
          e locale = e.a(this);
          try
          {
            localHashMap = locale.c(paramString);
            if (localHashMap == null)
            {
              if (this.listener == null) {
                continue;
              }
              this.listener.onError(this, 8, new Throwable());
            }
          }
          catch (Throwable localThrowable)
          {
            this.listener.onError(this, 8, localThrowable);
            return;
          }
        }
        if ((!localHashMap.containsKey("error_code")) || (((Integer)localHashMap.get("error_code")).intValue() == 0)) {
          break;
        }
      } while (this.listener == null);
      String str2 = new d().a(localHashMap);
      this.listener.onError(this, 8, new Throwable(str2));
      return;
      label305:
      String str1;
      if (i != 0)
      {
        this.db.putUserId(String.valueOf(localHashMap.get("id")));
        this.db.put("nickname", String.valueOf(localHashMap.get("screen_name")));
        this.db.put("icon", String.valueOf(localHashMap.get("avatar_hd")));
        if (!String.valueOf(localHashMap.get("verified")).equals("true")) {
          break label540;
        }
        this.db.put("secretType", "1");
        this.db.put("secret", String.valueOf(localHashMap.get("verified_reason")));
        str1 = String.valueOf(localHashMap.get("gender"));
        if (!str1.equals("m")) {
          break label556;
        }
        this.db.put("gender", "0");
      }
      for (;;)
      {
        this.db.put("snsUserUrl", "http://weibo.com/" + String.valueOf(localHashMap.get("profile_url")));
        this.db.put("resume", String.valueOf(localHashMap.get("description")));
        this.db.put("followerCount", String.valueOf(localHashMap.get("followers_count")));
        this.db.put("favouriteCount", String.valueOf(localHashMap.get("friends_count")));
        this.db.put("shareCount", String.valueOf(localHashMap.get("statuses_count")));
        long l = R.parseTwitterDate(String.valueOf(localHashMap.get("created_at")));
        this.db.put("snsregat", String.valueOf(l));
        if (this.listener == null) {
          break;
        }
        this.listener.onComplete(this, 8, localHashMap);
        return;
        label540:
        this.db.put("secretType", "0");
        break label305;
        label556:
        if (str1.equals("f")) {
          this.db.put("gender", "1");
        } else {
          this.db.put("gender", "2");
        }
      }
      i = j;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.sina.weibo.SinaWeibo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */