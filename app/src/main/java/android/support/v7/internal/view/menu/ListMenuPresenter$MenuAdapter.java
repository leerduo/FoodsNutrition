package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class ListMenuPresenter$MenuAdapter
  extends BaseAdapter
{
  private int b = -1;
  
  public ListMenuPresenter$MenuAdapter(ListMenuPresenter paramListMenuPresenter)
  {
    a();
  }
  
  public MenuItemImpl a(int paramInt)
  {
    ArrayList localArrayList = this.a.c.l();
    int i = paramInt + ListMenuPresenter.a(this.a);
    if ((this.b >= 0) && (i >= this.b)) {
      i++;
    }
    return (MenuItemImpl)localArrayList.get(i);
  }
  
  void a()
  {
    MenuItemImpl localMenuItemImpl = this.a.c.r();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = this.a.c.l();
      int i = localArrayList.size();
      for (int j = 0; j < i; j++) {
        if ((MenuItemImpl)localArrayList.get(j) == localMenuItemImpl)
        {
          this.b = j;
          return;
        }
      }
    }
    this.b = -1;
  }
  
  public int getCount()
  {
    int i = this.a.c.l().size() - ListMenuPresenter.a(this.a);
    if (this.b < 0) {
      return i;
    }
    return i - 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (View localView = this.a.b.inflate(this.a.f, paramViewGroup, false);; localView = paramView)
    {
      ((MenuView.ItemView)localView).a(a(paramInt), 0);
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
 * Qualified Name:     android.support.v7.internal.view.menu.ListMenuPresenter.MenuAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */