package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class MenuPopupHelper$MenuAdapter
  extends BaseAdapter
{
  private MenuBuilder b;
  private int c = -1;
  
  public MenuPopupHelper$MenuAdapter(MenuPopupHelper paramMenuPopupHelper, MenuBuilder paramMenuBuilder)
  {
    this.b = paramMenuBuilder;
    a();
  }
  
  public MenuItemImpl a(int paramInt)
  {
    if (MenuPopupHelper.a(this.a)) {}
    for (ArrayList localArrayList = this.b.l();; localArrayList = this.b.i())
    {
      if ((this.c >= 0) && (paramInt >= this.c)) {
        paramInt++;
      }
      return (MenuItemImpl)localArrayList.get(paramInt);
    }
  }
  
  void a()
  {
    MenuItemImpl localMenuItemImpl = MenuPopupHelper.c(this.a).r();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = MenuPopupHelper.c(this.a).l();
      int i = localArrayList.size();
      for (int j = 0; j < i; j++) {
        if ((MenuItemImpl)localArrayList.get(j) == localMenuItemImpl)
        {
          this.c = j;
          return;
        }
      }
    }
    this.c = -1;
  }
  
  public int getCount()
  {
    if (MenuPopupHelper.a(this.a)) {}
    for (ArrayList localArrayList = this.b.l(); this.c < 0; localArrayList = this.b.i()) {
      return localArrayList.size();
    }
    return -1 + localArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (View localView = MenuPopupHelper.b(this.a).inflate(MenuPopupHelper.a, paramViewGroup, false);; localView = paramView)
    {
      MenuView.ItemView localItemView = (MenuView.ItemView)localView;
      if (this.a.b) {
        ((ListMenuItemView)localView).setForceShowIcon(true);
      }
      localItemView.a(a(paramInt), 0);
      return localView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuPopupHelper.MenuAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */