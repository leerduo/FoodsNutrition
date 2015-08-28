package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class IcsLinearLayout
  extends LinearLayout
{
  private static final int[] a = { 16843049, 16843561, 16843562 };
  private Drawable b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  private void a(Canvas paramCanvas)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView2 = getChildAt(j);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (a(j)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        a(paramCanvas, localView2.getTop() - localLayoutParams.topMargin);
      }
    }
    View localView1;
    if (a(i))
    {
      localView1 = getChildAt(i - 1);
      if (localView1 != null) {
        break label120;
      }
    }
    label120:
    for (int k = getHeight() - getPaddingBottom() - this.d;; k = localView1.getBottom())
    {
      a(paramCanvas, k);
      return;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    this.b.setBounds(getPaddingLeft() + this.f, paramInt, getWidth() - getPaddingRight() - this.f, paramInt + this.d);
    this.b.draw(paramCanvas);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == getChildCount())) {}
    for (;;)
    {
      return false;
      if ((0x2 & this.e) != 0) {
        for (int i = paramInt - 1; i >= 0; i--) {
          if (getChildAt(i).getVisibility() != 8) {
            return true;
          }
        }
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView2 = getChildAt(j);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (a(j)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        b(paramCanvas, localView2.getLeft() - localLayoutParams.leftMargin);
      }
    }
    View localView1;
    if (a(i))
    {
      localView1 = getChildAt(i - 1);
      if (localView1 != null) {
        break label120;
      }
    }
    label120:
    for (int k = getWidth() - getPaddingRight() - this.c;; k = localView1.getRight())
    {
      b(paramCanvas, k);
      return;
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    this.b.setBounds(paramInt, getPaddingTop() + this.f, paramInt + this.c, getHeight() - getPaddingBottom() - this.f);
    this.b.draw(paramCanvas);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = indexOfChild(paramView);
    int j = getOrientation();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (a(i))
    {
      if (j == 1) {
        localLayoutParams.topMargin = this.d;
      }
    }
    else
    {
      int k = getChildCount();
      if ((i == k - 1) && (a(k)))
      {
        if (j != 1) {
          break label109;
        }
        localLayoutParams.bottomMargin = this.d;
      }
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      localLayoutParams.leftMargin = this.c;
      break;
      label109:
      localLayoutParams.rightMargin = this.c;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b != null)
    {
      if (getOrientation() != 1) {
        break label26;
      }
      a(paramCanvas);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      label26:
      b(paramCanvas);
    }
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.b) {
      return;
    }
    this.b = paramDrawable;
    if (paramDrawable != null) {
      this.c = paramDrawable.getIntrinsicWidth();
    }
    for (this.d = paramDrawable.getIntrinsicHeight();; this.d = 0)
    {
      boolean bool = false;
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      return;
      this.c = 0;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.IcsLinearLayout
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */