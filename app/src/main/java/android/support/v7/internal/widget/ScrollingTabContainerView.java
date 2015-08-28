package android.support.v7.internal.widget;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.HorizontalScrollView;

public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterViewCompat.OnItemClickListener
{
  private static final Interpolator k = new DecelerateInterpolator();
  Runnable a;
  int b;
  int c;
  protected ViewPropertyAnimatorCompat d;
  private ScrollingTabContainerView.TabClickListener e;
  private LinearLayoutCompat f;
  private SpinnerCompat g;
  private boolean h;
  private int i;
  private int j;
  
  private ScrollingTabContainerView.TabView a(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    ScrollingTabContainerView.TabView localTabView = new ScrollingTabContainerView.TabView(this, getContext(), paramTab, paramBoolean);
    if (paramBoolean)
    {
      localTabView.setBackgroundDrawable(null);
      localTabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
      return localTabView;
    }
    localTabView.setFocusable(true);
    if (this.e == null) {
      this.e = new ScrollingTabContainerView.TabClickListener(this, null);
    }
    localTabView.setOnClickListener(this.e);
    return localTabView;
  }
  
  private boolean a()
  {
    return (this.g != null) && (this.g.getParent() == this);
  }
  
  private void b()
  {
    if (a()) {
      return;
    }
    if (this.g == null) {
      this.g = d();
    }
    removeView(this.f);
    addView(this.g, new ViewGroup.LayoutParams(-2, -1));
    if (this.g.c() == null) {
      this.g.a(new ScrollingTabContainerView.TabAdapter(this, null));
    }
    if (this.a != null)
    {
      removeCallbacks(this.a);
      this.a = null;
    }
    this.g.setSelection(this.j);
  }
  
  private boolean c()
  {
    if (!a()) {
      return false;
    }
    removeView(this.g);
    addView(this.f, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.g.getSelectedItemPosition());
    return false;
  }
  
  private SpinnerCompat d()
  {
    SpinnerCompat localSpinnerCompat = new SpinnerCompat(getContext(), null, R.attr.actionDropDownStyle);
    localSpinnerCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localSpinnerCompat.a(this);
    return localSpinnerCompat;
  }
  
  public void a(int paramInt)
  {
    View localView = this.f.getChildAt(paramInt);
    if (this.a != null) {
      removeCallbacks(this.a);
    }
    this.a = new ScrollingTabContainerView.1(this, localView);
    post(this.a);
  }
  
  public void a(AdapterViewCompat<?> paramAdapterViewCompat, View paramView, int paramInt, long paramLong)
  {
    ((ScrollingTabContainerView.TabView)paramView).b().d();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a != null) {
      post(this.a);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    ActionBarPolicy localActionBarPolicy = ActionBarPolicy.a(getContext());
    setContentHeight(localActionBarPolicy.e());
    this.c = localActionBarPolicy.g();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null) {
      removeCallbacks(this.a);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 1;
    int n = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    label72:
    label87:
    int i2;
    if (n == 1073741824)
    {
      bool = m;
      setFillViewport(bool);
      int i1 = this.f.getChildCount();
      if ((i1 <= m) || ((n != 1073741824) && (n != -2147483648))) {
        break label201;
      }
      if (i1 <= 2) {
        break label188;
      }
      this.b = ((int)(0.4F * View.MeasureSpec.getSize(paramInt1)));
      this.b = Math.min(this.b, this.c);
      i2 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
      if ((bool) || (!this.h)) {
        break label209;
      }
      label110:
      if (m == 0) {
        break label222;
      }
      this.f.measure(0, i2);
      if (this.f.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label214;
      }
      b();
    }
    for (;;)
    {
      int i3 = getMeasuredWidth();
      super.onMeasure(paramInt1, i2);
      int i4 = getMeasuredWidth();
      if ((bool) && (i3 != i4)) {
        setTabSelected(this.j);
      }
      return;
      bool = false;
      break;
      label188:
      this.b = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label72;
      label201:
      this.b = -1;
      break label87;
      label209:
      m = 0;
      break label110;
      label214:
      c();
      continue;
      label222:
      c();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.j = paramInt;
    int m = this.f.getChildCount();
    int n = 0;
    if (n < m)
    {
      View localView = this.f.getChildAt(n);
      if (n == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          a(paramInt);
        }
        n++;
        break;
      }
    }
    if ((this.g != null) && (paramInt >= 0)) {
      this.g.setSelection(paramInt);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */