package cn.sharesdk.onekeyshare.theme.classic;

import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.UIHandler;
import cn.sharesdk.onekeyshare.ShareCore;
import java.util.ArrayList;

class EditPage$1
  extends Thread
{
  EditPage$1(EditPage paramEditPage) {}
  
  public void run()
  {
    EditPage.access$002(this.this$0, ShareSDK.getPlatformList());
    if (EditPage.access$000(this.this$0) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Platform[] arrayOfPlatform = EditPage.access$000(this.this$0);
    int i = arrayOfPlatform.length;
    int j = 0;
    if (j < i)
    {
      Platform localPlatform = arrayOfPlatform[j];
      String str = localPlatform.getName();
      if (((localPlatform instanceof CustomPlatform)) || (ShareCore.isUseClientToShare(str))) {}
      for (;;)
      {
        j++;
        break;
        localArrayList.add(localPlatform);
      }
    }
    EditPage.access$002(this.this$0, new Platform[localArrayList.size()]);
    for (int k = 0; k < EditPage.access$000(this.this$0).length; k++) {
      EditPage.access$000(this.this$0)[k] = ((Platform)localArrayList.get(k));
    }
    UIHandler.sendEmptyMessage(1, new EditPage.1.1(this));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.EditPage.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */