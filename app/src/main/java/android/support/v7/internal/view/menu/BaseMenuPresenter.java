package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter
  implements MenuPresenter
{
  protected Context a;
  protected Context b;
  protected MenuBuilder c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  protected MenuView f;
  private MenuPresenter.Callback g;
  private int h;
  private int i;
  private int j;
  
  public BaseMenuPresenter(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public MenuPresenter.Callback a()
  {
    return this.g;
  }
  
  public MenuView a(ViewGroup paramViewGroup)
  {
    if (this.f == null)
    {
      this.f = ((MenuView)this.d.inflate(this.h, paramViewGroup, false));
      this.f.a(this.c);
      a(true);
    }
    return this.f;
  }
  
  public View a(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof MenuView.ItemView)) {}
    for (MenuView.ItemView localItemView = (MenuView.ItemView)paramView;; localItemView = b(paramViewGroup))
    {
      a(paramMenuItemImpl, localItemView);
      return (View)localItemView;
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramMenuBuilder;
  }
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.a(paramMenuBuilder, paramBoolean);
    }
  }
  
  public abstract void a(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public void a(MenuPresenter.Callback paramCallback)
  {
    this.g = paramCallback;
  }
  
  protected void a(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.f).addView(paramView, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.f;
    if (localViewGroup == null) {}
    label190:
    label199:
    for (;;)
    {
      return;
      int k;
      int i1;
      if (this.c != null)
      {
        this.c.j();
        ArrayList localArrayList = this.c.i();
        int m = localArrayList.size();
        int n = 0;
        k = 0;
        if (n < m)
        {
          MenuItemImpl localMenuItemImpl1 = (MenuItemImpl)localArrayList.get(n);
          if (!a(k, localMenuItemImpl1)) {
            break label190;
          }
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof MenuView.ItemView)) {}
          for (MenuItemImpl localMenuItemImpl2 = ((MenuView.ItemView)localView1).getItemData();; localMenuItemImpl2 = null)
          {
            View localView2 = a(localMenuItemImpl1, localView1, localViewGroup);
            if (localMenuItemImpl1 != localMenuItemImpl2)
            {
              localView2.setPressed(false);
              ViewCompat.jumpDrawablesToCurrentState(localView2);
            }
            if (localView2 != localView1) {
              a(localView2, k);
            }
            i1 = k + 1;
            n++;
            k = i1;
            break;
          }
        }
      }
      for (;;)
      {
        if (k >= localViewGroup.getChildCount()) {
          break label199;
        }
        if (!a(localViewGroup, k))
        {
          k++;
          continue;
          i1 = k;
          break;
          k = 0;
        }
      }
    }
  }
  
  public boolean a(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return true;
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean a(SubMenuBuilder paramSubMenuBuilder)
  {
    if (this.g != null) {
      return this.g.a(paramSubMenuBuilder);
    }
    return false;
  }
  
  protected boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public MenuView.ItemView b(ViewGroup paramViewGroup)
  {
    return (MenuView.ItemView)this.d.inflate(this.i, paramViewGroup, false);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.BaseMenuPresenter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */