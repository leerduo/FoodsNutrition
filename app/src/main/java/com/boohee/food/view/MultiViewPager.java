package com.boohee.food.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.boohee.food.R.styleable;

public class MultiViewPager
  extends ViewPager
{
  private int a = -1;
  private int b = -1;
  private int c;
  private boolean d;
  
  public MultiViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setClipChildren(false);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MultiViewPager);
    setMaxWidth(localTypedArray.getDimensionPixelSize(0, -1));
    setMaxHeight(localTypedArray.getDimensionPixelSize(1, -1));
    setMatchChildWidth(localTypedArray.getResourceId(2, 0));
    localTypedArray.recycle();
  }
  
  private static void a(Point paramPoint1, Point paramPoint2)
  {
    if ((paramPoint2.x >= 0) && (paramPoint1.x > paramPoint2.x)) {
      paramPoint1.x = paramPoint2.x;
    }
    if ((paramPoint2.y >= 0) && (paramPoint1.y > paramPoint2.y)) {
      paramPoint1.y = paramPoint2.y;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (!this.d) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (this.c == 0)
        {
          this.d = false;
          return;
        }
      } while (getChildCount() <= 0);
      View localView1 = getChildAt(0);
      localView1.measure(paramInt1, paramInt2);
      i = localView1.getMeasuredWidth();
      View localView2 = localView1.findViewById(this.c);
      if (localView2 == null) {
        throw new NullPointerException("MatchWithChildResId did not find that ID in the first fragment of the ViewPager; is that view defined in the child view's layout? Note that MultiViewPager only measures the child for index 0.");
      }
      j = localView2.getMeasuredWidth();
    } while (j <= 0);
    this.d = false;
    setPageMargin(-(i - j));
    setOffscreenPageLimit(1 + (int)Math.ceil(i / j));
    requestLayout();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    if ((this.a >= 0) || (this.b >= 0))
    {
      a(localPoint, new Point(this.a, this.b));
      paramInt1 = View.MeasureSpec.makeMeasureSpec(localPoint.x, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(localPoint.y, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    a(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = true;
  }
  
  public void setMatchChildWidth(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      this.d = true;
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.view.MultiViewPager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */