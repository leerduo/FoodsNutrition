package cn.sharesdk.onekeyshare.theme.classic;

import android.os.Handler.Callback;
import android.os.Message;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

class EditPage$6
  implements Handler.Callback
{
  EditPage$6(EditPage paramEditPage, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    ((HorizontalScrollView)EditPage.access$1000(this.this$0).getParent()).scrollTo(this.val$postSel * (this.val$dp_24 + this.val$dp_9), 0);
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.EditPage.6
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */