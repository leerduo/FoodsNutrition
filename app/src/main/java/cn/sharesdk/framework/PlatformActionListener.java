package cn.sharesdk.framework;

import java.util.HashMap;

public abstract interface PlatformActionListener
{
  public abstract void onCancel(Platform paramPlatform, int paramInt);
  
  public abstract void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap);
  
  public abstract void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.PlatformActionListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */