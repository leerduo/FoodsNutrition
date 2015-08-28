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

public class UnderlinePageIndicator
  extends View
  implements PageIndicator
{
  private final Paint a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private ViewPager f;
  private ViewPager.OnPageChangeListener g;
  private int h;
  private int i;
  private float j;
  private int k;
  private float l;
  private int m;
  private boolean n;
  private final Runnable o;
  
  public int getFadeDelay()
  {
    return this.c;
  }
  
  public int getFadeLength()
  {
    return this.d;
  }
  
  public boolean getFades()
  {
    return this.b;
  }
  
  public int getSelectedColor()
  {
    return this.a.getColor();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.f == null) {}
    int i1;
    do
    {
      return;
      i1 = this.f.getAdapter().getCount();
    } while (i1 == 0);
    if (this.i >= i1)
    {
      setCurrentItem(i1 - 1);
      return;
    }
    int i2 = getPaddingLeft();
    float f1 = (getWidth() - i2 - getPaddingRight()) / (1.0F * i1);
    float f2 = i2 + f1 * (this.i + this.j);
    float f3 = f2 + f1;
    paramCanvas.drawRect(f2, getPaddingTop(), f3, getHeight() - getPaddingBottom(), this.a);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.h = paramInt;
    if (this.g != null) {
      this.g.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramFloat;
    if (this.b)
    {
      if (paramInt2 <= 0) {
        break label64;
      }
      removeCallbacks(this.o);
      this.a.setAlpha(255);
    }
    for (;;)
    {
      invalidate();
      if (this.g != null) {
        this.g.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      return;
      label64:
      if (this.h != 1) {
        postDelayed(this.o, this.c);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.h == 0)
    {
      this.i = paramInt;
      this.j = 0.0F;
      invalidate();
      this.o.run();
    }
    if (this.g != null) {
      this.g.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    UnderlinePageIndicator.SavedState localSavedState = (UnderlinePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.i = localSavedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    UnderlinePageIndicator.SavedState localSavedState = new UnderlinePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.i;
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
              if ((this.f == null) || (this.f.getAdapter().getCount() == 0)) {
                return false;
              }
              i1 = 0xFF & paramMotionEvent.getAction();
              switch (i1)
              {
              case 4: 
              default: 
                return true;
              case 0: 
                this.m = MotionEventCompat.getPointerId(paramMotionEvent, 0);
                this.l = paramMotionEvent.getX();
                return true;
              case 2: 
                f3 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.m));
                f4 = f3 - this.l;
                if ((!this.n) && (Math.abs(f4) > this.k)) {
                  this.n = true;
                }
                break;
              }
            } while (!this.n);
            this.l = f3;
          } while ((!this.f.isFakeDragging()) && (!this.f.beginFakeDrag()));
          this.f.fakeDragBy(f4);
          return true;
          if (this.n) {
            break label322;
          }
          i5 = this.f.getAdapter().getCount();
          int i6 = getWidth();
          f1 = i6 / 2.0F;
          f2 = i6 / 6.0F;
          if ((this.i <= 0) || (paramMotionEvent.getX() >= f1 - f2)) {
            break;
          }
        } while (i1 == 3);
        this.f.setCurrentItem(-1 + this.i);
        return true;
        if ((this.i >= i5 - 1) || (paramMotionEvent.getX() <= f2 + f1)) {
          break;
        }
      } while (i1 == 3);
      this.f.setCurrentItem(1 + this.i);
      return true;
      this.n = false;
      this.m = -1;
    } while (!this.f.isFakeDragging());
    this.f.endFakeDrag();
    return true;
    int i4 = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.l = MotionEventCompat.getX(paramMotionEvent, i4);
    this.m = MotionEventCompat.getPointerId(paramMotionEvent, i4);
    return true;
    int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i2) == this.m)
    {
      int i3 = 0;
      if (i2 == 0) {
        i3 = 1;
      }
      this.m = MotionEventCompat.getPointerId(paramMotionEvent, i3);
    }
    this.l = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.m));
    return true;
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.f == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.f.setCurrentItem(paramInt);
    this.i = paramInt;
    invalidate();
  }
  
  public void setFadeDelay(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setFadeLength(int paramInt)
  {
    this.d = paramInt;
    this.e = (255 / (this.d / 30));
  }
  
  public void setFades(boolean paramBoolean)
  {
    if (paramBoolean != this.b)
    {
      this.b = paramBoolean;
      if (paramBoolean) {
        post(this.o);
      }
    }
    else
    {
      return;
    }
    removeCallbacks(this.o);
    this.a.setAlpha(255);
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.g = paramOnPageChangeListener;
  }
  
  public void setSelectedColor(int paramInt)
  {
    this.a.setColor(paramInt);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.f == paramViewPager) {
      return;
    }
    if (this.f != null) {
      this.f.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.f = paramViewPager;
    this.f.setOnPageChangeListener(this);
    invalidate();
    post(new UnderlinePageIndicator.2(this));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.UnderlinePageIndicator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */