package com.boohee.pictures;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

class ImageGridViewActivity$ItemClickListener
  implements AdapterView.OnItemClickListener
{
  private ImageGridViewActivity$ItemClickListener(ImageGridViewActivity paramImageGridViewActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PictureHelper.getPicturePath(paramInt, ImageGridViewActivity.access$100(this.this$0).getCursor()));
    PreviewImageActivity.startMe(ImageGridViewActivity.access$200(this.this$0), localArrayList);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.ImageGridViewActivity.ItemClickListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */