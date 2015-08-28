package cn.sharesdk.onekeyshare;

import cn.sharesdk.framework.Platform;
import java.util.HashMap;

public abstract interface ThemeShareCallback
{
  public abstract void doShare(HashMap<Platform, HashMap<String, Object>> paramHashMap);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.ThemeShareCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */