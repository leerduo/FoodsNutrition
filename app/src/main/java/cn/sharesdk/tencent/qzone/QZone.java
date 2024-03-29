package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.BitmapHelper;
import cn.sharesdk.framework.utils.d;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class QZone
  extends Platform
{
  public static final String NAME = QZone.class.getSimpleName();
  private String a;
  private boolean b;
  
  public QZone(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Platform.ShareParams paramShareParams)
  {
    String str1 = paramShareParams.getImageUrl();
    String str2 = paramShareParams.getImagePath();
    boolean bool = paramShareParams.isShareTencentWeibo();
    try
    {
      if ((TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
      {
        paramShareParams.setImagePath(BitmapHelper.downloadBitmap(this.context, str1));
        doShare(paramShareParams);
        return;
      }
      if (!isValid())
      {
        setPlatformActionListener(new b(this, getPlatformActionListener(), paramShareParams));
        authorize();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, 9, localThrowable);
        return;
        String str3 = paramShareParams.getText();
        if (TextUtils.isEmpty(str3))
        {
          if (this.listener != null) {
            this.listener.onError(this, 9, new Throwable("share params' value of text is empty!"));
          }
        }
        else
        {
          String str4 = getShortLintk(str3, false);
          f localf = f.a(this);
          if (bool) {}
          HashMap localHashMap;
          for (Object localObject = localf.b(str2, str4);; localObject = localHashMap)
          {
            if ((localObject == null) && (this.listener != null)) {
              this.listener.onError(this, 9, new Throwable("response is empty"));
            }
            ((HashMap)localObject).put("ShareParams", paramShareParams);
            if (this.listener == null) {
              break;
            }
            this.listener.onComplete(this, 9, (HashMap)localObject);
            return;
            localHashMap = localf.a(str2, str4);
          }
        }
      }
    }
  }
  
  private void b(Platform.ShareParams paramShareParams)
  {
    String str1 = paramShareParams.getImageUrl();
    String str2 = paramShareParams.getImagePath();
    if ((TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      str1 = uploadImageToFileServer(str2);
      paramShareParams.setImageUrl(str1);
    }
    try
    {
      paramShareParams.set("webShare", Boolean.valueOf(true));
      String str3 = paramShareParams.getTitle();
      String str4 = paramShareParams.getTitleUrl();
      String str5 = paramShareParams.getSite();
      String str6 = paramShareParams.getText();
      String str7 = getShortLintk(str4 + " SSDK_SEP " + str6, false);
      String[] arrayOfString = str7.split(" SSDK_SEP ");
      if (arrayOfString.length >= 2)
      {
        str4 = arrayOfString[0];
        str6 = arrayOfString[1];
      }
      for (;;)
      {
        f.a(this).a(str3, str4, str6, str1, str5, this.b, new c(this, paramShareParams));
        return;
        if (arrayOfString.length >= 1) {
          if (str7.endsWith(" SSDK_SEP ")) {
            str4 = arrayOfString[0];
          } else {
            str6 = arrayOfString[0];
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.listener != null) {
        this.listener.onError(this, 9, localThrowable);
      }
    }
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if ((isValid()) || (paramInt == 9))
    {
      f localf = f.a(this);
      localf.a(this.a);
      localf.b(this.db.getUserId());
      localf.c(this.db.getToken());
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    f localf = f.a(this);
    localf.a(this.a);
    localf.a(paramArrayOfString);
    localf.a(new a(this, localf), isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    HashMap localHashMap = f.a(this).a(paramString1, paramString2, paramHashMap, paramHashMap1);
    if ((localHashMap == null) || (localHashMap.size() <= 0)) {
      if (this.listener != null) {
        this.listener.onError(this, paramInt, new Throwable());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (localHashMap.containsKey("ret")) {
            break;
          }
        } while (this.listener == null);
        this.listener.onError(this, paramInt, new Throwable());
        return;
        if (((Integer)localHashMap.get("ret")).intValue() == 0) {
          break;
        }
      } while (this.listener == null);
      String str = new d().a(localHashMap);
      this.listener.onError(this, paramInt, new Throwable(str));
      return;
    } while (this.listener == null);
    this.listener.onComplete(this, paramInt, localHashMap);
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    paramShareParams.set("webShare", Boolean.valueOf(false));
    String str1 = paramShareParams.getTitle();
    String str2 = paramShareParams.getTitleUrl();
    String str3 = paramShareParams.getSite();
    String str4 = paramShareParams.getSiteUrl();
    String str5 = paramShareParams.getImageUrl();
    String str6 = paramShareParams.getImagePath();
    if (paramShareParams.isShareTencentWeibo())
    {
      a(paramShareParams);
      return;
    }
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)) && ((!TextUtils.isEmpty(str6)) || (!TextUtils.isEmpty(str5))))
    {
      a(paramShareParams);
      return;
    }
    b(paramShareParams);
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    if (((Boolean)paramShareParams.get("webShare", Boolean.class)).booleanValue())
    {
      String str2 = paramShareParams.getImageUrl();
      if (str2 != null) {
        locala.d.add(str2);
      }
      String str3 = paramShareParams.getTitleUrl();
      if (str3 != null) {
        locala.c.add(str3);
      }
      String str4 = paramShareParams.getSiteUrl();
      if (str4 != null) {
        locala.c.add(str4);
      }
      if (paramHashMap != null) {
        locala.a = String.valueOf(paramHashMap.get("share_id"));
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", paramShareParams.getTitle());
      localHashMap.put("url", paramShareParams.getTitleUrl());
      localHashMap.put("site", paramShareParams.getSite());
      localHashMap.put("fromurl", paramShareParams.getSiteUrl());
      localHashMap.put("type", Integer.valueOf(4));
      localHashMap.put("comment", paramShareParams.getComment());
      localHashMap.put("summary", paramShareParams.getText());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramShareParams.getImageUrl());
      localHashMap.put("images", localArrayList);
      localHashMap.put("playurl", null);
      locala.g = localHashMap;
      return locala;
      String str1 = paramShareParams.getImagePath();
      if (str1 != null) {
        locala.e.add(str1);
      } else if (paramHashMap.get("large_url") != null) {
        locala.d.add(String.valueOf(paramHashMap.get("large_url")));
      } else if (paramHashMap.get("small_url") != null) {
        locala.d.add(String.valueOf(paramHashMap.get("small_url")));
      }
    }
  }
  
  protected void follow(String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 6);
    }
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 2);
    }
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public int getPlatformId()
  {
    return 6;
  }
  
  public int getVersion()
  {
    return 2;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppId");
    this.b = "true".equals(getDevinfo("ShareByAppClient"));
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getDevinfo("QQ", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyDevinfo("QQ", NAME);
        this.a = getDevinfo("AppId");
        this.b = "true".equals(getDevinfo("ShareByAppClient"));
        if (ShareSDK.isDebug()) {
          System.err.println("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.");
        }
      }
    }
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_id", "AppId");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getNetworkDevinfo(24, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(24, 6);
        this.a = getNetworkDevinfo("app_id", "AppId");
        if (ShareSDK.isDebug()) {
          System.err.println("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.");
        }
      }
    }
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 0)) {
      paramString = this.db.getUserId();
    }
    if ((paramString == null) || (paramString.length() < 0)) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new RuntimeException("qq account is null"));
      }
    }
    label134:
    label328:
    label595:
    for (;;)
    {
      return;
      f localf = f.a(this);
      HashMap localHashMap;
      try
      {
        localHashMap = localf.d(paramString);
        if ((localHashMap != null) && (localHashMap.size() > 0)) {
          break label134;
        }
        if (this.listener == null) {
          continue;
        }
        this.listener.onError(this, 8, new Throwable());
        return;
      }
      catch (Throwable localThrowable) {}
      if (this.listener != null)
      {
        this.listener.onError(this, 8, localThrowable);
        return;
        if (!localHashMap.containsKey("ret"))
        {
          if (this.listener != null) {
            this.listener.onError(this, 8, new Throwable());
          }
        }
        else if (((Integer)localHashMap.get("ret")).intValue() != 0)
        {
          if (this.listener != null)
          {
            String str2 = new d().a(localHashMap);
            this.listener.onError(this, 8, new Throwable(str2));
          }
        }
        else
        {
          String str1;
          if (paramString == this.db.getUserId())
          {
            this.db.put("nickname", String.valueOf(localHashMap.get("nickname")));
            if (!localHashMap.containsKey("figureurl_qq_1")) {
              break label449;
            }
            this.db.put("iconQQ", String.valueOf(localHashMap.get("figureurl_qq_1")));
            if (!localHashMap.containsKey("figureurl_2")) {
              break label484;
            }
            this.db.put("icon", String.valueOf(localHashMap.get("figureurl_2")));
            this.db.put("secretType", String.valueOf(localHashMap.get("is_yellow_vip")));
            if (String.valueOf(localHashMap.get("is_yellow_vip")).equals("1")) {
              this.db.put("snsUserLevel", String.valueOf(localHashMap.get("level")));
            }
            str1 = String.valueOf(localHashMap.get("gender"));
            if (!str1.equals("男")) {
              break label554;
            }
            this.db.put("gender", "0");
          }
          for (;;)
          {
            if (this.listener == null) {
              break label595;
            }
            this.listener.onComplete(this, 8, localHashMap);
            return;
            if (!localHashMap.containsKey("figureurl_qq_2")) {
              break;
            }
            this.db.put("iconQQ", String.valueOf(localHashMap.get("figureurl_qq_2")));
            break;
            label484:
            if (localHashMap.containsKey("figureurl_1"))
            {
              this.db.put("icon", String.valueOf(localHashMap.get("figureurl_1")));
              break label328;
            }
            if (!localHashMap.containsKey("figureurl")) {
              break label328;
            }
            this.db.put("icon", String.valueOf(localHashMap.get("figureurl")));
            break label328;
            if (str1.equals("女")) {
              this.db.put("gender", "1");
            } else {
              this.db.put("gender", "2");
            }
          }
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.QZone
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */