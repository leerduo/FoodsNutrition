package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class LinearLayoutCompat
  extends ViewGroup
{
  private boolean a = true;
  private int b = -1;
  private int c = 0;
  private int d;
  private int e = 8388659;
  private int f;
  private float g;
  private boolean h;
  private int[] i;
  private int[] j;
  private Drawable k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    int i1 = localTintTypedArray.a(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (i1 >= 0) {
      setOrientation(i1);
    }
    int i2 = localTintTypedArray.a(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (i2 >= 0) {
      setGravity(i2);
    }
    boolean bool = localTintTypedArray.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    this.g = localTintTypedArray.a(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    this.b = localTintTypedArray.a(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.h = localTintTypedArray.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(localTintTypedArray.a(R.styleable.LinearLayoutCompat_divider));
    this.n = localTintTypedArray.a(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.o = localTintTypedArray.d(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    localTintTypedArray.b();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int i2 = 0; i2 < paramInt1; i2++)
    {
      View localView = b(i2);
      if (localView.getVisibility() != 8)
      {
        LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int i3 = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, i1, 0, paramInt2, 0);
          localLayoutParams.height = i3;
        }
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    for (int i2 = 0; i2 < paramInt1; i2++)
    {
      View localView = b(i2);
      if (localView.getVisibility() != 8)
      {
        LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.height == -1)
        {
          int i3 = localLayoutParams.width;
          localLayoutParams.width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, i1, 0);
          localLayoutParams.width = i3;
        }
      }
    }
  }
  
  int a(View paramView)
  {
    return 0;
  }
  
  int a(View paramView, int paramInt)
  {
    return 0;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.f = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 1;
    float f1 = 0.0F;
    int i6 = getVirtualChildCount();
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int i9 = 0;
    int i10 = 0;
    int i11 = this.b;
    boolean bool = this.h;
    int i12 = -2147483648;
    int i13 = 0;
    View localView4;
    int i63;
    int i61;
    int i58;
    int i64;
    int i62;
    label189:
    LinearLayoutCompat.LayoutParams localLayoutParams3;
    float f7;
    int i51;
    if (i13 < i6)
    {
      localView4 = b(i13);
      if (localView4 == null)
      {
        this.f += d(i13);
        i63 = i12;
        i61 = i10;
        i58 = i5;
        i64 = i2;
      }
      for (i62 = i1;; i62 = i1)
      {
        i13++;
        i12 = i63;
        i10 = i61;
        i5 = i58;
        i2 = i64;
        i1 = i62;
        break;
        if (localView4.getVisibility() != 8) {
          break label189;
        }
        i13 += a(localView4, i13);
        i63 = i12;
        i61 = i10;
        i58 = i5;
        i64 = i2;
      }
      if (c(i13)) {
        this.f += this.m;
      }
      localLayoutParams3 = (LinearLayoutCompat.LayoutParams)localView4.getLayoutParams();
      f7 = f1 + localLayoutParams3.g;
      if ((i8 == 1073741824) && (localLayoutParams3.height == 0) && (localLayoutParams3.g > 0.0F))
      {
        int i66 = this.f;
        this.f = Math.max(i66, i66 + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin);
        i10 = 1;
        if ((i11 >= 0) && (i11 == i13 + 1)) {
          this.c = this.f;
        }
        if ((i13 < i11) && (localLayoutParams3.g > 0.0F)) {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        }
      }
      else
      {
        int i46 = -2147483648;
        if ((localLayoutParams3.height == 0) && (localLayoutParams3.g > 0.0F))
        {
          i46 = 0;
          localLayoutParams3.height = -2;
        }
        int i47 = i46;
        if (f7 == 0.0F) {}
        for (int i48 = this.f;; i48 = 0)
        {
          a(localView4, i13, paramInt1, 0, paramInt2, i48);
          if (i47 != -2147483648) {
            localLayoutParams3.height = i47;
          }
          int i49 = localView4.getMeasuredHeight();
          int i50 = this.f;
          this.f = Math.max(i50, i50 + i49 + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin + b(localView4));
          if (!bool) {
            break;
          }
          i12 = Math.max(i49, i12);
          break;
        }
      }
      if ((i7 == 1073741824) || (localLayoutParams3.width != -1)) {
        break label1625;
      }
      i51 = 1;
    }
    for (int i52 = 1;; i52 = 0)
    {
      int i53 = localLayoutParams3.leftMargin + localLayoutParams3.rightMargin;
      int i54 = i53 + localView4.getMeasuredWidth();
      int i55 = Math.max(i1, i54);
      int i56 = ViewCompat.getMeasuredState(localView4);
      int i57 = ViewUtils.a(i2, i56);
      if ((i5 != 0) && (localLayoutParams3.width == -1))
      {
        i58 = 1;
        label568:
        if (localLayoutParams3.g <= 0.0F) {
          break label661;
        }
        if (i52 == 0) {
          break label654;
        }
      }
      int i60;
      int i59;
      label654:
      for (int i65 = i53;; i65 = i54)
      {
        i60 = Math.max(i4, i65);
        i59 = i3;
        i13 += a(localView4, i13);
        i61 = i10;
        i4 = i60;
        i3 = i59;
        i62 = i55;
        i63 = i12;
        i64 = i57;
        i9 = i51;
        f1 = f7;
        break;
        i58 = 0;
        break label568;
      }
      label661:
      if (i52 != 0) {}
      for (;;)
      {
        i59 = Math.max(i3, i53);
        i60 = i4;
        break;
        i53 = i54;
      }
      if ((this.f > 0) && (c(i6))) {
        this.f += this.m;
      }
      if ((bool) && ((i8 == -2147483648) || (i8 == 0)))
      {
        this.f = 0;
        int i43 = 0;
        if (i43 < i6)
        {
          View localView3 = b(i43);
          int i45;
          if (localView3 == null)
          {
            this.f += d(i43);
            i45 = i43;
          }
          for (;;)
          {
            i43 = i45 + 1;
            break;
            if (localView3.getVisibility() == 8)
            {
              i45 = i43 + a(localView3, i43);
            }
            else
            {
              LinearLayoutCompat.LayoutParams localLayoutParams2 = (LinearLayoutCompat.LayoutParams)localView3.getLayoutParams();
              int i44 = this.f;
              this.f = Math.max(i44, i44 + i12 + localLayoutParams2.topMargin + localLayoutParams2.bottomMargin + b(localView3));
              i45 = i43;
            }
          }
        }
      }
      this.f += getPaddingTop() + getPaddingBottom();
      int i14 = ViewCompat.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumHeight()), paramInt2, 0);
      int i15 = (0xFFFFFF & i14) - this.f;
      float f2;
      int i17;
      int i18;
      int i19;
      int i20;
      int i21;
      View localView1;
      int i33;
      int i35;
      int i34;
      int i31;
      LinearLayoutCompat.LayoutParams localLayoutParams1;
      int i36;
      int i38;
      int i24;
      int i25;
      float f4;
      if ((i10 != 0) || ((i15 != 0) && (f1 > 0.0F)))
      {
        if (this.g > 0.0F) {
          f1 = this.g;
        }
        this.f = 0;
        int i16 = 0;
        f2 = f1;
        i17 = i5;
        i18 = i3;
        i19 = i2;
        i20 = i1;
        i21 = i15;
        for (;;)
        {
          if (i16 < i6)
          {
            localView1 = b(i16);
            if (localView1.getVisibility() == 8)
            {
              i33 = i18;
              i35 = i19;
              i34 = i20;
              i31 = i17;
              i16++;
              i18 = i33;
              i20 = i34;
              i17 = i31;
              i19 = i35;
            }
            else
            {
              localLayoutParams1 = (LinearLayoutCompat.LayoutParams)localView1.getLayoutParams();
              float f3 = localLayoutParams1.g;
              if (f3 <= 0.0F) {
                break label1610;
              }
              i36 = (int)(f3 * i21 / f2);
              float f6 = f2 - f3;
              int i37 = i21 - i36;
              i38 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin, localLayoutParams1.width);
              if ((localLayoutParams1.height != 0) || (i8 != 1073741824))
              {
                int i39 = i36 + localView1.getMeasuredHeight();
                if (i39 < 0) {
                  i39 = 0;
                }
                localView1.measure(i38, View.MeasureSpec.makeMeasureSpec(i39, 1073741824));
                int i40 = ViewUtils.a(i19, 0xFFFFFF00 & ViewCompat.getMeasuredState(localView1));
                i24 = i37;
                i25 = i40;
                f4 = f6;
              }
            }
          }
        }
      }
      for (;;)
      {
        int i26 = localLayoutParams1.leftMargin + localLayoutParams1.rightMargin;
        int i27 = i26 + localView1.getMeasuredWidth();
        int i28 = Math.max(i20, i27);
        int i29;
        label1255:
        label1260:
        int i30;
        if ((i7 != 1073741824) && (localLayoutParams1.width == -1))
        {
          i29 = 1;
          if (i29 == 0) {
            break label1389;
          }
          i30 = Math.max(i18, i26);
          if ((i17 == 0) || (localLayoutParams1.width != -1)) {
            break label1396;
          }
        }
        label1389:
        label1396:
        for (i31 = 1;; i31 = 0)
        {
          int i32 = this.f;
          this.f = Math.max(i32, i32 + localView1.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin + b(localView1));
          i33 = i30;
          i34 = i28;
          float f5 = f4;
          i35 = i25;
          i21 = i24;
          f2 = f5;
          break;
          if (i36 > 0) {}
          for (;;)
          {
            localView1.measure(i38, View.MeasureSpec.makeMeasureSpec(i36, 1073741824));
            break;
            i36 = 0;
          }
          i29 = 0;
          break label1255;
          i26 = i27;
          break label1260;
        }
        this.f += getPaddingTop() + getPaddingBottom();
        i5 = i17;
        int i22 = i18;
        i2 = i19;
        for (int i23 = i20;; i23 = i1)
        {
          if ((i5 == 0) && (i7 != 1073741824)) {}
          int i41;
          for (;;)
          {
            setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i22 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, i2), i14);
            if (i9 != 0) {
              c(i6, paramInt2);
            }
            return;
            i41 = Math.max(i3, i4);
            if ((!bool) || (i8 == 1073741824)) {
              break;
            }
            int i42 = 0;
            if (i42 >= i6) {
              break;
            }
            View localView2 = b(i42);
            if ((localView2 == null) || (localView2.getVisibility() == 8)) {}
            for (;;)
            {
              i42++;
              break;
              if (((LinearLayoutCompat.LayoutParams)localView2.getLayoutParams()).g > 0.0F) {
                localView2.measure(View.MeasureSpec.makeMeasureSpec(localView2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
              }
            }
            i22 = i23;
          }
          i22 = i41;
        }
        label1610:
        f4 = f2;
        i24 = i21;
        i25 = i19;
      }
      label1625:
      i51 = i9;
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getPaddingLeft();
    int i2 = paramInt3 - paramInt1;
    int i3 = i2 - getPaddingRight();
    int i4 = i2 - i1 - getPaddingRight();
    int i5 = getVirtualChildCount();
    int i6 = 0x70 & this.e;
    int i7 = 0x800007 & this.e;
    int i8;
    int i9;
    int i10;
    label97:
    View localView;
    int i11;
    switch (i6)
    {
    default: 
      i8 = getPaddingTop();
      i9 = 0;
      i10 = i8;
      if (i9 < i5)
      {
        localView = b(i9);
        if (localView == null)
        {
          i10 += d(i9);
          i11 = i9;
        }
      }
      break;
    }
    for (;;)
    {
      i9 = i11 + 1;
      break label97;
      i8 = paramInt4 + getPaddingTop() - paramInt2 - this.f;
      break;
      i8 = getPaddingTop() + (paramInt4 - paramInt2 - this.f) / 2;
      break;
      if (localView.getVisibility() != 8)
      {
        int i12 = localView.getMeasuredWidth();
        int i13 = localView.getMeasuredHeight();
        LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
        int i14 = localLayoutParams.h;
        if (i14 < 0) {
          i14 = i7;
        }
        int i15;
        switch (0x7 & GravityCompat.getAbsoluteGravity(i14, ViewCompat.getLayoutDirection(this)))
        {
        default: 
          i15 = i1 + localLayoutParams.leftMargin;
          label278:
          if (!c(i9)) {
            break;
          }
        }
        for (int i16 = i10 + this.m;; i16 = i10)
        {
          int i17 = i16 + localLayoutParams.topMargin;
          a(localView, i15, i17 + a(localView), i12, i13);
          i10 = i17 + (i13 + localLayoutParams.bottomMargin + b(localView));
          i11 = i9 + a(localView, i9);
          break;
          i15 = i1 + (i4 - i12) / 2 + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
          break label278;
          i15 = i3 - i12 - localLayoutParams.rightMargin;
          break label278;
          return;
        }
      }
      i11 = i9;
    }
  }
  
  void a(Canvas paramCanvas)
  {
    int i1 = getVirtualChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView2 = b(i2);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (c(i2)))
      {
        LinearLayoutCompat.LayoutParams localLayoutParams2 = (LinearLayoutCompat.LayoutParams)localView2.getLayoutParams();
        a(paramCanvas, localView2.getTop() - localLayoutParams2.topMargin - this.m);
      }
    }
    View localView1;
    if (c(i1))
    {
      localView1 = b(i1 - 1);
      if (localView1 != null) {
        break label125;
      }
    }
    label125:
    LinearLayoutCompat.LayoutParams localLayoutParams1;
    for (int i3 = getHeight() - getPaddingBottom() - this.m;; i3 = localView1.getBottom() + localLayoutParams1.bottomMargin)
    {
      a(paramCanvas, i3);
      return;
      localLayoutParams1 = (LinearLayoutCompat.LayoutParams)localView1.getLayoutParams();
    }
  }
  
  void a(Canvas paramCanvas, int paramInt)
  {
    this.k.setBounds(getPaddingLeft() + this.o, paramInt, getWidth() - getPaddingRight() - this.o, paramInt + this.m);
    this.k.draw(paramCanvas);
  }
  
  void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  int b(View paramView)
  {
    return 0;
  }
  
  public LinearLayoutCompat.LayoutParams b(AttributeSet paramAttributeSet)
  {
    return new LinearLayoutCompat.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LinearLayoutCompat.LayoutParams b(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LinearLayoutCompat.LayoutParams(paramLayoutParams);
  }
  
  View b(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    this.f = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 1;
    float f1 = 0.0F;
    int i6 = getVirtualChildCount();
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int i9 = 0;
    int i10 = 0;
    if ((this.i == null) || (this.j == null))
    {
      this.i = new int[4];
      this.j = new int[4];
    }
    int[] arrayOfInt1 = this.i;
    int[] arrayOfInt2 = this.j;
    arrayOfInt1[3] = -1;
    arrayOfInt1[2] = -1;
    arrayOfInt1[1] = -1;
    arrayOfInt1[0] = -1;
    arrayOfInt2[3] = -1;
    arrayOfInt2[2] = -1;
    arrayOfInt2[1] = -1;
    arrayOfInt2[0] = -1;
    boolean bool1 = this.a;
    boolean bool2 = this.h;
    int i11;
    int i12;
    int i13;
    label155:
    View localView4;
    int i69;
    int i67;
    int i64;
    int i70;
    if (i7 == 1073741824)
    {
      i11 = 1;
      i12 = -2147483648;
      i13 = 0;
      if (i13 >= i6) {
        break label915;
      }
      localView4 = b(i13);
      if (localView4 != null) {
        break label240;
      }
      this.f += d(i13);
      i69 = i12;
      i67 = i10;
      i64 = i5;
      i70 = i2;
    }
    for (int i68 = i1;; i68 = i1)
    {
      i13++;
      i12 = i69;
      i10 = i67;
      i5 = i64;
      i2 = i70;
      i1 = i68;
      break label155;
      i11 = 0;
      break;
      label240:
      if (localView4.getVisibility() != 8) {
        break label285;
      }
      i13 += a(localView4, i13);
      i69 = i12;
      i67 = i10;
      i64 = i5;
      i70 = i2;
    }
    label285:
    if (c(i13)) {
      this.f += this.l;
    }
    LinearLayoutCompat.LayoutParams localLayoutParams3 = (LinearLayoutCompat.LayoutParams)localView4.getLayoutParams();
    float f7 = f1 + localLayoutParams3.g;
    label377:
    int i57;
    if ((i7 == 1073741824) && (localLayoutParams3.width == 0) && (localLayoutParams3.g > 0.0F)) {
      if (i11 != 0)
      {
        this.f += localLayoutParams3.leftMargin + localLayoutParams3.rightMargin;
        if (!bool1) {
          break label675;
        }
        int i76 = View.MeasureSpec.makeMeasureSpec(0, 0);
        localView4.measure(i76, i76);
        label398:
        if ((i8 == 1073741824) || (localLayoutParams3.height != -1)) {
          break label2299;
        }
        i57 = 1;
      }
    }
    for (int i58 = 1;; i58 = 0)
    {
      int i59 = localLayoutParams3.topMargin + localLayoutParams3.bottomMargin;
      int i60 = i59 + localView4.getMeasuredHeight();
      int i61 = ViewCompat.getMeasuredState(localView4);
      int i62 = ViewUtils.a(i2, i61);
      int i73;
      if (bool1)
      {
        int i72 = localView4.getBaseline();
        if (i72 != -1)
        {
          if (localLayoutParams3.h >= 0) {
            break label864;
          }
          i73 = this.e;
          label491:
          int i74 = (0xFFFFFFFE & (i73 & 0x70) >> 4) >> 1;
          arrayOfInt1[i74] = Math.max(arrayOfInt1[i74], i72);
          arrayOfInt2[i74] = Math.max(arrayOfInt2[i74], i60 - i72);
        }
      }
      int i63 = Math.max(i1, i60);
      if ((i5 != 0) && (localLayoutParams3.height == -1))
      {
        i64 = 1;
        label563:
        if (localLayoutParams3.g <= 0.0F) {
          break label887;
        }
        if (i58 == 0) {
          break label880;
        }
      }
      int i66;
      int i65;
      label675:
      label730:
      label862:
      label864:
      label880:
      for (int i71 = i59;; i71 = i60)
      {
        i66 = Math.max(i4, i71);
        i65 = i3;
        i13 += a(localView4, i13);
        i67 = i10;
        i4 = i66;
        i3 = i65;
        i68 = i63;
        i69 = i12;
        i70 = i62;
        i9 = i57;
        f1 = f7;
        break;
        int i75 = this.f;
        this.f = Math.max(i75, i75 + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin);
        break label377;
        i10 = 1;
        break label398;
        int i52 = -2147483648;
        if ((localLayoutParams3.width == 0) && (localLayoutParams3.g > 0.0F))
        {
          i52 = 0;
          localLayoutParams3.width = -2;
        }
        int i53 = i52;
        int i54;
        int i55;
        if (f7 == 0.0F)
        {
          i54 = this.f;
          a(localView4, i13, paramInt1, i54, paramInt2, 0);
          if (i53 != -2147483648) {
            localLayoutParams3.width = i53;
          }
          i55 = localView4.getMeasuredWidth();
          if (i11 == 0) {
            break label822;
          }
        }
        int i56;
        for (this.f += i55 + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin + b(localView4);; this.f = Math.max(i56, i56 + i55 + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin + b(localView4)))
        {
          if (!bool2) {
            break label862;
          }
          i12 = Math.max(i55, i12);
          break;
          i54 = 0;
          break label730;
          i56 = this.f;
        }
        break label398;
        i73 = localLayoutParams3.h;
        break label491;
        i64 = 0;
        break label563;
      }
      label822:
      label887:
      if (i58 != 0) {}
      for (;;)
      {
        i65 = Math.max(i3, i59);
        i66 = i4;
        break;
        i59 = i60;
      }
      label915:
      if ((this.f > 0) && (c(i6))) {
        this.f += this.l;
      }
      int i14;
      if ((arrayOfInt1[1] != -1) || (arrayOfInt1[0] != -1) || (arrayOfInt1[2] != -1) || (arrayOfInt1[3] != -1)) {
        i14 = Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2])));
      }
      for (int i15 = Math.max(i1, i14);; i15 = i1)
      {
        if ((bool2) && ((i7 == -2147483648) || (i7 == 0)))
        {
          this.f = 0;
          int i49 = 0;
          if (i49 < i6)
          {
            View localView3 = b(i49);
            int i51;
            if (localView3 == null)
            {
              this.f += d(i49);
              i51 = i49;
            }
            for (;;)
            {
              i49 = i51 + 1;
              break;
              if (localView3.getVisibility() == 8)
              {
                i51 = i49 + a(localView3, i49);
              }
              else
              {
                LinearLayoutCompat.LayoutParams localLayoutParams2 = (LinearLayoutCompat.LayoutParams)localView3.getLayoutParams();
                if (i11 != 0)
                {
                  this.f += i12 + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin + b(localView3);
                  i51 = i49;
                }
                else
                {
                  int i50 = this.f;
                  this.f = Math.max(i50, i50 + i12 + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin + b(localView3));
                  i51 = i49;
                }
              }
            }
          }
        }
        this.f += getPaddingLeft() + getPaddingRight();
        int i16 = ViewCompat.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumWidth()), paramInt1, 0);
        int i17 = (0xFFFFFF & i16) - this.f;
        int i18;
        float f2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        View localView1;
        float f3;
        int i27;
        int i28;
        int i29;
        int i30;
        if ((i10 != 0) || ((i17 != 0) && (f1 > 0.0F)))
        {
          if (this.g > 0.0F) {
            f1 = this.g;
          }
          arrayOfInt1[3] = -1;
          arrayOfInt1[2] = -1;
          arrayOfInt1[1] = -1;
          arrayOfInt1[0] = -1;
          arrayOfInt2[3] = -1;
          arrayOfInt2[2] = -1;
          arrayOfInt2[1] = -1;
          arrayOfInt2[0] = -1;
          this.f = 0;
          i18 = 0;
          f2 = f1;
          i19 = i5;
          i20 = i3;
          i21 = i2;
          i22 = i17;
          i23 = -1;
          if (i18 < i6)
          {
            localView1 = b(i18);
            if (localView1 == null) {
              break label2270;
            }
            if (localView1.getVisibility() == 8)
            {
              f3 = f2;
              i27 = i22;
              i28 = i23;
              i29 = i20;
              i30 = i19;
            }
          }
        }
        for (;;)
        {
          i18++;
          i20 = i29;
          i23 = i28;
          i19 = i30;
          i22 = i27;
          f2 = f3;
          break;
          LinearLayoutCompat.LayoutParams localLayoutParams1 = (LinearLayoutCompat.LayoutParams)localView1.getLayoutParams();
          float f4 = localLayoutParams1.g;
          int i44;
          float f6;
          int i31;
          int i45;
          int i32;
          if (f4 > 0.0F)
          {
            i44 = (int)(f4 * i22 / f2);
            f6 = f2 - f4;
            i31 = i22 - i44;
            i45 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin, localLayoutParams1.height);
            if ((localLayoutParams1.width != 0) || (i7 != 1073741824))
            {
              int i46 = i44 + localView1.getMeasuredWidth();
              if (i46 < 0) {
                i46 = 0;
              }
              localView1.measure(View.MeasureSpec.makeMeasureSpec(i46, 1073741824), i45);
              i32 = ViewUtils.a(i21, 0xFF000000 & ViewCompat.getMeasuredState(localView1));
            }
          }
          for (float f5 = f6;; f5 = f2)
          {
            label1648:
            int i34;
            label1667:
            int i36;
            int i37;
            int i38;
            label1708:
            int i39;
            int i40;
            label1734:
            int i41;
            if (i11 != 0)
            {
              this.f += localView1.getMeasuredWidth() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin + b(localView1);
              if ((i8 == 1073741824) || (localLayoutParams1.height != -1)) {
                break label1913;
              }
              i34 = 1;
              int i35 = localLayoutParams1.topMargin + localLayoutParams1.bottomMargin;
              i36 = i35 + localView1.getMeasuredHeight();
              i37 = Math.max(i23, i36);
              if (i34 == 0) {
                break label1919;
              }
              i38 = i35;
              i39 = Math.max(i20, i38);
              if ((i19 == 0) || (localLayoutParams1.height != -1)) {
                break label1926;
              }
              i40 = 1;
              if (bool1)
              {
                i41 = localView1.getBaseline();
                if (i41 != -1) {
                  if (localLayoutParams1.h >= 0) {
                    break label1932;
                  }
                }
              }
            }
            label1926:
            label1932:
            for (int i42 = this.e;; i42 = localLayoutParams1.h)
            {
              int i43 = (0xFFFFFFFE & (i42 & 0x70) >> 4) >> 1;
              arrayOfInt1[i43] = Math.max(arrayOfInt1[i43], i41);
              arrayOfInt2[i43] = Math.max(arrayOfInt2[i43], i36 - i41);
              f3 = f5;
              i29 = i39;
              i30 = i40;
              i21 = i32;
              i27 = i31;
              i28 = i37;
              break;
              if (i44 > 0) {}
              for (;;)
              {
                localView1.measure(View.MeasureSpec.makeMeasureSpec(i44, 1073741824), i45);
                break;
                i44 = 0;
              }
              int i33 = this.f;
              this.f = Math.max(i33, i33 + localView1.getMeasuredWidth() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin + b(localView1));
              break label1648;
              label1913:
              i34 = 0;
              break label1667;
              label1919:
              i38 = i36;
              break label1708;
              i40 = 0;
              break label1734;
            }
            this.f += getPaddingLeft() + getPaddingRight();
            if ((arrayOfInt1[1] != -1) || (arrayOfInt1[0] != -1) || (arrayOfInt1[2] != -1) || (arrayOfInt1[3] != -1)) {
              i23 = Math.max(i23, Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))));
            }
            i5 = i19;
            int i24 = i20;
            i2 = i21;
            for (int i25 = i23;; i25 = i15)
            {
              if ((i5 == 0) && (i8 != 1073741824)) {}
              int i47;
              for (;;)
              {
                int i26 = Math.max(i24 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
                setMeasuredDimension(i16 | 0xFF000000 & i2, ViewCompat.resolveSizeAndState(i26, paramInt2, i2 << 16));
                if (i9 != 0) {
                  d(i6, paramInt1);
                }
                return;
                i47 = Math.max(i3, i4);
                if ((!bool2) || (i7 == 1073741824)) {
                  break;
                }
                int i48 = 0;
                if (i48 >= i6) {
                  break;
                }
                View localView2 = b(i48);
                if ((localView2 == null) || (localView2.getVisibility() == 8)) {}
                for (;;)
                {
                  i48++;
                  break;
                  if (((LinearLayoutCompat.LayoutParams)localView2.getLayoutParams()).g > 0.0F) {
                    localView2.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(localView2.getMeasuredHeight(), 1073741824));
                  }
                }
                i24 = i25;
              }
              i24 = i47;
            }
            i31 = i22;
            i32 = i21;
          }
          label2270:
          f3 = f2;
          i27 = i22;
          i28 = i23;
          i29 = i20;
          i30 = i19;
        }
      }
      label2299:
      i57 = i9;
    }
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.a(this);
    int i1 = getPaddingTop();
    int i2 = paramInt4 - paramInt2;
    int i3 = i2 - getPaddingBottom();
    int i4 = i2 - i1 - getPaddingBottom();
    int i5 = getVirtualChildCount();
    int i6 = 0x800007 & this.e;
    int i7 = 0x70 & this.e;
    boolean bool2 = this.a;
    int[] arrayOfInt1 = this.i;
    int[] arrayOfInt2 = this.j;
    int i8;
    int i22;
    int i9;
    switch (GravityCompat.getAbsoluteGravity(i6, ViewCompat.getLayoutDirection(this)))
    {
    default: 
      i8 = getPaddingLeft();
      if (bool1)
      {
        i22 = i5 - 1;
        i9 = -1;
      }
      break;
    }
    for (int i10 = i22;; i10 = 0)
    {
      int i11 = 0;
      label143:
      int i12;
      View localView;
      int i13;
      if (i11 < i5)
      {
        i12 = i10 + i9 * i11;
        localView = b(i12);
        if (localView == null)
        {
          i8 += d(i12);
          i13 = i11;
        }
      }
      for (;;)
      {
        i11 = i13 + 1;
        break label143;
        i8 = paramInt3 + getPaddingLeft() - paramInt1 - this.f;
        break;
        i8 = getPaddingLeft() + (paramInt3 - paramInt1 - this.f) / 2;
        break;
        if (localView.getVisibility() != 8)
        {
          int i14 = localView.getMeasuredWidth();
          int i15 = localView.getMeasuredHeight();
          LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
          if ((bool2) && (localLayoutParams.height != -1)) {}
          for (int i16 = localView.getBaseline();; i16 = -1)
          {
            int i17 = localLayoutParams.h;
            if (i17 < 0) {
              i17 = i7;
            }
            int i18;
            switch (i17 & 0x70)
            {
            default: 
              i18 = i1;
              label348:
              if (!c(i12)) {
                break;
              }
            }
            for (int i20 = i8 + this.l;; i20 = i8)
            {
              int i21 = i20 + localLayoutParams.leftMargin;
              a(localView, i21 + a(localView), i18, i14, i15);
              i8 = i21 + (i14 + localLayoutParams.rightMargin + b(localView));
              i13 = i11 + a(localView, i12);
              break;
              i18 = i1 + localLayoutParams.topMargin;
              if (i16 == -1) {
                break label348;
              }
              i18 += arrayOfInt1[1] - i16;
              break label348;
              i18 = i1 + (i4 - i15) / 2 + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
              break label348;
              i18 = i3 - i15 - localLayoutParams.bottomMargin;
              if (i16 == -1) {
                break label348;
              }
              int i19 = localView.getMeasuredHeight() - i16;
              i18 -= arrayOfInt2[2] - i19;
              break label348;
              return;
            }
          }
        }
        i13 = i11;
      }
      i9 = 1;
    }
  }
  
  void b(Canvas paramCanvas)
  {
    int i1 = getVirtualChildCount();
    boolean bool = ViewUtils.a(this);
    int i2 = 0;
    if (i2 < i1)
    {
      View localView2 = b(i2);
      LinearLayoutCompat.LayoutParams localLayoutParams2;
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (c(i2)))
      {
        localLayoutParams2 = (LinearLayoutCompat.LayoutParams)localView2.getLayoutParams();
        if (!bool) {
          break label91;
        }
      }
      label91:
      for (int i4 = localView2.getRight() + localLayoutParams2.rightMargin;; i4 = localView2.getLeft() - localLayoutParams2.leftMargin - this.l)
      {
        b(paramCanvas, i4);
        i2++;
        break;
      }
    }
    View localView1;
    int i3;
    if (c(i1))
    {
      localView1 = b(i1 - 1);
      if (localView1 != null) {
        break label171;
      }
      if (!bool) {
        break label152;
      }
      i3 = getPaddingLeft();
    }
    for (;;)
    {
      b(paramCanvas, i3);
      return;
      label152:
      i3 = getWidth() - getPaddingRight() - this.l;
      continue;
      label171:
      LinearLayoutCompat.LayoutParams localLayoutParams1 = (LinearLayoutCompat.LayoutParams)localView1.getLayoutParams();
      if (bool) {
        i3 = localView1.getLeft() - localLayoutParams1.leftMargin - this.l;
      } else {
        i3 = localView1.getRight() + localLayoutParams1.rightMargin;
      }
    }
  }
  
  void b(Canvas paramCanvas, int paramInt)
  {
    this.k.setBounds(paramInt, getPaddingTop() + this.o, paramInt + this.l, getHeight() - getPaddingBottom() - this.o);
    this.k.draw(paramCanvas);
  }
  
  protected boolean c(int paramInt)
  {
    if (paramInt == 0) {
      if ((0x1 & this.n) == 0) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != getChildCount()) {
        break;
      }
    } while ((0x4 & this.n) != 0);
    return false;
    if ((0x2 & this.n) != 0) {
      for (int i1 = paramInt - 1;; i1--)
      {
        if (i1 < 0) {
          break label74;
        }
        if (getChildAt(i1).getVisibility() != 8) {
          break;
        }
      }
    }
    return false;
    label74:
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LinearLayoutCompat.LayoutParams;
  }
  
  int d(int paramInt)
  {
    return 0;
  }
  
  public int getBaseline()
  {
    int i1 = -1;
    if (this.b < 0) {
      i1 = super.getBaseline();
    }
    View localView;
    int i2;
    do
    {
      return i1;
      if (getChildCount() <= this.b) {
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      }
      localView = getChildAt(this.b);
      i2 = localView.getBaseline();
      if (i2 != i1) {
        break;
      }
    } while (this.b == 0);
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    int i3 = this.c;
    int i5;
    if (this.d == 1)
    {
      i5 = 0x70 & this.e;
      if (i5 == 48) {}
    }
    int i4;
    switch (i5)
    {
    default: 
      i4 = i3;
    }
    for (;;)
    {
      return i2 + (i4 + ((LinearLayoutCompat.LayoutParams)localView.getLayoutParams()).topMargin);
      i4 = getBottom() - getTop() - getPaddingBottom() - this.f;
      continue;
      i4 = i3 + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.f) / 2;
    }
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.b;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.k;
  }
  
  public int getDividerPadding()
  {
    return this.o;
  }
  
  public int getDividerWidth()
  {
    return this.l;
  }
  
  public int getOrientation()
  {
    return this.d;
  }
  
  public int getShowDividers()
  {
    return this.n;
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return this.g;
  }
  
  protected LinearLayoutCompat.LayoutParams j()
  {
    if (this.d == 0) {
      return new LinearLayoutCompat.LayoutParams(-2, -2);
    }
    if (this.d == 1) {
      return new LinearLayoutCompat.LayoutParams(-1, -2);
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.k == null) {
      return;
    }
    if (this.d == 1)
    {
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.d == 1)
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.d == 1)
    {
      a(paramInt1, paramInt2);
      return;
    }
    b(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }
    this.b = paramInt;
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.k) {
      return;
    }
    this.k = paramDrawable;
    if (paramDrawable != null) {
      this.l = paramDrawable.getIntrinsicWidth();
    }
    for (this.m = paramDrawable.getIntrinsicHeight();; this.m = 0)
    {
      boolean bool = false;
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      return;
      this.l = 0;
    }
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.e != paramInt) {
      if ((0x800007 & paramInt) != 0) {
        break label44;
      }
    }
    label44:
    for (int i1 = 0x800003 | paramInt;; i1 = paramInt)
    {
      if ((i1 & 0x70) == 0) {
        i1 |= 48;
      }
      this.e = i1;
      requestLayout();
      return;
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    int i1 = paramInt & 0x800007;
    if ((0x800007 & this.e) != i1)
    {
      this.e = (i1 | 0xFF7FFFF8 & this.e);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.n) {
      requestLayout();
    }
    this.n = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    int i1 = paramInt & 0x70;
    if ((0x70 & this.e) != i1)
    {
      this.e = (i1 | 0xFFFFFF8F & this.e);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    this.g = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */