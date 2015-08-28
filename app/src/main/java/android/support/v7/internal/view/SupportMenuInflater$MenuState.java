package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class SupportMenuInflater$MenuState
{
  private Menu b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private int j;
  private int k;
  private CharSequence l;
  private CharSequence m;
  private int n;
  private char o;
  private char p;
  private int q;
  private boolean r;
  private boolean s;
  private boolean t;
  private int u;
  private int v;
  private String w;
  private String x;
  private String y;
  private ActionProvider z;
  
  public SupportMenuInflater$MenuState(SupportMenuInflater paramSupportMenuInflater, Menu paramMenu)
  {
    this.b = paramMenu;
    a();
  }
  
  private char a(String paramString)
  {
    if (paramString == null) {
      return '\000';
    }
    return paramString.charAt(0);
  }
  
  private <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = SupportMenuInflater.a(this.a).getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, localException);
    }
    return null;
  }
  
  private void a(MenuItem paramMenuItem)
  {
    int i1 = 1;
    MenuItem localMenuItem = paramMenuItem.setChecked(this.r).setVisible(this.s).setEnabled(this.t);
    if (this.q >= i1) {}
    int i4;
    for (int i3 = i1;; i4 = 0)
    {
      localMenuItem.setCheckable(i3).setTitleCondensed(this.m).setIcon(this.n).setAlphabeticShortcut(this.o).setNumericShortcut(this.p);
      if (this.u >= 0) {
        MenuItemCompat.setShowAsAction(paramMenuItem, this.u);
      }
      if (this.y == null) {
        break label163;
      }
      if (!SupportMenuInflater.a(this.a).isRestricted()) {
        break;
      }
      throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
    }
    paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.c(this.a), this.y));
    label163:
    if ((paramMenuItem instanceof MenuItemImpl)) {
      ((MenuItemImpl)paramMenuItem);
    }
    if (this.q >= 2)
    {
      if ((paramMenuItem instanceof MenuItemImpl)) {
        ((MenuItemImpl)paramMenuItem).a(i1);
      }
    }
    else
    {
      if (this.w == null) {
        break label297;
      }
      MenuItemCompat.setActionView(paramMenuItem, (View)a(this.w, SupportMenuInflater.b(), SupportMenuInflater.d(this.a)));
    }
    for (;;)
    {
      if (this.v > 0)
      {
        if (i1 != 0) {
          break label286;
        }
        MenuItemCompat.setActionView(paramMenuItem, this.v);
      }
      for (;;)
      {
        if (this.z != null) {
          MenuItemCompat.setActionProvider(paramMenuItem, this.z);
        }
        return;
        if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
          break;
        }
        ((MenuItemWrapperICS)paramMenuItem).a(i1);
        break;
        label286:
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
      label297:
      int i2 = 0;
    }
  }
  
  public void a()
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = true;
    this.h = true;
  }
  
  public void a(AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = SupportMenuInflater.a(this.a).obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
    this.c = localTypedArray.getResourceId(R.styleable.MenuGroup_android_id, 0);
    this.d = localTypedArray.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
    this.e = localTypedArray.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
    this.f = localTypedArray.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
    this.g = localTypedArray.getBoolean(R.styleable.MenuGroup_android_visible, true);
    this.h = localTypedArray.getBoolean(R.styleable.MenuGroup_android_enabled, true);
    localTypedArray.recycle();
  }
  
  public void b()
  {
    this.i = true;
    a(this.b.add(this.c, this.j, this.k, this.l));
  }
  
  public void b(AttributeSet paramAttributeSet)
  {
    int i1 = 1;
    TypedArray localTypedArray = SupportMenuInflater.a(this.a).obtainStyledAttributes(paramAttributeSet, R.styleable.MenuItem);
    this.j = localTypedArray.getResourceId(R.styleable.MenuItem_android_id, 0);
    int i2 = localTypedArray.getInt(R.styleable.MenuItem_android_menuCategory, this.d);
    int i3 = localTypedArray.getInt(R.styleable.MenuItem_android_orderInCategory, this.e);
    this.k = (i2 & 0xFFFF0000 | i3 & 0xFFFF);
    this.l = localTypedArray.getText(R.styleable.MenuItem_android_title);
    this.m = localTypedArray.getText(R.styleable.MenuItem_android_titleCondensed);
    this.n = localTypedArray.getResourceId(R.styleable.MenuItem_android_icon, 0);
    this.o = a(localTypedArray.getString(R.styleable.MenuItem_android_alphabeticShortcut));
    this.p = a(localTypedArray.getString(R.styleable.MenuItem_android_numericShortcut));
    int i4;
    if (localTypedArray.hasValue(R.styleable.MenuItem_android_checkable)) {
      if (localTypedArray.getBoolean(R.styleable.MenuItem_android_checkable, false))
      {
        i4 = i1;
        this.q = i4;
        label166:
        this.r = localTypedArray.getBoolean(R.styleable.MenuItem_android_checked, false);
        this.s = localTypedArray.getBoolean(R.styleable.MenuItem_android_visible, this.g);
        this.t = localTypedArray.getBoolean(R.styleable.MenuItem_android_enabled, this.h);
        this.u = localTypedArray.getInt(R.styleable.MenuItem_showAsAction, -1);
        this.y = localTypedArray.getString(R.styleable.MenuItem_android_onClick);
        this.v = localTypedArray.getResourceId(R.styleable.MenuItem_actionLayout, 0);
        this.w = localTypedArray.getString(R.styleable.MenuItem_actionViewClass);
        this.x = localTypedArray.getString(R.styleable.MenuItem_actionProviderClass);
        if (this.x == null) {
          break label342;
        }
        label272:
        if ((i1 == 0) || (this.v != 0) || (this.w != null)) {
          break label347;
        }
      }
    }
    for (this.z = ((ActionProvider)a(this.x, SupportMenuInflater.a(), SupportMenuInflater.b(this.a)));; this.z = null)
    {
      localTypedArray.recycle();
      this.i = false;
      return;
      i4 = 0;
      break;
      this.q = this.f;
      break label166;
      label342:
      i1 = 0;
      break label272;
      label347:
      if (i1 != 0) {
        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
      }
    }
  }
  
  public SubMenu c()
  {
    this.i = true;
    SubMenu localSubMenu = this.b.addSubMenu(this.c, this.j, this.k, this.l);
    a(localSubMenu.getItem());
    return localSubMenu;
  }
  
  public boolean d()
  {
    return this.i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportMenuInflater.MenuState
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */