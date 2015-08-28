package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class MenuPopupHelper
  implements MenuPresenter, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int a = R.layout.abc_popup_menu_item_layout;
  boolean b;
  private final Context c;
  private final LayoutInflater d;
  private final MenuBuilder e;
  private final MenuPopupHelper.MenuAdapter f;
  private final boolean g;
  private final int h;
  private final int i;
  private final int j;
  private View k;
  private ListPopupWindow l;
  private ViewTreeObserver m;
  private MenuPresenter.Callback n;
  private ViewGroup o;
  private boolean p;
  private int q;
  private int r = 0;
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
  {
    this(paramContext, paramMenuBuilder, paramView, false, R.attr.popupMenuStyle);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramMenuBuilder, paramView, paramBoolean, paramInt, 0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.e = paramMenuBuilder;
    this.f = new MenuPopupHelper.MenuAdapter(this, this.e);
    this.g = paramBoolean;
    this.i = paramInt1;
    this.j = paramInt2;
    Resources localResources = paramContext.getResources();
    this.h = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.k = paramView;
    paramMenuBuilder.a(this, paramContext);
  }
  
  private int g()
  {
    MenuPopupHelper.MenuAdapter localMenuAdapter = this.f;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i3 = localMenuAdapter.getCount();
    int i4 = 0;
    int i5 = 0;
    View localView1 = null;
    int i6 = 0;
    View localView2;
    label68:
    int i8;
    if (i4 < i3)
    {
      int i7 = localMenuAdapter.getItemViewType(i4);
      if (i7 == i5) {
        break label155;
      }
      i5 = i7;
      localView2 = null;
      if (this.o == null) {
        this.o = new FrameLayout(this.c);
      }
      localView1 = localMenuAdapter.getView(i4, localView2, this.o);
      localView1.measure(i1, i2);
      i8 = localView1.getMeasuredWidth();
      if (i8 >= this.h) {
        i6 = this.h;
      }
    }
    else
    {
      return i6;
    }
    if (i8 > i6) {}
    for (;;)
    {
      i4++;
      i6 = i8;
      break;
      label155:
      localView2 = localView1;
      break label68;
      i8 = i6;
    }
  }
  
  public void a()
  {
    if (!d()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder != this.e) {}
    do
    {
      return;
      e();
    } while (this.n == null);
    this.n.a(paramMenuBuilder, paramBoolean);
  }
  
  public void a(MenuPresenter.Callback paramCallback)
  {
    this.n = paramCallback;
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = false;
    if (this.f != null) {
      this.f.notifyDataSetChanged();
    }
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean a(SubMenuBuilder paramSubMenuBuilder)
  {
    MenuPopupHelper localMenuPopupHelper;
    int i2;
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      localMenuPopupHelper = new MenuPopupHelper(this.c, paramSubMenuBuilder, this.k);
      localMenuPopupHelper.a(this.n);
      int i1 = paramSubMenuBuilder.size();
      i2 = 0;
      if (i2 >= i1) {
        break label118;
      }
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(i2);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label118:
    for (boolean bool = true;; bool = false)
    {
      localMenuPopupHelper.b(bool);
      if (localMenuPopupHelper.d())
      {
        if (this.n != null) {
          this.n.a(paramSubMenuBuilder);
        }
        return true;
        i2++;
        break;
      }
      return false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public ListPopupWindow c()
  {
    return this.l;
  }
  
  public boolean d()
  {
    this.l = new ListPopupWindow(this.c, null, this.i, this.j);
    this.l.a(this);
    this.l.a(this);
    this.l.a(this.f);
    this.l.a(true);
    View localView = this.k;
    if (localView != null)
    {
      ViewTreeObserver localViewTreeObserver = this.m;
      int i1 = 0;
      if (localViewTreeObserver == null) {
        i1 = 1;
      }
      this.m = localView.getViewTreeObserver();
      if (i1 != 0) {
        this.m.addOnGlobalLayoutListener(this);
      }
      this.l.a(localView);
      this.l.b(this.r);
      if (!this.p)
      {
        this.q = g();
        this.p = true;
      }
      this.l.d(this.q);
      this.l.e(2);
      this.l.c();
      this.l.g().setOnKeyListener(this);
      return true;
    }
    return false;
  }
  
  public void e()
  {
    if (f()) {
      this.l.a();
    }
  }
  
  public boolean f()
  {
    return (this.l != null) && (this.l.b());
  }
  
  public void onDismiss()
  {
    this.l = null;
    this.e.close();
    if (this.m != null)
    {
      if (!this.m.isAlive()) {
        this.m = this.k.getViewTreeObserver();
      }
      this.m.removeGlobalOnLayoutListener(this);
      this.m = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (f())
    {
      View localView = this.k;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      e();
    }
    label28:
    while (!f()) {
      return;
    }
    this.l.c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    MenuPopupHelper.MenuAdapter localMenuAdapter = this.f;
    MenuPopupHelper.MenuAdapter.a(localMenuAdapter).a(localMenuAdapter.a(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      e();
      return true;
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuPopupHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */