package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

abstract class AbsActionBarView
  extends ViewGroup
{
  private static final Interpolator j = new DecelerateInterpolator();
  protected final AbsActionBarView.VisibilityAnimListener a = new AbsActionBarView.VisibilityAnimListener(this);
  protected final Context b;
  protected ActionMenuView c;
  protected ActionMenuPresenter d;
  protected ViewGroup e;
  protected boolean f;
  protected boolean g;
  protected int h;
  protected ViewPropertyAnimatorCompat i;
  
  AbsActionBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedValue localTypedValue = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true)) && (localTypedValue.resourceId != 0))
    {
      this.b = new ContextThemeWrapper(paramContext, localTypedValue.resourceId);
      return;
    }
    this.b = paramContext;
  }
  
  protected static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    int n = paramInt2 + (paramInt3 - m) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - k, n, paramInt1, m + n);
    }
    for (;;)
    {
      if (paramBoolean) {
        k = -k;
      }
      return k;
      paramView.layout(paramInt1, n, paramInt1 + k, m + n);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.i != null) {
      this.i.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0)
      {
        ViewCompat.setAlpha(this, 0.0F);
        if ((this.e != null) && (this.c != null)) {
          ViewCompat.setAlpha(this.c, 0.0F);
        }
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat3 = ViewCompat.animate(this).alpha(1.0F);
      localViewPropertyAnimatorCompat3.setDuration(200L);
      localViewPropertyAnimatorCompat3.setInterpolator(j);
      if ((this.e != null) && (this.c != null))
      {
        ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat4 = ViewCompat.animate(this.c).alpha(1.0F);
        localViewPropertyAnimatorCompat4.setDuration(200L);
        localViewPropertyAnimatorCompatSet2.a(this.a.a(localViewPropertyAnimatorCompat3, paramInt));
        localViewPropertyAnimatorCompatSet2.a(localViewPropertyAnimatorCompat3).a(localViewPropertyAnimatorCompat4);
        localViewPropertyAnimatorCompatSet2.a();
        return;
      }
      localViewPropertyAnimatorCompat3.setListener(this.a.a(localViewPropertyAnimatorCompat3, paramInt));
      localViewPropertyAnimatorCompat3.start();
      return;
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(this).alpha(0.0F);
    localViewPropertyAnimatorCompat1.setDuration(200L);
    localViewPropertyAnimatorCompat1.setInterpolator(j);
    if ((this.e != null) && (this.c != null))
    {
      ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet1 = new ViewPropertyAnimatorCompatSet();
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = ViewCompat.animate(this.c).alpha(0.0F);
      localViewPropertyAnimatorCompat2.setDuration(200L);
      localViewPropertyAnimatorCompatSet1.a(this.a.a(localViewPropertyAnimatorCompat1, paramInt));
      localViewPropertyAnimatorCompatSet1.a(localViewPropertyAnimatorCompat1).a(localViewPropertyAnimatorCompat2);
      localViewPropertyAnimatorCompatSet1.a();
      return;
    }
    localViewPropertyAnimatorCompat1.setListener(this.a.a(localViewPropertyAnimatorCompat1, paramInt));
    localViewPropertyAnimatorCompat1.start();
  }
  
  public boolean a()
  {
    if (this.d != null) {
      return this.d.c();
    }
    return false;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.i != null) {
      return this.a.a;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.h;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(localTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0));
    localTypedArray.recycle();
    if (this.d != null) {
      this.d.a(paramConfiguration);
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
  }
  
  public void setSplitToolbar(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setSplitView(ViewGroup paramViewGroup)
  {
    this.e = paramViewGroup;
  }
  
  public void setSplitWhenNarrow(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsActionBarView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */