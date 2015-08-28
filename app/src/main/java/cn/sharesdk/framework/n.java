package cn.sharesdk.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import cn.sharesdk.framework.statistics.b;
import cn.sharesdk.framework.statistics.b.d;
import cn.sharesdk.framework.utils.e;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class n
{
  private static boolean a = true;
  
  /* Error */
  private ArrayList<Platform> a(PackageInfo paramPackageInfo, Context paramContext)
  {
    // Byte code:
    //   0: new 18	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 19	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 21	dalvik/system/DexFile
    //   11: dup
    //   12: aload_1
    //   13: getfield 27	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   16: getfield 33	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   19: invokespecial 36	dalvik/system/DexFile:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: aload 4
    //   26: invokevirtual 40	dalvik/system/DexFile:entries	()Ljava/util/Enumeration;
    //   29: astore 7
    //   31: aload 4
    //   33: invokevirtual 43	dalvik/system/DexFile:close	()V
    //   36: aload 7
    //   38: ifnull +155 -> 193
    //   41: aload 7
    //   43: invokeinterface 49 1 0
    //   48: ifeq +145 -> 193
    //   51: aload 7
    //   53: invokeinterface 53 1 0
    //   58: checkcast 55	java/lang/String
    //   61: astore 10
    //   63: aload 10
    //   65: ldc 57
    //   67: invokevirtual 61	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq -34 -> 36
    //   73: aload 10
    //   75: ldc 63
    //   77: invokevirtual 67	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   80: ifne -44 -> 36
    //   83: aload 10
    //   85: invokestatic 73	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   88: astore 13
    //   90: aload 13
    //   92: ifnull -56 -> 36
    //   95: ldc 75
    //   97: aload 13
    //   99: invokevirtual 79	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   102: ifeq -66 -> 36
    //   105: ldc 81
    //   107: aload 13
    //   109: invokevirtual 79	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   112: ifne -76 -> 36
    //   115: aload 13
    //   117: iconst_1
    //   118: anewarray 69	java/lang/Class
    //   121: dup
    //   122: iconst_0
    //   123: ldc 83
    //   125: aastore
    //   126: invokevirtual 87	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   129: astore 14
    //   131: aload 14
    //   133: iconst_1
    //   134: invokevirtual 93	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   137: aload_3
    //   138: aload 14
    //   140: iconst_1
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload_2
    //   147: aastore
    //   148: invokevirtual 97	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   151: checkcast 75	cn/sharesdk/framework/Platform
    //   154: invokevirtual 101	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: goto -122 -> 36
    //   161: astore 11
    //   163: aload 11
    //   165: invokestatic 107	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   168: pop
    //   169: goto -133 -> 36
    //   172: astore 8
    //   174: aload 8
    //   176: invokestatic 107	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   179: pop
    //   180: goto -144 -> 36
    //   183: astore 5
    //   185: aload 5
    //   187: invokestatic 107	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   190: pop
    //   191: aconst_null
    //   192: areturn
    //   193: aload_3
    //   194: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	n
    //   0	195	1	paramPackageInfo	PackageInfo
    //   0	195	2	paramContext	Context
    //   7	187	3	localArrayList	ArrayList
    //   22	10	4	localDexFile	dalvik.system.DexFile
    //   183	3	5	localThrowable1	Throwable
    //   29	23	7	localEnumeration	java.util.Enumeration
    //   172	3	8	localThrowable2	Throwable
    //   61	23	10	str	String
    //   161	3	11	localThrowable3	Throwable
    //   88	28	13	localClass	Class
    //   129	10	14	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   83	90	161	java/lang/Throwable
    //   95	158	161	java/lang/Throwable
    //   31	36	172	java/lang/Throwable
    //   8	31	183	java/lang/Throwable
    //   174	180	183	java/lang/Throwable
  }
  
  private PackageInfo c(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      String str = paramContext.getPackageName();
      Iterator localIterator = localPackageManager.getInstalledPackages(8192).iterator();
      while (localIterator.hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
        boolean bool = str.equals(localPackageInfo.packageName);
        if (bool) {
          return localPackageInfo;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
      return null;
    }
    return null;
  }
  
  private ArrayList<Platform> d(Context paramContext)
  {
    String[] arrayOfString = { "cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", "cn.sharesdk.sina.weibo.SinaWeibo", "cn.sharesdk.sohu.suishenkan.SohuSuishenkan", "cn.sharesdk.kaixin.KaiXin", "cn.sharesdk.linkedin.LinkedIn", "cn.sharesdk.system.email.Email", "cn.sharesdk.system.text.ShortMessage", "cn.sharesdk.tencent.qq.QQ", "cn.sharesdk.tencent.qzone.QZone", "cn.sharesdk.tencent.weibo.TencentWeibo", "cn.sharesdk.twitter.Twitter", "cn.sharesdk.wechat.friends.Wechat", "cn.sharesdk.wechat.moments.WechatMoments", "cn.sharesdk.wechat.favorite.WechatFavorite", "cn.sharesdk.youdao.YouDao", "cn.sharesdk.google.GooglePlus", "cn.sharesdk.foursquare.FourSquare", "cn.sharesdk.pinterest.Pinterest", "cn.sharesdk.flickr.Flickr", "cn.sharesdk.tumblr.Tumblr", "cn.sharesdk.dropbox.Dropbox", "cn.sharesdk.vkontakte.VKontakte", "cn.sharesdk.instagram.Instagram", "cn.sharesdk.yixin.friends.Yixin", "cn.sharesdk.yixin.moments.YixinMoments", "cn.sharesdk.mingdao.Mingdao", "cn.sharesdk.line.Line", "cn.sharesdk.kakao.story.KakaoStory", "cn.sharesdk.kakao.talk.KakaoTalk", "cn.sharesdk.system.bluetooth.Bluetooth", "cn.sharesdk.whatsapp.WhatsApp", "cn.sharesdk.pocket.Pocket", "cn.sharesdk.instapaper.Instapaper", "cn.sharesdk.facebookmessenger.FacebookMessenger", "cn.sharesdk.baidu.tieba.BaiduTieba" };
    ArrayList localArrayList = new ArrayList();
    int i = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        String str = arrayOfString[j];
        try
        {
          Constructor localConstructor = Class.forName(str).getConstructor(new Class[] { Context.class });
          localConstructor.setAccessible(true);
          localArrayList.add((Platform)localConstructor.newInstance(new Object[] { paramContext }));
          j++;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            e.c(localThrowable);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String a()
  {
    return "2.5.7";
  }
  
  public String a(int paramInt, String paramString, HashMap<Integer, HashMap<String, Object>> paramHashMap)
  {
    HashMap localHashMap = (HashMap)paramHashMap.get(Integer.valueOf(paramInt));
    if (localHashMap == null) {
      return null;
    }
    Object localObject = localHashMap.get(paramString);
    if (localObject == null) {}
    for (String str = null;; str = String.valueOf(localObject)) {
      return str;
    }
  }
  
  public String a(Context paramContext, Bitmap paramBitmap)
  {
    return cn.sharesdk.framework.statistics.a.a(paramContext).a(paramBitmap);
  }
  
  public String a(Context paramContext, String paramString)
  {
    return cn.sharesdk.framework.statistics.a.a(paramContext).d(paramString);
  }
  
  public String a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3)
  {
    return cn.sharesdk.framework.statistics.a.a(paramContext).a(paramString2, paramString1, paramInt, paramBoolean, paramString3);
  }
  
  public ArrayList<Platform> a(Context paramContext)
  {
    if (a) {}
    PackageInfo localPackageInfo;
    for (ArrayList localArrayList = d(paramContext);; localArrayList = a(localPackageInfo, paramContext))
    {
      a(localArrayList);
      return localArrayList;
      localPackageInfo = c(paramContext);
      if (localPackageInfo == null) {
        return null;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, HashMap<Integer, HashMap<String, Object>> paramHashMap)
  {
    HashMap localHashMap = (HashMap)paramHashMap.get(Integer.valueOf(paramInt1));
    paramHashMap.put(Integer.valueOf(paramInt2), localHashMap);
  }
  
  public void a(int paramInt, Platform paramPlatform)
  {
    d locald = new d();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramPlatform != null) {
        locald.b = paramPlatform.getPlatformId();
      }
      b localb = b.a(null);
      if (localb != null) {
        localb.a(locald);
      }
      return;
      locald.a = "SHARESDK_ENTER_SHAREMENU";
      continue;
      locald.a = "SHARESDK_CANCEL_SHAREMENU";
      continue;
      locald.a = "SHARESDK_EDIT_SHARE";
      continue;
      locald.a = "SHARESDK_FAILED_SHARE";
      continue;
      locald.a = "SHARESDK_CANCEL_SHARE";
    }
  }
  
  public void a(Context paramContext, String paramString, Handler paramHandler, boolean paramBoolean, int paramInt)
  {
    b localb = b.a(paramContext);
    localb.a(paramString);
    localb.a(paramHandler);
    localb.a(paramBoolean);
    localb.a(paramInt);
    localb.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    b localb = b.a(null);
    if (localb == null) {
      return;
    }
    cn.sharesdk.framework.statistics.b.a locala = new cn.sharesdk.framework.statistics.b.a();
    locala.b = paramString;
    locala.a = paramInt;
    localb.a(locala);
  }
  
  public void a(ArrayList<Platform> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Collections.sort(paramArrayList, new o(this));
  }
  
  public boolean a(HashMap<String, Object> paramHashMap, HashMap<Integer, HashMap<String, Object>> paramHashMap1)
  {
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      return false;
    }
    Iterator localIterator = ((ArrayList)paramHashMap.get("fakelist")).iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        String str = String.valueOf(localHashMap.get("snsplat"));
        try
        {
          int j = Integer.parseInt(str);
          i = j;
          if (i != -1) {
            paramHashMap1.put(Integer.valueOf(i), localHashMap);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            e.c(localThrowable);
            int i = -1;
          }
        }
      }
    }
    return true;
  }
  
  public int b()
  {
    return 48;
  }
  
  public void b(Context paramContext)
  {
    b.a(paramContext).b();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.n
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */