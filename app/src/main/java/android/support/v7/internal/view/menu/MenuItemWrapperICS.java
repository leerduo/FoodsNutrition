package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
public class MenuItemWrapperICS
  extends BaseMenuWrapper<SupportMenuItem>
  implements MenuItem
{
  private Method c;
  
  MenuItemWrapperICS(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }
  
  MenuItemWrapperICS.ActionProviderWrapper a(android.view.ActionProvider paramActionProvider)
  {
    return new MenuItemWrapperICS.ActionProviderWrapper(this, this.a, paramActionProvider);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.c == null)
      {
        Class localClass = ((SupportMenuItem)this.b).getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        this.c = localClass.getDeclaredMethod("setExclusiveCheckable", arrayOfClass);
      }
      Method localMethod = this.c;
      Object localObject = this.b;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(localObject, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public boolean collapseActionView()
  {
    return ((SupportMenuItem)this.b).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((SupportMenuItem)this.b).expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    android.support.v4.view.ActionProvider localActionProvider = ((SupportMenuItem)this.b).getSupportActionProvider();
    if ((localActionProvider instanceof MenuItemWrapperICS.ActionProviderWrapper)) {
      return ((MenuItemWrapperICS.ActionProviderWrapper)localActionProvider).a;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView = ((SupportMenuItem)this.b).getActionView();
    if ((localView instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper)) {
      localView = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)localView).c();
    }
    return localView;
  }
  
  public char getAlphabeticShortcut()
  {
    return ((SupportMenuItem)this.b).getAlphabeticShortcut();
  }
  
  public int getGroupId()
  {
    return ((SupportMenuItem)this.b).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((SupportMenuItem)this.b).getIcon();
  }
  
  public Intent getIntent()
  {
    return ((SupportMenuItem)this.b).getIntent();
  }
  
  public int getItemId()
  {
    return ((SupportMenuItem)this.b).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((SupportMenuItem)this.b).getMenuInfo();
  }
  
  public char getNumericShortcut()
  {
    return ((SupportMenuItem)this.b).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((SupportMenuItem)this.b).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((SupportMenuItem)this.b).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((SupportMenuItem)this.b).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((SupportMenuItem)this.b).getTitleCondensed();
  }
  
  public boolean hasSubMenu()
  {
    return ((SupportMenuItem)this.b).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((SupportMenuItem)this.b).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((SupportMenuItem)this.b).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((SupportMenuItem)this.b).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((SupportMenuItem)this.b).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((SupportMenuItem)this.b).isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.b;
    if (paramActionProvider != null) {}
    for (MenuItemWrapperICS.ActionProviderWrapper localActionProviderWrapper = a(paramActionProvider);; localActionProviderWrapper = null)
    {
      localSupportMenuItem.setSupportActionProvider(localActionProviderWrapper);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((SupportMenuItem)this.b).setActionView(paramInt);
    View localView = ((SupportMenuItem)this.b).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((SupportMenuItem)this.b).setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    if ((paramView instanceof CollapsibleActionView)) {
      paramView = new MenuItemWrapperICS.CollapsibleActionViewWrapper(paramView);
    }
    ((SupportMenuItem)this.b).setActionView(paramView);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((SupportMenuItem)this.b).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((SupportMenuItem)this.b).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((SupportMenuItem)this.b).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((SupportMenuItem)this.b).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((SupportMenuItem)this.b).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((SupportMenuItem)this.b).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((SupportMenuItem)this.b).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((SupportMenuItem)this.b).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.b;
    if (paramOnActionExpandListener != null) {}
    for (MenuItemWrapperICS.OnActionExpandListenerWrapper localOnActionExpandListenerWrapper = new MenuItemWrapperICS.OnActionExpandListenerWrapper(this, paramOnActionExpandListener);; localOnActionExpandListenerWrapper = null)
    {
      localSupportMenuItem.setSupportOnActionExpandListener(localOnActionExpandListenerWrapper);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.b;
    if (paramOnMenuItemClickListener != null) {}
    for (MenuItemWrapperICS.OnMenuItemClickListenerWrapper localOnMenuItemClickListenerWrapper = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(this, paramOnMenuItemClickListener);; localOnMenuItemClickListenerWrapper = null)
    {
      localSupportMenuItem.setOnMenuItemClickListener(localOnMenuItemClickListenerWrapper);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((SupportMenuItem)this.b).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((SupportMenuItem)this.b).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((SupportMenuItem)this.b).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((SupportMenuItem)this.b).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.b).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.b).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((SupportMenuItem)this.b).setVisible(paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */