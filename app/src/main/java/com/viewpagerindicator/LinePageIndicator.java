package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;

public class LinePageIndicator
  extends View
  implements PageIndicator
{
  private final Paint a = new Paint(1);
  private final Paint b = new Paint(1);
  private ViewPager c;
  private ViewPager.OnPageChangeListener d;
  private int e;
  private boolean f;
  private float g;
  private float h;
  private int i;
  private float j = -1.0F;
  private int k = -1;
  private boolean l;
  
  public LinePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.vpiLinePageIndicatorStyle);
  }
  
  public LinePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    Resources localResources = getResources();
    int m = localResources.getColor(R.color.default_line_indicator_selected_color);
    int n = localResources.getColor(R.color.default_line_indicator_unselected_color);
    float f1 = localResources.getDimension(R.dimen.default_line_indicator_line_width);
    float f2 = localResources.getDimension(R.dimen.default_line_indicator_gap_width);
    float f3 = localResources.getDimension(R.dimen.default_line_indicator_stroke_width);
    boolean bool = localResources.getBoolean(R.bool.default_line_indicator_centered);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinePageIndicator, paramInt, 0);
    this.f = localTypedArray.getBoolean(1, bool);
    this.g = localTypedArray.getDimension(5, f1);
    this.h = localTypedArray.getDimension(6, f2);
    setStrokeWidth(localTypedArray.getDimension(3, f3));
    this.a.setColor(localTypedArray.getColor(4, n));
    this.b.setColor(localTypedArray.getColor(2, m));
    Drawable localDrawable = localTypedArray.getDrawable(0);
    if (localDrawable != null) {
      setBackgroundDrawable(localDrawable);
    }
    localTypedArray.recycle();
    this.i = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }
  
  private int a(int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    int n = View.MeasureSpec.getSize(paramInt);
    float f1;
    if ((m == 1073741824) || (this.c == null)) {
      f1 = n;
    }
    for (;;)
    {
      return (int)FloatMath.ceil(f1);
      int i1 = this.c.getAdapter().getCount();
      f1 = getPaddingLeft() + getPaddingRight() + i1 * this.g + (i1 - 1) * this.h;
      if (m == -2147483648) {
        f1 = Math.min(f1, n);
      }
    }
  }
  
  private int b(int paramInt)
  {
    int m = View.MeasureSpec.getMode(paramInt);
    int n = View.MeasureSpec.getSize(paramInt);
    float f1;
    if (m == 1073741824) {
      f1 = n;
    }
    for (;;)
    {
      return (int)FloatMath.ceil(f1);
      f1 = this.b.getStrokeWidth() + getPaddingTop() + getPaddingBottom();
      if (m == -2147483648) {
        f1 = Math.min(f1, n);
      }
    }
  }
  
  public float getGapWidth()
  {
    return this.h;
  }
  
  public float getLineWidth()
  {
    return this.g;
  }
  
  public int getSelectedColor()
  {
    return this.b.getColor();
  }
  
  public float getStrokeWidth()
  {
    return this.b.getStrokeWidth();
  }
  
  public int getUnselectedColor()
  {
    return this.a.getColor();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c == null) {}
    int m;
    do
    {
      return;
      m = this.c.getAdapter().getCount();
    } while (m == 0);
    if (this.e >= m)
    {
      setCurrentItem(m - 1);
      return;
    }
    float f1 = this.g + this.h;
    float f2 = f1 * m - this.h;
    float f3 = getPaddingTop();
    float f4 = getPaddingLeft();
    float f5 = getPaddingRight();
    float f6 = f3 + (getHeight() - f3 - getPaddingBottom()) / 2.0F;
    if (this.f) {}
    for (float f7 = f4 + ((getWidth() - f4 - f5) / 2.0F - f2 / 2.0F);; f7 = f4)
    {
      int n = 0;
      label140:
      float f8;
      float f9;
      if (n < m)
      {
        f8 = f7 + f1 * n;
        f9 = f8 + this.g;
        if (n != this.e) {
          break label200;
        }
      }
      label200:
      for (Paint localPaint = this.b;; localPaint = this.a)
      {
        paramCanvas.drawLine(f8, f6, f9, f6, localPaint);
        n++;
        break label140;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.d != null) {
      this.d.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.d != null) {
      this.d.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.e = paramInt;
    invalidate();
    if (this.d != null) {
      this.d.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    LinePageIndicator.SavedState localSavedState = (LinePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.e = localSavedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    LinePageIndicator.SavedState localSavedState = new LinePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.e;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.onTouchEvent(paramMotionEvent)) {}
    label323:
    do
    {
      int m;
      do
      {
        int i3;
        float f1;
        float f2;
        do
        {
          float f4;
          do
          {
            float f3;
            do
            {
              return true;
              if ((this.c == null) || (this.c.getAdapter().getCount() == 0)) {
                return false;
              }
              m = 0xFF & paramMotionEvent.getAction();
              switch (m)
              {
              case 4: 
              default: 
                return true;
              case 0: 
                this.k = MotionEventCompat.getPointerId(paramMotionEvent, 0);
                this.j = paramMotionEvent.getX();
                return true;
              case 2: 
                f3 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.k));
                f4 = f3 - this.j;
                if ((!this.l) && (Math.abs(f4) > this.i)) {
                  this.l = true;
                }
                break;
              }
            } while (!this.l);
            this.j = f3;
          } while ((!this.c.isFakeDragging()) && (!this.c.beginFakeDrag()));
          this.c.fakeDragBy(f4);
          return true;
          if (this.l) {
            break label323;
          }
          i3 = this.c.getAdapter().getCount();
          int i4 = getWidth();
          f1 = i4 / 2.0F;
          f2 = i4 / 6.0F;
          if ((this.e <= 0) || (paramMotionEvent.getX() >= f1 - f2)) {
            break;
          }
        } while (m == 3);
        this.c.setCurrentItem(-1 + this.e);
        return true;
        if ((this.e >= i3 - 1) || (paramMotionEvent.getX() <= f2 + f1)) {
          break;
        }
      } while (m == 3);
      this.c.setCurrentItem(1 + this.e);
      return true;
      this.l = false;
      this.k = -1;
    } while (!this.c.isFakeDragging());
    this.c.endFakeDrag();
    return true;
    int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.j = MotionEventCompat.getX(paramMotionEvent, i2);
    this.k = MotionEventCompat.getPointerId(paramMotionEvent, i2);
    return true;
    int n = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, n) == this.k)
    {
      int i1 = 0;
      if (n == 0) {
        i1 = 1;
      }
      this.k = MotionEventCompat.getPointerId(paramMotionEvent, i1);
    }
    this.j = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.k));
    return true;
  }
  
  public void setCentered(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.c == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.c.setCurrentItem(paramInt);
    this.e = paramInt;
    invalidate();
  }
  
  public void setGapWidth(float paramFloat)
  {
    this.h = paramFloat;
    invalidate();
  }
  
  public void setLineWidth(float paramFloat)
  {
    this.g = paramFloat;
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.d = paramOnPageChangeListener;
  }
  
  public void setSelectedColor(int paramInt)
  {
    this.b.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.b.setStrokeWidth(paramFloat);
    this.a.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setUnselectedColor(int paramInt)
  {
    this.a.setColor(paramInt);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.c == paramViewPager) {
      return;
    }
    if (this.c != null) {
      this.c.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.c = paramViewPager;
    this.c.setOnPageChangeListener(this);
    invalidate();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.LinePageIndicator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */