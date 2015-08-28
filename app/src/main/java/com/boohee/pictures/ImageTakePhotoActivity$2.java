package com.boohee.pictures;

import android.view.View;
import android.view.View.OnClickListener;

class ImageTakePhotoActivity$2
  implements View.OnClickListener
{
  ImageTakePhotoActivity$2(ImageTakePhotoActivity paramImageTakePhotoActivity) {}
  
  public void onClick(View paramView)
  {
    ImageTakePhotoActivity localImageTakePhotoActivity = this.this$0;
    IPictureUpload localIPictureUpload = ImageTakePhotoActivity.access$000();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ImageTakePhotoActivity.access$100();
    QiniuUploader.upload(localImageTakePhotoActivity, localIPictureUpload, arrayOfString);
    this.this$0.finish();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.ImageTakePhotoActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */