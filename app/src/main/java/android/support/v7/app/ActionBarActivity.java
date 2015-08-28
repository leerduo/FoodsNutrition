package android.support.v7.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle.Delegate;
import android.support.v4.app.ActionBarDrawerToggle.DelegateProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ActionBarActivity
  extends FragmentActivity
  implements ActionBarDrawerToggle.DelegateProvider, TaskStackBuilder.SupportParentable
{
  private ActionBarActivityDelegate a;
  
  private ActionBarActivityDelegate d()
  {
    if (this.a == null) {
      this.a = ActionBarActivityDelegate.a(this);
    }
    return this.a;
  }
  
  public ActionBar a()
  {
    return d().b();
  }
  
  public void a(TaskStackBuilder paramTaskStackBuilder)
  {
    paramTaskStackBuilder.addParentStack(this);
  }
  
  public void a(ActionMode paramActionMode) {}
  
  void a(View paramView)
  {
    super.setContentView(paramView);
  }
  
  boolean a(int paramInt, Menu paramMenu)
  {
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  boolean a(int paramInt, View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public boolean a(Intent paramIntent)
  {
    return NavUtils.shouldUpRecreateTask(this, paramIntent);
  }
  
  boolean a(View paramView, Menu paramMenu)
  {
    return super.onPrepareOptionsPanel(paramView, paramMenu);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    d().b(paramView, paramLayoutParams);
  }
  
  void b(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  public void b(Intent paramIntent)
  {
    NavUtils.navigateUpTo(this, paramIntent);
  }
  
  public void b(TaskStackBuilder paramTaskStackBuilder) {}
  
  public void b(ActionMode paramActionMode) {}
  
  public boolean b()
  {
    Intent localIntent = getSupportParentActivityIntent();
    if (localIntent != null)
    {
      if (a(localIntent))
      {
        TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(this);
        a(localTaskStackBuilder);
        b(localTaskStackBuilder);
        localTaskStackBuilder.startActivities();
      }
      for (;;)
      {
        try
        {
          ActivityCompat.finishAffinity(this);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        b(localIntent);
      }
    }
    return false;
  }
  
  public void c() {}
  
  boolean c(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return d().i();
  }
  
  public MenuInflater getMenuInflater()
  {
    return d().d();
  }
  
  public Intent getSupportParentActivityIntent()
  {
    return NavUtils.getParentActivityIntent(this);
  }
  
  public void invalidateOptionsMenu()
  {
    d().g();
  }
  
  public void onBackPressed()
  {
    if (!d().h()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    d().a(paramConfiguration);
  }
  
  public final void onContentChanged()
  {
    d().k();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d().a(paramBundle);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return d().c(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0) {
      return d().b(paramInt);
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = super.onCreateView(paramString, paramContext, paramAttributeSet);
    if (localView != null) {
      return localView;
    }
    return d().a(paramString, paramContext, paramAttributeSet);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d().n();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (super.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return d().a(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return d().b(paramInt, paramKeyEvent);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = a();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((0x4 & localActionBar.a()) != 0)) {
      return b();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return d().b(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    d().a(paramInt, paramMenu);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    d().f();
  }
  
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return d().a(paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return d().a(paramInt, paramView, paramMenu);
  }
  
  protected void onStop()
  {
    super.onStop();
    d().e();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    d().a(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    d().a(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    d().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    d().a(paramView, paramLayoutParams);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    d().g();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */