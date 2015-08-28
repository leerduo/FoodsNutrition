package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

class ActionBarActivityDelegateBase$ActionModeCallbackWrapper
  implements ActionMode.Callback
{
  private ActionMode.Callback b;
  
  public ActionBarActivityDelegateBase$ActionModeCallbackWrapper(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase, ActionMode.Callback paramCallback)
  {
    this.b = paramCallback;
  }
  
  public void a(ActionMode paramActionMode)
  {
    this.b.a(paramActionMode);
    if (this.a.i != null)
    {
      this.a.a.getWindow().getDecorView().removeCallbacks(this.a.j);
      this.a.i.dismiss();
    }
    for (;;)
    {
      if (this.a.h != null) {
        this.a.h.removeAllViews();
      }
      if (this.a.a != null) {}
      try
      {
        this.a.a.b(this.a.g);
        label101:
        this.a.g = null;
        return;
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        break label101;
      }
      if (this.a.h != null)
      {
        this.a.h.setVisibility(8);
        if (this.a.h.getParent() != null) {
          ViewCompat.requestApplyInsets((View)this.a.h.getParent());
        }
      }
    }
  }
  
  public boolean a(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.b.a(paramActionMode, paramMenu);
  }
  
  public boolean a(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.b.a(paramActionMode, paramMenuItem);
  }
  
  public boolean b(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.b.b(paramActionMode, paramMenu);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.ActionModeCallbackWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */