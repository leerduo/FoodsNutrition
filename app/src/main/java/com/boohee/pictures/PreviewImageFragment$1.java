package com.boohee.pictures;

import android.widget.ProgressBar;
import com.squareup.picasso.Callback;

class PreviewImageFragment$1
  implements Callback
{
  PreviewImageFragment$1(PreviewImageFragment paramPreviewImageFragment) {}
  
  public void onError()
  {
    PreviewImageFragment.access$000(this.this$0).setVisibility(0);
  }
  
  public void onSuccess()
  {
    PreviewImageFragment.access$000(this.this$0).setVisibility(8);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.PreviewImageFragment.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */