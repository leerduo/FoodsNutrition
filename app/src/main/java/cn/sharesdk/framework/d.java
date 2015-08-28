package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.statistics.b;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.a;
import java.util.HashMap;

public class d
  implements PlatformActionListener
{
  private PlatformActionListener a;
  
  private String a(Platform paramPlatform)
  {
    PlatformDb localPlatformDb = paramPlatform.getDb();
    try
    {
      String str = a(localPlatformDb, new String[] { "nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr" });
      return str;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.c(localThrowable);
    }
    return null;
  }
  
  private String a(PlatformDb paramPlatformDb, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = paramArrayOfString.length;
    int j = 0;
    int k = 0;
    if (j < i)
    {
      String str1 = paramArrayOfString[j];
      if (k > 0)
      {
        localStringBuilder2.append('|');
        localStringBuilder1.append('|');
      }
      k++;
      String str2 = paramPlatformDb.get(str1);
      if (TextUtils.isEmpty(str2)) {}
      for (;;)
      {
        j++;
        break;
        localStringBuilder1.append(str2);
        localStringBuilder2.append(a.c(str2, "utf-8"));
      }
    }
    cn.sharesdk.framework.utils.e.c("======UserData: " + localStringBuilder1.toString(), new Object[0]);
    return localStringBuilder2.toString();
  }
  
  private void a(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    this.a = new e(this, this.a, paramInt, paramHashMap);
    paramPlatform.showUser(null);
  }
  
  private String b(Platform paramPlatform)
  {
    PlatformDb localPlatformDb = paramPlatform.getDb();
    try
    {
      String str = a(localPlatformDb, new String[] { "gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr" });
      return str;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.c(localThrowable);
    }
    return null;
  }
  
  private void b(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    Platform.ShareParams localShareParams;
    if (paramHashMap != null) {
      localShareParams = (Platform.ShareParams)paramHashMap.remove("ShareParams");
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = (HashMap)paramHashMap.clone();
        Object localObject = localHashMap;
        String str;
        if (localShareParams != null)
        {
          cn.sharesdk.framework.statistics.b.f localf = new cn.sharesdk.framework.statistics.b.f();
          localf.o = localShareParams.getCustomFlag();
          if ("TencentWeibo".equals(paramPlatform.getName()))
          {
            str = paramPlatform.getDb().get("name");
            localf.b = str;
            localf.a = paramPlatform.getPlatformId();
            f.a locala = paramPlatform.filterShareContent(localShareParams, (HashMap)localObject);
            if (locala != null)
            {
              localf.c = locala.a;
              localf.d = locala;
            }
            localf.n = b(paramPlatform);
            b.a(paramPlatform.getContext()).a(localf);
          }
        }
        else if (this.a == null) {}
        localShareParams = null;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.a.onComplete(paramPlatform, paramInt, paramHashMap);
          return;
        }
        catch (Throwable localThrowable2)
        {
          cn.sharesdk.framework.utils.e.b(localThrowable2);
          return;
        }
        localThrowable1 = localThrowable1;
        cn.sharesdk.framework.utils.e.c(localThrowable1);
        localObject = paramHashMap;
        continue;
        str = paramPlatform.getDb().getUserId();
      }
    }
  }
  
  PlatformActionListener a()
  {
    return this.a;
  }
  
  void a(Platform paramPlatform, int paramInt, Object paramObject)
  {
    this.a = new f(this, this.a, paramInt, paramObject);
    paramPlatform.doAuthorize(null);
  }
  
  void a(PlatformActionListener paramPlatformActionListener)
  {
    this.a = paramPlatformActionListener;
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel(paramPlatform, paramInt);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    if ((paramPlatform instanceof CustomPlatform)) {
      if (this.a != null) {
        this.a.onComplete(paramPlatform, paramInt, paramHashMap);
      }
    }
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.a == null);
    this.a.onComplete(paramPlatform, paramInt, paramHashMap);
    return;
    a(paramPlatform, paramInt, paramHashMap);
    return;
    b(paramPlatform, paramInt, paramHashMap);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.onError(paramPlatform, paramInt, paramThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */