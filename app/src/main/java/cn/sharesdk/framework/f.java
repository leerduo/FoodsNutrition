package cn.sharesdk.framework;

import java.util.HashMap;

class f
  implements PlatformActionListener
{
  f(d paramd, PlatformActionListener paramPlatformActionListener, int paramInt, Object paramObject) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    d.a(this.d, this.a);
    if (d.a(this.d) != null) {
      d.a(this.d).onCancel(paramPlatform, this.b);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    d.a(this.d, this.a);
    paramPlatform.afterRegister(this.b, this.c);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    d.a(this.d, this.a);
    if (d.a(this.d) != null) {
      d.a(this.d).onError(paramPlatform, paramInt, paramThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */