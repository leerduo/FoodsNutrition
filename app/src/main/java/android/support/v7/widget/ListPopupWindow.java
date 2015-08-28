package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow
{
  private static Method a;
  private Handler A = new Handler();
  private Rect B = new Rect();
  private boolean C;
  private int D;
  int b = 2147483647;
  private Context c;
  private PopupWindow d;
  private ListAdapter e;
  private ListPopupWindow.DropDownListView f;
  private int g = -2;
  private int h = -2;
  private int i;
  private int j;
  private boolean k;
  private int l = 0;
  private boolean m = false;
  private boolean n = false;
  private View o;
  private int p = 0;
  private DataSetObserver q;
  private View r;
  private Drawable s;
  private AdapterView.OnItemClickListener t;
  private AdapterView.OnItemSelectedListener u;
  private final ListPopupWindow.ResizePopupRunnable v = new ListPopupWindow.ResizePopupRunnable(this, null);
  private final ListPopupWindow.PopupTouchInterceptor w = new ListPopupWindow.PopupTouchInterceptor(this, null);
  private final ListPopupWindow.PopupScrollListener x = new ListPopupWindow.PopupScrollListener(this, null);
  private final ListPopupWindow.ListSelectorHider y = new ListPopupWindow.ListSelectorHider(this, null);
  private Runnable z;
  
  static
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", arrayOfClass);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.i = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.j = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.j != 0) {
      this.k = true;
    }
    localTypedArray.recycle();
    this.d = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1);
    this.d.setInputMethodMode(1);
    this.D = TextUtilsCompat.getLayoutDirectionFromLocale(this.c.getResources().getConfiguration().locale);
  }
  
  private void b(boolean paramBoolean)
  {
    if (a != null) {}
    try
    {
      Method localMethod = a;
      PopupWindow localPopupWindow = this.d;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(localPopupWindow, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
    }
  }
  
  private void h()
  {
    if (this.o != null)
    {
      ViewParent localViewParent = this.o.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.o);
      }
    }
  }
  
  private int i()
  {
    boolean bool;
    ListPopupWindow.DropDownListView localDropDownListView;
    View localView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams2;
    label253:
    int i7;
    Object localObject;
    if (this.f == null)
    {
      Context localContext = this.c;
      this.z = new ListPopupWindow.2(this);
      if (!this.C)
      {
        bool = true;
        this.f = new ListPopupWindow.DropDownListView(localContext, bool);
        if (this.s != null) {
          this.f.setSelector(this.s);
        }
        this.f.setAdapter(this.e);
        this.f.setOnItemClickListener(this.t);
        this.f.setFocusable(true);
        this.f.setFocusableInTouchMode(true);
        this.f.setOnItemSelectedListener(new ListPopupWindow.3(this));
        this.f.setOnScrollListener(this.x);
        if (this.u != null) {
          this.f.setOnItemSelectedListener(this.u);
        }
        localDropDownListView = this.f;
        localView2 = this.o;
        if (localView2 == null) {
          break label697;
        }
        localLinearLayout = new LinearLayout(localContext);
        localLinearLayout.setOrientation(1);
        localLayoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.p)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + this.p);
          localView2.measure(View.MeasureSpec.makeMeasureSpec(this.h, -2147483648), 0);
          LinearLayout.LayoutParams localLayoutParams3 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
          i7 = localView2.getMeasuredHeight() + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin;
          localObject = localLinearLayout;
        }
      }
    }
    for (;;)
    {
      this.d.setContentView((View)localObject);
      int i1 = i7;
      for (;;)
      {
        label314:
        Drawable localDrawable = this.d.getBackground();
        int i6;
        int i2;
        if (localDrawable != null)
        {
          localDrawable.getPadding(this.B);
          i6 = this.B.top + this.B.bottom;
          if (this.k) {
            break label685;
          }
          this.j = (-this.B.top);
          i2 = i6;
        }
        for (;;)
        {
          if (this.d.getInputMethodMode() == 2) {}
          int i3 = this.d.getMaxAvailableHeight(d(), this.j);
          if ((this.m) || (this.g == -1))
          {
            return i3 + i2;
            bool = false;
            break;
            localLinearLayout.addView(localDropDownListView, localLayoutParams2);
            localLinearLayout.addView(localView2);
            break label253;
            localLinearLayout.addView(localView2);
            localLinearLayout.addView(localDropDownListView, localLayoutParams2);
            break label253;
            ((ViewGroup)this.d.getContentView());
            View localView1 = this.o;
            if (localView1 == null) {
              break label692;
            }
            LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localView1.getLayoutParams();
            i1 = localView1.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin;
            break label314;
            this.B.setEmpty();
            i2 = 0;
            continue;
          }
          int i4;
          switch (this.h)
          {
          default: 
            i4 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
          }
          for (;;)
          {
            int i5 = this.f.a(i4, 0, -1, i3 - i1, -1);
            if (i5 > 0) {
              i1 += i2;
            }
            return i5 + i1;
            i4 = View.MeasureSpec.makeMeasureSpec(this.c.getResources().getDisplayMetrics().widthPixels - (this.B.left + this.B.right), -2147483648);
            continue;
            i4 = View.MeasureSpec.makeMeasureSpec(this.c.getResources().getDisplayMetrics().widthPixels - (this.B.left + this.B.right), 1073741824);
          }
          label685:
          i2 = i6;
        }
        label692:
        i1 = 0;
      }
      label697:
      localObject = localDropDownListView;
      i7 = 0;
    }
  }
  
  public void a()
  {
    this.d.dismiss();
    h();
    this.d.setContentView(null);
    this.f = null;
    this.A.removeCallbacks(this.v);
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.d.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.r = paramView;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.t = paramOnItemClickListener;
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    if (this.q == null) {
      this.q = new ListPopupWindow.PopupDataSetObserver(this, null);
    }
    for (;;)
    {
      this.e = paramListAdapter;
      if (this.e != null) {
        paramListAdapter.registerDataSetObserver(this.q);
      }
      if (this.f != null) {
        this.f.setAdapter(this.e);
      }
      return;
      if (this.e != null) {
        this.e.unregisterDataSetObserver(this.q);
      }
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.d.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
    this.d.setFocusable(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public boolean b()
  {
    return this.d.isShowing();
  }
  
  public void c()
  {
    boolean bool1 = true;
    int i1 = -1;
    int i2 = i();
    boolean bool2 = f();
    if (this.d.isShowing())
    {
      int i5;
      if (this.h == i1)
      {
        i5 = i1;
        if (this.g != i1) {
          break label216;
        }
        if (!bool2) {
          break label172;
        }
        label49:
        if (!bool2) {
          break label182;
        }
        PopupWindow localPopupWindow4 = this.d;
        if (this.h != i1) {
          break label177;
        }
        label68:
        localPopupWindow4.setWindowLayoutMode(i1, 0);
      }
      for (;;)
      {
        PopupWindow localPopupWindow2 = this.d;
        boolean bool3 = this.n;
        boolean bool4 = false;
        if (!bool3)
        {
          boolean bool5 = this.m;
          bool4 = false;
          if (!bool5) {
            bool4 = bool1;
          }
        }
        localPopupWindow2.setOutsideTouchable(bool4);
        this.d.update(d(), this.i, this.j, i5, i2);
        return;
        if (this.h == -2)
        {
          i5 = d().getWidth();
          break;
        }
        i5 = this.h;
        break;
        label172:
        i2 = i1;
        break label49;
        label177:
        i1 = 0;
        break label68;
        label182:
        PopupWindow localPopupWindow3 = this.d;
        if (this.h == i1) {}
        for (int i6 = i1;; i6 = 0)
        {
          localPopupWindow3.setWindowLayoutMode(i6, i1);
          break;
        }
        label216:
        if (this.g != -2) {
          i2 = this.g;
        }
      }
    }
    int i3;
    label244:
    int i4;
    label255:
    PopupWindow localPopupWindow1;
    if (this.h == i1)
    {
      i3 = i1;
      if (this.g != i1) {
        break label426;
      }
      i4 = i1;
      this.d.setWindowLayoutMode(i3, i4);
      b(bool1);
      localPopupWindow1 = this.d;
      if ((this.n) || (this.m)) {
        break label466;
      }
    }
    for (;;)
    {
      localPopupWindow1.setOutsideTouchable(bool1);
      this.d.setTouchInterceptor(this.w);
      PopupWindowCompat.showAsDropDown(this.d, d(), this.i, this.j, this.l);
      this.f.setSelection(i1);
      if ((!this.C) || (this.f.isInTouchMode())) {
        e();
      }
      if (this.C) {
        break;
      }
      this.A.post(this.y);
      return;
      if (this.h == -2)
      {
        this.d.setWidth(d().getWidth());
        i3 = 0;
        break label244;
      }
      this.d.setWidth(this.h);
      i3 = 0;
      break label244;
      label426:
      if (this.g == -2)
      {
        this.d.setHeight(i2);
        i4 = 0;
        break label255;
      }
      this.d.setHeight(this.g);
      i4 = 0;
      break label255;
      label466:
      bool1 = false;
    }
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public View d()
  {
    return this.r;
  }
  
  public void d(int paramInt)
  {
    Drawable localDrawable = this.d.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.B);
      this.h = (paramInt + (this.B.left + this.B.right));
      return;
    }
    c(paramInt);
  }
  
  public void e()
  {
    ListPopupWindow.DropDownListView localDropDownListView = this.f;
    if (localDropDownListView != null)
    {
      ListPopupWindow.DropDownListView.a(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }
  
  public void e(int paramInt)
  {
    this.d.setInputMethodMode(paramInt);
  }
  
  public boolean f()
  {
    return this.d.getInputMethodMode() == 2;
  }
  
  public ListView g()
  {
    return this.f;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */