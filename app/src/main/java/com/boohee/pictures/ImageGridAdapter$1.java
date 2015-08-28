package com.boohee.pictures;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

class ImageGridAdapter$1
  implements Callback
{
  ImageGridAdapter$1(ImageGridAdapter paramImageGridAdapter, ImageGridAdapter.ViewHolder paramViewHolder, long paramLong) {}
  
  public void onError() {}
  
  public void onSuccess()
  {
    this.val$holder.imageView.setTag(this.val$id + "");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.ImageGridAdapter.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */