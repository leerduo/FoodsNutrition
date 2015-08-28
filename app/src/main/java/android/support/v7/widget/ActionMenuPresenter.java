package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.R.integer;
import android.support.v7.appcompat.R.layout;
import android.support.v7.internal.transition.ActionBarTransition;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  final ActionMenuPresenter.PopupPresenterCallback g = new ActionMenuPresenter.PopupPresenterCallback(this, null);
  int h;
  private View i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private int s;
  private final SparseBooleanArray t = new SparseBooleanArray();
  private View u;
  private ActionMenuPresenter.OverflowPopup v;
  private ActionMenuPresenter.ActionButtonSubmenu w;
  private ActionMenuPresenter.OpenOverflowRunnable x;
  private ActionMenuPresenter.ActionMenuPopupCallback y;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View a(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.f;
    View localView;
    if (localViewGroup == null)
    {
      localView = null;
      return localView;
    }
    int i1 = localViewGroup.getChildCount();
    for (int i2 = 0;; i2++)
    {
      if (i2 >= i1) {
        break label68;
      }
      localView = localViewGroup.getChildAt(i2);
      if (((localView instanceof MenuView.ItemView)) && (((MenuView.ItemView)localView).getItemData() == paramMenuItem)) {
        break;
      }
    }
    label68:
    return null;
  }
  
  public MenuView a(ViewGroup paramViewGroup)
  {
    MenuView localMenuView = super.a(paramViewGroup);
    ((ActionMenuView)localMenuView).setPresenter(this);
    return localMenuView;
  }
  
  public View a(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.m())) {
      localView = super.a(paramMenuItemImpl, paramView, paramViewGroup);
    }
    if (paramMenuItemImpl.isActionViewExpanded()) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      ActionMenuView localActionMenuView = (ActionMenuView)paramViewGroup;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if (!localActionMenuView.checkLayoutParams(localLayoutParams)) {
        localView.setLayoutParams(localActionMenuView.a(localLayoutParams));
      }
      return localView;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.l = paramInt;
    this.p = paramBoolean;
    this.q = true;
  }
  
  public void a(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    super.a(paramContext, paramMenuBuilder);
    Resources localResources = paramContext.getResources();
    ActionBarPolicy localActionBarPolicy = ActionBarPolicy.a(paramContext);
    if (!this.k) {
      this.j = localActionBarPolicy.b();
    }
    if (!this.q) {
      this.l = localActionBarPolicy.c();
    }
    if (!this.o) {
      this.n = localActionBarPolicy.a();
    }
    int i1 = this.l;
    if (this.j)
    {
      if (this.i == null)
      {
        this.i = new ActionMenuPresenter.OverflowMenuButton(this, this.a);
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.i.measure(i2, i2);
      }
      i1 -= this.i.getMeasuredWidth();
    }
    for (;;)
    {
      this.m = i1;
      this.s = ((int)(56.0F * localResources.getDisplayMetrics().density));
      this.u = null;
      return;
      this.i = null;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (!this.o) {
      this.n = this.b.getResources().getInteger(R.integer.abc_max_action_buttons);
    }
    if (this.c != null) {
      this.c.b(true);
    }
  }
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    e();
    super.a(paramMenuBuilder, paramBoolean);
  }
  
  public void a(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.a(paramMenuItemImpl, 0);
    ActionMenuView localActionMenuView = (ActionMenuView)this.f;
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)paramItemView;
    localActionMenuItemView.setItemInvoker(localActionMenuView);
    if (this.y == null) {
      this.y = new ActionMenuPresenter.ActionMenuPopupCallback(this, null);
    }
    localActionMenuItemView.setPopupCallback(this.y);
  }
  
  public void a(ActionMenuView paramActionMenuView)
  {
    this.f = paramActionMenuView;
    paramActionMenuView.a(this.c);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 1;
    ViewGroup localViewGroup1 = (ViewGroup)((View)this.f).getParent();
    if (localViewGroup1 != null) {
      ActionBarTransition.a(localViewGroup1);
    }
    super.a(paramBoolean);
    ((View)this.f).requestLayout();
    if (this.c != null)
    {
      ArrayList localArrayList2 = this.c.k();
      int i5 = localArrayList2.size();
      for (int i6 = 0; i6 < i5; i6++)
      {
        ActionProvider localActionProvider = ((MenuItemImpl)localArrayList2.get(i6)).getSupportActionProvider();
        if (localActionProvider != null) {
          localActionProvider.setSubUiVisibilityListener(this);
        }
      }
    }
    ArrayList localArrayList1;
    int i2;
    int i3;
    int i4;
    if (this.c != null)
    {
      localArrayList1 = this.c.l();
      boolean bool = this.j;
      i2 = 0;
      if (bool)
      {
        i2 = 0;
        if (localArrayList1 != null)
        {
          i3 = localArrayList1.size();
          if (i3 != i1) {
            break label290;
          }
          if (((MenuItemImpl)localArrayList1.get(0)).isActionViewExpanded()) {
            break label284;
          }
          i4 = i1;
          label173:
          i2 = i4;
        }
      }
      if (i2 == 0) {
        break label306;
      }
      if (this.i == null) {
        this.i = new ActionMenuPresenter.OverflowMenuButton(this, this.a);
      }
      ViewGroup localViewGroup2 = (ViewGroup)this.i.getParent();
      if (localViewGroup2 != this.f)
      {
        if (localViewGroup2 != null) {
          localViewGroup2.removeView(this.i);
        }
        ActionMenuView localActionMenuView = (ActionMenuView)this.f;
        localActionMenuView.addView(this.i, localActionMenuView.c());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.f).setOverflowReserved(this.j);
      return;
      localArrayList1 = null;
      break;
      label284:
      i4 = 0;
      break label173;
      label290:
      if (i3 > 0) {}
      for (;;)
      {
        i2 = i1;
        break;
        i1 = 0;
      }
      label306:
      if ((this.i != null) && (this.i.getParent() == this.f)) {
        ((ViewGroup)this.f).removeView(this.i);
      }
    }
  }
  
  public boolean a(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.i();
  }
  
  public boolean a(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return false;
    }
    for (SubMenuBuilder localSubMenuBuilder = paramSubMenuBuilder; localSubMenuBuilder.s() != this.c; localSubMenuBuilder = (SubMenuBuilder)localSubMenuBuilder.s()) {}
    View localView = a(localSubMenuBuilder.getItem());
    if (localView == null)
    {
      if (this.i == null) {
        return false;
      }
      localView = this.i;
    }
    this.h = paramSubMenuBuilder.getItem().getItemId();
    this.w = new ActionMenuPresenter.ActionButtonSubmenu(this, this.b, paramSubMenuBuilder);
    this.w.a(localView);
    this.w.a();
    super.a(paramSubMenuBuilder);
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.i) {
      return false;
    }
    return super.a(paramViewGroup, paramInt);
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
    this.o = true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.k = true;
  }
  
  public boolean b()
  {
    ArrayList localArrayList = this.c.i();
    int i1 = localArrayList.size();
    int i2 = this.n;
    int i3 = this.m;
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)this.f;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    MenuItemImpl localMenuItemImpl3;
    if (i8 < i1)
    {
      localMenuItemImpl3 = (MenuItemImpl)localArrayList.get(i8);
      if (localMenuItemImpl3.k())
      {
        i5++;
        label80:
        if ((!this.r) || (!localMenuItemImpl3.isActionViewExpanded())) {
          break label830;
        }
      }
    }
    label291:
    label428:
    label814:
    label830:
    for (int i36 = 0;; i36 = i2)
    {
      i8++;
      i2 = i36;
      break;
      if (localMenuItemImpl3.j())
      {
        i6++;
        break label80;
      }
      i7 = 1;
      break label80;
      if ((this.j) && ((i7 != 0) || (i5 + i6 > i2))) {
        i2--;
      }
      int i9 = i2 - i5;
      SparseBooleanArray localSparseBooleanArray = this.t;
      localSparseBooleanArray.clear();
      int i10;
      int i35;
      if (this.p)
      {
        i10 = i3 / this.s;
        i35 = i3 % this.s;
      }
      for (int i11 = this.s + i35 / i10;; i11 = 0)
      {
        int i12 = 0;
        int i13 = 0;
        int i14 = i10;
        MenuItemImpl localMenuItemImpl1;
        View localView2;
        int i15;
        int i33;
        if (i12 < i1)
        {
          localMenuItemImpl1 = (MenuItemImpl)localArrayList.get(i12);
          if (localMenuItemImpl1.k())
          {
            localView2 = a(localMenuItemImpl1, this.u, localViewGroup);
            if (this.u == null) {
              this.u = localView2;
            }
            if (this.p)
            {
              i14 -= ActionMenuView.a(localView2, i11, i14, i4, 0);
              i15 = localView2.getMeasuredWidth();
              i33 = i3 - i15;
              if (i13 != 0) {
                break label814;
              }
            }
          }
        }
        for (;;)
        {
          int i34 = localMenuItemImpl1.getGroupId();
          if (i34 != 0) {
            localSparseBooleanArray.put(i34, true);
          }
          localMenuItemImpl1.d(true);
          int i16 = i33;
          int i17 = i9;
          i12++;
          i3 = i16;
          i9 = i17;
          i13 = i15;
          break;
          localView2.measure(i4, i4);
          break label291;
          int i18;
          boolean bool1;
          boolean bool2;
          View localView1;
          int i27;
          label496:
          int i26;
          label500:
          int i30;
          boolean bool3;
          int i19;
          int i20;
          if (localMenuItemImpl1.j())
          {
            i18 = localMenuItemImpl1.getGroupId();
            bool1 = localSparseBooleanArray.get(i18);
            if (((i9 > 0) || (bool1)) && (i3 > 0) && ((!this.p) || (i14 > 0)))
            {
              bool2 = true;
              if (!bool2) {
                break label799;
              }
              localView1 = a(localMenuItemImpl1, this.u, localViewGroup);
              if (this.u == null) {
                this.u = localView1;
              }
              if (!this.p) {
                break label619;
              }
              int i31 = ActionMenuView.a(localView1, i11, i14, i4, 0);
              int i32 = i14 - i31;
              if (i31 != 0) {
                break label792;
              }
              i27 = 0;
              i26 = i32;
              int i28 = localView1.getMeasuredWidth();
              i3 -= i28;
              if (i13 == 0) {
                i13 = i28;
              }
              if (!this.p) {
                break label649;
              }
              if (i3 < 0) {
                break label643;
              }
              i30 = 1;
              bool3 = i27 & i30;
              i19 = i13;
              i20 = i26;
            }
          }
          for (;;)
          {
            int i21;
            if ((bool3) && (i18 != 0))
            {
              localSparseBooleanArray.put(i18, true);
              i21 = i9;
            }
            for (;;)
            {
              if (bool3) {
                i21--;
              }
              localMenuItemImpl1.d(bool3);
              i15 = i19;
              i16 = i3;
              int i22 = i20;
              i17 = i21;
              i14 = i22;
              break;
              bool2 = false;
              break label428;
              label619:
              localView1.measure(i4, i4);
              int i25 = bool2;
              i26 = i14;
              i27 = i25;
              break label500;
              i30 = 0;
              break label538;
              if (i3 + i13 > 0) {}
              for (int i29 = 1;; i29 = 0)
              {
                bool3 = i27 & i29;
                i19 = i13;
                i20 = i26;
                break;
              }
              if (bool1)
              {
                localSparseBooleanArray.put(i18, false);
                int i23 = i9;
                int i24 = 0;
                for (;;)
                {
                  if (i24 < i12)
                  {
                    MenuItemImpl localMenuItemImpl2 = (MenuItemImpl)localArrayList.get(i24);
                    if (localMenuItemImpl2.getGroupId() == i18)
                    {
                      if (localMenuItemImpl2.i()) {
                        i23++;
                      }
                      localMenuItemImpl2.d(false);
                    }
                    i24++;
                    continue;
                    localMenuItemImpl1.d(false);
                    i15 = i13;
                    i16 = i3;
                    i17 = i9;
                    break;
                    return true;
                  }
                }
                i21 = i23;
              }
              else
              {
                i21 = i9;
              }
            }
            i27 = bool2;
            break label496;
            bool3 = bool2;
            i19 = i13;
            i20 = i14;
          }
          i15 = i13;
        }
        i10 = 0;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public boolean c()
  {
    if ((this.j) && (!g()) && (this.c != null) && (this.f != null) && (this.x == null) && (!this.c.l().isEmpty()))
    {
      this.x = new ActionMenuPresenter.OpenOverflowRunnable(this, new ActionMenuPresenter.OverflowPopup(this, this.b, this.c, this.i, true));
      ((View)this.f).post(this.x);
      super.a(null);
      return true;
    }
    return false;
  }
  
  public boolean d()
  {
    if ((this.x != null) && (this.f != null))
    {
      ((View)this.f).removeCallbacks(this.x);
      this.x = null;
      return true;
    }
    ActionMenuPresenter.OverflowPopup localOverflowPopup = this.v;
    if (localOverflowPopup != null)
    {
      localOverflowPopup.e();
      return true;
    }
    return false;
  }
  
  public boolean e()
  {
    return d() | f();
  }
  
  public boolean f()
  {
    if (this.w != null)
    {
      this.w.e();
      return true;
    }
    return false;
  }
  
  public boolean g()
  {
    return (this.v != null) && (this.v.f());
  }
  
  public boolean h()
  {
    return (this.x != null) || (g());
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(null);
      return;
    }
    this.c.a(false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */