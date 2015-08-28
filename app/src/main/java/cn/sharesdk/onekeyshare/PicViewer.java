package cn.sharesdk.onekeyshare;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import cn.sharesdk.framework.FakeActivity;

public class PicViewer
  extends FakeActivity
  implements View.OnClickListener
{
  private ImageView ivViewer;
  private Bitmap pic;
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  public void onCreate()
  {
    this.ivViewer = new ImageView(this.activity);
    this.ivViewer.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.ivViewer.setBackgroundColor(-1073741824);
    this.ivViewer.setOnClickListener(this);
    this.activity.setContentView(this.ivViewer);
    if ((this.pic != null) && (!this.pic.isRecycled())) {
      this.ivViewer.setImageBitmap(this.pic);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.pic = paramBitmap;
    if (this.ivViewer != null) {
      this.ivViewer.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.PicViewer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */