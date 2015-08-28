package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerCompat
  extends AdapterViewCompat<SpinnerAdapter>
{
  private DataSetObserver E;
  SpinnerAdapter a;
  int b;
  int c;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  final Rect h = new Rect();
  final AbsSpinnerCompat.RecycleBin i = new AbsSpinnerCompat.RecycleBin(this);
  
  AbsSpinnerCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
  }
  
  private void k()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  void a()
  {
    this.u = false;
    this.o = false;
    removeAllViewsInLayout();
    this.B = -1;
    this.C = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }
  
  abstract void a(int paramInt, boolean paramBoolean);
  
  public void a(SpinnerAdapter paramSpinnerAdapter)
  {
    int j = -1;
    if (this.a != null)
    {
      this.a.unregisterDataSetObserver(this.E);
      a();
    }
    this.a = paramSpinnerAdapter;
    this.B = j;
    this.C = -9223372036854775808L;
    if (this.a != null)
    {
      this.A = this.z;
      this.z = this.a.getCount();
      e();
      this.E = new AdapterViewCompat.AdapterDataSetObserver(this);
      this.a.registerDataSetObserver(this.E);
      if (this.z > 0) {
        j = 0;
      }
      setSelectedPositionInt(j);
      setNextSelectedPositionInt(j);
      if (this.z == 0) {
        h();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      e();
      a();
      h();
    }
  }
  
  int b(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  void b()
  {
    int j = getChildCount();
    AbsSpinnerCompat.RecycleBin localRecycleBin = this.i;
    int k = this.j;
    for (int m = 0; m < j; m++)
    {
      View localView = getChildAt(m);
      localRecycleBin.a(k + m, localView);
    }
  }
  
  public SpinnerAdapter c()
  {
    return this.a;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public int getCount()
  {
    return this.z;
  }
  
  public View getSelectedView()
  {
    if ((this.z > 0) && (this.x >= 0)) {
      return getChildAt(this.x - this.j);
    }
    return null;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = getPaddingLeft();
    int m = getPaddingTop();
    int n = getPaddingRight();
    int i1 = getPaddingBottom();
    Rect localRect1 = this.h;
    int i2;
    label70:
    int i3;
    label96:
    int i4;
    label122:
    int i8;
    int i7;
    int i6;
    if (k > this.d)
    {
      localRect1.left = k;
      Rect localRect2 = this.h;
      if (m <= this.e) {
        break label412;
      }
      i2 = m;
      localRect2.top = i2;
      Rect localRect3 = this.h;
      if (n <= this.f) {
        break label421;
      }
      i3 = n;
      localRect3.right = i3;
      Rect localRect4 = this.h;
      if (i1 <= this.g) {
        break label430;
      }
      i4 = i1;
      localRect4.bottom = i4;
      if (this.u) {
        g();
      }
      int i5 = getSelectedItemPosition();
      if ((i5 < 0) || (this.a == null) || (i5 >= this.a.getCount())) {
        break label439;
      }
      View localView = this.i.a(i5);
      if (localView == null) {
        localView = this.a.getView(i5, null, this);
      }
      if (localView == null) {
        break label439;
      }
      this.i.a(i5, localView);
      if (localView.getLayoutParams() == null)
      {
        this.D = true;
        localView.setLayoutParams(generateDefaultLayoutParams());
        this.D = false;
      }
      measureChild(localView, paramInt1, paramInt2);
      i8 = a(localView) + this.h.top + this.h.bottom;
      i7 = b(localView) + this.h.left + this.h.right;
      i6 = 0;
    }
    for (;;)
    {
      if (i6 != 0)
      {
        i8 = this.h.top + this.h.bottom;
        if (j == 0) {
          i7 = this.h.left + this.h.right;
        }
      }
      int i9 = Math.max(i8, getSuggestedMinimumHeight());
      int i10 = Math.max(i7, getSuggestedMinimumWidth());
      int i11 = ViewCompat.resolveSizeAndState(i9, paramInt2, 0);
      setMeasuredDimension(ViewCompat.resolveSizeAndState(i10, paramInt1, 0), i11);
      this.b = paramInt2;
      this.c = paramInt1;
      return;
      k = this.d;
      break;
      label412:
      i2 = this.e;
      break label70;
      label421:
      i3 = this.f;
      break label96;
      label430:
      i4 = this.g;
      break label122;
      label439:
      i6 = 1;
      i7 = 0;
      i8 = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AbsSpinnerCompat.SavedState localSavedState = (AbsSpinnerCompat.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.a >= 0L)
    {
      this.u = true;
      this.o = true;
      this.m = localSavedState.a;
      this.l = localSavedState.b;
      this.p = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinnerCompat.SavedState localSavedState = new AbsSpinnerCompat.SavedState(super.onSaveInstanceState());
    localSavedState.a = getSelectedItemId();
    if (localSavedState.a >= 0L)
    {
      localSavedState.b = getSelectedItemPosition();
      return localSavedState;
    }
    localSavedState.b = -1;
    return localSavedState;
  }
  
  public void requestLayout()
  {
    if (!this.D) {
      super.requestLayout();
    }
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */