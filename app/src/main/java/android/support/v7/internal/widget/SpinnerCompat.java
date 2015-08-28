package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.SpinnerAdapter;

class SpinnerCompat
  extends AbsSpinnerCompat
  implements DialogInterface.OnClickListener
{
  int E;
  private ListPopupWindow.ForwardingListener F;
  private SpinnerCompat.SpinnerPopup G;
  private SpinnerCompat.DropDownAdapter H;
  private int I;
  private boolean J;
  private Rect K = new Rect();
  private final TintManager L;
  
  SpinnerCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  SpinnerCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, R.styleable.Spinner, paramInt1, 0);
    setBackgroundDrawable(localTintTypedArray.a(R.styleable.Spinner_android_background));
    if (paramInt2 == -1) {
      paramInt2 = localTintTypedArray.a(R.styleable.Spinner_spinnerMode, 0);
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.I = localTintTypedArray.a(R.styleable.Spinner_android_gravity, 17);
      this.G.a(localTintTypedArray.c(R.styleable.Spinner_prompt));
      this.J = localTintTypedArray.a(R.styleable.Spinner_disableChildrenWhenDisabled, false);
      localTintTypedArray.b();
      if (this.H != null)
      {
        this.G.a(this.H);
        this.H = null;
      }
      this.L = localTintTypedArray.c();
      return;
      this.G = new SpinnerCompat.DialogPopup(this, null);
      continue;
      SpinnerCompat.DropdownPopup localDropdownPopup = new SpinnerCompat.DropdownPopup(this, paramContext, paramAttributeSet, paramInt1);
      this.E = localTintTypedArray.e(R.styleable.Spinner_android_dropDownWidth, -2);
      localDropdownPopup.a(localTintTypedArray.a(R.styleable.Spinner_android_popupBackground));
      this.G = localDropdownPopup;
      this.F = new SpinnerCompat.1(this, this, localDropdownPopup);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = generateDefaultLayoutParams();
    }
    if (paramBoolean) {
      addViewInLayout(paramView, 0, localLayoutParams);
    }
    paramView.setSelected(hasFocus());
    if (this.J) {
      paramView.setEnabled(isEnabled());
    }
    int i = ViewGroup.getChildMeasureSpec(this.b, this.h.top + this.h.bottom, localLayoutParams.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.c, this.h.left + this.h.right, localLayoutParams.width), i);
    int j = this.h.top + (getMeasuredHeight() - this.h.bottom - this.h.top - paramView.getMeasuredHeight()) / 2;
    int k = j + paramView.getMeasuredHeight();
    paramView.layout(0, j, 0 + paramView.getMeasuredWidth(), k);
  }
  
  private View c(int paramInt, boolean paramBoolean)
  {
    if (!this.u)
    {
      View localView2 = this.i.a(paramInt);
      if (localView2 != null)
      {
        a(localView2, paramBoolean);
        return localView2;
      }
    }
    View localView1 = this.a.getView(paramInt, null, this);
    a(localView1, paramBoolean);
    return localView1;
  }
  
  int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = Math.max(0, getSelectedItemPosition());
    int m = Math.min(paramSpinnerAdapter.getCount(), k + 15);
    int n = Math.max(0, k - (15 - (m - k)));
    View localView1 = null;
    int i1 = 0;
    int i2 = 0;
    int i3;
    if (n < m)
    {
      i3 = paramSpinnerAdapter.getItemViewType(n);
      if (i3 == i2) {
        break label200;
      }
    }
    for (View localView2 = null;; localView2 = localView1)
    {
      localView1 = paramSpinnerAdapter.getView(n, localView2, this);
      if (localView1.getLayoutParams() == null) {
        localView1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView1.measure(i, j);
      i1 = Math.max(i1, localView1.getMeasuredWidth());
      n++;
      i2 = i3;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.K);
        return i1 + (this.K.left + this.K.right);
      }
      return i1;
      label200:
      i3 = i2;
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    int i = this.h.left;
    int j = getRight() - getLeft() - this.h.left - this.h.right;
    if (this.u) {
      g();
    }
    if (this.z == 0)
    {
      a();
      return;
    }
    if (this.v >= 0) {
      setSelectedPositionInt(this.v);
    }
    b();
    removeAllViewsInLayout();
    this.j = this.x;
    View localView;
    int k;
    if (this.a != null)
    {
      localView = c(this.x, true);
      k = localView.getMeasuredWidth();
      int m = ViewCompat.getLayoutDirection(this);
      switch (0x7 & GravityCompat.getAbsoluteGravity(this.I, m))
      {
      }
    }
    for (;;)
    {
      localView.offsetLeftAndRight(i);
      this.i.a();
      invalidate();
      h();
      this.u = false;
      this.o = false;
      setNextSelectedPositionInt(this.x);
      return;
      i = i + j / 2 - k / 2;
      continue;
      i = i + j - k;
    }
  }
  
  void a(AdapterViewCompat.OnItemClickListener paramOnItemClickListener)
  {
    super.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void a(SpinnerAdapter paramSpinnerAdapter)
  {
    super.a(paramSpinnerAdapter);
    this.i.a();
    if ((getContext().getApplicationInfo().targetSdkVersion >= 21) && (paramSpinnerAdapter != null) && (paramSpinnerAdapter.getViewTypeCount() != 1)) {
      throw new IllegalArgumentException("Spinner adapter view type count must be 1");
    }
    if (this.G != null)
    {
      this.G.a(new SpinnerCompat.DropDownAdapter(paramSpinnerAdapter));
      return;
    }
    this.H = new SpinnerCompat.DropDownAdapter(paramSpinnerAdapter);
  }
  
  public int getBaseline()
  {
    int i = -1;
    View localView;
    if (getChildCount() > 0) {
      localView = getChildAt(0);
    }
    for (;;)
    {
      if (localView != null)
      {
        int k = localView.getBaseline();
        if (k >= 0) {
          i = k + localView.getTop();
        }
      }
      return i;
      SpinnerAdapter localSpinnerAdapter = this.a;
      localView = null;
      if (localSpinnerAdapter != null)
      {
        int j = this.a.getCount();
        localView = null;
        if (j > 0)
        {
          localView = c(0, false);
          this.i.a(0, localView);
        }
      }
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    setSelection(paramInt);
    paramDialogInterface.dismiss();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.G != null) && (this.G.b())) {
      this.G.a();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.q = true;
    a(0, false);
    this.q = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.G != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(c(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SpinnerCompat.SavedState localSavedState = (SpinnerCompat.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.c)
    {
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver != null) {
        localViewTreeObserver.addOnGlobalLayoutListener(new SpinnerCompat.2(this));
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SpinnerCompat.SavedState localSavedState = new SpinnerCompat.SavedState(super.onSaveInstanceState());
    if ((this.G != null) && (this.G.b())) {}
    for (boolean bool = true;; bool = false)
    {
      localSavedState.c = bool;
      return localSavedState;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.F != null) && (this.F.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (!bool)
    {
      bool = true;
      if (!this.G.b()) {
        this.G.c();
      }
    }
    return bool;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (this.J)
    {
      int i = getChildCount();
      for (int j = 0; j < i; j++) {
        getChildAt(j).setEnabled(paramBoolean);
      }
    }
  }
  
  public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener paramOnItemClickListener)
  {
    throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */