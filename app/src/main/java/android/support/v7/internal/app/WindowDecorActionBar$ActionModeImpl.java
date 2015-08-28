package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class WindowDecorActionBar$ActionModeImpl
  extends ActionMode
  implements MenuBuilder.Callback
{
  private ActionMode.Callback b;
  private MenuBuilder c;
  private WeakReference<View> d;
  
  public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar paramWindowDecorActionBar, ActionMode.Callback paramCallback)
  {
    this.b = paramCallback;
    this.c = new MenuBuilder(paramWindowDecorActionBar.b()).a(1);
    this.c.a(this);
  }
  
  public MenuInflater a()
  {
    return new SupportMenuInflater(this.a.b());
  }
  
  public void a(int paramInt)
  {
    b(WindowDecorActionBar.k(this.a).getResources().getString(paramInt));
  }
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    if (this.b == null) {
      return;
    }
    d();
    WindowDecorActionBar.i(this.a).a();
  }
  
  public void a(View paramView)
  {
    WindowDecorActionBar.i(this.a).setCustomView(paramView);
    this.d = new WeakReference(paramView);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    WindowDecorActionBar.i(this.a).setSubtitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    WindowDecorActionBar.i(this.a).setTitleOptional(paramBoolean);
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if (this.b != null) {
      return this.b.a(this, paramMenuItem);
    }
    return false;
  }
  
  public Menu b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    a(WindowDecorActionBar.k(this.a).getResources().getString(paramInt));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    WindowDecorActionBar.i(this.a).setTitle(paramCharSequence);
  }
  
  public void c()
  {
    if (this.a.a != this) {
      return;
    }
    if (!WindowDecorActionBar.a(WindowDecorActionBar.g(this.a), WindowDecorActionBar.h(this.a), false))
    {
      this.a.b = this;
      this.a.c = this.b;
    }
    for (;;)
    {
      this.b = null;
      this.a.j(false);
      WindowDecorActionBar.i(this.a).b();
      WindowDecorActionBar.j(this.a).a().sendAccessibilityEvent(32);
      WindowDecorActionBar.f(this.a).setHideOnContentScrollEnabled(this.a.d);
      this.a.a = null;
      return;
      this.b.a(this);
    }
  }
  
  public void d()
  {
    this.c.g();
    try
    {
      this.b.b(this, this.c);
      return;
    }
    finally
    {
      this.c.h();
    }
  }
  
  public boolean e()
  {
    this.c.g();
    try
    {
      boolean bool = this.b.a(this, this.c);
      return bool;
    }
    finally
    {
      this.c.h();
    }
  }
  
  public CharSequence f()
  {
    return WindowDecorActionBar.i(this.a).getTitle();
  }
  
  public CharSequence g()
  {
    return WindowDecorActionBar.i(this.a).getSubtitle();
  }
  
  public boolean h()
  {
    return WindowDecorActionBar.i(this.a).d();
  }
  
  public View i()
  {
    if (this.d != null) {
      return (View)this.d.get();
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowDecorActionBar.ActionModeImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */