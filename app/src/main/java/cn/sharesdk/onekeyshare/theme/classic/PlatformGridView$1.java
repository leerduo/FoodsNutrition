package cn.sharesdk.onekeyshare.theme.classic;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.UIHandler;

class PlatformGridView$1
  extends Thread
{
  PlatformGridView$1(PlatformGridView paramPlatformGridView) {}
  
  public void run()
  {
    PlatformGridView.access$002(this.this$0, ShareSDK.getPlatformList());
    if (PlatformGridView.access$000(this.this$0) == null) {
      PlatformGridView.access$002(this.this$0, new Platform[0]);
    }
    UIHandler.sendEmptyMessage(1, this.this$0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.PlatformGridView.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */