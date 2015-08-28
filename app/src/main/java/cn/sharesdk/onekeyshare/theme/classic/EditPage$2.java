package cn.sharesdk.onekeyshare.theme.classic;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import cn.sharesdk.onekeyshare.PicViewer;

class EditPage$2
  implements View.OnClickListener
{
  EditPage$2(EditPage paramEditPage) {}
  
  public void onClick(View paramView)
  {
    if ((EditPage.access$100(this.this$0) != null) && (!EditPage.access$100(this.this$0).isRecycled()))
    {
      PicViewer localPicViewer = new PicViewer();
      localPicViewer.setImageBitmap(EditPage.access$100(this.this$0));
      localPicViewer.show(EditPage.access$200(this.this$0), null);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.EditPage.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */