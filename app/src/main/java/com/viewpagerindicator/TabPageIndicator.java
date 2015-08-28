package com.viewpagerindicator;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;

public class TabPageIndicator
  extends HorizontalScrollView
  implements PageIndicator
{
  private static final CharSequence a = "";
  private Runnable b;
  private final View.OnClickListener c;
  private final IcsLinearLayout d;
  private ViewPager e;
  private ViewPager.OnPageChangeListener f;
  private int g;
  private int h;
  private TabPageIndicator.OnTabReselectedListener i;
  
  private void a(int paramInt)
  {
    View localView = this.d.getChildAt(paramInt);
    if (this.b != null) {
      removeCallbacks(this.b);
    }
    this.b = new TabPageIndicator.2(this, localView);
    post(this.b);
  }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    TabPageIndicator.TabView localTabView = new TabPageIndicator.TabView(this, getContext());
    TabPageIndicator.TabView.a(localTabView, paramInt1);
    localTabView.setFocusable(true);
    localTabView.setOnClickListener(this.c);
    localTabView.setText(paramCharSequence);
    if (paramInt2 != 0) {
      localTabView.setCompoundDrawablesWithIntrinsicBounds(paramInt2, 0, 0, 0);
    }
    this.d.addView(localTabView, new LinearLayout.LayoutParams(0, -1, 1.0F));
  }
  
  public void a()
  {
    this.d.removeAllViews();
    PagerAdapter localPagerAdapter = this.e.getAdapter();
    boolean bool = localPagerAdapter instanceof IconPagerAdapter;
    IconPagerAdapter localIconPagerAdapter = null;
    if (bool) {
      localIconPagerAdapter = (IconPagerAdapter)localPagerAdapter;
    }
    int j = localPagerAdapter.getCount();
    int k = 0;
    CharSequence localCharSequence1;
    if (k < j)
    {
      localCharSequence1 = localPagerAdapter.getPageTitle(k);
      if (localCharSequence1 != null) {
        break label131;
      }
    }
    label131:
    for (CharSequence localCharSequence2 = a;; localCharSequence2 = localCharSequence1)
    {
      if (localIconPagerAdapter != null) {}
      for (int m = localIconPagerAdapter.a(k);; m = 0)
      {
        a(k, localCharSequence2, m);
        k++;
        break;
        if (this.h > j) {
          this.h = (j - 1);
        }
        setCurrentItem(this.h);
        requestLayout();
        return;
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.b != null) {
      post(this.b);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.b != null) {
      removeCallbacks(this.b);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (j == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int k = this.d.getChildCount();
      if ((k <= 1) || ((j != 1073741824) && (j != -2147483648))) {
        break label124;
      }
      if (k <= 2) {
        break label111;
      }
      this.g = ((int)(0.4F * View.MeasureSpec.getSize(paramInt1)));
    }
    for (;;)
    {
      int m = getMeasuredWidth();
      super.onMeasure(paramInt1, paramInt2);
      int n = getMeasuredWidth();
      if ((bool) && (m != n)) {
        setCurrentItem(this.h);
      }
      return;
      bool = false;
      break;
      label111:
      this.g = (View.MeasureSpec.getSize(paramInt1) / 2);
      continue;
      label124:
      this.g = -1;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.f != null) {
      this.f.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.f != null) {
      this.f.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    setCurrentItem(paramInt);
    if (this.f != null) {
      this.f.onPageSelected(paramInt);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.e == null) {
      throw new IllegalStateException("ViewPager has not been bound.");
    }
    this.h = paramInt;
    this.e.setCurrentItem(paramInt);
    int j = this.d.getChildCount();
    int k = 0;
    if (k < j)
    {
      View localView = this.d.getChildAt(k);
      if (k == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          a(paramInt);
        }
        k++;
        break;
      }
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.f = paramOnPageChangeListener;
  }
  
  public void setOnTabReselectedListener(TabPageIndicator.OnTabReselectedListener paramOnTabReselectedListener)
  {
    this.i = paramOnTabReselectedListener;
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
    paramViewPager.setOnPageChangeListener(this);
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.TabPageIndicator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */