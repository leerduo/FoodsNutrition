package com.viewpagerindicator;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class IconPageIndicator
  extends HorizontalScrollView
  implements PageIndicator
{
  private final IcsLinearLayout a;
  private ViewPager b;
  private ViewPager.OnPageChangeListener c;
  private Runnable d;
  private int e;
  
  private void a(int paramInt)
  {
    View localView = this.a.getChildAt(paramInt);
    if (this.d != null) {
      removeCallbacks(this.d);
    }
    this.d = new IconPageIndicator.1(this, localView);
    post(this.d);
  }
  
  public void a()
  {
    this.a.removeAllViews();
    IconPagerAdapter localIconPagerAdapter = (IconPagerAdapter)this.b.getAdapter();
    int i = localIconPagerAdapter.a();
    for (int j = 0; j < i; j++)
    {
      ImageView localImageView = new ImageView(getContext(), null, R.attr.vpiIconPageIndicatorStyle);
      localImageView.setImageResource(localIconPagerAdapter.a(j));
      this.a.addView(localImageView);
    }
    if (this.e > i) {
      this.e = (i - 1);
    }
    setCurrentItem(this.e);
    requestLayout();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.d != null) {
      post(this.d);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.d != null) {
      removeCallbacks(this.d);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.c != null) {
      this.c.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.c != null) {
      this.c.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    setCurrentItem(paramInt);
    if (this.c != null) {
      this.c.onPageSelected(paramInt);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.b == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.e = paramInt;
    this.b.setCurrentItem(paramInt);
    int i = this.a.getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = this.a.getChildAt(j);
      if (j == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          a(paramInt);
        }
        j++;
        break;
      }
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.c = paramOnPageChangeListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.b == paramViewPager) {
      return;
    }
    if (this.b != null) {
      this.b.setOnPageChangeListener(null);
    }
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    this.b = paramViewPager;
    paramViewPager.setOnPageChangeListener(this);
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.IconPageIndicator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */