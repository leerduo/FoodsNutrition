package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.ArrayList;

public class TitlePageIndicator
  extends View
  implements PageIndicator
{
  private TitlePageIndicator.OnCenterItemClickListener A;
  private ViewPager a;
  private ViewPager.OnPageChangeListener b;
  private int c;
  private float d;
  private int e;
  private final Paint f;
  private boolean g;
  private int h;
  private int i;
  private Path j;
  private final Rect k;
  private final Paint l;
  private TitlePageIndicator.IndicatorStyle m;
  private TitlePageIndicator.LinePosition n;
  private final Paint o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  private int w;
  private float x;
  private int y;
  private boolean z;
  
  private Rect a(int paramInt, Paint paramPaint)
  {
    Rect localRect = new Rect();
    CharSequence localCharSequence = a(paramInt);
    localRect.right = ((int)paramPaint.measureText(localCharSequence, 0, localCharSequence.length()));
    localRect.bottom = ((int)(paramPaint.descent() - paramPaint.ascent()));
    return localRect;
  }
  
  private CharSequence a(int paramInt)
  {
    Object localObject = this.a.getAdapter().getPageTitle(paramInt);
    if (localObject == null) {
      localObject = "";
    }
    return localObject;
  }
  
  private ArrayList<Rect> a(Paint paramPaint)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = this.a.getAdapter().getCount();
    int i2 = getWidth();
    int i3 = i2 / 2;
    for (int i4 = 0; i4 < i1; i4++)
    {
      Rect localRect = a(i4, paramPaint);
      int i5 = localRect.right - localRect.left;
      int i6 = localRect.bottom - localRect.top;
      localRect.left = ((int)(i3 - i5 / 2.0F + (i4 - this.c - this.d) * i2));
      localRect.right = (i5 + localRect.left);
      localRect.top = 0;
      localRect.bottom = i6;
      localArrayList.add(localRect);
    }
    return localArrayList;
  }
  
  private void a(Rect paramRect, float paramFloat, int paramInt)
  {
    paramRect.right = ((int)(paramInt - this.u));
    paramRect.left = ((int)(paramRect.right - paramFloat));
  }
  
  private void b(Rect paramRect, float paramFloat, int paramInt)
  {
    paramRect.left = ((int)(paramInt + this.u));
    paramRect.right = ((int)(paramFloat + this.u));
  }
  
  public float getClipPadding()
  {
    return this.u;
  }
  
  public int getFooterColor()
  {
    return this.l.getColor();
  }
  
  public float getFooterIndicatorHeight()
  {
    return this.p;
  }
  
  public float getFooterIndicatorPadding()
  {
    return this.r;
  }
  
  public TitlePageIndicator.IndicatorStyle getFooterIndicatorStyle()
  {
    return this.m;
  }
  
  public float getFooterLineHeight()
  {
    return this.v;
  }
  
  public TitlePageIndicator.LinePosition getLinePosition()
  {
    return this.n;
  }
  
  public int getSelectedColor()
  {
    return this.i;
  }
  
  public int getTextColor()
  {
    return this.h;
  }
  
  public float getTextSize()
  {
    return this.f.getTextSize();
  }
  
  public float getTitlePadding()
  {
    return this.s;
  }
  
  public float getTopPadding()
  {
    return this.t;
  }
  
  public Typeface getTypeface()
  {
    return this.f.getTypeface();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a == null) {}
    int i1;
    do
    {
      return;
      i1 = this.a.getAdapter().getCount();
    } while (i1 == 0);
    if ((this.c == -1) && (this.a != null)) {
      this.c = this.a.getCurrentItem();
    }
    ArrayList localArrayList = a(this.f);
    int i2 = localArrayList.size();
    if (this.c >= i2)
    {
      setCurrentItem(i2 - 1);
      return;
    }
    int i3 = i1 - 1;
    float f1 = getWidth() / 2.0F;
    int i4 = getLeft();
    float f2 = i4 + this.u;
    int i5 = getWidth();
    int i6 = getHeight();
    int i7 = i4 + i5;
    float f3 = i7 - this.u;
    int i8 = this.c;
    int i10;
    float f5;
    int i11;
    if (this.d <= 0.5D)
    {
      float f18 = this.d;
      i10 = i8;
      f5 = f18;
      if (f5 > 0.25F) {
        break label446;
      }
      i11 = 1;
      label189:
      if (f5 > 0.05F) {
        break label452;
      }
    }
    float f6;
    label446:
    label452:
    for (int i12 = 1;; i12 = 0)
    {
      f6 = (0.25F - f5) / 0.25F;
      Rect localRect1 = (Rect)localArrayList.get(this.c);
      float f7 = localRect1.right - localRect1.left;
      if (localRect1.left < f2) {
        b(localRect1, f7, i4);
      }
      if (localRect1.right > f3) {
        a(localRect1, f7, i7);
      }
      if (this.c <= 0) {
        break label458;
      }
      for (int i20 = -1 + this.c; i20 >= 0; i20--)
      {
        Rect localRect7 = (Rect)localArrayList.get(i20);
        if (localRect7.left < f2)
        {
          int i21 = localRect7.right - localRect7.left;
          b(localRect7, i21, i4);
          Rect localRect8 = (Rect)localArrayList.get(i20 + 1);
          if (localRect7.right + this.s > localRect8.left)
          {
            localRect7.left = ((int)(localRect8.left - i21 - this.s));
            localRect7.right = (i21 + localRect7.left);
          }
        }
      }
      int i9 = i8 + 1;
      float f4 = 1.0F - this.d;
      i10 = i9;
      f5 = f4;
      break;
      i11 = 0;
      break label189;
    }
    label458:
    if (this.c < i3) {
      for (int i18 = 1 + this.c; i18 < i1; i18++)
      {
        Rect localRect5 = (Rect)localArrayList.get(i18);
        if (localRect5.right > f3)
        {
          int i19 = localRect5.right - localRect5.left;
          a(localRect5, i19, i7);
          Rect localRect6 = (Rect)localArrayList.get(i18 - 1);
          if (localRect5.left - this.s < localRect6.right)
          {
            localRect5.left = ((int)(localRect6.right + this.s));
            localRect5.right = (i19 + localRect5.left);
          }
        }
      }
    }
    int i13 = this.h >>> 24;
    int i14 = 0;
    if (i14 < i1)
    {
      Rect localRect3 = (Rect)localArrayList.get(i14);
      int i16;
      label677:
      CharSequence localCharSequence;
      Paint localPaint;
      if (((localRect3.left > i4) && (localRect3.left < i7)) || ((localRect3.right > i4) && (localRect3.right < i7)))
      {
        if (i14 != i10) {
          break label961;
        }
        i16 = 1;
        localCharSequence = a(i14);
        localPaint = this.f;
        if ((i16 == 0) || (i12 == 0) || (!this.g)) {
          break label967;
        }
      }
      label961:
      label967:
      for (boolean bool = true;; bool = false)
      {
        localPaint.setFakeBoldText(bool);
        this.f.setColor(this.h);
        if ((i16 != 0) && (i11 != 0)) {
          this.f.setAlpha(i13 - (int)(f6 * i13));
        }
        if (i14 < i2 - 1)
        {
          Rect localRect4 = (Rect)localArrayList.get(i14 + 1);
          if (localRect3.right + this.s > localRect4.left)
          {
            int i17 = localRect3.right - localRect3.left;
            localRect3.left = ((int)(localRect4.left - i17 - this.s));
            localRect3.right = (i17 + localRect3.left);
          }
        }
        paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect3.left, localRect3.bottom + this.t, this.f);
        if ((i16 != 0) && (i11 != 0))
        {
          this.f.setColor(this.i);
          this.f.setAlpha((int)(f6 * (this.i >>> 24)));
          paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect3.left, localRect3.bottom + this.t, this.f);
        }
        i14++;
        break;
        i16 = 0;
        break label677;
      }
    }
    float f8 = this.v;
    float f9 = this.p;
    int i15;
    float f11;
    float f10;
    if (this.n == TitlePageIndicator.LinePosition.b)
    {
      i15 = 0;
      float f16 = -f8;
      float f17 = -f9;
      f11 = f16;
      f10 = f17;
    }
    for (;;)
    {
      this.j.reset();
      this.j.moveTo(0.0F, i15 - f11 / 2.0F);
      this.j.lineTo(i5, i15 - f11 / 2.0F);
      this.j.close();
      paramCanvas.drawPath(this.j, this.l);
      float f12 = i15 - f11;
      switch (TitlePageIndicator.1.a[this.m.ordinal()])
      {
      default: 
        return;
      case 1: 
        this.j.reset();
        this.j.moveTo(f1, f12 - f10);
        this.j.lineTo(f1 + f10, f12);
        this.j.lineTo(f1 - f10, f12);
        this.j.close();
        paramCanvas.drawPath(this.j, this.o);
        return;
      }
      if ((i11 == 0) || (i10 >= i2)) {
        break;
      }
      Rect localRect2 = (Rect)localArrayList.get(i10);
      float f13 = localRect2.right + this.q;
      float f14 = localRect2.left - this.q;
      float f15 = f12 - f10;
      this.j.reset();
      this.j.moveTo(f14, f12);
      this.j.lineTo(f13, f12);
      this.j.lineTo(f13, f15);
      this.j.lineTo(f14, f15);
      this.j.close();
      this.o.setAlpha((int)(255.0F * f6));
      paramCanvas.drawPath(this.j, this.o);
      this.o.setAlpha(255);
      return;
      i15 = i6;
      f10 = f9;
      f11 = f8;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    float f1;
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
      f1 = View.MeasureSpec.getSize(paramInt2);
    }
    for (;;)
    {
      setMeasuredDimension(i1, (int)f1);
      return;
      this.k.setEmpty();
      this.k.bottom = ((int)(this.f.descent() - this.f.ascent()));
      f1 = this.k.bottom - this.k.top + this.v + this.r + this.t;
      if (this.m != TitlePageIndicator.IndicatorStyle.a) {
        f1 += this.p;
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.e = paramInt;
    if (this.b != null) {
      this.b.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramFloat;
    invalidate();
    if (this.b != null) {
      this.b.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.e == 0)
    {
      this.c = paramInt;
      invalidate();
    }
    if (this.b != null) {
      this.b.onPageSelected(paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    TitlePageIndicator.SavedState localSavedState = (TitlePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.c = localSavedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    TitlePageIndicator.SavedState localSavedState = new TitlePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.c;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.onTouchEvent(paramMotionEvent)) {}
    label358:
    do
    {
      int i1;
      do
      {
        int i5;
        float f4;
        float f5;
        do
        {
          float f7;
          do
          {
            float f6;
            do
            {
              return true;
              if ((this.a == null) || (this.a.getAdapter().getCount() == 0)) {
                return false;
              }
              i1 = 0xFF & paramMotionEvent.getAction();
              switch (i1)
              {
              case 4: 
              default: 
                return true;
              case 0: 
                this.y = MotionEventCompat.getPointerId(paramMotionEvent, 0);
                this.x = paramMotionEvent.getX();
                return true;
              case 2: 
                f6 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.y));
                f7 = f6 - this.x;
                if ((!this.z) && (Math.abs(f7) > this.w)) {
                  this.z = true;
                }
                break;
              }
            } while (!this.z);
            this.x = f6;
          } while ((!this.a.isFakeDragging()) && (!this.a.beginFakeDrag()));
          this.a.fakeDragBy(f7);
          return true;
          if (this.z) {
            break label358;
          }
          i5 = this.a.getAdapter().getCount();
          int i6 = getWidth();
          float f1 = i6 / 2.0F;
          float f2 = i6 / 6.0F;
          float f3 = f1 - f2;
          f4 = f2 + f1;
          f5 = paramMotionEvent.getX();
          if (f5 >= f3) {
            break;
          }
          if (this.c <= 0) {
            break label358;
          }
        } while (i1 == 3);
        this.a.setCurrentItem(-1 + this.c);
        return true;
        if (f5 <= f4) {
          break;
        }
        if (this.c >= i5 - 1) {
          break label358;
        }
      } while (i1 == 3);
      this.a.setCurrentItem(1 + this.c);
      return true;
      if ((this.A != null) && (i1 != 3)) {
        this.A.a(this.c);
      }
      this.z = false;
      this.y = -1;
    } while (!this.a.isFakeDragging());
    this.a.endFakeDrag();
    return true;
    int i4 = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.x = MotionEventCompat.getX(paramMotionEvent, i4);
    this.y = MotionEventCompat.getPointerId(paramMotionEvent, i4);
    return true;
    int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i2) == this.y)
    {
      int i3 = 0;
      if (i2 == 0) {
        i3 = 1;
      }
      this.y = MotionEventCompat.getPointerId(paramMotionEvent, i3);
    }
    this.x = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.y));
    return true;
  }
  
  public void setClipPadding(float paramFloat)
  {
    this.u = paramFloat;
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.a == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.a.setCurrentItem(paramInt);
    this.c = paramInt;
    invalidate();
  }
  
  public void setFooterColor(int paramInt)
  {
    this.l.setColor(paramInt);
    this.o.setColor(paramInt);
    invalidate();
  }
  
  public void setFooterIndicatorHeight(float paramFloat)
  {
    this.p = paramFloat;
    invalidate();
  }
  
  public void setFooterIndicatorPadding(float paramFloat)
  {
    this.r = paramFloat;
    invalidate();
  }
  
  public void setFooterIndicatorStyle(TitlePageIndicator.IndicatorStyle paramIndicatorStyle)
  {
    this.m = paramIndicatorStyle;
    invalidate();
  }
  
  public void setFooterLineHeight(float paramFloat)
  {
    this.v = paramFloat;
    this.l.setStrokeWidth(this.v);
    invalidate();
  }
  
  public void setLinePosition(TitlePageIndicator.LinePosition paramLinePosition)
  {
    this.n = paramLinePosition;
    invalidate();
  }
  
  public void setOnCenterItemClickListener(TitlePageIndicator.OnCenterItemClickListener paramOnCenterItemClickListener)
  {
    this.A = paramOnCenterItemClickListener;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.b = paramOnPageChangeListener;
  }
  
  public void setSelectedBold(boolean paramBoolean)
  {
    this.g = paramBoolean;
    invalidate();
  }
  
  public void setSelectedColor(int paramInt)
  {
    this.i = paramInt;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.f.setColor(paramInt);
    this.h = paramInt;
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.f.setTextSize(paramFloat);
    invalidate();
  }
  
  public void setTitlePadding(float paramFloat)
  {
    this.s = paramFloat;
    invalidate();
  }
  
  public void setTopPadding(float paramFloat)
  {
    this.t = paramFloat;
    invalidate();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.f.setTypeface(paramTypeface);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.a == paramViewPager) {
      return;
    }
    if (this.a != null) {
      this.a.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.a = paramViewPager;
    this.a.setOnPageChangeListener(this);
    invalidate();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.TitlePageIndicator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */