package com.astuetz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.util.Pair;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.Locale;

public class PagerSlidingTabStrip
  extends HorizontalScrollView
{
  private static final int[] d = { 16842806, 16842901, 16842904, 16842966, 16842968 };
  private float A = 0.5F;
  private float B = 1.0F;
  private int C = 0;
  private boolean D = false;
  private boolean E = true;
  private boolean F = false;
  private Typeface G = null;
  private int H = 1;
  private int I = 1;
  private int J;
  private int K = 0;
  private int L = R.drawable.background_tab;
  private Locale M;
  private ViewTreeObserver.OnGlobalLayoutListener N = new PagerSlidingTabStrip.3(this);
  public ViewPager.OnPageChangeListener a;
  private PagerSlidingTabStrip.OnTabClickListener b;
  private int[] c;
  private final PagerSlidingTabStrip.PagerAdapterObserver e = new PagerSlidingTabStrip.PagerAdapterObserver(this, null);
  private LinearLayout.LayoutParams f;
  private LinearLayout.LayoutParams g;
  private final PagerSlidingTabStrip.PageListener h = new PagerSlidingTabStrip.PageListener(this, null);
  private PagerSlidingTabStrip.OnTabReselectedListener i = null;
  private LinearLayout j;
  private ViewPager k;
  private int l;
  private int m = 0;
  private float n = 0.0F;
  private Paint o;
  private Paint p;
  private int q;
  private int r = 2;
  private int s = 0;
  private int t;
  private int u = 0;
  private int v = 0;
  private int w;
  private int x = 12;
  private int y = 14;
  private ColorStateList z = null;
  
  public PagerSlidingTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    this.j = new LinearLayout(paramContext);
    this.j.setOrientation(0);
    this.j.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(this.j);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.J = ((int)TypedValue.applyDimension(1, this.J, localDisplayMetrics));
    this.r = ((int)TypedValue.applyDimension(1, this.r, localDisplayMetrics));
    this.s = ((int)TypedValue.applyDimension(1, this.s, localDisplayMetrics));
    this.v = ((int)TypedValue.applyDimension(1, this.v, localDisplayMetrics));
    this.x = ((int)TypedValue.applyDimension(1, this.x, localDisplayMetrics));
    this.u = ((int)TypedValue.applyDimension(1, this.u, localDisplayMetrics));
    this.y = ((int)TypedValue.applyDimension(2, this.y, localDisplayMetrics));
    TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, d);
    this.y = localTypedArray1.getDimensionPixelSize(1, this.y);
    ColorStateList localColorStateList = localTypedArray1.getColorStateList(2);
    int i1 = localTypedArray1.getColor(0, 17170443);
    if (localColorStateList != null) {}
    for (this.z = localColorStateList;; this.z = c(i1))
    {
      this.t = i1;
      this.w = i1;
      this.q = i1;
      int i2 = localTypedArray1.getDimensionPixelSize(3, this.C);
      int i3 = localTypedArray1.getDimensionPixelSize(4, this.C);
      localTypedArray1.recycle();
      this.C = Math.max(i2, i3);
      TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagerSlidingTabStrip);
      this.q = localTypedArray2.getColor(R.styleable.PagerSlidingTabStrip_pstsIndicatorColor, this.q);
      this.t = localTypedArray2.getColor(R.styleable.PagerSlidingTabStrip_pstsUnderlineColor, this.t);
      this.w = localTypedArray2.getColor(R.styleable.PagerSlidingTabStrip_pstsDividerColor, this.w);
      this.u = localTypedArray2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsDividerWidth, this.u);
      this.r = localTypedArray2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsIndicatorHeight, this.r);
      this.s = localTypedArray2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsUnderlineHeight, this.s);
      this.v = localTypedArray2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsDividerPadding, this.v);
      this.x = localTypedArray2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, this.x);
      this.L = localTypedArray2.getResourceId(R.styleable.PagerSlidingTabStrip_pstsTabBackground, this.L);
      this.D = localTypedArray2.getBoolean(R.styleable.PagerSlidingTabStrip_pstsShouldExpand, this.D);
      this.J = localTypedArray2.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsScrollOffset, this.J);
      this.E = localTypedArray2.getBoolean(R.styleable.PagerSlidingTabStrip_pstsTextAllCaps, this.E);
      this.F = localTypedArray2.getBoolean(R.styleable.PagerSlidingTabStrip_pstsPaddingMiddle, this.F);
      this.H = localTypedArray2.getInt(R.styleable.PagerSlidingTabStrip_pstsTextStyle, 1);
      this.I = localTypedArray2.getInt(R.styleable.PagerSlidingTabStrip_pstsTextSelectedStyle, 1);
      this.A = localTypedArray2.getFloat(R.styleable.PagerSlidingTabStrip_pstsTextAlpha, 0.5F);
      this.B = localTypedArray2.getFloat(R.styleable.PagerSlidingTabStrip_pstsTextSelectedAlpha, 1.0F);
      localTypedArray2.recycle();
      b();
      this.o = new Paint();
      this.o.setAntiAlias(true);
      this.o.setStyle(Paint.Style.FILL);
      this.p = new Paint();
      this.p.setAntiAlias(true);
      this.p.setStrokeWidth(this.u);
      this.f = new LinearLayout.LayoutParams(-2, -1);
      this.g = new LinearLayout.LayoutParams(0, -1, 1.0F);
      if (this.M == null) {
        this.M = getResources().getConfiguration().locale;
      }
      this.z = paramContext.getResources().getColorStateList(R.color.textcolor_tab);
      return;
    }
  }
  
  private void a(int paramInt)
  {
    int i1 = 0;
    if (i1 < this.l)
    {
      View localView = this.j.getChildAt(i1);
      boolean bool;
      if (i1 == paramInt)
      {
        bool = true;
        label27:
        localView.setSelected(bool);
        if (!bool) {
          break label55;
        }
        b(localView);
      }
      for (;;)
      {
        i1++;
        break;
        bool = false;
        break label27;
        label55:
        a(localView);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.l == 0) {}
    int i1;
    do
    {
      return;
      i1 = paramInt2 + this.j.getChildAt(paramInt1).getLeft();
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        int i2 = i1 - this.J;
        Pair localPair = getIndicatorCoordinates();
        i1 = (int)(i2 + (((Float)localPair.second).floatValue() - ((Float)localPair.first).floatValue()) / 2.0F);
      }
    } while (i1 == this.K);
    this.K = i1;
    scrollTo(i1, 0);
  }
  
  private void a(int paramInt, CharSequence paramCharSequence, View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(R.id.tab_title);
    float f1;
    LinearLayout localLinearLayout;
    if (localTextView != null)
    {
      if (paramCharSequence != null) {
        localTextView.setText(paramCharSequence);
      }
      if (this.k.getCurrentItem() == paramInt)
      {
        f1 = this.B;
        ViewCompat.setAlpha(localTextView, f1);
      }
    }
    else
    {
      a((ImageView)paramView.findViewById(R.id.iv_indicator), paramInt, false);
      paramView.setFocusable(true);
      paramView.setOnClickListener(new PagerSlidingTabStrip.2(this, paramInt, paramView));
      localLinearLayout = this.j;
      if (!this.D) {
        break label124;
      }
    }
    label124:
    for (LinearLayout.LayoutParams localLayoutParams = this.g;; localLayoutParams = this.f)
    {
      localLinearLayout.addView(paramView, paramInt, localLayoutParams);
      return;
      f1 = this.A;
      break;
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(R.id.tab_title);
      if (localTextView != null)
      {
        localTextView.setTypeface(this.G, this.H);
        ViewCompat.setAlpha(localTextView, this.A);
      }
    }
  }
  
  private void a(ImageView paramImageView, int paramInt, boolean paramBoolean)
  {
    if (paramImageView == null) {
      return;
    }
    int i1;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i1 = this.k.getCurrentItem();
      arrayOfInt = this.c;
      if (this.c[i1] != 0) {
        break label55;
      }
    }
    label55:
    for (int i2 = 1;; i2 = 0)
    {
      arrayOfInt[i1] = i2;
      if (paramInt != 0) {
        break;
      }
      paramImageView.setVisibility(8);
      return;
    }
    if (this.k.getCurrentItem() == paramInt)
    {
      if (this.c[paramInt] == 0)
      {
        paramImageView.setImageResource(R.drawable.ic_arrow_down_selected);
        return;
      }
      paramImageView.setImageResource(R.drawable.ic_arrow_up_selected);
      return;
    }
    if (this.c[paramInt] == 0)
    {
      paramImageView.setImageResource(R.drawable.ic_arrow_down_default);
      return;
    }
    paramImageView.setImageResource(R.drawable.ic_arrow_up_default);
  }
  
  private void b()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
    if (this.r >= this.s) {}
    for (int i1 = this.r;; i1 = this.s)
    {
      localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, localMarginLayoutParams.rightMargin, i1);
      this.j.setLayoutParams(localMarginLayoutParams);
      return;
    }
  }
  
  private void b(int paramInt)
  {
    int i1 = 0;
    if (i1 < this.l)
    {
      View localView = this.j.getChildAt(i1);
      if (i1 == 0) {
        localView.findViewById(R.id.iv_indicator).setVisibility(8);
      }
      ImageView localImageView = (ImageView)localView.findViewById(R.id.iv_indicator);
      if (i1 == paramInt) {
        if (this.c[i1] == 0) {
          localImageView.setImageResource(R.drawable.ic_arrow_down_selected);
        }
      }
      for (;;)
      {
        i1++;
        break;
        localImageView.setImageResource(R.drawable.ic_arrow_up_selected);
        continue;
        if (this.c[i1] == 0) {
          localImageView.setImageResource(R.drawable.ic_arrow_down_default);
        } else {
          localImageView.setImageResource(R.drawable.ic_arrow_up_default);
        }
      }
    }
  }
  
  private void b(View paramView)
  {
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(R.id.tab_title);
      if (localTextView != null)
      {
        localTextView.setTypeface(this.G, this.I);
        ViewCompat.setAlpha(localTextView, this.B);
      }
    }
  }
  
  private ColorStateList c(int paramInt)
  {
    return new ColorStateList(new int[][] { new int[0] }, new int[] { paramInt });
  }
  
  private void c()
  {
    int i1 = 0;
    if (i1 < this.l)
    {
      View localView = this.j.getChildAt(i1);
      localView.setBackgroundResource(this.L);
      localView.setPadding(this.x, localView.getPaddingTop(), this.x, localView.getPaddingBottom());
      TextView localTextView = (TextView)localView.findViewById(R.id.tab_title);
      int i2;
      if (localTextView != null)
      {
        localTextView.setTextSize(0, this.y);
        Typeface localTypeface = this.G;
        if (this.k.getCurrentItem() != i1) {
          break label160;
        }
        i2 = this.I;
        label95:
        localTextView.setTypeface(localTypeface, i2);
        if (this.z != null) {
          localTextView.setTextColor(this.z);
        }
        if (this.E)
        {
          if (Build.VERSION.SDK_INT < 14) {
            break label169;
          }
          localTextView.setAllCaps(true);
        }
      }
      for (;;)
      {
        a((ImageView)localView.findViewById(R.id.iv_indicator), i1, false);
        i1++;
        break;
        label160:
        i2 = this.H;
        break label95;
        label169:
        localTextView.setText(localTextView.getText().toString().toUpperCase(this.M));
      }
    }
  }
  
  private Pair<Float, Float> getIndicatorCoordinates()
  {
    View localView1 = this.j.getChildAt(this.m);
    float f1 = localView1.getLeft();
    float f2 = localView1.getRight();
    if ((this.n > 0.0F) && (this.m < -1 + this.l))
    {
      View localView2 = this.j.getChildAt(1 + this.m);
      float f3 = localView2.getLeft();
      float f4 = localView2.getRight();
      f1 = f3 * this.n + f1 * (1.0F - this.n);
      f2 = f4 * this.n + f2 * (1.0F - this.n);
    }
    return new Pair(Float.valueOf(f1), Float.valueOf(f2));
  }
  
  public void a()
  {
    this.j.removeAllViews();
    this.l = this.k.getAdapter().getCount();
    int i1 = 0;
    if (i1 < this.l)
    {
      if ((this.k.getAdapter() instanceof PagerSlidingTabStrip.CustomTabProvider)) {}
      for (View localView = ((PagerSlidingTabStrip.CustomTabProvider)this.k.getAdapter()).a(this, i1);; localView = LayoutInflater.from(getContext()).inflate(R.layout.tab, this, false))
      {
        a(i1, this.k.getAdapter().getPageTitle(i1), localView);
        i1++;
        break;
      }
    }
    c();
    getViewTreeObserver().addOnGlobalLayoutListener(new PagerSlidingTabStrip.1(this));
  }
  
  public int getDividerColor()
  {
    return this.w;
  }
  
  public int getDividerPadding()
  {
    return this.v;
  }
  
  public int getDividerWidth()
  {
    return this.u;
  }
  
  public int getIndicatorColor()
  {
    return this.q;
  }
  
  public int getIndicatorHeight()
  {
    return this.r;
  }
  
  public int getScrollOffset()
  {
    return this.J;
  }
  
  public boolean getShouldExpand()
  {
    return this.D;
  }
  
  public int getTabBackground()
  {
    return this.L;
  }
  
  public int getTabPaddingLeftRight()
  {
    return this.x;
  }
  
  public ColorStateList getTextColor()
  {
    return this.z;
  }
  
  public int getTextSize()
  {
    return this.y;
  }
  
  public int getUnderlineColor()
  {
    return this.t;
  }
  
  public int getUnderlineHeight()
  {
    return this.s;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.k != null) && (!this.e.a()))
    {
      this.k.getAdapter().registerDataSetObserver(this.e);
      this.e.a(true);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.k != null) && (this.e.a()))
    {
      this.k.getAdapter().unregisterDataSetObserver(this.e);
      this.e.a(false);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.l == 0)) {}
    for (;;)
    {
      return;
      int i1 = getHeight();
      this.o.setColor(this.q);
      Pair localPair = getIndicatorCoordinates();
      paramCanvas.drawRect(((Float)localPair.first).floatValue() + this.C, i1 - this.r, ((Float)localPair.second).floatValue() + this.C, i1, this.o);
      this.o.setColor(this.t);
      paramCanvas.drawRect(this.C, i1 - this.s, this.j.getWidth() + this.C, i1, this.o);
      if (this.u != 0)
      {
        this.p.setStrokeWidth(this.u);
        this.p.setColor(this.w);
        for (int i2 = 0; i2 < -1 + this.l; i2++)
        {
          View localView = this.j.getChildAt(i2);
          paramCanvas.drawLine(localView.getRight(), this.v, localView.getRight(), i1 - this.v, this.p);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.F) || (this.C > 0))
    {
      this.j.setMinimumWidth(getWidth());
      setClipToPadding(false);
    }
    if (this.j.getChildCount() > 0) {
      this.j.getChildAt(0).getViewTreeObserver().addOnGlobalLayoutListener(this.N);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    PagerSlidingTabStrip.SavedState localSavedState = (PagerSlidingTabStrip.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.m = localSavedState.a;
    if ((this.m != 0) && (this.j.getChildCount() > 0))
    {
      a(this.j.getChildAt(0));
      b(this.j.getChildAt(this.m));
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    PagerSlidingTabStrip.SavedState localSavedState = new PagerSlidingTabStrip.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.m;
    return localSavedState;
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    this.w = paramInt;
    invalidate();
  }
  
  public void setDividerColorResource(int paramInt)
  {
    this.w = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.v = paramInt;
    invalidate();
  }
  
  public void setDividerWidth(int paramInt)
  {
    this.u = paramInt;
    invalidate();
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }
  
  public void setIndicatorColorResource(int paramInt)
  {
    this.q = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setIndicatorHeight(int paramInt)
  {
    this.r = paramInt;
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.a = paramOnPageChangeListener;
  }
  
  public void setOnTabClickListener(PagerSlidingTabStrip.OnTabClickListener paramOnTabClickListener)
  {
    this.b = paramOnTabClickListener;
  }
  
  public void setOnTabReselectedListener(PagerSlidingTabStrip.OnTabReselectedListener paramOnTabReselectedListener)
  {
    this.i = paramOnTabReselectedListener;
  }
  
  public void setScrollOffset(int paramInt)
  {
    this.J = paramInt;
    invalidate();
  }
  
  public void setShouldExpand(boolean paramBoolean)
  {
    this.D = paramBoolean;
    if (this.k != null) {
      requestLayout();
    }
  }
  
  public void setTabBackground(int paramInt)
  {
    this.L = paramInt;
  }
  
  public void setTabDefaultValue(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
  }
  
  public void setTabPaddingLeftRight(int paramInt)
  {
    this.x = paramInt;
    c();
  }
  
  public void setTextColor(int paramInt)
  {
    setTextColor(c(paramInt));
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.z = paramColorStateList;
    c();
  }
  
  public void setTextColorResource(int paramInt)
  {
    setTextColor(getResources().getColor(paramInt));
  }
  
  public void setTextColorStateListResource(int paramInt)
  {
    setTextColor(getResources().getColorStateList(paramInt));
  }
  
  public void setTextSize(int paramInt)
  {
    this.y = paramInt;
    c();
  }
  
  public void setUnderlineColor(int paramInt)
  {
    this.t = paramInt;
    invalidate();
  }
  
  public void setUnderlineColorResource(int paramInt)
  {
    this.t = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setUnderlineHeight(int paramInt)
  {
    this.s = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.k = paramViewPager;
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    paramViewPager.setOnPageChangeListener(this.h);
    paramViewPager.getAdapter().registerDataSetObserver(this.e);
    this.e.a(true);
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.PagerSlidingTabStrip
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */