package cn.sharesdk.framework;

import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.b;
import cn.sharesdk.framework.utils.d;
import cn.sharesdk.framework.utils.e;
import java.util.HashMap;

public abstract class Service$ServiceEvent
{
  private final int PLATFORM = 1;
  protected Service service;
  
  public Service$ServiceEvent(Service paramService)
  {
    this.service = paramService;
  }
  
  protected HashMap<String, Object> filterShareContent(int paramInt, Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = ShareSDK.getPlatform(ShareSDK.platformIdToName(paramInt)).filterShareContent(paramShareParams, paramHashMap);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shareID", locala.a);
    localHashMap.put("shareContent", new d().a(locala.toString()));
    e.c("filterShareContent ==>>%s", new Object[] { localHashMap });
    return localHashMap;
  }
  
  protected HashMap<String, Object> toMap()
  {
    HashMap localHashMap = new HashMap();
    b localb = b.a(Service.a(this.service));
    localHashMap.put("deviceid", localb.p());
    localHashMap.put("appkey", this.service.getAppKey());
    localHashMap.put("apppkg", localb.q());
    localHashMap.put("appver", Integer.valueOf(localb.s()));
    localHashMap.put("sdkver", Integer.valueOf(this.service.getServiceVersionInt()));
    localHashMap.put("plat", Integer.valueOf(1));
    localHashMap.put("networktype", localb.n());
    localHashMap.put("deviceData", localb.h());
    return localHashMap;
  }
  
  public final String toString()
  {
    return new d().a(toMap());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.Service.ServiceEvent
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */