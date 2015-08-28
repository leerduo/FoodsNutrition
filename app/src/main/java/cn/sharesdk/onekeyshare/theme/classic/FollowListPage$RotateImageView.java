package cn.sharesdk.onekeyshare.theme.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.ImageView;

class FollowListPage$RotateImageView
  extends ImageView
{
  private int rotation;
  
  public FollowListPage$RotateImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.rotate(this.rotation, getWidth() / 2, getHeight() / 2);
    super.onDraw(paramCanvas);
  }
  
  public void setRotation(int paramInt)
  {
    this.rotation = paramInt;
    invalidate();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.FollowListPage.RotateImageView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */