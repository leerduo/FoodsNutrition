package cn.sharesdk.tencent.qzone;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

class c
  implements PlatformActionListener
{
  c(QZone paramQZone, Platform.ShareParams paramShareParams) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (QZone.m(this.b) != null) {
      QZone.n(this.b).onCancel(this.b, 9);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (QZone.k(this.b) != null)
    {
      paramHashMap.put("ShareParams", this.a);
      QZone.l(this.b).onComplete(this.b, 9, paramHashMap);
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (QZone.i(this.b) != null) {
      QZone.j(this.b).onError(this.b, 9, paramThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.tencent.qzone.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */