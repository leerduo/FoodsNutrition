package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.RtlSpacingHelper;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.internal.widget.ViewUtils;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private final ArrayList<View> A = new ArrayList();
  private final int[] B = new int[2];
  private Toolbar.OnMenuItemClickListener C;
  private final ActionMenuView.OnMenuItemClickListener D = new Toolbar.1(this);
  private ToolbarWidgetWrapper E;
  private ActionMenuPresenter F;
  private Toolbar.ExpandedActionViewMenuPresenter G;
  private MenuPresenter.Callback H;
  private MenuBuilder.Callback I;
  private boolean J;
  private int K;
  private final Runnable L = new Toolbar.2(this);
  private final TintManager M;
  View a;
  private ActionMenuView b;
  private TextView c;
  private TextView d;
  private ImageButton e;
  private ImageView f;
  private Drawable g;
  private CharSequence h;
  private ImageButton i;
  private Context j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private final RtlSpacingHelper t = new RtlSpacingHelper();
  private int u = 8388627;
  private CharSequence v;
  private CharSequence w;
  private int x;
  private int y;
  private boolean z;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(a(paramContext, paramAttributeSet, paramInt), paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.l = localTintTypedArray.f(R.styleable.Toolbar_titleTextAppearance, 0);
    this.m = localTintTypedArray.f(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.u = localTintTypedArray.b(R.styleable.Toolbar_android_gravity, this.u);
    this.n = 48;
    int i1 = localTintTypedArray.c(R.styleable.Toolbar_titleMargins, 0);
    this.s = i1;
    this.r = i1;
    this.q = i1;
    this.p = i1;
    int i2 = localTintTypedArray.c(R.styleable.Toolbar_titleMarginStart, -1);
    if (i2 >= 0) {
      this.p = i2;
    }
    int i3 = localTintTypedArray.c(R.styleable.Toolbar_titleMarginEnd, -1);
    if (i3 >= 0) {
      this.q = i3;
    }
    int i4 = localTintTypedArray.c(R.styleable.Toolbar_titleMarginTop, -1);
    if (i4 >= 0) {
      this.r = i4;
    }
    int i5 = localTintTypedArray.c(R.styleable.Toolbar_titleMarginBottom, -1);
    if (i5 >= 0) {
      this.s = i5;
    }
    this.o = localTintTypedArray.d(R.styleable.Toolbar_maxButtonHeight, -1);
    int i6 = localTintTypedArray.c(R.styleable.Toolbar_contentInsetStart, -2147483648);
    int i7 = localTintTypedArray.c(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    int i8 = localTintTypedArray.d(R.styleable.Toolbar_contentInsetLeft, 0);
    int i9 = localTintTypedArray.d(R.styleable.Toolbar_contentInsetRight, 0);
    this.t.b(i8, i9);
    if ((i6 != -2147483648) || (i7 != -2147483648)) {
      this.t.a(i6, i7);
    }
    this.g = localTintTypedArray.a(R.styleable.Toolbar_collapseIcon);
    this.h = localTintTypedArray.b(R.styleable.Toolbar_collapseContentDescription);
    CharSequence localCharSequence1 = localTintTypedArray.b(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(localCharSequence1)) {
      setTitle(localCharSequence1);
    }
    CharSequence localCharSequence2 = localTintTypedArray.b(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(localCharSequence2)) {
      setSubtitle(localCharSequence2);
    }
    this.j = getContext();
    setPopupTheme(localTintTypedArray.f(R.styleable.Toolbar_popupTheme, 0));
    Drawable localDrawable = localTintTypedArray.a(R.styleable.Toolbar_navigationIcon);
    if (localDrawable != null) {
      setNavigationIcon(localDrawable);
    }
    CharSequence localCharSequence3 = localTintTypedArray.b(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(localCharSequence3)) {
      setNavigationContentDescription(localCharSequence3);
    }
    this.K = localTintTypedArray.d(R.styleable.Toolbar_android_minHeight, 0);
    localTintTypedArray.b();
    this.M = localTintTypedArray.c();
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt & 0x70;
    switch (i1)
    {
    default: 
      i1 = 0x70 & this.u;
    }
    return i1;
  }
  
  private int a(View paramView, int paramInt)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i1 = paramView.getMeasuredHeight();
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i8;
    if (paramInt > 0)
    {
      i2 = (i1 - paramInt) / 2;
      switch (a(localLayoutParams.a))
      {
      default: 
        i3 = getPaddingTop();
        i4 = getPaddingBottom();
        i5 = getHeight();
        i6 = (i5 - i3 - i4 - i1) / 2;
        if (i6 < localLayoutParams.topMargin) {
          i8 = localLayoutParams.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return i8 + i3;
      i2 = 0;
      break;
      return getPaddingTop() - i2;
      return getHeight() - getPaddingBottom() - i1 - localLayoutParams.bottomMargin - i2;
      int i7 = i5 - i4 - i1 - i6 - i3;
      if (i7 < localLayoutParams.bottomMargin) {
        i8 = Math.max(0, i6 - (localLayoutParams.bottomMargin - i7));
      } else {
        i8 = i6;
      }
    }
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, paramInt2 + (i3 + (getPaddingLeft() + getPaddingRight())), localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, paramInt4 + (getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin), localMarginLayoutParams.height));
    return i3 + paramView.getMeasuredWidth();
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = paramInt1 + Math.max(0, i1);
    paramArrayOfInt[0] = Math.max(0, -i1);
    int i3 = a(paramView, paramInt2);
    int i4 = paramView.getMeasuredWidth();
    paramView.layout(i2, i3, i2 + i4, i3 + paramView.getMeasuredHeight());
    return i2 + (i4 + localLayoutParams.rightMargin);
  }
  
  private int a(List<View> paramList, int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt[0];
    int i2 = paramArrayOfInt[1];
    int i3 = paramList.size();
    int i4 = 0;
    int i5 = 0;
    int i6 = i2;
    int i7 = i1;
    while (i4 < i3)
    {
      View localView = (View)paramList.get(i4);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)localView.getLayoutParams();
      int i8 = localLayoutParams.leftMargin - i7;
      int i9 = localLayoutParams.rightMargin - i6;
      int i10 = Math.max(0, i8);
      int i11 = Math.max(0, i9);
      i7 = Math.max(0, -i8);
      i6 = Math.max(0, -i9);
      int i12 = i5 + (i11 + (i10 + localView.getMeasuredWidth()));
      i4++;
      i5 = i12;
    }
    return i5;
  }
  
  private static Context a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    int i1 = localTypedArray.getResourceId(R.styleable.Toolbar_theme, 0);
    if (i1 != 0) {
      paramContext = new ContextThemeWrapper(paramContext, i1);
    }
    localTypedArray.recycle();
    return paramContext;
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Toolbar.LayoutParams localLayoutParams1;
    if (localLayoutParams == null) {
      localLayoutParams1 = i();
    }
    for (;;)
    {
      localLayoutParams1.b = 1;
      addView(paramView, localLayoutParams1);
      return;
      if (!checkLayoutParams(localLayoutParams)) {
        localLayoutParams1 = a(localLayoutParams);
      } else {
        localLayoutParams1 = (Toolbar.LayoutParams)localLayoutParams;
      }
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, paramInt2 + (getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin), localMarginLayoutParams.width);
    int i2 = getChildMeasureSpec(paramInt3, paramInt4 + (getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin), localMarginLayoutParams.height);
    int i3 = View.MeasureSpec.getMode(i2);
    if ((i3 != 1073741824) && (paramInt5 >= 0))
    {
      if (i3 != 0) {
        paramInt5 = Math.min(View.MeasureSpec.getSize(i2), paramInt5);
      }
      i2 = View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824);
    }
    paramView.measure(i1, i2);
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i1 = 1;
    if (ViewCompat.getLayoutDirection(this) == i1) {}
    int i2;
    int i3;
    int i4;
    for (;;)
    {
      i2 = getChildCount();
      i3 = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
      paramList.clear();
      i4 = 0;
      if (i1 == 0) {
        break;
      }
      for (int i5 = i2 - 1; i5 >= 0; i5--)
      {
        View localView2 = getChildAt(i5);
        Toolbar.LayoutParams localLayoutParams2 = (Toolbar.LayoutParams)localView2.getLayoutParams();
        if ((localLayoutParams2.b == 0) && (b(localView2)) && (b(localLayoutParams2.a) == i3)) {
          paramList.add(localView2);
        }
      }
      i1 = 0;
    }
    while (i4 < i2)
    {
      View localView1 = getChildAt(i4);
      Toolbar.LayoutParams localLayoutParams1 = (Toolbar.LayoutParams)localView1.getLayoutParams();
      if ((localLayoutParams1.b == 0) && (b(localView1)) && (b(localLayoutParams1.a) == i3)) {
        paramList.add(localView1);
      }
      i4++;
    }
  }
  
  private int b(int paramInt)
  {
    int i1 = ViewCompat.getLayoutDirection(this);
    int i2 = 0x7 & GravityCompat.getAbsoluteGravity(paramInt, i1);
    switch (i2)
    {
    case 2: 
    case 4: 
    default: 
      if (i1 == 1) {
        i2 = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return i2;
    }
    return 3;
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.rightMargin - paramArrayOfInt[1];
    int i2 = paramInt1 - Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    int i3 = a(paramView, paramInt2);
    int i4 = paramView.getMeasuredWidth();
    paramView.layout(i2 - i4, i3, i2, i3 + paramView.getMeasuredHeight());
    return i2 - (i4 + localLayoutParams.leftMargin);
  }
  
  private boolean b(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private int c(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return MarginLayoutParamsCompat.getMarginStart(localMarginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(localMarginLayoutParams);
  }
  
  private int d(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
  }
  
  private void e(View paramView)
  {
    if ((((Toolbar.LayoutParams)paramView.getLayoutParams()).b != 2) && (paramView != this.b)) {
      if (this.a == null) {
        break label38;
      }
    }
    label38:
    for (int i1 = 8;; i1 = 0)
    {
      paramView.setVisibility(i1);
      return;
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(getContext());
  }
  
  private int getMinimumHeightCompat()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return ViewCompat.getMinimumHeight(this);
    }
    return this.K;
  }
  
  private void j()
  {
    if (this.f == null) {
      this.f = new ImageView(getContext());
    }
  }
  
  private void k()
  {
    l();
    if (this.b.d() == null)
    {
      MenuBuilder localMenuBuilder = (MenuBuilder)this.b.getMenu();
      if (this.G == null) {
        this.G = new Toolbar.ExpandedActionViewMenuPresenter(this, null);
      }
      this.b.setExpandedActionViewsExclusive(true);
      localMenuBuilder.a(this.G, this.j);
    }
  }
  
  private void l()
  {
    if (this.b == null)
    {
      this.b = new ActionMenuView(getContext());
      this.b.setPopupTheme(this.k);
      this.b.setOnMenuItemClickListener(this.D);
      this.b.a(this.H, this.I);
      Toolbar.LayoutParams localLayoutParams = i();
      localLayoutParams.a = (0x800005 | 0x70 & this.n);
      this.b.setLayoutParams(localLayoutParams);
      a(this.b);
    }
  }
  
  private void m()
  {
    if (this.e == null)
    {
      this.e = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      Toolbar.LayoutParams localLayoutParams = i();
      localLayoutParams.a = (0x800003 | 0x70 & this.n);
      this.e.setLayoutParams(localLayoutParams);
    }
  }
  
  private void n()
  {
    if (this.i == null)
    {
      this.i = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.i.setImageDrawable(this.g);
      this.i.setContentDescription(this.h);
      Toolbar.LayoutParams localLayoutParams = i();
      localLayoutParams.a = (0x800003 | 0x70 & this.n);
      localLayoutParams.b = 2;
      this.i.setLayoutParams(localLayoutParams);
      this.i.setOnClickListener(new Toolbar.3(this));
    }
  }
  
  private void o()
  {
    removeCallbacks(this.L);
    post(this.L);
  }
  
  private boolean p()
  {
    if (!this.J) {
      return false;
    }
    int i1 = getChildCount();
    for (int i2 = 0;; i2++)
    {
      if (i2 >= i1) {
        break label55;
      }
      View localView = getChildAt(i2);
      if ((b(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        break;
      }
    }
    label55:
    return true;
  }
  
  private void setChildVisibilityForExpandedActionView(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int i2 = 0;
    if (i2 < i1)
    {
      View localView = getChildAt(i2);
      if ((((Toolbar.LayoutParams)localView.getLayoutParams()).b != 2) && (localView != this.b)) {
        if (!paramBoolean) {
          break label64;
        }
      }
      label64:
      for (int i3 = 8;; i3 = 0)
      {
        localView.setVisibility(i3);
        i2++;
        break;
      }
    }
  }
  
  public Toolbar.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new Toolbar.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected Toolbar.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof Toolbar.LayoutParams)) {
      return new Toolbar.LayoutParams((Toolbar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new Toolbar.LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new Toolbar.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new Toolbar.LayoutParams(paramLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.t.a(paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    this.l = paramInt;
    if (this.c != null) {
      this.c.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void a(MenuBuilder paramMenuBuilder, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramMenuBuilder == null) && (this.b == null)) {}
    MenuBuilder localMenuBuilder;
    do
    {
      return;
      l();
      localMenuBuilder = this.b.d();
    } while (localMenuBuilder == paramMenuBuilder);
    if (localMenuBuilder != null)
    {
      localMenuBuilder.b(this.F);
      localMenuBuilder.b(this.G);
    }
    if (this.G == null) {
      this.G = new Toolbar.ExpandedActionViewMenuPresenter(this, null);
    }
    paramActionMenuPresenter.c(true);
    if (paramMenuBuilder != null)
    {
      paramMenuBuilder.a(paramActionMenuPresenter, this.j);
      paramMenuBuilder.a(this.G, this.j);
    }
    for (;;)
    {
      this.b.setPopupTheme(this.k);
      this.b.setPresenter(paramActionMenuPresenter);
      this.F = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.j, null);
      this.G.a(this.j, null);
      paramActionMenuPresenter.a(true);
      this.G.a(true);
    }
  }
  
  public boolean a()
  {
    return (getVisibility() == 0) && (this.b != null) && (this.b.a());
  }
  
  public void b(Context paramContext, int paramInt)
  {
    this.m = paramInt;
    if (this.d != null) {
      this.d.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.b != null) && (this.b.g());
  }
  
  public boolean c()
  {
    return (this.b != null) && (this.b.h());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof Toolbar.LayoutParams));
  }
  
  public boolean d()
  {
    return (this.b != null) && (this.b.e());
  }
  
  public boolean e()
  {
    return (this.b != null) && (this.b.f());
  }
  
  public void f()
  {
    if (this.b != null) {
      this.b.i();
    }
  }
  
  public boolean g()
  {
    return (this.G != null) && (this.G.b != null);
  }
  
  public int getContentInsetEnd()
  {
    return this.t.d();
  }
  
  public int getContentInsetLeft()
  {
    return this.t.a();
  }
  
  public int getContentInsetRight()
  {
    return this.t.b();
  }
  
  public int getContentInsetStart()
  {
    return this.t.c();
  }
  
  public Drawable getLogo()
  {
    if (this.f != null) {
      return this.f.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.f != null) {
      return this.f.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    k();
    return this.b.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.e != null) {
      return this.e.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.e != null) {
      return this.e.getDrawable();
    }
    return null;
  }
  
  public int getPopupTheme()
  {
    return this.k;
  }
  
  public CharSequence getSubtitle()
  {
    return this.w;
  }
  
  public CharSequence getTitle()
  {
    return this.v;
  }
  
  public DecorToolbar getWrapper()
  {
    if (this.E == null) {
      this.E = new ToolbarWidgetWrapper(this, true);
    }
    return this.E;
  }
  
  public void h()
  {
    if (this.G == null) {}
    for (MenuItemImpl localMenuItemImpl = null;; localMenuItemImpl = this.G.b)
    {
      if (localMenuItemImpl != null) {
        localMenuItemImpl.collapseActionView();
      }
      return;
    }
  }
  
  protected Toolbar.LayoutParams i()
  {
    return new Toolbar.LayoutParams(-2, -2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.L);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int[] arrayOfInt;
    int i9;
    int i10;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      i1 = 1;
      i2 = getWidth();
      i3 = getHeight();
      i4 = getPaddingLeft();
      i5 = getPaddingRight();
      i6 = getPaddingTop();
      i7 = getPaddingBottom();
      i8 = i2 - i5;
      arrayOfInt = this.B;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      i9 = getMinimumHeightCompat();
      if (!b(this.e)) {
        break label1612;
      }
      if (i1 == 0) {
        break label881;
      }
      i8 = b(this.e, i8, arrayOfInt, i9);
      i10 = i4;
    }
    for (;;)
    {
      label112:
      int i11;
      label144:
      label176:
      int i12;
      label272:
      int i13;
      int i14;
      if (b(this.i))
      {
        if (i1 != 0) {
          i8 = b(this.i, i8, arrayOfInt, i9);
        }
      }
      else
      {
        if (b(this.b))
        {
          if (i1 == 0) {
            break label919;
          }
          i10 = a(this.b, i10, arrayOfInt, i9);
        }
        arrayOfInt[0] = Math.max(0, getContentInsetLeft() - i10);
        arrayOfInt[1] = Math.max(0, getContentInsetRight() - (i2 - i5 - i8));
        i11 = Math.max(i10, getContentInsetLeft());
        i12 = Math.min(i8, i2 - i5 - getContentInsetRight());
        if (b(this.a))
        {
          if (i1 == 0) {
            break label938;
          }
          i12 = b(this.a, i12, arrayOfInt, i9);
        }
        if (!b(this.f)) {
          break label1601;
        }
        if (i1 == 0) {
          break label957;
        }
        i13 = b(this.f, i12, arrayOfInt, i9);
        i14 = i11;
      }
      for (;;)
      {
        label308:
        boolean bool1 = b(this.c);
        boolean bool2 = b(this.d);
        int i15 = 0;
        if (bool1)
        {
          Toolbar.LayoutParams localLayoutParams8 = (Toolbar.LayoutParams)this.c.getLayoutParams();
          i15 = 0 + (localLayoutParams8.topMargin + this.c.getMeasuredHeight() + localLayoutParams8.bottomMargin);
        }
        Toolbar.LayoutParams localLayoutParams7;
        if (bool2) {
          localLayoutParams7 = (Toolbar.LayoutParams)this.d.getLayoutParams();
        }
        for (int i16 = i15 + (localLayoutParams7.topMargin + this.d.getMeasuredHeight() + localLayoutParams7.bottomMargin);; i16 = i15)
        {
          TextView localTextView1;
          label433:
          TextView localTextView2;
          label444:
          Toolbar.LayoutParams localLayoutParams1;
          Toolbar.LayoutParams localLayoutParams2;
          int i17;
          label497:
          int i56;
          int i58;
          if ((bool1) || (bool2))
          {
            if (!bool1) {
              break label984;
            }
            localTextView1 = this.c;
            if (!bool2) {
              break label993;
            }
            localTextView2 = this.d;
            localLayoutParams1 = (Toolbar.LayoutParams)localTextView1.getLayoutParams();
            localLayoutParams2 = (Toolbar.LayoutParams)localTextView2.getLayoutParams();
            if (((!bool1) || (this.c.getMeasuredWidth() <= 0)) && ((!bool2) || (this.d.getMeasuredWidth() <= 0))) {
              break label1002;
            }
            i17 = 1;
            switch (0x70 & this.u)
            {
            default: 
              i56 = (i3 - i6 - i7 - i16) / 2;
              if (i56 < localLayoutParams1.topMargin + this.r) {
                i58 = localLayoutParams1.topMargin + this.r;
              }
              break;
            }
          }
          for (;;)
          {
            label574:
            int i18 = i6 + i58;
            label581:
            int i43;
            label597:
            int i45;
            int i55;
            if (i1 != 0) {
              if (i17 != 0)
              {
                i43 = this.p;
                int i44 = i43 - arrayOfInt[1];
                i45 = i13 - Math.max(0, i44);
                arrayOfInt[1] = Math.max(0, -i44);
                if (!bool1) {
                  break label1580;
                }
                Toolbar.LayoutParams localLayoutParams6 = (Toolbar.LayoutParams)this.c.getLayoutParams();
                int i53 = i45 - this.c.getMeasuredWidth();
                int i54 = i18 + this.c.getMeasuredHeight();
                this.c.layout(i53, i18, i45, i54);
                i55 = i53 - this.q;
                i18 = i54 + localLayoutParams6.bottomMargin;
              }
            }
            label919:
            label938:
            label1580:
            for (int i46 = i55;; i46 = i45)
            {
              int i52;
              if (bool2)
              {
                Toolbar.LayoutParams localLayoutParams5 = (Toolbar.LayoutParams)this.d.getLayoutParams();
                int i49 = i18 + localLayoutParams5.topMargin;
                int i50 = i45 - this.d.getMeasuredWidth();
                int i51 = i49 + this.d.getMeasuredHeight();
                this.d.layout(i50, i49, i45, i51);
                i52 = i45 - this.q;
                (i51 + localLayoutParams5.bottomMargin);
              }
              for (int i47 = i52;; i47 = i45)
              {
                if (i17 != 0) {}
                for (int i48 = Math.min(i46, i47);; i48 = i45)
                {
                  i13 = i48;
                  a(this.A, 3);
                  int i24 = this.A.size();
                  int i25 = 0;
                  int i26 = i14;
                  label881:
                  int i19;
                  label957:
                  label984:
                  label993:
                  label1002:
                  int i42;
                  label1125:
                  int i21;
                  for (;;)
                  {
                    if (i25 < i24)
                    {
                      i26 = a((View)this.A.get(i25), i26, arrayOfInt, i9);
                      i25++;
                      continue;
                      i1 = 0;
                      break;
                      i10 = a(this.e, i4, arrayOfInt, i9);
                      break label112;
                      i10 = a(this.i, i10, arrayOfInt, i9);
                      break label144;
                      i8 = b(this.b, i8, arrayOfInt, i9);
                      break label176;
                      i11 = a(this.a, i11, arrayOfInt, i9);
                      break label272;
                      int i59 = a(this.f, i11, arrayOfInt, i9);
                      i13 = i12;
                      i14 = i59;
                      break label308;
                      localTextView1 = this.d;
                      break label433;
                      localTextView2 = this.c;
                      break label444;
                      i17 = 0;
                      break label497;
                      i18 = getPaddingTop() + localLayoutParams1.topMargin + this.r;
                      break label581;
                      int i57 = i3 - i7 - i16 - i56 - i6;
                      if (i57 >= localLayoutParams1.bottomMargin + this.s) {
                        break label1587;
                      }
                      i58 = Math.max(0, i56 - (localLayoutParams2.bottomMargin + this.s - i57));
                      break label574;
                      i18 = i3 - i7 - localLayoutParams2.bottomMargin - this.s - i16;
                      break label581;
                      i43 = 0;
                      break label597;
                      if (i17 != 0)
                      {
                        i19 = this.p;
                        int i20 = i19 - arrayOfInt[0];
                        i14 += Math.max(0, i20);
                        arrayOfInt[0] = Math.max(0, -i20);
                        if (!bool1) {
                          break label1555;
                        }
                        Toolbar.LayoutParams localLayoutParams4 = (Toolbar.LayoutParams)this.c.getLayoutParams();
                        int i39 = i14 + this.c.getMeasuredWidth();
                        int i40 = i18 + this.c.getMeasuredHeight();
                        this.c.layout(i14, i18, i39, i40);
                        int i41 = i39 + this.q;
                        i42 = i40 + localLayoutParams4.bottomMargin;
                        i21 = i41;
                      }
                    }
                  }
                  for (int i22 = i42;; i22 = i18)
                  {
                    int i38;
                    if (bool2)
                    {
                      Toolbar.LayoutParams localLayoutParams3 = (Toolbar.LayoutParams)this.d.getLayoutParams();
                      int i35 = i22 + localLayoutParams3.topMargin;
                      int i36 = i14 + this.d.getMeasuredWidth();
                      int i37 = i35 + this.d.getMeasuredHeight();
                      this.d.layout(i14, i35, i36, i37);
                      i38 = i36 + this.q;
                      (i37 + localLayoutParams3.bottomMargin);
                    }
                    for (int i23 = i38;; i23 = i14)
                    {
                      if (i17 == 0) {
                        break label1553;
                      }
                      i14 = Math.max(i21, i23);
                      break;
                      i19 = 0;
                      break label1125;
                      a(this.A, 5);
                      int i27 = this.A.size();
                      for (int i28 = 0; i28 < i27; i28++) {
                        i13 = b((View)this.A.get(i28), i13, arrayOfInt, i9);
                      }
                      a(this.A, 1);
                      int i29 = a(this.A, arrayOfInt);
                      int i30 = i4 + (i2 - i4 - i5) / 2 - i29 / 2;
                      int i31 = i29 + i30;
                      if (i30 < i26) {
                        i30 = i26;
                      }
                      for (;;)
                      {
                        int i32 = this.A.size();
                        int i33 = 0;
                        int i34 = i30;
                        while (i33 < i32)
                        {
                          i34 = a((View)this.A.get(i33), i34, arrayOfInt, i9);
                          i33++;
                        }
                        if (i31 > i13) {
                          i30 -= i31 - i13;
                        }
                      }
                      this.A.clear();
                      return;
                    }
                    break;
                    i21 = i14;
                  }
                }
              }
            }
            label1553:
            label1555:
            label1587:
            i58 = i56;
          }
        }
        label1601:
        i13 = i12;
        i14 = i11;
      }
      label1612:
      i10 = i4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.B;
    int i1;
    int i2;
    int i10;
    int i12;
    int i13;
    int i14;
    label499:
    View localView;
    int i25;
    int i26;
    if (ViewUtils.a(this))
    {
      i1 = 0;
      i2 = 1;
      boolean bool1 = b(this.e);
      int i3 = 0;
      int i4 = 0;
      int i5 = 0;
      if (bool1)
      {
        a(this.e, paramInt1, 0, paramInt2, 0, this.o);
        i3 = this.e.getMeasuredWidth() + c(this.e);
        int i28 = Math.max(0, this.e.getMeasuredHeight() + d(this.e));
        i4 = ViewUtils.a(0, ViewCompat.getMeasuredState(this.e));
        i5 = i28;
      }
      if (b(this.i))
      {
        a(this.i, paramInt1, 0, paramInt2, 0, this.o);
        i3 = this.i.getMeasuredWidth() + c(this.i);
        i5 = Math.max(i5, this.i.getMeasuredHeight() + d(this.i));
        i4 = ViewUtils.a(i4, ViewCompat.getMeasuredState(this.i));
      }
      int i6 = getContentInsetStart();
      int i7 = 0 + Math.max(i6, i3);
      arrayOfInt[i2] = Math.max(0, i6 - i3);
      boolean bool2 = b(this.b);
      int i8 = 0;
      if (bool2)
      {
        a(this.b, paramInt1, i7, paramInt2, 0, this.o);
        i8 = this.b.getMeasuredWidth() + c(this.b);
        i5 = Math.max(i5, this.b.getMeasuredHeight() + d(this.b));
        i4 = ViewUtils.a(i4, ViewCompat.getMeasuredState(this.b));
      }
      int i9 = getContentInsetEnd();
      i10 = i7 + Math.max(i9, i8);
      arrayOfInt[i1] = Math.max(0, i9 - i8);
      if (b(this.a))
      {
        i10 += a(this.a, paramInt1, i10, paramInt2, 0, arrayOfInt);
        i5 = Math.max(i5, this.a.getMeasuredHeight() + d(this.a));
        i4 = ViewUtils.a(i4, ViewCompat.getMeasuredState(this.a));
      }
      if (b(this.f))
      {
        i10 += a(this.f, paramInt1, i10, paramInt2, 0, arrayOfInt);
        i5 = Math.max(i5, this.f.getMeasuredHeight() + d(this.f));
        i4 = ViewUtils.a(i4, ViewCompat.getMeasuredState(this.f));
      }
      int i11 = getChildCount();
      i12 = 0;
      i13 = i5;
      i14 = i4;
      if (i12 >= i11) {
        break label623;
      }
      localView = getChildAt(i12);
      if (((Toolbar.LayoutParams)localView.getLayoutParams()).b != 0) {
        break label913;
      }
      if (b(localView)) {
        break label568;
      }
      i25 = i14;
      i26 = i13;
    }
    for (;;)
    {
      i12++;
      i14 = i25;
      i13 = i26;
      break label499;
      i1 = 1;
      i2 = 0;
      break;
      label568:
      i10 += a(localView, paramInt1, i10, paramInt2, 0, arrayOfInt);
      int i27 = Math.max(i13, localView.getMeasuredHeight() + d(localView));
      i25 = ViewUtils.a(i14, ViewCompat.getMeasuredState(localView));
      i26 = i27;
      continue;
      label623:
      int i15 = this.r + this.s;
      int i16 = this.p + this.q;
      boolean bool3 = b(this.c);
      int i17 = 0;
      int i18 = 0;
      if (bool3)
      {
        a(this.c, paramInt1, i10 + i16, paramInt2, i15, arrayOfInt);
        i18 = this.c.getMeasuredWidth() + c(this.c);
        i17 = this.c.getMeasuredHeight() + d(this.c);
        i14 = ViewUtils.a(i14, ViewCompat.getMeasuredState(this.c));
      }
      if (b(this.d))
      {
        i18 = Math.max(i18, a(this.d, paramInt1, i10 + i16, paramInt2, i15 + i17, arrayOfInt));
        i17 += this.d.getMeasuredHeight() + d(this.d);
        i14 = ViewUtils.a(i14, ViewCompat.getMeasuredState(this.d));
      }
      int i19 = i18 + i10;
      int i20 = Math.max(i13, i17);
      int i21 = i19 + (getPaddingLeft() + getPaddingRight());
      int i22 = i20 + (getPaddingTop() + getPaddingBottom());
      int i23 = ViewCompat.resolveSizeAndState(Math.max(i21, getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i14);
      int i24 = ViewCompat.resolveSizeAndState(Math.max(i22, getSuggestedMinimumHeight()), paramInt2, i14 << 16);
      if (p()) {
        i24 = 0;
      }
      setMeasuredDimension(i23, i24);
      return;
      label913:
      i25 = i14;
      i26 = i13;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Toolbar.SavedState localSavedState = (Toolbar.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.b != null) {}
    for (MenuBuilder localMenuBuilder = this.b.d();; localMenuBuilder = null)
    {
      if ((localSavedState.a != 0) && (this.G != null) && (localMenuBuilder != null))
      {
        MenuItem localMenuItem = localMenuBuilder.findItem(localSavedState.a);
        if (localMenuItem != null) {
          MenuItemCompat.expandActionView(localMenuItem);
        }
      }
      if (localSavedState.b) {
        o();
      }
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    int i1 = 1;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    RtlSpacingHelper localRtlSpacingHelper = this.t;
    if (paramInt == i1) {}
    for (;;)
    {
      localRtlSpacingHelper.a(i1);
      return;
      i1 = 0;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Toolbar.SavedState localSavedState = new Toolbar.SavedState(super.onSaveInstanceState());
    if ((this.G != null) && (this.G.b != null)) {
      localSavedState.a = this.G.b.getItemId();
    }
    localSavedState.b = b();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i1 == 0) {
      this.z = false;
    }
    if (!this.z)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (!bool)) {
        this.z = true;
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.z = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.J = paramBoolean;
    requestLayout();
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(this.M.a(paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      j();
      if (this.f.getParent() == null)
      {
        a(this.f);
        e(this.f);
      }
    }
    for (;;)
    {
      if (this.f != null) {
        this.f.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.f != null) && (this.f.getParent() != null)) {
        removeView(this.f);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      j();
    }
    if (this.f != null) {
      this.f.setContentDescription(paramCharSequence);
    }
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.K = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      m();
    }
    if (this.e != null) {
      this.e.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(this.M.a(paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      m();
      if (this.e.getParent() == null)
      {
        a(this.e);
        e(this.e);
      }
    }
    for (;;)
    {
      if (this.e != null) {
        this.e.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.e != null) && (this.e.getParent() != null)) {
        removeView(this.e);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    m();
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.C = paramOnMenuItemClickListener;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      if (paramInt == 0) {
        this.j = getContext();
      }
    }
    else
    {
      return;
    }
    this.j = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.d == null)
      {
        Context localContext = getContext();
        this.d = new TextView(localContext);
        this.d.setSingleLine();
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        if (this.m != 0) {
          this.d.setTextAppearance(localContext, this.m);
        }
        if (this.y != 0) {
          this.d.setTextColor(this.y);
        }
      }
      if (this.d.getParent() == null)
      {
        a(this.d);
        e(this.d);
      }
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.setText(paramCharSequence);
      }
      this.w = paramCharSequence;
      return;
      if ((this.d != null) && (this.d.getParent() != null)) {
        removeView(this.d);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.y = paramInt;
    if (this.d != null) {
      this.d.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.c == null)
      {
        Context localContext = getContext();
        this.c = new TextView(localContext);
        this.c.setSingleLine();
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        if (this.l != 0) {
          this.c.setTextAppearance(localContext, this.l);
        }
        if (this.x != 0) {
          this.c.setTextColor(this.x);
        }
      }
      if (this.c.getParent() == null)
      {
        a(this.c);
        e(this.c);
      }
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.setText(paramCharSequence);
      }
      this.v = paramCharSequence;
      return;
      if ((this.c != null) && (this.c.getParent() != null)) {
        removeView(this.c);
      }
    }
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.x = paramInt;
    if (this.c != null) {
      this.c.setTextColor(paramInt);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.Toolbar
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */