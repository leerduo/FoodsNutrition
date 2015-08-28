package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;

public class CirclePageIndicator
  extends View
  implements PageIndicator
{
  private float a;
  private final Paint b;
  private final Paint c;
  private final Paint d;
  private ViewPager e;
  private ViewPager.OnPageChangeListener f;
  private int g;
  private int h;
  private float i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private int n;
  private float o;
  private int p;
  private boolean q;
  
  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    int i3;
    if ((i1 == 1073741824) || (this.e == null)) {
      i3 = i2;
    }
    do
    {
      return i3;
      int i4 = this.e.getAdapter().getCount();
      i3 = (int)(1.0F + (getPaddingLeft() + getPaddingRight() + i4 * 2 * this.a + (i4 - 1) * this.a));
    } while (i1 != -2147483648);
    return Math.min(i3, i2);
  }
  
  private int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824) {
      return i2;
    }
    int i3 = (int)(1.0F + (2.0F * this.a + getPaddingTop() + getPaddingBottom()));
    if (i1 == -2147483648) {
      return Math.min(i3, i2);
    }
    return i3;
  }
  
  public int getFillColor()
  {
    return this.d.getColor();
  }
  
  public int getOrientation()
  {
    return this.k;
  }
  
  public int getPageColor()
  {
    return this.b.getColor();
  }
  
  public float getRadius()
  {
    return this.a;
  }
  
  public int getStrokeColor()
  {
    return this.c.getColor();
  }
  
  public float getStrokeWidth()
  {
    return this.c.getStrokeWidth();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.e == null) {}
    int i1;
    do
    {
      return;
      i1 = this.e.getAdapter().getCount();
    } while (i1 == 0);
    if (this.g >= i1)
    {
      setCurrentItem(i1 - 1);
      return;
    }
    int i2;
    int i3;
    int i4;
    int i5;
    float f1;
    float f2;
    float f3;
    float f4;
    int i6;
    label168:
    float f8;
    float f9;
    if (this.k == 0)
    {
      i2 = getWidth();
      i3 = getPaddingLeft();
      i4 = getPaddingRight();
      i5 = getPaddingTop();
      f1 = 3.0F * this.a;
      f2 = i5 + this.a;
      f3 = i3 + this.a;
      if (this.l) {
        f3 += (i2 - i3 - i4) / 2.0F - f1 * i1 / 2.0F;
      }
      f4 = this.a;
      if (this.c.getStrokeWidth() > 0.0F) {
        f4 -= this.c.getStrokeWidth() / 2.0F;
      }
      i6 = 0;
      if (i6 >= i1) {
        break label289;
      }
      f8 = f3 + f1 * i6;
      if (this.k != 0) {
        break label282;
      }
      f9 = f8;
      f8 = f2;
    }
    for (;;)
    {
      if (this.b.getAlpha() > 0) {
        paramCanvas.drawCircle(f9, f8, f4, this.b);
      }
      if (f4 != this.a) {
        paramCanvas.drawCircle(f9, f8, this.a, this.c);
      }
      i6++;
      break label168;
      i2 = getHeight();
      i3 = getPaddingTop();
      i4 = getPaddingBottom();
      i5 = getPaddingLeft();
      break;
      label282:
      f9 = f2;
    }
    label289:
    int i7;
    float f5;
    float f7;
    if (this.m)
    {
      i7 = this.h;
      f5 = f1 * i7;
      if (!this.m) {
        f5 += f1 * this.i;
      }
      if (this.k != 0) {
        break label369;
      }
      f7 = f3 + f5;
    }
    for (;;)
    {
      paramCanvas.drawCircle(f7, f2, this.a, this.d);
      return;
      i7 = this.g;
      break;
      label369:
      float f6 = f3 + f5;
      f7 = f2;
      f2 = f6;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.k == 0)
    {
      setMeasuredDimension(a(paramInt1), b(paramInt2));
      return;
    }
    setMeasuredDimension(b(paramInt1), a(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.j = paramInt;
    if (this.f != null) {
      this.f.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.g = paramInt1;
    this.i = paramFloat;
    invalidate();
    if (this.f != null) {
      this.f.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.m) || (this.j == 0))
    {
      this.g = paramInt;
      this.h = paramInt;
      invalidate();
    }
    if (this.f != null) {
      this.f.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    CirclePageIndicator.SavedState localSavedState = (CirclePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.g = localSavedState.a;
    this.h = localSavedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    CirclePageIndicator.SavedState localSavedState = new CirclePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.g;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.onTouchEvent(paramMotionEvent)) {}
    label322:
    do
    {
      int i1;
      do
      {
        int i5;
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
              if ((this.e == null) || (this.e.getAdapter().getCount() == 0)) {
                return false;
              }
              i1 = 0xFF & paramMotionEvent.getAction();
              switch (i1)
              {
              case 4: 
              default: 
                return true;
              case 0: 
                this.p = MotionEventCompat.getPointerId(paramMotionEvent, 0);
                this.o = paramMotionEvent.getX();
                return true;
              case 2: 
                f3 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.p));
                f4 = f3 - this.o;
                if ((!this.q) && (Math.abs(f4) > this.n)) {
                  this.q = true;
                }
                break;
              }
            } while (!this.q);
            this.o = f3;
          } while ((!this.e.isFakeDragging()) && (!this.e.beginFakeDrag()));
          this.e.fakeDragBy(f4);
          return true;
          if (this.q) {
            break label322;
          }
          i5 = this.e.getAdapter().getCount();
          int i6 = getWidth();
          f1 = i6 / 2.0F;
          f2 = i6 / 6.0F;
          if ((this.g <= 0) || (paramMotionEvent.getX() >= f1 - f2)) {
            break;
          }
        } while (i1 == 3);
        this.e.setCurrentItem(-1 + this.g);
        return true;
        if ((this.g >= i5 - 1) || (paramMotionEvent.getX() <= f2 + f1)) {
          break;
        }
      } while (i1 == 3);
      this.e.setCurrentItem(1 + this.g);
      return true;
      this.q = false;
      this.p = -1;
    } while (!this.e.isFakeDragging());
    this.e.endFakeDrag();
    return true;
    int i4 = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.o = MotionEventCompat.getX(paramMotionEvent, i4);
    this.p = MotionEventCompat.getPointerId(paramMotionEvent, i4);
    return true;
    int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i2) == this.p)
    {
      int i3 = 0;
      if (i2 == 0) {
        i3 = 1;
      }
      this.p = MotionEventCompat.getPointerId(paramMotionEvent, i3);
    }
    this.o = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.p));
    return true;
  }
  
  public void setCentered(boolean paramBoolean)
  {
    this.l = paramBoolean;
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.e == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.e.setCurrentItem(paramInt);
    this.g = paramInt;
    invalidate();
  }
  
  public void setFillColor(int paramInt)
  {
    this.d.setColor(paramInt);
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.f = paramOnPageChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }
    this.k = paramInt;
    requestLayout();
  }
  
  public void setPageColor(int paramInt)
  {
    this.b.setColor(paramInt);
    invalidate();
  }
  
  public void setRadius(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }
  
  public void setSnap(boolean paramBoolean)
  {
    this.m = paramBoolean;
    invalidate();
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.c.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.c.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.e == paramViewPager) {
      return;
    }
    if (this.e != null) {
      this.e.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.e = paramViewPager;
    this.e.setOnPageChangeListener(this);
    invalidate();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.CirclePageIndicator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */