package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder
  extends MenuBuilder
  implements SubMenu
{
  private MenuBuilder d;
  private MenuItemImpl e;
  
  public SubMenuBuilder(Context paramContext, MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    super(paramContext);
    this.d = paramMenuBuilder;
    this.e = paramMenuItemImpl;
  }
  
  public String a()
  {
    if (this.e != null) {}
    for (int i = this.e.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.a() + ":" + i;
  }
  
  public void a(MenuBuilder.Callback paramCallback)
  {
    this.d.a(paramCallback);
  }
  
  boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (super.a(paramMenuBuilder, paramMenuItem)) || (this.d.a(paramMenuBuilder, paramMenuItem));
  }
  
  public boolean b()
  {
    return this.d.b();
  }
  
  public boolean c()
  {
    return this.d.c();
  }
  
  public boolean c(MenuItemImpl paramMenuItemImpl)
  {
    return this.d.c(paramMenuItemImpl);
  }
  
  public boolean d(MenuItemImpl paramMenuItemImpl)
  {
    return this.d.d(paramMenuItemImpl);
  }
  
  public MenuItem getItem()
  {
    return this.e;
  }
  
  public MenuBuilder p()
  {
    return this.d;
  }
  
  public Menu s()
  {
    return this.d;
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    super.a(ContextCompat.getDrawable(e(), paramInt));
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.a(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    super.a(e().getResources().getString(paramInt));
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    super.a(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.e.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.e.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.d.setQwertyMode(paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.SubMenuBuilder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */