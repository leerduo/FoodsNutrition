package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class StandaloneActionMode
  extends ActionMode
  implements MenuBuilder.Callback
{
  private Context a;
  private ActionBarContextView b;
  private ActionMode.Callback c;
  private WeakReference<View> d;
  private boolean e;
  private boolean f;
  private MenuBuilder g;
  
  public StandaloneActionMode(Context paramContext, ActionBarContextView paramActionBarContextView, ActionMode.Callback paramCallback, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramActionBarContextView;
    this.c = paramCallback;
    this.g = new MenuBuilder(paramContext).a(1);
    this.g.a(this);
    this.f = paramBoolean;
  }
  
  public MenuInflater a()
  {
    return new MenuInflater(this.a);
  }
  
  public void a(int paramInt)
  {
    b(this.a.getString(paramInt));
  }
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    d();
    this.b.a();
  }
  
  public void a(View paramView)
  {
    this.b.setCustomView(paramView);
    if (paramView != null) {}
    for (WeakReference localWeakReference = new WeakReference(paramView);; localWeakReference = null)
    {
      this.d = localWeakReference;
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b.setSubtitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.b.setTitleOptional(paramBoolean);
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return this.c.a(this, paramMenuItem);
  }
  
  public Menu b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    a(this.a.getString(paramInt));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.b.setTitle(paramCharSequence);
  }
  
  public void c()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    this.b.sendAccessibilityEvent(32);
    this.c.a(this);
  }
  
  public void d()
  {
    this.c.b(this, this.g);
  }
  
  public CharSequence f()
  {
    return this.b.getTitle();
  }
  
  public CharSequence g()
  {
    return this.b.getSubtitle();
  }
  
  public boolean h()
  {
    return this.b.d();
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
 * Qualified Name:     android.support.v7.internal.view.StandaloneActionMode
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */