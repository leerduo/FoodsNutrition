package android.support.v7.internal.widget;

import android.content.Context;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

public abstract class AdapterViewCompat<T extends Adapter>
  extends ViewGroup
{
  int A;
  int B = -1;
  long C = -9223372036854775808L;
  boolean D = false;
  private int a;
  private View b;
  private boolean c;
  private boolean d;
  private AdapterViewCompat<T>.SelectionNotifier e;
  @ViewDebug.ExportedProperty(category="scrolling")
  int j = 0;
  int k;
  int l;
  long m = -9223372036854775808L;
  long n;
  boolean o = false;
  int p;
  boolean q = false;
  AdapterViewCompat.OnItemSelectedListener r;
  AdapterViewCompat.OnItemClickListener s;
  AdapterViewCompat.OnItemLongClickListener t;
  boolean u;
  @ViewDebug.ExportedProperty(category="list")
  int v = -1;
  long w = -9223372036854775808L;
  @ViewDebug.ExportedProperty(category="list")
  int x = -1;
  long y = -9223372036854775808L;
  @ViewDebug.ExportedProperty(category="list")
  int z;
  
  AdapterViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (this.r == null) {
      return;
    }
    int i = getSelectedItemPosition();
    if (i >= 0)
    {
      View localView = getSelectedView();
      this.r.a(this, localView, i, getAdapter().getItemId(i));
      return;
    }
    this.r.a(this);
  }
  
  private void a(boolean paramBoolean)
  {
    if (d()) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (this.b != null)
      {
        this.b.setVisibility(0);
        setVisibility(8);
      }
      for (;;)
      {
        if (this.u) {
          onLayout(false, getLeft(), getTop(), getRight(), getBottom());
        }
        return;
        setVisibility(0);
      }
    }
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    setVisibility(0);
  }
  
  public long a(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    if ((localAdapter == null) || (paramInt < 0)) {
      return -9223372036854775808L;
    }
    return localAdapter.getItemId(paramInt);
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    AdapterViewCompat.OnItemClickListener localOnItemClickListener = this.s;
    boolean bool = false;
    if (localOnItemClickListener != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      this.s.a(this, paramView, paramInt, paramLong);
      bool = true;
    }
    return bool;
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  int b(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.z > 0);
  }
  
  boolean d()
  {
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    View localView = getSelectedView();
    return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  void e()
  {
    Adapter localAdapter = getAdapter();
    int i;
    int i1;
    label33:
    boolean bool1;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!d())) {
        break label115;
      }
      i1 = 1;
      if ((i1 == 0) || (!this.d)) {
        break label120;
      }
      bool1 = true;
      label47:
      super.setFocusableInTouchMode(bool1);
      if ((i1 == 0) || (!this.c)) {
        break label126;
      }
    }
    label115:
    label120:
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      super.setFocusable(bool2);
      if (this.b != null)
      {
        boolean bool3;
        if (localAdapter != null)
        {
          boolean bool4 = localAdapter.isEmpty();
          bool3 = false;
          if (!bool4) {}
        }
        else
        {
          bool3 = true;
        }
        a(bool3);
      }
      return;
      i = 0;
      break;
      i1 = 0;
      break label33;
      bool1 = false;
      break label47;
    }
  }
  
  void f()
  {
    if (this.r != null)
    {
      if ((!this.q) && (!this.D)) {
        break label78;
      }
      if (this.e == null) {
        this.e = new AdapterViewCompat.SelectionNotifier(this, null);
      }
      post(this.e);
    }
    for (;;)
    {
      if ((this.x != -1) && (isShown()) && (!isInTouchMode())) {
        sendAccessibilityEvent(4);
      }
      return;
      label78:
      a();
    }
  }
  
  void g()
  {
    int i = this.z;
    int i2;
    int i4;
    int i5;
    label104:
    int i1;
    if (i > 0) {
      if (this.o)
      {
        this.o = false;
        int i6 = i();
        if ((i6 >= 0) && (b(i6, true) == i6))
        {
          setNextSelectedPositionInt(i6);
          i2 = 1;
          if (i2 == 0)
          {
            int i3 = getSelectedItemPosition();
            if (i3 >= i) {
              i3 = i - 1;
            }
            if (i3 < 0) {
              i3 = 0;
            }
            i4 = b(i3, true);
            if (i4 >= 0) {
              break label164;
            }
            i5 = b(i3, false);
            if (i5 >= 0)
            {
              setNextSelectedPositionInt(i5);
              h();
              i1 = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        this.x = -1;
        this.y = -9223372036854775808L;
        this.v = -1;
        this.w = -9223372036854775808L;
        this.o = false;
        h();
      }
      return;
      i1 = i2;
      continue;
      label164:
      i5 = i4;
      break label104;
      i2 = 0;
      break;
      i1 = 0;
    }
  }
  
  public abstract T getAdapter();
  
  @ViewDebug.CapturedViewProperty
  public int getCount()
  {
    return this.z;
  }
  
  public View getEmptyView()
  {
    return this.b;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.j;
  }
  
  public int getLastVisiblePosition()
  {
    return -1 + (this.j + getChildCount());
  }
  
  public final AdapterViewCompat.OnItemClickListener getOnItemClickListener()
  {
    return this.s;
  }
  
  public final AdapterViewCompat.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.t;
  }
  
  public final AdapterViewCompat.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.r;
  }
  
  public Object getSelectedItem()
  {
    Adapter localAdapter = getAdapter();
    int i = getSelectedItemPosition();
    if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0)) {
      return localAdapter.getItem(i);
    }
    return null;
  }
  
  @ViewDebug.CapturedViewProperty
  public long getSelectedItemId()
  {
    return this.w;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getSelectedItemPosition()
  {
    return this.v;
  }
  
  public abstract View getSelectedView();
  
  void h()
  {
    if ((this.x != this.B) || (this.y != this.C))
    {
      f();
      this.B = this.x;
      this.C = this.y;
    }
  }
  
  int i()
  {
    int i = this.z;
    int i5;
    if (i == 0)
    {
      i5 = -1;
      return i5;
    }
    long l1 = this.m;
    int i1 = this.l;
    if (l1 == -9223372036854775808L) {
      return -1;
    }
    int i2 = Math.max(0, i1);
    int i3 = Math.min(i - 1, i2);
    long l2 = 100L + SystemClock.uptimeMillis();
    Adapter localAdapter = getAdapter();
    label76:
    int i8;
    int i6;
    int i7;
    if (localAdapter == null)
    {
      return -1;
      if ((i8 != 0) || ((i6 != 0) && (i7 == 0)))
      {
        i3++;
        i6 = 0;
        i5 = i3;
      }
    }
    for (;;)
    {
      int i4;
      if (SystemClock.uptimeMillis() <= l2)
      {
        if (localAdapter.getItemId(i5) == l1) {
          break;
        }
        if (i3 != i - 1) {
          break label155;
        }
        i7 = 1;
        if (i4 != 0) {
          break label161;
        }
      }
      label155:
      label161:
      for (i8 = 1;; i8 = 0)
      {
        if ((i7 == 0) || (i8 == 0)) {
          break label165;
        }
        return -1;
        i7 = 0;
        break;
      }
      label165:
      break label76;
      if ((i7 != 0) || ((i6 == 0) && (i8 == 0)))
      {
        i4--;
        i6 = 1;
        i5 = i4;
        continue;
        i4 = i3;
        i5 = i3;
        i6 = 0;
      }
    }
  }
  
  void j()
  {
    if (getChildCount() > 0)
    {
      this.o = true;
      this.n = this.a;
      if (this.x >= 0)
      {
        View localView2 = getChildAt(this.x - this.j);
        this.m = this.w;
        this.l = this.v;
        if (localView2 != null) {
          this.k = localView2.getTop();
        }
        this.p = 0;
      }
    }
    else
    {
      return;
    }
    View localView1 = getChildAt(0);
    Adapter localAdapter = getAdapter();
    if ((this.j >= 0) && (this.j < localAdapter.getCount())) {}
    for (this.m = localAdapter.getItemId(this.j);; this.m = -1L)
    {
      this.l = this.j;
      if (localView1 != null) {
        this.k = localView1.getTop();
      }
      this.p = 1;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.e);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = getHeight();
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  public abstract void setAdapter(T paramT);
  
  public void setEmptyView(View paramView)
  {
    this.b = paramView;
    Adapter localAdapter = getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    boolean bool1 = true;
    Adapter localAdapter = getAdapter();
    boolean bool2;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      bool2 = bool1;
      this.c = paramBoolean;
      if (!paramBoolean) {
        this.d = false;
      }
      if ((!paramBoolean) || ((bool2) && (!d()))) {
        break label65;
      }
    }
    for (;;)
    {
      super.setFocusable(bool1);
      return;
      bool2 = false;
      break;
      label65:
      bool1 = false;
    }
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool1 = true;
    Adapter localAdapter = getAdapter();
    boolean bool2;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      bool2 = bool1;
      this.d = paramBoolean;
      if (paramBoolean) {
        this.c = bool1;
      }
      if ((!paramBoolean) || ((bool2) && (!d()))) {
        break label65;
      }
    }
    for (;;)
    {
      super.setFocusableInTouchMode(bool1);
      return;
      bool2 = false;
      break;
      label65:
      bool1 = false;
    }
  }
  
  void setNextSelectedPositionInt(int paramInt)
  {
    this.v = paramInt;
    this.w = a(paramInt);
    if ((this.o) && (this.p == 0) && (paramInt >= 0))
    {
      this.l = paramInt;
      this.m = this.w;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener paramOnItemClickListener)
  {
    this.s = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterViewCompat.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.t = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterViewCompat.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.r = paramOnItemSelectedListener;
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    this.x = paramInt;
    this.y = a(paramInt);
  }
  
  public abstract void setSelection(int paramInt);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */