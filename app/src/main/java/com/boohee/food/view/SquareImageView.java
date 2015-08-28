package com.boohee.food.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class SquareImageView
  extends ImageView
{
  public SquareImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getMeasuredWidth();
    setMeasuredDimension(i, i);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.view.SquareImageView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */