package android.support.v7.internal.view.menu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;

public class MenuDialogHelper
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback
{
  ListMenuPresenter a;
  private MenuBuilder b;
  private AlertDialog c;
  private MenuPresenter.Callback d;
  
  public MenuDialogHelper(MenuBuilder paramMenuBuilder)
  {
    this.b = paramMenuBuilder;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
  }
  
  public void a(IBinder paramIBinder)
  {
    MenuBuilder localMenuBuilder = this.b;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localMenuBuilder.e());
    this.a = new ListMenuPresenter(R.layout.abc_list_menu_item_layout, R.style.Theme_AppCompat_CompactMenu);
    this.a.a(this);
    this.b.a(this.a);
    localBuilder.setAdapter(this.a.a(), this);
    View localView = localMenuBuilder.o();
    if (localView != null) {
      localBuilder.setCustomTitle(localView);
    }
    for (;;)
    {
      localBuilder.setOnKeyListener(this);
      this.c = localBuilder.create();
      this.c.setOnDismissListener(this);
      WindowManager.LayoutParams localLayoutParams = this.c.getWindow().getAttributes();
      localLayoutParams.type = 1003;
      if (paramIBinder != null) {
        localLayoutParams.token = paramIBinder;
      }
      localLayoutParams.flags = (0x20000 | localLayoutParams.flags);
      this.c.show();
      return;
      localBuilder.setIcon(localMenuBuilder.n()).setTitle(localMenuBuilder.m());
    }
  }
  
  public void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramMenuBuilder == this.b)) {
      a();
    }
    if (this.d != null) {
      this.d.a(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean a(MenuBuilder paramMenuBuilder)
  {
    if (this.d != null) {
      return this.d.a(paramMenuBuilder);
    }
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.a((MenuItemImpl)this.a.a().getItem(paramInt), 0);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(this.b, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        Window localWindow2 = this.c.getWindow();
        if (localWindow2 != null)
        {
          View localView2 = localWindow2.getDecorView();
          if (localView2 != null)
          {
            KeyEvent.DispatcherState localDispatcherState2 = localView2.getKeyDispatcherState();
            if (localDispatcherState2 != null)
            {
              localDispatcherState2.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Window localWindow1 = this.c.getWindow();
        if (localWindow1 != null)
        {
          View localView1 = localWindow1.getDecorView();
          if (localView1 != null)
          {
            KeyEvent.DispatcherState localDispatcherState1 = localView1.getKeyDispatcherState();
            if ((localDispatcherState1 != null) && (localDispatcherState1.isTracking(paramKeyEvent)))
            {
              this.b.a(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.b.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuDialogHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */