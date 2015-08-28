package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

final class ActionBarActivityDelegateBase$PanelFeatureState
{
  int a;
  ViewGroup b;
  View c;
  MenuBuilder d;
  ListMenuPresenter e;
  Context f;
  boolean g;
  boolean h;
  boolean i;
  public boolean j;
  boolean k;
  boolean l;
  Bundle m;
  
  ActionBarActivityDelegateBase$PanelFeatureState(int paramInt)
  {
    this.a = paramInt;
    this.k = false;
  }
  
  MenuView a(MenuPresenter.Callback paramCallback)
  {
    if (this.d == null) {
      return null;
    }
    if (this.e == null)
    {
      this.e = new ListMenuPresenter(this.f, R.layout.abc_list_menu_item_layout);
      this.e.a(paramCallback);
      this.d.a(this.e);
    }
    return this.e.a(this.b);
  }
  
  void a(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    Resources.Theme localTheme = paramContext.getResources().newTheme();
    localTheme.setTo(paramContext.getTheme());
    localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    for (;;)
    {
      ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper(paramContext, 0);
      localContextThemeWrapper.getTheme().setTo(localTheme);
      this.f = localContextThemeWrapper;
      return;
      localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
    }
  }
  
  void a(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder == this.d) {}
    do
    {
      return;
      if (this.d != null) {
        this.d.b(this.e);
      }
      this.d = paramMenuBuilder;
    } while ((paramMenuBuilder == null) || (this.e == null));
    paramMenuBuilder.a(this.e);
  }
  
  public boolean a()
  {
    if (this.c == null) {}
    while (this.e.a().getCount() <= 0) {
      return false;
    }
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */