package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  private MenuBuilder a;
  private Context b;
  private Context c;
  private int d;
  private boolean e;
  private ActionMenuPresenter f;
  private MenuPresenter.Callback g;
  private MenuBuilder.Callback h;
  private boolean i;
  private int j;
  private int k;
  private int l;
  private ActionMenuView.OnMenuItemClickListener m;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    setBaselineAligned(false);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.k = ((int)(56.0F * f1));
    this.l = ((int)(f1 * 4.0F));
    this.c = paramContext;
    this.d = 0;
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)paramView.getLayoutParams();
    int n = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    int i1;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.b())) {
        break label182;
      }
      i1 = 1;
      label54:
      if ((paramInt2 <= 0) || ((i1 != 0) && (paramInt2 < 2))) {
        break label188;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, -2147483648), n);
      int i3 = paramView.getMeasuredWidth();
      i2 = i3 / paramInt1;
      if (i3 % paramInt1 != 0) {
        i2++;
      }
      if ((i1 == 0) || (i2 >= 2)) {}
    }
    label182:
    label188:
    for (int i2 = 2;; i2 = 0)
    {
      boolean bool1 = localLayoutParams.a;
      boolean bool2 = false;
      if (!bool1)
      {
        bool2 = false;
        if (i1 != 0) {
          bool2 = true;
        }
      }
      localLayoutParams.d = bool2;
      localLayoutParams.b = i2;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(i2 * paramInt1, 1073741824), n);
      return i2;
      localActionMenuItemView = null;
      break;
      i1 = 0;
      break label54;
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i3 = getPaddingLeft() + getPaddingRight();
    int i4 = getPaddingTop() + getPaddingBottom();
    int i5 = getChildMeasureSpec(paramInt2, i4, -2);
    int i6 = i1 - i3;
    int i7 = i6 / this.k;
    int i8 = i6 % this.k;
    if (i7 == 0)
    {
      setMeasuredDimension(i6, 0);
      return;
    }
    int i9 = this.k + i8 / i7;
    int i10 = 0;
    int i11 = 0;
    int i12 = 0;
    int i13 = 0;
    int i14 = 0;
    long l1 = 0L;
    int i15 = getChildCount();
    int i16 = 0;
    View localView4;
    int i45;
    long l8;
    int i47;
    int i48;
    int i46;
    int i36;
    ActionMenuView.LayoutParams localLayoutParams5;
    boolean bool2;
    label295:
    int i37;
    label313:
    int i38;
    int i39;
    for (;;)
    {
      if (i16 < i15)
      {
        localView4 = getChildAt(i16);
        if (localView4.getVisibility() == 8)
        {
          i45 = i13;
          l8 = l1;
          i47 = i10;
          i48 = i7;
          i46 = i11;
          i16++;
          i11 = i46;
          i10 = i47;
          i7 = i48;
          l1 = l8;
          i13 = i45;
        }
        else
        {
          boolean bool1 = localView4 instanceof ActionMenuItemView;
          i36 = i13 + 1;
          if (bool1) {
            localView4.setPadding(this.l, 0, this.l, 0);
          }
          localLayoutParams5 = (ActionMenuView.LayoutParams)localView4.getLayoutParams();
          localLayoutParams5.f = false;
          localLayoutParams5.c = 0;
          localLayoutParams5.b = 0;
          localLayoutParams5.d = false;
          localLayoutParams5.leftMargin = 0;
          localLayoutParams5.rightMargin = 0;
          if ((bool1) && (((ActionMenuItemView)localView4).b()))
          {
            bool2 = true;
            localLayoutParams5.e = bool2;
            if (!localLayoutParams5.a) {
              break label438;
            }
            i37 = 1;
            i38 = a(localView4, i9, i37, i5, i4);
            i39 = Math.max(i11, i38);
            if (!localLayoutParams5.d) {
              break label1328;
            }
          }
        }
      }
    }
    label530:
    label550:
    label1328:
    for (int i40 = i12 + 1;; i40 = i12)
    {
      if (localLayoutParams5.a) {}
      for (int i41 = 1;; i41 = i14)
      {
        int i42 = i7 - i38;
        int i43 = localView4.getMeasuredHeight();
        int i44 = Math.max(i10, i43);
        label438:
        label613:
        label1254:
        if (i38 == 1)
        {
          long l9 = l1 | 1 << i16;
          i47 = i44;
          i48 = i42;
          i12 = i40;
          i14 = i41;
          l8 = l9;
          i46 = i39;
          i45 = i36;
          break;
          bool2 = false;
          break label295;
          i37 = i7;
          break label313;
          int i17;
          int i18;
          long l2;
          int i19;
          int i27;
          long l4;
          int i28;
          int i29;
          label493:
          ActionMenuView.LayoutParams localLayoutParams4;
          int i34;
          int i35;
          if ((i14 != 0) && (i13 == 2))
          {
            i17 = 1;
            i18 = 0;
            l2 = l1;
            i19 = i7;
            if ((i12 <= 0) || (i19 <= 0)) {
              break label1279;
            }
            i27 = 2147483647;
            l4 = 0L;
            i28 = 0;
            i29 = 0;
            if (i29 >= i15) {
              break label613;
            }
            localLayoutParams4 = (ActionMenuView.LayoutParams)getChildAt(i29).getLayoutParams();
            if (localLayoutParams4.d) {
              break label550;
            }
            i34 = i28;
            i35 = i27;
          }
          for (;;)
          {
            i29++;
            i27 = i35;
            i28 = i34;
            break label493;
            i17 = 0;
            break;
            if (localLayoutParams4.b < i27)
            {
              i35 = localLayoutParams4.b;
              l4 = 1 << i29;
              i34 = 1;
            }
            else
            {
              if (localLayoutParams4.b != i27) {
                break label1268;
              }
              l4 |= 1 << i29;
              i34 = i28 + 1;
              i35 = i27;
            }
          }
          long l5 = l2 | l4;
          if (i28 > i19) {}
          label1002:
          label1261:
          label1268:
          label1279:
          for (long l3 = l5;; l3 = l2)
          {
            int i20;
            float f1;
            float f2;
            int i24;
            int i25;
            int i21;
            int i26;
            int i31;
            int i32;
            long l6;
            View localView3;
            ActionMenuView.LayoutParams localLayoutParams3;
            int i33;
            if ((i14 == 0) && (i13 == 1))
            {
              i20 = 1;
              if ((i19 <= 0) || (l3 == 0L)) {
                break label1152;
              }
              int i23 = i13 - 1;
              if ((i19 >= i23) && (i20 == 0) && (i11 <= 1)) {
                break label1152;
              }
              f1 = Long.bitCount(l3);
              if (i20 != 0) {
                break label1254;
              }
              if (((1L & l3) != 0L) && (!((ActionMenuView.LayoutParams)getChildAt(0).getLayoutParams()).e)) {
                f1 -= 0.5F;
              }
              if (((l3 & 1 << i15 - 1) == 0L) || (((ActionMenuView.LayoutParams)getChildAt(i15 - 1).getLayoutParams()).e)) {
                break label1254;
              }
              f2 = f1 - 0.5F;
              if (f2 <= 0.0F) {
                break label1002;
              }
              i24 = (int)(i19 * i9 / f2);
              i25 = 0;
              i21 = i18;
              for (;;)
              {
                if (i25 < i15) {
                  if ((l3 & 1 << i25) == 0L)
                  {
                    i26 = i21;
                    i25++;
                    i21 = i26;
                    continue;
                    int i30 = i27 + 1;
                    i31 = 0;
                    i32 = i19;
                    l6 = l5;
                    if (i31 < i15)
                    {
                      localView3 = getChildAt(i31);
                      localLayoutParams3 = (ActionMenuView.LayoutParams)localView3.getLayoutParams();
                      if ((l4 & 1 << i31) == 0L)
                      {
                        if (localLayoutParams3.b != i30) {
                          break label1261;
                        }
                        l6 |= 1 << i31;
                        i33 = i32;
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              i31++;
              i32 = i33;
              break label846;
              if ((i17 != 0) && (localLayoutParams3.e) && (i32 == 1)) {
                localView3.setPadding(i9 + this.l, 0, this.l, 0);
              }
              localLayoutParams3.b = (1 + localLayoutParams3.b);
              localLayoutParams3.f = true;
              i33 = i32 - 1;
              continue;
              l2 = l6;
              i18 = 1;
              i19 = i32;
              break;
              i20 = 0;
              break label645;
              i24 = 0;
              break label788;
              View localView2 = getChildAt(i25);
              ActionMenuView.LayoutParams localLayoutParams2 = (ActionMenuView.LayoutParams)localView2.getLayoutParams();
              if ((localView2 instanceof ActionMenuItemView))
              {
                localLayoutParams2.c = i24;
                localLayoutParams2.f = true;
                if ((i25 == 0) && (!localLayoutParams2.e)) {
                  localLayoutParams2.leftMargin = (-i24 / 2);
                }
                i26 = 1;
                break label819;
              }
              if (localLayoutParams2.a)
              {
                localLayoutParams2.c = i24;
                localLayoutParams2.f = true;
                localLayoutParams2.rightMargin = (-i24 / 2);
                i26 = 1;
                break label819;
              }
              if (i25 != 0) {
                localLayoutParams2.leftMargin = (i24 / 2);
              }
              if (i25 != i15 - 1) {
                localLayoutParams2.rightMargin = (i24 / 2);
              }
              i26 = i21;
              break label819;
              i21 = i18;
              if (i21 != 0)
              {
                int i22 = 0;
                if (i22 < i15)
                {
                  View localView1 = getChildAt(i22);
                  ActionMenuView.LayoutParams localLayoutParams1 = (ActionMenuView.LayoutParams)localView1.getLayoutParams();
                  if (!localLayoutParams1.f) {}
                  for (;;)
                  {
                    i22++;
                    break;
                    localView1.measure(View.MeasureSpec.makeMeasureSpec(i9 * localLayoutParams1.b + localLayoutParams1.c, 1073741824), i5);
                  }
                }
              }
              if (n != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i6, i10);
                return;
                i10 = i2;
              }
              f2 = f1;
              break label769;
              i33 = i32;
            }
            i34 = i28;
            i35 = i27;
            break label530;
          }
        }
        label819:
        label846:
        i45 = i36;
        i46 = i39;
        long l7 = l1;
        i47 = i44;
        i48 = i42;
        i14 = i41;
        i12 = i40;
        l8 = l7;
        break;
      }
    }
  }
  
  public ActionMenuView.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new ActionMenuView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ActionMenuView.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof ActionMenuView.LayoutParams)) {}
      for (ActionMenuView.LayoutParams localLayoutParams = new ActionMenuView.LayoutParams((ActionMenuView.LayoutParams)paramLayoutParams);; localLayoutParams = new ActionMenuView.LayoutParams(paramLayoutParams))
      {
        if (localLayoutParams.h <= 0) {
          localLayoutParams.h = 16;
        }
        return localLayoutParams;
      }
    }
    return b();
  }
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    this.a = paramMenuBuilder;
  }
  
  public void a(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.g = paramCallback;
    this.h = paramCallback1;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  protected boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    int n = getChildCount();
    boolean bool1 = false;
    if (paramInt < n)
    {
      boolean bool2 = localView1 instanceof ActionMenuView.ActionMenuChildView;
      bool1 = false;
      if (bool2) {
        bool1 = false | ((ActionMenuView.ActionMenuChildView)localView1).d();
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof ActionMenuView.ActionMenuChildView))) {
      return bool1 | ((ActionMenuView.ActionMenuChildView)localView2).c();
    }
    return bool1;
  }
  
  public boolean a(MenuItemImpl paramMenuItemImpl)
  {
    return this.a.a(paramMenuItemImpl, 0);
  }
  
  protected ActionMenuView.LayoutParams b()
  {
    ActionMenuView.LayoutParams localLayoutParams = new ActionMenuView.LayoutParams(-2, -2);
    localLayoutParams.h = 16;
    return localLayoutParams;
  }
  
  public ActionMenuView.LayoutParams c()
  {
    ActionMenuView.LayoutParams localLayoutParams = b();
    localLayoutParams.a = true;
    return localLayoutParams;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof ActionMenuView.LayoutParams));
  }
  
  public MenuBuilder d()
  {
    return this.a;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public boolean e()
  {
    return (this.f != null) && (this.f.c());
  }
  
  public boolean f()
  {
    return (this.f != null) && (this.f.d());
  }
  
  public boolean g()
  {
    return (this.f != null) && (this.f.g());
  }
  
  public Menu getMenu()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (this.a == null)
    {
      Context localContext = getContext();
      this.a = new MenuBuilder(localContext);
      this.a.a(new ActionMenuView.MenuBuilderCallback(this, null));
      this.f = new ActionMenuPresenter(localContext);
      this.f.b(true);
      localActionMenuPresenter = this.f;
      if (this.g == null) {
        break label110;
      }
    }
    label110:
    for (Object localObject = this.g;; localObject = new ActionMenuView.ActionMenuPresenterCallback(this, null))
    {
      localActionMenuPresenter.a((MenuPresenter.Callback)localObject);
      this.a.a(this.f, this.c);
      this.f.a(this);
      return this.a;
    }
  }
  
  public int getPopupTheme()
  {
    return this.d;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public boolean h()
  {
    return (this.f != null) && (this.f.h());
  }
  
  public void i()
  {
    if (this.f != null) {
      this.f.e();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.f.a(false);
    if ((this.f != null) && (this.f.g()))
    {
      this.f.d();
      this.f.c();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    i();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.i)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int n = getChildCount();
    int i1 = (paramInt4 - paramInt2) / 2;
    int i2 = getDividerWidth();
    int i3 = 0;
    int i4 = 0;
    int i5 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int i6 = 0;
    boolean bool = ViewUtils.a(this);
    int i7 = 0;
    if (i7 < n)
    {
      View localView4 = getChildAt(i7);
      int i38;
      int i36;
      int i35;
      int i37;
      if (localView4.getVisibility() == 8)
      {
        i38 = i6;
        i36 = i4;
        i35 = i5;
        i37 = i3;
      }
      for (;;)
      {
        i7++;
        i3 = i37;
        i5 = i35;
        i4 = i36;
        i6 = i38;
        break;
        ActionMenuView.LayoutParams localLayoutParams3 = (ActionMenuView.LayoutParams)localView4.getLayoutParams();
        if (localLayoutParams3.a)
        {
          int i39 = localView4.getMeasuredWidth();
          if (a(i7)) {
            i39 += i2;
          }
          int i40 = localView4.getMeasuredHeight();
          int i42;
          int i41;
          if (bool)
          {
            i42 = getPaddingLeft() + localLayoutParams3.leftMargin;
            i41 = i42 + i39;
          }
          for (;;)
          {
            int i43 = i1 - i40 / 2;
            localView4.layout(i42, i43, i41, i40 + i43);
            i35 = i5 - i39;
            i38 = 1;
            i36 = i4;
            i37 = i3;
            break;
            i41 = getWidth() - getPaddingRight() - localLayoutParams3.rightMargin;
            i42 = i41 - i39;
          }
        }
        int i30 = localView4.getMeasuredWidth() + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin;
        int i31 = i3 + i30;
        int i32 = i5 - i30;
        if (a(i7)) {
          i31 += i2;
        }
        int i33 = i4 + 1;
        int i34 = i6;
        i35 = i32;
        i36 = i33;
        i37 = i31;
        i38 = i34;
      }
    }
    if ((n == 1) && (i6 == 0))
    {
      View localView3 = getChildAt(0);
      int i26 = localView3.getMeasuredWidth();
      int i27 = localView3.getMeasuredHeight();
      int i28 = (paramInt3 - paramInt1) / 2 - i26 / 2;
      int i29 = i1 - i27 / 2;
      localView3.layout(i28, i29, i26 + i28, i27 + i29);
      return;
    }
    int i8;
    label441:
    int i10;
    label460:
    int i11;
    int i19;
    int i20;
    label487:
    View localView2;
    ActionMenuView.LayoutParams localLayoutParams2;
    int i21;
    if (i6 != 0)
    {
      i8 = 0;
      int i9 = i4 - i8;
      if (i9 <= 0) {
        break label550;
      }
      i10 = i5 / i9;
      i11 = Math.max(0, i10);
      if (!bool) {
        break label627;
      }
      i19 = getWidth() - getPaddingRight();
      i20 = 0;
      if (i20 < n)
      {
        localView2 = getChildAt(i20);
        localLayoutParams2 = (ActionMenuView.LayoutParams)localView2.getLayoutParams();
        if (localView2.getVisibility() == 8) {
          break label771;
        }
        if (!localLayoutParams2.a) {
          break label556;
        }
        i21 = i19;
      }
    }
    for (;;)
    {
      i20++;
      i19 = i21;
      break label487;
      break;
      i8 = 1;
      break label441;
      label550:
      i10 = 0;
      break label460;
      label556:
      int i22 = i19 - localLayoutParams2.rightMargin;
      int i23 = localView2.getMeasuredWidth();
      int i24 = localView2.getMeasuredHeight();
      int i25 = i1 - i24 / 2;
      localView2.layout(i22 - i23, i25, i22, i24 + i25);
      i21 = i22 - (i11 + (i23 + localLayoutParams2.leftMargin));
      continue;
      label627:
      int i12 = getPaddingLeft();
      int i13 = 0;
      label636:
      View localView1;
      ActionMenuView.LayoutParams localLayoutParams1;
      int i14;
      if (i13 < n)
      {
        localView1 = getChildAt(i13);
        localLayoutParams1 = (ActionMenuView.LayoutParams)localView1.getLayoutParams();
        if (localView1.getVisibility() == 8) {
          break label764;
        }
        if (!localLayoutParams1.a) {
          break label693;
        }
        i14 = i12;
      }
      for (;;)
      {
        i13++;
        i12 = i14;
        break label636;
        break;
        label693:
        int i15 = i12 + localLayoutParams1.leftMargin;
        int i16 = localView1.getMeasuredWidth();
        int i17 = localView1.getMeasuredHeight();
        int i18 = i1 - i17 / 2;
        localView1.layout(i15, i18, i15 + i16, i17 + i18);
        i14 = i15 + (i11 + (i16 + localLayoutParams1.rightMargin));
        continue;
        label764:
        i14 = i12;
      }
      label771:
      i21 = i19;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool1 = this.i;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    int i1;
    for (boolean bool2 = true;; bool2 = false)
    {
      this.i = bool2;
      if (bool1 != this.i) {
        this.j = 0;
      }
      int n = View.MeasureSpec.getSize(paramInt1);
      if ((this.i) && (this.a != null) && (n != this.j))
      {
        this.j = n;
        this.a.b(true);
      }
      i1 = getChildCount();
      if ((!this.i) || (i1 <= 0)) {
        break;
      }
      c(paramInt1, paramInt2);
      return;
    }
    for (int i2 = 0; i2 < i1; i2++)
    {
      ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)getChildAt(i2).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.f.c(paramBoolean);
  }
  
  public void setOnMenuItemClickListener(ActionMenuView.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.m = paramOnMenuItemClickListener;
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      if (paramInt == 0) {
        this.c = this.b;
      }
    }
    else
    {
      return;
    }
    this.c = new ContextThemeWrapper(this.b, paramInt);
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.f = paramActionMenuPresenter;
    this.f.a(this);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */