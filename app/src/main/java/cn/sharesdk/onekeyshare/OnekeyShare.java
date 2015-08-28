package cn.sharesdk.onekeyshare;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.BitmapHelper;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.UIHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class OnekeyShare
  implements Handler.Callback, PlatformActionListener
{
  private static final int MSG_ACTION_CCALLBACK = 2;
  private static final int MSG_CANCEL_NOTIFY = 3;
  private static final int MSG_TOAST = 1;
  private View bgView;
  private PlatformActionListener callback = this;
  private Context context;
  private ArrayList<CustomerLogo> customers = new ArrayList();
  private ShareContentCustomizeCallback customizeCallback;
  private boolean dialogMode = false;
  private boolean disableSSO;
  private HashMap<String, String> hiddenPlatforms = new HashMap();
  private int notifyIcon;
  private String notifyTitle;
  private PlatformListFakeActivity.OnShareButtonClickListener onShareButtonClickListener;
  private HashMap<String, Object> shareParamsMap = new HashMap();
  private boolean silent;
  private OnekeyShareTheme theme;
  
  private void showNotification(long paramLong, String paramString)
  {
    try
    {
      Context localContext = this.context.getApplicationContext();
      NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService("notification");
      localNotificationManager.cancel(165191050);
      long l = System.currentTimeMillis();
      Notification localNotification = new Notification(this.notifyIcon, paramString, l);
      PendingIntent localPendingIntent = PendingIntent.getActivity(localContext, 0, new Intent(), 0);
      localNotification.setLatestEventInfo(localContext, this.notifyTitle, paramString, localPendingIntent);
      localNotification.flags = 16;
      localNotificationManager.notify(165191050, localNotification);
      if (paramLong > 0L)
      {
        Message localMessage = new Message();
        localMessage.what = 3;
        localMessage.obj = localNotificationManager;
        localMessage.arg1 = 165191050;
        UIHandler.sendMessageDelayed(localMessage, paramLong, this);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void addHiddenPlatform(String paramString)
  {
    this.hiddenPlatforms.put(paramString, paramString);
  }
  
  public void disableSSOWhenAuthorize()
  {
    this.disableSSO = true;
  }
  
  public PlatformActionListener getCallback()
  {
    return this.callback;
  }
  
  public ShareContentCustomizeCallback getShareContentCustomizeCallback()
  {
    return this.customizeCallback;
  }
  
  public String getText()
  {
    if (this.shareParamsMap.containsKey("text")) {
      return String.valueOf(this.shareParamsMap.get("text"));
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    NotificationManager localNotificationManager;
    do
    {
      int i;
      do
      {
        int m;
        do
        {
          int n;
          do
          {
            String str1;
            int i1;
            do
            {
              int i2;
              do
              {
                int k;
                do
                {
                  int i3;
                  do
                  {
                    int i4;
                    do
                    {
                      int j;
                      do
                      {
                        int i5;
                        do
                        {
                          return false;
                          String str2 = String.valueOf(paramMessage.obj);
                          Toast.makeText(this.context, str2, 0).show();
                          return false;
                          switch (paramMessage.arg1)
                          {
                          default: 
                            return false;
                          case 1: 
                            i5 = R.getStringRes(this.context, "share_completed");
                          }
                        } while (i5 <= 0);
                        showNotification(2000L, this.context.getString(i5));
                        return false;
                        str1 = paramMessage.obj.getClass().getSimpleName();
                        if ((!"WechatClientNotExistException".equals(str1)) && (!"WechatTimelineNotSupportedException".equals(str1)) && (!"WechatFavoriteNotSupportedException".equals(str1))) {
                          break;
                        }
                        j = R.getStringRes(this.context, "wechat_client_inavailable");
                      } while (j <= 0);
                      showNotification(2000L, this.context.getString(j));
                      return false;
                      if (!"GooglePlusClientNotExistException".equals(str1)) {
                        break;
                      }
                      i4 = R.getStringRes(this.context, "google_plus_client_inavailable");
                    } while (i4 <= 0);
                    showNotification(2000L, this.context.getString(i4));
                    return false;
                    if (!"QQClientNotExistException".equals(str1)) {
                      break;
                    }
                    i3 = R.getStringRes(this.context, "qq_client_inavailable");
                  } while (i3 <= 0);
                  showNotification(2000L, this.context.getString(i3));
                  return false;
                  if ((!"YixinClientNotExistException".equals(str1)) && (!"YixinTimelineNotSupportedException".equals(str1))) {
                    break;
                  }
                  k = R.getStringRes(this.context, "yixin_client_inavailable");
                } while (k <= 0);
                showNotification(2000L, this.context.getString(k));
                return false;
                if (!"KakaoTalkClientNotExistException".equals(str1)) {
                  break;
                }
                i2 = R.getStringRes(this.context, "kakaotalk_client_inavailable");
              } while (i2 <= 0);
              showNotification(2000L, this.context.getString(i2));
              return false;
              if (!"KakaoStoryClientNotExistException".equals(str1)) {
                break;
              }
              i1 = R.getStringRes(this.context, "kakaostory_client_inavailable");
            } while (i1 <= 0);
            showNotification(2000L, this.context.getString(i1));
            return false;
            if (!"WhatsAppClientNotExistException".equals(str1)) {
              break;
            }
            n = R.getStringRes(this.context, "whatsapp_client_inavailable");
          } while (n <= 0);
          showNotification(2000L, this.context.getString(n));
          return false;
          m = R.getStringRes(this.context, "share_failed");
        } while (m <= 0);
        showNotification(2000L, this.context.getString(m));
        return false;
        i = R.getStringRes(this.context, "share_canceled");
      } while (i <= 0);
      showNotification(2000L, this.context.getString(i));
      return false;
      localNotificationManager = (NotificationManager)paramMessage.obj;
    } while (localNotificationManager == null);
    localNotificationManager.cancel(paramMessage.arg1);
    return false;
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = 3;
    localMessage.arg2 = paramInt;
    localMessage.obj = paramPlatform;
    UIHandler.sendMessage(localMessage, this);
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = 1;
    localMessage.arg2 = paramInt;
    localMessage.obj = paramPlatform;
    UIHandler.sendMessage(localMessage, this);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = 2;
    localMessage.arg2 = paramInt;
    localMessage.obj = paramThrowable;
    UIHandler.sendMessage(localMessage, this);
    ShareSDK.logDemoEvent(4, paramPlatform);
  }
  
  public void setAddress(String paramString)
  {
    this.shareParamsMap.put("address", paramString);
  }
  
  public void setCallback(PlatformActionListener paramPlatformActionListener)
  {
    this.callback = paramPlatformActionListener;
  }
  
  public void setComment(String paramString)
  {
    this.shareParamsMap.put("comment", paramString);
  }
  
  public void setCustomerLogo(Bitmap paramBitmap, String paramString, View.OnClickListener paramOnClickListener)
  {
    CustomerLogo localCustomerLogo = new CustomerLogo();
    localCustomerLogo.label = paramString;
    localCustomerLogo.logo = paramBitmap;
    localCustomerLogo.listener = paramOnClickListener;
    this.customers.add(localCustomerLogo);
  }
  
  public void setDialogMode()
  {
    this.dialogMode = true;
    this.shareParamsMap.put("dialogMode", Boolean.valueOf(this.dialogMode));
  }
  
  public void setEditPageBackground(View paramView)
  {
    this.bgView = paramView;
  }
  
  public void setExecuteUrl(String paramString)
  {
    this.shareParamsMap.put("executeurl", paramString);
  }
  
  public void setFilePath(String paramString)
  {
    this.shareParamsMap.put("filePath", paramString);
  }
  
  public void setImageArray(String[] paramArrayOfString)
  {
    this.shareParamsMap.put("imageArray", paramArrayOfString);
  }
  
  public void setImagePath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.shareParamsMap.put("imagePath", paramString);
    }
  }
  
  public void setImageUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.shareParamsMap.put("imageUrl", paramString);
    }
  }
  
  public void setInstallUrl(String paramString)
  {
    this.shareParamsMap.put("installurl", paramString);
  }
  
  public void setLatitude(float paramFloat)
  {
    this.shareParamsMap.put("latitude", Float.valueOf(paramFloat));
  }
  
  public void setLongitude(float paramFloat)
  {
    this.shareParamsMap.put("longitude", Float.valueOf(paramFloat));
  }
  
  public void setMusicUrl(String paramString)
  {
    this.shareParamsMap.put("musicUrl", paramString);
  }
  
  public void setNotification(int paramInt, String paramString)
  {
    this.notifyIcon = paramInt;
    this.notifyTitle = paramString;
  }
  
  public void setOnShareButtonClickListener(PlatformListFakeActivity.OnShareButtonClickListener paramOnShareButtonClickListener)
  {
    this.onShareButtonClickListener = paramOnShareButtonClickListener;
  }
  
  public void setPlatform(String paramString)
  {
    this.shareParamsMap.put("platform", paramString);
  }
  
  public void setShareContentCustomizeCallback(ShareContentCustomizeCallback paramShareContentCustomizeCallback)
  {
    this.customizeCallback = paramShareContentCustomizeCallback;
  }
  
  public void setShareFromQQAuthSupport(boolean paramBoolean)
  {
    this.shareParamsMap.put("isShareTencentWeibo", Boolean.valueOf(paramBoolean));
  }
  
  public void setSilent(boolean paramBoolean)
  {
    this.silent = paramBoolean;
  }
  
  public void setSite(String paramString)
  {
    this.shareParamsMap.put("site", paramString);
  }
  
  public void setSiteUrl(String paramString)
  {
    this.shareParamsMap.put("siteUrl", paramString);
  }
  
  public void setText(String paramString)
  {
    this.shareParamsMap.put("text", paramString);
  }
  
  public void setTheme(OnekeyShareTheme paramOnekeyShareTheme)
  {
    this.theme = paramOnekeyShareTheme;
  }
  
  public void setTitle(String paramString)
  {
    this.shareParamsMap.put("title", paramString);
  }
  
  public void setTitleUrl(String paramString)
  {
    this.shareParamsMap.put("titleUrl", paramString);
  }
  
  public void setUrl(String paramString)
  {
    this.shareParamsMap.put("url", paramString);
  }
  
  public void setVenueDescription(String paramString)
  {
    this.shareParamsMap.put("venueDescription", paramString);
  }
  
  public void setVenueName(String paramString)
  {
    this.shareParamsMap.put("venueName", paramString);
  }
  
  public void setViewToShare(View paramView)
  {
    try
    {
      Bitmap localBitmap = BitmapHelper.captureView(paramView, paramView.getWidth(), paramView.getHeight());
      this.shareParamsMap.put("viewToShare", localBitmap);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void share(HashMap<Platform, HashMap<String, Object>> paramHashMap)
  {
    Iterator localIterator = paramHashMap.entrySet().iterator();
    int i = 0;
    Platform localPlatform;
    label678:
    HashMap localHashMap;
    int m;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localPlatform = (Platform)localEntry.getKey();
        localPlatform.SSOSetting(this.disableSSO);
        String str1 = localPlatform.getName();
        if (("GooglePlus".equals(str1)) && (!localPlatform.isValid()))
        {
          Message localMessage8 = new Message();
          localMessage8.what = 1;
          int i8 = R.getStringRes(this.context, "google_plus_client_inavailable");
          localMessage8.obj = this.context.getString(i8);
          UIHandler.sendMessage(localMessage8, this);
        }
        else if (("KakaoTalk".equals(str1)) && (!localPlatform.isValid()))
        {
          Message localMessage7 = new Message();
          localMessage7.what = 1;
          int i7 = R.getStringRes(this.context, "kakaotalk_client_inavailable");
          localMessage7.obj = this.context.getString(i7);
          UIHandler.sendMessage(localMessage7, this);
        }
        else if (("KakaoStory".equals(str1)) && (!localPlatform.isValid()))
        {
          Message localMessage6 = new Message();
          localMessage6.what = 1;
          int i6 = R.getStringRes(this.context, "kakaostory_client_inavailable");
          localMessage6.obj = this.context.getString(i6);
          UIHandler.sendMessage(localMessage6, this);
        }
        else if (("Line".equals(str1)) && (!localPlatform.isValid()))
        {
          Message localMessage5 = new Message();
          localMessage5.what = 1;
          int i5 = R.getStringRes(this.context, "line_client_inavailable");
          localMessage5.obj = this.context.getString(i5);
          UIHandler.sendMessage(localMessage5, this);
        }
        else if (("WhatsApp".equals(str1)) && (!localPlatform.isValid()))
        {
          Message localMessage4 = new Message();
          localMessage4.what = 1;
          int i4 = R.getStringRes(this.context, "whatsapp_client_inavailable");
          localMessage4.obj = this.context.getString(i4);
          UIHandler.sendMessage(localMessage4, this);
        }
        else if (("Pinterest".equals(str1)) && (!localPlatform.isValid()))
        {
          Message localMessage3 = new Message();
          localMessage3.what = 1;
          int i3 = R.getStringRes(this.context, "pinterest_client_inavailable");
          localMessage3.obj = this.context.getString(i3);
          UIHandler.sendMessage(localMessage3, this);
        }
        else if ("Instagram".equals(str1))
        {
          Intent localIntent = new Intent("android.intent.action.SEND");
          localIntent.setPackage("com.instagram.android");
          localIntent.setType("image/*");
          if (this.context.getPackageManager().resolveActivity(localIntent, 0) == null)
          {
            Message localMessage1 = new Message();
            localMessage1.what = 1;
            int j = R.getStringRes(this.context, "instagram_client_inavailable");
            localMessage1.obj = this.context.getString(j);
            UIHandler.sendMessage(localMessage1, this);
          }
        }
        else
        {
          if (("YixinMoments".equals(str1)) || ("Yixin".equals(str1))) {}
          for (int k = 1;; k = 0)
          {
            if ((k == 0) || (localPlatform.isValid())) {
              break label678;
            }
            Message localMessage2 = new Message();
            localMessage2.what = 1;
            int i2 = R.getStringRes(this.context, "yixin_client_inavailable");
            localMessage2.obj = this.context.getString(i2);
            UIHandler.sendMessage(localMessage2, this);
            break;
          }
          localHashMap = (HashMap)localEntry.getValue();
          String str2 = String.valueOf(localHashMap.get("imagePath"));
          if ((str2 != null) && (new File(str2).exists())) {
            if (str2.endsWith(".gif")) {
              m = 9;
            }
          }
        }
      }
    }
    for (;;)
    {
      label738:
      localHashMap.put("shareType", Integer.valueOf(m));
      if (i == 0) {
        if (this == this.callback)
        {
          int i1 = R.getStringRes(this.context, "sharing");
          if (i1 > 0) {
            showNotification(2000L, this.context.getString(i1));
          }
        }
      }
      for (int n = 1;; n = i)
      {
        localPlatform.setPlatformActionListener(this.callback);
        ShareCore localShareCore = new ShareCore();
        localShareCore.setShareContentCustomizeCallback(this.customizeCallback);
        localShareCore.share(localPlatform, localHashMap);
        i = n;
        break;
        if ((!localHashMap.containsKey("url")) || (TextUtils.isEmpty(localHashMap.get("url").toString()))) {
          break label1115;
        }
        if ((!localHashMap.containsKey("musicUrl")) || (TextUtils.isEmpty(localHashMap.get("musicUrl").toString()))) {
          break label1109;
        }
        m = 5;
        break label738;
        Bitmap localBitmap = (Bitmap)localHashMap.get("viewToShare");
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          if ((!localHashMap.containsKey("url")) || (TextUtils.isEmpty(localHashMap.get("url").toString()))) {
            break label1115;
          }
          if ((!localHashMap.containsKey("musicUrl")) || (TextUtils.isEmpty(localHashMap.get("musicUrl").toString()))) {
            break label1109;
          }
          m = 5;
          break label738;
        }
        Object localObject = localHashMap.get("imageUrl");
        if ((localObject == null) || (TextUtils.isEmpty(String.valueOf(localObject)))) {
          break label1121;
        }
        if (String.valueOf(localObject).endsWith(".gif"))
        {
          m = 9;
          break label738;
        }
        if ((!localHashMap.containsKey("url")) || (TextUtils.isEmpty(localHashMap.get("url").toString()))) {
          break label1115;
        }
        if ((!localHashMap.containsKey("musicUrl")) || (TextUtils.isEmpty(localHashMap.get("musicUrl").toString()))) {
          break label1109;
        }
        m = 5;
        break label738;
        return;
      }
      label1109:
      m = 4;
      continue;
      label1115:
      m = 2;
      continue;
      label1121:
      m = 1;
    }
  }
  
  public void show(Context paramContext)
  {
    ShareSDK.initSDK(paramContext);
    this.context = paramContext;
    ShareSDK.logDemoEvent(1, null);
    if (this.shareParamsMap.containsKey("platform"))
    {
      String str = String.valueOf(this.shareParamsMap.get("platform"));
      Platform localPlatform = ShareSDK.getPlatform(str);
      if ((this.silent) || (ShareCore.isUseClientToShare(str)) || ((localPlatform instanceof CustomPlatform)))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put(ShareSDK.getPlatform(str), this.shareParamsMap);
        share(localHashMap);
        return;
      }
    }
    PlatformListFakeActivity localPlatformListFakeActivity;
    try
    {
      localPlatformListFakeActivity = (PlatformListFakeActivity)Class.forName("cn.sharesdk.onekeyshare.theme.classic.PlatformListPage").newInstance();
      localPlatformListFakeActivity.setDialogMode(this.dialogMode);
      localPlatformListFakeActivity.setShareParamsMap(this.shareParamsMap);
      localPlatformListFakeActivity.setSilent(this.silent);
      localPlatformListFakeActivity.setCustomerLogos(this.customers);
      localPlatformListFakeActivity.setBackgroundView(this.bgView);
      localPlatformListFakeActivity.setHiddenPlatforms(this.hiddenPlatforms);
      localPlatformListFakeActivity.setOnShareButtonClickListener(this.onShareButtonClickListener);
      localPlatformListFakeActivity.setThemeShareCallback(new OnekeyShare.1(this));
      if (this.shareParamsMap.containsKey("platform"))
      {
        localPlatformListFakeActivity.showEditPage(paramContext, ShareSDK.getPlatform(String.valueOf(this.shareParamsMap.get("platform"))));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    localPlatformListFakeActivity.show(paramContext, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.OnekeyShare
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */