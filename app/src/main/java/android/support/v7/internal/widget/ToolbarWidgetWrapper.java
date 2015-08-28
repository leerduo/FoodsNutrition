package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ToolbarWidgetWrapper
  implements DecorToolbar
{
  private Toolbar a;
  private int b;
  private View c;
  private View d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private boolean h;
  private CharSequence i;
  private CharSequence j;
  private CharSequence k;
  private WindowCallback l;
  private boolean m;
  private ActionMenuPresenter n;
  private int o = 0;
  private final TintManager p;
  private int q = 0;
  private Drawable r;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
  }
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramToolbar;
    this.i = paramToolbar.getTitle();
    this.j = paramToolbar.getSubtitle();
    boolean bool;
    TintTypedArray localTintTypedArray;
    if (this.i != null)
    {
      bool = true;
      this.h = bool;
      if (!paramBoolean) {
        break label493;
      }
      localTintTypedArray = TintTypedArray.a(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      CharSequence localCharSequence1 = localTintTypedArray.b(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty(localCharSequence1)) {
        b(localCharSequence1);
      }
      CharSequence localCharSequence2 = localTintTypedArray.b(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty(localCharSequence2)) {
        c(localCharSequence2);
      }
      Drawable localDrawable1 = localTintTypedArray.a(R.styleable.ActionBar_logo);
      if (localDrawable1 != null) {
        d(localDrawable1);
      }
      Drawable localDrawable2 = localTintTypedArray.a(R.styleable.ActionBar_icon);
      if (localDrawable2 != null) {
        a(localDrawable2);
      }
      Drawable localDrawable3 = localTintTypedArray.a(R.styleable.ActionBar_homeAsUpIndicator);
      if (localDrawable3 != null) {
        b(localDrawable3);
      }
      c(localTintTypedArray.a(R.styleable.ActionBar_displayOptions, 0));
      int i1 = localTintTypedArray.f(R.styleable.ActionBar_customNavigationLayout, 0);
      if (i1 != 0)
      {
        a(LayoutInflater.from(this.a.getContext()).inflate(i1, this.a, false));
        c(0x10 | this.b);
      }
      int i2 = localTintTypedArray.e(R.styleable.ActionBar_height, 0);
      if (i2 > 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
        localLayoutParams.height = i2;
        this.a.setLayoutParams(localLayoutParams);
      }
      int i3 = localTintTypedArray.c(R.styleable.ActionBar_contentInsetStart, -1);
      int i4 = localTintTypedArray.c(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((i3 >= 0) || (i4 >= 0)) {
        this.a.a(Math.max(i3, 0), Math.max(i4, 0));
      }
      int i5 = localTintTypedArray.f(R.styleable.ActionBar_titleTextStyle, 0);
      if (i5 != 0) {
        this.a.a(this.a.getContext(), i5);
      }
      int i6 = localTintTypedArray.f(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (i6 != 0) {
        this.a.b(this.a.getContext(), i6);
      }
      int i7 = localTintTypedArray.f(R.styleable.ActionBar_popupTheme, 0);
      if (i7 != 0) {
        this.a.setPopupTheme(i7);
      }
      localTintTypedArray.b();
    }
    for (this.p = localTintTypedArray.c();; this.p = new TintManager(paramToolbar.getContext()))
    {
      f(paramInt1);
      this.k = this.a.getNavigationContentDescription();
      c(this.p.a(paramInt2));
      this.a.setNavigationOnClickListener(new ToolbarWidgetWrapper.1(this));
      return;
      bool = false;
      break;
      label493:
      this.b = r();
    }
  }
  
  private void e(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
    if ((0x8 & this.b) != 0) {
      this.a.setTitle(paramCharSequence);
    }
  }
  
  private int r()
  {
    int i1 = 11;
    if (this.a.getNavigationIcon() != null) {
      i1 = 15;
    }
    return i1;
  }
  
  private void s()
  {
    int i1 = 0x2 & this.b;
    Drawable localDrawable = null;
    if (i1 != 0)
    {
      if ((0x1 & this.b) == 0) {
        break label51;
      }
      if (this.f == null) {
        break label43;
      }
      localDrawable = this.f;
    }
    for (;;)
    {
      this.a.setLogo(localDrawable);
      return;
      label43:
      localDrawable = this.e;
      continue;
      label51:
      localDrawable = this.e;
    }
  }
  
  private void t()
  {
    if ((0x4 & this.b) != 0)
    {
      if (TextUtils.isEmpty(this.k)) {
        this.a.setNavigationContentDescription(this.q);
      }
    }
    else {
      return;
    }
    this.a.setNavigationContentDescription(this.k);
  }
  
  private void u()
  {
    Toolbar localToolbar;
    if ((0x4 & this.b) != 0)
    {
      localToolbar = this.a;
      if (this.g == null) {
        break label32;
      }
    }
    label32:
    for (Drawable localDrawable = this.g;; localDrawable = this.r)
    {
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
  }
  
  public ViewGroup a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.p.a(paramInt);; localDrawable = null)
    {
      a(localDrawable);
      return;
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    s();
  }
  
  public void a(WindowCallback paramWindowCallback)
  {
    this.l = paramWindowCallback;
  }
  
  public void a(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if ((this.c != null) && (this.c.getParent() == this.a)) {
      this.a.removeView(this.c);
    }
    this.c = paramScrollingTabContainerView;
    if ((paramScrollingTabContainerView != null) && (this.o == 2))
    {
      this.a.addView(this.c, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.a = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public void a(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    if (this.n == null)
    {
      this.n = new ActionMenuPresenter(this.a.getContext());
      this.n.a(R.id.action_menu_presenter);
    }
    this.n.a(paramCallback);
    this.a.a((MenuBuilder)paramMenu, this.n);
  }
  
  public void a(View paramView)
  {
    if ((this.d != null) && ((0x10 & this.b) != 0)) {
      this.a.removeView(this.d);
    }
    this.d = paramView;
    if ((paramView != null) && ((0x10 & this.b) != 0)) {
      this.a.addView(this.d);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!this.h) {
      e(paramCharSequence);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setCollapsible(paramBoolean);
  }
  
  public Context b()
  {
    return this.a.getContext();
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.p.a(paramInt);; localDrawable = null)
    {
      d(localDrawable);
      return;
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    this.g = paramDrawable;
    u();
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.h = true;
    e(paramCharSequence);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt)
  {
    int i1 = paramInt ^ this.b;
    this.b = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label115;
        }
        u();
        t();
      }
      if ((i1 & 0x3) != 0) {
        s();
      }
      if ((i1 & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label126;
        }
        this.a.setTitle(this.i);
        this.a.setSubtitle(this.j);
      }
    }
    for (;;)
    {
      if (((i1 & 0x10) != 0) && (this.d != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label145;
        }
        this.a.addView(this.d);
      }
      return;
      label115:
      this.a.setNavigationIcon(null);
      break;
      label126:
      this.a.setTitle(null);
      this.a.setSubtitle(null);
    }
    label145:
    this.a.removeView(this.d);
  }
  
  public void c(Drawable paramDrawable)
  {
    if (this.r != paramDrawable)
    {
      this.r = paramDrawable;
      u();
    }
  }
  
  public void c(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    if ((0x8 & this.b) != 0) {
      this.a.setSubtitle(paramCharSequence);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 8) {
      ViewCompat.animate(this.a).alpha(0.0F).setListener(new ToolbarWidgetWrapper.2(this));
    }
    while (paramInt != 0) {
      return;
    }
    ViewCompat.animate(this.a).alpha(1.0F).setListener(new ToolbarWidgetWrapper.3(this));
  }
  
  public void d(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    s();
  }
  
  public void d(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
    t();
  }
  
  public boolean d()
  {
    return this.a.g();
  }
  
  public void e()
  {
    this.a.h();
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = b().getString(paramInt))
    {
      d((CharSequence)localObject);
      return;
    }
  }
  
  public CharSequence f()
  {
    return this.a.getTitle();
  }
  
  public void f(int paramInt)
  {
    if (paramInt == this.q) {}
    do
    {
      return;
      this.q = paramInt;
    } while (!TextUtils.isEmpty(this.a.getNavigationContentDescription()));
    e(this.q);
  }
  
  public void g()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void h()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean i()
  {
    return this.a.a();
  }
  
  public boolean j()
  {
    return this.a.b();
  }
  
  public boolean k()
  {
    return this.a.c();
  }
  
  public boolean l()
  {
    return this.a.d();
  }
  
  public boolean m()
  {
    return this.a.e();
  }
  
  public void n()
  {
    this.m = true;
  }
  
  public void o()
  {
    this.a.f();
  }
  
  public int p()
  {
    return this.b;
  }
  
  public int q()
  {
    return this.o;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ToolbarWidgetWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */