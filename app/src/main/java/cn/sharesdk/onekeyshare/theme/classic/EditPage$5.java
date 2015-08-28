package cn.sharesdk.onekeyshare.theme.classic;

import android.view.View;
import android.view.View.OnClickListener;
import cn.sharesdk.framework.Platform;
import java.util.List;

class EditPage$5
  implements View.OnClickListener
{
  EditPage$5(EditPage paramEditPage) {}
  
  public void onClick(View paramView)
  {
    FollowListPage localFollowListPage = new FollowListPage();
    localFollowListPage.setPlatform((Platform)EditPage.access$800(this.this$0).get(0));
    localFollowListPage.showForResult(EditPage.access$900(this.this$0), null, this.this$0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.EditPage.5
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */