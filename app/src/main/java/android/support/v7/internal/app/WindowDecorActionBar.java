package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

public class WindowDecorActionBar
  extends ActionBar
  implements ActionBarOverlayLayout.ActionBarVisibilityCallback
{
  private static final boolean i;
  private int A = 0;
  private boolean B = true;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F = true;
  private ViewPropertyAnimatorCompatSet G;
  private boolean H;
  WindowDecorActionBar.ActionModeImpl a;
  ActionMode b;
  ActionMode.Callback c;
  boolean d;
  final ViewPropertyAnimatorListener e = new WindowDecorActionBar.1(this);
  final ViewPropertyAnimatorListener f = new WindowDecorActionBar.2(this);
  final ViewPropertyAnimatorUpdateListener g = new WindowDecorActionBar.3(this);
  private Context j;
  private Context k;
  private FragmentActivity l;
  private ActionBarOverlayLayout m;
  private ActionBarContainer n;
  private DecorToolbar o;
  private ActionBarContextView p;
  private ActionBarContainer q;
  private View r;
  private ScrollingTabContainerView s;
  private ArrayList<Object> t = new ArrayList();
  private int u = -1;
  private boolean v;
  private boolean w;
  private ArrayList<ActionBar.OnMenuVisibilityListener> x = new ArrayList();
  private int y;
  private boolean z;
  
  static
  {
    boolean bool1 = true;
    boolean bool2;
    if (!WindowDecorActionBar.class.desiredAssertionStatus())
    {
      bool2 = bool1;
      h = bool2;
      if (Build.VERSION.SDK_INT < 14) {
        break label34;
      }
    }
    for (;;)
    {
      i = bool1;
      return;
      bool2 = false;
      break;
      label34:
      bool1 = false;
    }
  }
  
  public WindowDecorActionBar(ActionBarActivity paramActionBarActivity, boolean paramBoolean)
  {
    this.l = paramActionBarActivity;
    View localView = paramActionBarActivity.getWindow().getDecorView();
    a(localView);
    if (!paramBoolean) {
      this.r = localView.findViewById(16908290);
    }
  }
  
  private void a(View paramView)
  {
    this.m = ((ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent));
    if (this.m != null) {
      this.m.setActionBarVisibilityCallback(this);
    }
    this.o = b(paramView.findViewById(R.id.action_bar));
    this.p = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
    this.n = ((ActionBarContainer)paramView.findViewById(R.id.action_bar_container));
    this.q = ((ActionBarContainer)paramView.findViewById(R.id.split_action_bar));
    if ((this.o == null) || (this.p == null) || (this.n == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }
    this.j = this.o.b();
    int i1;
    int i2;
    label193:
    ActionBarPolicy localActionBarPolicy;
    if (this.o.c())
    {
      i1 = 1;
      this.y = i1;
      if ((0x4 & this.o.p()) == 0) {
        break label309;
      }
      i2 = 1;
      if (i2 != 0) {
        this.v = true;
      }
      localActionBarPolicy = ActionBarPolicy.a(this.j);
      if ((!localActionBarPolicy.f()) && (i2 == 0)) {
        break label314;
      }
    }
    label309:
    label314:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      k(localActionBarPolicy.d());
      TypedArray localTypedArray = this.j.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (localTypedArray.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
        b(true);
      }
      int i3 = localTypedArray.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (i3 != 0) {
        a(i3);
      }
      localTypedArray.recycle();
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label193;
    }
  }
  
  private DecorToolbar b(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void k()
  {
    if (!this.E)
    {
      this.E = true;
      if (this.m != null) {
        this.m.setShowingForActionMode(true);
      }
      l(false);
    }
  }
  
  private void k(boolean paramBoolean)
  {
    boolean bool1 = true;
    this.z = paramBoolean;
    boolean bool2;
    label45:
    label78:
    boolean bool3;
    label98:
    ActionBarOverlayLayout localActionBarOverlayLayout;
    if (!this.z)
    {
      this.o.a(null);
      this.n.setTabContainer(this.s);
      if (f() != 2) {
        break label155;
      }
      bool2 = bool1;
      if (this.s != null)
      {
        if (!bool2) {
          break label160;
        }
        this.s.setVisibility(0);
        if (this.m != null) {
          ViewCompat.requestApplyInsets(this.m);
        }
      }
      DecorToolbar localDecorToolbar = this.o;
      if ((this.z) || (!bool2)) {
        break label172;
      }
      bool3 = bool1;
      localDecorToolbar.a(bool3);
      localActionBarOverlayLayout = this.m;
      if ((this.z) || (!bool2)) {
        break label178;
      }
    }
    for (;;)
    {
      localActionBarOverlayLayout.setHasNonEmbeddedTabs(bool1);
      return;
      this.n.setTabContainer(null);
      this.o.a(this.s);
      break;
      label155:
      bool2 = false;
      break label45;
      label160:
      this.s.setVisibility(8);
      break label78;
      label172:
      bool3 = false;
      break label98;
      label178:
      bool1 = false;
    }
  }
  
  private void l()
  {
    if (this.E)
    {
      this.E = false;
      if (this.m != null) {
        this.m.setShowingForActionMode(false);
      }
      l(false);
    }
  }
  
  private void l(boolean paramBoolean)
  {
    if (b(this.C, this.D, this.E)) {
      if (!this.F)
      {
        this.F = true;
        h(paramBoolean);
      }
    }
    while (!this.F) {
      return;
    }
    this.F = false;
    i(paramBoolean);
  }
  
  public int a()
  {
    return this.o.p();
  }
  
  public ActionMode a(ActionMode.Callback paramCallback)
  {
    if (this.a != null) {
      this.a.c();
    }
    this.m.setHideOnContentScrollEnabled(false);
    this.p.c();
    WindowDecorActionBar.ActionModeImpl localActionModeImpl = new WindowDecorActionBar.ActionModeImpl(this, paramCallback);
    if (localActionModeImpl.e())
    {
      localActionModeImpl.d();
      this.p.a(localActionModeImpl);
      j(true);
      if ((this.q != null) && (this.y == 1) && (this.q.getVisibility() != 0))
      {
        this.q.setVisibility(0);
        if (this.m != null) {
          ViewCompat.requestApplyInsets(this.m);
        }
      }
      this.p.sendAccessibilityEvent(32);
      this.a = localActionModeImpl;
      return localActionModeImpl;
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    ViewCompat.setElevation(this.n, paramFloat);
    if (this.q != null) {
      ViewCompat.setElevation(this.q, paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.o.e(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.o.p();
    if ((paramInt2 & 0x4) != 0) {
      this.v = true;
    }
    this.o.c(paramInt1 & paramInt2 | i1 & (paramInt2 ^ 0xFFFFFFFF));
  }
  
  public void a(Configuration paramConfiguration)
  {
    k(ActionBarPolicy.a(this.j).d());
  }
  
  public void a(Drawable paramDrawable)
  {
    this.o.b(paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.o.a(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    this.o.b(paramBoolean);
  }
  
  public Context b()
  {
    int i1;
    if (this.k == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.j.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (this.k = new ContextThemeWrapper(this.j, i1);; this.k = this.j) {
      return this.k;
    }
  }
  
  public void b(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.m.a())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.d = paramBoolean;
    this.m.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.v) {
      f(paramBoolean);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.H = paramBoolean;
    if ((!paramBoolean) && (this.G != null)) {
      this.G.b();
    }
  }
  
  public boolean d()
  {
    if ((this.o != null) && (this.o.d()))
    {
      this.o.e();
      return true;
    }
    return false;
  }
  
  void e()
  {
    if (this.c != null)
    {
      this.c.a(this.b);
      this.b = null;
      this.c = null;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean == this.w) {}
    for (;;)
    {
      return;
      this.w = paramBoolean;
      int i1 = this.x.size();
      for (int i2 = 0; i2 < i1; i2++) {
        ((ActionBar.OnMenuVisibilityListener)this.x.get(i2)).a(paramBoolean);
      }
    }
  }
  
  public int f()
  {
    return this.o.q();
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      a(i1, 4);
      return;
    }
  }
  
  public void g()
  {
    if (this.D)
    {
      this.D = false;
      l(true);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void h()
  {
    if (!this.D)
    {
      this.D = true;
      l(true);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.G != null) {
      this.G.b();
    }
    this.n.setVisibility(0);
    if ((this.A == 0) && (i) && ((this.H) || (paramBoolean)))
    {
      ViewCompat.setTranslationY(this.n, 0.0F);
      float f1 = -this.n.getHeight();
      if (paramBoolean)
      {
        int[] arrayOfInt = { 0, 0 };
        this.n.getLocationInWindow(arrayOfInt);
        f1 -= arrayOfInt[1];
      }
      ViewCompat.setTranslationY(this.n, f1);
      ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.n).translationY(0.0F);
      localViewPropertyAnimatorCompat.setUpdateListener(this.g);
      localViewPropertyAnimatorCompatSet.a(localViewPropertyAnimatorCompat);
      if ((this.B) && (this.r != null))
      {
        ViewCompat.setTranslationY(this.r, f1);
        localViewPropertyAnimatorCompatSet.a(ViewCompat.animate(this.r).translationY(0.0F));
      }
      if ((this.q != null) && (this.y == 1))
      {
        ViewCompat.setTranslationY(this.q, this.q.getHeight());
        this.q.setVisibility(0);
        localViewPropertyAnimatorCompatSet.a(ViewCompat.animate(this.q).translationY(0.0F));
      }
      localViewPropertyAnimatorCompatSet.a(AnimationUtils.loadInterpolator(this.j, 17432582));
      localViewPropertyAnimatorCompatSet.a(250L);
      localViewPropertyAnimatorCompatSet.a(this.f);
      this.G = localViewPropertyAnimatorCompatSet;
      localViewPropertyAnimatorCompatSet.a();
    }
    for (;;)
    {
      if (this.m != null) {
        ViewCompat.requestApplyInsets(this.m);
      }
      return;
      ViewCompat.setAlpha(this.n, 1.0F);
      ViewCompat.setTranslationY(this.n, 0.0F);
      if ((this.B) && (this.r != null)) {
        ViewCompat.setTranslationY(this.r, 0.0F);
      }
      if ((this.q != null) && (this.y == 1))
      {
        ViewCompat.setAlpha(this.q, 1.0F);
        ViewCompat.setTranslationY(this.q, 0.0F);
        this.q.setVisibility(0);
      }
      this.f.onAnimationEnd(null);
    }
  }
  
  public void i()
  {
    if (this.G != null)
    {
      this.G.b();
      this.G = null;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.G != null) {
      this.G.b();
    }
    if ((this.A == 0) && (i) && ((this.H) || (paramBoolean)))
    {
      ViewCompat.setAlpha(this.n, 1.0F);
      this.n.setTransitioning(true);
      ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      float f1 = -this.n.getHeight();
      if (paramBoolean)
      {
        int[] arrayOfInt = { 0, 0 };
        this.n.getLocationInWindow(arrayOfInt);
        f1 -= arrayOfInt[1];
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.n).translationY(f1);
      localViewPropertyAnimatorCompat.setUpdateListener(this.g);
      localViewPropertyAnimatorCompatSet.a(localViewPropertyAnimatorCompat);
      if ((this.B) && (this.r != null)) {
        localViewPropertyAnimatorCompatSet.a(ViewCompat.animate(this.r).translationY(f1));
      }
      if ((this.q != null) && (this.q.getVisibility() == 0))
      {
        ViewCompat.setAlpha(this.q, 1.0F);
        localViewPropertyAnimatorCompatSet.a(ViewCompat.animate(this.q).translationY(this.q.getHeight()));
      }
      localViewPropertyAnimatorCompatSet.a(AnimationUtils.loadInterpolator(this.j, 17432581));
      localViewPropertyAnimatorCompatSet.a(250L);
      localViewPropertyAnimatorCompatSet.a(this.e);
      this.G = localViewPropertyAnimatorCompatSet;
      localViewPropertyAnimatorCompatSet.a();
      return;
    }
    this.e.onAnimationEnd(null);
  }
  
  public void j() {}
  
  public void j(boolean paramBoolean)
  {
    int i1;
    label20:
    ActionBarContextView localActionBarContextView;
    int i2;
    if (paramBoolean)
    {
      k();
      DecorToolbar localDecorToolbar = this.o;
      if (!paramBoolean) {
        break label55;
      }
      i1 = 8;
      localDecorToolbar.d(i1);
      localActionBarContextView = this.p;
      i2 = 0;
      if (!paramBoolean) {
        break label60;
      }
    }
    for (;;)
    {
      localActionBarContextView.a(i2);
      return;
      l();
      break;
      label55:
      i1 = 0;
      break label20;
      label60:
      i2 = 8;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowDecorActionBar
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */