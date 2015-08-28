package com.boohee.pictures;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;
import java.util.LinkedList;

class ImageGridAdapter$CheckBoxClickListener
  implements View.OnClickListener
{
  private int mPosition;
  
  ImageGridAdapter$CheckBoxClickListener(ImageGridAdapter paramImageGridAdapter, int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = (CheckBox)paramView;
    if ((localCheckBox.isChecked()) && (ImageGridAdapter.access$000(this.this$0).size() >= PictureUpload.sMaxPicNumber))
    {
      Toast.makeText(ImageGridAdapter.access$100(this.this$0), "图片数已达上限！", 0).show();
      localCheckBox.setChecked(false);
      return;
    }
    ImageGridAdapter.access$200(this.this$0)[this.mPosition] = ((CheckBox)paramView).isChecked();
    if (((CheckBox)paramView).isChecked()) {
      ImageGridAdapter.access$000(this.this$0).addLast(ImageGridAdapter.access$300(this.this$0, this.mPosition));
    }
    for (;;)
    {
      ((ImageGridViewActivity)ImageGridAdapter.access$100(this.this$0)).updateMenuItem(ImageGridAdapter.access$000(this.this$0).size());
      return;
      ImageGridAdapter.access$000(this.this$0).removeLast();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.ImageGridAdapter.CheckBoxClickListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */