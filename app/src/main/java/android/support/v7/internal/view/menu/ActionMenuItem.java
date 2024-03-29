package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class ActionMenuItem
  implements SupportMenuItem
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private CharSequence e;
  private CharSequence f;
  private Intent g;
  private char h;
  private char i;
  private Drawable j;
  private int k = 0;
  private Context l;
  private MenuItem.OnMenuItemClickListener m;
  private int n = 16;
  
  public ActionMenuItem(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence)
  {
    this.l = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramCharSequence;
  }
  
  public SupportMenuItem a(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem a(View paramView)
  {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem b(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public boolean expandActionView()
  {
    return false;
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public View getActionView()
  {
    return null;
  }
  
  public char getAlphabeticShortcut()
  {
    return this.i;
  }
  
  public int getGroupId()
  {
    return this.b;
  }
  
  public Drawable getIcon()
  {
    return this.j;
  }
  
  public Intent getIntent()
  {
    return this.g;
  }
  
  public int getItemId()
  {
    return this.a;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public char getNumericShortcut()
  {
    return this.h;
  }
  
  public int getOrder()
  {
    return this.d;
  }
  
  public SubMenu getSubMenu()
  {
    return null;
  }
  
  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return null;
  }
  
  public CharSequence getTitle()
  {
    return this.e;
  }
  
  public CharSequence getTitleCondensed()
  {
    if (this.f != null) {
      return this.f;
    }
    return this.e;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    return (0x1 & this.n) != 0;
  }
  
  public boolean isChecked()
  {
    return (0x2 & this.n) != 0;
  }
  
  public boolean isEnabled()
  {
    return (0x10 & this.n) != 0;
  }
  
  public boolean isVisible()
  {
    return (0x8 & this.n) == 0;
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.i = paramChar;
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int i1 = 0xFFFFFFFE & this.n;
    if (paramBoolean) {}
    for (int i2 = 1;; i2 = 0)
    {
      this.n = (i2 | i1);
      return this;
    }
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    int i1 = 0xFFFFFFFD & this.n;
    if (paramBoolean) {}
    for (int i2 = 2;; i2 = 0)
    {
      this.n = (i2 | i1);
      return this;
    }
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    int i1 = 0xFFFFFFEF & this.n;
    if (paramBoolean) {}
    for (int i2 = 16;; i2 = 0)
    {
      this.n = (i2 | i1);
      return this;
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.k = paramInt;
    this.j = ContextCompat.getDrawable(this.l, paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.j = paramDrawable;
    this.k = 0;
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.g = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    this.h = paramChar;
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.m = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.h = paramChar1;
    this.i = paramChar2;
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    this.e = this.l.getResources().getString(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    int i1 = 0x8 & this.n;
    if (paramBoolean) {}
    for (int i2 = 0;; i2 = 8)
    {
      this.n = (i2 | i1);
      return this;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuItem
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */