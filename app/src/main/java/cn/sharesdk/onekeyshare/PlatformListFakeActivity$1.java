package cn.sharesdk.onekeyshare;

import cn.sharesdk.framework.FakeActivity;
import java.util.HashMap;

class PlatformListFakeActivity$1
  extends FakeActivity
{
  PlatformListFakeActivity$1(PlatformListFakeActivity paramPlatformListFakeActivity) {}
  
  public void onResult(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null) {}
    while (!paramHashMap.containsKey("editRes")) {
      return;
    }
    HashMap localHashMap = (HashMap)paramHashMap.get("editRes");
    this.this$0.themeShareCallback.doShare(localHashMap);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.PlatformListFakeActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */