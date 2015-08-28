package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

abstract class ActionBarActivityDelegate
{
  final ActionBarActivity a;
  boolean b;
  boolean c;
  boolean d;
  boolean e;
  final WindowCallback f = new ActionBarActivityDelegate.1(this);
  private ActionBar g;
  private MenuInflater h;
  private WindowCallback i;
  private boolean j;
  
  ActionBarActivityDelegate(ActionBarActivity paramActionBarActivity)
  {
    this.a = paramActionBarActivity;
    this.i = this.f;
  }
  
  static ActionBarActivityDelegate a(ActionBarActivity paramActionBarActivity)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return new ActionBarActivityDelegateHC(paramActionBarActivity);
    }
    return new ActionBarActivityDelegateBase(paramActionBarActivity);
  }
  
  abstract ActionBar a();
  
  abstract ActionMode a(ActionMode.Callback paramCallback);
  
  abstract View a(String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  abstract void a(int paramInt);
  
  abstract void a(int paramInt, Menu paramMenu);
  
  abstract void a(Configuration paramConfiguration);
  
  void a(Bundle paramBundle)
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(R.styleable.Theme);
    if (!localTypedArray.hasValue(R.styleable.Theme_windowActionBar))
    {
      localTypedArray.recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (localTypedArray.getBoolean(R.styleable.Theme_windowActionBar, false)) {
      this.b = true;
    }
    if (localTypedArray.getBoolean(R.styleable.Theme_windowActionBarOverlay, false)) {
      this.c = true;
    }
    if (localTypedArray.getBoolean(R.styleable.Theme_windowActionModeOverlay, false)) {
      this.d = true;
    }
    this.e = localTypedArray.getBoolean(R.styleable.Theme_android_windowIsFloating, false);
    localTypedArray.recycle();
  }
  
  abstract void a(View paramView);
  
  abstract void a(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  abstract void a(CharSequence paramCharSequence);
  
  boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  abstract boolean a(int paramInt, View paramView, Menu paramMenu);
  
  boolean a(View paramView, Menu paramMenu)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return this.a.onPrepareOptionsMenu(paramMenu);
    }
    return this.a.a(paramView, paramMenu);
  }
  
  final ActionBar b()
  {
    if ((this.b) && (this.g == null)) {
      this.g = a();
    }
    return this.g;
  }
  
  abstract View b(int paramInt);
  
  abstract void b(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  abstract boolean b(int paramInt, KeyEvent paramKeyEvent);
  
  abstract boolean b(int paramInt, Menu paramMenu);
  
  final ActionBar c()
  {
    return this.g;
  }
  
  abstract boolean c(int paramInt, Menu paramMenu);
  
  MenuInflater d()
  {
    if (this.h == null) {
      this.h = new SupportMenuInflater(l());
    }
    return this.h;
  }
  
  abstract void e();
  
  abstract void f();
  
  abstract void g();
  
  abstract boolean h();
  
  final ActionBarDrawerToggle.Delegate i()
  {
    return new ActionBarActivityDelegate.ActionBarDrawableToggleImpl(this, null);
  }
  
  abstract int j();
  
  abstract void k();
  
  protected final Context l()
  {
    ActionBar localActionBar = b();
    Object localObject = null;
    if (localActionBar != null) {
      localObject = localActionBar.b();
    }
    if (localObject == null) {
      localObject = this.a;
    }
    return localObject;
  }
  
  final WindowCallback m()
  {
    return this.i;
  }
  
  final void n()
  {
    this.j = true;
  }
  
  final boolean o()
  {
    return this.j;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegate
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */