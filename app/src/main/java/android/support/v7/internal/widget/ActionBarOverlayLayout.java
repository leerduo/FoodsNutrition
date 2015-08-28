package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.internal.VersionUtils;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements DecorContentParent
{
  static final int[] a = arrayOfInt;
  private final ViewPropertyAnimatorListener A = new ActionBarOverlayLayout.1(this);
  private final ViewPropertyAnimatorListener B = new ActionBarOverlayLayout.2(this);
  private final Runnable C = new ActionBarOverlayLayout.3(this);
  private final Runnable D = new ActionBarOverlayLayout.4(this);
  private int b;
  private int c = 0;
  private ContentFrameLayout d;
  private ActionBarContainer e;
  private ActionBarContainer f;
  private DecorToolbar g;
  private Drawable h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private final Rect p = new Rect();
  private final Rect q = new Rect();
  private final Rect r = new Rect();
  private final Rect s = new Rect();
  private final Rect t = new Rect();
  private final Rect u = new Rect();
  private ActionBarOverlayLayout.ActionBarVisibilityCallback v;
  private final int w = 600;
  private ScrollerCompat x;
  private ViewPropertyAnimatorCompat y;
  private ViewPropertyAnimatorCompat z;
  
  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = R.attr.actionBarSize;
    arrayOfInt[1] = 16842841;
  }
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private DecorToolbar a(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private void a(Context paramContext)
  {
    int i1 = 1;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(a);
    this.b = localTypedArray.getDimensionPixelSize(0, 0);
    this.h = localTypedArray.getDrawable(i1);
    if (this.h == null)
    {
      int i2 = i1;
      setWillNotDraw(i2);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion >= 19) {
        break label87;
      }
    }
    for (;;)
    {
      this.i = i1;
      this.x = ScrollerCompat.create(paramContext);
      return;
      int i3 = 0;
      break;
      label87:
      i1 = 0;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.x.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    int i1 = this.x.getFinalY();
    int i2 = this.f.getHeight();
    boolean bool = false;
    if (i1 > i2) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ActionBarOverlayLayout.LayoutParams localLayoutParams = (ActionBarOverlayLayout.LayoutParams)paramView.getLayoutParams();
    boolean bool = false;
    if (paramBoolean1)
    {
      int i1 = localLayoutParams.leftMargin;
      int i2 = paramRect.left;
      bool = false;
      if (i1 != i2)
      {
        localLayoutParams.leftMargin = paramRect.left;
        bool = true;
      }
    }
    if ((paramBoolean2) && (localLayoutParams.topMargin != paramRect.top))
    {
      localLayoutParams.topMargin = paramRect.top;
      bool = true;
    }
    if ((paramBoolean4) && (localLayoutParams.rightMargin != paramRect.right))
    {
      localLayoutParams.rightMargin = paramRect.right;
      bool = true;
    }
    if ((paramBoolean3) && (localLayoutParams.bottomMargin != paramRect.bottom))
    {
      localLayoutParams.bottomMargin = paramRect.bottom;
      return true;
    }
    return bool;
  }
  
  private void k()
  {
    removeCallbacks(this.C);
    removeCallbacks(this.D);
    if (this.y != null) {
      this.y.cancel();
    }
    if (this.z != null) {
      this.z.cancel();
    }
  }
  
  private void l()
  {
    k();
    postDelayed(this.C, 600L);
  }
  
  private void m()
  {
    k();
    postDelayed(this.D, 600L);
  }
  
  private void n()
  {
    k();
    this.C.run();
  }
  
  private void o()
  {
    k();
    this.D.run();
  }
  
  public ActionBarOverlayLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new ActionBarOverlayLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    c();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.g.g();
      return;
    case 5: 
      this.g.h();
      return;
    }
    setOverlayMode(true);
  }
  
  public void a(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    c();
    this.g.a(paramMenu, paramCallback);
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  protected ActionBarOverlayLayout.LayoutParams b()
  {
    return new ActionBarOverlayLayout.LayoutParams(-1, -1);
  }
  
  void c()
  {
    if (this.d == null)
    {
      this.d = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      this.f = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.g = a(findViewById(R.id.action_bar));
      this.e = ((ActionBarContainer)findViewById(R.id.split_action_bar));
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ActionBarOverlayLayout.LayoutParams;
  }
  
  public boolean d()
  {
    c();
    return this.g.i();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.h != null) && (!this.i)) {
      if (this.f.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i1 = (int)(0.5F + (this.f.getBottom() + ViewCompat.getTranslationY(this.f)));; i1 = 0)
    {
      this.h.setBounds(0, i1, getWidth(), i1 + this.h.getIntrinsicHeight());
      this.h.draw(paramCanvas);
      return;
    }
  }
  
  public boolean e()
  {
    c();
    return this.g.j();
  }
  
  public boolean f()
  {
    c();
    return this.g.k();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    c();
    if ((0x100 & ViewCompat.getWindowSystemUiVisibility(this)) != 0) {}
    boolean bool = a(this.f, paramRect, true, true, false, true);
    if (this.e != null) {
      bool |= a(this.e, paramRect, true, false, true, true);
    }
    this.s.set(paramRect);
    ViewUtils.a(this, this.s, this.p);
    if (!this.q.equals(this.p))
    {
      this.q.set(this.p);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public boolean g()
  {
    c();
    return this.g.l();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ActionBarOverlayLayout.LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (this.f != null) {
      return -(int)ViewCompat.getTranslationY(this.f);
    }
    return 0;
  }
  
  public CharSequence getTitle()
  {
    c();
    return this.g.f();
  }
  
  public boolean h()
  {
    c();
    return this.g.m();
  }
  
  public void i()
  {
    c();
    this.g.n();
  }
  
  public void j()
  {
    c();
    this.g.o();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    a(getContext());
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    k();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = getPaddingLeft();
    (paramInt3 - paramInt1 - getPaddingRight());
    int i3 = getPaddingTop();
    int i4 = paramInt4 - paramInt2 - getPaddingBottom();
    int i5 = 0;
    if (i5 < i1)
    {
      View localView = getChildAt(i5);
      ActionBarOverlayLayout.LayoutParams localLayoutParams;
      int i6;
      int i7;
      int i8;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ActionBarOverlayLayout.LayoutParams)localView.getLayoutParams();
        i6 = localView.getMeasuredWidth();
        i7 = localView.getMeasuredHeight();
        i8 = i2 + localLayoutParams.leftMargin;
        if (localView != this.e) {
          break label148;
        }
      }
      label148:
      for (int i9 = i4 - i7 - localLayoutParams.bottomMargin;; i9 = i3 + localLayoutParams.topMargin)
      {
        localView.layout(i8, i9, i6 + i8, i7 + i9);
        i5++;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    c();
    measureChildWithMargins(this.f, paramInt1, 0, paramInt2, 0);
    ActionBarOverlayLayout.LayoutParams localLayoutParams1 = (ActionBarOverlayLayout.LayoutParams)this.f.getLayoutParams();
    int i1 = Math.max(0, this.f.getMeasuredWidth() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin);
    int i2 = Math.max(0, this.f.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin);
    int i3 = ViewUtils.a(0, ViewCompat.getMeasuredState(this.f));
    int i6;
    int i5;
    int i4;
    if (this.e != null)
    {
      measureChildWithMargins(this.e, paramInt1, 0, paramInt2, 0);
      ActionBarOverlayLayout.LayoutParams localLayoutParams3 = (ActionBarOverlayLayout.LayoutParams)this.e.getLayoutParams();
      int i15 = Math.max(i1, this.e.getMeasuredWidth() + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin);
      int i16 = Math.max(i2, this.e.getMeasuredHeight() + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin);
      i6 = ViewUtils.a(i3, ViewCompat.getMeasuredState(this.e));
      i5 = i15;
      i4 = i16;
    }
    for (;;)
    {
      int i7;
      int i8;
      if ((0x100 & ViewCompat.getWindowSystemUiVisibility(this)) != 0)
      {
        i7 = 1;
        if (i7 == 0) {
          break label559;
        }
        i8 = this.b;
        if ((this.k) && (this.f.getTabContainer() != null)) {
          i8 += this.b;
        }
      }
      for (;;)
      {
        label242:
        int i9;
        if ((this.g.c()) && (this.e != null)) {
          if (i7 != 0) {
            i9 = this.b;
          }
        }
        for (;;)
        {
          label272:
          this.r.set(this.p);
          this.t.set(this.s);
          Rect localRect4;
          if ((!this.j) && (i7 == 0))
          {
            Rect localRect3 = this.r;
            localRect3.top = (i8 + localRect3.top);
            localRect4 = this.r;
          }
          label559:
          Rect localRect2;
          for (localRect4.bottom = (i9 + localRect4.bottom);; localRect2.bottom = (i9 + localRect2.bottom))
          {
            a(this.d, this.r, true, true, true, true);
            if (!this.u.equals(this.t))
            {
              this.u.set(this.t);
              this.d.a(this.t);
            }
            measureChildWithMargins(this.d, paramInt1, 0, paramInt2, 0);
            ActionBarOverlayLayout.LayoutParams localLayoutParams2 = (ActionBarOverlayLayout.LayoutParams)this.d.getLayoutParams();
            int i10 = Math.max(i5, this.d.getMeasuredWidth() + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin);
            int i11 = Math.max(i4, this.d.getMeasuredHeight() + localLayoutParams2.topMargin + localLayoutParams2.bottomMargin);
            int i12 = ViewUtils.a(i6, ViewCompat.getMeasuredState(this.d));
            int i13 = i10 + (getPaddingLeft() + getPaddingRight());
            int i14 = Math.max(i11 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
            setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i13, getSuggestedMinimumWidth()), paramInt1, i12), ViewCompat.resolveSizeAndState(i14, paramInt2, i12 << 16));
            return;
            i7 = 0;
            break;
            if (this.f.getVisibility() == 8) {
              break label642;
            }
            i8 = this.f.getMeasuredHeight();
            break label242;
            i9 = this.e.getMeasuredHeight();
            break label272;
            Rect localRect1 = this.t;
            localRect1.top = (i8 + localRect1.top);
            localRect2 = this.t;
          }
          i9 = 0;
        }
        label642:
        i8 = 0;
      }
      i4 = i2;
      i5 = i1;
      i6 = i3;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((!this.l) || (!paramBoolean)) {
      return false;
    }
    if (a(paramFloat1, paramFloat2)) {
      o();
    }
    for (;;)
    {
      this.m = true;
      return true;
      n();
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.n = (paramInt2 + this.n);
    setActionBarHideOffset(this.n);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.n = getActionBarHideOffset();
    k();
    if (this.v != null) {
      this.v.i();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.f.getVisibility() != 0)) {
      return false;
    }
    return this.l;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    super.onStopNestedScroll(paramView);
    if ((this.l) && (!this.m))
    {
      if (this.n > this.f.getHeight()) {
        break label54;
      }
      l();
    }
    for (;;)
    {
      if (this.v != null) {
        this.v.j();
      }
      return;
      label54:
      m();
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool1 = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    c();
    int i1 = paramInt ^ this.o;
    this.o = paramInt;
    boolean bool2;
    boolean bool3;
    if ((paramInt & 0x4) == 0)
    {
      bool2 = bool1;
      if ((paramInt & 0x100) == 0) {
        break label122;
      }
      bool3 = bool1;
      label51:
      if (this.v != null)
      {
        ActionBarOverlayLayout.ActionBarVisibilityCallback localActionBarVisibilityCallback = this.v;
        if (bool3) {
          break label128;
        }
        label69:
        localActionBarVisibilityCallback.g(bool1);
        if ((!bool2) && (bool3)) {
          break label133;
        }
        this.v.g();
      }
    }
    for (;;)
    {
      if (((i1 & 0x100) != 0) && (this.v != null)) {
        ViewCompat.requestApplyInsets(this);
      }
      return;
      bool2 = false;
      break;
      label122:
      bool3 = false;
      break label51;
      label128:
      bool1 = false;
      break label69;
      label133:
      this.v.h();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.c = paramInt;
    if (this.v != null) {
      this.v.b(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    k();
    int i1 = this.f.getHeight();
    int i2 = Math.max(0, Math.min(paramInt, i1));
    ViewCompat.setTranslationY(this.f, -i2);
    if ((this.e != null) && (this.e.getVisibility() != 8))
    {
      int i3 = (int)(i2 / i1 * this.e.getHeight());
      ViewCompat.setTranslationY(this.e, i3);
    }
  }
  
  public void setActionBarVisibilityCallback(ActionBarOverlayLayout.ActionBarVisibilityCallback paramActionBarVisibilityCallback)
  {
    this.v = paramActionBarVisibilityCallback;
    if (getWindowToken() != null)
    {
      this.v.b(this.c);
      if (this.o != 0)
      {
        onWindowSystemUiVisibilityChanged(this.o);
        ViewCompat.requestApplyInsets(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.l)
    {
      this.l = paramBoolean;
      if (!paramBoolean)
      {
        if (VersionUtils.a()) {
          stopNestedScroll();
        }
        k();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    c();
    this.g.a(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    c();
    this.g.a(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    c();
    this.g.b(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (boolean bool = true;; bool = false)
    {
      this.i = bool;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(WindowCallback paramWindowCallback)
  {
    c();
    this.g.a(paramWindowCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    c();
    this.g.a(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */