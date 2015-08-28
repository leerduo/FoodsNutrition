package cn.sharesdk.framework;

import java.util.HashMap;

class e
  implements PlatformActionListener
{
  e(d paramd, PlatformActionListener paramPlatformActionListener, int paramInt, HashMap paramHashMap) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    d.a(this.d, this.a);
    if (d.a(this.d) != null) {
      d.a(this.d).onComplete(paramPlatform, this.b, this.c);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    d.a(this.d, this.a);
    if (d.a(this.d) != null) {
      d.a(this.d).onComplete(paramPlatform, this.b, this.c);
    }
    cn.sharesdk.framework.statistics.b.b localb = new cn.sharesdk.framework.statistics.b.b();
    localb.a = paramPlatform.getPlatformId();
    if ("TencentWeibo".equals(paramPlatform.getName())) {}
    for (String str = paramPlatform.getDb().get("name");; str = paramPlatform.getDb().getUserId())
    {
      localb.b = str;
      localb.c = new cn.sharesdk.framework.utils.d().a(paramHashMap);
      localb.d = d.a(this.d, paramPlatform);
      cn.sharesdk.framework.statistics.b.a(paramPlatform.getContext()).a(localb);
      return;
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    cn.sharesdk.framework.utils.e.c(paramThrowable);
    d.a(this.d, this.a);
    if (d.a(this.d) != null) {
      d.a(this.d).onComplete(paramPlatform, this.b, this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */