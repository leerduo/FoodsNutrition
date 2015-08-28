package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
  extends AbsActionBarView
  implements ViewPropertyAnimatorListener
{
  private CharSequence j;
  private CharSequence k;
  private View l;
  private View m;
  private LinearLayout n;
  private TextView o;
  private TextView p;
  private int q;
  private int r;
  private Drawable s;
  private boolean t;
  private int u;
  private ViewPropertyAnimatorCompatSet v;
  private boolean w;
  private int x;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    setBackgroundDrawable(localTintTypedArray.a(R.styleable.ActionMode_background));
    this.q = localTintTypedArray.f(R.styleable.ActionMode_titleTextStyle, 0);
    this.r = localTintTypedArray.f(R.styleable.ActionMode_subtitleTextStyle, 0);
    this.h = localTintTypedArray.e(R.styleable.ActionMode_height, 0);
    this.s = localTintTypedArray.a(R.styleable.ActionMode_backgroundSplit);
    this.u = localTintTypedArray.f(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    localTintTypedArray.b();
  }
  
  private void e()
  {
    int i = 8;
    int i1 = 1;
    if (this.n == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      this.n = ((LinearLayout)getChildAt(-1 + getChildCount()));
      this.o = ((TextView)this.n.findViewById(R.id.action_bar_title));
      this.p = ((TextView)this.n.findViewById(R.id.action_bar_subtitle));
      if (this.q != 0) {
        this.o.setTextAppearance(getContext(), this.q);
      }
      if (this.r != 0) {
        this.p.setTextAppearance(getContext(), this.r);
      }
    }
    this.o.setText(this.j);
    this.p.setText(this.k);
    int i2;
    label166:
    TextView localTextView;
    if (!TextUtils.isEmpty(this.j))
    {
      i2 = i1;
      if (TextUtils.isEmpty(this.k)) {
        break label232;
      }
      localTextView = this.p;
      if (i1 == 0) {
        break label237;
      }
    }
    label232:
    label237:
    for (int i3 = 0;; i3 = i)
    {
      localTextView.setVisibility(i3);
      LinearLayout localLinearLayout = this.n;
      if ((i2 != 0) || (i1 != 0)) {
        i = 0;
      }
      localLinearLayout.setVisibility(i);
      if (this.n.getParent() == null) {
        addView(this.n);
      }
      return;
      i2 = 0;
      break;
      i1 = 0;
      break label166;
    }
  }
  
  private void f()
  {
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = this.v;
    if (localViewPropertyAnimatorCompatSet != null)
    {
      this.v = null;
      localViewPropertyAnimatorCompatSet.b();
    }
  }
  
  private ViewPropertyAnimatorCompatSet g()
  {
    ViewCompat.setTranslationX(this.l, -this.l.getWidth() - ((ViewGroup.MarginLayoutParams)this.l.getLayoutParams()).leftMargin);
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(this.l).translationX(0.0F);
    localViewPropertyAnimatorCompat1.setDuration(200L);
    localViewPropertyAnimatorCompat1.setListener(this);
    localViewPropertyAnimatorCompat1.setInterpolator(new DecelerateInterpolator());
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
    localViewPropertyAnimatorCompatSet.a(localViewPropertyAnimatorCompat1);
    if (this.c != null)
    {
      int i = this.c.getChildCount();
      if (i > 0)
      {
        int i1 = i - 1;
        for (int i2 = 0; i1 >= 0; i2++)
        {
          View localView = this.c.getChildAt(i1);
          ViewCompat.setScaleY(localView, 0.0F);
          ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = ViewCompat.animate(localView).scaleY(1.0F);
          localViewPropertyAnimatorCompat2.setDuration(300L);
          localViewPropertyAnimatorCompatSet.a(localViewPropertyAnimatorCompat2);
          i1--;
        }
      }
    }
    return localViewPropertyAnimatorCompatSet;
  }
  
  private ViewPropertyAnimatorCompatSet h()
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.l).translationX(-this.l.getWidth() - ((ViewGroup.MarginLayoutParams)this.l.getLayoutParams()).leftMargin);
    localViewPropertyAnimatorCompat.setDuration(200L);
    localViewPropertyAnimatorCompat.setListener(this);
    localViewPropertyAnimatorCompat.setInterpolator(new DecelerateInterpolator());
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
    localViewPropertyAnimatorCompatSet.a(localViewPropertyAnimatorCompat);
    if ((this.c != null) && (this.c.getChildCount() > 0)) {}
    return localViewPropertyAnimatorCompatSet;
  }
  
  public void a(ActionMode paramActionMode)
  {
    MenuBuilder localMenuBuilder;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.l == null)
    {
      this.l = LayoutInflater.from(getContext()).inflate(this.u, this, false);
      addView(this.l);
      this.l.findViewById(R.id.action_mode_close_button).setOnClickListener(new ActionBarContextView.1(this, paramActionMode));
      localMenuBuilder = (MenuBuilder)paramActionMode.b();
      if (this.d != null) {
        this.d.e();
      }
      this.d = new ActionMenuPresenter(getContext());
      this.d.b(true);
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      if (this.f) {
        break label192;
      }
      localMenuBuilder.a(this.d, this.b);
      this.c = ((ActionMenuView)this.d.a(this));
      this.c.setBackgroundDrawable(null);
      addView(this.c, localLayoutParams);
    }
    for (;;)
    {
      this.w = true;
      return;
      if (this.l.getParent() != null) {
        break;
      }
      addView(this.l);
      break;
      label192:
      this.d.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.d.b(2147483647);
      localLayoutParams.width = -1;
      localLayoutParams.height = this.h;
      localMenuBuilder.a(this.d, this.b);
      this.c = ((ActionMenuView)this.d.a(this));
      this.c.setBackgroundDrawable(this.s);
      this.e.addView(this.c, localLayoutParams);
    }
  }
  
  public boolean a()
  {
    if (this.d != null) {
      return this.d.c();
    }
    return false;
  }
  
  public void b()
  {
    if (this.x == 2) {
      return;
    }
    if (this.l == null)
    {
      c();
      return;
    }
    f();
    this.x = 2;
    this.v = h();
    this.v.a();
  }
  
  public void c()
  {
    f();
    removeAllViews();
    if (this.e != null) {
      this.e.removeView(this.c);
    }
    this.m = null;
    this.c = null;
    this.w = false;
  }
  
  public boolean d()
  {
    return this.t;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.k;
  }
  
  public CharSequence getTitle()
  {
    return this.j;
  }
  
  public void onAnimationCancel(View paramView) {}
  
  public void onAnimationEnd(View paramView)
  {
    if (this.x == 2) {
      c();
    }
    this.x = 0;
  }
  
  public void onAnimationStart(View paramView) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.d != null)
    {
      this.d.d();
      this.d.f();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent.setSource(this);
        paramAccessibilityEvent.setClassName(getClass().getName());
        paramAccessibilityEvent.setPackageName(getContext().getPackageName());
        paramAccessibilityEvent.setContentDescription(this.j);
      }
    }
    else {
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.a(this);
    int i;
    int i1;
    int i2;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i5;
    label87:
    int i6;
    label99:
    int i4;
    label259:
    ActionMenuView localActionMenuView;
    if (bool1)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      i1 = getPaddingTop();
      i2 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      if ((this.l != null) && (this.l.getVisibility() != 8))
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.l.getLayoutParams();
        if (!bool1) {
          break label308;
        }
        i5 = localMarginLayoutParams.rightMargin;
        if (!bool1) {
          break label318;
        }
        i6 = localMarginLayoutParams.leftMargin;
        int i7 = a(i, i5, bool1);
        i = a(i7 + a(this.l, i7, i1, i2, bool1), i6, bool1);
        if (this.w)
        {
          this.x = 1;
          this.v = g();
          this.v.a();
          this.w = false;
        }
      }
      int i3 = i;
      if ((this.n != null) && (this.m == null) && (this.n.getVisibility() != 8)) {
        i3 += a(this.n, i3, i1, i2, bool1);
      }
      if (this.m != null) {
        (i3 + a(this.m, i3, i1, i2, bool1));
      }
      if (!bool1) {
        break label328;
      }
      i4 = getPaddingLeft();
      if (this.c != null)
      {
        localActionMenuView = this.c;
        if (bool1) {
          break label342;
        }
      }
    }
    label308:
    label318:
    label328:
    label342:
    for (boolean bool2 = true;; bool2 = false)
    {
      (i4 + a(localActionMenuView, i4, i1, i2, bool2));
      return;
      i = getPaddingLeft();
      break;
      i5 = localMarginLayoutParams.leftMargin;
      break label87;
      i6 = localMarginLayoutParams.rightMargin;
      break label99;
      i4 = paramInt3 - paramInt1 - getPaddingRight();
      break label259;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1073741824;
    int i1 = 0;
    if (View.MeasureSpec.getMode(paramInt1) != i) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    }
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3;
    int i5;
    int i6;
    int i7;
    int i15;
    label304:
    int i16;
    label330:
    label337:
    int i11;
    label366:
    int i12;
    label396:
    label416:
    int i9;
    label452:
    int i10;
    if (this.h > 0)
    {
      i3 = this.h;
      int i4 = getPaddingTop() + getPaddingBottom();
      i5 = i2 - getPaddingLeft() - getPaddingRight();
      i6 = i3 - i4;
      i7 = View.MeasureSpec.makeMeasureSpec(i6, -2147483648);
      if (this.l != null)
      {
        int i17 = a(this.l, i5, i7, 0);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.l.getLayoutParams();
        i5 = i17 - (localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
      }
      if ((this.c != null) && (this.c.getParent() == this)) {
        i5 = a(this.c, i5, i7, 0);
      }
      if ((this.n != null) && (this.m == null))
      {
        if (!this.t) {
          break label512;
        }
        int i13 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.n.measure(i13, i7);
        int i14 = this.n.getMeasuredWidth();
        if (i14 > i5) {
          break label499;
        }
        i15 = 1;
        if (i15 != 0) {
          i5 -= i14;
        }
        LinearLayout localLinearLayout = this.n;
        if (i15 == 0) {
          break label505;
        }
        i16 = 0;
        localLinearLayout.setVisibility(i16);
      }
      if (this.m != null)
      {
        ViewGroup.LayoutParams localLayoutParams = this.m.getLayoutParams();
        if (localLayoutParams.width == -2) {
          break label530;
        }
        i11 = i;
        if (localLayoutParams.width >= 0) {
          i5 = Math.min(localLayoutParams.width, i5);
        }
        if (localLayoutParams.height == -2) {
          break label538;
        }
        if (localLayoutParams.height < 0) {
          break label545;
        }
        i12 = Math.min(localLayoutParams.height, i6);
        this.m.measure(View.MeasureSpec.makeMeasureSpec(i5, i11), View.MeasureSpec.makeMeasureSpec(i12, i));
      }
      if (this.h > 0) {
        break label561;
      }
      int i8 = getChildCount();
      i9 = 0;
      if (i1 >= i8) {
        break label552;
      }
      i10 = i4 + getChildAt(i1).getMeasuredHeight();
      if (i10 <= i9) {
        break label570;
      }
    }
    for (;;)
    {
      i1++;
      i9 = i10;
      break label452;
      i3 = View.MeasureSpec.getSize(paramInt2);
      break;
      label499:
      i15 = 0;
      break label304;
      label505:
      i16 = 8;
      break label330;
      label512:
      i5 = a(this.n, i5, i7, 0);
      break label337;
      label530:
      i11 = -2147483648;
      break label366;
      label538:
      i = -2147483648;
      break label396;
      label545:
      i12 = i6;
      break label416;
      label552:
      setMeasuredDimension(i2, i9);
      return;
      label561:
      setMeasuredDimension(i2, i3);
      return;
      label570:
      i10 = i9;
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.m != null) {
      removeView(this.m);
    }
    this.m = paramView;
    if (this.n != null)
    {
      removeView(this.n);
      this.n = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSplitToolbar(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (this.f != paramBoolean) {
      if (this.d != null)
      {
        localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (paramBoolean) {
          break label94;
        }
        this.c = ((ActionMenuView)this.d.a(this));
        this.c.setBackgroundDrawable(null);
        ViewGroup localViewGroup2 = (ViewGroup)this.c.getParent();
        if (localViewGroup2 != null) {
          localViewGroup2.removeView(this.c);
        }
        addView(this.c, localLayoutParams);
      }
    }
    for (;;)
    {
      super.setSplitToolbar(paramBoolean);
      return;
      label94:
      this.d.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.d.b(2147483647);
      localLayoutParams.width = -1;
      localLayoutParams.height = this.h;
      this.c = ((ActionMenuView)this.d.a(this));
      this.c.setBackgroundDrawable(this.s);
      ViewGroup localViewGroup1 = (ViewGroup)this.c.getParent();
      if (localViewGroup1 != null) {
        localViewGroup1.removeView(this.c);
      }
      this.e.addView(this.c, localLayoutParams);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
    e();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    e();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.t) {
      requestLayout();
    }
    this.t = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarContextView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */